CREATE TABLE `departament` (
  `idDepartament` int(11) NOT NULL,
  `DenumireDepartament` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idDepartament`)
)


INSERT INTO `departament` VALUES (10,'Marketing'),(20,'Contabilitate'),(30,'Proiectare'),(40,'Resurse Umane'),(50,'Testare');

--
-- Table structure for table `salariat`
--


CREATE TABLE `salariat` (
  `idSalariat` int(11) NOT NULL,
  `NumeSalariat` varchar(45) NOT NULL,
  `DataNstere` date DEFAULT NULL,
  `Salariu` float DEFAULT NULL,
  `Departament_idDepartament` int(11) NOT NULL,
  PRIMARY KEY (`idSalariat`,`Departament_idDepartament`),
  KEY `fk_Salariat_Departament_idx` (`Departament_idDepartament`),
  CONSTRAINT `fk_Salariat_Departament` FOREIGN KEY (`Departament_idDepartament`) REFERENCES `departament` (`idDepartament`) ON DELETE NO ACTION ON UPDATE NO ACTION
) 


INSERT INTO `salariat` VALUES (7369,'Popa Ion','1980-12-07',800,20),(7499,'Tache Ionut','1981-02-20',1450,30),(7521,'Marinescu Mihai','1981-02-22',1250,30),(7566,'Stoica Dan','1981-04-02',2975,50),(7654,'Marinescu Alin','1981-09-28',1250,10),(7698,'Negru Gelu','1981-04-01',2850,10),(7782,'Avram Calin','1987-05-23',2450,20),(7788,'Savescu Ovidiu','1981-06-09',3000,40),(7839,'Costescu George','1981-10-08',5000,40),(7844,'Tanase Dorel','1982-01-01',1500,10),(7876,'Adam Sorin','1989-04-21',1100,20),(7900,'Ionescu Victoria','1981-11-15',950,30),(7902,'Florescu Aurel','1988-03-10',3000,50),(7934,'Milescu Silvia','1971-12-31',1300,10);

