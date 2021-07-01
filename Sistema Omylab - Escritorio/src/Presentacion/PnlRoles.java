/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Entidad.ClsEEmpleado;
import Entidad.ClsEMarca;
import Entidad.ClsEProveedor;
import Entidad.*;
import Negocios.ClsNEmpleado;
import Negocios.ClsNMarca;
import Negocios.ClsNProveedor;
import Negocios.*;
import static Presentacion.PnlCliente.ListarCliente;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Brian Anco
 */
public class PnlRoles extends javax.swing.JPanel {

    /**
     * Creates new form PnlOrdenes
     */
    public PnlRoles() {
        initComponents();
        ListarRoles();
        Limpiar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanel1 = new necesario.RSPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRol = new javax.swing.JTextField();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEditar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnLimpiar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblRoles = new javax.swing.JTable();
        lblIdRol = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        chkClientes = new javax.swing.JCheckBox();
        chkOrdenes = new javax.swing.JCheckBox();
        chkResultados = new javax.swing.JCheckBox();
        chkAnalisis = new javax.swing.JCheckBox();
        chkCompras = new javax.swing.JCheckBox();
        chkMantenimiento = new javax.swing.JCheckBox();
        chkProveedores = new javax.swing.JCheckBox();
        chkEmpleados = new javax.swing.JCheckBox();
        chkReportes = new javax.swing.JCheckBox();
        chkRoles = new javax.swing.JCheckBox();
        chkHistorial = new javax.swing.JCheckBox();
        chkAlmacen = new javax.swing.JCheckBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanel1.setColorBackground(new java.awt.Color(255, 255, 255));
        rSPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(235, 73, 51));
        jLabel1.setText("GESTIONAR ROLES Y PERMISOS");
        rSPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");
        rSPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        txtRol.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRol.setPreferredSize(new java.awt.Dimension(150, 28));
        txtRol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRolKeyTyped(evt);
            }
        });
        rSPanel1.add(txtRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, -1));

        btnGuardar.setBackground(new java.awt.Color(56, 171, 38));
        btnGuardar.setBackgroundHover(new java.awt.Color(56, 178, 72));
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        rSPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 30, 28));

        btnEditar.setBackground(new java.awt.Color(254, 221, 14));
        btnEditar.setBackgroundHover(new java.awt.Color(254, 218, 75));
        btnEditar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        rSPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 30, 28));

        btnLimpiar.setBackground(new java.awt.Color(0, 153, 153));
        btnLimpiar.setBackgroundHover(new java.awt.Color(153, 204, 255));
        btnLimpiar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BACKSPACE);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        rSPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 30, 28));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(237, 125, 52));
        jLabel14.setText("Asignación de Permisos");
        rSPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        tblRoles.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRoles.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblRoles);
        if (tblRoles.getColumnModel().getColumnCount() > 0) {
            tblRoles.getColumnModel().getColumn(0).setResizable(false);
            tblRoles.getColumnModel().getColumn(1).setResizable(false);
            tblRoles.getColumnModel().getColumn(1).setPreferredWidth(139);
        }

        rSPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 220, 290));

        lblIdRol.setBackground(new java.awt.Color(0, 0, 0));
        lblIdRol.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdRol.setForeground(new java.awt.Color(255, 255, 255));
        lblIdRol.setText("0");
        rSPanel1.add(lblIdRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 60, 40));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(237, 125, 52));
        jLabel15.setText("Gestionar Roles");
        rSPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        chkClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkClientes.setText("Clientes");
        chkClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkClientesActionPerformed(evt);
            }
        });
        rSPanel1.add(chkClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 170, -1));

        chkOrdenes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkOrdenes.setText("Órdenes");
        chkOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOrdenesActionPerformed(evt);
            }
        });
        rSPanel1.add(chkOrdenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 170, -1));

        chkResultados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkResultados.setText("Resultados");
        chkResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkResultadosActionPerformed(evt);
            }
        });
        rSPanel1.add(chkResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 170, -1));

        chkAnalisis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkAnalisis.setText("Análisis");
        chkAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAnalisisActionPerformed(evt);
            }
        });
        rSPanel1.add(chkAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 170, -1));

        chkCompras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkCompras.setText("Compras/Ventas");
        chkCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkComprasActionPerformed(evt);
            }
        });
        rSPanel1.add(chkCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 170, -1));

        chkMantenimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkMantenimiento.setText("Mantenimiento");
        chkMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMantenimientoActionPerformed(evt);
            }
        });
        rSPanel1.add(chkMantenimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 170, -1));

        chkProveedores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkProveedores.setText("Proveedores");
        chkProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkProveedoresActionPerformed(evt);
            }
        });
        rSPanel1.add(chkProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 170, -1));

        chkEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkEmpleados.setText("Empleados");
        chkEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEmpleadosActionPerformed(evt);
            }
        });
        rSPanel1.add(chkEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 170, -1));

        chkReportes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkReportes.setText("Reportes");
        chkReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkReportesActionPerformed(evt);
            }
        });
        rSPanel1.add(chkReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 170, -1));

        chkRoles.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkRoles.setText("Roles/Permisos");
        chkRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkRolesActionPerformed(evt);
            }
        });
        rSPanel1.add(chkRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 170, -1));

        chkHistorial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkHistorial.setText("Historial");
        chkHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHistorialActionPerformed(evt);
            }
        });
        rSPanel1.add(chkHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 170, -1));

        chkAlmacen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkAlmacen.setText("Almacen");
        chkAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAlmacenActionPerformed(evt);
            }
        });
        rSPanel1.add(chkAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 170, -1));

        add(rSPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 570));
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ClsNRol objNR=new ClsNRol();
        ClsERol objER=new ClsERol();
        ClsNRol_Permiso objNRP=new ClsNRol_Permiso();
        ClsERol_Permiso objERP=new ClsERol_Permiso();
        objER.setDescripcion(txtRol.getText());
        if(objNR.MtdRegistrarRol(objER)==true){
            //FOR para extraer el ID del Rol creado
            for(ClsERol objE:objNR.MtdListarRol()){
                if(objE.getDescripcion().equals(txtRol.getText())){
                    lblIdRol.setText(objE.getIdRol()+"");
                }
            }
            //FOR para ELIMINAR todos los permisos del rol existentes previamente.
            for(int i=1;i<=11;i++){
            objERP.setIdPermiso(i);
            objERP.setIdRol(Integer.parseInt(lblIdRol.getText()));
            if(objNRP.MtdEliminarRol_Permiso(objERP)==true){
            }
            else{
            }
            }
            objERP.setIdRol(Integer.parseInt(lblIdRol.getText()));
            if(chkOrdenes.isSelected()){
                objERP.setIdPermiso(1);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkResultados.isSelected()){
                objERP.setIdPermiso(2);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkAnalisis.isSelected()){
                objERP.setIdPermiso(3);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkClientes.isSelected()){
                objERP.setIdPermiso(4);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkEmpleados.isSelected()){
                objERP.setIdPermiso(5);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkProveedores.isSelected()){
                objERP.setIdPermiso(6);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkMantenimiento.isSelected()){
                objERP.setIdPermiso(7);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkCompras.isSelected()){
                objERP.setIdPermiso(8);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkReportes.isSelected()){
                objERP.setIdPermiso(9);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkRoles.isSelected()){
                objERP.setIdPermiso(10);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                   // JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkHistorial.isSelected()){
                objERP.setIdPermiso(11);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkAlmacen.isSelected()){
                objERP.setIdPermiso(12);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            JOptionPane.showMessageDialog(null, "Rol creado correctamente, permisos asignados correctamente.");
            ListarRoles();
            ListarPermisos(0+"");
        }
        else{
            JOptionPane.showMessageDialog(null, "Error al registrar rol.");
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtRolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRolKeyTyped
        // TODO add your handling code here:
        if (txtRol.getText().length()== 12) 
            evt.consume(); 
    }//GEN-LAST:event_txtRolKeyTyped

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        ClsNRol objNR=new ClsNRol();
        ClsERol objER=new ClsERol();
        ClsNRol_Permiso objNRP=new ClsNRol_Permiso();
        ClsERol_Permiso objERP=new ClsERol_Permiso();
        objER.setIdRol(Integer.parseInt(lblIdRol.getText()));
        objER.setDescripcion(txtRol.getText());
        if(objNR.MtdModificarRol(objER)==true){
            
            //FOR para ELIMINAR todos los permisos del rol existentes previamente.
            for(int i=1;i<=11;i++){
            objERP.setIdPermiso(i);
            objERP.setIdRol(Integer.parseInt(lblIdRol.getText()));
            if(objNRP.MtdEliminarRol_Permiso(objERP)==true){
            }
            else{
            }
            }
            objERP.setIdRol(Integer.parseInt(lblIdRol.getText()));
            if(chkOrdenes.isSelected()){
                objERP.setIdPermiso(1);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkResultados.isSelected()){
                objERP.setIdPermiso(2);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkAnalisis.isSelected()){
                objERP.setIdPermiso(3);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                   // JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkClientes.isSelected()){
                objERP.setIdPermiso(4);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkEmpleados.isSelected()){
                objERP.setIdPermiso(5);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkProveedores.isSelected()){
                objERP.setIdPermiso(6);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkMantenimiento.isSelected()){
                objERP.setIdPermiso(7);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkCompras.isSelected()){
                objERP.setIdPermiso(8);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkReportes.isSelected()){
                objERP.setIdPermiso(9);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkRoles.isSelected()){
                objERP.setIdPermiso(10);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkHistorial.isSelected()){
                objERP.setIdPermiso(11);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            if(chkAlmacen.isSelected()){
                objERP.setIdPermiso(12);
                if(objNRP.MtdRegistrarRol_Permiso(objERP)==true){
                }
                else{
                    //JOptionPane.showMessageDialog(null, "Error al asignar permiso al rol.");
                }
            }
            JOptionPane.showMessageDialog(null, "Rol modificado correctamente, permisos asignados correctamente.");
            ListarRoles();
            ListarPermisos(0+"");
        }
        else{
            JOptionPane.showMessageDialog(null, "Error al registrar rol.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRolesMouseClicked
        int seleccionar=tblRoles.rowAtPoint(evt.getPoint());
        lblIdRol.setText(String.valueOf(tblRoles.getValueAt(seleccionar, 0)));
        txtRol.setText(String.valueOf(tblRoles.getValueAt(seleccionar, 1)));
        ListarPermisos(lblIdRol.getText());
    }//GEN-LAST:event_tblRolesMouseClicked

    private void chkClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkClientesActionPerformed

    private void chkOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOrdenesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkOrdenesActionPerformed

    private void chkResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkResultadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkResultadosActionPerformed

    private void chkAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAnalisisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAnalisisActionPerformed

    private void chkComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkComprasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkComprasActionPerformed

    private void chkMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkMantenimientoActionPerformed

    private void chkProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkProveedoresActionPerformed

    private void chkEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEmpleadosActionPerformed

    private void chkReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkReportesActionPerformed

    private void chkRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkRolesActionPerformed

    private void chkHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkHistorialActionPerformed

    private void chkAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAlmacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAlmacenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnLimpiar;
    private javax.swing.JCheckBox chkAlmacen;
    private javax.swing.JCheckBox chkAnalisis;
    private javax.swing.JCheckBox chkClientes;
    private javax.swing.JCheckBox chkCompras;
    private javax.swing.JCheckBox chkEmpleados;
    private javax.swing.JCheckBox chkHistorial;
    private javax.swing.JCheckBox chkMantenimiento;
    private javax.swing.JCheckBox chkOrdenes;
    private javax.swing.JCheckBox chkProveedores;
    private javax.swing.JCheckBox chkReportes;
    private javax.swing.JCheckBox chkResultados;
    private javax.swing.JCheckBox chkRoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblIdRol;
    private necesario.RSPanel rSPanel1;
    private static javax.swing.JTable tblRoles;
    private javax.swing.JTextField txtRol;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
        txtRol.setText("");
        lblIdRol.setText("0");
        ListarRoles();
        ListarPermisos("0");
    }
    
    private void ListarRoles(){
        DefaultTableModel modelo = (DefaultTableModel) tblRoles.getModel();
        try {
            int filas=tblRoles.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
        ClsNRol objNC=new ClsNRol();
        String[] datos=new String[4];
        for(ClsERol objE:objNC.MtdListarRol()){
            datos[0]=String.valueOf(objE.getIdRol());
            datos[1]=objE.getDescripcion();
            modelo.addRow(datos);
        }
        TableRowSorter<TableModel> Id = new TableRowSorter<TableModel>(modelo);
        tblRoles.setRowSorter(Id);
        tblRoles.getRowSorter().toggleSortOrder(0);
    }
    
    private void ListarPermisos(String IdRol){
        chkOrdenes.setSelected(false);
        chkResultados.setSelected(false);
        chkAnalisis.setSelected(false);
        chkClientes.setSelected(false);
        chkEmpleados.setSelected(false);
        chkProveedores.setSelected(false);
        chkMantenimiento.setSelected(false);
        chkCompras.setSelected(false);
        chkReportes.setSelected(false);
        chkRoles.setSelected(false);
        chkHistorial.setSelected(false);
        chkAlmacen.setSelected(false);
        ClsNRol_Permiso objNC=new ClsNRol_Permiso();
        String[] datos=new String[4];
        for(ClsERol_Permiso objE:objNC.MtdListarRol_Permiso()){
            if(objE.getIdRol()==Integer.parseInt(IdRol)){
                if(objE.getIdPermiso()==1){
                    chkOrdenes.setSelected(true);
                }
                if(objE.getIdPermiso()==2){
                    chkResultados.setSelected(true);
                }
                if(objE.getIdPermiso()==3){
                    chkAnalisis.setSelected(true);
                }
                if(objE.getIdPermiso()==4){
                    chkClientes.setSelected(true);
                }
                if(objE.getIdPermiso()==5){
                    chkEmpleados.setSelected(true);
                }
                if(objE.getIdPermiso()==6){
                    chkProveedores.setSelected(true);
                }
                if(objE.getIdPermiso()==7){
                    chkMantenimiento.setSelected(true);
                }
                if(objE.getIdPermiso()==8){
                    chkCompras.setSelected(true);
                }
                if(objE.getIdPermiso()==9){
                    chkReportes.setSelected(true);
                }
                if(objE.getIdPermiso()==10){
                    chkRoles.setSelected(true);
                }
                if(objE.getIdPermiso()==11){
                    chkHistorial.setSelected(true);
                }
                if(objE.getIdPermiso()==12){
                    chkAlmacen.setSelected(true);
                }
            }
        }

    }

}