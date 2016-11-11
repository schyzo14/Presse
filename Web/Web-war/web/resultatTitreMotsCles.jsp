<%-- 
    Document   : resultatTitreMotsCles
    Created on : 11 nov. 2016, 15:29:49
    Author     : Schyzo
--%>

<%@ page import="java.io.*,java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Résultat de la recherche de titre par mots-clés</title>
    </head>
    <body>
        <h1>Résultat de la recherche pour les mots suivants : </h1>
        <%
          String token = request.getParameter("titreMotsCles");
          String[] motscles = token.split(" ");
          for(int i=0; i<motscles.length; i++) {
              out.print(motscles[i]+"<br />");
          }
        %>  
        <%@include file="rechercheVolume.html" %>
    </body>
</html>
