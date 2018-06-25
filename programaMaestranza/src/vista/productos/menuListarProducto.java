/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.productos;

import clase.Producto;
import control.ProductoDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alfredo
 */
public class menuListarProducto extends javax.swing.JFrame {

    /**
     * Creates new form menuListarProducto
     */
    public menuListarProducto() {
        this.setTitle("Ventana Consulta Productos");
        initComponents();
        this.llenarComboBoxProveedor();
        this.cargarTablaListaPedidos();
        this.llenarComboBoxCategoria();
        this.llenarComboBoxMarca();
    }

    /*Metodos Listar Trabajador*/
    public void eliminarContenidoTabla() {
        DefaultTableModel tb = (DefaultTableModel) this.tablaProductos.getModel();
        int a = this.tablaProductos.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }
    
    public void llenarComboBoxProveedor() {
        try {
            ProductoDao productox = new ProductoDao();
            ArrayList<String> listado = productox.cargarComboBoxProveedores();
            
            this.cboNombreEmpresaProveedor.removeAllItems();
            
            for (int i = -1; i < listado.size(); i++) {
                if (i == -1) {
                    this.cboNombreEmpresaProveedor.addItem("Seleccionar");
                } else {
                    this.cboNombreEmpresaProveedor.addItem(listado.get(i));
                }
            }
            /*Fin llenado*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema CBO: " + e.getMessage());
        }
    }
    
    public void llenarComboBoxCategoria() {
        try {
            ProductoDao productox = new ProductoDao();
            ArrayList<String> listado = productox.cargarComboBoxCategoria();
            
            this.cboCategoriaProductos.removeAllItems();
            
            for (int i = -1; i < listado.size(); i++) {
                if (i == -1) {
                    this.cboCategoriaProductos.addItem("Seleccionar");
                } else {
                    this.cboCategoriaProductos.addItem(listado.get(i));
                }
            }
            /*Fin llenado*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema CBO: " + e.getMessage());
        }
    }
    
    public void llenarComboBoxMarca() {
        try {
            ProductoDao productox = new ProductoDao();
            ArrayList<String> listado = productox.cargarComboBoxMarcaProducto();
            
            this.cboMarcaProducto.removeAllItems();
            
            for (int i = -1; i < listado.size(); i++) {
                if (i == -1) {
                    this.cboMarcaProducto.addItem("Seleccionar");
                } else {
                    this.cboMarcaProducto.addItem(listado.get(i));
                }
            }
            /*Fin llenado*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema CBO: " + e.getMessage());
        }
    }

//CArgar tabla
    public void cargarTablaListaPedidos() {
        //Listar empresa
        try {
            
            ProductoDao productitox = new ProductoDao();
            /*cambiar datos desde el nuevo cbo*/
            
            DefaultTableModel modelo = (DefaultTableModel) this.tablaProductos.getModel();
            ArrayList<Producto> listado = productitox.obtenerListadoProductos();
            
            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getId();
                fila[1] = listado.get(i).getNombre();
                fila[2] = listado.get(i).getDescripcion();
                fila[3] = listado.get(i).getUnidadMedida();
                fila[4] = listado.get(i).getMarca();
                fila[5] = listado.get(i).getModelo();
                fila[6] = listado.get(i).getNombreCategoria();
                fila[7] = listado.get(i).getNombreProveedor();
                
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema lista" + e.getMessage());
        }
    }
    
    public void cargarTablaListaPedidos(String nombre) {
        //Listar empresa
        try {
            
            ProductoDao productitox = new ProductoDao();
            /*cambiar datos desde el nuevo cbo*/
            
            DefaultTableModel modelo = (DefaultTableModel) this.tablaProductos.getModel();
            ArrayList<Producto> listado = productitox.obtenerListadoProductos(nombre);
            
            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getId();
                fila[1] = listado.get(i).getNombre();
                fila[2] = listado.get(i).getDescripcion();
                fila[3] = listado.get(i).getUnidadMedida();
                fila[4] = listado.get(i).getMarca();
                fila[5] = listado.get(i).getModelo();
                fila[6] = listado.get(i).getNombreCategoria();
                fila[7] = listado.get(i).getNombreProveedor();
                
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema lista" + e.getMessage());
        }
    }
    
