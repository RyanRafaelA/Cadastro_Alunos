package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.AlunoDAO;
import model.Aluno;

public class TelaVerAlunos extends JFrame{
	private static final long serialVersionUID = 1L;

	public TelaVerAlunos() {
		setTitle("Tela de Alunos");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("Matricula: "), gbc);
		
		gbc.gridx = 1;
		JTextField campoMatricula = new JTextField(10);
		panel.add(campoMatricula, gbc);
		
		gbc.gridx = 2;
		JButton pesquisa = new JButton("Pesquisa");
		panel.add(pesquisa, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		JTextArea areaResultado = new JTextArea(20, 40);
		JScrollPane scroll = new JScrollPane(areaResultado);
		panel.add(scroll, gbc);
		
		pesquisa.addActionListener((ActionEvent e) -> {
			StringBuilder resultado = new StringBuilder();
			String matriculaTexto = campoMatricula.getText().trim();
			areaResultado.setText("");
			
			if(matriculaTexto.isEmpty()) {
				List<Aluno> listaAlunos = AlunoDAO.lerAlunos();
				if(listaAlunos.isEmpty()) {
					areaResultado.setText("Nenhum aluno encontrado.");
				} else {
					for(Aluno aluno: listaAlunos) {
						resultado.append(aluno.toString())
						.append("\n***************************************\n");
					}
					areaResultado.setText(resultado.toString());
				}
			} else {
				try {
					int matricula = Integer.parseInt(matriculaTexto);
					Aluno aluno = AlunoDAO.pesquisarAluno(matricula);
					if(aluno != null) {
						areaResultado.setText(aluno.toString());
					} else {
						areaResultado.setText("Aluno não encontrado.");
					}
				}
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Digite uma matrícula válida (número inteiro).");
				}
			}
		});
		
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		JButton BVoltar = new JButton("Voltar");
		panel.add(BVoltar, gbc);
		
		BVoltar.addActionListener(e -> { 
			new TelaInicial();
			dispose();
		});
		
		add(panel);
		setVisible(true);
	}

}
