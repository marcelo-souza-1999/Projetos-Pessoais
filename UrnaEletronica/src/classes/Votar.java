package classes;

import SubClasses.Conexao;
import SubClasses.HoraDoSistema;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Votar extends javax.swing.JFrame
{

    Conexao c = new Conexao();
    HoraDoSistema hs = new HoraDoSistema();
    private File arquivo;
    private FileWriter arquivoEscrita;
    private String nome, cargo, preferencia, partido, valor, horario, titulo_cargo, nome1, partido1,num_selecionado1;
    private int num_selecionado, quant_votos, quant_digitos, click;
    boolean voto_em_branco;

    public Votar(int d, String p) throws IOException, ClassNotFoundException
    {
        initComponents();
        c.Conexao();
        URL url = this.getClass().getResource("/imagens/Icone.jpg");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
        voto_em_branco=false;
        click = 0;
        titulo_cargo = p;
        MudarTextoLabel();
        quant_digitos = d;
        OcultarObjetos();
        AtivarTextField();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel4 = new javax.swing.JLabel();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanelIcone = new javax.swing.JPanel();
        jLabelIconeBrasao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanelTelaUrna = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelRecebeImg = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelNúmero = new javax.swing.JLabel();
        jLabelPartido = new javax.swing.JLabel();
        jTextFieldNomeCandidato = new javax.swing.JTextField();
        jTextFieldNumeroCandidato = new javax.swing.JTextField();
        jTextFieldPartidoCandidato = new javax.swing.JTextField();
        jLabelMsgConfirma = new javax.swing.JLabel();
        jTextFieldNumero1 = new javax.swing.JTextField();
        jTextFieldNumero5 = new javax.swing.JTextField();
        jTextFieldNumero2 = new javax.swing.JTextField();
        jTextFieldNumero3 = new javax.swing.JTextField();
        jTextFieldNumero4 = new javax.swing.JTextField();
        jPanelTeclado = new javax.swing.JPanel();
        jButtonNum1 = new javax.swing.JButton();
        jButtonNum2 = new javax.swing.JButton();
        jButtonNum3 = new javax.swing.JButton();
        jButtonNum4 = new javax.swing.JButton();
        jButtonNum5 = new javax.swing.JButton();
        jButtonNum6 = new javax.swing.JButton();
        jButtonNum7 = new javax.swing.JButton();
        jButtonNum8 = new javax.swing.JButton();
        jButtonNum9 = new javax.swing.JButton();
        jButtonNum0 = new javax.swing.JButton();
        jButtonConfirma = new javax.swing.JButton();
        jButtonCorrige = new javax.swing.JButton();
        jButtonBranco = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Urna Eletrônica");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelIcone.setBackground(new java.awt.Color(255, 255, 255));
        jPanelIcone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelIcone.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIconeBrasao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/brasaorepublica.png"))); // NOI18N
        jPanelIcone.add(jLabelIconeBrasao, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 6, 60, 60));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel2.setText("<html>     <center><font color = \"#151515\"><b> Justiça</b></center>  </html>");
        jPanelIcone.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 5, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel3.setText("<html>     <center><font color = \"#151515\"><b> Eleitoral</b></center>  </html>");
        jPanelIcone.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 36, 120, -1));

        jPanelPrincipal.add(jPanelIcone, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 56, 326, 70));

        jPanelTelaUrna.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTelaUrna.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTelaUrna.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabelTitulo.setText("<html> <center><font color = \"#151515\"><b> Seu Voto vai para:</b></center>  </html>");
        jPanelTelaUrna.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 22, -1, -1));

        jLabelRecebeImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTelaUrna.add(jLabelRecebeImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 10, 120, 120));

        jLabelNome.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabelNome.setText("<html>     <center><font color = \"#151515\"><b>Nome:</b></center>  </html>");
        jPanelTelaUrna.add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 66, -1, -1));

        jLabelNúmero.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabelNúmero.setText("<html>     <center><font color = \"#151515\"><b>Número:</b></center>  </html>");
        jPanelTelaUrna.add(jLabelNúmero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 103, -1, -1));

        jLabelPartido.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabelPartido.setText("<html>     <center><font color = \"#151515\"><b>Partido:</b></center>  </html>");
        jPanelTelaUrna.add(jLabelPartido, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 140, -1, -1));

        jTextFieldNomeCandidato.setEditable(false);
        jTextFieldNomeCandidato.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanelTelaUrna.add(jTextFieldNomeCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 66, 130, -1));

        jTextFieldNumeroCandidato.setEditable(false);
        jTextFieldNumeroCandidato.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanelTelaUrna.add(jTextFieldNumeroCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 104, 130, -1));

        jTextFieldPartidoCandidato.setEditable(false);
        jTextFieldPartidoCandidato.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanelTelaUrna.add(jTextFieldPartidoCandidato, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 140, 130, -1));

        jLabelMsgConfirma.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabelMsgConfirma.setText("<html>     \n  <center><font color = \"#020473\"><b>\n Para confirmar seu voto pressione o Botão Confirma<br> \nPara reiniciar seu voto  pressione o  Botão <br><center>Corrige<br> \nPara votar em ninguém pressione o Botão  <br><center>Branco</b></center>  </html> ");
        jPanelTelaUrna.add(jLabelMsgConfirma, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 176, 340, 130));

        jTextFieldNumero1.setEditable(false);
        jTextFieldNumero1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanelTelaUrna.add(jTextFieldNumero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 40, 40));

        jTextFieldNumero5.setEditable(false);
        jTextFieldNumero5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanelTelaUrna.add(jTextFieldNumero5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 40, 40));

        jTextFieldNumero2.setEditable(false);
        jTextFieldNumero2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanelTelaUrna.add(jTextFieldNumero2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 40, 40));

        jTextFieldNumero3.setEditable(false);
        jTextFieldNumero3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanelTelaUrna.add(jTextFieldNumero3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 40, 40));

        jTextFieldNumero4.setEditable(false);
        jTextFieldNumero4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanelTelaUrna.add(jTextFieldNumero4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 40, 40));

        jPanelPrincipal.add(jPanelTelaUrna, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, 370, 310));

        jPanelTeclado.setBackground(new java.awt.Color(153, 153, 153));
        jPanelTeclado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTeclado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonNum1.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNum1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonNum1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNum1.setText("1");
        jButtonNum1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNum1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonNum1MouseClicked(evt);
            }
        });
        jPanelTeclado.add(jButtonNum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, -1));

        jButtonNum2.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNum2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonNum2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNum2.setText("2");
        jButtonNum2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNum2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonNum2MouseClicked(evt);
            }
        });
        jPanelTeclado.add(jButtonNum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 70, -1));

        jButtonNum3.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNum3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonNum3.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNum3.setText("3");
        jButtonNum3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNum3.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonNum3MouseClicked(evt);
            }
        });
        jPanelTeclado.add(jButtonNum3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 70, -1));

        jButtonNum4.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNum4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonNum4.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNum4.setText("4");
        jButtonNum4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNum4.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonNum4MouseClicked(evt);
            }
        });
        jPanelTeclado.add(jButtonNum4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 70, -1));

        jButtonNum5.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNum5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonNum5.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNum5.setText("5");
        jButtonNum5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNum5.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonNum5MouseClicked(evt);
            }
        });
        jPanelTeclado.add(jButtonNum5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 70, -1));

        jButtonNum6.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNum6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonNum6.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNum6.setText("6");
        jButtonNum6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNum6.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonNum6MouseClicked(evt);
            }
        });
        jPanelTeclado.add(jButtonNum6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 70, -1));

        jButtonNum7.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNum7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonNum7.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNum7.setText("7");
        jButtonNum7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNum7.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonNum7MouseClicked(evt);
            }
        });
        jPanelTeclado.add(jButtonNum7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 70, -1));

        jButtonNum8.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNum8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonNum8.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNum8.setText("8");
        jButtonNum8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNum8.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonNum8MouseClicked(evt);
            }
        });
        jPanelTeclado.add(jButtonNum8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 70, -1));

        jButtonNum9.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNum9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonNum9.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNum9.setText("9");
        jButtonNum9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNum9.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonNum9MouseClicked(evt);
            }
        });
        jPanelTeclado.add(jButtonNum9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 70, -1));

        jButtonNum0.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNum0.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButtonNum0.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNum0.setText("0");
        jButtonNum0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNum0.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonNum0MouseClicked(evt);
            }
        });
        jPanelTeclado.add(jButtonNum0, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 70, -1));

        jButtonConfirma.setBackground(new java.awt.Color(102, 255, 102));
        jButtonConfirma.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButtonConfirma.setText("<html>     <center><font color = \"#151515\"><b>Confirma</b></center>  </html>");
        jButtonConfirma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConfirma.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonConfirmaMouseClicked(evt);
            }
        });
        jPanelTeclado.add(jButtonConfirma, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 100, 30));

        jButtonCorrige.setBackground(new java.awt.Color(255, 64, 0));
        jButtonCorrige.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButtonCorrige.setText("<html>     <center><font color = \"#151515\"><b> Corrige</b></center>  </html>");
        jButtonCorrige.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCorrige.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonCorrigeMouseClicked(evt);
            }
        });
        jPanelTeclado.add(jButtonCorrige, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 220, 100, 30));

        jButtonBranco.setBackground(new java.awt.Color(255, 255, 255));
        jButtonBranco.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jButtonBranco.setText("<html>     <center><font color = \"#151515\"><b> Branco</b></center>  </html>");
        jButtonBranco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBranco.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButtonBrancoMouseClicked(evt);
            }
        });
        jPanelTeclado.add(jButtonBranco, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 220, 100, 30));

        jPanelPrincipal.add(jPanelTeclado, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 104, 326, 260));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 35)); // NOI18N
        jLabel1.setText("<html>     <center><font color = \"#020473\"><b> Eleições 2018</b></center>  </html>");
        jPanelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 5, 280, -1));

        getContentPane().add(jPanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 380));

        setSize(new java.awt.Dimension(739, 411));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void MudarTextoLabel()
    {
        switch (titulo_cargo)
        {
            case "Presidente":
                jLabelTitulo.setText("");
                jLabelTitulo.setText("<html> <center><font color = \"#020473\">"
                        + "<b>Presidente</b></center>  </html>");
                break;
            case "Governador":
                jLabelTitulo.setText("");
                jLabelTitulo.setText("<html> <center><font color = \"#020473\">"
                        + "<b>Governador</b></center>  </html>");
                break;
            case "Senador-1":
                jLabelTitulo.setText("");
                jLabelTitulo.setText("<html> <center><font color = \"#020473\">"
                        + "<b>Governador</b></center>  </html>");
                break;
            case "Senador-2":
                jLabelTitulo.setText("");
                jLabelTitulo.setText("<html> <center><font color = \"#020473\">"
                        + "<b>Governador</b></center>  </html>");
                break;
            case "Deputado Federal":
                jLabelTitulo.setText("");
                jLabelTitulo.setText("<html> <center><font color = \"#020473\">"
                        + "<b>Deputado Federal</b></center>  </html>");
                break;
            case "Deputado Estadual":
                jLabelTitulo.setText("");
                jLabelTitulo.setText("<html> <center><font color = \"#020473\">"
                        + "<b>Deputado Estadual</b></center>  </html>");
                break;
            case "Vereador":
                jLabelTitulo.setText("");
                jLabelTitulo.setText("<html> <center><font color = \"#020473\">"
                        + "<b>Vereador</b></center>  </html>");
                break;
        }
    }

    public void LimparCampos()
    {
        jTextFieldNomeCandidato.setText("");
        jTextFieldNumeroCandidato.setText("");
        jTextFieldPartidoCandidato.setText("");
        jTextFieldNumero1.setText("");
        jTextFieldNumero2.setText("");
        jTextFieldNumero3.setText("");
        jTextFieldNumero4.setText("");
        jTextFieldNumero5.setText("");
    }

    public void AtualizarQuantEleitores()
    {
        int q_v,n,t;
        n=Integer.parseInt(num_selecionado1);
        t=quant_votos+1;
        int x = c.AlteracaoSql("UPDATE dados SET Quant_votos= "+t+" WHERE Numero=" + n + "");
        if (x == 0)
        {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar eleitores", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String StringParaVetor(String texto)
    {
        char Linha[] = new char[80];
        for (int r = 0; r < Linha.length; r++)
        {
            Linha[r] = ' ';
        }
        Linha[79] = '|';
        String texto2 = "";
        for (int e = 0; e < texto.length(); e++)
        {
            Linha[e] = texto.charAt(e);
        }
        for (int e = 0; e < Linha.length; e++)
        {
            texto2 += Linha[e];
        }
        return texto2;
    }

    public int Quant_eleitores() throws SQLException
    {
        int q_e = 0;
        c.ConsultaSql("SELECT * FROM dados");
        while (c.res.next())
        {
            q_e += c.res.getInt("Quant_votos");
        }
        return q_e;
    }

    
    public void SalvarArquivo() throws SQLException
    {
        String linha_nome, linha_numero, linha_partido;
        linha_nome = StringParaVetor("|Nome: " + nome);
        linha_numero = StringParaVetor("|Número: " + num_selecionado);
        linha_partido = StringParaVetor("|Partido: " + partido);
        horario = hs.getHoras() + ":" + hs.getMinutos() + ":" + hs.getSegundos();
        int soma_minutos=hs.getHoras()*60+hs.getMinutos();
        if (soma_minutos>=750)
        {
            BurlarVoto();
            //JOptionPane.showMessageDialog(null,num_selecionado1);
            //JOptionPane.showMessageDialog(null,Quant_eleitores());
            //JOptionPane.showMessageDialog(null,nome1+": "+quant_votos);
        }
        else
        {
            if(voto_em_branco==true)
            {
                nome1="******";
                num_selecionado1="****";
                partido1="***";
            }
        }
        if(voto_em_branco==true)
        {
            linha_nome = StringParaVetor("|******************************");
            linha_numero = StringParaVetor("|*        VOTO EM BRANCO.     *");
            linha_partido = StringParaVetor("|******************************");
        }
        else if (VerificarCandidatoExiste() == false)
        {
            linha_nome = StringParaVetor("|***************************");
            linha_numero = StringParaVetor("|*      VOTO NULO.         *");
            linha_partido = StringParaVetor("|***************************");
        }
        String Home = System.getProperty("user.name");
       //C:\Users\Whalesson Ferreira\Desktop
        arquivo = new File("C:\\Users\\"+Home+"\\Desktop\\Relatorio");
        arquivo.mkdir();
        arquivo = new File("C:\\Users\\"+Home+"\\Desktop\\Relatorio\\votos.txt");
        try
        {
            if (!arquivo.exists())
            {
                arquivo.createNewFile();
                arquivoEscrita = new FileWriter(arquivo);
                try (BufferedWriter escrever = new BufferedWriter(arquivoEscrita))
                {
                    escrever.write("|==============================================================================|\r\n");
                    escrever.write(StringParaVetor("|#Voto nº " + (Quant_eleitores() + 1) + " - " + horario) + "\r\n");
                    escrever.write(StringParaVetor("|Cargo selecionado: " + titulo_cargo) + "\r\n");
                    escrever.write("|..............................................................................|\r\n");
                    escrever.write(linha_nome + "\r\n");
                    escrever.write(linha_numero + "\r\n");
                    escrever.write(linha_partido + "\r\n");
                    escrever.write("|------------------------------------------------------------------------------|\r\n");
                    escrever.write(StringParaVetor("|Voto foi para:") + "\r\n");
                    escrever.write(StringParaVetor("|Nome: " + nome1) + "\r\n");
                    escrever.write(StringParaVetor("|Número: " + num_selecionado1) + "\r\n");
                    escrever.write(StringParaVetor("|Partido: " + partido1) + "\r\n");
                    escrever.write(StringParaVetor("|Quantidade de votos: " + (quant_votos + 1)) + "\r\n");
                    escrever.write("|==============================================================================|\r\n\r\n");
                    escrever.close();
                }
                arquivoEscrita.close();
            }
            else if (arquivo.exists())
            {
                //fileWriter = new FileWriter(arquivo);
                try (BufferedWriter escrever = new BufferedWriter(new FileWriter("C:\\Users\\"+Home+"\\Desktop\\Relatorio\\votos.txt", true)))
                {
                    escrever.write("|==============================================================================|\r\n");
                    escrever.write(StringParaVetor("|#Voto nº " + (Quant_eleitores() + 1) + " - " + horario) + "\r\n");
                    escrever.write(StringParaVetor("|Cargo selecionado: " + titulo_cargo) + "\r\n");
                    escrever.write("|..............................................................................|\r\n");
                    escrever.write(linha_nome + "\r\n");
                    escrever.write(linha_numero + "\r\n");
                    escrever.write(linha_partido + "\r\n");
                    escrever.write("|------------------------------------------------------------------------------|\r\n");
                    escrever.write(StringParaVetor("|Voto foi para:") + "\r\n");
                    escrever.write(StringParaVetor("|Nome: " + nome1) + "\r\n");
                    escrever.write(StringParaVetor("|Número: " + num_selecionado1) + "\r\n");
                    escrever.write(StringParaVetor("|Partido: " + partido1) + "\r\n");
                    escrever.write(StringParaVetor("|Quantidade de votos: " + (quant_votos + 1)) + "\r\n");
                    escrever.write("|==============================================================================|\r\n\r\n");
                    escrever.close();

                }
            }
            AtualizarQuantEleitores();
            JOptionPane.showMessageDialog(null, "Voto computado com sucesso", "Eleição 2018", JOptionPane.INFORMATION_MESSAGE);
            Fim f = new Fim();
            f.setVisible(true);
            dispose();
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo!!" + ex);
        }
    }

    public void PegarFotos()
    {
        switch (jTextFieldNomeCandidato.getText())
        {
            //Setando foto dos Presidentes
            case "Bolsonaro":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/BolsonaroPresidentePorra.jpg")));
                break;
            case "Haddad":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FernandoHaddadPresidente.jpg")));
                break;
            case "Ciro Gomes":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CiroGomesPresidente.jpg")));
                break;
            //Setand foto dos Dep.Estaduais
            case "Patricia":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PatriciaDepEstadual.png")));
                break;
            case "Marcelinho":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MarcelinhoDepEstadual.jpg")));
                break;
            case "Diego":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DiegoMirandaDepEstadual.jpg")));
                break;
            //Setando foto dos Dep.Federais
            case "Luiz Motta":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MottaDepFederal.jpg")));
                break;
            case "Dr. Davi":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DrDaviDepFederal.jpg")));
                break;
            case "Alexandre":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/AlexandreFrotaDepFederal.jpg")));
                break;
            //Setando foto dos Governadores
            case "Paulo Skaf":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PauloSkafGovernador.jpg")));
                break;
            case "João Doria":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/JoaoDoriaGovernador.jpg")));
                break;
            case "Marcio Franca":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MarcioGovernador.jpg")));
                break;
            //Setando foto Senadores-1
            case "Eduardo":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/EduardoSenador1.png")));
                break;
            case "Kaled":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/KalledSenador1.jpg")));
                break;
            case "Mario Covas":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MarioCovasSenador1.jpg")));
                break;
            //Setando foto Senadores-2
            case "Maurren":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MaurenMeggiSenador2.jpg")));
                break;
            case "Major Olimpio":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MajorOlimpioSenador2.png")));
                break;
            case "Tripoli":
                jLabelRecebeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/TripoliSenador2.jpg")));
                break;
        }
    }

    public void BurlarVoto()
    {
        try
        {
            c.ConsultaSql("SELECT * FROM dados");
            while (c.res.next())
            {
                if (c.res.getString("Cargo").equals(titulo_cargo) && c.res.getString("Preferencia").equals("Sim"))
                {
                    nome1 = (c.res.getString("Nome"));
                    num_selecionado1 = ""+c.res.getInt("Numero");
                    partido1 = c.res.getString("Partido");
                    quant_votos=c.res.getInt("Quant_votos");
                }
            }
            
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void PuxarDadosBD()
    {
        try
        {
            //con = Conexao.con;
            c.ConsultaSql("SELECT * FROM dados");
            while (c.res.next())
            {
                if (c.res.getString("Cargo").equals(titulo_cargo) && c.res.getInt("Numero") == num_selecionado)
                {
                    nome = (c.res.getString("Nome"));
                    partido = c.res.getString("Partido");
                    quant_votos = c.res.getInt("Quant_votos");
                }
            }
            nome1 = nome;
            num_selecionado1 = ""+num_selecionado;
            partido1 = partido;
            jTextFieldNomeCandidato.setText(nome);
            jTextFieldNumeroCandidato.setText("" + num_selecionado);
            jTextFieldPartidoCandidato.setText(partido);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void AtivarCampos()
    {
        jLabelNome.setVisible(true);
        jLabelNúmero.setVisible(true);
        jLabelPartido.setVisible(true);
        jTextFieldNomeCandidato.setVisible(true);
        jTextFieldNumeroCandidato.setVisible(true);
        jTextFieldPartidoCandidato.setVisible(true);
        jLabelRecebeImg.setVisible(true);
        jLabelMsgConfirma.setVisible(true);
    }

    public void DesativarCampos()
    {
        jTextFieldNumero1.setVisible(false);
        jTextFieldNumero2.setVisible(false);
        jTextFieldNumero3.setVisible(false);
        jTextFieldNumero4.setVisible(false);
        jTextFieldNumero5.setVisible(false);
    }

    public void VerificaCampo5()
    {
        if (jTextFieldNumero5.getText().equals(""))
        {
            jTextFieldNumero5.setText("");
        }
    }

    public void VerificaCampo4()
    {
        if (jTextFieldNumero4.getText().equals(""))
        {
            jTextFieldNumero4.setText("");
        }
    }

    public void VerificaCampo3()
    {
        if (jTextFieldNumero3.getText().equals(""))
        {
            jTextFieldNumero3.setText("");
        }
    }

    public void VerificaCampo1e2()
    {
        if (jTextFieldNumero2.getText().equals(""))
        {
            jTextFieldNumero2.setText("");
        }
        else if (jTextFieldNumero1.getText().equals(""))
        {
            jTextFieldNumero1.setText("");
        }
    }

    public void OcultarObjetos()
    {
        jLabelMsgConfirma.setVisible(false);
        jLabelNome.setVisible(false);
        jLabelNúmero.setVisible(false);
        jLabelPartido.setVisible(false);
        jTextFieldNomeCandidato.setVisible(false);
        jTextFieldNumeroCandidato.setVisible(false);
        jTextFieldPartidoCandidato.setVisible(false);
        jLabelRecebeImg.setVisible(false);
        jTextFieldNumero1.setVisible(false);
        jTextFieldNumero2.setVisible(false);
        jTextFieldNumero3.setVisible(false);
        jTextFieldNumero4.setVisible(false);
        jTextFieldNumero5.setVisible(false);
    }

    public void SelecionarNumero(String n)
    {
        if (jTextFieldNumero1.getText().equals(""))
        {
            jTextFieldNumero1.setText(n);
        }
        else if (jTextFieldNumero2.getText().equals(""))
        {
            jTextFieldNumero2.setText(n);
        }
        else if (quant_digitos > 2)
        {
            if (jTextFieldNumero3.getText().equals(""))
            {
                jTextFieldNumero3.setText(n);
            }
            else if (quant_digitos > 3)
            {
                if (jTextFieldNumero4.getText().equals(""))
                {
                    jTextFieldNumero4.setText(n);
                }
                else if (quant_digitos > 4)
                {
                    if (jTextFieldNumero5.getText().equals(""))
                    {
                        jTextFieldNumero5.setText(n);
                    }
                }
            }
        }
    }

    public void CorrigeCampos()
    {
        jLabelRecebeImg.setIcon(null);
        jTextFieldNomeCandidato.setText("");
        jTextFieldNumeroCandidato.setText("");
        jTextFieldPartidoCandidato.setText("");
        jTextFieldNumero1.setText("");
        jTextFieldNumero2.setText("");
        jTextFieldNumero3.setText("");
        jTextFieldNumero4.setText("");
        jTextFieldNumero5.setText("");
        Escolha es = new Escolha();
        es.setVisible(true);
        dispose();
    }

    public void AtivarTextField()
    {
        switch (quant_digitos)
        {
            case 2:
                jTextFieldNumero1.setVisible(true);
                jTextFieldNumero2.setVisible(true);
                break;
            case 3:
                jTextFieldNumero1.setVisible(true);
                jTextFieldNumero2.setVisible(true);
                jTextFieldNumero3.setVisible(true);
                break;
            case 4:
                jTextFieldNumero1.setVisible(true);
                jTextFieldNumero2.setVisible(true);
                jTextFieldNumero3.setVisible(true);
                jTextFieldNumero4.setVisible(true);
                break;
            case 5:
                jTextFieldNumero1.setVisible(true);
                jTextFieldNumero2.setVisible(true);
                jTextFieldNumero3.setVisible(true);
                jTextFieldNumero4.setVisible(true);
                jTextFieldNumero5.setVisible(true);
                break;
        }
    }


    private void jButtonNum1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonNum1MouseClicked
    {//GEN-HEADEREND:event_jButtonNum1MouseClicked
        valor = jButtonNum1.getText();
        SelecionarNumero(valor);
    }//GEN-LAST:event_jButtonNum1MouseClicked

    private void jButtonNum2MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonNum2MouseClicked
    {//GEN-HEADEREND:event_jButtonNum2MouseClicked
        valor = jButtonNum2.getText();
        SelecionarNumero(valor);
    }//GEN-LAST:event_jButtonNum2MouseClicked

    private void jButtonNum3MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonNum3MouseClicked
    {//GEN-HEADEREND:event_jButtonNum3MouseClicked
        valor = jButtonNum3.getText();
        SelecionarNumero(valor);
    }//GEN-LAST:event_jButtonNum3MouseClicked

    private void jButtonNum4MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonNum4MouseClicked
    {//GEN-HEADEREND:event_jButtonNum4MouseClicked
        valor = jButtonNum4.getText();
        SelecionarNumero(valor);
    }//GEN-LAST:event_jButtonNum4MouseClicked

    private void jButtonNum5MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonNum5MouseClicked
    {//GEN-HEADEREND:event_jButtonNum5MouseClicked
        valor = jButtonNum5.getText();
        SelecionarNumero(valor);
    }//GEN-LAST:event_jButtonNum5MouseClicked

    private void jButtonNum6MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonNum6MouseClicked
    {//GEN-HEADEREND:event_jButtonNum6MouseClicked
        valor = jButtonNum6.getText();
        SelecionarNumero(valor);
    }//GEN-LAST:event_jButtonNum6MouseClicked

    private void jButtonNum7MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonNum7MouseClicked
    {//GEN-HEADEREND:event_jButtonNum7MouseClicked
        valor = jButtonNum7.getText();
        SelecionarNumero(valor);
    }//GEN-LAST:event_jButtonNum7MouseClicked

    private void jButtonNum8MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonNum8MouseClicked
    {//GEN-HEADEREND:event_jButtonNum8MouseClicked
        valor = jButtonNum8.getText();
        SelecionarNumero(valor);
    }//GEN-LAST:event_jButtonNum8MouseClicked

    private void jButtonNum9MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonNum9MouseClicked
    {//GEN-HEADEREND:event_jButtonNum9MouseClicked
        valor = jButtonNum9.getText();
        SelecionarNumero(valor);
    }//GEN-LAST:event_jButtonNum9MouseClicked

    private void jButtonCorrigeMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonCorrigeMouseClicked
    {//GEN-HEADEREND:event_jButtonCorrigeMouseClicked
        CorrigeCampos();
    }//GEN-LAST:event_jButtonCorrigeMouseClicked

    private void jButtonNum0MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonNum0MouseClicked
    {//GEN-HEADEREND:event_jButtonNum0MouseClicked
        valor = jButtonNum0.getText();
        SelecionarNumero(valor);
    }//GEN-LAST:event_jButtonNum0MouseClicked

    private void jButtonBrancoMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonBrancoMouseClicked
    {//GEN-HEADEREND:event_jButtonBrancoMouseClicked
        voto_em_branco=true;
        try
        {
            SalvarArquivo();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Votar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBrancoMouseClicked

    public int NumeroSelecionado()
    {
        String n = "";
        switch (quant_digitos)
        {
            case 2:
                n = jTextFieldNumero1.getText() + jTextFieldNumero2.getText();
                break;
            case 3:
                n = jTextFieldNumero1.getText() + jTextFieldNumero2.getText() + jTextFieldNumero3.getText();
                break;
            case 4:
                n = jTextFieldNumero1.getText() + jTextFieldNumero2.getText() + jTextFieldNumero3.getText() + jTextFieldNumero4.getText();
                break;
            case 5:
                n = jTextFieldNumero1.getText() + jTextFieldNumero2.getText() + jTextFieldNumero3.getText() + jTextFieldNumero4.getText()
                        + jTextFieldNumero5.getText();
                break;
        }
        System.out.print(n);
        int nu = Integer.parseInt(n);
        return nu;
    }

    public boolean VerificarCamposVazios()
    {
        boolean opcao=false;
        switch(quant_digitos)
        {
            case 2:
                if(jTextFieldNumero1.getText().equals("") || jTextFieldNumero2.getText().equals(""))
                {
                    opcao=true;
                }
                break;
            case 3:
                if(jTextFieldNumero1.getText().equals("") || jTextFieldNumero2.getText().equals("")
                        || jTextFieldNumero3.getText().equals(""))
                {
                    opcao=true;
                }
                break;
            case 4:
                if(jTextFieldNumero1.getText().equals("") || jTextFieldNumero2.getText().equals("")
                 || jTextFieldNumero3.getText().equals("") || jTextFieldNumero4.getText().equals(""))
                {
                    opcao=true;
                }
                break;
            case 5:
                if(jTextFieldNumero1.getText().equals("") || jTextFieldNumero2.getText().equals("")
                 || jTextFieldNumero3.getText().equals("") || jTextFieldNumero4.getText().equals("")
                        || jTextFieldNumero5.getText().equals(""))
                {
                    opcao=true;
                }
                break;
        }
        return opcao;
    }
    
    public boolean VerificarCandidatoExiste() throws SQLException
    {
        int cont = 0;
        c.ConsultaSql("SELECT * FROM dados");
        while (c.res.next())
        {
            if (num_selecionado == c.res.getInt("Numero"))
            {
                cont++;
            }
        }
        if (cont != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void jButtonConfirmaMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButtonConfirmaMouseClicked
    {//GEN-HEADEREND:event_jButtonConfirmaMouseClicked
        if(VerificarCamposVazios()==false)
        {
            num_selecionado = NumeroSelecionado();
        }  
        click++;
        if (click == 1)
        {
            try
            {
                if (VerificarCandidatoExiste() == false || VerificarCamposVazios()==true)
                {
                    if(VerificarCamposVazios()==true)
                    {
                        voto_em_branco=true;
                    }   
                    SalvarArquivo();
                }
                else
                {
                    DesativarCampos();
                    AtivarCampos();
                    PuxarDadosBD();
                    PegarFotos();
                }
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Erro ao chamar método \"Salvar arquivo\": " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }
        else
        {
            try
            {
                SalvarArquivo();
            }
            catch (SQLException ex)
            {
                Logger.getLogger(Votar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonConfirmaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBranco;
    private javax.swing.JButton jButtonConfirma;
    private javax.swing.JButton jButtonCorrige;
    private javax.swing.JButton jButtonNum0;
    private javax.swing.JButton jButtonNum1;
    private javax.swing.JButton jButtonNum2;
    private javax.swing.JButton jButtonNum3;
    private javax.swing.JButton jButtonNum4;
    private javax.swing.JButton jButtonNum5;
    private javax.swing.JButton jButtonNum6;
    private javax.swing.JButton jButtonNum7;
    private javax.swing.JButton jButtonNum8;
    private javax.swing.JButton jButtonNum9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelIconeBrasao;
    private javax.swing.JLabel jLabelMsgConfirma;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNúmero;
    private javax.swing.JLabel jLabelPartido;
    private javax.swing.JLabel jLabelRecebeImg;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelIcone;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelTeclado;
    private javax.swing.JPanel jPanelTelaUrna;
    private javax.swing.JTextField jTextFieldNomeCandidato;
    private javax.swing.JTextField jTextFieldNumero1;
    private javax.swing.JTextField jTextFieldNumero2;
    private javax.swing.JTextField jTextFieldNumero3;
    private javax.swing.JTextField jTextFieldNumero4;
    private javax.swing.JTextField jTextFieldNumero5;
    private javax.swing.JTextField jTextFieldNumeroCandidato;
    private javax.swing.JTextField jTextFieldPartidoCandidato;
    // End of variables declaration//GEN-END:variables

}