    public void cargarTablaListaPedidosPorCategoria(String nombreCategoria) {
        //Listar empresa
        try {
            
            ProductoDao productitox = new ProductoDao();
            /*cambiar datos desde el nuevo cbo*/
            
            DefaultTableModel modelo = (DefaultTableModel) this.tablaProductos.getModel();
            ArrayList<Producto> listado = productitox.obtenerListadoProductosPorCategoria(nombreCategoria);
            
            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getId();
                fila[1] = listado.get(i).getNombre();
                fila[2] = listado.get(i).getDescripcion();
                fila[3] = listado.get(i).getUnidadMedida();
                fila[4] = listado.get(i).getMarca();
                fila[5] = listado.get(i).getModelo();
                fila[6] = listado.get(i).getNombreCategoria();
                fila[7] = listado.get(i).getNombreProveedor();
                
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema lista" + e.getMessage());
        }
    }
    
    public void cargarTablaListaProductosPorMarca(String marca) {
        //Listar empresa
        try {
            
            ProductoDao productitox = new ProductoDao();
            /*cambiar datos desde el nuevo cbo*/
            
            DefaultTableModel modelo = (DefaultTableModel) this.tablaProductos.getModel();
            ArrayList<Producto> listado = productitox.obtenerListadoProductosPorMarca(marca);
            
            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getId();
                fila[1] = listado.get(i).getNombre();
                fila[2] = listado.get(i).getDescripcion();
                fila[3] = listado.get(i).getUnidadMedida();
                fila[4] = listado.get(i).getMarca();
                fila[5] = listado.get(i).getModelo();
                fila[6] = listado.get(i).getNombreCategoria();
                fila[7] = listado.get(i).getNombreProveedor();
                
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema lista" + e.getMessage());
        }
    }
    
