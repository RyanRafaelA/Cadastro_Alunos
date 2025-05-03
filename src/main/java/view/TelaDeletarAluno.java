package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.AlunoDAO;

public class TelaDeletarAluno extends JFrame{
	private static final long serialVersionUID = 1L;

	public TelaDeletarAluno() {
		setTitle("Deletar Aluno");
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
		JButton BDeletar = new JButton("Deletar");
		panel.add(BDeletar, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		JTextArea areaResultado = new JTextArea(10, 10);
		panel.add(areaResultado, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		JButton BVoltar = new JButton("Volta");
		panel.add(BVoltar, gbc);
		
		BDeletar.addActionListener(e -> {
			String matriculaTexto = campoMatricula.getText();
			areaResultado.setText("");
			
			if(matriculaTexto.isEmpty()) {
				areaResultado.setText("O campo matricula é obrigatorio!");
			} else {
				try {
					int matricula = Integer.parseInt(matriculaTexto);
					String resultado = AlunoDAO.deletarAluno(matricula);
					
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
