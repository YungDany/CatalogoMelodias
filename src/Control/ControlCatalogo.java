package Control;
import Vista.CatalogoView;
import modelo.CatalogoMelodias;
import modelo.Melodia;

public class ControlCatalogo {
    private CatalogoMelodias modelo;
    private CatalogoView vista;

    public ControlCatalogo(CatalogoView vista, CatalogoMelodias modelo) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion = 0;
        while (opcion != 3) {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    vista.mostrarCadena("\n--- Registrar una nueva melodía ---");
                    String n = vista.leerNombreMelodia();
                    String nca = vista.leerCantante();
                    String nco = vista.leerCompositor();
                    String gen = vista.mostrarObtenerGenero();
                    String formato = vista.mostrarObtenerFormato();
                    int anio = vista.leerAnioMelodia();
                    double precio = vista.leerPrecioMelodia();

                    // Generamos un ID simple basado en el tamaño actual + 1
                    int idGenerado = (int) (Math.random() * 1000);

                    crearObjetoMelodia(idGenerado, n, nco, anio, gen, nca, precio, formato);
                    break;

                case 2:
                    vista.mostrarCatalogo(modelo.mostrarTodasMelodias());
                    break;

                case 3:
                    vista.mostrarCadena("Saliendo del programa...");
                    break;

                default:
                    vista.mostrarCadena("Opción no válida.");
                    break;
            }
        }
    }

    public void crearObjetoMelodia(int id, String nm, String nco, int anio, String genero, String nca, double precio, String formato) {
        Melodia nueva = new Melodia(id, nm, nco, anio, genero, nca, precio, formato);
        boolean registrado = modelo.registarMelodia(nueva);

        if (registrado) {
            vista.mostrarCadena("La melodía ya existía (no se registró duplicada).");
        } else {
            vista.mostrarCadena("¡Melodía registrada con éxito!");
        }
    }
}
