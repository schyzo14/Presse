<%-- 
    Document   : resultatTitreNom
    Created on : 11 nov. 2016, 15:20:37
    Author     : Schyzo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Résultat de la recherche de titre par nom</title>
    </head>
    <body>
        <h1>Résultat de la recherche du titre : <%= request.getParameter("titreNom") %></h1>
        <table></table>
        <%@include file="rechercheVolume.html" %>
    </body>
</html>
