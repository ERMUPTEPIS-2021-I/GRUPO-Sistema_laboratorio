/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEMuestra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsNMuestra {
    public static boolean MtdRegistrarMuestra(ClsEMuestra objEM) {
        
        try
        {
            String SQL="CALL USP_I_Muestra(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objEM.getDescripcion());
            
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

    public boolean MtdModificarMuestra(ClsEMuestra objEM) {
        
        try
        {
            String SQL="CALL USP_U_Muestra (?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objEM.getIdMuestra());
            st.setString(2, objEM.getDescripcion());
            
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

    public boolean MtdEliminarMuestra(ClsEMuestra objEM) {
        try
        {
            
            String SQL="CALL USP_D_Muestra(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEM.getIdMuestra());
            
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

    public Iterable<ClsEMuestra> MtdListarMuestra() {
        
        try
        {
            String SQL="CALL USP_S_Muestra";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEMuestra> lista=new ArrayList<>();
            ClsEMuestra muestra;
            
            while (resultado.next())
            {
                muestra = new ClsEMuestra();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                muestra.setIdMuestra(resultado.getInt("idMuestra"));
                muestra.setDescripcion(resultado.getString("descripcion"));
                
                lista.add(muestra);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEMuestra> MtdBuscarMuestra(ClsEMuestra objEM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
