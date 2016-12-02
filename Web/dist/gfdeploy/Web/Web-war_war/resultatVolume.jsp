<%-- 
    Document   : resultatVolume
    Created on : 11 nov. 2016, 16:11:39
    Author     : Schyzo
--%>

<%@page import="presse.Article"%>
<%@page import="java.util.ArrayList"%>
<%@page import="presse.Volume"%>
<%@page import="rest.ClientRESTVolume"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Résultat de la recherche de volume</title>
    </head>
    <body>
        <h1>Résultat de la recherche du volume : <%= request.getParameter("numVolume") %></h1>
        <h2>Titre : <%= request.getParameter("selectionTitre") %></h2>
        <%
          ClientRESTVolume c = new ClientRESTVolume();
          Volume v = c.getVolume(request.getParameter("selectionTitre"), request.getParameter("numVolume"));
          ArrayList<Article> listeArticles = new ArrayList<Article>(v.getListeArticles().values());
        %>
        <table border='1'>
            <caption><% Integer.toString(v.getNumV()); %></caption>
            <tr>
                <th>Numéro de l'article</th>
                <th>Nom de l'article</th>
            </tr>
            <%
                for(Article a : listeArticles) {
                    out.write("<tr>");
                        out.write("<td>");
                            out.write(Integer.toString(a.getNumA()));
                        out.write("</td>");
                        out.write("<td>");
                            out.write(a.getNomA());
                        out.write("</td>");
                    out.write("</tr>");
                }
            %>
        </table>
    </body>
</html>
