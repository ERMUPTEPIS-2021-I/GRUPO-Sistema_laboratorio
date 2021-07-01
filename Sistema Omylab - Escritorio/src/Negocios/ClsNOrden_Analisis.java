/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEOrden_Analisis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Mathius
 */
public class ClsNOrden_Analisis {
    
    public static boolean MtdRegistrarOrden_Analisis(ClsEOrden_Analisis objEO) {
        
        try
        {
            String SQL="CALL USP_I_Orden_has_Analisis(?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objEO.getIdOrden());
            st.setInt(2, objEO.getIdAnalisis());
            st.setDouble(3, objEO.getValor_min());
            st.setDouble(4, objEO.getValor_max());
            st.setString(5, objEO.getResultado());
            st.setInt(6, objEO.getIdMuestra());
            
            
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

    public boolean MtdModificarOrden_Analisis(ClsEOrden_Analisis objEO) {
        
        try
        {
            String SQL="CALL USP_U_Orden_has_Analisis(?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objEO.getIdOrden());
            st.setInt(2, objEO.getIdAnalisis());
            st.setDouble(3, objEO.getValor_min());
            st.setDouble(4, objEO.getValor_max());
            st.setString(5, objEO.getResultado());
            st.setInt(6, objEO.getIdMuestra());
            
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

    public boolean MtdEliminarOrden_Analisis(ClsEOrden_Analisis objEO) {
        try
        {
            
            String SQL="CALL USP_D_Orden_has_Analisis(?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEO.getIdOrden());
            st.setInt(2, objEO.getIdAnalisis());
            
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

    public Iterable<ClsEOrden_Analisis> MtdListarOrden_Analisis() {
        
        try
        {
            String SQL="CALL USP_S_Orden_has_Analisis";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEOrden_Analisis> lista=new ArrayList<>();
            ClsEOrden_Analisis ord;
            
            while (resultado.next())
            {
                ord = new ClsEOrden_Analisis();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                ord.setIdOrden(resultado.getInt("idOrden"));
                ord.setIdAnalisis(resultado.getInt("idAnalisis"));
                ord.setValor_min(resultado.getFloat("valor_min"));
                ord.setValor_max(resultado.getFloat("valor_max"));
                ord.setResultado(resultado.getString("resultado"));
                ord.setIdMuestra(resultado.getInt("idMuestra"));
                
                lista.add(ord);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEOrden_Analisis> MtdBuscarOrden_Analisis(ClsEOrden_Analisis objEO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
