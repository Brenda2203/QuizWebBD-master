package controller;

import dao.EsquemaDAO;
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

public class SchemaSer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        EsquemaDAO ed = new EsquemaDAO();
        ArrayList<Esquema> respuesta = new ArrayList<>();
        if (action.equals("modificar")) {
            try {
                respuesta = ed.getAllEsquemas();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificar_esquema.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }
        if (action.equals("eliminar")) {
            try {
                respuesta = ed.getAllEsquemas();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/eliminar_esquema.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }
        if (action.equals("listar")) {
            try {
                respuesta = ed.getAllEsquemas();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listar_esquema.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EsquemaDAO esquema_dao = new EsquemaDAO();
        String nombre_esquema = request.getParameter("nombre_esquema");

        Esquema esquema = new Esquema(nombre_esquema);

        try {
            esquema_dao.addEsquema(esquema);
        } catch (SQLException ex) {
            Logger.getLogger(SchemaSer.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("menu.html");

    }

}
