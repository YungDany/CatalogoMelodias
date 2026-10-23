package Vista;

import java.util.Scanner;

public class CatalogoView {
    private Scanner leerNumeros = new Scanner(System.in);
    private Scanner leerCadenas = new Scanner(System.in);
    private String[] formatos = {"mp3", "ogg", "wav", "flac"};

    // Validar entero de forma segura
    private int leerEnteroValido() {
        while (!leerNumeros.hasNextInt()) {
            System.out.print("Entrada inválida. Ingresa un número entero: ");
            leerNumeros.next(); // Limpia la entrada no válida
        }
        return leerNumeros.nextInt();
    }

    // Validar decimal (double) de forma segura
    private double leerDoubleValido() {
        while (!leerNumeros.hasNextDouble()) {
            System.out.print("Entrada inválida. Ingresa un número: ");
            leerNumeros.next(); // Limpia la entrada no válida
        }
        return leerNumeros.nextDouble();
    }

    public int mostrarMenu() {
        System.out.println("\nMenú cátalogo de melodías");
        System.out.println("1. Registrar Melodía");
        System.out.println("2. Mostrar todo el catálogo");
        System.out.println("3. Buscar melodía por Nombre");
        System.out.println("4. Eliminar melodía por ID");
        System.out.println("5. Corregir datos de una melodía");
        System.out.println("6. Ver valor total de la colección");
        System.out.println("7. Ver géneros de la colección");
        System.out.println("8. Buscar canciones por Año");
        System.out.println("9. Buscar canciones por Cantante / Artista");
        System.out.println("10. Buscar canciones por Compositor");
        System.out.println("11. Reporte por Formato (mp3, wav, etc.)");
        System.out.println("12. Ver cantidad de cantantes únicos");
        System.out.println("13. Ordenar catálogo");
        System.out.println("14. Salir");
        System.out.print("Elige una opción: ");
        return leerEnteroValido();
    }

    public String leerNombreMelodia() {
        System.out.print("Ingresa el nombre: ");
        return leerCadenas.nextLine();
    }

    public String leerCompositor() {
        System.out.print("Ingresa el compositor: ");
        return leerCadenas.nextLine();
    }

    public String leerCantante() {
        System.out.print("Ingresa el cantante: ");
        return leerCadenas.nextLine();
    }

    public int leerAnioMelodia() {
        System.out.print("Ingresa el año de la melodía: ");
        return leerEnteroValido();
    }

    public double leerPrecioMelodia() {
        System.out.print("Ingresa el precio: ");
        return leerDoubleValido();
    }

    public int leerId() {
        System.out.print("Ingresa el ID de la melodía: ");
        return leerEnteroValido();
    }

    public String mostrarObtenerFormato() {
        System.out.println("Formatos disponibles:");
        for (int i = 0; i < formatos.length; i++) {
            System.out.println((i + 1) + ". " + formatos[i]);
        }
        System.out.print("Ingresa el número del formato: ");
        int seleccion = leerEnteroValido();
        if (seleccion >= 1 && seleccion <= formatos.length) {
            return formatos[seleccion - 1];
        }
        return "mp3";
    }

    public String leerGenero() {
        System.out.print("Ingresa el género musical: ");
        return leerCadenas.nextLine();
    }

    public void mostrarCatalogo(String catalogo) {
        System.out.println(catalogo);
    }

    public void mostrarCadena(String cadena) {
        System.out.println(cadena);
    }
}