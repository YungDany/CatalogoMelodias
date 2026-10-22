package Vista;

import java.util.Scanner;

public class ControlCatalogo {
    private Scanner leerNumeros= new Scanner(System.in);
    private Scanner leerCadenas= new Scanner(System.in);

    public int mostrarMenu(){
        System.out.println("MENÚ DE MELODIAS");
        System.out.println("1. Registrar Melodia");
        System.out.println("2. Mostrar todo el catalogo");
        System.out.println("3. Salir");
        System.out.println("Elige una opción");
        return leerNumeros.nextInt();
    }



    public String leerCompositor(){
        System.out.println("Ingrese el nombre del compositor: ");
        return leerCadenas.nextLine();
    }

    public String leerCantante(){
        System.out.println("Ingrese el nombre del cantante: ");
        return leerCadenas.nextLine();
    }

    public void  mostrarCadena(String cadena){
        System.out.println(cadena);

    }

    public int leerAnioMelodia(){
        System.out.println("Ingrese el año de la melodia: ");
        return leerNumeros.nextInt();
    }

    public void mostrarCatalogo(String catalogo){
        System.out.println(catalogo);
    }

    public double leerPrecioMelodia(){
        System.out.println("Ingrese el precio de la melodia: ");
        return leerNumeros.nextDouble();
    }



}

