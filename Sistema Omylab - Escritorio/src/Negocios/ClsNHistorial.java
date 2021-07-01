/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEHistorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsNHistorial {
     public static boolean MtdRegistrarHistorial(ClsEHistorial objEM) {
        
        try
        {
            String SQL="CALL USP_I_Historial(?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objEM.getFecha());
            st.setString(2, objEM.getTipo());
            st.setString(3, objEM.getAccion());
            st.setString(4, objEM.getNro_doc());
            
            
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch(SQLException e)
        {
                return false;         
        }
        
    }

    public boolean MtdModificarHistorial(ClsEHistorial objEM) {
        
        try
        {
            String SQL="CALL USP_U_Historial (?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objEM.getIdHistorial());
            st.setString(2, objEM.getFecha());
            st.setString(3, objEM.getTipo());
            st.setString(4, objEM.getAccion());
            st.setString(5, objEM.getNro_doc());
            
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        } catch(SQLException e){
                return false;         
            }
    }

    public boolean MtdEliminarHistorial(ClsEHistorial objEM) {
        try
        {
            
            String SQL="CALL USP_D_Historial(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEM.getIdHistorial());
            
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }catch(SQLException e){
                return false;         
            }
    }

    public Iterable<ClsEHistorial> MtdListarHistorial() {
        
        try
        {
            String SQL="CALL USP_S_Historial";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEHistorial> lista=new ArrayList<>();
            ClsEHistorial muestra;
            
            while (resultado.next())
            {
                muestra = new ClsEHistorial();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                muestra.setIdHistorial(resultado.getInt("idHistorial"));
                muestra.setFecha(resultado.getString("fecha"));
                muestra.setTipo(resultado.getString("tipo"));
                muestra.setAccion(resultado.getString("accion"));
                muestra.setNro_doc(resultado.getString("nro_documento"));
                
                lista.add(muestra);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }
    
    public Iterable<ClsEHistorial> MtdListarHistorialCliente() {
        
        try
        {
            String SQL="Select * from historial_cliente;";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEHistorial> lista=new ArrayList<>();
            ClsEHistorial muestra;
            
            while (resultado.next())
            {
                muestra = new ClsEHistorial();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                muestra.setIdHistorial(resultado.getInt("idHistorial_cliente"));
                muestra.setFecha(resultado.getString("fecha"));
                muestra.setTipo(resultado.getString("tipo"));
                muestra.setAccion(resultado.getString("accion"));
                muestra.setNro_doc(resultado.getString("nro_documento"));
                
                lista.add(muestra);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEHistorial> MtdBuscarHistorial(ClsEHistorial objEM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
