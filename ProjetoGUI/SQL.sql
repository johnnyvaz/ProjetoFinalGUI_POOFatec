mysql> create database academico;

mysql> use academico;

mysql>CREATE TABLE `aluno` (
	`codigo` INT(11) NOT NULL AUTO_INCREMENT,
	`cidade` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`cpf` VARCHAR(15) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`documentos` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`endereco` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`estado` VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`nome` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`rg` VARCHAR(15) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`sexo` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	PRIMARY KEY (`codigo`)
)
COLLATE='utf8_unicode_ci'
ENGINE=MyISAM
;
