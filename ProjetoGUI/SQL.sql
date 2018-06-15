mysql> create database academico;

mysql> use academico;

mysql> create table aluno(
	codigo int, 
	cidade varchar(20), 
	cpf varchar(15), 
	documentos varchar(50), 
	endereco varchar(30), 
	estado varchar(20), 
	nome varchar(30), 
	rg varchar(15), 
	sexo varchar(10), 
	primary key(codigo)
       );
