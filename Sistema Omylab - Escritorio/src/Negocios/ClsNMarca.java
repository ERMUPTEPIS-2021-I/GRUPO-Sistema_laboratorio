/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEMarca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsNMarca {
     public static boolean MtdRegistrarMarca(ClsEMarca objEM) {
        
        try
        {
            String SQL="CALL USP_I_Marca(?)";
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

    public boolean MtdModificarMarca(ClsEMarca objEM) {
        
        try
        {
            String SQL="CALL USP_U_Marca (?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objEM.getIdMarca());
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

    public boolean MtdEliminarMarca(ClsEMarca objEM) {
        try
        {
            
            String SQL="CALL USP_D_Marca(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEM.getIdMarca());
            
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

    public Iterable<ClsEMarca> MtdListarMarca() {
        
        try
        {
            String SQL="CALL USP_S_Marca";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEMarca> lista=new ArrayList<>();
            ClsEMarca muestra;
            
            while (resultado.next())
            {
                muestra = new ClsEMarca();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                muestra.setIdMarca(resultado.getInt("idMarca"));
                muestra.setDescripcion(resultado.getString("descripcion"));
                
                lista.add(muestra);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEMarca> MtdBuscarMarca(ClsEMarca objEM) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
