<%-- 
    Document   : cliente
    Created on : 19 jun 2021, 18:04:43
    Author     : Mathius
--%>
<%@page import= "java.sql.*" %>
<%@page import= "java.util.Date"%>
<%@page import= "java.text.SimpleDateFormat"%>
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
            
            String ayuda=request.getParameter("id2");
            
            String nro=request.getParameter("id");
            String orden="";
            if(ayuda!=null){
                nro=ayuda.split("-")[0];
                orden= ayuda.split("-")[1];
            }

            //id es el parametro que bien de cargo
            
            String SQL="select * from cliente where nro_documento="+nro;
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            String fech="";
            Date date=new Date();
            SimpleDateFormat formatoFecha=new SimpleDateFormat("YYYY/MM/dd HH:mm");
            fech=formatoFecha.format(date);
            String newfecha = fech.replace(" ", "T");
            String newfecha2 = newfecha.replace("/", "-");
            while (resultado.next()){
          %>
        <h1>AGREGAR ANALISIS</h1>
        <hr>

                
        <h4><b>Agregue análisis a su Orden</b></h4>
        <%
                String SQL3="select * from analisis where estado=1";
                PreparedStatement sp=con.prepareStatement(SQL3);
                ResultSet resultado3=sp.executeQuery();

                String est="";
                String ana="";
                %>
        <form action="" method="post" style="width: 500px; height: 630px">
        <table class="table table-bordered">
            <tr>
                <th class="text-center">Analisis</th>
                <th class="text-center">Acciones</th>
 
            </tr>
            <%
                while (resultado3.next()) {
            %>
            <tr>
               <td class="text-center"><%= resultado3.getString("nombre") %></td>
               <td class="text-center">
                   
                   <a class="btn btn-warning btn-sm" href="agregar.jsp?id2=<%= nro+"-"+orden+"-"+resultado3.getString("idAnalisis")%>">Agregar</a> 
               </td>


            </tr>
                <% } %>
        </table>
        <%
                String SQL5="select a.idAnalisis,a.nombre from orden_has_analisis o INNER JOIN analisis a on a.idAnalisis = o.idAnalisis where o.idOrden="+orden;
                PreparedStatement sq=con.prepareStatement(SQL5);
                ResultSet resultado5=sq.executeQuery();
                
        %>        
        <hr>
        <h4><b>Analisis agregados</b></h4>
        <table class="table table-bordered">
            <tr>
                <th class="text-center">Analisis</th>
                <th class="text-center">Accion</th>
            </tr>
            <%
             while (resultado5.next()) {
              %>
            <tr>
               <td class="text-center"><%= resultado5.getString("a.nombre") %></td>
               <td class="text-center">
                   
                   <a class="btn btn-danger btn-sm" href="eliminar.jsp?id2=<%= nro+"-"+orden+"-"+resultado5.getString("a.idAnalisis")%>">Eliminar</a> 
               </td>
            </tr>
            <% } %>
            
        </table>
            <h3> <a class="btn btn-info btn-lg"  href="../index2.jsp?id=<%= nro%>" >Guardar</a></h3>
                <br>
            </form>
   
                <%}%>    
        
        <%  
            //Connection con;
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3309/db_ejemplo","root","");
            //String SQL="CALL USP_S_ListarTodoslosCargos()";
            String SQL2="select idOrden,fecha,estado from orden where Cliente_nro_documento="+nro;
            PreparedStatement sr=con.prepareStatement(SQL2);
            ResultSet resultado2=sr.executeQuery();
          %>

   </div>
    </body>
</html>

