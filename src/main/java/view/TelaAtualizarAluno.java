package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.AlunoDAO;

public class TelaAtualizarAluno extends JFrame{
	private static final long serialVersionUID = 1L;

	public TelaAtualizarAluno() {
		setTitle("Atualizar Aluno");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("Matricula do aluno atualizado: "), gbc);
		gbc.gridx = 1;
		JTextField campoMatricula = new JTextField(10);
		panel.add(campoMatricula, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(new JLabel("Novo Curso: "), gbc);
		gbc.gridx = 1;
		JTextField campoCurso = new JTextField(20);
		panel.add(campoCurso, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(new JLabel("Novo E-mail: "), gbc);
		gbc.gridx = 1;
		JTextField campoEmail = new JTextField(20);
		panel.add(campoEmail, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(new JLabel("Novo Telefone (xx) xxxx-xxxx: "), gbc);
		gbc.gridx = 1;
		JTextField campoTelefone = new JTextField(20);
		panel.add(campoTelefone, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		JButton BAtualizar = new JButton("Atualizar");
		panel.add(BAtualizar, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 3;
		JTextArea areaResultado = new JTextArea(10, 30);
		panel.add(areaResultado, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		JButton BVoltar = new JButton("Voltar");
		panel.add(BVoltar, gbc);
		
		BAtualizar.addActionListener((ActionEvent e) -> {
			String matriculaTexto = campoMatricula.getText().trim();
			String novoEmail = campoEmail.getText().trim();
			String novoCurso = campoCurso.getText().trim();
			String novoTelefone = campoTelefone.getText().trim();
			
			areaResultado.setText("");
			
			if(matriculaTexto.isEmpty()) {
				areaResultado.setText("O campo matricula é obrigatorio!");
			} else {
				try {
					int matricula = Integer.parseInt(matriculaTexto);
					String resultado = "";
					
					if(!novoCurso.isEmpty()) {
						resultado += AlunoDAO.atualizarCursoAluno(matricula, novoCurso) + "\n";
					}
					if(!novoEmail.isEmpty()) {
						resultado += AlunoDAO.atualizarEmailAluno(matricula, novoEmail) + "\n";
						
					}
					if(!novoTelefone.isEmpty()) {
						boolean telefoneValido = novoTelefone.matches("\\(\\d{2}\\) \\d{4}-\\d{4}");
						if(telefoneValido) {
							resultado += AlunoDAO.atualizarTelefoneAluno(matricula, novoTelefone) + "\n";
						} else {
							resultado += "Formatação do telefone invalida!";
						}
					}
					
					areaResultado.setText(resultado);
				}
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Digite uma matrícula válida (número inteiro).");
				}
			}
		});
		
		BVoltar.addActionListener(e -> {
			new TelaInicial();
			dispose();
		});
		
		add(panel);
		setVisible(true);
	}

}
