package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;


public class CatalogoMelodias {
    // Inicialización del ArrayList para evitar NullPointerException
    private ArrayList<Melodia> canciones = new ArrayList<>();

    public boolean registarMelodia(Melodia obj) {
        boolean bandera = false;
        for (Melodia melodia : canciones) {
            if (melodia.equals(obj)) {
                bandera = true;
                break;
            }
        }
        if (!bandera) {
            canciones.add(obj);
        }
        return bandera;
    }

    public String mostrarTodasMelodias() {
        StringBuilder sb = new StringBuilder();
        for (Melodia melodia : canciones) {
            sb.append(melodia);
            sb.append("\n");
        }
        return sb.toString();
    }

    public ArrayList<String> obtenerTodosLosGeneros() {
        return canciones.stream()
                .map(Melodia::getGenero)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public HashSet<String> obtenerTodosLosGenerosIterativo() {
        HashSet<String> generos = new HashSet<>();
        for (Melodia cancion : canciones) {
            generos.add(cancion.getGenero());
        }
        return generos;
    }


    public ArrayList<Melodia> melodiasPorAnio(int anio) {
        return canciones.stream()
                .filter(cancion -> cancion.getAnio() == anio)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
