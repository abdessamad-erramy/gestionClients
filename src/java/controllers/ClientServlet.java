/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java
 */
package controllers;

import dao.ClientDAO;
import model.Client;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/clients")
public class ClientServlet extends HttpServlet {

    private ClientDAO dao;

    @Override
    public void init() {
        dao = new ClientDAO();
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {

               
                case "new":
                    request.getRequestDispatcher("/client-form.jsp")
                           .forward(request, response);
                    break;

                
                case "delete":
                    int id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/clients");
                    break;

                
                case "edit":
                  
                    request.getRequestDispatcher("/form-update.jsp")
                           .forward(request, response);
                    break;

                
                default:
                    List<Client> list = dao.findAll();
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("/client-list.jsp")
                           .forward(request, response);
            }

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
           
            if ("update".equals(action)) {

                int id = Integer.parseInt(request.getParameter("idClt"));
                String nom = request.getParameter("nomClt");
                String ville = request.getParameter("villeClt");

                if (nom == null || nom.trim().isEmpty()
                        || ville == null || ville.trim().isEmpty()) {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().println("Champs obligatoires");
                    return;
                }

                dao.update(id, nom, ville);
                response.sendRedirect(request.getContextPath() + "/clients");
                return;
            }

           
            String nom = request.getParameter("nomClt");
            String ville = request.getParameter("villeClt");

            if (nom == null || nom.trim().isEmpty()
                    || ville == null || ville.trim().isEmpty()) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("Champs obligatoires : nomClt, villeClt");
                return;
            }

            dao.insert(new Client(nom, ville));
            response.sendRedirect(request.getContextPath() + "/clients");

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}