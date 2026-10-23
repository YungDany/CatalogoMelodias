package Control;
import Vista.CatalogoView;
import modelo.CatalogoMelodias;
import modelo.Melodia;

import java.util.ArrayList;

public class ControlCatalogo {
    private CatalogoMelodias modelo;
    private CatalogoView vista;

    public ControlCatalogo(CatalogoView vista, CatalogoMelodias modelo) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion = 0;
        while (opcion != 9) {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    vista.mostrarCadena("Registrar una nueva melodía");
                    int id = (int) (Math.random() * 9000) + 1000;
                    String nombre = vista.leerNombreMelodia();
                    String cantante = vista.leerCantante();
                    String compositor = vista.leerCompositor();
                    String genero = vista.leerGenero();
                    String formato = vista.mostrarObtenerFormato();
                    int anio = vista.leerAnioMelodia();
                    double precio = vista.leerPrecioMelodia();

                    Melodia nueva = new Melodia(id, nombre, compositor, anio, genero, cantante, precio, formato);
                    boolean exitoso = modelo.registrarMelodia(nueva);
                    if (exitoso) {
                        vista.mostrarCadena("Melodía registrada con éxito de ID: " + id + "!");
                    } else {
                        vista.mostrarCadena("Error: Ya hay una canción con el mismo cantante y año");

                    }
                    break;

                case 2:
                    vista.mostrarCadena("Catálogo completo");
                    vista.mostrarCatalogo(modelo.mostrarTodasMelodias());
                    break;

                case 3:
                    String busqueda = vista.leerNombreMelodia();
                    ArrayList<Melodia> encontradas = modelo.buscar(busqueda);
                    if (encontradas.isEmpty()) {
                        vista.mostrarCadena("No se encontraron melodías con ese nombre");
                    } else {
                        encontradas.forEach(m -> vista.mostrarCadena(m.toString()));
                    }
                    break;

                case 4:
                    int idEliminar = vista.leerId();
                    if (modelo.removerMelodia(idEliminar)) {
                        vista.mostrarCadena("Melodía eliminada con éxito");

                    } else {
                        vista.mostrarCadena("No se encontró una melodía con ese ID.");
                    }
                    break;

                case 5:
                    vista.mostrarCadena(String.format("El valor de la colleción es: %.2f", modelo.obtenerPrecioColeccion()));
                    break;

                case 6:
                    vista.mostrarCadena("Géneros en la colección: " + modelo.obtenerTodosLosGeneros());
                    break;

                case 7:
                    int anioBuscar = vista.leerAnioMelodia();
                    ArrayList<Melodia> porAnio = modelo.melodiasPorAnio(anioBuscar);
                    if (porAnio.isEmpty()) {
                        vista.mostrarCadena("No hay canciones de ese año.");
                    } else {
                        porAnio.forEach(m -> vista.mostrarCadena(m.toString()));
                    }
                    break;

                case 8:
                    vista.mostrarCadena("1. Ordenar por Precio | 2. Ordenar por Año | 3. Ordenar por Cantante");
                    int opcOrd = vista.leerAnioMelodia(); // Reutiliza la lectura de entero
                    if (opcOrd == 1) modelo.ordenarMelodiasPorPrecio();
                    else if (opcOrd == 2) modelo.ordenarMelodiasPorAnio();
                    else if (opcOrd == 3) modelo.ordenarMelodiasPorCantante();
                    vista.mostrarCadena("Catálogo ordenado correctamente.");
                    break;

                case 9:
                    vista.mostrarCadena("Gracias por su consulta. Tenga un excelente día");
                    break;

                default:
                    vista.mostrarCadena("Opción no válida.");
                    break;
            }
        }
    }
}
