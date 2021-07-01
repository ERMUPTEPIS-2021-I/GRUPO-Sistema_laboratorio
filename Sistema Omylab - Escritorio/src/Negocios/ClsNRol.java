/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsERol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsNRol {
    public static boolean MtdRegistrarRol(ClsERol objER) {
        
        try
        {
            String SQL="CALL USP_I_Rol(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objER.getDescripcion());
            
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

    public boolean MtdModificarRol(ClsERol objER) {
        
        try
        {
            String SQL="CALL USP_U_Rol (?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objER.getIdRol());
            st.setString(2, objER.getDescripcion());
            
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

    public boolean MtdEliminarRol(ClsERol objER) {
        try
        {
            
            String SQL="CALL USP_D_Rol(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objER.getIdRol());
            
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

    public Iterable<ClsERol> MtdListarRol() {
        
        try
        {
            String SQL="CALL USP_S_Rol";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsERol> lista=new ArrayList<>();
            ClsERol muestra;
            
            while (resultado.next())
            {
                muestra = new ClsERol();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                muestra.setIdRol(resultado.getInt("idRol"));
                muestra.setDescripcion(resultado.getString("descripcion"));
                
                lista.add(muestra);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsERol> MtdBuscarRol(ClsERol objER) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
