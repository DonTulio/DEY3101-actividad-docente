-- MySQL Script generated by MySQL Workbench
-- Fri Jun 26 13:50:49 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema respaldo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema respaldo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `respaldo` DEFAULT CHARACTER SET utf8 ;
USE `respaldo` ;

-- -----------------------------------------------------
-- Table `respaldo`.`section`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `respaldo`.`section` (
  `idSection` INT NOT NULL AUTO_INCREMENT,
  `nameSection` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL DEFAULT '0',
  PRIMARY KEY (`idSection`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `respaldo`.`mark`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `respaldo`.`mark` (
  `idMark` INT NOT NULL AUTO_INCREMENT,
  `idSection` INT NOT NULL,
  `rutStudent` VARCHAR(9) NOT NULL,
  `mark` DECIMAL(2,1) NOT NULL,
  `newMark` DECIMAL(2,1) NOT NULL DEFAULT '1.0',
  PRIMARY KEY (`idMark`),
  INDEX `fk_mark_section_idx` (`idSection` ASC),
  CONSTRAINT `fk_mark_section`
    FOREIGN KEY (`idSection`)
    REFERENCES `respaldo`.`section` (`idSection`))
ENGINE = InnoDB
AUTO_INCREMENT = 190
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
