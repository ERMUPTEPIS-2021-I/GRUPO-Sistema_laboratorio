/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEValor_referencial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsNValor_referencial {
    public static boolean MtdRegistrarValor_referencial(ClsEValor_referencial objEM) {
        
        try
        {
            String SQL="CALL USP_I_Valor_referencial(?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setFloat(1, objEM.getValor_min());
            st.setFloat(2, objEM.getValor_max());
            st.setString(3, objEM.getSexo());
            st.setInt(4, objEM.getEdad_min());
            st.setInt(5, objEM.getEdad_max());
            st.setInt(6, objEM.getIdAnalisis());
    
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

    public boolean MtdModificarValor_referencial(ClsEValor_referencial objEM) {
        
        try
        {
            String SQL="CALL USP_U_Valor_referencial (?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(7, objEM.getIdValor_referencial());
            st.setFloat(1, objEM.getValor_min());
            st.setFloat(2, objEM.getValor_max());
            st.setString(3, objEM.getSexo());
            st.setInt(4, objEM.getEdad_min());
            st.setInt(5, objEM.getEdad_max());
            st.setInt(6, objEM.getIdAnalisis());
            
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

    public boolean MtdEliminarValor_referencial(ClsEValor_referencial objEM) {
        try
        {
            
            String SQL="CALL USP_D_Valor_referencial(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEM.getIdValor_referencial());
            
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

    public Iterable<ClsEValor_referencial> MtdListarValor_referencial() {
        
        try
        {
            String SQL="CALL USP_S_Valor_referencial";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEValor_referencial> lista=new ArrayList<>();
            ClsEValor_referencial muestra;
            
            while (resultado.next())
            {
                muestra = new ClsEValor_referencial();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                muestra.setIdValor_referencial(resultado.getInt("idValor_referencial"));
                muestra.setValor_min(resultado.getFloat("valor_min"));
                muestra.setValor_max(resultado.getFloat("valor_max"));
                muestra.setSexo(resultado.getString("sexo"));
                muestra.setEdad_min(resultado.getInt("edad_min"));
                muestra.setEdad_max(resultado.getInt("edad_max"));
                muestra.setIdAnalisis(resultado.getInt("idAnalisis"));
                
                
                lista.add(muestra);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEValor_referencial> MtdBuscarValor_referencial(ClsEValor_referencial objEM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}