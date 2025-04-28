CREATE DATABASE CadastroAlunos;

USE CadastroAlunos;

CREATE TABLE Aluno (
	matricula INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(250) NOT NULL,
    data_Nascimento DATE NOT NULL,
    curso VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL,
    telefone VARCHAR(100) NOT NULL
);

INSERT INTO Aluno (nome, data_nascimento, curso, email, telefone)
	VALUES
		('Juan Jonas', '2000-07-24', 'Fisica Quantica', 'Juan@gmail.com','(45)98888888'),
        ('Fernanda Mendonsa', '2004-01-12', 'Biologia', 'Fernanda@gmail.com','(55)995555555'),
        ('Maria Clara', '2003-08-01', 'Engenharia Civil', 'Maria@gmail.com','(72)988675799'),
        ('Pedro Gomes', '2001-11-11', 'Ciencia da Computação', 'Gomes@gmail.com','(45)98688648'),
        ('Maria Helena', '2006-03-12', 'Engenharia de Pesca', 'Helena@gmail.com','(80)98857335');