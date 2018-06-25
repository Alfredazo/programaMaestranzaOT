/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.pedidos;

import clase.ListadoPedido;
import control.ListadoPedidoDao;
import control.PedidoDao;
import control.ProductoDao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alfredo
 */
public class menuPedido extends javax.swing.JFrame {

    /**
     * Creates new form menuPedido
     */
    public menuPedido() {
        this.setTitle("Ventana Gestión Pedidos ");
        initComponents();
        this.obtenerUltimoIDPedido();
        this.generarFechaHoy();
        this.cargarTablaInicio();
    }

    public void obtenerUltimoIDPedido() {
        if (this.txt_idPedido.getText().equals("00000")) {
            PedidoDao pedidox = new PedidoDao();
            int idPedido = pedidox.obtenerUltimoNroPedido() + 1;
            this.txt_idPedido.setText(String.valueOf(idPedido));
        }
    }

    public void eliminarContenidoTabla() {
        DefaultTableModel tb = (DefaultTableModel) this.tablaListadoPedido.getModel();
        int a = this.tablaListadoPedido.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public void cargarTablaInicio() {
        try {
            //Menu pedido
            ListadoPedidoDao listadoPedidox = new ListadoPedidoDao();

            DefaultTableModel modelo = (DefaultTableModel) this.tablaListadoPedido.getModel();
            int idPedido = Integer.parseInt(this.txt_idPedido.getText());
            ArrayList<ListadoPedido> listado = listadoPedidox.listadoITEMPedidosListaCompleta(idPedido);

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getIdListado();
                fila[1] = listado.get(i).getNombre();
                fila[2] = listado.get(i).getCantidad();
                fila[3] = listado.get(i).getPrecioUnitario();
                fila[4] = listado.get(i).getSubTotal();
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

    public void generarFechaHoy() {
        Calendar today = Calendar.getInstance();
        Date fechaHoy = today.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String fechaStringBase = format.format(fechaHoy);
        //System.out.println("Fecha: " + fechaStringBase);
        this.txt_fechaCreacion.setText(fechaStringBase);
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
        txt_idPedido = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_fechaCreacion = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nroOT = new javax.swing.JTextField();
        btnBuscaROT = new javax.swing.JButton();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_personaSolicita = new javax.swing.JTextField();
        btnBuscarPersona = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cboUrgencia = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListadoPedido = new javax.swing.JTable();
        btnAgregarITEM = new javax.swing.JButton();
        btnEliminarITEM = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_totalPedido = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnActualizarListadoITEM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID Pedido:");

        txt_idPedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_idPedido.setText("00000");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Fecha Generación:");

        txt_fechaCreacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_fechaCreacion.setText("00-00-0000");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("N° OT:");

        btnBuscaROT.setText("?");
        btnBuscaROT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaROTActionPerformed(evt);
            }
        });

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "ACEPTADO", "RECHAZADO", "COMPRADO" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Estado:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Solicita:");

        txt_personaSolicita.setEnabled(false);

        btnBuscarPersona.setText("?");
        btnBuscarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPersonaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Urgencia:");

        cboUrgencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "NORMAL", "URGENTE" }));

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tablaListadoPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCTO", "CANTIDAD", "P/U", "SUB TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaListadoPedido.getTableHeader().setReorderingAllowed(false);
        tablaListadoPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaListadoPedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaListadoPedido);

        btnAgregarITEM.setText("AGREGAR");
        btnAgregarITEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarITEMActionPerformed(evt);
            }
        });

        btnEliminarITEM.setText("ELIMINAR");
        btnEliminarITEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarITEMActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("TOTAL:");

        txt_totalPedido.setText("0");
        txt_totalPedido.setEnabled(false);

        btnActualizarListadoITEM.setText("ACTUALIZAR");
        btnActualizarListadoITEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarListadoITEMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarITEM, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(btnEliminarITEM, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(btnActualizarListadoITEM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(39, 39, 39)
                                .addComponent(txt_nroOT, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addComponent(txt_idPedido)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_personaSolicita, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarPersona)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txt_fechaCreacion)
                                .addGap(108, 108, 108))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscaROT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(cboUrgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(525, 525, 525)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txt_totalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txt_personaSolicita, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscarPersona)
                                .addComponent(jLabel1)
                                .addComponent(txt_idPedido))
                            .addComponent(btnAgregar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txt_fechaCreacion)
                                .addComponent(btnEliminar)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_nroOT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscaROT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(cboUrgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(btnModificar)
                                    .addComponent(btnLimpiar))))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnAgregarITEM, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarITEM, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarListadoITEM, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_totalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscaROTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaROTActionPerformed
        vista.pedidos.menuConsultaOTpedidos menu = new vista.pedidos.menuConsultaOTpedidos();
        menu.setVisible(true);
    }//GEN-LAST:event_btnBuscaROTActionPerformed

    private void btnBuscarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPersonaActionPerformed
        vista.pedidos.menuConsultaTrabajadorPedido menu = new vista.pedidos.menuConsultaTrabajadorPedido();
        menu.setVisible(true);
    }//GEN-LAST:event_btnBuscarPersonaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            //Validar si existe
            PedidoDao pedidox = new PedidoDao();
            int idPedido = Integer.parseInt(this.txt_idPedido.getText());
            if (!pedidox.validarSiExistePedido(idPedido)) {
                //Crear ya que no existe
                if (vista.pedidos.menuPedido.txt_personaSolicita.getText().isEmpty()) {
                    throw new Exception("El campo PERSONA SOLICITANTE no puede venir vacio");
                }

                if (vista.pedidos.menuPedido.txt_nroOT.getText().isEmpty()) {
                    throw new Exception("El campo NRO° ORDEN DE TRABAJO no puede venir vacio");
                }

                if (this.cboEstado.getSelectedIndex() == 0) {
                    throw new Exception("El campo ESTADO no puede venir vacio");
                }

                if (this.cboUrgencia.getSelectedIndex() == 0) {
                    throw new Exception("EL campo URGENCIA no puede venir vacio");
                }

                String nombrePersonaSolicita = vista.pedidos.menuPedido.txt_personaSolicita.getText().toUpperCase();
                int nroOT = Integer.parseInt(vista.pedidos.menuPedido.txt_nroOT.getText());
                String estado = this.cboEstado.getSelectedItem().toString();
                String urgencia = this.cboUrgencia.getSelectedItem().toString();

                //Metodo consultar rut segun nombre
                String rutPersona = pedidox.devolverRutTrabajador(nombrePersonaSolicita);
                System.out.println("RuT: " + rutPersona);
                if (pedidox.ingresarCabeceraPedido(nroOT, estado, urgencia, rutPersona)) {
                    JOptionPane.showMessageDialog(null, "Agregado Correctamente");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ya existe el ID para ese pedido");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    public void limpiarCampos() {
        this.txt_idPedido.setText("00000");
        this.obtenerUltimoIDPedido();
        vista.pedidos.menuPedido.txt_nroOT.setText("");
        vista.pedidos.menuPedido.txt_personaSolicita.setText("");
        this.generarFechaHoy();
        this.cboEstado.setSelectedIndex(0);
        this.cboUrgencia.setSelectedIndex(0);
        this.eliminarContenidoTabla();
        //Eliminar tabla
    }
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    public void actualizarTotalCampoyBD(int idPedido) {
        PedidoDao pedidox = new PedidoDao();
        ListadoPedidoDao listadoPedidox = new ListadoPedidoDao();
        if (pedidox.validarSiExistePedido(idPedido)) {

            long subTotal = listadoPedidox.devolverTotalListaPedidos(idPedido);

            //Necesito actualizar la tabla y el texto con ese total
            if (pedidox.modificarSubTotal(subTotal, idPedido)) {
                JOptionPane.showMessageDialog(null, "Total Actualizado Correctamente");
                //Modificar Campo TOTAL
                vista.pedidos.menuPedido.txt_totalPedido.setText(this.cambiarFormatoMil(String.valueOf(subTotal)));
            }
            System.out.println("VALOR TOTAL: " + subTotal);
        }
    }

    private void btnActualizarListadoITEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarListadoITEMActionPerformed
        try {
            PedidoDao pedidox = new PedidoDao();
            int idPedido = Integer.parseInt(this.txt_idPedido.getText());
            if (pedidox.validarSiExistePedido(idPedido)) {
                this.eliminarContenidoTabla();
                this.cargarTablaInicio();
                this.actualizarTotalCampoyBD(idPedido);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarListadoITEMActionPerformed

    private void btnAgregarITEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarITEMActionPerformed
        try {
            //Validar que exista y pasar dato
            PedidoDao pedidox = new PedidoDao();
            if (pedidox.validarSiExistePedido(Integer.parseInt(this.txt_idPedido.getText()))) {
                vista.pedidos.agregarItemListadoPedido menu = new vista.pedidos.agregarItemListadoPedido();
                menu.setVisible(true);
                vista.pedidos.agregarItemListadoPedido.txt_idPedido.setText(this.txt_idPedido.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Debe agregar el id pedido primero");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarITEMActionPerformed

    private void tablaListadoPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaListadoPedidoMouseClicked
        if (evt.getClickCount() == 2) {
            int idPedido = Integer.parseInt(this.txt_idPedido.getText());
            int idListadoPedido = Integer.parseInt(vista.pedidos.menuPedido.tablaListadoPedido.getValueAt(vista.pedidos.menuPedido.tablaListadoPedido.getSelectedRow(), 0).toString());
            String nombreProducto = vista.pedidos.menuPedido.tablaListadoPedido.getValueAt(vista.pedidos.menuPedido.tablaListadoPedido.getSelectedRow(), 1).toString();
            int cantidad = Integer.parseInt(vista.pedidos.menuPedido.tablaListadoPedido.getValueAt(vista.pedidos.menuPedido.tablaListadoPedido.getSelectedRow(), 2).toString());
            long precioUnitario = Long.parseLong(vista.pedidos.menuPedido.tablaListadoPedido.getValueAt(vista.pedidos.menuPedido.tablaListadoPedido.getSelectedRow(), 3).toString());
            long subTotal = Long.parseLong(vista.pedidos.menuPedido.tablaListadoPedido.getValueAt(vista.pedidos.menuPedido.tablaListadoPedido.getSelectedRow(), 4).toString());

            vista.pedidos.modificarItemListadoPedido menu = new vista.pedidos.modificarItemListadoPedido();
            menu.setVisible(true);

            ProductoDao productox = new ProductoDao();
            int idProducto = productox.obtenerIDProductoPorNombre(nombreProducto);

            vista.pedidos.modificarItemListadoPedido.txt_idPedido.setText(String.valueOf(idPedido));
            vista.pedidos.modificarItemListadoPedido.txt_idListado.setText(String.valueOf(idListadoPedido));
            vista.pedidos.modificarItemListadoPedido.txt_cantidad.setText(this.cambiarFormatoMil(String.valueOf(cantidad)));
            vista.pedidos.modificarItemListadoPedido.txt_precioUnitario.setText(this.cambiarFormatoMil(String.valueOf(precioUnitario)));
            vista.pedidos.modificarItemListadoPedido.txt_subTotal.setText(this.cambiarFormatoMil(String.valueOf(subTotal)));
            vista.pedidos.modificarItemListadoPedido.txt_codigoProducto.setText(String.valueOf(idProducto));

            //Devolver datos listado segun ID-
        }
    }//GEN-LAST:event_tablaListadoPedidoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            PedidoDao pedidox = new PedidoDao();
            int idPedido = Integer.parseInt(this.txt_idPedido.getText());
            if (pedidox.validarSiExistePedido(idPedido)) {
                //Consultar si elimino
                int confirmacion = JOptionPane.YES_NO_OPTION;
                //System.out.println("Numero Confirmacion ELiminacion: "+ confirmacion);
                int numeroConfirmacion = JOptionPane.showConfirmDialog(null, "¿Desea Eliminarlo Realmente?", "Warning", confirmacion);

                if (numeroConfirmacion == 0) {
                    //Accion eliminar cotiza
                    if (pedidox.eliminarPedido(idPedido)) {
                        JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "El ID de ese pedido no existe, favor agregar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            PedidoDao pedidox = new PedidoDao();
            int idPedido = Integer.parseInt(this.txt_idPedido.getText());
            if (pedidox.validarSiExistePedido(idPedido)) {
                //Modifico si existe
            if (vista.pedidos.menuPedido.txt_personaSolicita.getText().isEmpty()) {
                    throw new Exception("El campo PERSONA SOLICITANTE no puede venir vacio");
                }

                if (vista.pedidos.menuPedido.txt_nroOT.getText().isEmpty()) {
                    throw new Exception("El campo NRO° ORDEN DE TRABAJO no puede venir vacio");
                }

                if (this.cboEstado.getSelectedIndex() == 0) {
                    throw new Exception("El campo ESTADO no puede venir vacio");
                }

                if (this.cboUrgencia.getSelectedIndex() == 0) {
                    throw new Exception("EL campo URGENCIA no puede venir vacio");
                }

                String nombrePersonaSolicita = vista.pedidos.menuPedido.txt_personaSolicita.getText().toUpperCase();
                int nroOT = Integer.parseInt(vista.pedidos.menuPedido.txt_nroOT.getText());
                String estado = this.cboEstado.getSelectedItem().toString();
                String urgencia = this.cboUrgencia.getSelectedItem().toString();

                //Metodo consultar rut segun nombre
                String rutPersona = pedidox.devolverRutTrabajador(nombrePersonaSolicita);
                System.out.println("RuT: " + rutPersona);
                
                if (pedidox.modificarCabeceraPedido(estado, urgencia, nroOT, idPedido,rutPersona)) {
                    JOptionPane.showMessageDialog(null, "Se modifico correctamente");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo modificar");
                }              
            } else {
                JOptionPane.showMessageDialog(null, "No existe el id de pedido a modificar, favor agregar el id de pedido primero");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarITEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarITEMActionPerformed
        try {
            PedidoDao pedidox = new PedidoDao();
            int idPedido = Integer.parseInt(vista.pedidos.menuPedido.txt_idPedido.getText());
            if (pedidox.validarSiExistePedido(idPedido)) {
                //Validar si hay una fila seleccionada y rescatar
                if (vista.pedidos.menuPedido.tablaListadoPedido.getSelectedRow() < 0) {
                    throw new Exception("Seleccione una fila para eliminar");
                }

                //Consultar si quiere eliminar
                int confirmacion = JOptionPane.YES_NO_OPTION;
                //System.out.println("Numero Confirmacion ELiminacion: "+ confirmacion);
                int numeroConfirmacion = JOptionPane.showConfirmDialog(null, "¿Desea Eliminarlo Realmente?", "Warning", confirmacion);
                if (numeroConfirmacion == 0) {
                    ListadoPedidoDao listadopedidox = new ListadoPedidoDao();
                    int idItemListadoPedido = Integer.parseInt(vista.pedidos.menuPedido.tablaListadoPedido.getValueAt(vista.pedidos.menuPedido.tablaListadoPedido.getSelectedRow(), 0).toString());
                    if (listadopedidox.eliminarITEM(idItemListadoPedido)) {
                        JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
                        this.eliminarContenidoTabla();
                        this.cargarTablaInicio();
                        this.actualizarTotalCampoyBD(idPedido);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Primero debe agregar el id pedido");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarITEMActionPerformed

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
//            java.util.logging.Logger.getLogger(menuPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(menuPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(menuPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(menuPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new menuPedido().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarListadoITEM;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarITEM;
    private javax.swing.JButton btnBuscaROT;
    private javax.swing.JButton btnBuscarPersona;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarITEM;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    public static javax.swing.JComboBox<String> cboEstado;
    public static javax.swing.JComboBox<String> cboUrgencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTable tablaListadoPedido;
    public static javax.swing.JLabel txt_fechaCreacion;
    public static javax.swing.JLabel txt_idPedido;
    public static javax.swing.JTextField txt_nroOT;
    public static javax.swing.JTextField txt_personaSolicita;
    public static javax.swing.JTextField txt_totalPedido;
    // End of variables declaration//GEN-END:variables
}
