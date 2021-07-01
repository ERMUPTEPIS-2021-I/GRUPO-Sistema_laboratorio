/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsETipo_documento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsNTipo_documento {
   public static boolean MtdRegistrarTipo_documento(ClsETipo_documento objETD) {
        
        try
        {
            String SQL="CALL USP_I_Tipo_documento(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objETD.getDescripcion());
            
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

    public boolean MtdModificarTipo_documento(ClsETipo_documento objETD) {
        
        try
        {
            String SQL="CALL USP_U_Tipo_documento (?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objETD.getIdTipo_documento());
            st.setString(2, objETD.getDescripcion());
            
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

    public boolean MtdEliminarTipo_documento(ClsETipo_documento objETD) {
        try
        {
            
            String SQL="CALL USP_D_Tipo_documento(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objETD.getIdTipo_documento());
            
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

    public Iterable<ClsETipo_documento> MtdListarTipo_documento() {
        
        try
        {
            String SQL="CALL USP_S_Tipo_documento";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsETipo_documento> lista=new ArrayList<>();
            ClsETipo_documento tdoc;
            
            while (resultado.next())
            {
                tdoc = new ClsETipo_documento();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                tdoc.setIdTipo_documento(resultado.getInt("idTipo_documento"));
                tdoc.setDescripcion(resultado.getString("descripcion"));
                
                lista.add(tdoc);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsETipo_documento> MtdBuscarTipo_documento(ClsETipo_documento objETD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
