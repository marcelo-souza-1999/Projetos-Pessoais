package classes;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Fim extends javax.swing.JFrame
{
    public Fim()
    {
        initComponents();
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
        jLabelTitulo1 = new javax.swing.JLabel();
        jLabelIconeBrasao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Final");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 25)); // NOI18N
        jLabelTitulo.setText("<html>     <center><font color = \"#020473\"\"><b>Fim!!<br> Obrigado pela Participação</b></center>  </html>");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 68, -1, -1));

        jLabelTitulo1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 25)); // NOI18N
        jLabelTitulo1.setText("<html>     <center><font color = \"#020473\"\"><b> Eleições 2018</b></center>  </html>");
        jPanel1.add(jLabelTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 10, -1, -1));

        jLabelIconeBrasao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/brasaorepublica.png"))); // NOI18N
        jPanel1.add(jLabelIconeBrasao, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 155, 60, 60));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel2.setText("<html>     <center><font color = \"#020473\"\"><b> Justiça</b></center>  </html>");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel3.setText("<html>     <center><font color = \"#020473\"\"><b> Eleitoral</b></center>  </html>");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 170, 120, -1));

        jButtonExit.setBackground(new java.awt.Color(255, 255, 255));
        jButtonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit.png"))); // NOI18N
        jButtonExit.setBorderPainted(false);
        jButtonExit.setContentAreaFilled(false);
        jButtonExit.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonExitMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 202, 50, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 250));

        setSize(new java.awt.Dimension(416, 286));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonExitMouseClicked
    {//GEN-HEADEREND:event_jButtonExitMouseClicked
        Acesso ac = null;
        try
        {
            ac = new Acesso(1);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Fim.class.getName()).log(Level.SEVERE, null, ex);
        }
        ac.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonExitMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelIconeBrasao;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
