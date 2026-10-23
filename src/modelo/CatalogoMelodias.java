package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
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
        return false;
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

    public ArrayList<Melodia> melodiasPorCantante(String cantante){
        return canciones.stream().filter(m->m.getCantante().equalsIgnoreCase(cantante)).collect(Collectors.toCollection(ArrayList::new));

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





}
