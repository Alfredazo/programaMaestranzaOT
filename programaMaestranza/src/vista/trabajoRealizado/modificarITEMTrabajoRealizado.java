/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.trabajoRealizado;

import clase.ListadoTrabajosRealizados;
import control.TipoTrabajoDao;
import control.TrabajosRealizadosDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alfredo
 */
public class modificarITEMTrabajoRealizado extends javax.swing.JFrame {

    /**
     * Creates new form agregarITEMTrabajoRealizado
     */
    public modificarITEMTrabajoRealizado() {
        this.setTitle("Ventana Modificar  Item Trabajo Realizado");
        initComponents();
        this.txt_descripcion.setLineWrap(true);
        vista.trabajoRealizado.modificarITEMTrabajoRealizado.txt_id_itemTrabajosRealizados.setVisible(false);
    }

    
     public void actualizarTotalCampoyBD(int idTrabajoRealizado) {
        TrabajosRealizadosDao trabajox = new TrabajosRealizadosDao();
        if (trabajox.validarQueNoExistaOTTrabajoRealizadoCabeceraPorID(idTrabajoRealizado)) {
            //Existe entonces rescato
            //REscato el total final de la lista
            long subTotal = trabajox.devolverTotalITEMListadoTrabajos(idTrabajoRealizado);

            //Necesito actualizar la tabla y el texto con ese total
            if (trabajox.actualizarTotalTrabajosRealizados(subTotal, idTrabajoRealizado)){
                JOptionPane.showMessageDialog(null, "Total Actualizado Correctamente");
                //Modificar Campo TOTAL
                vista.trabajoRealizado.menuTrabajoRealizado.txt_total.setText(this.cambiarFormatoMil(String.valueOf(subTotal)));
            }
            System.out.println("VALOR TOTAL: " + subTotal);
        }
    }
    
