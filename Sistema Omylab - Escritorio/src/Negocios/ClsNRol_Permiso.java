/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsERol_Permiso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsNRol_Permiso {
    public static boolean MtdRegistrarRol_Permiso(ClsERol_Permiso objER) {
        
        try
        {
            String SQL="CALL USP_I_Rol_has_Permiso(?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objER.getIdRol());
            st.setInt(2, objER.getIdPermiso());
            
            
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

    public boolean MtdModificarRol_Permiso(ClsERol_Permiso objER) {
        
        try
        {
            String SQL="CALL USP_U_Rol_has_Permiso (?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objER.getIdRol());
            st.setInt(2, objER.getIdPermiso());
            
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

    public boolean MtdEliminarRol_Permiso(ClsERol_Permiso objER) {
        try
        {
            
            String SQL="CALL USP_D_Rol_has_Permiso(?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objER.getIdRol());
            st.setInt(2, objER.getIdPermiso());
            
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

    public Iterable<ClsERol_Permiso> MtdListarRol_Permiso() {
        
        try
        {
            String SQL="CALL USP_S_Rol_has_Permiso";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsERol_Permiso> lista=new ArrayList<>();
            ClsERol_Permiso muestra;
            
            while (resultado.next())
            {
                muestra = new ClsERol_Permiso();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                muestra.setIdRol(resultado.getInt("idRol"));
                muestra.setIdPermiso(resultado.getInt("idPermiso"));
                
                lista.add(muestra);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsERol_Permiso> MtdBuscarRol_Permiso(ClsERol_Permiso objER) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
