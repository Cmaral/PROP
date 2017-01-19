/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import java.awt.CardLayout;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Claudia Martinez Alquezar
 */

public class VistaConsultas extends javax.swing.JFrame {
    private CtrlPresentacion cPresentacion;
    private SortedSet<String> listaP;
    private Set<AbstractMap.SimpleEntry<String,String> > listaS;
    private int key;
    
    private int linea;
    private int count;
   
    /**
     * Creates new form VistaConsultas
     */
    public VistaConsultas() {
        initComponents();
    }
    
    public VistaConsultas(CtrlPresentacion cPresentacion) {
        this.cPresentacion = cPresentacion;
        this.setTitle("Consulta");
        initComponents();
    }
     public void visible() {
        this.setVisible(true);
    }
     
     public void iniTableDosColumnas(Set<AbstractMap.SimpleEntry<String,String> > lista) {
         this.listaS = lista;
         DefaultTableModel model = (DefaultTableModel)jTableDocs.getModel(); 
         int columns = model.getColumnCount();
         int i=0;
         for(final Iterator it = listaS.iterator(); it.hasNext(); ) {
             AbstractMap.SimpleEntry<String,String>  e = (AbstractMap.SimpleEntry<String,String>) it.next();
             model.addRow(new Object[columns]); 
             jTableDocs.setModel(model); 
             jTableDocs.setValueAt(i+1, i, 0); 
             jTableDocs.setValueAt((e.getKey()), i, 0);
             jTableDocs.setValueAt((e.getValue()), i, 1);
             jTableDocs.setValueAt((false), i, 2);
             ++i;                       
         }
     }
     
     public void iniTableUnaColumna(SortedSet<String> lista) {
         CardLayout card = (CardLayout)Panel.getLayout();
         card.show(Panel, "Autores");
         this.listaP = lista;
         DefaultTableModel model = (DefaultTableModel)jTableAutores.getModel(); 
         int columns = model.getColumnCount(); 
         int i=0;
         for(final Iterator it = listaP.iterator(); it.hasNext(); ) {
             model.addRow(new Object[columns]); 
             jTableAutores.setModel(model); 
             jTableAutores.setValueAt(i+1, i, 0); 
             jTableAutores.setValueAt(it.next(), i, 0);
             ++i;                       
         }
     }
     
     public void cuentaLineas() {
        DefaultTableModel model = (DefaultTableModel) jTableDocs.getModel();
        int rows = jTableDocs.getRowCount();
        count = 0;
        for (int i=0; i<rows; ++i) {
            if ((Boolean)model.getValueAt(i, 2) == true) {
                    ++count;
                    linea = i;
            } 
            model.setValueAt(false, i, 2);
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

        Panel = new javax.swing.JPanel();
        PanelDocs = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDocs = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        PanelAutores = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAutores = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        Panel.setLayout(new java.awt.CardLayout());

        jButton1.setText("Ver documento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar documento");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Buscar documentos parecidos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Atrás");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Salir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTableDocs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Autor", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDocs.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTableDocs);
        jTableDocs.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (jTableDocs.getColumnModel().getColumnCount() > 0) {
            jTableDocs.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDocsLayout = new javax.swing.GroupLayout(PanelDocs);
        PanelDocs.setLayout(PanelDocsLayout);
        PanelDocsLayout.setHorizontalGroup(
            PanelDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDocsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDocsLayout.createSequentialGroup()
                        .addGroup(PanelDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDocsLayout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(PanelDocsLayout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        PanelDocsLayout.setVerticalGroup(
            PanelDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDocsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelDocsLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(31, 31, 31)
                        .addComponent(jButton3)
                        .addGap(31, 31, 31)
                        .addGroup(PanelDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(PanelDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel.add(PanelDocs, "Docs");

        jTableAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Autor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableAutores);
        jTableAutores.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jButton7.setBackground(new java.awt.Color(102, 255, 255));
        jButton7.setText("Atrás");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(102, 255, 255));
        jButton8.setText("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAutoresLayout = new javax.swing.GroupLayout(PanelAutores);
        PanelAutores.setLayout(PanelAutoresLayout);
        PanelAutoresLayout.setHorizontalGroup(
            PanelAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAutoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(28, 28, 28))
        );
        PanelAutoresLayout.setVerticalGroup(
            PanelAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAutoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7)
                        .addComponent(jButton8))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel.add(PanelAutores, "Autores");

        getContentPane().add(Panel);

        setSize(new java.awt.Dimension(752, 476));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) jTableDocs.getModel();
        String autor;
        String titulo;
        int rows = jTableDocs.getRowCount();
        cuentaLineas();
        
        if (count == 1) {                
                titulo = ((String)model.getValueAt(linea, 0));   
                autor = ((String)model.getValueAt(linea, 1));
                VistaDocumento vDocumento = cPresentacion.abreDocumentoConsulta(titulo,autor);
        } else JOptionPane.showMessageDialog(rootPane, "Selecciona un único documento.");
        jTableDocs.clearSelection();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        VistaMenuConsultas obj = new VistaMenuConsultas(cPresentacion);
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cPresentacion.controlaVistas("Principal");
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!cPresentacion.esPrivilegiado()) JOptionPane.showMessageDialog(rootPane, "Se necesitan privilegios para acceder a esta función.");
        else {
            DefaultTableModel model = (DefaultTableModel) jTableDocs.getModel();
            String autor;
            String titulo;
            int rows = jTableDocs.getRowCount();
            for (int i=0; i<rows; ++i) {
                if ((Boolean)model.getValueAt(i, 2) == true) { 
                    titulo = ((String)model.getValueAt(i, 0));   
                    autor = ((String)model.getValueAt(i, 1));
                    cPresentacion.bajaDocumento(titulo,autor);
                    model.removeRow(i);
                    --i;
                    --rows;
                }
            }
        }
        cuentaLineas();

        jTableDocs.clearSelection();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        VistaMenuConsultas obj = new VistaMenuConsultas(cPresentacion);
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        cPresentacion.controlaVistas("Principal");
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableDocs.getModel();
        String autor;
        String titulo;
        int rows = jTableDocs.getRowCount();
        cuentaLineas();
        
        if (count == 1) {                
                titulo = ((String)model.getValueAt(linea, 0));   
                autor = ((String)model.getValueAt(linea, 1));
                String t = jTextField1.getText().replaceAll(" ", "");
                if (t.length() == 0) JOptionPane.showMessageDialog(rootPane, "Escribe número de documentos parecidos a buscar.");
                else {
                    int k = Integer.parseInt(t);
                    cPresentacion.consultarDocumentosParecidos(titulo, autor, k);
                    dispose();
                }                
        } else JOptionPane.showMessageDialog(rootPane, "Selecciona un único documento.");
        jTableDocs.clearSelection();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaConsultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel PanelAutores;
    private javax.swing.JPanel PanelDocs;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAutores;
    private javax.swing.JTable jTableDocs;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}