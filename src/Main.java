import Control.ControlCatalogo;
import Vista.CatalogoView;
import modelo.CatalogoMelodias;
import modelo.Melodia;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CatalogoMelodias melodias = new CatalogoMelodias();

        Melodia m1 = new Melodia(); //Crea canción de Strategy que está en el constructor vacío
        Melodia m2 = new Melodia(2, "The Feels", "Park Jihyo", 2021, "K_POP", "TWICE", 150.0, "mp3");
        Melodia m3 = new Melodia(3, "CRAZY", "Huh Yunjin", 2024, "K_POP", "LE Sserafim", 100, "flac");
        Melodia m4 = new Melodia(4, "500lbs", "Tyler-Justin Anthony Sharpe", 2023, "Trap", "Lil Tecca", 170.0, "wav");

        System.out.println("Registro m1: " + (melodias.registarMelodia(m1) ? "No se pudo" : "Registrada"));
        System.out.println("Registro m2: " + (melodias.registarMelodia(m2) ? "No se pudo" : "Registrada"));
        System.out.println("Registro m3: " + (melodias.registarMelodia(m3) ? "No se pudo" : "Registrada"));
        System.out.println("Registro m4: " + (melodias.registarMelodia(m4) ? "No se pudo" : "Registrada"));

        System.out.println("Registro duplicado m2: " + (melodias.registarMelodia(m2) ? "No se pudo" : "Registrada"));

        System.out.println("\n--- Catálogo ---");
        System.out.println(melodias.mostrarTodasMelodias());
        System.out.println("Géneros: " + melodias.obtenerTodosLosGeneros());

        int anioBuscar = 2025;
        System.out.println("\n--- Canciones del año " + anioBuscar + " ---");
        ArrayList<Melodia> resultado2025 = melodias.melodiasPorAnio(anioBuscar);

        for (Melodia m : resultado2025) {
            System.out.println(m);
        }

        CatalogoMelodias modelo=new CatalogoMelodias();
        CatalogoView vista=new CatalogoView();
        ControlCatalogo control=new ControlCatalogo(vista,modelo);
        control.iniciar();


    }
}