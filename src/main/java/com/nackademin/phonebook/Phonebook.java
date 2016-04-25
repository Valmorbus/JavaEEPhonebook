/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.phonebook;

import com.nackademin.businesslogic.PersonBusinessLogic;
import com.nackademin.businesslogic.PhonenumbersBusinessLogic;
import com.nackademin.entities.Person;
import com.nackademin.entities.Phonenumbers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author borgs_000
 */
@WebServlet(name = "Phonebook", urlPatterns = {"/Phonebook"})
public class Phonebook extends HttpServlet {
 @Inject
 PersonBusinessLogic pbl;
 @Inject 
 PhonenumbersBusinessLogic pnl;
    protected void printAllHtml(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            printHeader(out);
            printBody(out, request);
            printFooter(out);
        }
    }

    protected void printFooter(final PrintWriter out) {
        out.println("</html>");
    }

    protected void printBody(final PrintWriter out, HttpServletRequest request) {
        out.println("<body>");
        out.println("<h1>Servlet TodoServlet at " + request.getContextPath() + "</h1>");
        printForm(out);
        out.println("<table>");
        List<Person> persons = pbl.showAllPersons();
        for (Person p : persons) {
            out.println("<tr><td>" +p.getId() + p.getFirstName() + "</td><td>" + p.getLastName() + "</td><td>" );
                  List<Phonenumbers> numbers = (List) p.getPhonenumbersCollection();
                  for (Phonenumbers n : numbers){
                     out.print("<td>" + n.getPhonenumber() + "</td>");
                  }
        }
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
    }

    protected void printForm(final PrintWriter out) {
        out.println("<form method=\"POST\" action=\"\">");
        out.println("<input type = \"text\" name=\"firstname\" >");
        out.println("<input type = \"text\" name=\"lastname\" >");
        out.println("<input type =\"submit\" value=\"OK\" > ");
        out.println("</form>");
    }

    protected void printHeader(final PrintWriter out) {
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet TodoServlet</title>");
        out.println("</head>");
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

        printAllHtml(request, response);
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
        ///processRequest(request, response);

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        //Nedanstående borde vi också hämtat från foruläret.
     
        pbl.createPerson(firstname, lastname);

        response.sendRedirect("");
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
