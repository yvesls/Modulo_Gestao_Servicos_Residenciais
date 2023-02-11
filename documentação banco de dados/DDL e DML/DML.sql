
USE ManutencaoResidencial;
INSERT INTO `pessoa` (`nome`,`telefone`)
VALUES
  ("Castor Gamble","(868) 192-7161"),
  ("Dennis Blevins","1-376-582-7274"),
  ("Yoshio Huff","(777) 694-0722"),
  ("Sopoline Kinney","(761) 542-8027"),
  ("Justin Best","1-271-417-6113"),
  ("Amanda Buchanan","(432) 866-8861"),
  ("Jordan Wells","(819) 183-7327"),
  ("Aphrodite Mejia","(787) 158-6141"),
  ("Daquan Joseph","(334) 256-9858"),
  ("Ingrid Gordon","(448) 507-2422");
INSERT INTO `pessoa` (`nome`,`telefone`)
VALUES
  ("Keegan Lang","(131) 987-9949"),
  ("Freya Johnson","(431) 217-2631"),
  ("Joan Poole","1-423-988-8427"),
  ("Cathleen Maddox","1-265-783-1597"),
  ("Imelda Booth","(710) 436-8732"),
  ("Matthew Leon","1-885-727-3878"),
  ("Quemby Yang","(162) 453-8144"),
  ("Abdul Britt","1-224-407-1086"),
  ("Jarrod Patel","(513) 232-1185"),
  ("Shelley Velazquez","(784) 200-7288");
INSERT INTO `pessoa` (`nome`,`telefone`)
VALUES
  ("Jade Alston","1-369-858-1297"),
  ("Charles Lindsay","1-392-571-7855"),
  ("Kai Buck","1-317-633-2248"),
  ("Deirdre Oneal","(522) 867-5754"),
  ("Genevieve Britt","1-185-577-4280"),
  ("Macey Chavez","(611) 420-2451"),
  ("Quemby Best","(463) 245-2885"),
  ("Harding Gamble","1-526-428-4259"),
  ("Olympia Pace","1-566-661-8011"),
  ("Lani Tran","1-767-824-2616");
INSERT INTO `pessoa` (`nome`,`telefone`)
VALUES
  ("Victoria Neal","(206) 895-6314"),
  ("Aurelia Goodman","(757) 432-3151"),
  ("Nevada Monroe","(213) 711-9017"),
  ("Kibo Eaton","(263) 972-6926"),
  ("Bell Collier","(219) 830-2861"),
  ("Ira Wynn","(427) 345-6273"),
  ("Chiquita Leon","(244) 869-7627"),
  ("Dana Leonard","1-718-266-7142"),
  ("Ivor Joyce","(857) 233-4611"),
  ("Whilemina Glass","1-483-573-6338");
INSERT INTO `pessoa` (`nome`,`telefone`)
VALUES
  ("Gareth Slater","(885) 537-0966"),
  ("Norman Atkinson","1-748-767-8217"),
  ("Stephanie Curtis","(535) 226-7394"),
  ("Carson Wyatt","(890) 926-4143"),
  ("James Gentry","1-970-765-0508"),
  ("Barclay Welch","(623) 121-5681"),
  ("Gray Matthews","(231) 222-8024"),
  ("Malachi Armstrong","1-657-673-5503"),
  ("Carolyn Cohen","(561) 241-2753"),
  ("Galena Ferguson","1-330-267-5687");
INSERT INTO `pessoa` (`nome`,`telefone`)
VALUES
  ("Buckminster Myers","1-828-996-5780"),
  ("Quintessa Todd","(380) 598-2429"),
  ("Alden Franks","(713) 732-8553"),
  ("Lionel Horton","(286) 128-3218"),
  ("Whitney Avila","1-823-774-7684"),
  ("Latifah Shaffer","1-707-217-5019"),
  ("Patrick Battle","1-586-189-8378"),
  ("Philip Reese","(774) 896-7767"),
  ("Jaden Riggs","1-355-962-7667"),
  ("Alec Camacho","1-814-857-6855");
  
INSERT INTO `cliente` (`idCliente`,`cpf`)
VALUES
  (1,"17651038436"),
  (2,"27265534433"),
  (3,"93951033290"),
  (4,"15182944993"),
  (5,"80828579784"),
  (6,"61119870038"),
  (7,"15402622604"),
  (8,"31802053697"),
  (9,"63739556218"),
  (10,"59812488820"),
  (11,"81136287469"),
  (12,"87649535487"),
  (13,"48276215947"),
  (14,"71152456652"),
  (15,"57561462450"),
  (16,"33301129218"),
  (17,"51934873942"),
  (18,"48813697171"),
  (19,"37220456301"),
  (20,"20546564534"),
  (21,"23607031703"),
  (22,"97126826761"),
  (23,"59240574883"),
  (24,"70288787757"),
  (25,"31377323870"),
  (26,"28776233863"),
  (27,"60242944507"),
  (28,"89282281744"),
  (29,"37285685542"),
  (30,"24185328362");
  
  
  
  INSERT INTO `prestador` (`idPrestador`,`cnpj`)
