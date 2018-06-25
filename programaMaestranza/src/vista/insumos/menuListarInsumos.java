/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.insumos;

import clase.Insumo;
import clase.InsumoExportacion;
import clase.ListadoCotizacion;
import clase.ListadoExportarCotizacion;
import clase.ListadoInsumos;
import control.CotizacionDao;
import control.InsumoDao;
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
public class menuListarInsumos extends javax.swing.JFrame {

    /**
     * Creates new form menuListarInsumos
     */
    public menuListarInsumos() {
        this.setTitle("Ventana Buscar Listado Insumos ");
        initComponents();
        this.cargarTablaInicio();
    }

    public void eliminarContenidoTabla() {
        DefaultTableModel tb = (DefaultTableModel) this.tablaInsumos.getModel();
        int a = this.tablaInsumos.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
    }

    public void cargarTablaInicio() {
        try {
            InsumoDao insumox = new InsumoDao();

            DefaultTableModel modelo = (DefaultTableModel) this.tablaInsumos.getModel();
            ArrayList<Insumo> listado = insumox.listadoInsumo();

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getIdInsumo();
                fila[1] = listado.get(i).getNumeroOT();
                fila[2] = listado.get(i).getNombreOT();
                fila[3] = listado.get(i).getNombreEmpresa();
                fila[4] = listado.get(i).getTotal();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problema Tabla Proveedores: " + e.getMessage());
        }
    }

