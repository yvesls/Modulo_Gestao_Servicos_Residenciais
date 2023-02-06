CREATE DATABASE IF NOT EXISTS ManutencaoResidencial;
USE ManutencaoResidencial;

CREATE TABLE IF NOT EXISTS `ManutencaoResidencial`.`Endereco` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `Logradouro` VARCHAR(45) NOT NULL,
  `CEP` INT(8) NOT NULL,
  `Numero` INT NOT NULL,
  `Bairro` VARCHAR(45) NOT NULL,
  `Cidade` VARCHAR(45) NOT NULL,
  `Estado` VARCHAR(45) NOT NULL,
   CONSTRAINT pkEndereco PRIMARY KEY (`idEndereco`, `idCliente`),
   CONSTRAINT fkCliente FOREIGN KEY (`idCliente`)
   REFERENCES `ManutencaoResidencial`.`Cliente`(`idCliente`)
  );

-- -----------------------------------------------------
-- Table `ManutencaoResidencial`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ManutencaoResidencial`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Telefone` INT(11) NOT NULL,
  CONSTRAINT pkPessoa PRIMARY KEY (`idPessoa`)
);


-- -----------------------------------------------------
-- Table `ManutencaoResidencial`.`Prestador de serviço`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ManutencaoResidencial`.`Prestador` (
  `idPrestador` INT NOT NULL UNIQUE AUTO_INCREMENT,
  `CNPJ` INT(14) NOT NULL,
  CONSTRAINT pkPrestador PRIMARY KEY (`idPrestador`),
  CONSTRAINT `fkIdPrestador`
    FOREIGN KEY (`idPrestador`)
    REFERENCES `ManutencaoResidencial`.`Pessoa` (`idPessoa`)
);


-- -----------------------------------------------------
-- Table `ManutencaoResidencial`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ManutencaoResidencial`.`Cliente` (
  `idCliente` INT NOT NULL UNIQUE AUTO_INCREMENT,
  `CPF` INT(11) NOT NULL,
  CONSTRAINT pkCliente PRIMARY KEY (`idCliente`),
  CONSTRAINT `fkIdCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `ManutencaoResidencial`.`Pessoa` (`idPessoa`)
);


-- -----------------------------------------------------
-- Table `ManutencaoResidencial`.`Servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ManutencaoResidencial`.`Servico` (
  `idServico` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(45) NOT NULL,
  `Valor` DOUBLE NOT NULL,
  `IdCliente` INT NOT NULL,
  `IdPrestador` INT NOT NULL,
  `Data` DATE NOT NULL,
  CONSTRAINT pkServicoClientePrestador 
	PRIMARY KEY (`idServico`, `IdCliente`, `IdPrestador`),
  CONSTRAINT `IdCliente`
    FOREIGN KEY (`IdCliente`)
    REFERENCES `ManutencaoResidencial`.`Cliente` (`idCliente`),
  CONSTRAINT `IdPrestador`
    FOREIGN KEY (`IdPrestador`)
    REFERENCES `ManutencaoResidencial`.`Prestador de servico` (`idPrestador`)
);

