
package classes;

import SubClasses.Conexao;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Acesso extends javax.swing.JFrame 
{
    Conexao c = new Conexao();
    private String Home;
    private File arquivo;
    private FileWriter arquivoEscrita;
    
    public Acesso(int j) throws ClassNotFoundException 
    {
        initComponents();
        Home = System.getProperty("user.name");
        c.Conexao();
        if(j==0)
        {
            VerificarArquivoExiste();
        }
        URL url = this.getClass().getResource("/imagens/Icone.jpg");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonRelatorio = new javax.swing.JButton();
        jButtonVotar = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acesso");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 40)); // NOI18N
        jLabelTitulo.setText("<html>     <center><font color = \"#020473\"><b> Eleições 2018</b></center>  </html>");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 10, -1, -1));

        jButtonRelatorio.setBackground(new java.awt.Color(204, 255, 255));
        jButtonRelatorio.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jButtonRelatorio.setText("<html><b><strong><font color = \"#151515\" =>Relatórios</strong></b></html>");
        jButtonRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRelatorio.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonRelatorioMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 100, 160, 46));

        jButtonVotar.setBackground(new java.awt.Color(204, 255, 255));
        jButtonVotar.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jButtonVotar.setText("<html><b><strong><font color = \"#151515\" =>Votar </strong></b></html>");
        jButtonVotar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVotar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonVotarMouseClicked(evt);
            }
        });
        jButtonVotar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonVotarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVotar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 160, 46));

        jButtonExit.setBackground(new java.awt.Color(255, 255, 255));
        jButtonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit.png"))); // NOI18N
        jButtonExit.setBorderPainted(false);
        jButtonExit.setContentAreaFilled(false);
        jButtonExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 192, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 270));

        setSize(new java.awt.Dimension(431, 271));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void ZerarQuant_votosBanco()
    {
        int r=c.AlteracaoSql("UPDATE dados SET Quant_votos = "+0+" WHERE Quant_votos != "+0+"");
        JOptionPane.showMessageDialog(null,"Olá "+Home+",\n\n"
                + "Notamos que o diretório onde foi salvo o último relatório foi excluído.\n"
                + "Portanto, por questões de segurança, apagamos todos os dados da\n"
                + "última eleição.\n\n"
                + "Esperamos sua compreensão.","Eleição 2018",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void VerificarArquivoExiste()
    {
        arquivo = new File("C:\\Users\\"+Home+"\\Desktop\\Relatorio");
        if(arquivo.exists())
        {
            arquivo = new File("C:\\Users\\"+Home+"\\Desktop\\Relatorio\\votos.txt");
            if(arquivo.exists()==false)
            {
                ZerarQuant_votosBanco();
            }
        }
        else
        {
            ZerarQuant_votosBanco();
        }
    }
    private void jButtonRelatorioMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonRelatorioMouseClicked
    {//GEN-HEADEREND:event_jButtonRelatorioMouseClicked
        Relatorio rl = null;
        try
        {
            rl = new Relatorio();
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Acesso.class.getName()).log(Level.SEVERE, null, ex);
        }
        rl.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonRelatorioMouseClicked

    private void jButtonVotarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonVotarActionPerformed
    {//GEN-HEADEREND:event_jButtonVotarActionPerformed
//        
    }//GEN-LAST:event_jButtonVotarActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonExitActionPerformed
    {//GEN-HEADEREND:event_jButtonExitActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonVotarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonVotarMouseClicked
    {//GEN-HEADEREND:event_jButtonVotarMouseClicked
        Escolha es = new Escolha();
        es.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonVotarMouseClicked

    public static void main(String args[]) 
    {
       
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
            java.util.logging.Logger.getLogger(Acesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try
                {
                    new Acesso(0).setVisible(true);
                }
                catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(Acesso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonRelatorio;
    private javax.swing.JButton jButtonVotar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
