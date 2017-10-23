package dao;


import util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ContextoNavegacion;

public class ContextoDAO {

    private Connection connection;

    public ContextoDAO() {
        connection = DbUtil.getConnection();
    }

    public void addContexto(ContextoNavegacion contexto) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into contextonavegacion(link, id_modelo,nombre_contexto) values (?, ?,?)");
        preparedStatement.setString(1, contexto.getLink());
        preparedStatement.setInt(2, contexto.getId_modelo());
        preparedStatement.setString(3, contexto.getNombre_contexto());
        preparedStatement.executeUpdate();
    }

    public void deleteContexto(int id_contexto) throws SQLException {
      
        PreparedStatement rs = connection.prepareStatement("select * from unidadabstracta where id_contexto=?");
        rs.setInt(1, id_contexto);
        ResultSet rt=rs.executeQuery();
        UnidadDAO cd=new UnidadDAO();
        while (rt.next()) {
            cd.deleteUnidad(rt.getInt("id_unidad"));
        }
        PreparedStatement preparedStatement = connection.prepareStatement("delete from contextonavegacion where id_contexto=?");
        preparedStatement.setInt(1, id_contexto);
        preparedStatement.executeUpdate();
    }

    public void updateContexto(String link,String nombreT,int idT) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update contextonavegacion set link=?, nombre_contexto=?" + "where id_contexto=?");
        preparedStatement.setString(1, link);
        preparedStatement.setString(2, nombreT);
        preparedStatement.setInt(3, idT);
        preparedStatement.executeUpdate();
    }

    public ArrayList<ContextoNavegacion> getAllTables() throws SQLException {
        ArrayList<ContextoNavegacion> contextos = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from contextonavegacion");
        while (rs.next()) {
            ContextoNavegacion contexto = new ContextoNavegacion();
            contexto.setId_contexto(rs.getInt("id_contexto"));
            contexto.setLink(rs.getString("link"));
            contexto.setId_modelo(rs.getInt("id_modelo"));
            contexto.setNombre_contexto(rs.getString("nombre_contexto"));
           
            contextos.add(contexto);
        }
        return contextos;
    }

    public ContextoNavegacion getContextoById(int id_conexto) throws SQLException {
        ContextoNavegacion contexto = new ContextoNavegacion();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from tabla where id_tabla=?");
        preparedStatement.setInt(1, id_conexto);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            contexto.setId_contexto(rs.getInt("id_conexto"));
            contexto.setLink(rs.getString("link"));
            contexto.setId_modelo(rs.getInt("id_modelo"));
            contexto.setNombre_contexto(rs.getString("nombre_contexto"));
        }
        return contexto;
    }

}
