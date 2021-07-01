<%-- 
    Document   : eliminar
    Created on : 29 jun 2021, 17:45:46
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
            con=DriverManager.getConnection("jdbc:mysql://localhost:3309/laboratorio_omylab","root","");
            String ayuda=request.getParameter("id2");
            String nro=request.getParameter("id");
            String orden="";
            String analisis="";
            if(ayuda!=null){
                nro=ayuda.split("-")[0];
                orden= ayuda.split("-")[1];
                analisis= ayuda.split("-")[2];
            }
            
            String SQL="delete from orden_has_analisis where (idOrden="+orden+" and idAnalisis="+analisis+")";
            PreparedStatement st=con.prepareStatement(SQL);
            st.executeUpdate();
            response.sendRedirect("agregar_analisis.jsp?id2="+ nro+"-"+orden);
          %>
    </body>
</html>
