USE urna_eleitoral;

CREATE TABLE dados 
(
  ID INT(255) NOT NULL,
  Nome VARCHAR(60) NOT NULL,
  Cargo VARCHAR(20) NOT NULL,
  Numero INT(6) NOT NULL,
  Partido VARCHAR(20) NOT NULL,
  Preferencia VARCHAR(4) NOT NULL
);
DROP TABLE dados;
SELECT * FROM dados;

/*Inserindo os Candidatos   */                                                                                     
INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (17,"Bolsonaro","Presidente",17,"PSL","Sim");
INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (13,"Haddad","Presidente",13,"PT","Não");
INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (12,"Ciro Gomes","Presidente",12,"PDT","Não");

INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (55100,"Diego","Dep.Estadual",55100,"PSD","Não");
INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (77300,"Marcelinho","Dep.Estadual",77300,"SD","Sim");
INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (22299,"Patricia","Dep.Estadual",22299,"PR","Não");

INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (2244,"Luiz Motta","Dep.Federal",2244,"PR","Sim");
INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (4311,"Dr. Davi","Dep.Federal",4311,"PV","Não");
INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (1777,"Alexandre","Dep.Federal",1777,"PSL","Não");

INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (15,"Paulo Skaf","Governador",15,"MDB","Sim");
INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (45,"João Doria","Governador",45,"PSDB","Não");
INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (40,"Marcio Franca","Governador",40,"PSB","Não");

INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (131,"Eduardo","Senador-1",131,"PT","Sim");
INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (277,"Kaled","Senador-1",277,"DC","Não");
INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (191,"Mario Covas","Senador-1",191,"PODE","Não");

INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (400,"Maurren","Senador-2",400,"PSB","Sim");
INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (177,"Major Olimpio","Senador-2",177,"PSL","Não");
INSERT INTO dados (ID,Nome, Cargo, Numero, Partido, Preferencia) VALUES (450,"Tripoli","Senador-2",450,"PSDB","Não");






