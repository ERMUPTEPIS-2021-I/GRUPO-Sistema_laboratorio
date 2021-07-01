/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Entidad.ClsEHistorial;
import Negocios.ClsConexion;
import Negocios.ClsNHistorial;
import static Presentacion.FrmPrincipal.lblApellidos;
import static Presentacion.FrmPrincipal.lblDni;
import static Presentacion.FrmPrincipal.lblNombres;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Brian Anco
 */
public class PnlReportes extends javax.swing.JPanel {

    /**
     * Creates new form PnlOrdenes
     */
    public PnlReportes() {
        initComponents();
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
        jLabel4 = new javax.swing.JLabel();
        cboMes = new javax.swing.JComboBox<>();
        btnProductos = new RSMaterialComponent.RSButtonMaterialOne();
        btnAnalisis = new RSMaterialComponent.RSButtonMaterialOne();
        btnVentas = new RSMaterialComponent.RSButtonMaterialOne();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanel1.setColorBackground(new java.awt.Color(255, 255, 255));
        rSPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(235, 73, 51));
        jLabel1.setText("GENERAR REPORTES");
        rSPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Mes");
        rSPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));

        cboMes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboMes.setForeground(new java.awt.Color(0, 0, 0));
        cboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre" }));
        cboMes.setPreferredSize(new java.awt.Dimension(93, 28));
        rSPanel1.add(cboMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 120, -1));

        btnProductos.setBackground(new java.awt.Color(244, 146, 34));
        btnProductos.setText("Productos Utilizados");
        btnProductos.setBackgroundHover(new java.awt.Color(251, 169, 76));
        btnProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        rSPanel1.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 170, 28));

        btnAnalisis.setBackground(new java.awt.Color(244, 146, 34));
        btnAnalisis.setText("Análisis Realizados");
        btnAnalisis.setBackgroundHover(new java.awt.Color(251, 169, 76));
        btnAnalisis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisisActionPerformed(evt);
            }
        });
        rSPanel1.add(btnAnalisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 170, 28));

        btnVentas.setBackground(new java.awt.Color(244, 146, 34));
        btnVentas.setText("Ventas");
        btnVentas.setBackgroundHover(new java.awt.Color(251, 169, 76));
        btnVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        rSPanel1.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 170, 28));

        add(rSPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 570));
    }// </editor-fold>//GEN-END:initComponents

    public static void MostrarReporte1(String mes) throws JRException, net.sf.jasperreports.engine.JRException{
        Map parameters = new HashMap();
        //parameters.put("codigo", "descripcion");
        //parameters.put("FECHA", new java.util.Date());
        String Nombre="Analisis_"+mes;
        String path = "D:\\Universidad\\Laboratorios Programación III\\Omylab\\src\\Presentacion\\Reportes\\"+Nombre+".jrxml";
        JasperReport report = JasperCompileManager.compileReport(path);
        JasperPrint print = JasperFillManager.fillReport(report, parameters,ClsConexion.Conectar());
         // Exporta el informe a PDF
        JasperExportManager.exportReportToPdfFile(print,"D:\\Universidad\\Laboratorios Programación III\\Omylab\\src\\Presentacion\\ReportesPdf\\"+Nombre+".pdf");
        //Para visualizar el pdf directamente desde java
        JasperViewer.viewReport(print, false);
    }
    public static void MostrarReporte2(String mes) throws JRException, net.sf.jasperreports.engine.JRException{
        Map parameters = new HashMap();
        //parameters.put("codigo", "descripcion");
        //parameters.put("FECHA", new java.util.Date());
        String Nombre="Productos_"+mes;
        String path = "D:\\Universidad\\Laboratorios Programación III\\Omylab\\src\\Presentacion\\Reportes\\"+Nombre+".jrxml";
        JasperReport report = JasperCompileManager.compileReport(path);
        JasperPrint print = JasperFillManager.fillReport(report, parameters,ClsConexion.Conectar());
         // Exporta el informe a PDF
        JasperExportManager.exportReportToPdfFile(print,"D:\\Universidad\\Laboratorios Programación III\\Omylab\\src\\Presentacion\\ReportesPdf\\"+Nombre+".pdf");
        //Para visualizar el pdf directamente desde java
        JasperViewer.viewReport(print, false);
    }
    public static void MostrarReporte3() throws JRException, net.sf.jasperreports.engine.JRException{
        Map parameters = new HashMap();
        //parameters.put("codigo", "descripcion");
        //parameters.put("FECHA", new java.util.Date());
        String Nombre="Ventas2021";
        String path = "D:\\Universidad\\Laboratorios Programación III\\Omylab\\src\\Presentacion\\Reportes\\"+Nombre+".jrxml";
        JasperReport report = JasperCompileManager.compileReport(path);
        JasperPrint print = JasperFillManager.fillReport(report, parameters,ClsConexion.Conectar());
         // Exporta el informe a PDF
        JasperExportManager.exportReportToPdfFile(print,"D:\\Universidad\\Laboratorios Programación III\\Omylab\\src\\Presentacion\\ReportesPdf\\"+Nombre+".pdf");
        //Para visualizar el pdf directamente desde java
        JasperViewer.viewReport(print, false);
    }
    
    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        try {
            MostrarReporte2(cboMes.getSelectedItem()+"");
            //GUARDAR HISTORIAL - REGISTRAR
            ClsNHistorial objNH=new ClsNHistorial();
            ClsEHistorial objEH = new ClsEHistorial();
            Date date = new Date();
            DateFormat FechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            objEH.setFecha(FechaHora.format(date)+"");
            objEH.setTipo("Generar Reporte");
            objEH.setAccion(lblNombres.getText()+" "+lblApellidos.getText()+ " genero un reporte de Productos - "+cboMes.getSelectedItem());
            objEH.setNro_doc(lblDni.getText());
            if(objNH.MtdRegistrarHistorial(objEH)==true){
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al registrar accion.");
            }
            //FIN GUARDAR HISTORIAL - REGISTRAR
        } catch (JRException ex) {
            Logger.getLogger(PnlReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisisActionPerformed
        try {
            MostrarReporte1(cboMes.getSelectedItem()+"");
            //GUARDAR HISTORIAL - REGISTRAR
            ClsNHistorial objNH=new ClsNHistorial();
            ClsEHistorial objEH = new ClsEHistorial();
            Date date = new Date();
            DateFormat FechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            objEH.setFecha(FechaHora.format(date)+"");
            objEH.setTipo("Generar Reporte");
            objEH.setAccion(lblNombres.getText()+" "+lblApellidos.getText()+ " genero un reporte de Analisis - "+cboMes.getSelectedItem());
            objEH.setNro_doc(lblDni.getText());
            if(objNH.MtdRegistrarHistorial(objEH)==true){
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al registrar accion.");
            }
            //FIN GUARDAR HISTORIAL - REGISTRAR
        } catch (JRException ex) {
            Logger.getLogger(PnlReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalisisActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        try {
            MostrarReporte3();
        } catch (JRException ex) {
            Logger.getLogger(PnlReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVentasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialOne btnAnalisis;
    private RSMaterialComponent.RSButtonMaterialOne btnProductos;
    private RSMaterialComponent.RSButtonMaterialOne btnVentas;
    private javax.swing.JComboBox<String> cboMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private necesario.RSPanel rSPanel1;
    // End of variables declaration//GEN-END:variables
}