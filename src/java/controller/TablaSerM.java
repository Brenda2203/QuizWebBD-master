
package controller;

import dao.TablaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TablaSerM extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idT=Integer.parseInt(request.getParameter("id_tabla"));
        TablaDAO tabla_dao = new TablaDAO();

        try {
            tabla_dao.deleteTabla(idT);
        } catch (SQLException ex) {
            Logger.getLogger(ModelSer.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("menu.html"); 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreT=request.getParameter("nombre_tabla");
        int idT=Integer.parseInt(request.getParameter("id_tabla"));
        TablaDAO tabla_dao = new TablaDAO();

        try {
            tabla_dao.updateTabla(nombreT,idT);
        } catch (SQLException ex) {
            Logger.getLogger(ModelSer.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        response.sendRedirect("menu.html");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
