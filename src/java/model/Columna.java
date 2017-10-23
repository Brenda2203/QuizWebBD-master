package model;

public class Columna {

    private int id_columna;
    private String nombre_columna;
    private String data_type;
    private int id_tabla;

    public Columna () {
        
    }
    
    public Columna (String nombre_columna, String data_type, int id_tabla) {
        this.nombre_columna = nombre_columna; 
        this.data_type = data_type;
        this.id_tabla = id_tabla;
    }
    
    public int getId_columna() {
        return id_columna;
    }

    public void setId_columna(int id_columna) {
        this.id_columna = id_columna;
    }

    public String getNombre_columna() {
        return nombre_columna;
    }

    public void setNombre_columna(String nombre_columna) {
        this.nombre_columna = nombre_columna;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public int getId_tabla() {
        return id_tabla;
    }

    public void setId_tabla(int id_tabla) {
        this.id_tabla = id_tabla;
    }

    @Override
    public String toString() {
        return "Columna{" + "id_columna=" + id_columna + ", nombre_columna=" + nombre_columna + ", data_type=" + data_type + ", id_tabla=" + id_tabla + '}';
    }

}
