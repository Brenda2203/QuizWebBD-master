package controller;

import dao.EsquemaDAO;
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
import model.Esquema;
import model.Tabla;

public class TablaSer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        TablaDAO td = new TablaDAO();
        ArrayList<Tabla> respuesta = new ArrayList<>();
        EsquemaDAO ed = new EsquemaDAO();
        ArrayList<Esquema> respuesta2 = new ArrayList<>();
        if (action.equals("modificar")) {
            try {
                respuesta = td.getAllTables();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificar_tabla.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }
        if (action.equals("eliminar")) {
            try {
                respuesta = td.getAllTables();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/eliminar_tabla.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }
        if (action.equals("agregar")) {
            try {
                respuesta2 = ed.getAllEsquemas();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregar_tabla.jsp");
            request.setAttribute("respuesta", respuesta2);
            rd.forward(request, response);
        }
        if (action.equals("listar")) {
            try {
                respuesta = td.getAllTables();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listar_tabla.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TablaDAO tabla_dao = new TablaDAO();
        String nombre_tabla = request.getParameter("nombre_tabla");
        int id_esquema = Integer.parseInt(request.getParameter("id_esquema"));

        Tabla tabla = new Tabla(nombre_tabla, id_esquema);

        try {
            tabla_dao.addTabla(tabla);
        } catch (SQLException ex) {
            Logger.getLogger(ModelSer.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("menu.html");

    }

}
