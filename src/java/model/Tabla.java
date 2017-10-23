package model;

public class Tabla {

    private int id_tabla;
    private String nombre_tabla;
    private int id_esquema;
    
    public Tabla () {
        
    }
    
    public Tabla (String nombre_tabla, int id_esquema) {
        this.nombre_tabla = nombre_tabla;
        this.id_esquema = id_esquema;
    }

    public int getId_tabla() {
        return id_tabla;
    }

    public void setId_tabla(int id_tabla) {
        this.id_tabla = id_tabla;
    }

    public String getNombre_tabla() {
        return nombre_tabla;
    }

    public void setNombre_tabla(String nombre_tabla) {
        this.nombre_tabla = nombre_tabla;
    }

    public int getId_esquema() {
        return id_esquema;
    }

    public void setId_esquema(int id_esquema) {
        this.id_esquema = id_esquema;
    }

    @Override
    public String toString() {
        return "Tabla{" + "id_tabla=" + id_tabla + ", nombre_tabla=" + nombre_tabla + ", id_esquema=" + id_esquema + '}';
    }

}
