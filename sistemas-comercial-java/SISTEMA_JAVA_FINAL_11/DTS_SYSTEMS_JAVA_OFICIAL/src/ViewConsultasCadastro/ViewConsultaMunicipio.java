package ViewConsultasCadastro;

import ControllerCadastro.ControllerManutencaoMunicipio;
import ModelCadastro.ModelMunicipio;
import Principal.Conexao;
import Estrutura.ViewManutencaoPadrao;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gelvazio
 */
public class ViewConsultaMunicipio extends ViewManutencaoPadrao {

    String SQLConsulta_Cidade;
    JTextField campoCodigo;
    JComboBox campoCodigoEstado;

    /**
     * Creates new form LocalizaUsuario
     */
    public DefaultComboBoxModel getComboCampo() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        String auxEstado = "Estado";
        String auxNome = "Nome";
        String auxIBGE = "IBGE";
        String auxCEP = "CEP";
        try {
            modelo.addElement(auxEstado);
            modelo.addElement(auxNome);
            modelo.addElement(auxIBGE);
            modelo.addElement(auxCEP);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no Método getComboCampo(): \n" + erro.getMessage());
        } finally {
            return modelo;
        }
    }

    public DefaultComboBoxModel getComboValor() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        String auxIgual = "Igual";
        String auxDiferente = "Diferente";
        String auxMaior = "Maior";
        String auxMenor = "Menor";
        String auxMaiorIgual = "MaiorIgual";
        String auxMenorIgual = "MenorIgual";
        String auxParecido = "Parecido";
        try {
            modelo.addElement(auxIgual);
            modelo.addElement(auxParecido);
            modelo.addElement(auxMaior);
            modelo.addElement(auxMenor);
            modelo.addElement(auxMaiorIgual);
            modelo.addElement(auxMenorIgual);
            modelo.addElement(auxDiferente);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no Método getComboValor(): \n" + erro.getMessage());
        } finally {
            return modelo;
        }
    }

    public void PegaValorCamposComboboxCampo_E_Valor(String SQLValorCamposComboboxCampo_E_Valor) {
        String auxedtPesquisa = null;
        String auxCampo = cbCampo.getSelectedItem().toString();
        String auxValor = cbValor.getSelectedItem().toString();
        //Programação do SQL do Estado
        if ((auxCampo.equals("Estado")) & (auxValor.equals("Igual"))) {
            auxCampo = "cd_estado";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "LIKE UPPER('" + auxedtPesquisa + "%')";
        } else if ((auxCampo.equals("Estado")) & (auxValor.equals("Diferente"))) {
            auxCampo = "cd_estado";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "<> '" + auxedtPesquisa + "'";
        } else if ((auxCampo.equals("Estado")) & (auxValor.equals("Maior"))) {
            auxCampo = "cd_estado";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = ">'" + auxedtPesquisa + "'";
        } else if ((auxCampo.equals("Estado")) & (auxValor.equals("Menor"))) {
            auxCampo = "cd_estado";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "<'" + auxedtPesquisa + "'";
        } else if ((auxCampo.equals("Estado")) & (auxValor.equals("MaiorIgual"))) {
            auxCampo = "cd_estado";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = ">='" + auxedtPesquisa + "'";
        } else if ((auxCampo.equals("Estado")) & (auxValor.equals("MenorIgual"))) {
            auxCampo = "cd_estado";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "<='" + auxedtPesquisa + "'";
        } else if ((auxCampo.equals("Estado")) & (auxValor.equals("Parecido"))) {
            auxCampo = "cd_estado";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "LIKE UPPER('" + auxedtPesquisa + "%')";
        }
        //######################################################################################################
        //######################################################################################################
        //######################################################################################################
        //######################################################################################################
        //######################################################################################################
        //######################################################################################################
        //Programação do SQL do Nome
        if ((auxCampo.equals("Nome")) & (auxValor.equals("Igual"))) {
            auxCampo = "ds_municipio";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "LIKE UPPER('" + auxedtPesquisa + "%')";
        } else if ((auxCampo.equals("Nome")) & (auxValor.equals("Diferente"))) {
            auxCampo = "ds_municipio";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "<> '" + auxedtPesquisa + "'";
        } else if ((auxCampo.equals("Nome")) & (auxValor.equals("Maior"))) {
            auxCampo = "ds_municipio";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = ">'" + auxedtPesquisa + "'";
        } else if ((auxCampo.equals("Nome")) & (auxValor.equals("Menor"))) {
            auxCampo = "ds_municipio";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "<'" + auxedtPesquisa + "'";
        } else if ((auxCampo.equals("Nome")) & (auxValor.equals("MaiorIgual"))) {
            auxCampo = "ds_municipio";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = ">='" + auxedtPesquisa + "'";
        } else if ((auxCampo.equals("Nome")) & (auxValor.equals("MenorIgual"))) {
            auxCampo = "ds_municipio";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "<='" + auxedtPesquisa + "'";
        } else if ((auxCampo.equals("Nome")) & (auxValor.equals("Parecido"))) {
            auxCampo = "ds_municipio";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "LIKE UPPER('" + auxedtPesquisa + "%')";
        }
        //######################################################################################################
        //######################################################################################################
        //######################################################################################################
        //######################################################################################################
        //######################################################################################################
        //######################################################################################################
        //Programação do SQL do IBGE
        if ((auxCampo.equals("IBGE")) & (auxValor.equals("Igual"))) {
            auxCampo = "cd_ibge";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "=" + auxedtPesquisa;
        } else if ((auxCampo.equals("IBGE")) & (auxValor.equals("Diferente"))) {
            auxCampo = "cd_ibge";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "<>" + auxedtPesquisa;
        } else if ((auxCampo.equals("IBGE")) & (auxValor.equals("Maior"))) {
            auxCampo = "cd_ibge";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = ">" + auxedtPesquisa;
        } else if ((auxCampo.equals("IBGE")) & (auxValor.equals("Menor"))) {
            auxCampo = "cd_ibge";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "<" + auxedtPesquisa;
        } else if ((auxCampo.equals("IBGE")) & (auxValor.equals("MaiorIgual"))) {
            auxCampo = "cd_ibge";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = ">=" + auxedtPesquisa;
        } else if ((auxCampo.equals("IBGE")) & (auxValor.equals("MenorIgual"))) {
            auxCampo = "cd_ibge";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "<=" + auxedtPesquisa;
        } else if ((auxCampo.equals("IBGE")) & (auxValor.equals("Parecido"))) {
            auxCampo = "cd_ibge";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "LIKE UPPER('" + auxedtPesquisa + "%')";
        }

        //######################################################################################################
        //######################################################################################################
        //######################################################################################################
        //######################################################################################################
        //######################################################################################################
        //######################################################################################################
        //Programação do SQL do CEP
        if ((auxCampo.equals("CEP")) & (auxValor.equals("Igual"))) {
            auxCampo = "cd_cep";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "=" + auxedtPesquisa;
        } else if ((auxCampo.equals("CEP")) & (auxValor.equals("Diferente"))) {
            auxCampo = "cd_cep";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "<>" + auxedtPesquisa;
        } else if ((auxCampo.equals("CEP")) & (auxValor.equals("Maior"))) {
            auxCampo = "cd_cep";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = ">" + auxedtPesquisa;
        } else if ((auxCampo.equals("CEP")) & (auxValor.equals("Menor"))) {
            auxCampo = "cd_cep";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "<" + auxedtPesquisa;
        } else if ((auxCampo.equals("CEP")) & (auxValor.equals("MaiorIgual"))) {
            auxCampo = "cd_cep";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = ">=" + auxedtPesquisa;
        } else if ((auxCampo.equals("CEP")) & (auxValor.equals("MenorIgual"))) {
            auxCampo = "cd_cep";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "<=" + auxedtPesquisa;
        } else if ((auxCampo.equals("CEP")) & (auxValor.equals("Parecido"))) {
            auxCampo = "cd_cep";
            auxedtPesquisa = edtPesquisa.getText();
            auxValor = "LIKE UPPER('" + auxedtPesquisa + "%')";
        }
        //E passado por parametro os valores do Edit  mais os valores selecionados do Combobox  para o SQL
        //A Variavel "SQLValorCamposComboboxCampo_E_Valor" recebe o SQL
        SQLValorCamposComboboxCampo_E_Valor = "select * from municipio where " + auxCampo + " " + auxValor;
        //A Variavel global "SQLConsulta_Cidade" recebe por parametro a variavel "SQLValorCamposComboboxCampo_E_Valor"
        SQLConsulta_Cidade = SQLValorCamposComboboxCampo_E_Valor;
    }

    public void ValidaCampoPesquisa() {
        //JOptionPane.showMessageDialog(null, "Precisa Fazer Validacao de deixar digitar so numero qdo for o Codigo!!");
        //Nesta parte é feita a Validação do Edit  edtPesquisa, para que caso seja nulo de uma MSG.
        String auxedtPesquisa = edtPesquisa.getText();
        if (auxedtPesquisa.equals("")) {
            JOptionPane.showMessageDialog(null, "Favor Digitar algum valor ou caractere no campo Pesquisa!");
            edtPesquisa.grabFocus();
        } else {
            //Não estando Nulo o campo é chamado o Metodo abaixo que é o responsavel pela pesquisa Compelta da Tela.
            ListaCidadesCompleto();
        }
    }

    public void mostrar_mensagem_tres() {
        JOptionPane.showMessageDialog(null, "Teste de Mensagem Tres Valor do SQL: !!!\n " + SQLConsulta_Cidade);
    }

    public ArrayList SQLConsultagetTodos_Completo() {
        //Aqui é chamado o Metodo "PegaValorCamposComboboxCampo_E_Valor("");" para pegar os valores da tela
        //Caso nao seja repassado ele nao da certo pois nao pega nada do edtPesquisa
        PegaValorCamposComboboxCampo_E_Valor("");
        ArrayList listaCidade = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            //Nessa Parte é passado po parametro os Dados da Variavel "SQLConsulta_Cidade"
            //que contem o sql da pesquisa.
            rs = stmt.executeQuery(SQLConsulta_Cidade);
            while (rs.next()) {
                String auxcd_estado = rs.getString("cd_estado");
                int auxcd_municipio = rs.getInt("cd_municipio");
                String auxds_municipio = rs.getString("ds_municipio");
                int auxcd_ibge = rs.getInt("cd_ibge");
                String auxcd_cep = rs.getString("cd_cep");
                int auxcd_usuario = rs.getInt("cd_usuario");
                int auxcd_filial = rs.getInt("cd_filial");
                ModelMunicipio cidade = new ModelMunicipio(
                        auxcd_estado,
                        auxcd_municipio,
                        auxds_municipio,
                        auxcd_ibge,
                        auxcd_cep,
                        auxcd_usuario,
                        auxcd_filial);
                listaCidade.add(cidade);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no sql, SQLConsultagetTodos_Completo: \n" + erro.getMessage());
        } finally {
            Conexao.closeAll(conn);
        }
        return listaCidade;
    }

    public void ListaTodasCidades() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cod.Municipio");
        modelo.addColumn("Estado");
        modelo.addColumn("Descricao");
        modelo.addColumn("CEP");
        modelo.addColumn("IBGE");
        //Nesta Parte o ArrayList dos Usuarios(Que chama a Classe Usuario) recebe por parametro o Metodo "SQLConsultagetTodos_Completo()" que tera os dados da pesquisa
        //Este Metodo Chama o ArrayList  que tera os dados e passa para a DefaultTableModel
        ControllerManutencaoMunicipio cidadedb = new ControllerManutencaoMunicipio();
        ArrayList<ModelMunicipio> cidades = cidadedb.getTodos();
        for (ModelMunicipio auxCidade : cidades) {
            modelo.addRow(new Object[]{
                auxCidade.getCd_municipio(),
                auxCidade.getCd_estado(),
                auxCidade.getDs_municipio(),
                auxCidade.getCd_cep(),
                auxCidade.getCd_ibge()
            });
        }
        tbGrid.setModel(modelo);
    }

    public void ListaCidadesCompleto() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cod.Cod.Municipio");
        modelo.addColumn("Estado");
        modelo.addColumn("Descricao");
        modelo.addColumn("CEP");
        modelo.addColumn("IBGE");
        //Nesta Parte o ArrayList dos Usuarios(Que chama a Classe Usuario) recebe por parametro o Metodo "SQLConsultagetTodos_Completo()" que tera os dados da pesquisa
        //Este Metodo Chama o ArrayList  que tera os dados e passa para a DefaultTableModel
        ArrayList<ModelMunicipio> cidades = SQLConsultagetTodos_Completo();
        for (ModelMunicipio auxCidade : cidades) {
            modelo.addRow(new Object[]{
                auxCidade.getCd_municipio(),
                auxCidade.getCd_estado(),
                auxCidade.getDs_municipio(),
                auxCidade.getCd_cep(),
                auxCidade.getCd_ibge()
            });
        }
        tbGrid.setModel(modelo);
    }

    public ViewConsultaMunicipio(JTextField campoCodigo, JComboBox campoCodigoEstado) {
        initComponents();
        ListaTodasCidades();
        cbCampo.setModel(getComboCampo());
        cbValor.setModel(getComboValor());
        centralizaFormulario();
        this.campoCodigo = campoCodigo;
        this.campoCodigoEstado = campoCodigoEstado;
    }

    /**
     * Este método é chamado de dentro do construtor para inicializar o
     * formulário.    ATENÇÃO: Não modifique o código. O conteúdo deste método é
     * sempre     regenerados pelo editor de formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbGrid = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbCampo = new javax.swing.JComboBox();
        cbValor = new javax.swing.JComboBox();
        edtPesquisa = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);

        tbGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbGrid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGridMouseClicked(evt);
            }
        });
        tbGrid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbGridKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbGrid);

        jLabel1.setText("Valor:");

        jLabel2.setText("Digite sua pesquisa ...");

        jLabel3.setText("Campo:");

        cbCampo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCampoActionPerformed(evt);
            }
        });

        cbValor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        edtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtPesquisaKeyPressed(evt);
            }
        });

        btnPesquisa.setText("Pesquisar");
        btnPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisaMouseClicked(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Carregar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbValor, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 87, Short.MAX_VALUE))
                    .addComponent(edtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(btnPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(36, 36, 36)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Consulta Municipio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jLabel4)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbGridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGridMouseClicked
        // TODO add your handling code here:
        int linha = tbGrid.getSelectedRow();
        if (linha >= 0) {
            String auxCodigo = tbGrid.getValueAt(linha, 0).toString();
            campoCodigo.setText(auxCodigo);
        }
    }//GEN-LAST:event_tbGridMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCampoActionPerformed
    }//GEN-LAST:event_cbCampoActionPerformed

    private void btnPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisaMouseClicked
        ValidaCampoPesquisa();
        edtPesquisa.getText();
    }//GEN-LAST:event_btnPesquisaMouseClicked

    private void edtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ValidaCampoPesquisa();
        }
    }//GEN-LAST:event_edtPesquisaKeyPressed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        int linha = tbGrid.getSelectedRow();
        if (linha >= 0) {
            String auxCodigo = tbGrid.getValueAt(linha, 0).toString();
            campoCodigo.setText(auxCodigo);
            campoCodigo.grabFocus();
            dispose();
        }
    }//GEN-LAST:event_jButton3MouseClicked

private void tbGridKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbGridKeyPressed
// TODO add your handling code here:
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        int linha = tbGrid.getSelectedRow();
        if (linha >= 0) {
            String auxCodigo = tbGrid.getValueAt(linha, 0).toString();
            campoCodigo.setText(auxCodigo);
            campoCodigo.grabFocus();
            dispose();
        }
    }
}//GEN-LAST:event_tbGridKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JComboBox cbCampo;
    private javax.swing.JComboBox cbValor;
    private javax.swing.JTextField edtPesquisa;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbGrid;
    // End of variables declaration//GEN-END:variables
}