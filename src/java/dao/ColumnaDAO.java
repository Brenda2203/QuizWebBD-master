package dao;

import util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Columna;

public class ColumnaDAO {

    private Connection connection;

    public ColumnaDAO() {
        connection = DbUtil.getConnection();
    }

    public void addColumna(Columna columna) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into columna(nombre_columna, data_type, id_tabla) values (?, ?, ?)");
        preparedStatement.setString(1, columna.getNombre_columna());
        preparedStatement.setString(2, columna.getData_type());
        preparedStatement.setInt(3, columna.getId_tabla());
        preparedStatement.executeUpdate();
    }

    public void deleteColumna(int id_columna) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from columna where id_columna=?");
        preparedStatement.setInt(1, id_columna);
        preparedStatement.executeUpdate();
    }

    public void updateColumna(String nombre,String tipo,int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update columna set nombre_columna=?, data_type=?" + "where id_columna=?");
        preparedStatement.setString(1, nombre);
        preparedStatement.setString(2, tipo);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
    }
    

    public ArrayList<Columna> getAllColumna() throws SQLException {
        ArrayList<Columna> columnas = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from columna");
        while (rs.next()) {
            Columna columna = new Columna();
            columna.setId_columna(rs.getInt("id_columna"));
            columna.setNombre_columna(rs.getString("nombre_columna"));
            columna.setData_type(rs.getString("data_type"));
            columna.setId_tabla(rs.getInt("id_tabla"));
            columnas.add(columna);
        }
        return columnas;
    }

    public Columna getTablaById(int id_columna) throws SQLException {
        Columna columna = new Columna();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from columna where id_columna=?");
        preparedStatement.setInt(1, id_columna);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            columna.setId_columna(rs.getInt("id_columna"));
            columna.setNombre_columna(rs.getString("nombre_columna"));
            columna.setData_type(rs.getString("data_typea"));
            columna.setId_tabla(rs.getInt("id_tabla"));
        }
        return columna;
    }

}
