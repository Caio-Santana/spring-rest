INSERT INTO POLL (POLL_ID, QUESTION) VALUES (1, 'Qual a sua idade?');

INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (1, 1, '0-15');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (2, 1, '16-30');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (3, 1, '31-40');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (4, 1, '41-80');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (5, 1, '80+');

INSERT INTO POLL (POLL_ID, QUESTION) VALUES (2, 'Qual a sua cor favorita?');

INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (6, 2, 'PRETO');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (7, 2, 'AZUL');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (8, 2, 'VERMELHO');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (9, 2, 'VERDE');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (10, 2, 'AMARELO');

INSERT INTO POLL (POLL_ID, QUESTION) VALUES (3, 'Qual a sua estação do ano prefere?');

INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (11, 3, 'VERÃO');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (12, 3, 'PRIMAVERA');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (13, 3, 'OUTONO');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (14, 3, 'INVERNO');

INSERT INTO POLL (POLL_ID, QUESTION) VALUES (4, 'Qual a sua cidade mais gosta?');

INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (15, 4, 'NEW YORK');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (16, 4, 'LONDON');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (17, 4, 'CALIFORNIA');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (18, 4, 'BARCELONA');

INSERT INTO POLL (POLL_ID, QUESTION) VALUES (5, 'Qual comida você escolhe?');

INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (19, 5, 'PIZZA');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (20, 5, 'CHURRASCO');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (21, 5, 'HOTDOG');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (22, 5, 'HAMBURGUER');

INSERT INTO POLL (POLL_ID, QUESTION) VALUES (6, 'Qual sobremesa você prefere?');

INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (23, 6, 'BRIGADEIRO');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (24, 6, 'PUDIM');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (25, 6, 'SORVETE');

INSERT INTO POLL (POLL_ID, QUESTION) VALUES (7, 'Qual sua pretensão salarial?');

INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (26, 7, '1000');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (27, 7, '5000');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (28, 7, '10000');

INSERT INTO POLL (POLL_ID, QUESTION) VALUES (8, 'Qual esporte gosta mais?');

INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (29, 8, 'FUTEBOL');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (30, 8, 'VOLEI');
INSERT INTO "OPTION" (OPTION_ID, POLL_ID, OPTION_VALUE) VALUES (31, 8, 'BASQUETE');

-- Users
--password encrypted with BCrypt
INSERT INTO USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, ADMIN) VALUES (1, 'admin', '$2a$12$R.sL.NIcTHh0T1cu83KH0OMYx7vOu49HL1QRj979O596yjSJCcuNO', 'Super', 'Admin', 'Y');
--pass=Admin

INSERT INTO USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, ADMIN) VALUES (2, 'mickey', '$2a$12$/hoKNUWsnbV1HKcCUfskKOSq9kc4IEv7dwXz6xh6wH856UAqSuRza', 'Mickey', 'Mouse', 'N');
--pass=Cheese

INSERT INTO USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, ADMIN) VALUES (3, 'master', '$2a$12$PMAClWg5i9jFLCEk06Qel.Sr8.WKNoLadxN3HjbVGID6UPMmTlNR.', 'Master', 'Super', 'Y');
--pass=Moo

INSERT INTO USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, ADMIN) VALUES (4, 'mary', '$2a$12$ml4.std7peZPXQdhdA/cs.Ef7tgvDXe8TmtafbByoA21HwAFSC1UW', 'Mary', 'Smith', 'N');
--pass=Red01

INSERT INTO USERS (USER_ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, ADMIN) VALUES (5, 'john', '$2a$12$hLT5ocu.bmDrC8ztifW3aOiM2fyeqtddmbibRVsCvUSQIMdp8/VjO', 'John', 'Doe', 'N');
--pass=Quack


