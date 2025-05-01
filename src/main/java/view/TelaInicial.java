package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaInicial extends JFrame{
	private static final long serialVersionUID = 1L;

	public TelaInicial() {
		setTitle("Cadastro Usuario");
		setSize(500, 500);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("Bem Vindo a Tela de Aluno");
		label.setBounds(150, 20, 200, 200);
		JButton botao = new JButton("Entrar");
		botao.setBounds(180, 200, 100, 30);
		
		add(label);
		add(botao);
		
		
		setVisible(true);
	}

}