    public void cargarTablaListaProductosPorNombre(String nombreBuscar) {
        //Listar empresa
        try {
            
            ProductoDao productitox = new ProductoDao();
            /*cambiar datos desde el nuevo cbo*/
            
            DefaultTableModel modelo = (DefaultTableModel) this.tablaProductos.getModel();
            ArrayList<Producto> listado = productitox.obtenerListadoProductosPorNombre(nombreBuscar);
            
            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getId();
                fila[1] = listado.get(i).getNombre();
                fila[2] = listado.get(i).getDescripcion();
                fila[3] = listado.get(i).getUnidadMedida();
                fila[4] = listado.get(i).getMarca();
                fila[5] = listado.get(i).getModelo();
                fila[6] = listado.get(i).getNombreCategoria();
                fila[7] = listado.get(i).getNombreProveedor();
                
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema lista" + e.getMessage());
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        cboNombreEmpresaProveedor = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        cboCategoriaProductos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        cboMarcaProducto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txt_nombreBuscar = new javax.swing.JTextField();
        btnBuscarPorNombre = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        btnMarca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Proveedor:");

        cboNombreEmpresaProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNombreEmpresaProveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNombreEmpresaProveedorItemStateChanged(evt);
            }
        });

        cboCategoriaProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Categoría:");

        cboMarcaProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Marca:");

        jLabel4.setText("Nombre:");

        btnBuscarPorNombre.setText("BUSCAR");
        btnBuscarPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorNombreActionPerformed(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnProveedor.setText("BUSCAR");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        btnCategoria.setText("BUSCAR");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        btnMarca.setText("BUSCAR");
        btnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(cboNombreEmpresaProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(cboCategoriaProductos, 0, 266, Short.MAX_VALUE)
            .addComponent(jSeparator4)
            .addComponent(jSeparator3)
            .addComponent(cboMarcaProducto, 0, 266, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addComponent(txt_nombreBuscar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBuscarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboNombreEmpresaProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboCategoriaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(cboMarcaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_nombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "DESCRIPCION", "U/M", "MARCA", "MODELO", "CATEGORIA", "PROVEEDOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        if (evt.getClickCount() == 2) {
            //Rescatar datos y enviar
            int idProducto = Integer.parseInt(this.tablaProductos.getValueAt(this.tablaProductos.getSelectedRow(), 0).toString());
            //Enviar metodo y rescatar producto            
            vista.productos.menuProductos menu = new vista.productos.menuProductos();
            vista.productos.menuProductos.txt_idProducto.setText(String.valueOf(idProducto));
            ProductoDao productox = new ProductoDao();
            Producto productito = productox.obtenerProductoSegunID(idProducto);
            vista.productos.menuProductos.txt_nombreProducto.setText(productito.getNombre());
            vista.productos.menuProductos.txt_descripcion.setText(productito.getDescripcion());
            vista.productos.menuProductos.cboUnidadMedida.setSelectedItem(productito.getUnidadMedida());
            vista.productos.menuProductos.txt_marca.setText(productito.getMarca());
            vista.productos.menuProductos.txt_modelo.setText(productito.getModelo());
            String categoria = this.tablaProductos.getValueAt(this.tablaProductos.getSelectedRow(), 6).toString();
            vista.productos.menuProductos.cboCategoria.setSelectedItem(categoria);
            vista.productos.menuProductos.txt_rutProveedor.setText(productito.getRutProveedor());
            menu.setVisible(true);
        }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.eliminarContenidoTabla();
        this.cargarTablaListaPedidos();
        this.llenarComboBoxCategoria();
        this.llenarComboBoxMarca();
        this.llenarComboBoxProveedor();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void cboNombreEmpresaProveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNombreEmpresaProveedorItemStateChanged

    }//GEN-LAST:event_cboNombreEmpresaProveedorItemStateChanged

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        try {
            if (this.cboNombreEmpresaProveedor.getSelectedIndex() == 0) {
                throw new Exception("Seleccione un proveedor para buscar");
            } else {
                this.eliminarContenidoTabla();
                this.cargarTablaListaPedidos(this.cboNombreEmpresaProveedor.getSelectedItem().toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        try {
            if (this.cboCategoriaProductos.getSelectedIndex() == 0) {
                throw new Exception("Seleccione un proveedor para buscar");
            } else {
                this.eliminarContenidoTabla();
                this.cargarTablaListaPedidosPorCategoria(this.cboCategoriaProductos.getSelectedItem().toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcaActionPerformed
        try {
            if (this.cboMarcaProducto.getSelectedIndex() == 0) {
                throw new Exception("Seleccione un proveedor para buscar");
            } else {
                this.eliminarContenidoTabla();
                this.cargarTablaListaProductosPorMarca(this.cboMarcaProducto.getSelectedItem().toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnMarcaActionPerformed

    private void btnBuscarPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorNombreActionPerformed
        try {
            if (this.txt_nombreBuscar.getText().isEmpty()) {
                throw new Exception("Ingrese al menos una letra para usar la funcion");
            } else {
                this.eliminarContenidoTabla();
                this.cargarTablaListaProductosPorNombre(this.txt_nombreBuscar.getText());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarPorNombreActionPerformed

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
//            java.util.logging.Logger.getLogger(menuListarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(menuListarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(menuListarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(menuListarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new menuListarProducto().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscarPorNombre;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnMarca;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JComboBox<String> cboCategoriaProductos;
    private javax.swing.JComboBox<String> cboMarcaProducto;
    private javax.swing.JComboBox<String> cboNombreEmpresaProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txt_nombreBuscar;
    // End of variables declaration//GEN-END:variables
}