    public void cargarTablaInicio(int nroOT) {
        try {
            InsumoDao insumox = new InsumoDao();

            DefaultTableModel modelo = (DefaultTableModel) this.tablaInsumos.getModel();
            ArrayList<Insumo> listado = insumox.listadoInsumo(nroOT);

            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listado.size(); i++) {
                fila[0] = listado.get(i).getIdInsumo();
                fila[1] = listado.get(i).getNumeroOT();
                fila[2] = listado.get(i).getNombreOT();
                fila[3] = listado.get(i).getNombreEmpresa();
                fila[4] = listado.get(i).getTotal();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_numeroOT = new javax.swing.JTextField();
        btnConsultarOT = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInsumos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Numero Orden de Trabajo:");

        btnConsultarOT.setText("?");
        btnConsultarOT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarOTActionPerformed(evt);
            }
        });

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_numeroOT, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarOT)
                .addGap(22, 22, 22)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_numeroOT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnConsultarOT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnActualizar)
                    .addComponent(btnExportar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buscar insumos por numero de OT", jPanel1);

        tablaInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NUMERO OT", "NOMBRE OT", "CLIENTE", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInsumos.getTableHeader().setReorderingAllowed(false);
        tablaInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInsumosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaInsumos);

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaInsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInsumosMouseClicked
        try {
            if (evt.getClickCount() == 2) {
                int idInsumos = Integer.parseInt(this.tablaInsumos.getValueAt(this.tablaInsumos.getSelectedRow(), 0).toString());
                int nroOT = Integer.parseInt(this.tablaInsumos.getValueAt(this.tablaInsumos.getSelectedRow(), 1).toString());

                vista.insumos.menuInsumo menu = new vista.insumos.menuInsumo();
                menu.setVisible(true);

                vista.insumos.menuInsumo.txt_nroOT.setText(String.valueOf(nroOT));
                vista.insumos.menuInsumo.txt_idInsumos.setText(String.valueOf(idInsumos));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tablaInsumosMouseClicked

    private void btnConsultarOTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarOTActionPerformed
        try {
            vista.insumos.menuConsultarOTInsumosListar menu = new vista.insumos.menuConsultarOTInsumosListar();
            menu.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnConsultarOTActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.eliminarContenidoTabla();
        this.cargarTablaInicio();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            if (vista.insumos.menuListarInsumos.txt_numeroOT.getText().isEmpty()) {
                throw new Exception("Para usar esta funcion, ingrese Nro° OT ");
            }
            int nroOT = Integer.parseInt(vista.insumos.menuListarInsumos.txt_numeroOT.getText());

            this.eliminarContenidoTabla();
            this.cargarTablaInicio(nroOT);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        try {
            if (this.tablaInsumos.getSelectedRowCount() < 0) {
                throw new Exception("Seleccione una fila para utilizar esta funcion");
            }

            String nombreUsuario = System.getProperty("user.name");

            Calendar today = Calendar.getInstance();
            Date fechaHoy = today.getTime();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String fechaStringBase = format.format(fechaHoy);

            String nuevaCarpeta = "FECHA-HOY-" + fechaStringBase;
            //Crear directorio y comprobar si existe
            File file = new File("C:/Users/" + nombreUsuario + "/Desktop/INSUMOS/" + nuevaCarpeta);
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("Directory is created!");
                }
            }

            InputStream ExcelFileToRead = new FileInputStream("C:/FORMATOS/FORMATOINSUMO.xls");
            // OPCPackage pkg = OPCPackage.open(new File("C:/Users/Alfredo/Desktop/PEDIDOS/FORMATO.xlsx"));
            HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
            //XSSFWorkbook wb = new XSSFWorkbook(pkg);
            String nombreHoja = wb.getSheetName(0);
            //HSSFSheet hoja = wb.getSheet(nombreHoja);
            HSSFSheet hoja = wb.getSheetAt(0);
            System.out.println("HOJA EXCEL: " + hoja);

            int idInsumo = Integer.parseInt(this.tablaInsumos.getValueAt(this.tablaInsumos.getSelectedRow(), 0).toString());
            int nroOT = Integer.parseInt(this.tablaInsumos.getValueAt(this.tablaInsumos.getSelectedRow(), 1).toString());

            InsumoDao insumito = new InsumoDao();
            InsumoExportacion insumox = insumito.objetoExportarInsumo(idInsumo);

            HSSFRow row = hoja.createRow(0);
            HSSFCell cell = row.createCell(1);
            //Nombre empresa
            cell.setCellValue(insumox.getNombreEmpresa());
            //Nombre OT
            row = hoja.createRow(1);
            cell = row.createCell(1);
            cell.setCellValue(insumox.getNombreOT());
            //Nombre Responsable
            row = hoja.createRow(2);
            cell = row.createCell(1);
            cell.setCellValue(insumox.getNombreResponsable());
            //Nro insumo
            row = hoja.createRow(3);
            cell = row.createCell(1);
            cell.setCellValue(insumox.getIdInsumo());
            //TOTAL
            row = hoja.createRow(4);
            cell = row.createCell(1);
            cell.setCellValue(insumox.getSubTotalInsumo());
            //N° OT
            row = hoja.createRow(5);
            cell = row.createCell(1);
            cell.setCellValue(insumox.getNroOT());

            //Recorrer listado
            ArrayList<ListadoInsumos> listadoRecorrer = insumito.listadoItemsInsumo(idInsumo);
            int filaInicial = 10;
            int columnaRecorre = 0;
            /*Seleccionar fila inicial*/
            for (int i = 0; i < listadoRecorrer.size(); i++) {
                row = hoja.createRow(filaInicial++);
                for (int j = 0; j <= 4; j++) {
                    cell = row.createCell(j);
                    if (j == 0) {
                        //Primera columna
                        cell.setCellValue(listadoRecorrer.get(i).getNombreProducto());
                    } else if (j == 1) {
                        cell.setCellValue(listadoRecorrer.get(i).getFechaCreacion());
                    } else if (j == 2) {
                        cell.setCellValue(listadoRecorrer.get(i).getCantidad());
                    } else if (j == 3) {
                        cell.setCellValue(listadoRecorrer.get(i).getPrecioUnitario());
                    }else if(j==4){
                        cell.setCellValue(listadoRecorrer.get(i).getSubTotal());
                    }
                }
            }

            String rutaNueva = "C:/Users/" + nombreUsuario + "/Desktop/INSUMOS/" + nuevaCarpeta + "/ID INSUMO -" + idInsumo + ".xls";
            FileOutputStream fileOut = new FileOutputStream(rutaNueva);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
            JOptionPane.showMessageDialog(null, "Exportado Correctamente\n"+rutaNueva);
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
//            java.util.logging.Logger.getLogger(menuListarInsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(menuListarInsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(menuListarInsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(menuListarInsumos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new menuListarInsumos().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConsultarOT;
    private javax.swing.JButton btnExportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaInsumos;
    public static javax.swing.JTextField txt_numeroOT;
    // End of variables declaration//GEN-END:variables
}
