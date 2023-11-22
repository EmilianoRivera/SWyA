/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Clase.RSAMANITA;
import java.math.BigInteger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Diego
 */
@WebServlet(urlPatterns = {"/Descifrar"})
public class Descifrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            RSAMANITA rsa = new RSAMANITA();
            
           
            String de = request.getParameter("d");
            String ee = request.getParameter("e");
            String ne = request.getParameter("n");
            String men = request.getParameter("c");
           BigInteger d = new BigInteger(de);
           BigInteger n = new BigInteger(ne);
            BigInteger e = new BigInteger(ee);
            BigInteger[] cifrado = rsa.cifrar(men, e , n);
            
            String descifrado = rsa.descifrar(cifrado, d, n);
            
            String mensaje = "El mensaje descifrado es: "+descifrado;
            
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("des", mensaje);
            request.setAttribute("e", null);
            request.setAttribute("mel", null);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                   rd.forward(request, response);
            
            
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
