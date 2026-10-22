package Vista;
import modelo.Genero;

import java.util.Scanner;

public class CatalogoView {
    private Scanner leerNumeros = new Scanner(System.in);
    private Scanner leerCadenas = new Scanner(System.in);
    private String[] formatos = {"mp3", "oog", "wav"};


    public int mostrarMenu() {
        System.out.println("\n--Menu Catalogo de melodias--");
        System.out.println("1.Registrar Melodia");
        System.out.println("2.Mostrar todo el catalogo");
        System.out.println("3.Salir");
        System.out.println("Elige una opcion: ");
        return leerNumeros.nextInt();

    }

    public String leerNombreMelodia() {
        System.out.println("Ingresa el nombre");
        return leerCadenas.nextLine();
    }

    public String leerCompositor() {
        System.out.println("Ingresa Compositor");
        return leerCadenas.nextLine();
    }

    public String leerCantante() {
        System.out.println("ingresa Cantante");
        return leerCadenas.nextLine();
    }

    public int leerAnioMelodia() {
        System.out.println("Ingresa anio de melodia");
        return leerNumeros.nextInt();
    }

    public void mostrarCatalogo(String Catalogo) {
        System.out.println(Catalogo);
    }

    public void mostrarCadena(String Cadena) {
        System.out.println(Cadena);
    }

    //leer y regresar  el precio
    public double leerPrecioMelodia() {
        System.out.println("Ingresa Precio de melodia");
        return leerNumeros.nextDouble();
    }

    public String mostrarObtenerFormato() {
        int numero = 1;
        int Seleccion;
        for (String g : formatos) {
            System.out.println(numero + ".Formato: " + g);
            numero++;
        }
        System.out.println("Ingresa el numero del formato");
        numero = leerNumeros.nextInt();
        return formatos[numero - 1].toString();
    }

    public String mostrarObtenerGenero() {
        Genero[] generos = Genero.values();
        int numero = 1;
        int seleccion;
        for (Genero g : Genero.values()) {
            System.out.println(numero + ".Genero " + g);
            numero++;
        }
        System.out.println("INRESA EL NUMERO DE GENERO");
        numero = leerNumeros.nextInt();
        return generos[numero - 1].toString();
    }
}