VALUES
  (31,"02.383.270/0001-54"),
  (32,"18.223.960/0001-86"),
  (33,"88.044.978/0001-04"),
  (34,"61.219.207/0001-46"),
  (35,"25.002.882/0001-55"),
  (36,"74.374.950/0001-12"),
  (37,"77.205.248/0001-13"),
  (38,"27.218.714/0001-27"),
  (39,"08.459.336/0001-29"),
  (40,"75.413.850/0001-10"),
  (41,"56.999.224/0001-03"),
  (42,"86.754.157/0001-28"),
  (43,"59.626.902/0001-80"),
  (44,"55.940.142/0001-20"),
  (45,"45.467.625/0001-04"),
  (46,"43.548.531/0001-26"),
  (47,"45.579.354/0001-70"),
  (48,"31.682.334/0001-16"),
  (49,"08.945.537/0001-36"),
  (50,"11.584.800/0001-13"),
  (51,"89.101.736/0001-60"),
  (52,"09.551.164/0001-81"),
  (53,"76.457.368/0001-45"),
  (54,"97.638.823/0001-89"),
  (55,"64.614.466/0001-60"),
  (56,"35.666.930/0001-63"),
  (57,"85.488.277/0001-68"),
  (58,"99.072.210/0001-52"),
  (59,"40.403.133/0001-23"),
  (60,"23.517.192/0001-03");
  
  insert into `servico`(`Descricao`, `Valor`, `IdCliente`, `IdPrestador`, `Data`) 
  values
  ("Limpeza de jardins",123.45,1,60,"01/05/2022 10:20:30"),
  ("Lavagem de janelas",234.56,2,59,"15/06/2022 11:22:33"),
  ("Reparos elétricos",345.67,3,58,"18/08/2022 12:25:36"),
  ("Instalação de ar condicionado",400.12,4,57,"20/09/2022 13:28:39"),
  ("Pintura de paredes",300.98,5,56,"25/10/2022 14:31:42"),
  ("Conserto de encanamentos",175.45,6,55,"30/11/2022 15:34:45"),
  ("Instalação de iluminação",140.56,7,54,"10/12/2022 16:37:48"),
  ("Limpeza de piscinas",231.67,8,53,"05/01/2023 17:40:51"),
  ("Reparos de telhados",400.12,9,52,"12/02/2023 18:43:54"),
  ("Instalação de alarme",350.98,10,51,"15/03/2023 19:46:57"),
  ("Jardinagem",275.45,11,50,"18/04/2023 20:50:00"),
  ("Reparos de aquecimento",320.56,12,49,"22/05/2023 21:53:03"),
  ("Instalação de cozinhas",233.67,13,48,"25/06/2023 22:56:06"),
  ("Limpeza de chaminés",430.12,14,47,"28/07/2023 23:59:09"),
  ("Reparos de estrutura",342.98,15,46,"01/09/2023 00:02:12"),
  ("Instalação de sistemas de água",155.45,16,45,"04/10/2023 01:05:15"),
  ("Limpeza de carpetes",124.56,17,44,"07/11/2023 02:08:18"),
  ("Reparos de telas de proteção",333.67,18,43,"10/12/2023 03:11:21"),
  ("Instalação de sistemas de segurança",409.12,19,42,"13/01/2023 04:14:24"),
  ("Limpeza de pisos",302.98,20,41,"16/02/2023 05:17:27"),
  ("Reparos de cercas",259.45,21,40,"19/03/2023 06:20:30"),
  ("Instalação de móveis",315.56,22,39,"22/04/2023 07:23:33"),
  ("Limpeza de têxteis",356.67,23,38,"25/05/2023 08:26:36"),
  ("Reparos de portões",450.00,24,37,"28/06/2023 09:29:39"),
  ("Instalação de sistemas de som",123.67,25,36,"04/09/2023 11:35:45"),
  ("Limpeza de estofados",235.98,26,35,"01/08/2023 10:32:42"),
  ("Reparos de vidros",175.12,27,34,"07/10/2023 12:38:48"),
  ("Instalação de sistemas de climatização",405.45,28,33,"10/11/2023 13:41:51"),
  ("Limpeza de ladrilhos",389.56,29,32,"13/12/2023 14:44:54"),
  ("Reparos de pisos flutuantes",324.67,30,31,"16/01/2023 15:47:57");
  
  
INSERT INTO `Endereco` (IdCliente, Logradouro, CEP, Numero, Bairro, Cidade, Estado) 
VALUES (1,'Rua dos Pássaros', '11111111', 100, 'Jardim América', 'São Paulo', 'SP');

