/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import view.Conexao;

/**
 *
 * @author yasmim.roeder
 */
public class ControllerVendaDB {

    public boolean procurarProdutoNaVenda(int codigoProduto) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean existe = false;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select procodigo as codigo from tbvenda where procodigo = " + codigoProduto);
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        
        return existe;
    }
    }
    
  