    public void eliminarContenidoTabla() {
        DefaultTableModel tb = (DefaultTableModel) vista.trabajoRealizado.menuTrabajoRealizado.tablaTrabajoRealizado.getModel();
        int a = vista.trabajoRealizado.menuTrabajoRealizado.tablaTrabajoRealizado.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public void cargarTablaInicio() {
        try {
            TrabajosRealizadosDao trx = new TrabajosRealizadosDao();
            int idTrabajoRealizado = Integer.parseInt(vista.trabajoRealizado.menuTrabajoRealizado.txt_idTrabajoRealizado.getText());
            DefaultTableModel modelo = (DefaultTableModel) vista.trabajoRealizado.menuTrabajoRealizado.tablaTrabajoRealizado.getModel();
            ArrayList<ListadoTrabajosRealizados> listado = trx.listadoITEMSTrabajosRealizados(idTrabajoRealizado);

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getIdListadoTrabajosRealizado();
                fila[1] = listado.get(i).getNombreTrabajo();
                fila[2] = listado.get(i).getTipoTrabajo();
                fila[3] = listado.get(i).getNombreDepto();
                fila[4] = listado.get(i).getHorasTrabajadas();
                fila[5] = listado.get(i).getValorHora();
                fila[6] = listado.get(i).getSubTotal();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema Tabla Proveedores: " + e.getMessage());
        }
    }
    
    
    
    public String cambiarFormatoMil(String valor) {
        String valorConSeparador = "";
        char[] arregloPaso = valor.toCharArray();
        int contadorPaso = 1;
        for (int i = arregloPaso.length - 1; i >= 0; i--) {
            if (contadorPaso == 3) {
                if (i == 0) {
                    valorConSeparador = valorConSeparador + arregloPaso[i];
                    contadorPaso = 1;
                } else {
                    valorConSeparador = valorConSeparador + arregloPaso[i] + ".";
                    contadorPaso = 1;
                }

            } else {
                valorConSeparador = valorConSeparador + arregloPaso[i];
                contadorPaso = contadorPaso + 1;
            }
            //System.out.println("LETRA: " + arregloPaso[i]);
        }

        StringBuilder stringPaso = new StringBuilder(valorConSeparador);
        valorConSeparador = stringPaso.reverse().toString();

        return valorConSeparador;
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
        txt_idTrabajosRealizados = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nombreTrabajo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txt_tipoTrabajo = new javax.swing.JTextField();
        btnBuscarTipoTR = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_subTotal = new javax.swing.JTextField();
        btnModificariTEM = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_horasTrabajadas = new javax.swing.JTextField();
        txt_valorHora = new javax.swing.JTextField();
        txt_id_itemTrabajosRealizados = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID Trabajos Realizados:");

        txt_idTrabajosRealizados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_idTrabajosRealizados.setText("00000");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre Trabajo:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Descripcion");

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane1.setViewportView(txt_descripcion);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tipo Trabajo: ");

        txt_tipoTrabajo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_tipoTrabajoCaretUpdate(evt);
            }
        });

        btnBuscarTipoTR.setText("?");
        btnBuscarTipoTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTipoTRActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Valor Hora:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("SUB TOTAL:");

        txt_subTotal.setText("0");

        btnModificariTEM.setText("MODIFICAR");
        btnModificariTEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificariTEMActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Horas Trabajadas:");

        txt_horasTrabajadas.setText("0");
        txt_horasTrabajadas.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_horasTrabajadasCaretUpdate(evt);
            }
        });

        txt_valorHora.setText("0");
        txt_valorHora.setEnabled(false);
        txt_valorHora.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_valorHoraCaretUpdate(evt);
            }
        });

        txt_id_itemTrabajosRealizados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_id_itemTrabajosRealizados.setText("00000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_idTrabajosRealizados)
                        .addGap(144, 144, 144)
                        .addComponent(txt_id_itemTrabajosRealizados))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nombreTrabajo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37)
                        .addComponent(txt_tipoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarTipoTR)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_valorHora, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addComponent(txt_horasTrabajadas, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(48, 48, 48)
                        .addComponent(txt_subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnModificariTEM, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_idTrabajosRealizados)
                        .addComponent(txt_id_itemTrabajosRealizados)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3))
                    .addComponent(txt_nombreTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tipoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarTipoTR, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addComponent(txt_valorHora, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txt_horasTrabajadas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel8))
                    .addComponent(txt_subTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnModificariTEM, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarTipoTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTipoTRActionPerformed
        try {
            vista.trabajoRealizado.menuConsultaTipoTrabajoMoficar menu = new vista.trabajoRealizado.menuConsultaTipoTrabajoMoficar();
            menu.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarTipoTRActionPerformed

    private void txt_tipoTrabajoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_tipoTrabajoCaretUpdate
        try {
            if (vista.trabajoRealizado.modificarITEMTrabajoRealizado.txt_tipoTrabajo.getText().isEmpty()) {
                this.txt_valorHora.setText("0");
            } else {
                int idTipoTrabajo = Integer.parseInt(vista.trabajoRealizado.modificarITEMTrabajoRealizado.txt_tipoTrabajo.getText());

                //Realizar metodo devolver valor hora
                TipoTrabajoDao tipox = new TipoTrabajoDao();
                long valorHora = tipox.obtenerValorHoraTipoTrabajo(idTipoTrabajo);
                this.txt_valorHora.setText(this.cambiarFormatoMil(String.valueOf(valorHora)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_txt_tipoTrabajoCaretUpdate

    private void txt_horasTrabajadasCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_horasTrabajadasCaretUpdate
        try {
            long valorHora = Long.parseLong(this.txt_valorHora.getText().replace(".", ""));

            double horasTrabajadas = 0;
            if (!this.txt_horasTrabajadas.getText().isEmpty()) {
                horasTrabajadas = Double.parseDouble(this.txt_horasTrabajadas.getText());
            }

            long subTotal = (long) (valorHora * horasTrabajadas);

            this.txt_subTotal.setText(this.cambiarFormatoMil(String.valueOf(subTotal)));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_txt_horasTrabajadasCaretUpdate

    private void txt_valorHoraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_valorHoraCaretUpdate

    }//GEN-LAST:event_txt_valorHoraCaretUpdate

    private void btnModificariTEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificariTEMActionPerformed
        try {
            if (this.txt_nombreTrabajo.getText().isEmpty()) {
                throw new Exception("El campo NOMBRE TRABAJO no debe venir vacio");
            }
            if (this.txt_descripcion.getText().isEmpty()) {
                throw new Exception("El campo DESCRIPCION no debe venir vacio");
            }
            if (vista.trabajoRealizado.modificarITEMTrabajoRealizado.txt_tipoTrabajo.getText().isEmpty()) {
                throw new Exception("El campo TIPO TRABAJO no debe venir vacio");
            }
            if (vista.trabajoRealizado.modificarITEMTrabajoRealizado.txt_horasTrabajadas.getText().isEmpty()) {
                throw new Exception("El campo HORAS TRABAJADAS  no debe venir vacio");
            }

            String nombreTrabajo = this.txt_nombreTrabajo.getText().toUpperCase();
            String descripcion = this.txt_descripcion.getText();
            int idTrabajoRealizado = Integer.parseInt(vista.trabajoRealizado.modificarITEMTrabajoRealizado.txt_idTrabajosRealizados.getText());
            int idTipoTrabajo = Integer.parseInt(vista.trabajoRealizado.modificarITEMTrabajoRealizado.txt_tipoTrabajo.getText());
            long valorHora = Long.parseLong(this.txt_valorHora.getText().replace(".", ""));
            double horasTrabajadas = Double.parseDouble(vista.trabajoRealizado.modificarITEMTrabajoRealizado.txt_horasTrabajadas.getText());
            long subTotal = Long.parseLong(vista.trabajoRealizado.modificarITEMTrabajoRealizado.txt_subTotal.getText().replace(".", ""));
            TrabajosRealizadosDao trabajox = new TrabajosRealizadosDao();
            int idITEMListado = Integer.parseInt(vista.trabajoRealizado.modificarITEMTrabajoRealizado.txt_id_itemTrabajosRealizados.getText());
            //MODIFICAR
            if (trabajox.modificarITEMListadoTrabajadores(nombreTrabajo, descripcion, idTipoTrabajo, horasTrabajadas, subTotal, idITEMListado)) {
                JOptionPane.showMessageDialog(null, "Modificado Correctamente");
                //Eliminar tabla - cargar y actualizar subTotal de trabajo
                this.eliminarContenidoTabla();
                this.cargarTablaInicio();
                //Metodo actualizar
                this.actualizarTotalCampoyBD(idTrabajoRealizado);
                this.dispose();                
            }else{
                JOptionPane.showMessageDialog(null, "Error al Modificar");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnModificariTEMActionPerformed

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
//            java.util.logging.Logger.getLogger(modificarITEMTrabajoRealizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(modificarITEMTrabajoRealizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(modificarITEMTrabajoRealizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(modificarITEMTrabajoRealizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new modificarITEMTrabajoRealizado().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarTipoTR;
    private javax.swing.JButton btnModificariTEM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea txt_descripcion;
    public static javax.swing.JTextField txt_horasTrabajadas;
    public static javax.swing.JLabel txt_idTrabajosRealizados;
    public static javax.swing.JLabel txt_id_itemTrabajosRealizados;
    public static javax.swing.JTextField txt_nombreTrabajo;
    public static javax.swing.JTextField txt_subTotal;
    public static javax.swing.JTextField txt_tipoTrabajo;
    private javax.swing.JTextField txt_valorHora;
    // End of variables declaration//GEN-END:variables
}