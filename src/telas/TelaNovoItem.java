/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import br.com.biblisis.controller.CObra;
import br.com.biblisis.controller.CExemplar;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author romeu
 */
public class TelaNovoItem extends javax.swing.JFrame {
    String [] obra = null;
    /**
     * Creates new form TelaNovoItem
     */
    public TelaNovoItem() {
        initComponents();
    }
    
    public void chamaCadastroDeNovaObra(){
        TelaNovoItem2 novaTela = new TelaNovoItem2 (); 
        novaTela.setVisible(true);
        dispose();
    }

    private String [] buscaObra(int codigoDaObra){
        String [] resposta = null;
        try {
            resposta = CObra.search(codigoDaObra);
        }catch (SQLException e) {
            System.out.println("Erro!" + e);
            return resposta;
        }
        return resposta;
    }
    
    private String [] buscaExemplar(int codigoDoExemplar, int codigoDaObra){
        String [] resposta = null;
        try {
            resposta = CExemplar.search(codigoDoExemplar, codigoDaObra);
        }catch (SQLException e) {
            System.out.println("Erro!" + e);
            return resposta;
        }
        return resposta;
    }
    
    private int geraCodigo (){ //com 9 dígitos
        Random gerador = new Random ();
        int codigo = 000000000 + gerador.nextInt(999999999);
        return codigo;
    }
    
    private int adicionaExemplar (int codigoDaObra){
        int novoCodigo;
        do{
           novoCodigo = geraCodigo();
        } while(buscaExemplar(novoCodigo, codigoDaObra)!= null);
        try {
            CExemplar.create(novoCodigo, codigoDaObra, false);
        }catch (SQLException e) {
            System.out.println("Erro!" + e);
            return novoCodigo;
        }
        return novoCodigo;
        
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
        jLabel2 = new javax.swing.JLabel();
        txtCodigoDaObra = new javax.swing.JTextField();
        btnVerificarObra = new javax.swing.JButton();
        btnAdicionarExemplar = new javax.swing.JButton();
        lblResultado = new javax.swing.JLabel();
        btnCadastrarNovaObra = new javax.swing.JButton();
        btnFechar3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Novo Exemplar");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("CÓDIGO DA OBRA");

        txtCodigoDaObra.setToolTipText("digite uma obra");
        txtCodigoDaObra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoDaObraKeyPressed(evt);
            }
        });

        btnVerificarObra.setText("Verificar Obra");
        btnVerificarObra.setToolTipText("verifica existência da obra ");
        btnVerificarObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarObraActionPerformed(evt);
            }
        });

        btnAdicionarExemplar.setText("Adicionar Exemplar");
        btnAdicionarExemplar.setToolTipText("adicona novo exemplar da obra ");
        btnAdicionarExemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarExemplarActionPerformed(evt);
            }
        });

        lblResultado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblResultado.setText("Clique em Verificar Obra");
        lblResultado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCadastrarNovaObra.setText("Cadastrar Nova Obra");
        btnCadastrarNovaObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarNovaObraActionPerformed(evt);
            }
        });

        btnFechar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons8-close-window-24.png"))); // NOI18N
        btnFechar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdicionarExemplar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCadastrarNovaObra)
                                .addGap(0, 290, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVerificarObra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoDaObra)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(btnFechar3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoDaObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerificarObra)
                    .addComponent(lblResultado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarNovaObra)
                    .addComponent(btnAdicionarExemplar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarObraActionPerformed
        String codigo = txtCodigoDaObra.getText();
        if (!codigo.matches("[A-Za-z]{1,}")){
            if (!codigo.equals("")){
                obra = buscaObra(Integer.parseInt(codigo)); 
            }
            if (obra != null){
                lblResultado.setText(obra[1]);
                btnAdicionarExemplar.setEnabled(true);
            }else{
                lblResultado.setText("Obra não cadastrada!"); 
            }
        }
        
        
    }//GEN-LAST:event_btnVerificarObraActionPerformed

    private void btnAdicionarExemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarExemplarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja adicionar um novo exemplar para '" + obra[1] + "' ?");
        if (resposta == 0){
           int codigoDoNovoExemplar = adicionaExemplar(Integer.parseInt(obra[0]));
            lblResultado.setText("Código gerado: " + codigoDoNovoExemplar);
            JOptionPane.showMessageDialog(null, "Novo exemplar de '" +obra[1] + "' adicionado com sucesso!"); 
        }
    }//GEN-LAST:event_btnAdicionarExemplarActionPerformed

    private void btnFechar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar3ActionPerformed
        dispose();
    }//GEN-LAST:event_btnFechar3ActionPerformed

    private void btnCadastrarNovaObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarNovaObraActionPerformed
        chamaCadastroDeNovaObra();
    }//GEN-LAST:event_btnCadastrarNovaObraActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        btnAdicionarExemplar.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void txtCodigoDaObraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoDaObraKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja adicionar um novo exemplar para '" + obra[1] + "' ?");
        if (resposta == 0){
           int codigoDoNovoExemplar = adicionaExemplar(Integer.parseInt(obra[0]));
            lblResultado.setText("Código gerado: " + codigoDoNovoExemplar);
            JOptionPane.showMessageDialog(null, "Novo exemplar de '" +obra[1] + "' adicionado com sucesso!"); 
        }
        }
    }//GEN-LAST:event_txtCodigoDaObraKeyPressed

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
            java.util.logging.Logger.getLogger(TelaNovoItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovoItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovoItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovoItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNovoItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarExemplar;
    private javax.swing.JButton btnCadastrarNovaObra;
    private javax.swing.JButton btnFechar3;
    private javax.swing.JButton btnVerificarObra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JTextField txtCodigoDaObra;
    // End of variables declaration//GEN-END:variables
}
