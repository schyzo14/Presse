<%-- 
    Document   : resultatTitreNom
    Created on : 11 nov. 2016, 15:20:37
    Author     : Schyzo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="presse.titre"%>
<%@page import="java.util.HashMap"%>
<%@page import="rest.ClientRESTTitre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Résultat de la recherche de titre par nom</title>
        <script>
            function validateForm() {
                var x = document.forms["formulaire"]["numVolume"].value;
                if (x === "") {
                    alert("Il faut saisir un nom de volume");
                    return false;
                }
                var x = document.forms["formulaire"]["selectionTitre"].checked;
                if(!x) {
                    alert("Il faut choisir un titre");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <h1>Résultat de la recherche du titre : <%= request.getParameter("titreNom") %></h1>
        <%
          ClientRESTTitre c = new ClientRESTTitre();
          ArrayList<titre> liste = c.getTitreParNom(request.getParameter("titreNom"));
        %>
        
        <form name='formulaire' action='resultatVolume.jsp' method='get' target='_blank' onsubmit='return validateForm()'>
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
                                out.write("<input type='radio' name=selectionTitre value='"+t.getNomT()+"'/>");
                            out.write("</td>");
                        out.write("</tr>");
                    }
                %>
            </table>
        
            <h1>Rechercher un volume</h1>
            <label>Numéro du volume :</label>
            <input type='text' name='numVolume' />
            <input type='submit' value='Rechercher' />
        </form>
    </body>
</html>
