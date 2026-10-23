package Vista;
import modelo.Genero;

import java.util.Scanner;

public class CatalogoView {
    private Scanner leerNumeros = new Scanner(System.in);
    private Scanner leerCadenas = new Scanner(System.in);
    private String[] formatos = {"mp3", "ogg", "wav","flac"};


    public int mostrarMenu() {
        System.out.println("\n Menu Catalogo de melodias");
        System.out.println("1. Registrar Melodía");
        System.out.println("2. Mostrar todo el catálogo");
        System.out.println("3. Buscar melodía por Nombre");
        System.out.println("4. Eliminar melodía por ID");
        System.out.println("5. Ver valor total de la colección");
        System.out.println("6. Ver todos los géneros");
        System.out.println("7. Buscar canciones por Año");
        System.out.println("8. Ordenar catálogo (Precio / Año / Cantante)");
        System.out.println("9. Salir");
        System.out.print("Elige una opción: ");
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
        System.out.println("Ingresa año de melodia");
        return leerNumeros.nextInt();
    }

    public double leerPrecioMelodia(){
        System.out.println("Ingrese el precio: ");
        return leerNumeros.nextDouble();
    }

    public int leerId(){
        System.out.println("Ingrese el ID de la melodía: ");
        return leerNumeros.nextInt();
    }

    public String mostrarObtenerFormato(){
        System.out.println("Formatos disponibles ");
        for(int i=0;i<formatos.length; i++){
            System.out.println((i+1) + ". " + formatos[i]);
        }
        System.out.println("Ingrese el número del formato: ");
        int seleccion=leerNumeros.nextInt();
        if(seleccion>=1&&seleccion<=formatos.length){
            return formatos[seleccion-1];
        }
        return "mp3";
    }

    public String leerGenero(){
        System.out.println("Ingrese el género musical: ");
        return leerCadenas.nextLine();
    }

    public void mostrarCatalogo(String catalogo ){
        System.out.println(catalogo);
    }

    public void mostrarCadena(String cadena ){
        System.out.println(cadena);
    }
}
