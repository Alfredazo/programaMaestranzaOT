/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.trabajo;

import clase.TipoTrabajo;
import control.DepartamentoDao;
import control.TipoTrabajoDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alfredo
 */
public class menuTrabajo extends javax.swing.JFrame {

    /**
     * Creates new form menuTrabajo
     */
    public menuTrabajo() {
        this.setTitle("Ventana Gestión Valor Hora Trabajos");
        initComponents();
        this.cargarNombresDeptoComboBox();
        this.rescatarultimoIDTipoTrabajo();
        this.cargarListaClientesEmpresa();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cboTipoTrabajo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txt_idTrabajo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_valorHora = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnConsultarDepto = new javax.swing.JButton();
        txt_nombreDeptoConsulta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbo_nombreDeptoBuscar = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTipoTrabajo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cboTipoTrabajo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "TALLER", "TERRENO" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tipo trabajo: ");

        txt_idTrabajo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_idTrabajo.setText("1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID Trabajo:");

        txt_valorHora.setText("0");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Valor Hora Trabajo:");

        btnConsultarDepto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultarDepto.setText("?");
        btnConsultarDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDeptoActionPerformed(evt);
            }
        });

        txt_nombreDeptoConsulta.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Departamento:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton5.setText("Limpiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboTipoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_valorHora, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_idTrabajo)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nombreDeptoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultarDepto)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregar)
                        .addComponent(jLabel1)
                        .addComponent(txt_idTrabajo)
                        .addComponent(btnEliminar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_nombreDeptoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConsultarDepto)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txt_valorHora, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTipoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Buscar Valor Hora por Departamento");

        cbo_nombreDeptoBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "TALLER", "TERRENO" }));
        cbo_nombreDeptoBuscar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_nombreDeptoBuscarItemStateChanged(evt);
            }
        });

        btnActualizar.setText("Actualizar Tabla");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbo_nombreDeptoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbo_nombreDeptoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaTipoTrabajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "TIPO", "Departamento", "Valor Hora Trabajo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTipoTrabajo.getTableHeader().setReorderingAllowed(false);
        tablaTipoTrabajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTipoTrabajoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTipoTrabajo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void rescatarultimoIDTipoTrabajo() {
        try {
            TipoTrabajoDao tipoTrabajox = new TipoTrabajoDao();
            int idTipoTrabajo = tipoTrabajox.obtenerIDDepartamento() + 1;
            this.txt_idTrabajo.setText(String.valueOf(idTipoTrabajo));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarContenidoTabla() {
        DefaultTableModel tb = (DefaultTableModel) this.tablaTipoTrabajo.getModel();
        int a = this.tablaTipoTrabajo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }
    //Cargar tabla inicio (TODOS)

    public void cargarListaClientesEmpresa() {
        try {
            if (this.tablaTipoTrabajo.getSelectedRow() != 0) {
                this.eliminarContenidoTabla();
            }

            TipoTrabajoDao tipotrabajox = new TipoTrabajoDao();
            ArrayList<TipoTrabajo> listado = tipotrabajox.obtenerListadoTipoTrabajo();

            DefaultTableModel modelo = (DefaultTableModel) this.tablaTipoTrabajo.getModel();

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getIdTipoTrabajo();
                fila[1] = listado.get(i).getTipoDepto();
                fila[2] = listado.get(i).getNombreDepto();
                fila[3] = listado.get(i).getValorHora();

                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Listado Proveedores: " + e.getMessage());
        }
    }

    public void cargarListaClientesEmpresa(String nombreDepto) {
        try {
            if (this.tablaTipoTrabajo.getSelectedRow() != 0) {
                this.eliminarContenidoTabla();
            }

            TipoTrabajoDao tipotrabajox = new TipoTrabajoDao();
            ArrayList<TipoTrabajo> listado = tipotrabajox.obtenerListadoTipoTrabajo(nombreDepto);

            DefaultTableModel modelo = (DefaultTableModel) this.tablaTipoTrabajo.getModel();

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getIdTipoTrabajo();
                fila[1] = listado.get(i).getTipoDepto();
                fila[2] = listado.get(i).getNombreDepto();
                fila[3] = listado.get(i).getValorHora();

                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Listado Proveedores: " + e.getMessage());
        }
    }

    public void cargarNombresDeptoComboBox() {
        try {
            DepartamentoDao departamentox = new DepartamentoDao();
            ArrayList<String> listado = departamentox.rescatarNombresDeptoComboBox();

            this.cbo_nombreDeptoBuscar.removeAllItems();

            for (int i = -1; i < listado.size(); i++) {
                if (i == -1) {
                    this.cbo_nombreDeptoBuscar.addItem("Seleccionar");
                } else {
                    this.cbo_nombreDeptoBuscar.addItem(listado.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            //Validar que exista idTipo
            int idPedidoActual = Integer.parseInt(this.txt_idTrabajo.getText());
            TipoTrabajoDao tipox = new TipoTrabajoDao();

            if (tipox.validarSiExisteTipoTrabajo(idPedidoActual)) {
                //Rescatar datos y modificar
                String nombreDepto = vista.trabajo.menuTrabajo.txt_nombreDeptoConsulta.getText().trim();
                nombreDepto = nombreDepto.toUpperCase();
                int idDepartamentoActual = tipox.obtenerIDDepartamento(nombreDepto);
                System.out.println("ID ACTUAL : " + idDepartamentoActual);

                String tipoTrabajo = this.cboTipoTrabajo.getSelectedItem().toString();
                long valorHora = Long.parseLong(this.txt_valorHora.getText().replace(".", ""));

                if (tipox.modificarTipoTrabajo(tipoTrabajo, idDepartamentoActual, valorHora, idPedidoActual)) {
                    JOptionPane.showMessageDialog(null, "Se modifico Correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo modificar");
                }

            } else {
                JOptionPane.showMessageDialog(null, "No existe id tipo trabajo actual");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnConsultarDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDeptoActionPerformed
        vista.trabajo.menuConsultaDepartamento menu = new vista.trabajo.menuConsultaDepartamento();
        menu.setVisible(true);
    }//GEN-LAST:event_btnConsultarDeptoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        /*AGREGAR BOTON*/
        try {

            String nombreDepto = vista.trabajo.menuTrabajo.txt_nombreDeptoConsulta.getText();
            if (nombreDepto.isEmpty()) {
                throw new Exception("Seleccione un departamento");
            }

            if (this.cboTipoTrabajo.getSelectedItem().equals("Seleccionar")) {
                throw new Exception("Seleccione un tipo de trabajo");
            }

            String tipoTrabajo = this.cboTipoTrabajo.getSelectedItem().toString();

            long valorHora = 0;
            if (!this.txt_valorHora.getText().trim().isEmpty()) {
                valorHora = Long.parseLong(this.txt_valorHora.getText().trim().replace(".", ""));
            }

            int idDepartamentoSeleccionado = Integer.parseInt(vista.trabajo.menuConsultaDepartamento.tablaDepartamento.getValueAt(vista.trabajo.menuConsultaDepartamento.tablaDepartamento.getSelectedRow(), 0).toString());
            TipoTrabajoDao tipoTrabajox = new TipoTrabajoDao();

            //Validar si existe
            if (!tipoTrabajox.validarSiExisteTipoTrabajo(Integer.parseInt(this.txt_idTrabajo.getText()))) {
                if (tipoTrabajox.insertarTipoTrabajo(tipoTrabajo, idDepartamentoSeleccionado, valorHora)) {
                    JOptionPane.showMessageDialog(null, "Se agrego correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido agregar");
                }

                System.out.println("VALOR ID: " + idDepartamentoSeleccionado);
                System.out.println("Valor HH : " + this.cambiarFormatoMil(String.valueOf(valorHora)));
            } else {
                JOptionPane.showMessageDialog(null, "ya existe ese ID");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_btnAgregarActionPerformed

    public void limpiar() {
        this.rescatarultimoIDTipoTrabajo();
        vista.trabajo.menuTrabajo.txt_nombreDeptoConsulta.setText("");
        this.cboTipoTrabajo.setSelectedIndex(0);
        this.cbo_nombreDeptoBuscar.setSelectedIndex(0);
        this.txt_valorHora.setText("0");
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.limpiar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tablaTipoTrabajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTipoTrabajoMouseClicked
        //rescatar datos seleccionados
        if (evt.getClickCount() == 2) {
            int idTipoTrabajo = Integer.parseInt(this.tablaTipoTrabajo.getValueAt(this.tablaTipoTrabajo.getSelectedRow(), 0).toString());
            TipoTrabajoDao trabajox = new TipoTrabajoDao();
            TipoTrabajo tipoTrabajo = trabajox.obtenerTipoTrabajo(idTipoTrabajo);
            //Pasar valores
            this.txt_idTrabajo.setText(String.valueOf(tipoTrabajo.getIdTipoTrabajo()));
            vista.trabajo.menuTrabajo.txt_nombreDeptoConsulta.setText(tipoTrabajo.getNombreDepto());
            this.cboTipoTrabajo.setSelectedItem(tipoTrabajo.getTipoDepto());
            this.txt_valorHora.setText(String.valueOf(tipoTrabajo.getValorHora()));

        }
    }//GEN-LAST:event_tablaTipoTrabajoMouseClicked

    private void cbo_nombreDeptoBuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_nombreDeptoBuscarItemStateChanged
        try {
            if (this.cbo_nombreDeptoBuscar.getSelectedItem().equals("Seleccionar")) {
                this.cargarListaClientesEmpresa();
            } else {
                String nombreDeptoBuscar = this.cbo_nombreDeptoBuscar.getSelectedItem().toString();
                this.cargarListaClientesEmpresa(nombreDeptoBuscar);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }//GEN-LAST:event_cbo_nombreDeptoBuscarItemStateChanged

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        this.eliminarContenidoTabla();
        this.cargarListaClientesEmpresa();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            //Validar si existe el id
            int idTipoTrabajo = Integer.parseInt(this.txt_idTrabajo.getText());
            TipoTrabajoDao tipox = new TipoTrabajoDao();

            if (tipox.validarSiExisteTipoTrabajo(idTipoTrabajo)) {

                int confirmacion = JOptionPane.YES_NO_OPTION;
                //System.out.println("Numero Confirmacion ELiminacion: "+ confirmacion);
                int numeroConfirmacion = JOptionPane.showConfirmDialog(null, "¿Desea Eliminarlo Realmente?", "Warning", confirmacion);
                if (numeroConfirmacion == 0) {
                    //Eliminar
                    if (tipox.eliminarTipoTrabajo(idTipoTrabajo)) {
                        JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
                        this.limpiar();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "No existe el id de Trabajo actual");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

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
//            java.util.logging.Logger.getLogger(menuTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(menuTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(menuTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(menuTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new menuTrabajo().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConsultarDepto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cboTipoTrabajo;
    private javax.swing.JComboBox<String> cbo_nombreDeptoBuscar;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTipoTrabajo;
    private javax.swing.JLabel txt_idTrabajo;
    public static javax.swing.JTextField txt_nombreDeptoConsulta;
    private javax.swing.JTextField txt_valorHora;
    // End of variables declaration//GEN-END:variables
}