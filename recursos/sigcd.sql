-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sigcd
-- -----------------------------------------------------
drop database `sigcd`;
CREATE SCHEMA IF NOT EXISTS `sigcd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `sigcd` ;

-- -----------------------------------------------------
-- Table `sigcd`.`GradoAcademicoAA`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`GradoAcademico` (
    `idGradoAcademico` INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`idGradoAcademico`)
)  ENGINE=INNODB DEFAULT CHARACTER SET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

-- -----------------------------------------------------
-- Table `sigcd`.`Estado`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`Estado` (
    `idEstado` INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`idEstado`)
)  ENGINE=INNODB DEFAULT CHARACTER SET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

-- -----------------------------------------------------
-- Table `sigcd`.`Direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sigcd`.`Direccion` (
  `idDireccion` int NOT NULL,
  `distrito` VARCHAR(45) NOT NULL,
  `barrio` VARCHAR(45) NOT NULL,
  `direccionExacta` VARCHAR(100) NOT NULL,
  primary key(`idDireccion`)
) ENGINE=INNODB DEFAULT CHARACTER SET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

-- -----------------------------------------------------
-- Table `sigcd`.`Solicitante`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`Solicitante` (
    `cedula` VARCHAR(45) NOT NULL,
    `nombre` VARCHAR(45) NOT NULL,
    `primerApellido` VARCHAR(45) NOT NULL,
    `segundoApellido` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`cedula`)
)  ENGINE=INNODB DEFAULT CHARACTER SET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;


-- -----------------------------------------------------
-- Table `sigcd`.`Estudiante`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`Estudiante` (
    `cedula` VARCHAR(45) NOT NULL,
    `nombre` VARCHAR(45) NOT NULL,
    `primerApellido` VARCHAR(45) NOT NULL,
    `segundoApellido` VARCHAR(45) NOT NULL,
    `gradoAcademico` INT NOT NULL,
    `edad` INT NOT NULL,
    `fechaNacimiento` VARCHAR(45) NOT NULL,
    `encargado` varchar(45) NOT NULL,
    PRIMARY KEY (`cedula`),
    CONSTRAINT `fkGradoAcademico` FOREIGN KEY (`gradoAcademico`)
        REFERENCES `sigcd`.`GradoAcademico` (`idGradoAcademico`),
	CONSTRAINT `fkEncargado` FOREIGN KEY(`encargado`) REFERENCES `sigcd`.`Solicitante` (`cedula`)
)  ENGINE=INNODB DEFAULT CHARACTER SET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;



-- -----------------------------------------------------
-- Table `sigcd`.`AyudaTemporal`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`AyudaTemporal` (
    `idAyudaTemporal` INT NOT NULL AUTO_INCREMENT,
    `estado` INT NOT NULL,
    `solicitante` varchar(45) NOT NULL,
    `estudiante` varchar(45) not null,
    `motivoAyuda` VARCHAR(500) NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
    `TelefonoCelular` varchar(20) not NULL,
    `TelefonoHabitacion` varchar(20),
    PRIMARY KEY (`idAyudaTemporal`),
    CONSTRAINT `fkSolicitante` FOREIGN KEY (`solicitante`) REFERENCES `sigcd`.`solicitante` (`cedula`),
	constraint `fkEstudiante` foreign key (`estudiante`) references `sigcd`.`estudiante`(`cedula`),
    CONSTRAINT `fkEstadoAY` FOREIGN KEY (`estado`) REFERENCES `sigcd`.`Estado` (`idEstado`)
)  ENGINE=INNODB DEFAULT CHARACTER SET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

-- -----------------------------------------------------
-- Table `sigcd`.`BecaMunicipal`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `sigcd`.`BecaMunicipal` (
    `idBecaMunicipal` INT NOT NULL AUTO_INCREMENT,
    `estado` INT NOT NULL,
    `fechaCreacion` TIMESTAMP NOT NULL,
	`TelefonoCelular` varchar(20) not NULL,
    `TelefonoHabitacion` varchar(20),
    PRIMARY KEY (`idBecaMunicipal`),
    CONSTRAINT `fkEstadoBM` FOREIGN KEY (`estado`)
        REFERENCES `sigcd`.`Estado` (`idEstado`)
)  ENGINE=INNODB DEFAULT CHARACTER SET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

INSERT INTO estado VALUES(1);
INSERT INTO estado VALUES(2);
INSERT INTO estado VALUES(3);

INSERT INTO gradoAcademico values(1);
INSERT INTO gradoAcademico values(2);
INSERT INTO gradoAcademico values(3);
INSERT INTO gradoAcademico values(4);
INSERT INTO gradoAcademico values(5);
INSERT INTO gradoAcademico values(6);
INSERT INTO gradoAcademico values(7);
INSERT INTO gradoAcademico values(8);
INSERT INTO gradoAcademico values(9);
INSERT INTO gradoAcademico values(10);
INSERT INTO gradoAcademico values(11);
INSERT INTO gradoAcademico values(12);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;