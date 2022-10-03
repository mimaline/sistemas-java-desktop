package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelPessoa;
import view.Conexao;

/**
 * @author Gelvazio Camargo
 */
public class ControllerPessoaDB extends ControllerDBPadrao {

    /*



     */
    // CTRL + /
//
//
    private static final String sqlTodos = "select * from public.tbpessoa order by pescodigo";
//    private static final String sqlInserir
//            = "INSERT INTO CADASTRO.TBESTADO (CD_ESTADO, DS_ESTADO,"
//            + " CD_IBGE, CD_FILIAL, CD_USUARIO, DT_ALT, HR_ALT, DT_CAD, HR_CAD)"
//            + "VALUES "
//            + "(?,?,?,?,?,"
//            + "CAST('NOW' AS DATE),"
//            + "CAST('NOW' AS TIME),"
//            + "CAST('NOW' AS DATE),"
//            + "CAST('NOW' AS TIME))";
//    private static final String sqlExcluir = "DELETE FROM TBESTADO WHERE CD_ESTADO = ?";
//    private static final String sqlAlterar
//            = "UPDATE CADASTRO.TBESTADO SET "
//            + "DS_ESTADO = ?,"
//            + "CD_USUARIO =?,"
//            + "CD_IBGE = ?,"
//            + "CD_FILIAL=?,"
//            + "DT_ALT = CAST('NOW' AS DATE),"
//            + "HR_ALT = CAST('NOW' AS TIME)"
//            + " WHERE (CD_ESTADO = ?)";
    private static final String sqlPessoa = "SELECT * FROM public.tbpessoa WHERE pescodigo = ?";
//
//    public DefaultComboBoxModel getComboEstado() {
//        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            conn = Conexao.getConexao();
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sqlTodos);
//            while (rs.next()) {
//                modelo.addElement(rs.getString("CD_ESTADO"));
//            }
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro no sql, getComboEstado(): \n" + erro.getMessage());
//        } finally {
//            Conexao.closeAll(conn);
//        }
//        return modelo;
//    }
//
//    public DefaultComboBoxModel getComboboxPessoaEstado() {
//        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            conn = Conexao.getConexao();
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sqlTodos);
//            while (rs.next()) {
//                modelo.addElement(rs.getString("ds_estado"));
//            }
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro no sql, getComboboxPessoaEstado(): \n" + erro.getMessage());
//        } finally {
//            Conexao.closeAll(conn);
//        }
//        return modelo;
//    }
//
//    public boolean alterarEstado(Estado estado) {
//        boolean alterou = false;
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            conn = Conexao.getConexao();
//            pstmt = conn.prepareStatement(sqlAlterar);
//            pstmt.setString(1, estado.getDs_estado());
//            pstmt.setInt(2, estado.getCd_usuario());
//            pstmt.setInt(3, estado.getCd_ibge());
//            pstmt.setInt(4, estado.getCd_filial());
//            pstmt.setString(5, estado.getCd_estado());
//            pstmt.executeUpdate();
//            alterou = true;
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro no sql. alterarEstado(): \n" + erro.getMessage());
//        } finally {
//            Conexao.closeAll(conn);
//        }
//        return alterou;
//    }
//
//    public boolean excluirEstado(String CD_ESTADO) {
//        boolean excluiu = false;
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            conn = Conexao.getConexao();
//            pstmt = conn.prepareStatement(sqlExcluir);
//            pstmt.setString(1, CD_ESTADO);
//            pstmt.executeUpdate();
//            excluiu = true;
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro no sql. excluirEstado(): \n" + erro.getMessage());
//        } finally {
//            Conexao.closeAll(conn);
//        }
//        return excluiu;
//    }
//
//    public boolean inserirEstado(Estado estado) {
//        boolean inseriu = false;
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            conn = Conexao.getConexao();
//            pstmt = conn.prepareStatement(sqlInserir);
//            pstmt.setString(1, estado.getCd_estado());
//            pstmt.setString(2, estado.getDs_estado());
//            pstmt.setInt(3, estado.getCd_ibge());
//            pstmt.setInt(4, estado.getCd_filial());
//            pstmt.setInt(5, estado.getCd_usuario());
//            pstmt.executeUpdate();
//            inseriu = true;
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro no sql. inserirEstado():\n" + erro.getMessage());
//        } finally {
//            Conexao.closeAll(conn);
//        }
//        return inseriu;
//    }
//

    public ArrayList getTodos() {
        ArrayList listaDados = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlTodos);
            while (rs.next()) {
                // Pega valor inteiro
                int codigo = rs.getInt("pescodigo");
                
                // Pega valores String(texto)
                String nome = rs.getString("pesnome");
                String endereco = rs.getString("pesendereco");
                String cpf = rs.getString("pescpf");
                ModelPessoa pessoa = new ModelPessoa(codigo, nome, endereco, cpf);
                listaDados.add(pessoa);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no sql, getTodos():\n" + erro.getMessage());
        } finally {
            Conexao.closeAll(conn);
        }
        return listaDados;
    }

    public ModelPessoa getPessoa(int codigo) {
        ModelPessoa pessoa = new ModelPessoa();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConexao();
            pstmt = conn.prepareStatement(sqlPessoa);
            pstmt.setInt(1, codigo);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                // Pega valores String(texto)
                String nome = rs.getString("pesnome");
                String endereco = rs.getString("pesendereco");
                String cpf = rs.getString("pescpf");
                ModelPessoa pessoaBanco = new ModelPessoa(codigo, nome, endereco, cpf);

                // recebe a pessoa do banco de dados
                pessoa = pessoaBanco;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL. getPessoa(): \n" + e.getMessage());
        } finally {
            Conexao.closeAll(conn);
        }

        return pessoa;
    }
//
//    public boolean getEstadoPessoa(String CD_ESTADO) {
//        boolean existe = false;
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            conn = Conexao.getConexao();
//            pstmt = conn.prepareStatement(sqlEstado);
//            pstmt.setString(1, CD_ESTADO);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                existe = rs.getInt("total") > 0;
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro de SQL. getEstadoPessoa(): \n" + e.getMessage());
//        } finally {
//            Conexao.closeAll(conn);
//        }
//        return existe;
//    }
//}
}
