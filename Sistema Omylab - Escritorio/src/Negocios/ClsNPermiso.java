/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEPermiso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsNPermiso {
    public static boolean MtdRegistrarPermiso(ClsEPermiso objEP) {
        
        try
        {
            String SQL="CALL USP_I_Permiso(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objEP.getDescripcion());
            
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

    public boolean MtdModificarPermiso(ClsEPermiso objEP) {
        
        try
        {
            String SQL="CALL USP_U_Permiso (?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objEP.getIdPermiso());
            st.setString(2, objEP.getDescripcion());
            
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

    public boolean MtdEliminarPermiso(ClsEPermiso objEP) {
        try
        {
            
            String SQL="CALL USP_D_Permiso(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEP.getIdPermiso());
            
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

    public Iterable<ClsEPermiso> MtdListarPermiso() {
        
        try
        {
            String SQL="CALL USP_S_Permiso";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEPermiso> lista=new ArrayList<>();
            ClsEPermiso muestra;
            
            while (resultado.next())
            {
                muestra = new ClsEPermiso();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                muestra.setIdPermiso(resultado.getInt("idPermiso"));
                muestra.setDescripcion(resultado.getString("descripcion"));
                
                lista.add(muestra);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEPermiso> MtdBuscarPermiso(ClsEPermiso objEP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
