package classes;

import SubClasses.Conexao;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Relatorio extends javax.swing.JFrame
{
    Conexao c = new Conexao();
    private String dados = "";
    

    public Relatorio() throws ClassNotFoundException
    {
        initComponents();
        c.Conexao();
        URL url = this.getClass().getResource("/imagens/Icone.jpg");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        jTextAreaDados.setFont(new Font("Arial", Font.PLAIN, 16));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonConsultar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDados = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel1.setText("<html>     <center><font color = \"#151515\"><b>Candidatos Cadastrados</b></center>  </html>");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jButtonConsultar.setBackground(new java.awt.Color(153, 153, 255));
        jButtonConsultar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jButtonConsultar.setText("<html>     <center><font color = \"#FFFFFF\"><b> Consultar</b></center>  </html>");
        jButtonConsultar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        jButtonConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConsultar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonConsultarMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 130, 32));

        jButtonVoltar.setBackground(new java.awt.Color(153, 153, 255));
        jButtonVoltar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jButtonVoltar.setText("<html>     <center><font color = \"#FFFFFF\"><b>Voltar</b></center>  </html>");
        jButtonVoltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        jButtonVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVoltar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonVoltarMouseClicked(evt);
            }
        });
        jPanel1.add(jButtonVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 130, 32));

        jTextAreaDados.setEditable(false);
        jTextAreaDados.setColumns(20);
        jTextAreaDados.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jTextAreaDados.setRows(5);
        jTextAreaDados.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(jTextAreaDados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 410, 270));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 380));

        setSize(new java.awt.Dimension(469, 420));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void GerarRelatorio()
    {
        try
        {
            c.ConsultaSql("SELECT * FROM dados");
            while (c.res.next())
            {
                dados += "Nome: " + c.res.getString("Nome")+"\n";
                dados += "Partido: " + c.res.getString("Partido")+"\n";
                dados += "Número: " + c.res.getString("Numero")+"\n";
                dados += "Cargo: " + c.res.getString("Cargo")+"\n";
                dados += "Vantagem em relação à outros candidatos: " + c.res.getString("Preferencia")+"\n";
                dados += "---------------------------------------------------------------------------"+"\n";
            }
            jTextAreaDados.setText(dados);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Erro em exibir Relatório!!!"+e);
        }
    }
    
    private void jButtonConsultarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonConsultarMouseClicked
    {//GEN-HEADEREND:event_jButtonConsultarMouseClicked
        if(jTextAreaDados.getText().isEmpty()==true)
        {
            GerarRelatorio();
        }
    }//GEN-LAST:event_jButtonConsultarMouseClicked

    private void jButtonVoltarMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonVoltarMouseClicked
    {//GEN-HEADEREND:event_jButtonVoltarMouseClicked
        Acesso ac = null;
        try
        {
            ac = new Acesso(1);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        ac.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonVoltarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDados;
    // End of variables declaration//GEN-END:variables

}
