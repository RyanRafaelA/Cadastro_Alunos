package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import util.Conexao;

public class AlunoDAO {
	
	private String transformandoDateString(Date dataNascimentoBD) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate ld = dataNascimentoBD.toLocalDate();
		
		String dataFormatada = ld.format(dtf);
		
		return dataFormatada;
	}
	
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
	
	public List<Aluno> lerAlunos(){
		List<Aluno> alunosBD = new ArrayList<>();
		
		String SQL = "SELECT * FROM Aluno";
		int matricula;
		String nome, dataNascimento, curso, email, telefone;
		
		try {
			Connection conn = Conexao.getConexao();
			
			PreparedStatement stmt = conn.prepareStatement(SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				matricula = rs.getInt("matricula");
				nome = rs.getString("nome");
				dataNascimento = transformandoDateString(rs.getDate("data_nascimento"));
				curso = rs.getString("curso");
				email = rs.getString("email");
				telefone = rs.getString("telefone");
				
				alunosBD.add(new Aluno(matricula, nome, dataNascimento, curso, email, telefone));
			}
			
			return alunosBD;
		}
		catch(SQLException ex) {
			System.err.println("Erro na conexão com o banco de dados. "+ex.getMessage());
		}
		catch(IOException e){
			e.printStackTrace();
		} 
		return null;
	}
	
	public Aluno pesquisarAluno(int matricula) {
		Aluno alunoPesquisado = null;
		
		String sql = "SELECT * FROM Aluno WHERE matricula = ?";
		String nome, dataNascimento, curso, email, telefone;
		
		try {
			Connection conn = Conexao.getConexao();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, matricula);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				nome = rs.getString("nome");
				dataNascimento = transformandoDateString(rs.getDate("data_nascimento"));
				curso = rs.getString("curso");
				email = rs.getString("email");
				telefone = rs.getString("telefone");
			
				alunoPesquisado = new Aluno(matricula, nome, dataNascimento, curso, email, telefone);
			} else {
				System.err.println("Não foi encontrado nenhum aluno");
			}
		}
		catch(SQLException ex) {
			System.err.println("Erro na conexão com o banco de dados. "+ex.getMessage());
		}
		catch(IOException e){
			e.printStackTrace();
		} 
		return alunoPesquisado;
	}
	
	public void atualizarCursoAluno(int matricula, String curso) {
		String sql = "UPDATE Aluno SET curso = ? WHERE matricula = ?";
		
		try {
			Connection conn = Conexao.getConexao();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, curso);
			stmt.setInt(2, matricula);
			stmt.executeUpdate();
			
			System.out.println("Aluno atualizado com sucesso.");
		}
		catch(SQLException ex) {
			System.err.println("Erro na conexão com o banco de dados. "+ex.getMessage());
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void atualizarEmailAluno(int matricula, String email) {
		String sql = "UPDATE Aluno SET email = ? WHERE matricula = ?";
		
		try {
			Connection conn = Conexao.getConexao();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, email);
			stmt.setInt(2, matricula);
			stmt.executeUpdate();
			
			System.out.println("Aluno atualizado com sucesso.");
		}
		catch(SQLException ex) {
			System.err.println("Erro na conexão com o banco de dados. "+ex.getMessage());
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