INSERT INTO `Endereco` (IdCliente, Logradouro, CEP, Numero, Bairro, Cidade, Estado) 
VALUES (2,'Avenida das Flores', '22222222', 200, 'Bela Vista', 'Rio de Janeiro', 'RJ');

INSERT INTO `Endereco`  (IdCliente, Logradouro, CEP, Numero, Bairro, Cidade, Estado) 
VALUES (3,'Rua do Sol', '33333333', 300, 'Vila Mariana', 'Belo Horizonte', 'MG');

INSERT INTO `Endereco`  (IdCliente, Logradouro, CEP, Numero, Bairro, Cidade, Estado) 
VALUES (4,'Avenida dos Jardins', '44444444', 400, 'Moema', 'São Paulo', 'SP');

INSERT INTO `Endereco`  (IdCliente,Logradouro, CEP, Numero, Bairro, Cidade, Estado) 
VALUES (5,'Rua da Lua', '55555555', 500, 'Copacabana', 'Rio de Janeiro', 'RJ');

INSERT INTO `Endereco`  (IdCliente, Logradouro, CEP, Numero, Bairro, Cidade, Estado) 
VALUES (6,'Avenida das Estrelas', '66666666', 600, 'Lapa', 'Rio de Janeiro', 'RJ');

INSERT INTO `Endereco`  (IdCliente, Logradouro, CEP, Numero, Bairro, Cidade, Estado) 
VALUES (7,'Rua das Árvores', '77777777', 700, 'Jardim Botânico', 'Rio de Janeiro', 'RJ');

INSERT INTO `Endereco`  (IdCliente,Logradouro, CEP, Numero, Bairro, Cidade, Estado) 
VALUES (8,'Avenida dos Anjos', '88888888', 800, 'Barra da Tijuca', 'Rio de Janeiro', 'RJ');

INSERT INTO `Endereco`  (IdCliente,Logradouro, CEP, Numero, Bairro, Cidade, Estado) 
VALUES (9,'Rua das Flores', '99999999', 900, 'Santa Teresa', 'Rio de Janeiro', 'RJ');

INSERT INTO `Endereco`  (IdCliente,Logradouro, CEP, Numero, Bairro, Cidade, Estado) 
VALUES (10,'Avenida das Águas', '12345678', 1000, 'Leblon', 'Rio de Janeiro', 'RJ');

INSERT INTO `Endereco`  (IdCliente,Logradouro, CEP, Numero, Bairro, Cidade, Estado) 
values
(11,'Rua dos Coqueiros', '33333333', 40, 'Praia do Sol', 'Rio de Janeiro', 'RJ'),
(12,'Avenida das Águas', '44444444', 50, 'Parque das Cachoeiras', 'Belo Horizonte', 'MG'),
(13,'Rua das Estrelas', '55555555', 60, 'Jardim Celestial', 'Porto Alegre', 'RS'),
(14,'Avenida das Flores', '66666666', 70, 'Jardim das Abelhas', 'Curitiba', 'PR'),
(15,'Rua dos Anjos', '77777777', 80, 'Praça das Almas', 'Recife', 'PE'),
(16,'Avenida das Aves', '88888888', 90, 'Parque dos Pássaros', 'Salvador', 'BA'),
(17,'Rua das Montanhas', '99999999', 100, 'Vale das Nuvens', 'Brasília', 'DF'),
(18,'Avenida das Árvores', '10000000', 110, 'Floresta das Almas', 'Fortaleza', 'CE'),
(19,'Rua dos Rios', '11000111', 120, 'Vale das Águas', 'Goiânia', 'GO'),
(20,'Avenida dos Ventos', '12000222', 130, 'Colina dos Ventos', 'Belém', 'PA'),
(21,"Rua das Flores", "12345678", "1", "Centro", "São Paulo", "SP"),
(22,"Avenida Paulista", "23456789", "2", "Bela Vista", "São Paulo", "SP"),
(23,"Rua dos Pássaros", "34567890", "3", "Jardins", "São Paulo", "SP"),
(24,"Rua das Rosas", "45678901", "4", "Moema", "São Paulo", "SP"),
(25,"Avenida Brasil", "56789012", "5", "Itaim Bibi", "São Paulo", "SP"),
(26,"Rua das Arvores", "67890123", "6", "Pinheiros", "São Paulo", "SP"),
(27,"Rua dos Jardins", "78901234", "7", "Morumbi", "São Paulo", "SP"),
(28,"Avenida 9 de Julho", "89012345", "8", "Vila Mariana", "São Paulo", "SP"),
(29,"Rua das Estrelas", "90123456", "9", "Consolação", "São Paulo", "SP"),
(30,"Rua dos Pássaros", "34567890", "3", "Jardins", "São Paulo", "SP");
  
  

  				
				
