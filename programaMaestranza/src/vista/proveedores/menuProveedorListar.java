/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.proveedores;

import clase.Proveedor;
import control.ProveedorDao;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alfredo
 */
public class menuProveedorListar extends javax.swing.JFrame {

    /**
     * Creates new form menuProveedorListar
     */
    public menuProveedorListar() {
        this.setTitle("Menu  Listado Proveedores");
        initComponents();
        this.cargarListaProveedoresInicio();
        this.llenarComboBoxGiroProveedores();
    }

    public void llenarComboBoxGiroProveedores() {
        try {
            ProveedorDao provedor = new ProveedorDao();
            ArrayList<String> listado = provedor.cargarComboBoxGiroProveedor();

            this.cbo_Giro.removeAllItems();

            for (int i = -1; i < listado.size(); i++) {
                if (i == -1) {
                    this.cbo_Giro.addItem("Seleccionar");
                } else {
                    this.cbo_Giro.addItem(listado.get(i));
                }

            }
            /*Fin llenado*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema CBO: " + e.getMessage());
        }
    }

    public void eliminarContenidoTabla() {
        DefaultTableModel tb = (DefaultTableModel) this.tablaProvedores.getModel();
        int a = this.tablaProvedores.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public void cargarListaProveedoresInicio() {
        try {
            ProveedorDao provedorx = new ProveedorDao();
            ArrayList<Proveedor> listado = provedorx.cargarListadoProveedoresInformacionCompleta();

            DefaultTableModel modelo = (DefaultTableModel) this.tablaProvedores.getModel();

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getRut();
                fila[1] = listado.get(i).getNombreEmpresa();
                fila[2] = listado.get(i).getGiro();
                fila[3] = listado.get(i).getTelefono();
                fila[4] = listado.get(i).getNombreContacto();
                fila[5] = listado.get(i).getPaginaWeb();
                fila[6] = listado.get(i).getCorreo();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Listado Proveedores: " + e.getMessage());
        }
    }

    public void cargarListaProveedoresInicio(String giro) {
        try {
            this.eliminarContenidoTabla();
            ProveedorDao provedorx = new ProveedorDao();
            ArrayList<Proveedor> listado = provedorx.cargarListadoProveedoresInformacionCompleta(giro);

            DefaultTableModel modelo = (DefaultTableModel) this.tablaProvedores.getModel();

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getRut();
                fila[1] = listado.get(i).getNombreEmpresa();
                fila[2] = listado.get(i).getGiro();
                fila[3] = listado.get(i).getTelefono();
                fila[4] = listado.get(i).getNombreContacto();
                fila[5] = listado.get(i).getPaginaWeb();
                fila[6] = listado.get(i).getCorreo();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Listado Proveedores: " + e.getMessage());
        }
    }

    public void cargarListaProveedoresInicioPorEmpresa(String nombreEmpresa) {
        try {
            this.eliminarContenidoTabla();
            ProveedorDao provedorx = new ProveedorDao();
            ArrayList<Proveedor> listado = provedorx.cargarListadoProveedoresInformacionCompletaPorNombre(nombreEmpresa);

            DefaultTableModel modelo = (DefaultTableModel) this.tablaProvedores.getModel();

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getRut();
                fila[1] = listado.get(i).getNombreEmpresa();
                fila[2] = listado.get(i).getGiro();
                fila[3] = listado.get(i).getTelefono();
                fila[4] = listado.get(i).getNombreContacto();
                fila[5] = listado.get(i).getPaginaWeb();
                fila[6] = listado.get(i).getCorreo();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Listado Proveedores: " + e.getMessage());
        }
    }

    public void cargarListaProveedoresInicioPorRut(String rutBuscar) {
        try {
            this.eliminarContenidoTabla();
            ProveedorDao provedorx = new ProveedorDao();
            ArrayList<Proveedor> listado = provedorx.cargarListadoProveedoresInformacionCompletaPorRut(rutBuscar);

            DefaultTableModel modelo = (DefaultTableModel) this.tablaProvedores.getModel();

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getRut();
                fila[1] = listado.get(i).getNombreEmpresa();
                fila[2] = listado.get(i).getGiro();
                fila[3] = listado.get(i).getTelefono();
                fila[4] = listado.get(i).getNombreContacto();
                fila[5] = listado.get(i).getPaginaWeb();
                fila[6] = listado.get(i).getCorreo();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Listado Proveedores: " + e.getMessage());
        }
    }

    public void cargarListaProveedoresInicioPorRut(String giroBuscar, String rutBuscar) {
        try {
            this.eliminarContenidoTabla();
            ProveedorDao provedorx = new ProveedorDao();
            ArrayList<Proveedor> listado = provedorx.cargarListadoProveedoresInformacionCompleta(giroBuscar, rutBuscar);

            DefaultTableModel modelo = (DefaultTableModel) this.tablaProvedores.getModel();

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getRut();
                fila[1] = listado.get(i).getNombreEmpresa();
                fila[2] = listado.get(i).getGiro();
                fila[3] = listado.get(i).getTelefono();
                fila[4] = listado.get(i).getNombreContacto();
                fila[5] = listado.get(i).getPaginaWeb();
                fila[6] = listado.get(i).getCorreo();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Listado Proveedores: " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nombreEmpresa = new javax.swing.JTextField();
        txt_rutProveedor = new javax.swing.JTextField();
        cbo_Giro = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProvedores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Rut Proveedor:");

        jLabel2.setText("Nombre Empresa:");

        jLabel3.setText("Giro:");

        cbo_Giro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_Giro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_GiroItemStateChanged(evt);
            }
        });

        btnActualizar.setText("Actualizar Tabla");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaProvedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUT", "NOMBRE", "GIRO", "TELEFONO", "CONTACTO", "WEB", "E-MAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProvedores.getTableHeader().setReorderingAllowed(false);
        tablaProvedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProvedoresMouseClicked(evt);
            }
        });
        tablaProvedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaProvedoresKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProvedores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_rutProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_nombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbo_Giro, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_rutProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbo_Giro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProvedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProvedoresMouseClicked
        if (evt.getButton() == 3) {

            int confirmacion = JOptionPane.YES_NO_OPTION;
            //System.out.println("Numero Confirmacion ELiminacion: "+ confirmacion);
            int numeroConfirmacion = JOptionPane.showConfirmDialog(null, "¿Desea abrir metodos de pago?", "Warning", confirmacion);
            if (numeroConfirmacion == 0) {
                String rut = this.tablaProvedores.getValueAt(this.tablaProvedores.getSelectedRow(), 0).toString();
                ProveedorDao provedorx = new ProveedorDao();
                Proveedor provedor = provedorx.rescatarProveedorSegunRut(rut);
                String rutMostrar = "\nRUT: " + rut;
                String nombreMostrar = "\nNOMBRE: " + provedor.getNombreEmpresa();
                String bancoMostrar = "\nBANCO: " + provedor.getNombreBanco();
                if (provedor.getNombreBanco() == null) {
                    bancoMostrar = "\nBANCO: No tiene";
                }
                String cuentaMostrar = "\nCTA.CTE: " + provedor.getNroCuentaCorriente();
                if (provedor.getNroCuentaCorriente() == null) {
                    cuentaMostrar = "\nCTA.CTE: No tiene";
                }
                String correoMostrar = "\nCORREO: " + provedor.getCorreo();
                if (provedor.getCorreo() == null) {
                    correoMostrar = "\nCORREO: No tiene";
                }
                String mensaje = rutMostrar + nombreMostrar + bancoMostrar + cuentaMostrar + correoMostrar;
                JOptionPane.showMessageDialog(null, "Información Bancaria\n" + mensaje);
            }
        }

        if (evt.getClickCount() == 2) {
            //Rescatar dato y enviar a edicion
            String rut = this.tablaProvedores.getValueAt(this.tablaProvedores.getSelectedRow(), 0).toString();
            vista.proveedores.menuProveedores menu = new vista.proveedores.menuProveedores();
            menu.setVisible(true);
            vista.proveedores.menuProveedores.txt_rutEmpresa.setText(rut);
        }
    }//GEN-LAST:event_tablaProvedoresMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        this.eliminarContenidoTabla();
        this.cargarListaProveedoresInicio();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void cbo_GiroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_GiroItemStateChanged
        /*filtrar por cambios estado */
    }//GEN-LAST:event_cbo_GiroItemStateChanged

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Validar que consulta usar
        if (this.txt_rutProveedor.getText().isEmpty() && this.txt_nombreEmpresa.getText().isEmpty()) {
            //Consulta por giro %LIKE
            this.cargarListaProveedoresInicio(this.cbo_Giro.getSelectedItem().toString());
        } else if (this.txt_nombreEmpresa.getText().isEmpty() && !this.cbo_Giro.getSelectedItem().equals("Seleccionar")) {
            //Consulta rut y giro
            this.cargarListaProveedoresInicioPorRut(this.cbo_Giro.getSelectedItem().toString(), this.txt_rutProveedor.getText().toString());
        } else if (this.txt_nombreEmpresa.getText().isEmpty() && this.cbo_Giro.getSelectedItem().equals("Seleccionar")) {
            //Consulta solo por rut
            String rut = this.txt_rutProveedor.getText();
            System.out.println("RUT: " + rut);
            this.cargarListaProveedoresInicioPorRut(rut);
        } else if (this.txt_rutProveedor.getText().isEmpty() && this.cbo_Giro.getSelectedItem().equals("Seleccionar")) {
            //Consultar solo por nombre
            System.out.println("Consulta nombre");
            this.cargarListaProveedoresInicioPorEmpresa(this.txt_nombreEmpresa.getText());
        }


    }//GEN-LAST:event_btnBuscarActionPerformed
    public void goToURL(String URL) {
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI uri = new java.net.URI(URL);
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {

                }
            }
        }
    }

    private void tablaProvedoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaProvedoresKeyPressed
        //letra p 80
        try {
            if (evt.getKeyCode() == 80) {
                String paginaWeb = this.tablaProvedores.getValueAt(this.tablaProvedores.getSelectedRow(), 5).toString();
                if (paginaWeb.isEmpty() || paginaWeb.length() == 0) {
                    throw new Exception("Este proveedor no posee una página web, favor ingresar una");
                }
                paginaWeb = paginaWeb.toLowerCase();
                int confirmacion = JOptionPane.YES_NO_OPTION;
                //System.out.println("Numero Confirmacion ELiminacion: "+ confirmacion);
                int numeroConfirmacion = JOptionPane.showConfirmDialog(null, "¿Desea abrir la página web de esta Empresa?", "Warning", confirmacion);

                if (numeroConfirmacion == 0) {
                    this.goToURL(paginaWeb);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        System.out.println(evt.getKeyCode());
    }//GEN-LAST:event_tablaProvedoresKeyPressed

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
//            java.util.logging.Logger.getLogger(menuProveedorListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(menuProveedorListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(menuProveedorListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(menuProveedorListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new menuProveedorListar().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cbo_Giro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaProvedores;
    private javax.swing.JTextField txt_nombreEmpresa;
    private javax.swing.JTextField txt_rutProveedor;
    // End of variables declaration//GEN-END:variables
}
