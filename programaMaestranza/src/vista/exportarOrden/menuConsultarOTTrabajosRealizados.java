/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.exportarOrden;

import vista.insumos.*;
import clase.OrdenTrabajo;
import control.OrdenTrabajoDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alfredo
 */
public class menuConsultarOTTrabajosRealizados extends javax.swing.JFrame {

    /**
     * Creates new form menuConsultarOTInsumos
     */
    public menuConsultarOTTrabajosRealizados() {
        this.setTitle("Ventana Consultar Orden de Trabajo");
        initComponents();
        this.cargarTablaInicio();
    }

    public void eliminarContenidoTabla() {
        DefaultTableModel tb = (DefaultTableModel) this.tablaOrdenTrabajo.getModel();
        int a = this.tablaOrdenTrabajo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public void cargarTablaInicio(String nombreBusca) {
        try {
            OrdenTrabajoDao otx = new OrdenTrabajoDao();

            DefaultTableModel modelo = (DefaultTableModel) this.tablaOrdenTrabajo.getModel();
            ArrayList<OrdenTrabajo> listado = otx.listarPorNombreOTBuscar(nombreBusca);

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getNumeroOT();
                fila[1] = listado.get(i).getNombreOT();
                fila[2] = listado.get(i).getFechaInicio();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema Tabla Proveedores: " + e.getMessage());
        }
    }
    
     public void cargarTablaInicio() {
        try {
            OrdenTrabajoDao otx = new OrdenTrabajoDao();

            DefaultTableModel modelo = (DefaultTableModel) this.tablaOrdenTrabajo.getModel();
            ArrayList<OrdenTrabajo> listado = otx.listarTodasLasOrdenesDeTrabajo();

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getNumeroOT();
                fila[1] = listado.get(i).getNombreOT();
                fila[2] = listado.get(i).getFechaInicio();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema Tabla Proveedores: " + e.getMessage());
        }
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_nombreOTBuscar = new javax.swing.JTextField();
        btnBuscarPorNombre = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOrdenTrabajo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("NOMBRE ORDEN DE TRABAJO:");

        btnBuscarPorNombre.setText("BUSCAR");
        btnBuscarPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorNombreActionPerformed(evt);
            }
        });

        tablaOrdenTrabajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro° OT", "Nombre OT", "Fecha Creación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaOrdenTrabajo.getTableHeader().setReorderingAllowed(false);
        tablaOrdenTrabajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaOrdenTrabajoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaOrdenTrabajo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nombreOTBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPorNombre)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_nombreOTBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPorNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorNombreActionPerformed
        try{
            if (this.txt_nombreOTBuscar.getText().isEmpty()) {
                this.eliminarContenidoTabla();
                this.cargarTablaInicio();
            }else{
                String nombreBuscar = this.txt_nombreOTBuscar.getText().toUpperCase();
                this.eliminarContenidoTabla();
                this.cargarTablaInicio(nombreBuscar);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarPorNombreActionPerformed

    private void tablaOrdenTrabajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOrdenTrabajoMouseClicked
        if (evt.getClickCount() ==2) {
            int numeroOT = Integer.parseInt(this.tablaOrdenTrabajo.getValueAt(this.tablaOrdenTrabajo.getSelectedRow(), 0).toString());
            vista.exportarOrden.menuExportarOrden.txt_nroOT.setText(String.valueOf(numeroOT));
            this.dispose();
        }
    }//GEN-LAST:event_tablaOrdenTrabajoMouseClicked

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(menuConsultarOTInsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(menuConsultarOTInsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(menuConsultarOTInsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(menuConsultarOTInsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new menuConsultarOTInsumos().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPorNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaOrdenTrabajo;
    private javax.swing.JTextField txt_nombreOTBuscar;
    // End of variables declaration//GEN-END:variables
}
