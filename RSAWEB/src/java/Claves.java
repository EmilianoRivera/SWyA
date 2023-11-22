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
import javax.servlet.http.HttpSession;
/**
 *
 * @author Diego
 */
@WebServlet(urlPatterns = {"/Claves"})
public class Claves extends HttpServlet {

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
            
            
            String primo = request.getParameter("tamanoPrimo");
            
            int tamPrimo = Integer.parseInt(primo);
            
            RSAMANITA rsa = new RSAMANITA();

            BigInteger[] pq = rsa.generarPrimos(tamPrimo);
            
            BigInteger p= pq[0];
            BigInteger q = pq[1];

            BigInteger[] claves = rsa.generarClaves(p, q, tamPrimo);
            
            BigInteger n = claves[0];
            BigInteger fi = claves[1];
            BigInteger e = claves[2];
            BigInteger d = claves[3];
            
            String mensaje = "La clave publica es: "+e+ " La clave privada es: "+d;
            
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("e", e);
            request.setAttribute("n", n);
            request.setAttribute("d", d);
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
