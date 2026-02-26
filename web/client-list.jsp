<%@ page import="java.util.List" %>
<%@ page import="model.Client" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">

<div class="container">
    <h1>Liste des clients</h1>

    <a class="btn btn-primary"
       href="<%= request.getContextPath() %>/clients?action=new">
        + Ajouter un client
    </a>

    <table>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Ville</th>
            <th colspan="2">Actions</th>
        </tr>

        <%
            List<Client> list = (List<Client>) request.getAttribute("list");
            if (list != null) {
                for (Client c : list) {
        %>
        <tr>
            <td><%= c.getIdClt() %></td>
            <td><%= c.getNomClt() %></td>
            <td><%= c.getVilleClt() %></td>
            <td>
                <a class="btn btn-danger"
                   href="<%= request.getContextPath() %>/clients?action=delete&id=<%= c.getIdClt() %>"
                   onclick="return confirm('Supprimer ce client ?');">
                    Supprimer
                </a>
            </td>
            <td>
                <a class="btn btn-warning"
                   href="<%= request.getContextPath() %>/clients?action=edit
&id=<%= c.getIdClt() %>
&nomClt=<%= c.getNomClt() %>
&villeClt=<%= c.getVilleClt() %>">
                    Update
                </a>
            </td>
        </tr>
        <% } } %>
    </table>
</div>