package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Aluno;
import util.Conexao;

public class AlunoDAO {
	
	public void criarAluno(Aluno novoAluno) {
		String sql = "INSERT INTO Aluno (nome, data_nascimento, curso, email, telefone) VALUES (?, ?, ?, ?, ?)";
		
		try {
			Connection conn = Conexao.getConexao();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, novoAluno.getNome());
			stmt.setDate(2, java.sql.Date.valueOf(novoAluno.getDataNascimento()));
			stmt.setString(3, novoAluno.getCurso());
			stmt.setString(4, novoAluno.getEmail());
			stmt.setString(5, novoAluno.getTelefone());
			
			stmt.executeUpdate();
			
			System.out.println("Novo Aluno adicionado com sucesso.");
		}
		catch(SQLException ex) {
			System.err.println("Erro na conexão com o banco de dados. "+ex.getMessage());
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
