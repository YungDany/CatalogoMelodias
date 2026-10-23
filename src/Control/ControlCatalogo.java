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
        int opcion=0;
        while (opcion!=14) {
            opcion=vista.mostrarMenu();
            switch(opcion) {
                case 1:
                    vista.mostrarCadena("\nRegistrar una nueva melodía");
                    int id = (int) (Math.random() * 9000) + 1000;
                    String nombre = vista.leerNombreMelodia();
                    String cantante = vista.leerCantante();
                    String compositor = vista.leerCompositor();
                    String genero = vista.leerGenero();
                    String formato = vista.mostrarObtenerFormato();
                    int anio = vista.leerAnioMelodia();
                    double precio = vista.leerPrecioMelodia();

                    Melodia nueva = new Melodia(id, nombre, compositor, anio, genero, cantante, precio, formato);
                    boolean exito = modelo.registrarMelodia(nueva);

                    if(exito) {
                        vista.mostrarCadena("Melodía registrada exitosamente con ID: " + id );
                    } else {
                        vista.mostrarCadena("Error: Ya hay una canción con el mismo cantante y año.");
                    }
                    break;

                case 2:
                    vista.mostrarCadena("\n Catálogo Completo ");
                    vista.mostrarCatalogo(modelo.mostrarTodasMelodias());
                    break;

                case 3:
                    String busqueda = vista.leerNombreMelodia();
                    ArrayList<Melodia> encontradas = modelo.buscar(busqueda);
                    if (encontradas.isEmpty()) {
                        vista.mostrarCadena("No se encontraron melodías con ese nombre.");
                    } else {
                        encontradas.forEach(m -> vista.mostrarCadena(m.toString()));
                    }
                    break;

                case 4:
                    int idEliminar = vista.leerId();
                    if (modelo.removerMelodia(idEliminar)) {
                        vista.mostrarCadena("Melodía eliminada con éxito.");
                    } else {
                        vista.mostrarCadena("No se encontró ninguna melodía con ese ID.");
                    }
                    break;

                case 5:
                    vista.mostrarCadena("\nCorregir / Actualizar Melodía");
                    int idAct = vista.leerId();
                    Melodia existente = modelo.buscar(idAct);

                    if (existente == null) {
                        vista.mostrarCadena("Error: No se encontró ninguna melodía con el ID " + idAct + " (o el catálogo está vacío).");
                    } else {
                        vista.mostrarCadena("Melodía encontrada: " + existente.toString());
                        vista.mostrarCadena("Ingrese los nuevos datos para corregir:");

                        String nuevoNombre = vista.leerNombreMelodia();
                        String nuevoCantante = vista.leerCantante();
                        String nuevoCompositor = vista.leerCompositor();
                        String nuevoGenero = vista.leerGenero();
                        String nuevoFormato = vista.mostrarObtenerFormato();
                        int nuevoAnio = vista.leerAnioMelodia();
                        double nuevoPrecio = vista.leerPrecioMelodia();

                        boolean actualizado = modelo.actualizarMelodia(
                                idAct, nuevoNombre, nuevoCompositor, nuevoAnio, nuevoGenero, nuevoCantante, nuevoPrecio, nuevoFormato
                        );

                        if (actualizado) {
                            vista.mostrarCadena("¡Datos actualizados con éxito!");
                        } else {
                            vista.mostrarCadena("No se pudo actualizar la melodía.");
                        }
                    }
                    break;

                case 6:
                    vista.mostrarCadena(String.format("El valor monetario total de la colección es: $%.2f", modelo.obtenerPrecioColeccion()));
                    break;

                case 7:
                    vista.mostrarCadena("Géneros en la colección: " + modelo.obtenerTodosLosGeneros());
                    break;

                case 8:
                    int anioBuscar = vista.leerAnioMelodia();
                    ArrayList<Melodia> porAnio = modelo.melodiasPorAnio(anioBuscar);
                    if (porAnio.isEmpty()) {
                        vista.mostrarCadena("No hay canciones registradas de ese año.");
                    } else {
                        porAnio.forEach(m -> vista.mostrarCadena(m.toString()));
                    }
                    break;

                case 9:
                    String cantanteBusq = vista.leerCantante();
                    ArrayList<Melodia> porCantante = modelo.melodiasPorCantante(cantanteBusq);
                    if (porCantante.isEmpty()) {
                        vista.mostrarCadena("No hay canciones registradas de ese cantante.");
                    } else {
                        porCantante.forEach(m -> vista.mostrarCadena(m.toString()));
                    }
                    break;

                case 10:
                    String compBusq = vista.leerCompositor();
                    ArrayList<Melodia> porComp = modelo.melodiasPorCompositor(compBusq);
                    if (porComp.isEmpty()) {
                        vista.mostrarCadena("No hay canciones registradas de ese compositor.");
                    } else {
                        porComp.forEach(m -> vista.mostrarCadena(m.toString()));
                    }
                    break;

                case 11:
                    vista.mostrarCadena(modelo.reportePorFormato());
                    break;

                case 12:
                    vista.mostrarCadena("Cantidad de cantantes únicos en el catálogo: " + modelo.contarCantantesUnicos());
                    break;

                case 13:
                    vista.mostrarCadena("1. Ordenar por Precio | 2. Ordenar por Año | 3. Ordenar por Cantante");
                    int opcOrd = vista.leerAnioMelodia();
                    if (opcOrd == 1) modelo.ordenarMelodiasPorPrecio();
                    else if (opcOrd == 2) modelo.ordenarMelodiasPorAnio();
                    else if (opcOrd == 3) modelo.ordenarMelodiasPorCantante();
                    vista.mostrarCadena("Catálogo ordenado correctamente.");
                    break;

                case 14:
                    vista.mostrarCadena("Gracias por su consulta. Tenga un excelente día");
                    break;

                default:
                    vista.mostrarCadena("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
    }


}
