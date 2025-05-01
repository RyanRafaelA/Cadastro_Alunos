package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Aluno {
	private final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private int matricula;
	private String nome;
	private LocalDate dataNascimento;
	private String curso;
	private String email;
	private String telefone;
	
	public Aluno() {}
	public Aluno(int matricula, String nome, String dataNascimento, String curso, String email, String telefone) {
		this.matricula = matricula;
		this.nome = nome;
		this.dataNascimento = LocalDate.parse(dataNascimento, FORMATO_DATA);
		this.curso = curso;
		this.email = email;
		this.telefone = telefone;
	}
	
	public String getCurso() { return curso; }
	public void setCurso(String curso) { this.curso = curso; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getTelefone() { return telefone; }
	public void setTelefone(String telefone) { this.telefone = telefone; }
	
	public int getMatricula() { return matricula; }
	
	public String getNome() { return nome; }
	
	public LocalDate getDataNascimento() { return dataNascimento; }
	
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return matricula == other.matricula;
	}
	
	@Override
	public String toString() {
		return "Nome: "+getNome()+"\nMatricula: "+getMatricula()+"\nCurso: "+getCurso()+"\nData Nascimento: "+getDataNascimento()+
				"\nE-mail: "+getEmail()+"\nTelefone: "+getTelefone();
	}
	
	
}
