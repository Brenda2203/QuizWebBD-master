package controller;


import dao.ContextoDAO;
import dao.TablaDAO;
import dao.UnidadDAO;
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
import model.ContextoNavegacion;
import model.Tabla;
import model.UnidadAbstracta;


public class UnidadSer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        UnidadDAO td = new UnidadDAO();
        ArrayList<UnidadAbstracta> respuesta = new ArrayList<>();
        
        TablaDAO ed = new TablaDAO();
        ArrayList<Tabla> respuesta2 = new ArrayList<>();
        
        ContextoDAO cd = new ContextoDAO();
        ArrayList<ContextoNavegacion> respuesta3 = new ArrayList<>();
        
        
        if (action.equals("modificar")) {
            try {
                respuesta = td.getAllUnidades();
            } catch (SQLException ex) {
                Logger.getLogger(UnidadSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificar_unidad.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }
        if (action.equals("eliminar")) {
            try {
                respuesta = td.getAllUnidades();
            } catch (SQLException ex) {
                Logger.getLogger(UnidadSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/eliminar_unidad.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }
        if (action.equals("agregar")) {
            try {
                respuesta2 = ed.getAllTables();
                respuesta3 = cd.getAllTables();
            } catch (SQLException ex) {
                Logger.getLogger(UnidadSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregar_unidad.jsp");
            request.setAttribute("respuesta", respuesta2);
            request.setAttribute("respuesta1", respuesta3);
            rd.forward(request, response);
        }
        if (action.equals("listar")) {
            try {
                respuesta = td.getAllUnidades();
            } catch (SQLException ex) {
                Logger.getLogger(UnidadSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listar_unidad.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UnidadDAO unidad_dao = new UnidadDAO();
        String nombre_unidad = request.getParameter("nombre_unidad");
        int id_tabla = Integer.parseInt(request.getParameter("id_tabla"));
        int id_modelo = Integer.parseInt(request.getParameter("id_contexto"));

        UnidadAbstracta unidad = new UnidadAbstracta(nombre_unidad, id_modelo, id_tabla);

        try {
            unidad_dao.addUnidad(unidad);
        } catch (SQLException ex) {
            Logger.getLogger(ModelSer.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("menu.html");

    }

}
