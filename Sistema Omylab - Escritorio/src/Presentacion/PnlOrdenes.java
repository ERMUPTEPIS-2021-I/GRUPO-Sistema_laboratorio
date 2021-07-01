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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Brian Anco
 */
public class PnlOrdenes extends javax.swing.JPanel {

    /**
     * Creates new form PnlOrdenes
     */
    public PnlOrdenes() {
        initComponents();
        ListarOrdenes();
        ListarAnalisis();
        Date date = new Date();
        DateFormat FechaHora = new SimpleDateFormat("yyyy/MM/dd");
        lblFecha.setText(FechaHora.format(date));
    }
    public static void ListarOrdenAnalisis(int IdOrden){
        DefaultTableModel modelo = (DefaultTableModel) tblAnalisisOrden.getModel();
        try {
            int filas=tblAnalisisOrden.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
        ClsNOrden_Analisis objNC=new ClsNOrden_Analisis();
        ClsNAnalisis objN=new ClsNAnalisis();
        String[] datos=new String[5];
        for(ClsEOrden_Analisis objE:objNC.MtdListarOrden_Analisis()){
            datos[0]=String.valueOf(objE.getIdAnalisis());
            if(objE.getIdOrden()==IdOrden){
                for(ClsEAnalisis objEC:objN.MtdListarAnalisis()){
                if(objEC.getIdAnalisis()==objE.getIdAnalisis()){
                    datos[1]=objEC.getNombre();
                    datos[2]=""+objEC.getCosto();
                }
            }
            modelo.addRow(datos);
            }
        }
        TableRowSorter<TableModel> Id = new TableRowSorter<TableModel>(modelo);
        tblAnalisisOrden.setRowSorter(Id);
        tblAnalisisOrden.getRowSorter().toggleSortOrder(0);
    }
    
    public static void ListarOrdenes(){
        
        DefaultTableModel modelo = (DefaultTableModel) tblOrdenes.getModel();
        try {
            int filas=tblOrdenes.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
        ClsNOrden objNC=new ClsNOrden();
        ClsNCliente objN=new ClsNCliente();
        String[] datos=new String[5];
        for(ClsEOrden objE:objNC.MtdListarOrden()){
            datos[0]=String.valueOf(objE.getIdOrden());
            datos[1]=objE.getCliente_nro_documento();
            for(ClsECliente objEC:objN.MtdListarCliente()){
                if(objEC.getNro_documento().equals(datos[1])){
                    datos[2]=objEC.getNombre();
                    datos[3]=objEC.getApellido();
                }
            }
            datos[4]=String.valueOf(objE.getEstado());
            modelo.addRow(datos);
        }
        TableRowSorter<TableModel> Id = new TableRowSorter<TableModel>(modelo);
        tblOrdenes.setRowSorter(Id);
        tblOrdenes.getRowSorter().toggleSortOrder(0);
        txtNumDocCliente.setText("");
        txtNombresCliente.setText("");
        
        lblIdOrden.setText("0");
        txtNumDocEmpleado.setText("");
        txtNombresEmpleado.setText("");

    }
    public static void VerificarAnalisisDisponibles(){
        ClsNAnalisis objNA = new ClsNAnalisis();
        ClsNAnalisis_Producto objNAP = new ClsNAnalisis_Producto();
        ClsNProducto_detalle objNP = new ClsNProducto_detalle();
        
        ClsEAnalisis objEAnalisis=new ClsEAnalisis();
        ClsNAnalisis objNAnalisis=new ClsNAnalisis();
        double SumaCantidad=0; //Almacena la suma total del producto requerido
                               //para realizar el análisis.
        int Llave=0; //Almacena 0 si el análisis tiene los productos necesarios.
                     //Almacena 1 si el análisis no tiene cualquier producto necesario.
        for(ClsEAnalisis objEA:objNA.MtdListarAnalisis()){
            
            Llave=0;
            for(ClsEAnalisis_Producto objEAP:objNAP.MtdListarAnalisis_Producto()){
                SumaCantidad=0;
                if(objEA.getIdAnalisis()==objEAP.getIdAnalisis()){
                    for(ClsEProducto_detalle objEPD:objNP.MtdListarProducto_detalle()){
                        if(objEAP.getIdProducto()==objEPD.getIdProducto()){
                            SumaCantidad=SumaCantidad+objEPD.getCantidad();
                        }
                    }
                    if(SumaCantidad<objEAP.getCantidad()){
                        Llave=1;
                    }
                    //JOptionPane.showMessageDialog(null,objEA.getNombre()+" Cantidad: "+objEAP.getCantidad()+" Acumulador: "+SumaCantidad+"");
                }
            }
            if(Llave==1){
                objEAnalisis.setIdAnalisis(objEA.getIdAnalisis());
                objEAnalisis.setNombre(objEA.getNombre());
                objEAnalisis.setCosto(objEA.getCosto());
                objEAnalisis.setEstado(0);
                objNAnalisis.MtdModificarAnalisis(objEAnalisis);
                
            }
            else{
                objEAnalisis.setIdAnalisis(objEA.getIdAnalisis());
                objEAnalisis.setNombre(objEA.getNombre());
                objEAnalisis.setCosto(objEA.getCosto());
                objEAnalisis.setEstado(1);
                objNAnalisis.MtdModificarAnalisis(objEAnalisis);
            }
            //JOptionPane.showMessageDialog(null, "La llave de"+ objEA.getNombre()+" terminó en: "+Llave);
        }
        
    }
    
    public static void ListarAnalisis(){
        VerificarAnalisisDisponibles();
        DefaultTableModel modelo = (DefaultTableModel) tblAnalisisGeneral.getModel();
        try {
            int filas=tblAnalisisGeneral.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
        ClsNAnalisis objNC=new ClsNAnalisis();
        String[] datos=new String[5];
        for(ClsEAnalisis objE:objNC.MtdListarAnalisis()){
            if(objE.getEstado()==1){
                datos[0]=String.valueOf(objE.getIdAnalisis());
                datos[1]=objE.getNombre();
                datos[2]=String.valueOf(objE.getCosto());
                modelo.addRow(datos);
            }
        }
        TableRowSorter<TableModel> Id = new TableRowSorter<TableModel>(modelo);
        tblAnalisisGeneral.setRowSorter(Id);
        tblAnalisisGeneral.getRowSorter().toggleSortOrder(0);
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
        lblIdOrden = new javax.swing.JLabel();
        txtNumDocCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumDocEmpleado = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        txtNombresEmpleado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrdenes = new javax.swing.JTable();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnSubir = new RSMaterialComponent.RSButtonMaterialOne();
        btnBajar = new RSMaterialComponent.RSButtonMaterialOne();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEditar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblAnalisisOrden = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtNombresCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCostoTotal = new javax.swing.JLabel();
        btnLimpiar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblAnalisisGeneral = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnLimpiar1 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBoleta = new RSMaterialComponent.RSButtonMaterialOne();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblCostoTotal1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanel1.setColorBackground(new java.awt.Color(255, 255, 255));
        rSPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(235, 73, 51));
        jLabel1.setText("GESTIONAR ÓRDENES");
        rSPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        lblIdOrden.setBackground(new java.awt.Color(0, 0, 0));
        lblIdOrden.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIdOrden.setForeground(new java.awt.Color(255, 255, 255));
        lblIdOrden.setText("0");
        rSPanel1.add(lblIdOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 270, 110, -1));

        txtNumDocCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNumDocCliente.setPreferredSize(new java.awt.Dimension(150, 28));
        rSPanel1.add(txtNumDocCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 120, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cliente");
        rSPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        txtNumDocEmpleado.setEditable(false);
        txtNumDocEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNumDocEmpleado.setPreferredSize(new java.awt.Dimension(150, 28));
        rSPanel1.add(txtNumDocEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 120, -1));

        lblFecha.setBackground(new java.awt.Color(0, 0, 0));
        lblFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 0));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("-");
        lblFecha.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        rSPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 140, -1));

        cboEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboEstado.setForeground(new java.awt.Color(0, 0, 0));
        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Finalizado", "Entregado" }));
        cboEstado.setPreferredSize(new java.awt.Dimension(93, 28));
        rSPanel1.add(cboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 120, -1));

        txtNombresEmpleado.setEditable(false);
        txtNombresEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombresEmpleado.setPreferredSize(new java.awt.Dimension(150, 28));
        rSPanel1.add(txtNombresEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 320, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Empleado");
        rSPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        tblOrdenes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nro. Doc.", "Nombres", "Apellidos", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdenesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrdenes);
        if (tblOrdenes.getColumnModel().getColumnCount() > 0) {
            tblOrdenes.getColumnModel().getColumn(0).setResizable(false);
            tblOrdenes.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblOrdenes.getColumnModel().getColumn(1).setResizable(false);
            tblOrdenes.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblOrdenes.getColumnModel().getColumn(3).setResizable(false);
            tblOrdenes.getColumnModel().getColumn(4).setResizable(false);
        }

        rSPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 400, 220));

        btnGuardar.setBackground(new java.awt.Color(56, 171, 38));
        btnGuardar.setBackgroundHover(new java.awt.Color(56, 178, 72));
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        rSPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 30, 28));

        btnSubir.setBackground(new java.awt.Color(244, 146, 34));
        btnSubir.setText("↑");
        btnSubir.setBackgroundHover(new java.awt.Color(251, 169, 76));
        btnSubir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirActionPerformed(evt);
            }
        });
        rSPanel1.add(btnSubir, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 360, 28, 28));

        btnBajar.setBackground(new java.awt.Color(244, 146, 34));
        btnBajar.setText("↓");
        btnBajar.setBackgroundHover(new java.awt.Color(251, 169, 76));
        btnBajar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajarActionPerformed(evt);
            }
        });
        rSPanel1.add(btnBajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 282, 28, 28));

        btnBuscar.setBackground(new java.awt.Color(244, 146, 34));
        btnBuscar.setBackgroundHover(new java.awt.Color(251, 169, 76));
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        rSPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 30, 28));

        btnEditar.setBackground(new java.awt.Color(254, 221, 14));
        btnEditar.setBackgroundHover(new java.awt.Color(254, 218, 75));
        btnEditar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        rSPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 30, 28));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(237, 125, 52));
        jLabel14.setText("Total:");
        rSPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 530, -1, -1));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(237, 125, 52));
        jLabel15.setText("Lista de Órdenes");
        rSPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        tblAnalisisOrden.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblAnalisisOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Análisis", "Costo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblAnalisisOrden);
        if (tblAnalisisOrden.getColumnModel().getColumnCount() > 0) {
            tblAnalisisOrden.getColumnModel().getColumn(0).setResizable(false);
            tblAnalisisOrden.getColumnModel().getColumn(0).setPreferredWidth(25);
            tblAnalisisOrden.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblAnalisisOrden.getColumnModel().getColumn(2).setResizable(false);
        }

        rSPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 480, 160));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cliente");
        rSPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        txtNombresCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombresCliente.setPreferredSize(new java.awt.Dimension(150, 28));
        rSPanel1.add(txtNombresCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 320, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nro. Doc.");
        rSPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Empleado");
        rSPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        lblCostoTotal.setBackground(new java.awt.Color(0, 0, 0));
        lblCostoTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCostoTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblCostoTotal.setText("-");
        rSPanel1.add(lblCostoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 530, 90, -1));

        btnLimpiar.setBackground(new java.awt.Color(51, 12, 229));
        btnLimpiar.setBackgroundHover(new java.awt.Color(51, 51, 255));
        btnLimpiar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BACKSPACE);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        rSPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, 30, 28));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nro. Doc.");
        rSPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        tblAnalisisGeneral.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblAnalisisGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Análisis", "Costo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblAnalisisGeneral);
        if (tblAnalisisGeneral.getColumnModel().getColumnCount() > 0) {
            tblAnalisisGeneral.getColumnModel().getColumn(0).setResizable(false);
            tblAnalisisGeneral.getColumnModel().getColumn(0).setPreferredWidth(25);
            tblAnalisisGeneral.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblAnalisisGeneral.getColumnModel().getColumn(2).setResizable(false);
        }

        rSPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 480, 180));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(237, 125, 52));
        jLabel16.setText("Análisis Disponibles");
        rSPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        rSPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, -1, -1));

        btnLimpiar1.setBackground(new java.awt.Color(51, 12, 229));
        btnLimpiar1.setBackgroundHover(new java.awt.Color(51, 51, 255));
        btnLimpiar1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BACKSPACE);
        rSPanel1.add(btnLimpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 400, 30, 28));

        btnBoleta.setBackground(new java.awt.Color(178, 0, 168));
        btnBoleta.setText("Generar Boleta");
        btnBoleta.setBackgroundHover(new java.awt.Color(178, 0, 255));
        btnBoleta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoletaActionPerformed(evt);
            }
        });
        rSPanel1.add(btnBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 530, 120, 28));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(237, 125, 52));
        jLabel17.setText("Análisis de la Orden");
        rSPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Estado");
        rSPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        lblCostoTotal1.setBackground(new java.awt.Color(0, 0, 0));
        lblCostoTotal1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCostoTotal1.setForeground(new java.awt.Color(0, 0, 0));
        lblCostoTotal1.setText("S/.");
        rSPanel1.add(lblCostoTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 530, 90, -1));

        add(rSPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void tblOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdenesMouseClicked
        int seleccionar=tblOrdenes.rowAtPoint(evt.getPoint());
        lblIdOrden.setText(String.valueOf(tblOrdenes.getValueAt(seleccionar, 0)));
        txtNumDocCliente.setText(String.valueOf(tblOrdenes.getValueAt(seleccionar, 1)));
        txtNombresCliente.setText(String.valueOf(tblOrdenes.getValueAt(seleccionar, 2))+" "+String.valueOf(tblOrdenes.getValueAt(seleccionar, 3)));
        
        if(String.valueOf(tblOrdenes.getValueAt(seleccionar, 4)).equals("Pendiente")){
            cboEstado.setSelectedIndex(0);
        }
        if(String.valueOf(tblOrdenes.getValueAt(seleccionar, 4)).equals("Finalizado")){
            cboEstado.setSelectedIndex(1);
        }
        if(String.valueOf(tblOrdenes.getValueAt(seleccionar, 4)).equals("Entregado")){
            cboEstado.setSelectedIndex(2);
        }
        ClsNEmpleado objNE = new ClsNEmpleado();
        ClsNOrden objNO = new ClsNOrden();
        for(ClsEOrden objO:objNO.MtdListarOrden()){
            if(objO.getIdOrden()==Integer.parseInt(lblIdOrden.getText())){
                
                txtNumDocEmpleado.setText(objO.getEmpleado_nro_documento());
                for(ClsEEmpleado objE:objNE.MtdListarEmpleado()){
                    if(objO.getEmpleado_nro_documento().equals(objE.getNro_documento())){
                        txtNombresEmpleado.setText(objE.getNombre()+" "+objE.getApellido());
                        lblFecha.setText(objO.getFecha());
                    }
                }
            }
        }
        ListarOrdenAnalisis(Integer.parseInt(lblIdOrden.getText()));
    }//GEN-LAST:event_tblOrdenesMouseClicked

    private void btnBajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblAnalisisOrden.getModel();
        String[] datos=new String[5];
        datos[0] = ""+tblAnalisisGeneral.getValueAt(tblAnalisisGeneral.getSelectedRow(),0);
        datos[1] = ""+tblAnalisisGeneral.getValueAt(tblAnalisisGeneral.getSelectedRow(),1);
        datos[2] = ""+tblAnalisisGeneral.getValueAt(tblAnalisisGeneral.getSelectedRow(),2);
        int llave=0;
        try {
            int filas=tblAnalisisOrden.getRowCount();
            for (int i = 0;filas>i; i++) {
                if(datos[0].equals(modelo.getValueAt(i, 0))){
                    llave=1;
                }
            }
        } catch (Exception e) {
        }
        if(llave==0){
            modelo.addRow(datos);
        }
        else{
            JOptionPane.showMessageDialog(null, "El análisis ya fue agregado a la orden.");
        }
        Double total=0.0;
        try {
            int filas=tblAnalisisOrden.getRowCount();
            for (int i = 0;filas>i; i++) {
                total=total+Double.parseDouble(""+modelo.getValueAt(i, 2));
            }
        } catch (Exception e) {
        }
        lblCostoTotal.setText(""+total);
        
        
    }//GEN-LAST:event_btnBajarActionPerformed

    private void btnBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoletaActionPerformed
        if(lblIdOrden.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una orden para generar una boleta.");
        }
        else{
            
            int llave=0; //Cambia a 1 si el documento existe.
            ClsNDoc_Compra_Venta objND = new ClsNDoc_Compra_Venta();
            ClsEDoc_Compra_Venta objED = new ClsEDoc_Compra_Venta();
            for(ClsEDoc_Compra_Venta objDoc:objND.MtdListarDoc_Compra_Venta()){
                if(lblIdOrden.getText().equals(objDoc.getIdOrden()+"")){
                    llave=1;
                }
            }
            if(llave==1){
                JOptionPane.showMessageDialog(null, "La orden ya cuenta con una boleta, no se puede modificar.");
            }
            else{
                //JOptionPane.showMessageDialog(null, "La orden NO tiene venta.");
                ClsNProducto_detalle objNProdDetalle = new ClsNProducto_detalle();
                ClsEProducto_detalle objEProdDetalle = new ClsEProducto_detalle();
                ClsNProducto objNProducto = new ClsNProducto();
                ClsEProducto objEProducto = new ClsEProducto();
                
                ClsNDoc_Compra_Venta objNVenta = new ClsNDoc_Compra_Venta();
                ClsEDoc_Compra_Venta objEVenta = new ClsEDoc_Compra_Venta();
                
                DecimalFormat myFormatter = new DecimalFormat("000000");
                String output = myFormatter.format(Integer.parseInt(lblIdOrden.getText()));
                objEVenta.setNro_documento(output);
                objEVenta.setRazon_social(txtNombresCliente.getText());
                Date date = new Date();
                DateFormat FechaHora = new SimpleDateFormat("yyyy/MM/dd");
                objEVenta.setFecha(FechaHora.format(date));
                objEVenta.setTipo("VENTA");
                objEVenta.setTotal(Double.parseDouble(lblCostoTotal.getText()));
                objEVenta.setEstado(1);
                objEVenta.setIdTipo_documento(3);
                
                objEVenta.setIdOrden(Integer.parseInt(lblIdOrden.getText()));
                if(objNVenta.MtdRegistrarDoc_Compra_Venta(objEVenta)==true){
                    //GUARDAR HISTORIAL - REGISTRAR
                    ClsNHistorial objNH=new ClsNHistorial();
                    ClsEHistorial objEH = new ClsEHistorial();
                    Date date2 = new Date();
                    DateFormat FechaHora2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    objEH.setFecha(FechaHora2.format(date2)+"");
                    objEH.setTipo("Insertar Documento Venta");
                    objEH.setAccion(lblNombres.getText()+" "+lblApellidos.getText()+ " registro un Documento Venta para la orden: "+lblIdOrden.getText());
                    objEH.setNro_doc(lblDni.getText());
                    if(objNH.MtdRegistrarHistorial(objEH)==true){
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error al registrar accion.");
                    }
                    //FIN GUARDAR HISTORIAL - REGISTRAR
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error al registrar documento de venta.");
                }
                
                
                
                ClsNAnalisis_Producto objNAnalisis_Producto = new ClsNAnalisis_Producto();
                ClsEAnalisis_Producto objAnalisis_Producto = new ClsEAnalisis_Producto();
                
                
                //For para recorrer la tabla de ANÁLISIS DE LA ORDEN
                DefaultTableModel modelo = (DefaultTableModel) tblAnalisisOrden.getModel();
                try {
                    int filas=tblAnalisisOrden.getRowCount();
                    for (int i = 0;filas>i; i++) {
                        
                        //INSERTAR EN LA TABLA ORDEN ANALISIS
                        ClsNOrden_Analisis objNOrden_Analisis = new ClsNOrden_Analisis();
                        ClsEOrden_Analisis objEOrden_Analisis = new ClsEOrden_Analisis();
                        objEOrden_Analisis.setIdOrden(Integer.parseInt(lblIdOrden.getText()));
                        objEOrden_Analisis.setIdAnalisis(Integer.parseInt((String)modelo.getValueAt(i, 0)));
                        objEOrden_Analisis.setIdMuestra(3);
                        if(objNOrden_Analisis.MtdRegistrarOrden_Analisis(objEOrden_Analisis)){
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "Error al registrar Orden_Analisis");
                        }
                    
                        //JOptionPane.showInternalMessageDialog(null, "Estamos en el análisis: "+modelo.getValueAt(i, 0)+" de la tabla Análisis de la Orden.");
                        //Extraemos el ID del análisis en cada iteración.
                        //For para recorrer la tabla ANALISIS PRODUCTO
                        //Así encontramos todos los productos necesarios para el análisis de la iteración.
                        for(ClsEAnalisis_Producto objProd:objNAnalisis_Producto.MtdListarAnalisis_Producto()){
                            //JOptionPane.showInternalMessageDialog(null, "Estamos en el análisis: "+objProd.getIdAnalisis()+" Producto: "+objProd.getIdProducto()+" que requiere la cantidad de: "+objProd.getCantidad()+" de la tabla Análisis_Producto.");
                            //Almacenamos la cantidad de producto necesaria para hacer el anáisis
                            Double CantidadNecesariaAnalisis=objProd.getCantidad();
                            //If para comparar ambos ID de ANÁLISIS
                            if((""+objProd.getIdAnalisis()).equals(modelo.getValueAt(i, 0))){
                                //JOptionPane.showInternalMessageDialog(null, "Analisis: "+objProd.getIdAnalisis()+" coincide");
                                while(CantidadNecesariaAnalisis>0){
                                    //Comparamos el ID del PRODUCTO de la tabla ANALISIS PRODUCTO con la tabla PRODUCTO DETALLE
                                    //JOptionPane.showMessageDialog(null, CantidadNecesariaAnalisis+" Cantidad necesaria analisis actual.");
                                    for(ClsEProducto_detalle objProdDet:objNProdDetalle.MtdListarProducto_detalle()){
                                        if(objProd.getIdProducto()==objProdDet.getIdProducto()&&objProdDet.getCantidad()!=0){
                                            
                                            if(CantidadNecesariaAnalisis-objProdDet.getCantidad()>0){
                                                //JOptionPane.showMessageDialog(null, (CantidadNecesariaAnalisis-objProdDet.getCantidad())+" resta de Cantidad Necesaria con Cantidad del Producto Detalle LA CANTIDAD ES CERO Y LA NECESARIA AÚN EXISTE");
                                                objEProdDetalle.setIdProducto_detalle(objProdDet.getIdProducto_detalle());
                                                objEProdDetalle.setCantidad(0);
                                                Date date2 = new Date();
                                                DateFormat FechaHora2 = new SimpleDateFormat("yyyy/MM/dd");
                                                objEProdDetalle.setFech_vencimiento(FechaHora2.format(date2));
                                                objEProdDetalle.setIdProducto(objProdDet.getIdProducto());
                                                if(objNProdDetalle.MtdModificarProducto_detalle(objEProdDetalle)==true){
                                                    objEProducto.setIdProducto(objProdDet.getIdProducto());
                                                    objEProducto.setStock(1);
                                                    if(objNProducto.MtdModificarProductoStock(objEProducto)){
                                                        
                                                    }
                                                }
                                                else{
                                                    JOptionPane.showMessageDialog(null, "Error al modificar el Producto Detalle");
                                                }
                                                CantidadNecesariaAnalisis=CantidadNecesariaAnalisis-objProdDet.getCantidad();
                                                
                                            
                                            }
                                            else{
                                                //JOptionPane.showMessageDialog(null, (CantidadNecesariaAnalisis-objProdDet.getCantidad())+" resta de Cantidad Necesaria con Cantidad del Producto Detalle LA NECESARIA ES CERO Y LA CANTIDAD AÚN EXISTE");
                                                objEProdDetalle.setIdProducto_detalle(objProdDet.getIdProducto_detalle());
                                                objEProdDetalle.setCantidad(objProdDet.getCantidad()-CantidadNecesariaAnalisis);
                                                objEProdDetalle.setFech_vencimiento(objProdDet.getFech_vencimiento());
                                                objEProdDetalle.setIdProducto(objProdDet.getIdProducto());
                                                if(objNProdDetalle.MtdModificarProducto_detalle(objEProdDetalle)==true){
                                                }
                                                else{
                                                    JOptionPane.showMessageDialog(null, "Error al modificar el Producto Detalle");
                                                }
                                                
                                                if(objProdDet.getCantidad()-CantidadNecesariaAnalisis==0){
                                                    if(objNProdDetalle.MtdModificarProducto_detalle(objEProdDetalle)==true){
                                                        objEProducto.setIdProducto(objProdDet.getIdProducto());
                                                        objEProducto.setStock(1);
                                                        if(objNProducto.MtdModificarProductoStock(objEProducto)){

                                                        }
                                                    }
                                                    else{
                                                        JOptionPane.showMessageDialog(null, "Error al modificar el Producto Detalle");
                                                    }
                                                }
                                                CantidadNecesariaAnalisis=CantidadNecesariaAnalisis-objProdDet.getCantidad();
                                                break;
                                            }
                                            //JOptionPane.showMessageDialog(null, CantidadNecesariaAnalisis+" Cantidad necesaria analisis después de la resta con la Cantidad del Detalle.");
                                        }
                                    }         
                                }
                            }
                        }
                    }
                }
                catch (Exception e) { JOptionPane.showMessageDialog(null, e);}
                ListarAnalisis();
                ListarOrdenes();
            }
            
        }
    }//GEN-LAST:event_btnBoletaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ListarAnalisis();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ClsNCliente objNC = new ClsNCliente();
        ClsECliente objEC = new ClsECliente();
        int verificarcliente=0;
        for(ClsECliente objE:objNC.MtdListarCliente()){
            if(objE.getNro_documento().equals(txtNumDocCliente.getText())){
                txtNombresCliente.setText(objE.getNombre()+" "+objE.getApellido());
                verificarcliente=1;
            }
        }
        if(verificarcliente==0){
            JOptionPane.showMessageDialog(null, "No se encontró al cliente.");
        }
        txtNombresEmpleado.setText(lblNombres.getText()+" "+lblApellidos.getText());
        txtNumDocEmpleado.setText(lblDni.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblAnalisisOrden.getModel();
        modelo.removeRow(tblAnalisisOrden.getSelectedRow());
        Double total=0.0;
        try {
            int filas=tblAnalisisOrden.getRowCount();
            for (int i = 0;filas>i; i++) {
                total=total+Double.parseDouble(""+modelo.getValueAt(i, 2));
            }
        } catch (Exception e) {
        }
        lblCostoTotal.setText(""+total);
    }//GEN-LAST:event_btnSubirActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ClsNOrden objNO = new ClsNOrden();
        ClsEOrden objEO = new ClsEOrden();
        objEO.setFecha(lblFecha.getText());
        objEO.setEstado(cboEstado.getSelectedItem()+"");
        objEO.setCliente_nro_documento(txtNumDocCliente.getText());
        objEO.setEmpleado_nro_documento(txtNumDocEmpleado.getText());
        if(objNO.MtdRegistrarOrden(objEO)==true){
            JOptionPane.showMessageDialog(null, "Orden registrada correctamente.");
            //GUARDAR HISTORIAL - REGISTRAR
            ClsNHistorial objNH=new ClsNHistorial();
            ClsEHistorial objEH = new ClsEHistorial();
            Date date = new Date();
            DateFormat FechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            objEH.setFecha(FechaHora.format(date)+"");
            objEH.setTipo("Insertar Orden");
            objEH.setAccion(lblNombres.getText()+" "+lblApellidos.getText()+ " registro una orden para: "+txtNombresCliente.getText());
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
        ListarOrdenes();
        ListarAnalisis();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        ClsNOrden objNO = new ClsNOrden();
        ClsEOrden objEO = new ClsEOrden();
        objEO.setIdOrden(Integer.parseInt(lblIdOrden.getText()));
        objEO.setFecha(lblFecha.getText());
        objEO.setEstado(cboEstado.getSelectedItem()+"");
        objEO.setCliente_nro_documento(txtNumDocCliente.getText());
        objEO.setEmpleado_nro_documento(txtNumDocEmpleado.getText());
        if(objNO.MtdModificarOrden(objEO)==true){
            JOptionPane.showMessageDialog(null, "Orden modificada correctamente.");
            //GUARDAR HISTORIAL - REGISTRAR
            ClsNHistorial objNH=new ClsNHistorial();
            ClsEHistorial objEH = new ClsEHistorial();
            Date date = new Date();
            DateFormat FechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            objEH.setFecha(FechaHora.format(date)+"");
            objEH.setTipo("Modificar Orden");
            objEH.setAccion(lblNombres.getText()+" "+lblApellidos.getText()+ " modifico una orden para: "+txtNombresCliente.getText());
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
        ListarOrdenes();
        ListarAnalisis();
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialOne btnBajar;
    private RSMaterialComponent.RSButtonMaterialOne btnBoleta;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnLimpiar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnLimpiar1;
    private RSMaterialComponent.RSButtonMaterialOne btnSubir;
    private static javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblCostoTotal;
    private javax.swing.JLabel lblCostoTotal1;
    private javax.swing.JLabel lblFecha;
    private static javax.swing.JLabel lblIdOrden;
    private necesario.RSPanel rSPanel1;
    private static javax.swing.JTable tblAnalisisGeneral;
    private static javax.swing.JTable tblAnalisisOrden;
    private static javax.swing.JTable tblOrdenes;
    private static javax.swing.JTextField txtNombresCliente;
    private static javax.swing.JTextField txtNombresEmpleado;
    private static javax.swing.JTextField txtNumDocCliente;
    private static javax.swing.JTextField txtNumDocEmpleado;
    // End of variables declaration//GEN-END:variables
}
