<%-- 
    Document   : eliminar
    Created on : 19 jun 2021, 18:05:01
    Author     : Mathius
--%>
<%@page import="java.sql.*"%>
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
            String nro=request.getParameter("id");
            String SQL="delete from cliente where nro_documento="+nro;
            PreparedStatement st=con.prepareStatement(SQL);
            st.executeUpdate();
            response.sendRedirect("cliente.jsp");
          %>
    </body>
</html>
