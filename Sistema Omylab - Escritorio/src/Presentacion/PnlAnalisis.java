/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import Entidad.*;
import Negocios.*;
import static Presentacion.FrmPrincipal.lblApellidos;
import static Presentacion.FrmPrincipal.lblDni;
import static Presentacion.FrmPrincipal.lblNombres;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Brian Anco
 */
public class PnlAnalisis extends javax.swing.JPanel {

    /**
     * Creates new form PnlOrdenes
     */
    public PnlAnalisis() {
        initComponents();
        ListarAnalisis();
        ListarProductos();
    }
    
    public static void ListarAnalisis(){
        DefaultTableModel modelo = (DefaultTableModel) tblAnalisis.getModel();
        try {
            int filas=tblAnalisis.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
        ClsNAnalisis objNC=new ClsNAnalisis();
        String[] datos=new String[4];
        for(ClsEAnalisis objE:objNC.MtdListarAnalisis()){
            datos[0]=String.valueOf(objE.getIdAnalisis());
            datos[1]=objE.getNombre();
            datos[2]=String.valueOf(objE.getCosto());
            if(objE.getEstado()==1){
                datos[3]="Activo";
            }
            else{
                datos[3]="Inactivo";
            }
            modelo.addRow(datos);
        }
        TableRowSorter<TableModel> Id = new TableRowSorter<TableModel>(modelo);
        tblAnalisis.setRowSorter(Id);
        tblAnalisis.getRowSorter().toggleSortOrder(0);
        txtNombreAnalisis.setText("");
        cboEstadoAnalisis.setSelectedIndex(0);
        txtCostoAnalisis.setText("");
        txtNombreAnalisis.setText("");
        txtCantidadProductos.setText("");
        txtMinimoReferenciales.setText("");
        txtMaximoReferenciales.setText("");
        txtEdadMinima.setText("");
        txtEdadMaxima.setText("");
        cboSexoReferenciales.setSelectedIndex(0);
        
    }
    
    public static void ListarProductos(){
        DefaultTableModel modelo = (DefaultTableModel) tblProductosGeneral.getModel();
        try {
            int filas=tblProductosGeneral.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
        ClsNProducto objNC=new ClsNProducto();
        ClsNTipo_medida objNT=new ClsNTipo_medida();
        String[] datos=new String[4];
        for(ClsEProducto objE:objNC.MtdListarProducto()){
            datos[0]=String.valueOf(objE.getIdProducto());
            datos[1]=objE.getDescripcion();
            datos[2]=String.valueOf(objE.getCantidad());
            for(ClsETipo_medida objT:objNT.MtdListarTipo_medida()){
                if(objE.getIdTipo_medida()==objT.getIdTipo_medida()){
                    datos[2]=datos[2]+" "+objT.getDescripcion();
                }
            }
            modelo.addRow(datos);
        }
        TableRowSorter<TableModel> Id = new TableRowSorter<TableModel>(modelo);
        tblProductosGeneral.setRowSorter(Id);
        tblProductosGeneral.getRowSorter().toggleSortOrder(0);
        txtNombreAnalisis.setText("");
        txtCantidadProductos.setText("");
    }
    
    public static void ListarReferenciales(int IdAnalisis){
        DefaultTableModel modelo = (DefaultTableModel) tblReferenciales.getModel();
        try {
            int filas=tblReferenciales.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
        ClsNValor_referencial objNC=new ClsNValor_referencial();
        String[] datos=new String[8];
        for(ClsEValor_referencial objE:objNC.MtdListarValor_referencial()){
            if(IdAnalisis==objE.getIdAnalisis()){
                datos[0]=String.valueOf(objE.getIdValor_referencial());
                datos[1]=String.valueOf(objE.getValor_min());
                datos[2]=String.valueOf(objE.getValor_max());
                datos[3]=objE.getSexo();
                datos[4]=String.valueOf(objE.getEdad_min());
                datos[5]=String.valueOf(objE.getEdad_max());
                modelo.addRow(datos);
            }
        }
        TableRowSorter<TableModel> Id = new TableRowSorter<TableModel>(modelo);
        tblReferenciales.setRowSorter(Id);
        tblReferenciales.getRowSorter().toggleSortOrder(0);
        txtMinimoReferenciales.setText("");
        txtMaximoReferenciales.setText("");
        txtEdadMinima.setText("");
        txtEdadMaxima.setText("");
        cboSexoReferenciales.setSelectedIndex(0);
    }
    
    public static void ListarDetalleProducto(int IdAnalisis){
        DefaultTableModel modelo = (DefaultTableModel) tblProductosDetalle.getModel();
        try {
            int filas=tblProductosDetalle.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
        ClsNAnalisis_Producto objNC=new ClsNAnalisis_Producto();
        ClsNProducto objNP = new ClsNProducto();
        String[] datos=new String[8];
        for(ClsEAnalisis_Producto objE:objNC.MtdListarAnalisis_Producto()){
            if(IdAnalisis==objE.getIdAnalisis()){
                datos[0]=String.valueOf(objE.getIdProducto());
                for(ClsEProducto objEP:objNP.MtdListarProducto()){
                    if(datos[0].equals(String.valueOf(objEP.getIdProducto()))){
                        datos[1]=objEP.getDescripcion();
                    }
                }
                datos[2]=String.valueOf(objE.getCantidad());
                modelo.addRow(datos);
            }
        }
        TableRowSorter<TableModel> Id = new TableRowSorter<TableModel>(modelo);
        tblProductosDetalle.setRowSorter(Id);
        tblProductosDetalle.getRowSorter().toggleSortOrder(0);
        txtNombreProductos.setText("");
        txtCantidadProductos.setText("");
        
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
        lblIdAnalisis = new javax.swing.JLabel();
        txtNombreAnalisis = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboEstadoAnalisis = new javax.swing.JComboBox<>();
        txtCostoAnalisis = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAnalisis = new javax.swing.JTable();
        btnGuardarAnalisis = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEditarAnalisis = new RSMaterialComponent.RSButtonMaterialIconOne();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblReferenciales = new javax.swing.JTable();
        txtNombreProductos = new javax.swing.JTextField();
        txtCantidadProductos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMinimoReferenciales = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtMaximoReferenciales = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtEdadMinima = new javax.swing.JTextField();
        txtEdadMaxima = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cboSexoReferenciales = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnEliminarReferenciales = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEditarReferenciales = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardarReferenciales = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardarProductos = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEditarProductos = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnRetirarProductos = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblIdProducto = new javax.swing.JLabel();
        lblIdReferenciales = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblProductosDetalle = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblProductosGeneral = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanel1.setColorBackground(new java.awt.Color(255, 255, 255));
        rSPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(235, 73, 51));
        jLabel1.setText("GESTIONAR ANÁLISIS");
        rSPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        lblIdAnalisis.setBackground(new java.awt.Color(0, 0, 0));
        lblIdAnalisis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdAnalisis.setForeground(new java.awt.Color(255, 255, 255));
        lblIdAnalisis.setText("0");
        rSPanel1.add(lblIdAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        txtNombreAnalisis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombreAnalisis.setPreferredSize(new java.awt.Dimension(150, 28));
        rSPanel1.add(txtNombreAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 230, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Estado");
        rSPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        cboEstadoAnalisis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboEstadoAnalisis.setForeground(new java.awt.Color(0, 0, 0));
        cboEstadoAnalisis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cboEstadoAnalisis.setPreferredSize(new java.awt.Dimension(93, 28));
        rSPanel1.add(cboEstadoAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 100, -1));

        txtCostoAnalisis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCostoAnalisis.setPreferredSize(new java.awt.Dimension(150, 28));
        rSPanel1.add(txtCostoAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 60, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Costo");
        rSPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, -1, -1));

        tblAnalisis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblAnalisis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Costo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAnalisis.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblAnalisis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAnalisisMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAnalisis);
        if (tblAnalisis.getColumnModel().getColumnCount() > 0) {
            tblAnalisis.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblAnalisis.getColumnModel().getColumn(1).setPreferredWidth(184);
            tblAnalisis.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblAnalisis.getColumnModel().getColumn(3).setPreferredWidth(65);
        }

        rSPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 350, 180));

        btnGuardarAnalisis.setBackground(new java.awt.Color(56, 171, 38));
        btnGuardarAnalisis.setBackgroundHover(new java.awt.Color(56, 178, 72));
        btnGuardarAnalisis.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardarAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAnalisisActionPerformed(evt);
            }
        });
        rSPanel1.add(btnGuardarAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 30, 28));

        btnEditarAnalisis.setBackground(new java.awt.Color(254, 221, 14));
        btnEditarAnalisis.setBackgroundHover(new java.awt.Color(254, 218, 75));
        btnEditarAnalisis.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAnalisisActionPerformed(evt);
            }
        });
        rSPanel1.add(btnEditarAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 30, 28));

        tblReferenciales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblReferenciales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Val. Mín.", "Val. Máx.", "Sexo", "Edad Mín.", "Edad Máx."
            }
        ));
        tblReferenciales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReferencialesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblReferenciales);
        if (tblReferenciales.getColumnModel().getColumnCount() > 0) {
            tblReferenciales.getColumnModel().getColumn(0).setPreferredWidth(25);
            tblReferenciales.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        rSPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 380, 120));

        txtNombreProductos.setEditable(false);
        txtNombreProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombreProductos.setPreferredSize(new java.awt.Dimension(150, 28));
        rSPanel1.add(txtNombreProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 200, -1));

        txtCantidadProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCantidadProductos.setPreferredSize(new java.awt.Dimension(150, 28));
        rSPanel1.add(txtCantidadProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 50, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("-");
        rSPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 20, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Nombre");
        rSPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, -1, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(237, 125, 52));
        jLabel12.setText("Valores Referenciales");
        rSPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, -1));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(237, 125, 52));
        jLabel14.setText("Lista de Análisis");
        rSPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(237, 125, 52));
        jLabel15.setText("Productos Utilizados");
        rSPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, -1, -1));

        txtMinimoReferenciales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMinimoReferenciales.setPreferredSize(new java.awt.Dimension(150, 28));
        rSPanel1.add(txtMinimoReferenciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 110, -1));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Valor Mínimo");
        rSPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, -1, -1));

        txtMaximoReferenciales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaximoReferenciales.setPreferredSize(new java.awt.Dimension(150, 28));
        rSPanel1.add(txtMaximoReferenciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, 110, -1));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Valor Máximo");
        rSPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, -1, -1));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Edad Mínima");
        rSPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 480, -1, -1));

        txtEdadMinima.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEdadMinima.setPreferredSize(new java.awt.Dimension(150, 28));
        rSPanel1.add(txtEdadMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, 40, -1));

        txtEdadMaxima.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEdadMaxima.setPreferredSize(new java.awt.Dimension(150, 28));
        rSPanel1.add(txtEdadMaxima, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 510, 40, -1));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Edad Máxima");
        rSPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 520, -1, -1));

        cboSexoReferenciales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboSexoReferenciales.setForeground(new java.awt.Color(0, 0, 0));
        cboSexoReferenciales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cboSexoReferenciales.setPreferredSize(new java.awt.Dimension(93, 28));
        rSPanel1.add(cboSexoReferenciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 470, 100, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Sexo");
        rSPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 480, -1, -1));

        btnEliminarReferenciales.setBackground(new java.awt.Color(210, 0, 0));
        btnEliminarReferenciales.setBackgroundHover(new java.awt.Color(219, 35, 48));
        btnEliminarReferenciales.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminarReferenciales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarReferencialesActionPerformed(evt);
            }
        });
        rSPanel1.add(btnEliminarReferenciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 520, 30, 28));

        btnEditarReferenciales.setBackground(new java.awt.Color(254, 221, 14));
        btnEditarReferenciales.setBackgroundHover(new java.awt.Color(254, 218, 75));
        btnEditarReferenciales.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarReferenciales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarReferencialesActionPerformed(evt);
            }
        });
        rSPanel1.add(btnEditarReferenciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 520, 30, 28));

        btnGuardarReferenciales.setBackground(new java.awt.Color(56, 171, 38));
        btnGuardarReferenciales.setBackgroundHover(new java.awt.Color(56, 178, 72));
        btnGuardarReferenciales.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardarReferenciales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarReferencialesActionPerformed(evt);
            }
        });
        rSPanel1.add(btnGuardarReferenciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 520, 30, 28));

        btnGuardarProductos.setBackground(new java.awt.Color(56, 171, 38));
        btnGuardarProductos.setBackgroundHover(new java.awt.Color(56, 178, 72));
        btnGuardarProductos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProductosActionPerformed(evt);
            }
        });
        rSPanel1.add(btnGuardarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, 30, 28));

        btnEditarProductos.setBackground(new java.awt.Color(254, 221, 14));
        btnEditarProductos.setBackgroundHover(new java.awt.Color(254, 218, 75));
        btnEditarProductos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductosActionPerformed(evt);
            }
        });
        rSPanel1.add(btnEditarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 30, 28));

        btnRetirarProductos.setBackground(new java.awt.Color(210, 0, 0));
        btnRetirarProductos.setBackgroundHover(new java.awt.Color(219, 35, 48));
        btnRetirarProductos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnRetirarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarProductosActionPerformed(evt);
            }
        });
        rSPanel1.add(btnRetirarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 30, 28));

        jPanel2.setBackground(new java.awt.Color(244, 146, 34));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        rSPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 415, 1010, 2));

        jPanel1.setBackground(new java.awt.Color(244, 146, 34));

        jPanel3.setBackground(new java.awt.Color(244, 146, 34));

        jPanel4.setBackground(new java.awt.Color(244, 146, 34));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(318, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        rSPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 80, 2, 335));

        lblIdProducto.setBackground(new java.awt.Color(0, 0, 0));
        lblIdProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblIdProducto.setText("idAnalisis");
        rSPanel1.add(lblIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, -1, -1));

        lblIdReferenciales.setBackground(new java.awt.Color(0, 0, 0));
        lblIdReferenciales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdReferenciales.setForeground(new java.awt.Color(255, 255, 255));
        lblIdReferenciales.setText("idAnalisis");
        rSPanel1.add(lblIdReferenciales, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, -1, -1));

        tblProductosDetalle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblProductosDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductosDetalle.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblProductosDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosDetalleMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblProductosDetalle);
        if (tblProductosDetalle.getColumnModel().getColumnCount() > 0) {
            tblProductosDetalle.getColumnModel().getColumn(0).setResizable(false);
            tblProductosDetalle.getColumnModel().getColumn(0).setPreferredWidth(25);
            tblProductosDetalle.getColumnModel().getColumn(1).setPreferredWidth(154);
            tblProductosDetalle.getColumnModel().getColumn(2).setResizable(false);
        }

        rSPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 260, 180));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(237, 125, 52));
        jLabel20.setText("Todos los Productos");
        rSPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, -1, -1));

        tblProductosGeneral.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblProductosGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductosGeneral.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblProductosGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosGeneralMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblProductosGeneral);
        if (tblProductosGeneral.getColumnModel().getColumnCount() > 0) {
            tblProductosGeneral.getColumnModel().getColumn(0).setResizable(false);
            tblProductosGeneral.getColumnModel().getColumn(0).setPreferredWidth(25);
            tblProductosGeneral.getColumnModel().getColumn(1).setPreferredWidth(154);
            tblProductosGeneral.getColumnModel().getColumn(2).setResizable(false);
        }

        rSPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 260, 180));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Cantidad");
        rSPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nombre");
        rSPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        add(rSPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 570));
    }// </editor-fold>//GEN-END:initComponents

    private void tblAnalisisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAnalisisMouseClicked
        int seleccionar=tblAnalisis.rowAtPoint(evt.getPoint());
        lblIdAnalisis.setText(String.valueOf(tblAnalisis.getValueAt(seleccionar, 0)));
        txtNombreAnalisis.setText(String.valueOf(tblAnalisis.getValueAt(seleccionar, 1)));
        if(tblAnalisis.getValueAt(seleccionar, 3).equals("Activo")){
            cboEstadoAnalisis.setSelectedIndex(0);
        }
        else{
            cboEstadoAnalisis.setSelectedIndex(1);
        }
        txtCostoAnalisis.setText(String.valueOf(tblAnalisis.getValueAt(seleccionar, 2)));
        ListarReferenciales(Integer.parseInt(lblIdAnalisis.getText()));
        ListarDetalleProducto(Integer.parseInt(lblIdAnalisis.getText()));
    }//GEN-LAST:event_tblAnalisisMouseClicked

    private void tblProductosGeneralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosGeneralMouseClicked
        int seleccionar=tblProductosGeneral.rowAtPoint(evt.getPoint());
        lblIdProducto.setText(String.valueOf(tblProductosGeneral.getValueAt(seleccionar, 0)));
        txtNombreProductos.setText(String.valueOf(tblProductosGeneral.getValueAt(seleccionar, 1)));
        
    }//GEN-LAST:event_tblProductosGeneralMouseClicked

    private void tblReferencialesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReferencialesMouseClicked
        int seleccionar=tblReferenciales.rowAtPoint(evt.getPoint());
        lblIdReferenciales.setText(String.valueOf(tblReferenciales.getValueAt(seleccionar, 0)));
        txtMinimoReferenciales.setText(String.valueOf(tblReferenciales.getValueAt(seleccionar, 1)));
        txtMaximoReferenciales.setText(String.valueOf(tblReferenciales.getValueAt(seleccionar, 2)));
        if(String.valueOf(tblReferenciales.getValueAt(seleccionar, 3)).equals("Masculino")){
            cboSexoReferenciales.setSelectedIndex(0);
        }
        else{
            cboSexoReferenciales.setSelectedIndex(1);
        }
        txtEdadMinima.setText(String.valueOf(tblReferenciales.getValueAt(seleccionar, 4)));
        txtEdadMaxima.setText(String.valueOf(tblReferenciales.getValueAt(seleccionar, 5)));
    }//GEN-LAST:event_tblReferencialesMouseClicked

    private void btnGuardarAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAnalisisActionPerformed
        ClsEAnalisis objEC=new ClsEAnalisis();
        ClsNAnalisis objNC=new ClsNAnalisis();

        objEC.setNombre(txtNombreAnalisis.getText());
        objEC.setCosto(Integer.parseInt(txtCostoAnalisis.getText()));
        if(cboEstadoAnalisis.getSelectedIndex()==0){
            objEC.setEstado(1);
        }
        else{
            objEC.setEstado(0);
        }

        if(objNC.MtdRegistrarAnalisis(objEC)==true){
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
            //GUARDAR HISTORIAL - REGISTRAR
            ClsNHistorial objNH=new ClsNHistorial();
            ClsEHistorial objEH = new ClsEHistorial();
            Date date = new Date();
            DateFormat FechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            objEH.setFecha(FechaHora.format(date)+"");
            objEH.setTipo("Insertar Analisis");
            objEH.setAccion(lblNombres.getText()+" "+lblApellidos.getText()+ " registro un Analisis: "+txtNombreAnalisis.getText());
            objEH.setNro_doc(lblDni.getText());
            if(objNH.MtdRegistrarHistorial(objEH)==true){
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al registrar accion.");
            }
            //FIN GUARDAR HISTORIAL - REGISTRAR
        }
        else{
            JOptionPane.showMessageDialog(null, "Error de Datos");
        }
        ListarAnalisis();
        ListarReferenciales(0);
        ListarDetalleProducto(0);
    }//GEN-LAST:event_btnGuardarAnalisisActionPerformed

    private void btnEditarAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAnalisisActionPerformed
        ClsEAnalisis objEC=new ClsEAnalisis();
        ClsNAnalisis objNC=new ClsNAnalisis();

        objEC.setIdAnalisis(Integer.parseInt(lblIdAnalisis.getText()));
        objEC.setNombre(txtNombreAnalisis.getText());
        objEC.setCosto(Float.parseFloat(txtCostoAnalisis.getText()));
        if(cboEstadoAnalisis.getSelectedIndex()==0){
            objEC.setEstado(1);
        }
        else{
            objEC.setEstado(0);
        }

        if(objNC.MtdModificarAnalisis(objEC)==true){
            JOptionPane.showMessageDialog(null, "Datos modificados correctamente.");
            //GUARDAR HISTORIAL - REGISTRAR
            ClsNHistorial objNH=new ClsNHistorial();
            ClsEHistorial objEH = new ClsEHistorial();
            Date date = new Date();
            DateFormat FechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            objEH.setFecha(FechaHora.format(date)+"");
            objEH.setTipo("Modificar Analisis");
            objEH.setAccion(lblNombres.getText()+" "+lblApellidos.getText()+ " modifico un Analisis: "+txtNombreAnalisis.getText());
            objEH.setNro_doc(lblDni.getText());
            if(objNH.MtdRegistrarHistorial(objEH)==true){
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al registrar accion.");
            }
            //FIN GUARDAR HISTORIAL - REGISTRAR
        }
        else{
            JOptionPane.showMessageDialog(null, "Error de Datos");
        }
        ListarAnalisis();
        ListarReferenciales(0);
        ListarDetalleProducto(0);
    }//GEN-LAST:event_btnEditarAnalisisActionPerformed

    private void btnGuardarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductosActionPerformed
        ClsEAnalisis_Producto objEC=new ClsEAnalisis_Producto();
        ClsNAnalisis_Producto objNC=new ClsNAnalisis_Producto();

        objEC.setIdAnalisis(Integer.parseInt(lblIdAnalisis.getText()));
        objEC.setIdProducto(Integer.parseInt(lblIdProducto.getText()));
        objEC.setCantidad(Float.parseFloat(txtCantidadProductos.getText()));

        if(objNC.MtdRegistrarAnalisis_Producto(objEC)==true){
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
        }
        else{
            JOptionPane.showMessageDialog(null, "Error de Datos");
        }

        ListarReferenciales(Integer.parseInt(lblIdAnalisis.getText()));
        ListarDetalleProducto(Integer.parseInt(lblIdAnalisis.getText()));

    }//GEN-LAST:event_btnGuardarProductosActionPerformed

    private void btnEditarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductosActionPerformed
        ClsEAnalisis_Producto objEC=new ClsEAnalisis_Producto();
        ClsNAnalisis_Producto objNC=new ClsNAnalisis_Producto();

        objEC.setIdAnalisis(Integer.parseInt(lblIdAnalisis.getText()));
        objEC.setIdProducto(Integer.parseInt(lblIdProducto.getText()));
        objEC.setCantidad(Float.parseFloat(txtCantidadProductos.getText()));

        if(objNC.MtdModificarAnalisis_Producto(objEC)==true){
            JOptionPane.showMessageDialog(null, "Datos modificados correctamente.");
        }
        else{
            JOptionPane.showMessageDialog(null, "Error de Datos");
        }

        ListarReferenciales(Integer.parseInt(lblIdAnalisis.getText()));
        ListarDetalleProducto(Integer.parseInt(lblIdAnalisis.getText()));
        PnlOrdenes.ListarAnalisis();
        ListarAnalisis();
        ListarReferenciales(0);
        ListarDetalleProducto(0);
        
    }//GEN-LAST:event_btnEditarProductosActionPerformed

    private void tblProductosDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosDetalleMouseClicked
        int seleccionar=tblProductosDetalle.rowAtPoint(evt.getPoint());
        lblIdProducto.setText(String.valueOf(tblProductosDetalle.getValueAt(seleccionar, 0)));
        txtNombreProductos.setText(String.valueOf(tblProductosDetalle.getValueAt(seleccionar, 1)));
        txtCantidadProductos.setText(String.valueOf(tblProductosDetalle.getValueAt(seleccionar, 2)));
    }//GEN-LAST:event_tblProductosDetalleMouseClicked

    private void btnRetirarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarProductosActionPerformed
        ClsEAnalisis_Producto objEC=new ClsEAnalisis_Producto();
        ClsNAnalisis_Producto objNC=new ClsNAnalisis_Producto();

        objEC.setIdAnalisis(Integer.parseInt(lblIdAnalisis.getText()));
        objEC.setIdProducto(Integer.parseInt(lblIdProducto.getText()));

        if(objNC.MtdEliminarAnalisis_Producto(objEC)==true){
            JOptionPane.showMessageDialog(null, "Datos eliminados correctamente.");
            
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Error de datos");
        }
        ListarDetalleProducto(Integer.parseInt(lblIdAnalisis.getText()));
    }//GEN-LAST:event_btnRetirarProductosActionPerformed

    private void btnGuardarReferencialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarReferencialesActionPerformed
        ClsEValor_referencial objEC=new ClsEValor_referencial();
        ClsNValor_referencial objNC=new ClsNValor_referencial();

        try{
            objEC.setValor_min(Float.parseFloat(txtMinimoReferenciales.getText()));
        }
        catch(Exception e){
            objEC.setValor_min(0);
        }
        try{
            objEC.setValor_max(Float.parseFloat(txtMaximoReferenciales.getText()));
        }
        catch(Exception e){
            objEC.setValor_max(0);
        }
        
        if(cboSexoReferenciales.getSelectedIndex()==0){
            objEC.setSexo("Masculino");
        }
        else{
            objEC.setSexo("Femenino");
        }
        try{
            objEC.setEdad_min(Integer.parseInt(txtEdadMinima.getText()));
        }
        catch(Exception e){
            objEC.setEdad_min(0);
        }
        try{
            objEC.setEdad_max(Integer.parseInt(txtEdadMaxima.getText()));
        }
        catch(Exception e){
            objEC.setEdad_max(0);
        }
        
        objEC.setIdAnalisis(Integer.parseInt(lblIdAnalisis.getText()));
        if(objNC.MtdRegistrarValor_referencial(objEC)==true){
            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
            //GUARDAR HISTORIAL - REGISTRAR
            ClsNHistorial objNH=new ClsNHistorial();
            ClsEHistorial objEH = new ClsEHistorial();
            Date date = new Date();
            DateFormat FechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            objEH.setFecha(FechaHora.format(date)+"");
            objEH.setTipo("Insertar Valor Referencial");
            objEH.setAccion(lblNombres.getText()+" "+lblApellidos.getText()+ " registro un Valor Referencial para: "+txtNombreAnalisis.getText());
            objEH.setNro_doc(lblDni.getText());
            if(objNH.MtdRegistrarHistorial(objEH)==true){
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al registrar accion.");
            }
            //FIN GUARDAR HISTORIAL - REGISTRAR
        }
        else{
            JOptionPane.showMessageDialog(null, "Error de Datos");
        }
        ListarReferenciales(Integer.parseInt(lblIdAnalisis.getText()));
        ListarDetalleProducto(Integer.parseInt(lblIdAnalisis.getText()));
    }//GEN-LAST:event_btnGuardarReferencialesActionPerformed

    private void btnEditarReferencialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarReferencialesActionPerformed
        ClsEValor_referencial objEC=new ClsEValor_referencial();
        ClsNValor_referencial objNC=new ClsNValor_referencial();

        objEC.setIdValor_referencial(Integer.parseInt(lblIdReferenciales.getText()));
        try{
            objEC.setValor_min(Float.parseFloat(txtMinimoReferenciales.getText()));
        }
        catch(Exception e){
            objEC.setValor_min(0);
        }
        try{
            objEC.setValor_max(Float.parseFloat(txtMaximoReferenciales.getText()));
        }
        catch(Exception e){
            objEC.setValor_max(0);
        }
        
        if(cboSexoReferenciales.getSelectedIndex()==0){
            objEC.setSexo("Masculino");
        }
        else{
            objEC.setSexo("Femenino");
        }
        try{
            objEC.setEdad_min(Integer.parseInt(txtEdadMinima.getText()));
        }
        catch(Exception e){
            objEC.setEdad_min(0);
        }
        try{
            objEC.setEdad_max(Integer.parseInt(txtEdadMaxima.getText()));
        }
        catch(Exception e){
            objEC.setEdad_max(0);
        }
        objEC.setIdAnalisis(Integer.parseInt(lblIdAnalisis.getText()));
        if(objNC.MtdModificarValor_referencial(objEC)==true){
            JOptionPane.showMessageDialog(null, "Datos modificados correctamente.");
            //GUARDAR HISTORIAL - REGISTRAR
            ClsNHistorial objNH=new ClsNHistorial();
            ClsEHistorial objEH = new ClsEHistorial();
            Date date = new Date();
            DateFormat FechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            objEH.setFecha(FechaHora.format(date)+"");
            objEH.setTipo("Modificar Valor Referencial");
            objEH.setAccion(lblNombres.getText()+" "+lblApellidos.getText()+ " modifico un Valor Referencial para: "+txtNombreAnalisis.getText());
            objEH.setNro_doc(lblDni.getText());
            if(objNH.MtdRegistrarHistorial(objEH)==true){
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al registrar accion.");
            }
            //FIN GUARDAR HISTORIAL - REGISTRAR
        }
        else{
            JOptionPane.showMessageDialog(null, "Error de Datos");
        }
        ListarReferenciales(Integer.parseInt(lblIdAnalisis.getText()));
        ListarDetalleProducto(Integer.parseInt(lblIdAnalisis.getText()));
    }//GEN-LAST:event_btnEditarReferencialesActionPerformed

    private void btnEliminarReferencialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarReferencialesActionPerformed
        ClsEValor_referencial objEC=new ClsEValor_referencial();
        ClsNValor_referencial objNC=new ClsNValor_referencial();

        objEC.setIdValor_referencial(Integer.parseInt(lblIdReferenciales.getText()));;

        if(objNC.MtdEliminarValor_referencial(objEC)==true){
            JOptionPane.showMessageDialog(null, "Datos eliminados correctamente.");
            
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Error de datos");
        }
        ListarReferenciales(Integer.parseInt(lblIdAnalisis.getText()));
        ListarDetalleProducto(Integer.parseInt(lblIdAnalisis.getText()));
    }//GEN-LAST:event_btnEliminarReferencialesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarAnalisis;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarProductos;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarReferenciales;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEliminarReferenciales;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardarAnalisis;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardarProductos;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardarReferenciales;
    private RSMaterialComponent.RSButtonMaterialIconOne btnRetirarProductos;
    private static javax.swing.JComboBox<String> cboEstadoAnalisis;
    private static javax.swing.JComboBox<String> cboSexoReferenciales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private static javax.swing.JLabel lblIdAnalisis;
    private static javax.swing.JLabel lblIdProducto;
    private static javax.swing.JLabel lblIdReferenciales;
    private necesario.RSPanel rSPanel1;
    private static javax.swing.JTable tblAnalisis;
    private static javax.swing.JTable tblProductosDetalle;
    private static javax.swing.JTable tblProductosGeneral;
    private static javax.swing.JTable tblReferenciales;
    private static javax.swing.JTextField txtCantidadProductos;
    private static javax.swing.JTextField txtCostoAnalisis;
    private static javax.swing.JTextField txtEdadMaxima;
    private static javax.swing.JTextField txtEdadMinima;
    private static javax.swing.JTextField txtMaximoReferenciales;
    private static javax.swing.JTextField txtMinimoReferenciales;
    private static javax.swing.JTextField txtNombreAnalisis;
    private static javax.swing.JTextField txtNombreProductos;
    // End of variables declaration//GEN-END:variables
}
