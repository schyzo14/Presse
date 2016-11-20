<%-- 
    Document   : resultatTitreNom
    Created on : 11 nov. 2016, 15:20:37
    Author     : Schyzo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="presse.titre"%>
<%@page import="java.util.HashMap"%>
<%@page import="rest.ClientTitre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Résultat de la recherche de titre par nom</title>
    </head>
    <body>
        <h1>Résultat de la recherche du titre : <%= request.getParameter("titreNom") %></h1>
        <%
          ClientTitre c = new ClientTitre(request.getParameter("titreNom"));
          ArrayList<titre> liste = c.getTitreParNom();
        %>
        <table border="1">
            <tr>
                <th>Numéro du titre</th>
                <th>Nom du titre</th>
                <th>Sélection</th>
            </tr>
            <%
                for(titre t : liste) {
                    out.write("<tr>");
                        out.write("<td>");
                            out.write(Integer.toString(t.getNumT()));
                        out.write("</td>");
                        out.write("<td>");
                            out.write(t.getNomT());
                        out.write("</td>");
                        out.write("<td>");
                            out.write("<input type='radio' name='selectionTitre' />");
                        out.write("</td>");
                    out.write("</tr>");
                }
            %>
        </table>
        <%@include file="rechercheVolume.html" %>
    </body>
</html>
