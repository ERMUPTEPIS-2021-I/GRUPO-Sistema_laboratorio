<%-- 
    Document   : confirmar
    Created on : 1 jul 2021, 2:53:16
    Author     : Mathius
--%>
<%@page import= "java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/laboratorio_omylab2","root","");
            String ayuda=request.getParameter("id2");
            String nro=request.getParameter("id");
            String orden="";
            if(ayuda!=null){
                nro=ayuda.split("-")[0];
                orden= ayuda.split("-")[1];
            }
 
            String SQL5="select * from orden_has_analisis";
            PreparedStatement sq=con.prepareStatement(SQL5);
            ResultSet resultado5=sq.executeQuery();
            String e="";
            int aux=0;
            while (resultado5.next()) {
                e=resultado5.getString("idOrden");
                if(orden.equals(e)){
                    aux=1;
                }
            }
            if(aux==1){
                    response.sendRedirect("../index.jsp?id="+ nro);
                        
            }else{
                response.sendRedirect("agregar_analisis.jsp?id2="+ nro+"-"+orden);
            }
 
                
            
          %>
    </body>
</html>
