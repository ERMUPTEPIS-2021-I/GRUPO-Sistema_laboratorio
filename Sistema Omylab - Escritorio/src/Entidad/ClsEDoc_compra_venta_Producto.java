/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Mathius
 */
public class ClsEDoc_compra_venta_Producto {

    int idDoc_compra_venta;
    int idProducto;
    double precio_compra;
    int cantidad;
    
    public int getIdDoc_compra_venta() {
        return idDoc_compra_venta;
    }

    public void setIdDoc_compra_venta(int idDoc_compra_venta) {
        this.idDoc_compra_venta = idDoc_compra_venta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
