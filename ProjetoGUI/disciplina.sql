CREATE TABLE `disciplina` (
	`codigo` INT(11) NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(30) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`cargaHoraria` VARCHAR(15) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`professor` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	PRIMARY KEY (`codigo`)
)
COLLATE='utf8_unicode_ci'
ENGINE=MyISAM
AUTO_INCREMENT=2
;
