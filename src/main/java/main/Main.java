package main;

import dao.AlunoDAO;
import model.Aluno;

public class Main {
	public static void main(String[] args) {
		AlunoDAO alunoBD = new AlunoDAO();
		
		Aluno novoAluno = new Aluno(0, "Liliane Jose", "29/01/2007", "Medicina", "liliane@gmail.com", "(81) 987545654");
		
		alunoBD.criarAluno(novoAluno);
	}

}