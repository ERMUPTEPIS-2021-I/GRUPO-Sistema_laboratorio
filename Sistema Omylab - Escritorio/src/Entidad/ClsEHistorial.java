/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Calendar;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsEHistorial {
    int idHistorial;
    String fecha;
    String tipo;
    String accion;
    String nro_doc;

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getNro_doc() {
        return nro_doc;
    }

    public void setNro_doc(String nro_doc) {
        this.nro_doc = nro_doc;
    }

    
    
}
