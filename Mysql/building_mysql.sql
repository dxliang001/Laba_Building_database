-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema laba_test
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `laba_test` DEFAULT CHARACTER SET latin1 ;
USE `laba_test` ;

-- -----------------------------------------------------
-- Table `laba_test`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laba_test`.`clients` (
  `client_id` INT(11) NOT NULL,
  `client_name` VARCHAR(100) NOT NULL,
  `contact_name` VARCHAR(100) NULL DEFAULT NULL,
  `client_address` VARCHAR(255) NULL DEFAULT NULL,
  `client_email` VARCHAR(100) NULL DEFAULT NULL,
  `client_phone` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `laba_test`.`departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laba_test`.`departments` (
  `department_id` INT(11) NOT NULL,
  `department_name` VARCHAR(50) NOT NULL,
  `department_description` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`department_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `laba_test`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laba_test`.`roles` (
  `role_id` INT(11) NOT NULL,
  `role_name` VARCHAR(50) NOT NULL,
  `role_description` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `laba_test`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laba_test`.`employees` (
  `emp_id` INT(11) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `role_id` INT(11) NULL DEFAULT NULL,
  `department_id` INT(11) NULL DEFAULT NULL,
  `hire_date` DATE NOT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `phone_number` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  INDEX `role_id_idx` (`role_id` ASC) VISIBLE,
  INDEX `department_id_idx` (`department_id` ASC) VISIBLE,
  CONSTRAINT `role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `laba_test`.`roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `department_id`
    FOREIGN KEY (`department_id`)
    REFERENCES `laba_test`.`departments` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `laba_test`.`projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laba_test`.`projects` (
  `project_id` INT(11) NOT NULL,
  `project_name` VARCHAR(100) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL DEFAULT NULL,
  `client_id` INT(11) NULL DEFAULT NULL,
  `project_status` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`project_id`),
  INDEX `client_id_idx` (`client_id` ASC) VISIBLE,
  CONSTRAINT `client_id`
    FOREIGN KEY (`client_id`)
    REFERENCES `laba_test`.`clients` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `laba_test`.`expenses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laba_test`.`expenses` (
  `expense_id` INT(11) NOT NULL,
  `project_id` INT(11) NULL DEFAULT NULL,
  `amount` DECIMAL(10,2) NOT NULL,
  `expense_date` DATE NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`expense_id`),
  INDEX `project_id_idx` (`project_id` ASC) VISIBLE,
  CONSTRAINT `project_id`
    FOREIGN KEY (`project_id`)
    REFERENCES `laba_test`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `laba_test`.`suppliers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laba_test`.`suppliers` (
  `supplier_id` INT(11) NOT NULL,
  `supplier_name` VARCHAR(100) NOT NULL,
  `supplier_address` VARCHAR(255) NULL DEFAULT NULL,
  `supplier_email` VARCHAR(100) NULL DEFAULT NULL,
  `supplier_phone` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`supplier_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `laba_test`.`materials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laba_test`.`materials` (
  `material_id` INT(11) NOT NULL,
  `material_name` VARCHAR(100) NOT NULL,
  `material_description` TEXT NULL DEFAULT NULL,
  `supplier_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`material_id`),
  INDEX `supplier_id_idx` (`supplier_id` ASC) VISIBLE,
  CONSTRAINT `supplier_id`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `laba_test`.`suppliers` (`supplier_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `laba_test`.`inventory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laba_test`.`inventory` (
  `inventory_id` INT(11) NOT NULL,
  `material_id` INT(11) NULL DEFAULT NULL,
  `quantity_on_hand` INT(11) NOT NULL,
  PRIMARY KEY (`inventory_id`),
  INDEX `material_id_idx` (`material_id` ASC) VISIBLE,
  CONSTRAINT `material_id`
    FOREIGN KEY (`material_id`)
    REFERENCES `laba_test`.`materials` (`material_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `laba_test`.`payments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laba_test`.`payments` (
  `payment_id` INT(11) NOT NULL,
  `client_id` INT(11) NULL DEFAULT NULL,
  `project_id` INT(11) NULL DEFAULT NULL,
  `amount` DECIMAL(10,2) NOT NULL,
  `payment_date` DATE NOT NULL,
  `payment_method` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  INDEX `client_id_idx` (`client_id` ASC) VISIBLE,
  INDEX `project_id_idx` (`project_id` ASC) VISIBLE,
  CONSTRAINT `payments_client_id_fk`
    FOREIGN KEY (`client_id`)
    REFERENCES `laba_test`.`clients` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `payments_project_id_fk`
    FOREIGN KEY (`project_id`)
    REFERENCES `laba_test`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `laba_test`.`invoices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laba_test`.`invoices` (
  `invoice_id` INT(11) NOT NULL,
  `client_id` INT(11) NULL DEFAULT NULL,
  `project_id` INT(11) NULL DEFAULT NULL,
  `issue_date` DATE NOT NULL,
  `due_date` DATE NOT NULL,
  `total_amount` DECIMAL(10,2) NOT NULL,
  `payment_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`invoice_id`),
  INDEX `client_id_idx` (`client_id` ASC) VISIBLE,
  INDEX `project_id_idx` (`project_id` ASC) VISIBLE,
  INDEX `payment_id_idx` (`payment_id` ASC) VISIBLE,
  CONSTRAINT `invoices_client_id`
    FOREIGN KEY (`client_id`)
    REFERENCES `laba_test`.`clients` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `invoices_project_id`
    FOREIGN KEY (`project_id`)
    REFERENCES `laba_test`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `invocies_payment_id`
    FOREIGN KEY (`payment_id`)
    REFERENCES `laba_test`.`payments` (`payment_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `laba_test`.`projectemployees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laba_test`.`projectemployees` (
  `project_id` INT(11) NULL DEFAULT NULL,
  `emp_id` INT(11) NULL DEFAULT NULL,
  INDEX `emp_id_idx` (`project_id` ASC) VISIBLE,
  CONSTRAINT `project_emp_id`
    FOREIGN KEY (`project_id`)
    REFERENCES `laba_test`.`employees` (`emp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `project_project_id`
    FOREIGN KEY (`project_id`)
    REFERENCES `laba_test`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `laba_test`.`projectmaterials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laba_test`.`projectmaterials` (
  `project_id` INT(11) NULL DEFAULT NULL,
  `material_id` INT(11) NULL DEFAULT NULL,
  `quantity_required` INT(11) NOT NULL,
  INDEX `project_id_idx` (`project_id` ASC) VISIBLE,
  INDEX `material_id_idx` (`material_id` ASC) VISIBLE,
  CONSTRAINT `masterials_project_id`
    FOREIGN KEY (`project_id`)
    REFERENCES `laba_test`.`projects` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `masterials_projectmaterialsmaterial_id`
    FOREIGN KEY (`material_id`)
    REFERENCES `laba_test`.`materials` (`material_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
