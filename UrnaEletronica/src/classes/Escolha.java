package classes;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Escolha extends javax.swing.JFrame
{

    private int quant_campos;
    private String cargo = "";

    public Escolha()
    {
        initComponents();
        URL url = this.getClass().getResource("/imagens/Icone.jpg");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        quant_campos = 0;
        jComboBoxEscolhas.addItem("");
        jComboBoxEscolhas.addItem("Deputado Federal");
        jComboBoxEscolhas.addItem("Deputado Estadual");
        jComboBoxEscolhas.addItem("Senador-1");
        jComboBoxEscolhas.addItem("Senador-2");
        jComboBoxEscolhas.addItem("Governador");
        jComboBoxEscolhas.addItem("Presidente");
        this.jComboBoxEscolhas.setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanelPrincipal = new javax.swing.JPanel();
        jComboBoxEscolhas = new javax.swing.JComboBox<>();
        jButtonAvancar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Escolha");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxEscolhas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jComboBoxEscolhas.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jComboBoxEscolhasItemStateChanged(evt);
            }
        });
        jPanelPrincipal.add(jComboBoxEscolhas, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 44, 175, -1));

        jButtonAvancar.setBackground(new java.awt.Color(102, 255, 102));
        jButtonAvancar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jButtonAvancar.setText("<html>     <center><font color = \"#515151\"><b>Avançar</b></center>  </html>");
        jButtonAvancar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAvancar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonAvancarMouseClicked(evt);
            }
        });
        jPanelPrincipal.add(jButtonAvancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 76, 110, 28));

        jButtonVoltar.setBackground(new java.awt.Color(102, 255, 102));
        jButtonVoltar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jButtonVoltar.setText("<html>     <center><font color = \"#515151\"><b>Voltar</b></center>  </html>");
        jButtonVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVoltar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonVoltarMouseClicked(evt);
            }
        });
        jPanelPrincipal.add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 76, 110, 28));

        jLabelTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabelTitulo.setText("<html>     <center><font color = \"#151515\"><b>Escolha o Cargo que deseja votar:</b></center>  </html>");
        jPanelPrincipal.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 10, -1, -1));

        getContentPane().add(jPanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 120));

        setSize(new java.awt.Dimension(326, 159));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void Verifica() throws IOException, ClassNotFoundException
    {
        if (jComboBoxEscolhas.getSelectedItem().toString().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Favor Escolha um Cargo para poder Votar");
        }
        else
        {
            Votar vt = new Votar(quant_campos, cargo);
            vt.setVisible(true);
            dispose();
        }
    }

    public String Texto()
    {
        if (jComboBoxEscolhas.getSelectedItem().toString().equals("Presidente"))
        {
            cargo = "Presidente";
        }
        if (jComboBoxEscolhas.getSelectedItem().toString().equals("Governador"))
        {
            cargo = "Governador";
        }
        if (jComboBoxEscolhas.getSelectedItem().toString().equals("Senador-1"))
        {
            cargo = "Senador-1";
        }
        if (jComboBoxEscolhas.getSelectedItem().toString().equals("Senador-2"))
        {
            cargo = "Senador-2";
        }
        if (jComboBoxEscolhas.getSelectedItem().toString().equals("Deputado Federal"))
        {
            cargo = "Deputado Federal";
        }
        if (jComboBoxEscolhas.getSelectedItem().toString().equals("Deputado Estadual"))
        {
            cargo = "Deputado Estadual";
        }
        return cargo;
    }

    public void Valor()
    {
        switch (jComboBoxEscolhas.getSelectedItem().toString())
        {
            case "Presidente":
            case "Governador":
                quant_campos = 2;
                break;
            case "Senador-1":
            case "Senador-2":
                quant_campos = 3;
                break;
            case "Deputado Federal":
                quant_campos = 4;
                break;
            case "Deputado Estadual":
                quant_campos = 5;
                break;
        }
    }

    private void jButtonAvancarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonAvancarMouseClicked
    {//GEN-HEADEREND:event_jButtonAvancarMouseClicked
        try
        {
            Verifica();
        }
        catch (IOException ex)
        {
            Logger.getLogger(Escolha.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Escolha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAvancarMouseClicked

    private void jButtonVoltarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonVoltarMouseClicked
    {//GEN-HEADEREND:event_jButtonVoltarMouseClicked
        Acesso ac = null;
        try
        {
            ac = new Acesso(1);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Escolha.class.getName()).log(Level.SEVERE, null, ex);
        }
        ac.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonVoltarMouseClicked

    private void jComboBoxEscolhasItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_jComboBoxEscolhasItemStateChanged
    {//GEN-HEADEREND:event_jComboBoxEscolhasItemStateChanged
        Valor();
        Texto();
    }//GEN-LAST:event_jComboBoxEscolhasItemStateChanged

    public static void main(String args[])
    {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Votar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Votar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Votar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Votar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Escolha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAvancar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxEscolhas;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelPrincipal;
    // End of variables declaration//GEN-END:variables
}
