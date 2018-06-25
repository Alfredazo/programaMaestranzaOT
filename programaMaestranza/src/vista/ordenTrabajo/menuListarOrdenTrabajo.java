/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ordenTrabajo;

import clase.ExportarOT;
import clase.Factura;
import clase.ListadoPedido;
import clase.ListadoTrabajosRealizadosExportOT;
import clase.OrdenTrabajo;
import control.ExportarOTDAO;
import control.OrdenTrabajoDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Alfredo
 */
public class menuListarOrdenTrabajo extends javax.swing.JFrame {

    /**
     * Creates new form menuListarOrdenTrabajo
     */
    public menuListarOrdenTrabajo() {
        this.setTitle("Ventana Listar Ordenes de Trabajo");
        initComponents();
        this.cargarTablaInicio();
    }

    public void eliminarContenidoTabla() {
        DefaultTableModel tb = (DefaultTableModel) this.tablaOrdenTrabajos.getModel();
        int a = this.tablaOrdenTrabajos.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public void cargarTablaInicio() {
        try {
            OrdenTrabajoDao otx = new OrdenTrabajoDao();

            DefaultTableModel modelo = (DefaultTableModel) this.tablaOrdenTrabajos.getModel();
            ArrayList<OrdenTrabajo> listado = otx.listarTodasLasOrdenesDeTrabajo();

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getNumeroOT();
                fila[1] = listado.get(i).getNombreCliente();
                fila[2] = listado.get(i).getNombreResponsable();
                fila[3] = listado.get(i).getFechaInicio();
                fila[4] = listado.get(i).getFechaTermino();
                fila[5] = listado.get(i).getNombreOT();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema Tabla Proveedores: " + e.getMessage());
        }
    }

    public void cargarTablaInicioPorOT(int numeroOTBuscar) {
        try {
            OrdenTrabajoDao otx = new OrdenTrabajoDao();

            DefaultTableModel modelo = (DefaultTableModel) this.tablaOrdenTrabajos.getModel();
            ArrayList<OrdenTrabajo> listado = otx.listarTodasLasOrdenesDeTrabajo(numeroOTBuscar);

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getNumeroOT();
                fila[1] = listado.get(i).getNombreCliente();
                fila[2] = listado.get(i).getNombreResponsable();
                fila[3] = listado.get(i).getFechaInicio();
                fila[4] = listado.get(i).getFechaTermino();
                fila[5] = listado.get(i).getNombreOT();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema Tabla Proveedores: " + e.getMessage());
        }
    }

    public void cargarTablaInicioPorRangoNumeroOT(int desde, int hasta) {
        try {
            OrdenTrabajoDao otx = new OrdenTrabajoDao();

            DefaultTableModel modelo = (DefaultTableModel) this.tablaOrdenTrabajos.getModel();
            ArrayList<OrdenTrabajo> listado = otx.listarPorRangoNumeroOT(desde, hasta);

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getNumeroOT();
                fila[1] = listado.get(i).getNombreCliente();
                fila[2] = listado.get(i).getNombreResponsable();
                fila[3] = listado.get(i).getFechaInicio();
                fila[4] = listado.get(i).getFechaTermino();
                fila[5] = listado.get(i).getNombreOT();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema Tabla Proveedores: " + e.getMessage());
        }
    }

    public void cargarTablaInicioPorNombre(String nombreBuscar) {
        try {
            OrdenTrabajoDao otx = new OrdenTrabajoDao();

            DefaultTableModel modelo = (DefaultTableModel) this.tablaOrdenTrabajos.getModel();
            ArrayList<OrdenTrabajo> listado = otx.listarPorNombreBuscar(nombreBuscar);

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getNumeroOT();
                fila[1] = listado.get(i).getNombreCliente();
                fila[2] = listado.get(i).getNombreResponsable();
                fila[3] = listado.get(i).getFechaInicio();
                fila[4] = listado.get(i).getFechaTermino();
                fila[5] = listado.get(i).getNombreOT();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema Tabla Proveedores: " + e.getMessage());
        }
    }

    public void cargarTablaInicioPorFecha(String fechaBuscar) {
        try {
            OrdenTrabajoDao otx = new OrdenTrabajoDao();

            DefaultTableModel modelo = (DefaultTableModel) this.tablaOrdenTrabajos.getModel();
            ArrayList<OrdenTrabajo> listado = otx.listarPorFechaCreacion(fechaBuscar);

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getNumeroOT();
                fila[1] = listado.get(i).getNombreCliente();
                fila[2] = listado.get(i).getNombreResponsable();
                fila[3] = listado.get(i).getFechaInicio();
                fila[4] = listado.get(i).getFechaTermino();
                fila[5] = listado.get(i).getNombreOT();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema Tabla Proveedores: " + e.getMessage());
        }
    }

    
    public void cargarTablaInicioPorFechaRango(String desde, String hasta) {
        try {
            OrdenTrabajoDao otx = new OrdenTrabajoDao();

            DefaultTableModel modelo = (DefaultTableModel) this.tablaOrdenTrabajos.getModel();
            ArrayList<OrdenTrabajo> listado = otx.listarPorFechaCreacionPorRango(desde, hasta);

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getNumeroOT();
                fila[1] = listado.get(i).getNombreCliente();
                fila[2] = listado.get(i).getNombreResponsable();
                fila[3] = listado.get(i).getFechaInicio();
                fila[4] = listado.get(i).getFechaTermino();
                fila[5] = listado.get(i).getNombreOT();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_numeroOT_desde = new javax.swing.JTextField();
        btnBuscarPorOT = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_numeroOT = new javax.swing.JTextField();
        txt_numeroOT_hasta = new javax.swing.JTextField();
        btnBuscarPorRango = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nombreResponsable = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnActualizar1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_fechaCreacionBuscar = new javax.swing.JTextField();
        btnBuscarPORFEcha = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_fecha_Desde = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_fecha_hasta = new javax.swing.JTextField();
        btnBuscarPorFechaRangos = new javax.swing.JButton();
        btnActualizar2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOrdenTrabajos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Numero ORDEN");

        btnBuscarPorOT.setText("Buscar");
        btnBuscarPorOT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorOTActionPerformed(evt);
            }
        });

