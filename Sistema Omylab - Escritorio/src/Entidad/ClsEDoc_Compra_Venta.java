/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Date;
/**
 *
 * @author Mathius
 */
public class ClsEDoc_Compra_Venta {

    int idDoc_compra_venta;
    String nro_documento;
    String razon_social;
    String fecha;
    String tipo;
    double total;
    int estado;
    int idTipo_documento;
    int idOrden;
    String Proveedor_nro_documento;
    
    public int getIdDoc_compra_venta() {
        return idDoc_compra_venta;
    }

    public void setIdDoc_compra_venta(int idDoc_compra_venta) {
        this.idDoc_compra_venta = idDoc_compra_venta;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
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

    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdTipo_documento() {
        return idTipo_documento;
    }

    public void setIdTipo_documento(int idTipo_documento) {
        this.idTipo_documento = idTipo_documento;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getProveedor_nro_documento() {
        return Proveedor_nro_documento;
    }

    public void setProveedor_nro_documento(String Proveedor_nro_documento) {
        this.Proveedor_nro_documento = Proveedor_nro_documento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    
    
           
}
