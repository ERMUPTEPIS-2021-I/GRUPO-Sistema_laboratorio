/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Brian Anco
 */
public class ClsConexion {
    public static Connection Conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/laboratorio_omylab","root","");
        }catch(ClassNotFoundException e){
            return null;
        }catch (SQLException ex){
            return  null;
        }
    }
}
