-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`est_establishments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`est_establishments` (
  `est_id` BIGINT NOT NULL,
  `est_name` VARCHAR(50) NOT NULL,
  `est_cnpj` VARCHAR(14) NOT NULL,
  `est_country` VARCHAR(50) NOT NULL,
  `est_state` VARCHAR(50) NOT NULL,
  `est_city` VARCHAR(50) NOT NULL,
  `est_district` VARCHAR(50) NOT NULL,
  `est_number` INT NULL,
  `est_description` VARCHAR(100) NULL,
  `est_stars` DOUBLE NULL,
  PRIMARY KEY (`est_id`),
  UNIQUE INDEX `est_cnpj_UNIQUE` (`est_cnpj` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usr_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usr_users` (
  `usr_user` BIGINT NOT NULL AUTO_INCREMENT,
  `usr_first_name` VARCHAR(25) NOT NULL,
  `usr_last_name` VARCHAR(45) NOT NULL,
  `usr_email` VARCHAR(60) NOT NULL,
  `usr_password` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`usr_user`),
  UNIQUE INDEX `usr_email_UNIQUE` (`usr_email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`rvw_reviews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`rvw_reviews` (
  `rvw_id` BIGINT NOT NULL AUTO_INCREMENT,
  `usr_id` BIGINT NOT NULL,
  `est_id` BIGINT NOT NULL,
  `rvw_stars` DOUBLE NOT NULL,
  `rvw_comment` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`rvw_id`, `usr_id`, `est_id`),
  INDEX `fk_rvw_reviews_usr_users_idx` (`usr_id` ASC),
  INDEX `fk_rvw_reviews_est_establishments1_idx` (`est_id` ASC),
  CONSTRAINT `fk_rvw_reviews_usr_users`
    FOREIGN KEY (`usr_id`)
    REFERENCES `mydb`.`usr_users` (`usr_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rvw_reviews_est_establishments1`
    FOREIGN KEY (`est_id`)
    REFERENCES `mydb`.`est_establishments` (`est_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

