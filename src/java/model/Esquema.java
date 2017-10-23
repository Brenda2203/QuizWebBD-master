package model;

public class Esquema {
    
    private int id_esquema;
    private String nombre_esquema;
    
    public Esquema () {

    }

    public Esquema (String nombre_esquema) {
        this.nombre_esquema = nombre_esquema;
    }
    
    public int getId_esquema() {
        return id_esquema;
    }

    public void setId_esquema(int id_esquema) {
        this.id_esquema = id_esquema;
    }

    public String getNombre_esquema() {
        return nombre_esquema;
    }

    public void setNombre_esquema(String nombre_esquema) {
        this.nombre_esquema = nombre_esquema;
    }

    @Override
    public String toString() {
        return "Esquema{" + "id_esquema=" + id_esquema + ", nombre_esquema=" + nombre_esquema + '}';
    }
    
}
