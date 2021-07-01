<%-- 
    Document   : index2
    Created on : 28 jun 2021, 0:53:03
    Author     : Mathius
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <%
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3309/laboratorio_omylab","root","");
            
            String nro=request.getParameter("id");//id es el parametro que bien de cargo
          %>  
        <h1>Página Principal</h1>
        <table>
            <tr>
                <td>
                    <a href="Cliente/cliente.jsp?id=<%= nro%>">Mis Datos</a><br>
                    <a href="Analisis/analisis.jsp?id=<%= nro%>">Listado de Analisis</a><br>
                    <a href="Orden/orden.jsp?id=<%= nro%>">Realizar Orden</a><br>
                    <a href="Orden/listar.jsp?id=<%= nro%>">Ver mis ordenes</a><br>
                    <br><br><br>
                    <a href="index.jsp">Cerrar Sesion</a>
                </td>
            </tr>
        </table>
        </div>
    </body>
</html>
