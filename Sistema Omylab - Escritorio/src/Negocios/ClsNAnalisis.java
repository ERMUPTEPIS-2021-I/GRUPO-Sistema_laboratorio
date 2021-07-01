/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEAnalisis;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Mathius
 */
public class ClsNAnalisis {
    public static boolean MtdRegistrarAnalisis(ClsEAnalisis objEA) {
        
        try
        {
            String SQL="CALL USP_I_Analisis(?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objEA.getNombre());
            st.setDouble(2, objEA.getCosto());
            st.setInt(3, objEA.getEstado());
            
            
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

    public boolean MtdModificarAnalisis(ClsEAnalisis objEA) {
        
        try
        {
            String SQL="CALL USP_U_Analisis (?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            
            st.setInt(1, objEA.getIdAnalisis());
            st.setString(2, objEA.getNombre());
            st.setDouble(3, objEA.getCosto());
            st.setInt(4, objEA.getEstado());
            
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

    public boolean MtdEliminarAnalisis(ClsEAnalisis objEA) {
        try
        {
            
            String SQL="CALL USP_D_Analisis(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEA.getIdAnalisis());
            
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

    public Iterable<ClsEAnalisis> MtdListarAnalisis() {
        
        try
        {
            String SQL="CALL USP_S_Analisis";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEAnalisis> lista=new ArrayList<>();
            ClsEAnalisis anali;
            
            while (resultado.next())
            {
                anali = new ClsEAnalisis();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                anali.setIdAnalisis(resultado.getInt("idAnalisis"));
                anali.setNombre(resultado.getString("nombre"));
                anali.setCosto(resultado.getDouble("costo"));             
                anali.setEstado(resultado.getInt("estado"));
                
                
                lista.add(anali);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEAnalisis> MtdBuscarAnalisis(ClsEAnalisis objEA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
