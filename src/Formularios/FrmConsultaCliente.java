/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Banco.Conexao;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Abel
 */
public class FrmConsultaCliente extends javax.swing.JFrame {
    
    Connection conexao;

    /**
     * Creates new form FrmConsultaCliente
     */
    public FrmConsultaCliente() {
        initComponents();
        
        preencherJTable();
        
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
        txtPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Clientes");

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText("Pesquisa:");

        txtPesquisa.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtPesquisaPropertyChange(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
        });

        JTableClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableClientes);
        if (JTableClientes.getColumnModel().getColumnCount() > 0) {
            JTableClientes.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
         
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtPesquisaPropertyChange
      
    }//GEN-LAST:event_txtPesquisaPropertyChange

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
             FiltrarJTable();
    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void JTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableClientesMouseClicked
            if(evt.getClickCount() == 2) {
                
                Point p = evt.getPoint();
                
                int row = JTableClientes.rowAtPoint(p);
                String nome = String.valueOf(JTableClientes.getModel().getValueAt(row, 0));
                
                new FrmConsultaClienteDetalhe().retornaDados(nome);
                
            }
    }//GEN-LAST:event_JTableClientesMouseClicked

    
       private void FiltrarJTable()
    {
        TableRowSorter sorter = new TableRowSorter(JTableClientes.getModel());
        JTableClientes.setRowSorter(sorter);
        String texto = txtPesquisa.getText();
        
        
        try
        {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Valor não encontrado", "Aviso - Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
       
       
     private void preencherJTable(){
          
         
            JTableClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            //JTableClientes.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 24));
            DefaultTableModel modelo = (DefaultTableModel)JTableClientes.getModel();
            modelo.setNumRows(0);
            
          
     
            try
            {
         
                this.conexao = Conexao.getConexao();
                String sql = "Select nome from clientes";
                PreparedStatement ps = this.conexao.prepareStatement(sql);
                ResultSet rst = ps.executeQuery();

                while(rst.next())
                    modelo.addRow(new Object[]{rst.getString("nome")});
            
         
         
            }catch(SQLException err){

            }
     
     }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(FrmConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConsultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmConsultaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
