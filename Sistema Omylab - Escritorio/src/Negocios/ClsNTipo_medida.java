/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsETipo_medida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsNTipo_medida {
    public static boolean MtdRegistrarTipo_medida(ClsETipo_medida objETM) {
        
        try
        {
            String SQL="CALL USP_I_Tipo_medida(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objETM.getDescripcion());
            
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

    public boolean MtdModificarTipo_medida(ClsETipo_medida objETM) {
        
        try
        {
            String SQL="CALL USP_U_Tipo_medida (?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objETM.getIdTipo_medida());
            st.setString(2, objETM.getDescripcion());
            
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

    public boolean MtdEliminarTipo_medida(ClsETipo_medida objETM) {
        try
        {
            
            String SQL="CALL USP_D_Tipo_medida(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objETM.getIdTipo_medida());
            
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

    public Iterable<ClsETipo_medida> MtdListarTipo_medida() {
        
        try
        {
            String SQL="CALL USP_S_Tipo_medida";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsETipo_medida> lista=new ArrayList<>();
            ClsETipo_medida tdoc;
            
            while (resultado.next())
            {
                tdoc = new ClsETipo_medida();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                tdoc.setIdTipo_medida(resultado.getInt("idTipo_medida"));
                tdoc.setDescripcion(resultado.getString("descripcion"));
                
                lista.add(tdoc);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsETipo_medida> MtdBuscarTipo_medida(ClsETipo_medida objETM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
