<%-- 
    Document   : agregar
    Created on : 29 jun 2021, 17:24:02
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
            
            String SQL5="select * from orden_has_analisis";
                PreparedStatement sq=con.prepareStatement(SQL5);
                ResultSet resultado5=sq.executeQuery();
                String a="";
                String e="";
                int aux=0;
                while (resultado5.next()) {
                    a=resultado5.getString("idAnalisis");
                    e=resultado5.getString("idOrden");
                    if(orden.equals(e) && analisis.equals(a)){
                        aux=1;
                        response.sendRedirect("agregar_analisis.jsp?id2="+ nro+"-"+orden);
                    }

                }
                if(aux==0){
                    PreparedStatement ps=con.prepareStatement("insert into orden_has_analisis(idOrden,"
                   + " idAnalisis) values('"+orden+"','"+analisis+"')");
                    ps.executeUpdate();
                    response.sendRedirect("agregar_analisis.jsp?id2="+ nro+"-"+orden);
                }
            
          %>
        
    </body>
</html>
