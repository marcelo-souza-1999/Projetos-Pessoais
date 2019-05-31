package SubClasses;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao
{
    public ResultSet res;
    public static Connection con;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String caminho = "jdbc:mysql://localhost:3306/urna_eleitoral";
    private final String usuario = "root";
    private final String senha = "";

    public void Conexao() throws ClassNotFoundException
    {
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro na conexão!!!" + ex);
        }
    }

    public void ConsultaSql(String sql)
    {
        try
        {
            Statement stm = con.createStatement();
            res = stm.executeQuery(sql);
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro!!!" + ex);
        }
    }

    public int AlteracaoSql(String sql)
    {
        try
        {
            Statement stm = con.createStatement();
            return stm.executeUpdate(sql);
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Erro!!!" + ex);
            return 0;
        }
    }
}
