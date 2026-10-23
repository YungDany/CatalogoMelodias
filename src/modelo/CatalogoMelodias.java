package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;


public class CatalogoMelodias {
    // Inicialización del ArrayList para evitar NullPointerException
    private ArrayList<Melodia> canciones = new ArrayList<>();

    public boolean registrarMelodia(Melodia obj) {
        for(Melodia melodia:canciones){
            if (melodia.equals(obj)) {

                return false;
            }
        }
        canciones.add(obj);
        return true;
    }

    public boolean removerMelodia(int id){
        return canciones.removeIf(m->m.getId()==id);
    }

    public boolean removerMelodiaPorNombre(String nombre){
        return canciones.removeIf(m->m.getNombre().equalsIgnoreCase(nombre));
    }

    public Melodia buscar(int id){
        for(Melodia m:canciones){
            if(m.getId()==id){
                return m;
            }

        }
        return null;
    }

    public ArrayList<Melodia> buscar(String nombreMelodia){
        return canciones.stream().filter(m->m.getNombre().equalsIgnoreCase(nombreMelodia)).collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean actualizarMelodia(int id, String nombre, String compositor,int anio, String genero, String cantante, double precio, String formato){
        Melodia m=buscar(id);
        if(m!=null){
            m.setNombre(nombre);
            m.setCompositor(compositor);
            m.setAnio(anio);
            m.setGenero(genero);
            m.setCantante(cantante);
            m.setPrecio(precio);
            m.setFormato(formato);
            return true;

        }
        return false;
    }

    public double obtenerPrecioColeccion(){
        return  canciones.stream().mapToDouble(Melodia::getPrecio).sum();
    }

    public ArrayList<String> obtenerTodosLosGeneros(){
        return canciones.stream().map(Melodia::getGenero).filter(g->g!=null).map(String::toUpperCase).distinct().collect(Collectors.toCollection(ArrayList::new));

    }

    public ArrayList<Melodia> melodiasPorAnio(int anio){
        return canciones.stream().filter(m->m.getAnio()==anio).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Melodia> melodiasPorCompositor(String compositor){
        return canciones.stream().filter(m->m.getCompositor().equalsIgnoreCase(compositor)).collect(Collectors.toCollection(ArrayList::new));

    }
    public ArrayList<Melodia> melodiasPorCantante(String cantante) {
        return canciones.stream().filter(m -> m.getCantante() != null && m.getCantante().equalsIgnoreCase(cantante)).collect(Collectors.toCollection(ArrayList::new));
    }

    public void ordenarMelodiasPorPrecio(){
        canciones.sort(Comparator.comparingDouble(Melodia::getPrecio));
    }
    public void ordenarMelodiasPorAnio(){
        canciones.sort(Comparator.comparingInt(Melodia::getAnio));
    }

    public void ordenarMelodiasPorCantante(){
        canciones.sort(Comparator.comparing(Melodia::getCantante, String.CASE_INSENSITIVE_ORDER));
    }

    public String mostrarTodasMelodias(){
        if(canciones.isEmpty()){
            return "El catálogo está vacío";
        }
        StringBuilder sb=new StringBuilder();
        for(Melodia melodia:canciones){
            sb.append(melodia).append("\n");
        }
        return sb.toString();
    }

    // Contar cuántos cantantes únicos existen en el catálogo
    public int contarCantantesUnicos() {
        return (int) canciones.stream()
                .map(Melodia::getCantante)
                .filter(c -> c != null)
                .map(String::trim)
                .map(String::toUpperCase)
                .distinct()
                .count();
    }

    // Generar el reporte de distribución por formato de audio
    public String reportePorFormato() {
        if (canciones.isEmpty()) {
            return "No hay canciones registradas en el catálogo.";
        }

        Map<String, Long> conteoFormatos = canciones.stream()
                .filter(m -> m.getFormato() != null)
                .collect(Collectors.groupingBy(m -> m.getFormato().toLowerCase(), Collectors.counting()));

        StringBuilder sb = new StringBuilder(" Canciones por Formato \n");
        conteoFormatos.forEach((formato, cantidad) ->
                sb.append("Formato: ").append(formato).append(" -> ").append(cantidad).append(" melodía(s)\n")
        );
        return sb.toString();
    }







}
