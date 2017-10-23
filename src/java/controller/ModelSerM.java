
package controller;


import dao.ModeloDAO;
import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ModelSerM extends HttpServlet {


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
        int idE=Integer.parseInt(request.getParameter("id_unidad"));
        ModeloDAO modelo_dao = new ModeloDAO();
        System.out.println(idE);

        try {
            modelo_dao.deleteModelo(idE);
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
        String nombreE=request.getParameter("nombre_modelo");
        int idE=Integer.parseInt(request.getParameter("id_modelo"));
        ModeloDAO modelo_dao = new ModeloDAO();

        try {
            modelo_dao.updateModelo(nombreE,idE);
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