        jLabel3.setText("Buscar por Rango Orden");

        jLabel4.setText("DESDE:");

        jLabel5.setText("HASTA");

        btnBuscarPorRango.setText("Buscar");
        btnBuscarPorRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorRangoActionPerformed(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnExportar.setText("EXPORTAR");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txt_numeroOT, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnBuscarPorOT, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_numeroOT_desde, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_numeroOT_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarPorRango, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txt_numeroOT_desde)
                                .addComponent(jLabel5)
                                .addComponent(txt_numeroOT_hasta)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBuscarPorOT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_numeroOT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarPorRango, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Buscar Por Número ORDEN", jPanel4);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nombre Responsable:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnActualizar1.setText("ACTUALIZAR");
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_nombreResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 449, Short.MAX_VALUE)
                .addComponent(btnActualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_nombreResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buscar por Responsable", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("FECHA CREACIÓN");

        btnBuscarPORFEcha.setText("Buscar");
        btnBuscarPORFEcha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPORFEchaActionPerformed(evt);
            }
        });

        jLabel7.setText("Buscar por Rango FECHAS");

        jLabel8.setText("DESDE:");

        jLabel9.setText("HASTA");

        btnBuscarPorFechaRangos.setText("Buscar");
        btnBuscarPorFechaRangos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorFechaRangosActionPerformed(evt);
            }
        });

        btnActualizar2.setText("ACTUALIZAR");
        btnActualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txt_fechaCreacionBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnBuscarPORFEcha, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_fecha_Desde, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_fecha_hasta, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPorFechaRangos, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(btnActualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txt_fecha_Desde)
                                .addComponent(jLabel9)
                                .addComponent(txt_fecha_hasta)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBuscarPORFEcha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_fechaCreacionBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarPorFechaRangos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Buscar Por Fecha", jPanel3);

        tablaOrdenTrabajos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NRO° OT", "CLIENTE", "PERSONA A CARGO", "FECHA INICIO", "FECHA TERMINO", "NOMBRE OT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaOrdenTrabajos.getTableHeader().setReorderingAllowed(false);
        tablaOrdenTrabajos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaOrdenTrabajosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaOrdenTrabajos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaOrdenTrabajosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOrdenTrabajosMouseClicked
        try {
            if (evt.getButton() == 3) {
                if (this.tablaOrdenTrabajos.getSelectedRowCount() == 0) {
                    throw new Exception("Seleccione una fila primero");
                }
                int confirmacion = JOptionPane.YES_NO_OPTION;
                int numeroConfirmacion = JOptionPane.showConfirmDialog(null, "¿Desea Mostrar Información Facturas y OC?", "Warning", confirmacion);
                if (numeroConfirmacion == 0) {
                    OrdenTrabajoDao otx = new OrdenTrabajoDao();
                    int numeroOT = Integer.parseInt(this.tablaOrdenTrabajos.getValueAt(this.tablaOrdenTrabajos.getSelectedRow(), 0).toString());
                    Factura factura = otx.obtenerFacturaOCPorNumeroOT(numeroOT);
                    String mensaje = "FACTURA 1:                   " + factura.getFactura1() + "    ";
                    mensaje += "\nFACTURA 2:                   " + factura.getFactura2() + "    ";
                    mensaje += "\nFACTURA 3:                   " + factura.getFactura3() + "    ";
                    mensaje += "\nFACTURA 4:                   " + factura.getFactura4() + "    ";
                    mensaje += "\nFACTURA 5:                   " + factura.getFactura5() + "    ";
                    mensaje += "\nNRO ORDEN:                " + factura.getNumeroOC() + "    ";
                    JOptionPane.showMessageDialog(null, mensaje);
                }
            } else if (evt.getClickCount() == 2 && evt.getButton() == 1) {
                /*Enviar datos al otro menu*/
                int numeroOT = Integer.parseInt(this.tablaOrdenTrabajos.getValueAt(this.tablaOrdenTrabajos.getSelectedRow(), 0).toString());
                vista.ordenTrabajo.menuOT menu = new vista.ordenTrabajo.menuOT();
                menu.setVisible(true);
                //Metodo Rescatar datos y hacer metodo rescatar
                OrdenTrabajoDao otx = new OrdenTrabajoDao();
                OrdenTrabajo ot = otx.obtenerOrdenTrabajo(numeroOT);
                //Enviar datos rescatados
                vista.ordenTrabajo.menuOT.txt_nroOrdenTrabajo.setText(String.valueOf(numeroOT));
                vista.ordenTrabajo.menuOT.txt_fechaCreacionHoy.setText(ot.getFechaInicio());
                vista.ordenTrabajo.menuOT.txt_fechaTermino.setText(ot.getFechaTermino());
                vista.ordenTrabajo.menuOT.txt_nombreCliente.setText(ot.getNombreCliente());
                vista.ordenTrabajo.menuOT.txt_nombreResponsable.setText(ot.getNombreResponsable());
                vista.ordenTrabajo.menuOT.txt_facturasAsignadas.setText(String.valueOf(ot.getIdFactura()));
                vista.ordenTrabajo.menuOT.txt_OrdenCompra.setText(String.valueOf(ot.getNroOrden()));
                vista.ordenTrabajo.menuOT.txt_descripcion.setText(ot.getDescripcion());
                vista.ordenTrabajo.menuOT.txt_nombreOT.setText(ot.getNombreOT());

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tablaOrdenTrabajosMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.eliminarContenidoTabla();
        this.cargarTablaInicio();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBuscarPorOTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorOTActionPerformed
        try {
            if (this.txt_numeroOT.getText().isEmpty()) {
                throw new Exception("Para utilizar esta función, ingrese un numero de Orden de trabajo");
            }
            int numeroOT = Integer.parseInt(this.txt_numeroOT.getText());
            this.eliminarContenidoTabla();
            this.cargarTablaInicioPorOT(numeroOT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarPorOTActionPerformed

    private void btnBuscarPorRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorRangoActionPerformed
        try {
            if (this.txt_numeroOT_desde.getText().isEmpty()) {
                throw new Exception("Para utilizar esta funcion ingrese un numero a buscar");
            }
            int numeroOTDesde = Integer.parseInt(this.txt_numeroOT_desde.getText());

            int numeroHasta = 9999999;
            if (!this.txt_numeroOT_hasta.getText().isEmpty()) {
                numeroHasta = Integer.parseInt(this.txt_numeroOT_hasta.getText());
            }

            //Cargar datos
            this.eliminarContenidoTabla();
            this.cargarTablaInicioPorRangoNumeroOT(numeroOTDesde, numeroHasta);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarPorRangoActionPerformed

    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed
        this.eliminarContenidoTabla();
        this.cargarTablaInicio();
    }//GEN-LAST:event_btnActualizar1ActionPerformed

    private void btnActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar2ActionPerformed
        // TODO add your handling code here:
        this.eliminarContenidoTabla();
        this.cargarTablaInicio();
    }//GEN-LAST:event_btnActualizar2ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            if (this.txt_nombreResponsable.getText().isEmpty()) {
                throw new Exception("Para utilizar esta funcion, ingrese al menos una letra");
            }

            String nombreBuscar = this.txt_nombreResponsable.getText().toUpperCase();

            //Realizar metodo
            this.eliminarContenidoTabla();
            this.cargarTablaInicioPorNombre(nombreBuscar);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarPORFEchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPORFEchaActionPerformed
        try {
            if (this.txt_fechaCreacionBuscar.getText().isEmpty()) {
                throw new Exception("Para utilizar esta funcion, debe ingresar una fecha a buscar");
            }

            String fechaCreacion = this.txt_fechaCreacionBuscar.getText();

            //Dar formato fecha
//            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//            fechaCreacion = format.format(fechaCreacion);

            this.eliminarContenidoTabla();
            this.cargarTablaInicioPorFecha(fechaCreacion);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarPORFEchaActionPerformed

    private void btnBuscarPorFechaRangosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorFechaRangosActionPerformed
       try{
           if (this.txt_fecha_Desde.getText().isEmpty()) {
               throw new Exception("Para utilizar esta opcion ingrese una fecha de partida");
           }
           String fechaCreacionDesde = this.txt_fecha_Desde.getText();
           String fechaCreacionHasta = "31-12-9999";
           if (!this.txt_fecha_hasta.getText().isEmpty()) {
               fechaCreacionHasta = this.txt_fecha_hasta.getText();
           }
           
           this.eliminarContenidoTabla();
           this.cargarTablaInicioPorFechaRango(fechaCreacionDesde, fechaCreacionHasta);
           
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }//GEN-LAST:event_btnBuscarPorFechaRangosActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
       try {
           if (this.tablaOrdenTrabajos.getSelectedRow() <0) {
               throw new Exception("Primero seleccione una fila.");
           }
 
           
            int nroOT = Integer.parseInt(this.tablaOrdenTrabajos.getValueAt(this.tablaOrdenTrabajos.getSelectedRow(), 0).toString());
            
            OrdenTrabajoDao ot = new OrdenTrabajoDao();
            if (!ot.validarSiExiste(nroOT)) {
                throw new Exception("No existe el número de Orden Trabajo");
            }
            
            String nombreUsuario = System.getProperty("user.name");

            Calendar today = Calendar.getInstance();
            Date fechaHoy = today.getTime();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String fechaStringBase = format.format(fechaHoy);

            String nuevaCarpeta = "FECHA-" + fechaStringBase;
            //Crear directorio y comprobar si existe        
            File file = new File("C:/Users/" + nombreUsuario + "/Desktop/ORDENCOPIAS/" + nuevaCarpeta);
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("Directory is created!");
                }
            }

            ExportarOTDAO exportar = new ExportarOTDAO();

            //Rescatar cabecera 
            ExportarOT ordenTrabajo = exportar.rescatarCabeceraExport(nroOT);

            InputStream ExcelFileToRead = new FileInputStream("C:/FORMATOS/FORMATOOTCOPIA.xls");
            // OPCPackage pkg = OPCPackage.open(new File("C:/Users/Alfredo/Desktop/PEDIDOS/FORMATO.xlsx"));
            HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
            //XSSFWorkbook wb = new XSSFWorkbook(pkg);
            String nombreHoja = wb.getSheetName(0);
            //HSSFSheet hoja = wb.getSheet(nombreHoja);
            HSSFSheet hoja = wb.getSheetAt(0);
            System.out.println("HOJA EXCEL: " + hoja);

            HSSFRow row = hoja.createRow(0);
            HSSFCell cell = row.createCell(1);
            //Nombre empresa
            cell.setCellValue(ordenTrabajo.getNombreEmpresa());
            //Giro
            row = hoja.createRow(1);
            cell = row.createCell(1);
            cell.setCellValue(ordenTrabajo.getGiroEmpresa());
            //RUT
            row = hoja.createRow(2);
            cell = row.createCell(1);
            cell.setCellValue(ordenTrabajo.getRutEmpresa());
            //Nro Telefono
            row = hoja.createRow(3);
            cell = row.createCell(1);
            cell.setCellValue(ordenTrabajo.getNroEmpresa());
            //Direccion
            row = hoja.createRow(4);
            cell = row.createCell(1);
            cell.setCellValue(ordenTrabajo.getDireccion());
            //NOMBRE CONTACTO
            row = hoja.createRow(5);
            cell = row.createCell(1);
            cell.setCellValue(ordenTrabajo.getNombreContacto());
            //Nro Contcto
            row = hoja.createRow(6);
            cell = row.createCell(1);
            cell.setCellValue(ordenTrabajo.getNroContacto());
            //NOMBRE OT
            row = hoja.createRow(7);
            cell = row.createCell(1);
            cell.setCellValue(ordenTrabajo.getNombreOT());
            //NRO ORDEN
            row = hoja.createRow(8);
            cell = row.createCell(1);
            cell.setCellValue(nroOT);
            //NOMBRE RESPONSABLE
            row = hoja.createRow(9);
            cell = row.createCell(1);
            cell.setCellValue(ordenTrabajo.getNombreResponsable());
            //FECHA INICIO
            row = hoja.createRow(10);
            cell = row.createCell(1);
            cell.setCellValue(ordenTrabajo.getFechaInicio());
            //FECHA Termino
            row = hoja.createRow(11);
            cell = row.createCell(1);
            cell.setCellValue(ordenTrabajo.getFechaTermino());
            //FACTURAS
            row = hoja.createRow(12);
            cell = row.createCell(1);
            String facturas = ordenTrabajo.getNroFactura1() + " / " + ordenTrabajo.getNroFactura2() + " / " + ordenTrabajo.getNroFactura3() + " / " + ordenTrabajo.getNroFactura4() + " / " + ordenTrabajo.getNroFactura5();
            cell.setCellValue(facturas);
            //NRO OC
            row = hoja.createRow(13);
            cell = row.createCell(1);
            cell.setCellValue(ordenTrabajo.getNroOrdenCompra());
            //Descripcion
            row = hoja.createRow(14);
            cell = row.createCell(1);
            cell.setCellValue(ordenTrabajo.getDescripcionOT());
            
            
            String rutaNueva = "C:/Users/" + nombreUsuario + "/Desktop/ORDENCOPIAS/" + nuevaCarpeta + "/NRO OT -" + nroOT + ".xls";
            FileOutputStream fileOut = new FileOutputStream(rutaNueva);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
            JOptionPane.showMessageDialog(null, "Exportado correctamente \n" + rutaNueva);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnExportarActionPerformed

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
//            java.util.logging.Logger.getLogger(menuListarOrdenTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(menuListarOrdenTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(menuListarOrdenTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(menuListarOrdenTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new menuListarOrdenTrabajo().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JButton btnActualizar2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarPORFEcha;
    private javax.swing.JButton btnBuscarPorFechaRangos;
    private javax.swing.JButton btnBuscarPorOT;
    private javax.swing.JButton btnBuscarPorRango;
    private javax.swing.JButton btnExportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaOrdenTrabajos;
    private javax.swing.JTextField txt_fechaCreacionBuscar;
    private javax.swing.JTextField txt_fecha_Desde;
    private javax.swing.JTextField txt_fecha_hasta;
    private javax.swing.JTextField txt_nombreResponsable;
    private javax.swing.JTextField txt_numeroOT;
    private javax.swing.JTextField txt_numeroOT_desde;
    private javax.swing.JTextField txt_numeroOT_hasta;
    // End of variables declaration//GEN-END:variables

}
