package controller;

import dao.ColumnaDAO;
import dao.TablaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Columna;
import model.Tabla;

public class ColumnaSer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        TablaDAO td = new TablaDAO();
        ArrayList<Tabla> respuesta = new ArrayList<>();
        ColumnaDAO cd = new ColumnaDAO();
        ArrayList<Columna> respuesta2 = new ArrayList<>();
        if (action.equals("modificar")) {
            try {
                respuesta2 = cd.getAllColumna();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificar_columna.jsp");
            request.setAttribute("respuesta", respuesta2);
            rd.forward(request, response);
        }
        if (action.equals("eliminar")) {
            try {
                respuesta2 = cd.getAllColumna();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/eliminar_columna.jsp");
            request.setAttribute("respuesta", respuesta2);
            rd.forward(request, response);
        }
        if (action.equals("listar")) {
            try {
                respuesta2 = cd.getAllColumna();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listar_columna.jsp");
            request.setAttribute("respuesta", respuesta2);
            rd.forward(request, response);
        }
        if (action.equals("agregar")) {
            try {
                respuesta = td.getAllTables();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregar_columna.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ColumnaDAO columna_dao = new ColumnaDAO();
        String nombre_columna = request.getParameter("nombre_columna");
        String data_type = request.getParameter("data_type");
        int id_tabla = Integer.parseInt(request.getParameter("id_tabla"));

        Columna columna = new Columna(nombre_columna, data_type, id_tabla);

        try {
            columna_dao.addColumna(columna);
        } catch (SQLException ex) {
            Logger.getLogger(ModelSer.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("menu.html");

    }

}
