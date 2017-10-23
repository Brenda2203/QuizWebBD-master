package controller;

import dao.ModeloDAO;
import dao.ContextoDAO;
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

import model.ModeloNavegacion;

public class ContextoSer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        ContextoDAO td = new ContextoDAO();
        ArrayList<ContextoNavegacion> respuesta = new ArrayList<>();
        ModeloDAO ed = new ModeloDAO();
        ArrayList<ModeloNavegacion> respuesta2 = new ArrayList<>();
        if (action.equals("modificar")) {
            try {
                respuesta = td.getAllTables();
            } catch (SQLException ex) {
                Logger.getLogger(ContextoSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificar_contexto.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }
        if (action.equals("eliminar")) {
            try {
                respuesta = td.getAllTables();
            } catch (SQLException ex) {
                Logger.getLogger(ContextoSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/eliminar_contexto.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }
        if (action.equals("agregar")) {
            try {
                respuesta2 = ed.getAllModelos();
            } catch (SQLException ex) {
                Logger.getLogger(ContextoSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregar_contexto.jsp");
            request.setAttribute("respuesta", respuesta2);
            rd.forward(request, response);
        }
        if (action.equals("listar")) {
            try {
                respuesta = td.getAllTables();
            } catch (SQLException ex) {
                Logger.getLogger(ContextoSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listar_contexto.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ContextoDAO contexto_dao = new ContextoDAO();
         String link = request.getParameter("link");
        String nombre_contexto = request.getParameter("nombre_contexto");
        int id_modelo = Integer.parseInt(request.getParameter("id_modelo"));

        ContextoNavegacion contexto = new ContextoNavegacion(link,nombre_contexto, id_modelo);

        try {
            contexto_dao.addContexto(contexto);
        } catch (SQLException ex) {
            Logger.getLogger(ModelSer.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("menu.html");

    }

}
