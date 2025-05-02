package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.AlunoDAO;
import model.Aluno;

public class TelaNovoAluno extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public TelaNovoAluno() {
		setTitle("Novo Aluno");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("Nome: "), gbc);
		gbc.gridx = 1;
		JTextField campoNome = new JTextField(20);
		panel.add(campoNome, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(new JLabel("Data Nascimento (dd/mm/yyyy): "), gbc);
		gbc.gridx = 1;
		JTextField campoDataNascimento = new JTextField(20);
		panel.add(campoDataNascimento, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(new JLabel("Curso: "), gbc);
		gbc.gridx = 1;
		JTextField campoCurso = new JTextField(20);
		panel.add(campoCurso, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(new JLabel("E-mail: "), gbc);
		gbc.gridx = 1;
		JTextField campoEmail = new JTextField(20);
		panel.add(campoEmail, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(new JLabel("Telefone: "), gbc);
		gbc.gridx = 1;
		JTextField campoTelefone = new JTextField(20);
		panel.add(campoTelefone, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		
		JPanel painelBotoes = new JPanel();
		JButton BSalvar = new JButton("Salvar");
		JButton BLimpar = new JButton("Limpar");
		JButton BVoltar = new JButton("Voltar");
		BVoltar.addActionListener(e -> dispose());
		
		painelBotoes.add(BSalvar);
		painelBotoes.add(BLimpar);
		painelBotoes.add(BVoltar);
		panel.add(painelBotoes, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		JTextArea campoConfirmacao = new JTextArea();
		panel.add(campoConfirmacao, gbc);
		
		BSalvar.addActionListener(e -> {
			String confirmacao;
			String nome = campoNome.getText();
			String dataNascimento = campoDataNascimento.getText();
			String curso = campoCurso.getText();
			String email = campoEmail.getText();
			String telefone = campoTelefone.getText();
			
			boolean telefoneValido = telefone.matches("^\\(\\d{2}\\)\\s\\d{8}$");
			boolean dataValida = dataNascimento.matches("^([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$");
			
			if(telefoneValido && dataValida) {
				confirmacao = AlunoDAO.criarAluno(new Aluno(0, nome, dataNascimento, curso, email, telefone));
			} else {
				confirmacao = "Erro na formatação da Data de Nascimento e do Telefone";
			}
			
			campoConfirmacao.setText(confirmacao);
		});
		
		BLimpar.addActionListener(e -> {
			campoNome.setText("");
			campoDataNascimento.setText("");
			campoCurso.setText("");
			campoEmail.setText("");
			campoTelefone.setText("");
		});
		
		BVoltar.addActionListener(e -> { 
			dispose(); 
			new TelaInicial();
		});
		
		
		add(panel);
		setVisible(true);
	}

}
