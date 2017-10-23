package controller;


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
import model.ModeloNavegacion;
import dao.ModeloDAO;

public class ModelSer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ModeloDAO ed = new ModeloDAO();
        ArrayList<ModeloNavegacion> respuesta = new ArrayList<>();
        if (action.equals("modificar")) {
            try {
                respuesta = ed.getAllModelos();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificar_modelo.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }
        if (action.equals("eliminar")) {
            try {
                respuesta = ed.getAllModelos();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/eliminar_modelo.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }
        if (action.equals("listar")) {
            try {
                respuesta = ed.getAllModelos();
            } catch (SQLException ex) {
                Logger.getLogger(TablaSer.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listar_modelo.jsp");
            request.setAttribute("respuesta", respuesta);
            rd.forward(request, response);
        }
         if (action.equals("agregar")) {
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregar_modelo.jsp");
           
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModeloDAO modelo_dao = new ModeloDAO();
        String nombre_modelo = request.getParameter("nombre_modelo");

        ModeloNavegacion modelo = new ModeloNavegacion(nombre_modelo);

        try {
            modelo_dao.addModelo(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(ModelSer.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("menu.html");

    }

}
