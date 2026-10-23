package modelo;

import java.util.Objects;

public class Melodia {
    private int id;
    private String nombre;
    private String compositor;
    private int anio;
    private String genero;
    private String cantante;
    private double precio;
    private String formato;

    public Melodia(int id, String nombre, String compositor, int anio, String genero, String cantante, double precio, String formato) {
        this.id = id;
        this.nombre = nombre;
        this.compositor = compositor;
        this.anio = anio;
        this.genero = genero;
        this.cantante = cantante;
        this.precio = precio;
        this.formato = formato;
    }

    public Melodia() {
        this.id = Math.abs(this.hashCode());
        this.nombre = "Strategy";
        this.compositor = "Park Jihyo";
        this.anio = 2025;
        this.genero = "K_POP";
        this.cantante = "TWICE";
        this.precio = 200;
        this.formato = "Mp3";
    }

    @Override
    public String toString() {
        return "Melodia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", compositor='" + compositor + '\'' +
                ", anio=" + anio +
                ", genero='" + genero + '\'' +
                ", cantante='" + cantante + '\'' +
                ", precio=" + precio +
                ", formato='" + formato + '\'' +
                '}';
    }

    public void setCompositor(String compositor){
        this.compositor=compositor;
    }

    public String getCompositor(){
        return compositor;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setGenero(String genero){
        this.genero=genero;
    }

    public String getGenero() {
        return genero;
    }
    public void setAnio(int anio){
            this.anio=anio;
    }

    public int getAnio() {
        return anio;
    }

    public void setCantante(String cantante){
        this.cantante=cantante;
    }

    public String getCantante(){
        return cantante;
    }

    public void setPrecio(Double precio){
        this.precio=precio;
    }

    public double getPrecio(){
        return precio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Melodia mel = (Melodia) obj;
        return this.anio==mel.anio && (this.cantante != null && this.cantante.equalsIgnoreCase(mel.cantante));
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantante!=null ? cantante.toLowerCase() :null,anio);
    }
}
