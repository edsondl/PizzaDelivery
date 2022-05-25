/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import beans.ClienteBeans;
import controller.ClienteController;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import utilitarios.VerificadoresECorretores;

/**
 *
 * @author Edson Dias
 */
public class ClienteGUI extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone; // Máscara para telefone
    ClienteBeans ClienteB; // Criando o bean
    ClienteController ClienteC; // criando o controller
    DefaultTableModel Modelo; //Classe abstrata da jTable fica mais fácil trabalhar
    
    
    /**
     * Creates new form ClienteGUI
     */
    public ClienteGUI() {
        initComponents();
        
        BotaoCadastrar.setEnabled(false);
        jButtonLiberar.setEnabled(false);
        BotaoEditar.setEnabled(false);
        
        jTextFieldCodigo.setEditable(false);
        jTextFieldData.setEditable(false); //Desabilita campo data
        
        habilitaCampos(false);
        
        ClienteB = new ClienteBeans();  //Instanciando ClienteBeans
        ClienteC = new ClienteController(); //Instanciando ClienteBeans
        Modelo = (DefaultTableModel)Tabela.getModel();//No contrutor instanciando tabela
        jTextFieldData.setText(VerificadoresECorretores.retornoDeDataAtual());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelTelefone = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        jSeparatorCodigo = new javax.swing.JSeparator();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldRua = new javax.swing.JTextField();
        jLabelPesquisar = new javax.swing.JLabel();
        jLabelBairro = new javax.swing.JLabel();
        try {
            FormatoTelefone = new MaskFormatter("(##)####-####");
        }catch(Exception Erro) {
            JOptionPane.showMessageDialog(null, "Impossível formatar campo Telefone!!!", "Erro de formatação", 0);
        }
        jFormattedTextFieldTelefone = new JFormattedTextField(FormatoTelefone);
        ;
        jLabelRua = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jSeparatorFormulario = new javax.swing.JSeparator();
        jLabelData = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jSeparatorPesquisar = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jSeparatorTabela = new javax.swing.JSeparator();
        BotaoNovo = new javax.swing.JButton();
        BotaoCadastrar = new javax.swing.JButton();
        BotaoEditar = new javax.swing.JButton();
        jButtonLiberar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Manutenção de Clientes");
        getContentPane().setLayout(null);

        jLabelCodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelCodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCodigo.setText("Código");
        getContentPane().add(jLabelCodigo);
        jLabelCodigo.setBounds(0, 0, 430, 17);

        jTextFieldCodigo.setEditable(false);
        jTextFieldCodigo.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextFieldCodigo.setForeground(new java.awt.Color(255, 51, 51));
        jTextFieldCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodigo.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jTextFieldCodigo.setEnabled(false);
        jTextFieldCodigo.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextFieldCodigo);
        jTextFieldCodigo.setBounds(0, 20, 430, 21);

        jLabelTelefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTelefone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/telefone.png"))); // NOI18N
        getContentPane().add(jLabelTelefone);
        jLabelTelefone.setBounds(20, 170, 50, 50);
        getContentPane().add(jTextFieldBairro);
        jTextFieldBairro.setBounds(80, 140, 350, 30);
        getContentPane().add(jSeparatorCodigo);
        jSeparatorCodigo.setBounds(0, 50, 430, 0);

        jLabelNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelNome.setText("Nome:");
        getContentPane().add(jLabelNome);
        jLabelNome.setBounds(0, 70, 44, 17);

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNome);
        jTextFieldNome.setBounds(80, 60, 350, 30);
        getContentPane().add(jTextFieldRua);
        jTextFieldRua.setBounds(80, 100, 350, 30);

        jLabelPesquisar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        getContentPane().add(jLabelPesquisar);
        jLabelPesquisar.setBounds(20, 230, 50, 40);

        jLabelBairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelBairro.setText("Bairro:");
        getContentPane().add(jLabelBairro);
        jLabelBairro.setBounds(0, 150, 50, 17);
        getContentPane().add(jFormattedTextFieldTelefone);
        jFormattedTextFieldTelefone.setBounds(80, 180, 120, 30);

        jLabelRua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelRua.setText("Rua:");
        getContentPane().add(jLabelRua);
        jLabelRua.setBounds(0, 110, 40, 17);

        jTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldData);
        jTextFieldData.setBounds(270, 180, 160, 30);
        getContentPane().add(jSeparatorFormulario);
        jSeparatorFormulario.setBounds(0, 220, 450, 0);

        jLabelData.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dataCalendario.png"))); // NOI18N
        getContentPane().add(jLabelData);
        jLabelData.setBounds(210, 170, 50, 50);

        jTextFieldPesquisar.setForeground(new java.awt.Color(51, 51, 255));
        jTextFieldPesquisar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisarActionPerformed(evt);
            }
        });
        jTextFieldPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldPesquisar);
        jTextFieldPesquisar.setBounds(80, 230, 350, 30);
        getContentPane().add(jSeparatorPesquisar);
        jSeparatorPesquisar.setBounds(0, 268, 430, 2);

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Rua", "Bairro", "Telefone", "Data do Cadastro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabela.getTableHeader().setReorderingAllowed(false);
        Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TabelaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela);
        if (Tabela.getColumnModel().getColumnCount() > 0) {
            Tabela.getColumnModel().getColumn(0).setResizable(false);
            Tabela.getColumnModel().getColumn(1).setResizable(false);
            Tabela.getColumnModel().getColumn(2).setResizable(false);
            Tabela.getColumnModel().getColumn(3).setResizable(false);
            Tabela.getColumnModel().getColumn(4).setResizable(false);
            Tabela.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 280, 440, 120);
        getContentPane().add(jSeparatorTabela);
        jSeparatorTabela.setBounds(0, 408, 430, 2);

        BotaoNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        BotaoNovo.setToolTipText("Habilita o formulário para receber novos dados");
        BotaoNovo.setAutoscrolls(true);
        BotaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNovoActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoNovo);
        BotaoNovo.setBounds(34, 430, 50, 50);

        BotaoCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvarV2.png"))); // NOI18N
        BotaoCadastrar.setToolTipText("Cadastro de um novo cliente");
        BotaoCadastrar.setAutoscrolls(true);
        BotaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoCadastrar);
        BotaoCadastrar.setBounds(100, 430, 50, 50);

        BotaoEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        BotaoEditar.setToolTipText("Para editar alguma informação do cliente");
        BotaoEditar.setAutoscrolls(true);
        BotaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoEditar);
        BotaoEditar.setBounds(230, 430, 50, 50);

        jButtonLiberar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/liberarParaEditar.png"))); // NOI18N
        jButtonLiberar.setToolTipText("Libera os campos para edição");
        jButtonLiberar.setAutoscrolls(true);
        jButtonLiberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLiberarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLiberar);
        jButtonLiberar.setBounds(160, 430, 50, 50);

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fechar.png"))); // NOI18N
        jButtonFechar.setAutoscrolls(true);
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFechar);
        jButtonFechar.setBounds(300, 430, 50, 50);

        setBounds(0, 0, 484, 546);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisarActionPerformed

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
        Modelo.setRowCount(0);  //Limpa tabela
        BotaoCadastrar.setEnabled(true);
        jButtonLiberar.setEnabled(false);
        BotaoEditar.setEnabled(false);
        
        habilitaCampos(true);
        jTextFieldNome.requestFocus(); // Foco no nome
        jTextFieldCodigo.setText(ClienteC.controleDeCodigo());
        limpaNovo();
    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void BotaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarActionPerformed
        //Cadastrar
        populaClienteBeans();
        if(ClienteC.verificarDados(ClienteB)) {
            limpaTudo();
            habilitaCampos(false);
        }
        
    }//GEN-LAST:event_BotaoCadastrarActionPerformed

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        // TODO add your handling code here:
        populaClienteBeans();
        if(ClienteC.verificarDadosParaEditar(ClienteB)) {
            limpaTudo();
            habilitaCampos(false);
        }
    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void jTextFieldPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisarKeyPressed

    private void jTextFieldPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyReleased
        BotaoCadastrar.setEnabled(false);
        jButtonLiberar.setEnabled(true);
        BotaoEditar.setEnabled(true);
        
        Modelo.setNumRows(0);
        ClienteC.controlePesquisa(jTextFieldPesquisar.getText(), Modelo);
    }//GEN-LAST:event_jTextFieldPesquisarKeyReleased

    private void TabelaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMousePressed
        ClienteB = ClienteC.controlePreenchimento(Integer.parseInt(Modelo.getValueAt(Tabela.getSelectedRow(), 0).toString()));
        jTextFieldCodigo.setText(ClienteB.getCli_Codigo() + "");
        jTextFieldNome.setText(ClienteB.getCli_Nome() + "");
        jTextFieldRua.setText(ClienteB.getCli_Rua() + "");
        jTextFieldBairro.setText(ClienteB.getCli_Bairro() + "");
        jFormattedTextFieldTelefone.setText(ClienteB.getCli_Telefone() + "");
        jTextFieldData.setText(ClienteB.getCli_DataCad() + "");
    }//GEN-LAST:event_TabelaMousePressed

    private void jButtonLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLiberarActionPerformed
        // TODO add your handling code here:
        BotaoCadastrar.setEnabled(false);
        BotaoEditar.setEnabled(true);
        
        habilitaCampos(true);
        jTextFieldNome.requestFocus();
    }//GEN-LAST:event_jButtonLiberarActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCadastrar;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JTable Tabela;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonLiberar;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JLabel jLabelRua;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparatorCodigo;
    private javax.swing.JSeparator jSeparatorFormulario;
    private javax.swing.JSeparator jSeparatorPesquisar;
    private javax.swing.JSeparator jSeparatorTabela;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldRua;
    // End of variables declaration//GEN-END:variables

    final void habilitaCampos(boolean Valor) {
    jTextFieldNome.setEditable(Valor);
    jTextFieldRua.setEditable(Valor);
    jFormattedTextFieldTelefone.setEditable(Valor);
    jTextFieldBairro.setEditable(Valor);
    }
    
    final void populaClienteBeans() {
        ClienteB.setCli_Nome(jTextFieldNome.getText());
        ClienteB.setCli_Rua(jTextFieldRua.getText());
        ClienteB.setCli_Bairro(jTextFieldBairro.getText());
        ClienteB.setCli_Telefone(jFormattedTextFieldTelefone.getText());
        ClienteB.setCli_DataCad(jTextFieldData.getText());
    }
    
    final void limpaTudo() {
        jTextFieldCodigo.setText("");
        jTextFieldNome.setText("");
        jTextFieldRua.setText("");
        jTextFieldBairro.setText("");
        jFormattedTextFieldTelefone.setText("");
        jTextFieldData.setText("");
    }
    
    final void limpaNovo() {
        jTextFieldNome.setText("");
        jTextFieldRua.setText("");
        jTextFieldBairro.setText("");
        jFormattedTextFieldTelefone.setText("");
    }
 }
