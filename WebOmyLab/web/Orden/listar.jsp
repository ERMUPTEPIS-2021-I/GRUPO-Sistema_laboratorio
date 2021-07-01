<%-- 
    Document   : listar
    Created on : 28 jun 2021, 2:37:57
    Author     : Mathius
--%>
<%@page import= "java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
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
        <h1>ORDENES</h1>
        <hr>
        <h4><b>Mis Ordenes</b></h4>
       
        <hr>
        <%  
            //Connection con;
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3309/db_ejemplo","root","");
            //String SQL="CALL USP_S_ListarTodoslosCargos()";
            String SQL2="select idOrden,fecha,estado from orden where Cliente_nro_documento="+nro;
            PreparedStatement sr=con.prepareStatement(SQL2);
            ResultSet resultado2=sr.executeQuery();
          %>
          
        
        
        <!--<h3> <a class="btn btn-success btn-lg" href="agregar.jsp">Agregar Cliente</a></h3>-->
        <table class="table table-bordered">
            <tr>
                <th class="text-center">idOrden</th>
                <th class="text-center">Fecha</th>
                <th class="text-center">Estado</th>
                <th class="text-center">Detalle</th>
 
            </tr>
            
            <%
                while (resultado2.next()) {
            %>
            <tr>
               <td class="text-center"><%= resultado2.getString("idOrden") %></td>
               <td class="text-left"><%= resultado2.getString("fecha") %></td>
               <td class="text-left"><%= resultado2.getString("estado") %></td>
               <td class="text-center">
                   
                   <a class="btn btn-info btn-sm" href="detalle.jsp?id2=<%= nro+"-"+resultado2.getString("idOrden")%>">Ver Detalle</a> 
                
               </td>
            </tr>
                <% } %>
            
        </table>
        <hr>
        <h3> <a class="btn btn-info btn-lg"  href="../index2.jsp?id=<%= nro%>" >Inicio</a></h3>
   </div>
    </body>
</html>
