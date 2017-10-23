
package model;

public class ContextoNavegacion {
    public int id_contexto;
    public String link;
    public String nombre_contexto;
    public int id_modelo;
    
    public ContextoNavegacion(){
        
    }

    public ContextoNavegacion(String link, String nombre_contexto, int id_modelo) {
        this.link = link;
        this.nombre_contexto = nombre_contexto;
        this.id_modelo = id_modelo;
    }

    public int getId_contexto() {
        return id_contexto;
    }

    public void setId_contexto(int id_contexto) {
        this.id_contexto = id_contexto;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNombre_contexto() {
        return nombre_contexto;
    }

    public void setNombre_contexto(String nombre_contexto) {
        this.nombre_contexto = nombre_contexto;
    }

    public int getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }
    
    @Override
    public String toString() {
        return "ContextoNavegacion{" + "id_contexto=" + id_contexto + ", link=" + link + ", nombre_contexto=" + nombre_contexto + ", id_modelo=" + id_modelo + '}';
    }
    
    
}
