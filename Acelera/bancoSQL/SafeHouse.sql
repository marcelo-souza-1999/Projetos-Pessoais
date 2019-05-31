CREATE DATABASE safehouse;
USE safehouse;

CREATE TABLE usuario
(
    nome VARCHAR(40) NOT NULL,
    caminho_foto VARCHAR(500) NOT NULL,
    tipo VARCHAR(5) NOT NULL,
    email VARCHAR(40) NOT NULL PRIMARY KEY,
    data_cadastro VARCHAR(10) NOT NULL,
    hora_cadastro VARCHAR(10) NOT NULL,
    alarmeNomeCasa VARCHAR(30)
);

CREATE TABLE alarme 
(
  senha VARCHAR(10) NOT NULL,
  estado VARCHAR(7) NOT NULL
);

UPDATE alarme SET estado="Desativado"; 

CREATE TABLE janela 
(
  estado VARCHAR(7) NOT NULL,
  horaAcao VARCHAR(10) NOT NULL,
  dataAcao CHAR(10) NOT NULL,
  hora CHAR(10) NOT NULL
);

CREATE TABLE portao 
(
  estado VARCHAR(7) NOT NULL,
  horaAcao VARCHAR(10) NOT NULL,
  dataAcao CHAR(10) NOT NULL,
  hora CHAR(10) NOT NULL
);

CREATE TABLE registroAlarme 
(
  estado VARCHAR(10) NOT NULL,
  horaAcao VARCHAR(10) NOT NULL,
  dataAcao CHAR(10) NOT NULL,
  diaSemana CHAR(10) NOT NULL
);

-- ALTER TABLE registroAlarme CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;

SELECT * FROM usuario;

SELECT * FROM registroAlarme;

SELECT * FROM registroAlarme ORDER BY dataAcao DESC, horaAcao DESC; 

SELECT horaAcao, MAX(dataAcao) FROM registroAlarme;

SELECT * FROM registroAlarme ORDER BY dataAcao DESDC; 

SELECT senha FROM alarme;

SELECT alarmeNomeCasa FROM usuario WHERE alarmeNomeCasa !='NULL';

SELECT * FROM alarme;

UPDATE registroAlarme SET estado="Desativado" WHERE dataAcao="30/04/2019"; 





SELECT LAST_INSERT_horaAcao();

SELECT MAX(dataAcao) AS teste1 FROM registroAlarme;

SELECT MAX(horaAcao) FROM registroAlarme WHERE dataAcao='30/05/2019';

SELECT estado FROM registroAlarme WHERE horaAcao='15:47:14';

SELECT @maiorData:=MAX(dataAcao) AS teste1 FROM registroAlarme UNION SELECT @maiorHora:=MAX(horaAcao) AS teste2 FROM registroAlarme 
WHERE dataAcao=@maiorData UNION SELECT estado AS teste3 FROM registroAlarme WHERE horaAcao=@maiorHora;






