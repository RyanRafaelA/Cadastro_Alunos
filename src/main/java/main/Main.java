package main;

import dao.AlunoDAO;
import model.Aluno;

public class Main {
	public static void main(String[] args) {
		AlunoDAO alunoBD = new AlunoDAO();
		/***********
		
		Aluno novoAluno = new Aluno(0, "Liliane Jose", "29/01/2007", "Medicina", "liliane@gmail.com", "(81) 987545654");
		
		alunoBD.criarAluno(novoAluno);
		***************/
		/**************************************
		List<Aluno> listaAlunos = new ArrayList<>();
		
		
		listaAlunos = alunoBD.lerAlunos();
		
		for(Aluno x: listaAlunos) {
			System.out.println(x+"\n****************************************************");
		}
		******************************************/
		Aluno alunoPesquisado = alunoBD.pesquisarAluno(2);
		System.out.println(alunoPesquisado);
		
	}

}