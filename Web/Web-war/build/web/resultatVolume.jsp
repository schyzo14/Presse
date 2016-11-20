<%-- 
    Document   : resultatVolume
    Created on : 11 nov. 2016, 16:11:39
    Author     : Schyzo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Résultat de la recherche de volume</title>
    </head>
    <body>
        <h1>Résultat de la recherche du volume : <%= request.getParameter("nomVolume") %></h1>
        <h2>Titre : <%= request.getParameter("selectionTitre") %></h2>
        <table></table>
    </body>
</html>
