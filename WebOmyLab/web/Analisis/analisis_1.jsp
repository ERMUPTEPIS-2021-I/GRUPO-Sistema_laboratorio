<%-- 
    Document   : cliente
    Created on : 19 jun 2021, 18:04:43
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
        
        <div class="container" style="width: 500px; height: 120px">
        <h1>ANALISIS</h1>
           
        <hr>
        <%
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/laboratorio_omylab2","root","");
            
            String nro=request.getParameter("id");//id es el parametro que bien de cargo
            String SQL="select * from analisis";
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
          %>
          
        
        
        <!--<h3> <a class="btn btn-success btn-lg" href="agregar.jsp">Agregar Cliente</a></h3>-->
        <table class="table table-bordered" >
            <tr>
                <th class="text-center">Nombre</th>
                <th class="text-center">Costo</th>
                <th class="text-center">Estado</th>
 
            </tr>
            
            <%
                while (resultado.next()) {
            %>
            <tr>
               <td class="text-center"><%= resultado.getString("nombre") %></td>
               <td class="text-left"><%= resultado.getString("costo") %></td>
               <td class="text-left"><%= resultado.getString("estado") %></td>

               
            </tr>
                <% } %>
            
        </table>
        <hr>
        <h3> <a class="btn btn-info btn-lg"  href="../index.jsp?id=<%= nro%>" >Inicio</a></h3>
   </div>
    </body>
</html>
