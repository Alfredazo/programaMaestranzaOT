/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.departamento;

import clase.Departamento;
import control.DepartamentoDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alfredo
 */
public class menuDepartamento extends javax.swing.JFrame {

    /**
     * Creates new form menuDepartamento
     */
    public menuDepartamento() {
        this.setTitle("Ventana Gestión Departamento");
        initComponents();
        this.txt_descripcion.setLineWrap(true);
        this.obtenerUltimoIDDepartamento();
        this.cargarTablaInicio();
    }
    
    public void eliminarContenidoTabla() {
        DefaultTableModel tb = (DefaultTableModel) this.tablaDepartamento.getModel();
        int a = this.tablaDepartamento.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }
    
    public void cargarTablaInicio() {
        if (this.tablaDepartamento.getSelectedRow() != 0 || this.tablaDepartamento.getSelectedRow() > 0) {
            this.eliminarContenidoTabla();
        }
        DepartamentoDao deptox = new DepartamentoDao();
        ArrayList<Departamento> listado = deptox.rescatarTodosLosDepartamentos();
        DefaultTableModel modelo = (DefaultTableModel) this.tablaDepartamento.getModel();
        
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < listado.size(); i++) {
            fila[0] = listado.get(i).getIdDepartamento();
            fila[1] = listado.get(i).getNombre();
            fila[2] = listado.get(i).getDescripcion();
            modelo.addRow(fila);
        }
    }
    
    public void cargarTablaInicioPorNombre(String nombre) {
        if (this.tablaDepartamento.getSelectedRow() != 0) {
            this.eliminarContenidoTabla();
        }
        DepartamentoDao deptox = new DepartamentoDao();
        ArrayList<Departamento> listado = deptox.rescatarTodosLosDepartamentos(nombre);
        DefaultTableModel modelo = (DefaultTableModel) this.tablaDepartamento.getModel();
        
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < listado.size(); i++) {
            fila[0] = listado.get(i).getIdDepartamento();
            fila[1] = listado.get(i).getNombre();
            fila[2] = listado.get(i).getDescripcion();
            modelo.addRow(fila);
        }
    }
    
    public void obtenerUltimoIDDepartamento() {
        DepartamentoDao departamentox = new DepartamentoDao();
        int id = departamentox.obtenerIDDepartamento() + 1;
        this.txt_idDepartamento.setText(String.valueOf(id));
    }
    
    public void limpiarCampos() {
        this.txt_nombreDepto.setText("");
        this.txt_descripcion.setText("");
        this.txt_nombreDeptoBuscar.setText("");
        this.obtenerUltimoIDDepartamento();
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
        jLabel1 = new javax.swing.JLabel();
        txt_idDepartamento = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nombreDepto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        btn_agregar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_nombreDeptoBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDepartamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID Dpto.");

        txt_idDepartamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_idDepartamento.setText("1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre Departamento:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Descripcion:");

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane1.setViewportView(txt_descripcion);

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_limpiar.setText("Limpiar Casillas");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                .addComponent(txt_nombreDepto)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(28, 28, 28)
                                    .addComponent(txt_idDepartamento))
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_agregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_modificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_eliminar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btn_limpiar)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_idDepartamento))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_nombreDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar)
                    .addComponent(btn_modificar)
                    .addComponent(btn_eliminar))
                .addGap(18, 18, 18)
                .addComponent(btn_limpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Buscar Departamento:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        tablaDepartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre Departamento", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDepartamento.getTableHeader().setReorderingAllowed(false);
        tablaDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDepartamentoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaDepartamento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombreDeptoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar))
                    .addComponent(jScrollPane2))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreDeptoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnBuscar)
                    .addComponent(btnActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        this.limpiarCampos();
    }//GEN-LAST:event_btn_limpiarActionPerformed
    
    public void validarCampos(String dato, String campo) throws Exception {
        if (dato.trim().length() == 0) {
            throw new Exception("El campo " + campo + " no puede venir vacio");
        }
    }

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        /*Validar que no exista y agregar*/
        try {
            DepartamentoDao departamentox = new DepartamentoDao();
            int idDpto = Integer.parseInt(this.txt_idDepartamento.getText());
            if (!departamentox.validarSiExiste(idDpto)) {
                //Agregar
                this.validarCampos(this.txt_nombreDepto.getText(), "NOMBRE DEPARTAMENTO");
                this.validarCampos(this.txt_descripcion.getText(), "DESCRIPCION");
                String nombre = this.txt_nombreDepto.getText();
                String descripcion = this.txt_descripcion.getText();
                if (departamentox.insertarDepartamento(nombre, descripcion)) {
                    JOptionPane.showMessageDialog(null, "Agregado Correctamente");
                    this.limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El id del departamento ya existe");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        this.eliminarContenidoTabla();
        this.cargarTablaInicio();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        try {
            //Validar si existe id
            DepartamentoDao departamentox = new DepartamentoDao();
            int idDpto = Integer.parseInt(this.txt_idDepartamento.getText());
            if (departamentox.validarSiExiste(idDpto)) {
                //Modifico si existe
                this.validarCampos(this.txt_nombreDepto.getText(), "NOMBRE DEPARTAMENTO");
                String nombreDepartamento = this.txt_nombreDepto.getText();
                String descripcion = this.txt_descripcion.getText();
                if (descripcion.isEmpty()) {
                    descripcion = "";
                }
                
                if (departamentox.modificarDepartamento(idDpto, nombreDepartamento, descripcion)) {
                    JOptionPane.showMessageDialog(null, "Se modifico correctamente");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "El id del departamento no existe");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void tablaDepartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDepartamentoMouseClicked
        if (evt.getClickCount() == 2) {
            //Obtener valores y devolver
            DepartamentoDao departamentox = new DepartamentoDao();
            int idDepto = Integer.parseInt(this.tablaDepartamento.getValueAt(this.tablaDepartamento.getSelectedRow(), 0).toString());
            Departamento departamento = departamentox.rescatarDepartamentos(idDepto);
            
            this.txt_idDepartamento.setText(String.valueOf(departamento.getIdDepartamento()));
            this.txt_nombreDepto.setText(departamento.getNombre());
            this.txt_descripcion.setText(departamento.getDescripcion());
            
        }
    }//GEN-LAST:event_tablaDepartamentoMouseClicked

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        try {
            DepartamentoDao departamentox = new DepartamentoDao();
            //Validar si existe
            int idDepto = Integer.parseInt(this.txt_idDepartamento.getText());
            if (departamentox.validarSiExiste(idDepto)) {
                //validar confirmacion
                int confirmacion = JOptionPane.YES_NO_OPTION;
                //System.out.println("Numero Confirmacion ELiminacion: "+ confirmacion);
                int numeroConfirmacion = JOptionPane.showConfirmDialog(null, "¿Desea Eliminarlo Realmente?", "Warning", confirmacion);
                if (numeroConfirmacion == 0) {
                    if (departamentox.eliminarDepartamento(idDepto)) {
                        JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
                        this.limpiarCampos();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe un departamento asociado a ese id");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        

    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            this.validarCampos(this.txt_nombreDeptoBuscar.getText(), "NOMBRE A BUSCAR");
            String nombreDeptoBuscar = this.txt_nombreDeptoBuscar.getText();
            
            this.cargarTablaInicioPorNombre(nombreDeptoBuscar);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed
//
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
//                    
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(menuDepartamento.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(menuDepartamento.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(menuDepartamento.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(menuDepartamento.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new menuDepartamento().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaDepartamento;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JLabel txt_idDepartamento;
    private javax.swing.JTextField txt_nombreDepto;
    private javax.swing.JTextField txt_nombreDeptoBuscar;
    // End of variables declaration//GEN-END:variables
}
