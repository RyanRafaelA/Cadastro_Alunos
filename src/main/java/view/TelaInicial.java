package view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaInicial extends JFrame{
	private static final long serialVersionUID = 1L;

	public TelaInicial() {
		setTitle("Cadastro Aluno");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		
		JLabel label = new JLabel("Bem-vindo a Tela de Aluno");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(label);
		panel.add(Box.createVerticalStrut(20));
		
		String[] textos = {
				"Novo Aluno", "Ver Alunos", "Atualizar Aluno", "Deletar Aluno", "Sair"
		};
		
		for(String texto: textos) {
			JButton btn = new JButton(texto);
			btn.setAlignmentX(Component.CENTER_ALIGNMENT);
			btn.setMaximumSize(new Dimension(200, 30));
			btn.setFocusable(false);
			panel.add(btn);
			panel.add(Box.createHorizontalStrut(10));
			
			btn.addActionListener(e -> {
				if(texto.equals("Novo Aluno")) {
					new TelaNovoAluno();
					dispose();
				} else if(texto.equals("Ver Alunos")) {
					//new TelaVerAlunos();
					dispose();
				} else if(texto.equals("Atualizar Aluno")) {
					//new TelaAtualizarAluno();
					dispose();
				} else if(texto.equals("Deletar Aluno")) {
					//new TelaDeletarAluno();
					dispose();
				} else {
					dispose();
				}
			});
		}
		
		add(panel);
		
		setVisible(true);
	}

}
