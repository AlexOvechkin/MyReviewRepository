-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mr-myreview
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mr-myreview
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mr-myreview` DEFAULT CHARACTER SET utf8 ;
USE `mr-myreview` ;

-- -----------------------------------------------------
-- Table `mr-myreview`.`est_establishment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mr-myreview`.`est_establishment` (
  `est_id` INT(11) NOT NULL AUTO_INCREMENT,
  `est_name` VARCHAR(50) NOT NULL,
  `est_cnpj` INT(14) NOT NULL,
  `est_description` VARCHAR(300) NULL DEFAULT NULL,
  `est_stars` DOUBLE NOT NULL,
  `est_country` VARCHAR(100) NOT NULL,
  `est_state` VARCHAR(100) NOT NULL,
  `est_city` VARCHAR(100) NOT NULL,
  `est_district` VARCHAR(100) NOT NULL,
  `est_number` INT NOT NULL,
  PRIMARY KEY (`est_id`),
  UNIQUE INDEX `est_name_UNIQUE` (`est_name` ASC) VISIBLE,
  UNIQUE INDEX `est_cnpj_UNIQUE` (`est_cnpj` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mr-myreview`.`usr_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mr-myreview`.`usr_user` (
  `usr_id` INT(11) NOT NULL AUTO_INCREMENT,
  `usr_firstname` VARCHAR(70) NOT NULL,
  `usr_lastname` VARCHAR(100) NOT NULL,
  `usr_email` VARCHAR(60) NOT NULL,
  `usr_password` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`usr_id`),
  UNIQUE INDEX `usr_email_UNIQUE` (`usr_email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mr-myreview`.`rvw_review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mr-myreview`.`rvw_review` (
  `rvw_id` INT(11) NOT NULL AUTO_INCREMENT,
  `usr_id` INT(11) NOT NULL,
  `est_id` INT(11) NOT NULL,
  `rvw_comment` VARCHAR(300) NOT NULL,
  `rvw_stars` DOUBLE NOT NULL,
  PRIMARY KEY (`rvw_id`),
  INDEX `fk_review_user_idx` (`usr_id` ASC) VISIBLE,
  INDEX `fk_review_establishment1_idx` (`est_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_establishment1`
    FOREIGN KEY (`est_id`)
    REFERENCES `mr-myreview`.`est_establishment` (`est_id`),
  CONSTRAINT `fk_review_user`
    FOREIGN KEY (`usr_id`)
    REFERENCES `mr-myreview`.`usr_user` (`usr_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
