<%-- 
    Document   : detalle
    Created on : 29 jun 2021, 18:14:00
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
        <div class="container" style="width: 500px; height: 300px">
         <%
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3309/laboratorio_omylab","root","");
            String ayuda=request.getParameter("id2");
            String nro=request.getParameter("id");
            String orden="";
            String analisis="";
            if(ayuda!=null){
                nro=ayuda.split("-")[0];
                orden= ayuda.split("-")[1];
            }
                String SQL5="select a.idAnalisis,a.nombre from orden_has_analisis o INNER JOIN analisis a on a.idAnalisis = o.idAnalisis where o.idOrden="+orden;
                PreparedStatement sq=con.prepareStatement(SQL5);
                ResultSet resultado5=sq.executeQuery();
                
        %> 
        <h4><b>Analisis de la Orden</b></h4>
        <table class="table table-bordered">

            <tr>
                <th class="text-center">Analisis</th>
            </tr>
            <%
             while (resultado5.next()) {
              %>
            <tr>
               <td class="text-center"><%= resultado5.getString("a.nombre") %></td>

            </tr>
            <% } %>
        </table>
        <h3> <a class="btn btn-info btn-lg"  href="../index2.jsp?id=<%= nro%>" >Regresar</a></h3>
        </div>
    </body>
</html>
