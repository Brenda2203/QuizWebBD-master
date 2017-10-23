package dao;

import model.UnidadAbstracta;
import util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UnidadDAO {

    private Connection connection;

    public UnidadDAO() {
        connection = DbUtil.getConnection();
    }

    public void addUnidad(UnidadAbstracta unidad) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into unidadabstracta(id_contexto, id_tabla,nombre_unidad) values (?, ?,?)");
      
        preparedStatement.setInt(1, unidad.getId_contexto());
        preparedStatement.setInt(2, unidad.getId_tabla());
        preparedStatement.setString(3, unidad.getNombre_unidad());
        preparedStatement.executeUpdate();
    }

    public void deleteUnidad(int id_unidad) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from unidadabstracta where id_unidad=?");
        preparedStatement.setInt(1, id_unidad);
        preparedStatement.executeUpdate();
    }

    public void updateUnidad(String nombreT,int idT) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update unidadabstracta set nombre_unidad=?" + "where id_unidad=?");
        preparedStatement.setString(1, nombreT);
        preparedStatement.setInt(2, idT);
        preparedStatement.executeUpdate();
    }

    public ArrayList<UnidadAbstracta> getAllUnidades() throws SQLException {
        ArrayList<UnidadAbstracta> unidades = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from unidadabstracta");
        while (rs.next()) {
            UnidadAbstracta unidad = new UnidadAbstracta();
            unidad.setId_unidad(rs.getInt("id_unidad"));
            unidad.setId_contexto(rs.getInt("id_contexto"));
             unidad.setId_tabla(rs.getInt("id_tabla"));
            unidad.setNombre_unidad(rs.getString("nombre_unidad"));  
            unidades.add(unidad);
        }
        return unidades;
    }

    public UnidadAbstracta getUnidadById(int id_unidad) throws SQLException {
        UnidadAbstracta unidad = new UnidadAbstracta();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from unidadabtracta where id_unidad=?");
        preparedStatement.setInt(1, id_unidad);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
             unidad.setId_unidad(rs.getInt("id_unidad"));
            unidad.setId_contexto(rs.getInt("id_contexto"));
             unidad.setId_tabla(rs.getInt("id_tabla"));
            unidad.setNombre_unidad(rs.getString("nombre_contexto"));  
        }
        return unidad;
    }

}
