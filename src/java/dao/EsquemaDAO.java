package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Esquema;

import util.DbUtil;

public class EsquemaDAO {
    
    private Connection connection;

    public EsquemaDAO() {
        connection = DbUtil.getConnection();
    }

    public void addEsquema(Esquema esquema) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into esquema(nombre_esquema) values (?)");
        preparedStatement.setString(1, esquema.getNombre_esquema());
        preparedStatement.executeUpdate();
    }

    public void deleteEsquema(int id_esquema) throws SQLException {
        
        PreparedStatement rs = connection.prepareStatement("select * from tabla where id_esquema=?");
        rs.setInt(1, id_esquema);
        ResultSet rt=rs.executeQuery();
        TablaDAO cd=new TablaDAO();
        while (rt.next()) {
            cd.deleteTabla(rt.getInt("id_tabla"));
        }
        PreparedStatement preparedStatement = connection.prepareStatement("delete from esquema where id_esquema=?");
        preparedStatement.setInt(1, id_esquema);
        preparedStatement.executeUpdate();
    }

    public void updateEsquema(String esquema,int idE) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update esquema set nombre_esquema=?" + " where id_esquema=?");
        preparedStatement.setString(1, esquema);
        preparedStatement.setInt(2, idE);
        
        preparedStatement.executeUpdate();
    }

    public ArrayList<Esquema> getAllEsquemas() throws SQLException {
        ArrayList<Esquema> esquemas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from esquema");
        while (rs.next()) {
            Esquema esquema = new Esquema();
            esquema.setId_esquema(rs.getInt("id_esquema"));
            esquema.setNombre_esquema(rs.getString("nombre_esquema"));
            esquemas.add(esquema);
        }
        return esquemas;
    }

    public Esquema getEsquemaById(int id_esquema) throws SQLException {
        Esquema esquema = new Esquema();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from esquema where id_esquema=?");
        preparedStatement.setInt(1, id_esquema);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            esquema.setId_esquema(rs.getInt("id_esquema"));
            esquema.setNombre_esquema(rs.getString("nombre_esquema"));
        }
        return esquema;
    }   
    
}
