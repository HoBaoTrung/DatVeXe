drop database if exists dat_ve_xe_khach;
create database dat_ve_xe_khach;
use dat_ve_xe_khach;

create table role(
id int primary key,
user_role varchar(7)
);
insert into role values
(1,'USER'),(2,'ADMIN'),(3,'STAFF');

create table user(
 `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(254) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `phonenumber` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  KEY `fk_user_role_id` (`role_id`),
  CONSTRAINT `fk_user_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)

);
INSERT INTO `user` (`username`, `password`, `first_name`, `last_name`, `email`, `address`, `phonenumber`, `avatar`, `created_at`, `is_active`, `role_id`)
VALUES 
('nicholasharrington', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Patricia', 'Navarro', 'fernandolee@example.net', '123 Main St', '3714533435', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('allisonpeterson', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Christine', 'Collins', 'taylorclark@example.org', '456 Elm St', '0019913760', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('jonathanalvarez', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Jessica', 'Miller', 'kevin53@example.com', '789 Oak St', '8762074072', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('jeffrey59', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Jessica', 'Day', 'cantubob@example.com', '159 Maple St', '5475408441', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('uharris', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Sarah', 'Matthews', 'kylekim@example.org', '753 Birch St', '7502723249', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('amanda88', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Julie', 'Craig', 'eschmidt@example.net', '852 Cedar St', '4746573145', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('esmith', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Jeff', 'Jackson', 'matthew95@example.net', '951 Pine St', '7587846551', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('gillespiekendra', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Michael', 'Cochran', 'justin87@example.com', '357 Willow St', '0014065655', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3), 
('nguyensusan', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Julia', 'Johnson', 'matthew57@example.com', '258 Spruce St', '8166283812', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('csmith', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Brian', 'Martinez', 'shannon64@example.net', '753 Maple St', '8457850892', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 1), 
('jenniferhartman', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Courtney', 'Nguyen', 'powersthomas@example.org', '456 Oak St', '7608730575', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('christensenkellie', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Jason', 'Sandoval', 'gardnernicole@example.com', '654 Birch St', '7347941193', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3), 
('stuartwilliams', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Adam', 'Burch', 'eric54@example.org', '753 Elm St', '6107361177', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3), 
('jasonrivera', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'David', 'Rogers', 'xdiaz@example.org', '753 Oak St', '4522017307', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3), 
('cummingscharles', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Clinton', 'Smith', 'fosterlisa@example.com', '753 Spruce St', '3293494623', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('wshaw', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'David', 'Bell', 'clarkalexander@example.org', '123 Maple St', '5214078636', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('robinsonrichard', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Alicia', 'Fisher', 'amyers@example.net', '456 Elm St', '7988523710', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('margaret98', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Brad', 'Mora', 'vwashington@example.com', '789 Pine St', '5943036091', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('susan98', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Stephanie', 'Gilbert', 'baileybarbara@example.com', '321 Cedar St', '5859653941', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('duarteapril', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Andrew', 'Anderson', 'rickymcmahon@example.net', '654 Birch St', '9282551392', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('rross', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Jacob', 'Parks', 'sheenaharris@example.com', '987 Willow St', '5508750827', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('mmorales', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Jacob', 'Black', 'anthonybowman@example.net', '678 Maple St', '9498662885', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('qperez', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Carly', 'Stephenson', 'kristen14@example.org', '123 Oak St', '7406342442', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('jasonhayes', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Sarah', 'Long', 'goldenlori@example.net', '234 Pine St', '9662335026', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('peggywright', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Laura', 'Adkins', 'aharrison@example.com', '567 Cedar St', '3384192244', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('brittany50', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Alyssa', 'Nixon', 'whitekyle@example.com', '432 Elm St', '5339798580', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('lisa46', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Kyle', 'Hudson', 'jacobsmith@example.net', '987 Maple St', '9879765810', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 1),
('emma19', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Sarah', 'Adkins', 'tammy31@example.org', '654 Oak St', '9559172628', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 1),
('billyjones', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Michaela', 'Jones', 'erica12@example.com', '987 Birch St', '6986330154', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('patriciaedwards', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Audrey', 'Clayton', 'angelaguerra@example.com', '987 Elm St', '5017210991', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 1),
('arnoldpatricia', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Phyllis', 'Ruiz', 'vphillips@example.net', '432 Birch St', '7497195125', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('jbradshaw', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Joshua', 'White', 'marie12@example.com', '543 Willow St', '2954866200', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('meganfrancis', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'James', 'Stafford', 'derek10@example.com', '876 Pine St', '7458431024', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('amy15', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Deborah', 'Peterson', 'ernestmcdaniel@example.com', '876 Oak St', '7444275003', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('stevengoodwin', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Stephanie', 'King', 'lynnandrews@example.com', '654 Cedar St', '3775131556', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('christopher60', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Margaret', 'Smith', 'john66@example.com', '789 Birch St', '9517421374', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('bailey72', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Elizabeth', 'Meyer', 'greenchristopher@example.org', '432 Maple St', '7695368834', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('ashleyhill', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Yvonne', 'Bell', 'craig47@example.com', '123 Oak St', '3756304068', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('hartlaura', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Lori', 'Marsh', 'lpowell@example.com', '876 Maple St', '7676792966', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 1),
('wilsonjane', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Tonya', 'Johnson', 'jacob70@example.net', '789 Elm St', '4516558740', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('larmstrong', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Jerry', 'Washington', 'xroach@example.com', '654 Pine St', '7158262334', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('jamierichardson', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Vanessa', 'Hill', 'colemanmatthew@example.com', '432 Maple St', '7723461506', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 1),
('raymondrichards', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Toni', 'Rodriguez', 'powersmelissa@example.org', '987 Oak St', '2025279151', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('michaeldominguez', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Timothy', 'Keller', 'johnny45@example.com', '543 Elm St', '5098105953', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('christopherwatson', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Patrick', 'Pitts', 'vhoward@example.net', '876 Pine St', '5975875869', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('tracy27', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'David', 'Miller', 'tjackson@example.net', '654 Cedar St', '2295626409', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 2),
('vrowland', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Kenneth', 'Jenkins', 'kimshawn@example.com', '123 Maple St', '6096362612', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('gregorysims', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Samantha', 'Mcclain', 'hughesrachel@example.com', '876 Elm St', '9515403974', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('toddsimmons', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Destiny', 'Foster', 'obrientyler@example.com', '987 Oak St', '8982940645', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('unewman', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Ryan', 'Castaneda', 'shellyrodriguez@example.net', '654 Birch St', '5506808625', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 1),
('teresa62', '$2a$10$71E6n4s9RYAH/VamU.fJgO0czyA4.Z8X2gTrIHw4JBBCXqFsR3OBm', 'Melody', 'Singh', 'qhuffman@example.org', '789 Oak St', '7632653958', 'https://cdn.dribbble.com/users/3367729/screenshots/6393911/db_minon.jpg?resize=400x300&vertical=center', '2024-04-16 21:51:04.695947', 1, 3),
('admin', '$2a$10$W5ahQHTwloyerl1HM0FHCetpzVQMzCDYF299FJ7thUpdFOftFqESi', '', '', 'admin@example.com', '753 Birch St', NULL, NULL, '2024-04-16 21:51:04.695947', 1, 2);

create table `otp`(
`id` bigint primary key NOT NULL AUTO_INCREMENT,
`code` varchar(20),
`userID` bigint, FOREIGN KEY (`userID` ) references `user`(`id`)
);

CREATE TABLE `types_seat`(
`id` bigint primary key NOT NULL AUTO_INCREMENT,
`name` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
);
INSERT INTO `types_seat` (`name`) VALUES
('Nằm'),('Ngồi');

CREATE TABLE `types`(
`id` bigint primary key NOT NULL AUTO_INCREMENT,
`name` varchar(255)  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL, 
`quantity` int not null
);
INSERT INTO `types` (`name`, `quantity`) 
VALUES ('Xe 12 chỗ',12),
('Xe 7 chỗ',7),
('Xe 45 chỗ',45);

CREATE TABLE `car` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `car_number` varchar(10) NOT NULL,
  `seat_price` double ,
  `type_id` bigint not null,
  `type_seat_id` bigint not null, foreign key(`type_seat_id`) references  `types_seat`(`id`),
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`type_id` ) references `types`(`id`)
);
INSERT INTO `car` (`car_number`, `type_id`,`seat_price`, `type_seat_id`,`image`) VALUES 
('000091',1, 70000,2,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRjfg22SAlVZ5dJvvvRuJjvTmPYeCqGHzFTw&s'),
('000245',2,80000,2,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTye7hps-5C-fcc-GpAlcyCT-cLt95r06y00A&s'),
('000165',3,60000,1,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNiwbm5bYpalMRR6DF9aCrwT2Xj-n3NTRZVA&s');

CREATE TABLE `seat` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `car_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_car_seat` (`code`,`car_id`),
  KEY `fk_seat_of_car` (`car_id`),
  CONSTRAINT `fk_seat_of_car` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
);
INSERT INTO `seat`(`code`,`car_id`) VALUES ('A-1',1),('A-2',1),('A-3',1),('A-4',1),('A-5',1),('A-6',1),('A-7',1),('A-8',1),('A-9',1),
('A-10',1),('A-11',1),('A-12',1),
('A-1',2),('A-2',2),('A-3',2),('A-4',2),('A-5',2),('A-6',2),('A-7',2),
('A-1',3),('A-2',3),('A-3',3),('A-4',3),('A-5',3),('A-6',3),('A-7',3),('A-8',3),('A-9',3),('A-10',3),('A-11',3),('A-12',3),('A-13',3),('A-14',3),
('A-15',3),('A-16',3),('A-17',3),('A-18',3),('A-19',3),('A-20',3),('A-21',3),('A-22',3),('A-23',3),('A-24',3),('A-25',3),('A-26',3),('A-27',3),('A-28',3),
('A-29',3),('A-30',3),('A-31',3),('A-32',3),('A-33',3),('A-34',3),('A-35',3),('A-36',3),('A-37',3),('A-38',3),('A-39',3),('A-40',3),('A-41',3),('A-42',3),
('A-43',3),('A-44',3),('A-45',3);

drop table if exists `station`; 
CREATE TABLE `station`(
 `id` bigint primary key NOT NULL AUTO_INCREMENT,
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
UNIQUE KEY `name` (`name`)
);
INSERT INTO `station` (`name`) VALUES ('Nhà Bè'), ('Quận 3'),('Quận 4'), ('Quận 5'),
	('An Giang'),
	('Bà rịa Vũng Tàu'),
	('Bạc Liêu'),
	('Bắc Giang'),
	('Bắc Kạn'),
	('Bắc Ninh'),
	('Bến Tre'),
	('Bình Dương'),
	('Bình Định'),
	('Bình Phước'),
	('Bình Thuận'),
	('Cà Mau'),
	('Cao Bằng'),
	('Cần Thơ'),
	('Đà Nẵng'),
	('Đắk Lắk'),
	('Đắk Nông'),
	('Điện Biên'),
	('Đồng Nai'),
	('Đồng Tháp'),
	('Gia Lai'),
	('Hà Giang'),
	('Hà Nam'),
	('Hà Nội'),
	('Hà Tĩnh'),
	('Hải Dương'),
	('Hải Phòng'),
	('Hậu Giang'),
	('Hòa Bình'),
	('Hưng Yên'),
	('Khánh Hòa'),
	('Kiên Giang'),
	('Kon Tum'),
	('Lai Châu'),
	('Lạng Sơn'),
	('Lào Cai'),
	('Lâm Đồng'),
	('Long An'),
	('Nam Định'),
	('Nghệ An'),
	('Ninh Bình'),
	('Ninh Thuận'),
	('Phú Thọ'),
	('Phú Yên'),
	('Quảng Bình'),
	('Quảng Nam'),
	('Quảng Ngãi'),
	('Quảng Ninh'),
	('Quảng Trị'),
	('Sóc Trăng'),
	('Sơn La'),
	('Tây Ninh'),
	('Thái Bình'),
	('Thái Nguyên'),
	('Thanh Hóa'),
	('Thừa Thiên Huế'),
	('Tiền Giang'),
	('TP Hồ Chí Minh'),
	('Trà Vinh'),
	('Tuyên Quang'),
	('Vĩnh Long'),
	('Vĩnh Phúc'),
	('Yên Bái');



CREATE TABLE `route` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `from_station` bigint DEFAULT NULL,
  `to_station` bigint DEFAULT NULL,
  `route_price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  FOREIGN KEY (`from_station`) REFERENCES `station` (`id`),
  FOREIGN KEY (`to_station`) REFERENCES `station` (`id`)
) ;
INSERT INTO `route` VALUES 
(1,'NB-Q3-8257','2024-05-16 14:51:05.672698',1,2,50000),
(2,'NB-Q3-4067','2024-05-16 14:51:05.675086',1,2,50000),
(3,'NB-Q3-1279','2024-05-16 14:51:05.677094',1,2,80000),
(4,'NB-Q3-2444','2024-05-16 14:51:05.678095',1,2,60000),
(5,'NB-Q3-2145','2024-05-16 14:51:05.679092',1,2,60000),
(6,'NB-Q3-7402','2024-05-16 14:51:05.680091',1,2,60000),
(7,'NB-Q3-5819','2024-05-16 14:51:05.681098',1,2,50000),
(8,'NB-Q3-3550','2024-05-16 14:51:05.682618',1,2,90000),
(9,'NB-Q3-5271','2024-05-16 14:51:05.683624',1,2,80000),
(10,'NB-Q3-9606','2024-05-16 14:51:05.684623',1,2,50000),
(11,'NB-Q3-8091','2024-05-16 14:51:05.685637',1,2,90000),
(12,'NB-Q3-9660','2024-05-16 14:51:05.686645',1,2,50000),
(13,'NB-Q3-8512','2024-05-16 14:51:05.688643',1,2,60000),
(14,'NB-Q3-5204','2024-05-16 14:51:05.689645',1,2,60000),
(15,'NB-Q3-3881','2024-05-16 14:51:05.690643',1,2,50000),
(16,'NB-Q3-1766','2024-05-16 14:51:05.691645',2,1,70000),
(17,'NB-Q3-8469','2024-05-16 14:51:05.692644',2,1,80000),
(18,'NB-Q3-2739','2024-05-16 14:51:05.693668',2,1,50000),
(19,'NB-Q3-4205','2024-05-16 14:51:05.695667',2,1,60000),
(20,'NB-Q3-5427','2024-05-16 14:51:05.696682',2,1,50000);


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trip` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `depart_at` datetime(6) NOT NULL,
  `car_id` bigint NOT NULL,
  `route_id` bigint NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `trip_car_idx` (`car_id`),
  KEY `trip_route_idx` (`route_id`),
  CONSTRAINT `fk_trip_car` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
  CONSTRAINT `fk_trip_route` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`)
) ;
DELIMITER $$

CREATE TRIGGER `calculate_trip_price` BEFORE INSERT ON `trip`
FOR EACH ROW 
BEGIN
  DECLARE seatPrice double;
  DECLARE routePrice double;

  SELECT `seat_price` INTO seatPrice FROM `car` WHERE `id` = NEW.car_id;
  SELECT `route_price` INTO routePrice FROM `route` WHERE `id` = NEW.route_id;

  SET NEW.price = IFNULL(seatPrice, 0) + IFNULL(routePrice, 0);
END$$

DELIMITER ;
INSERT INTO `trip` (`created_at`, `is_active`, `depart_at`, `car_id`, `route_id`) 
VALUES 
('2024-05-16 14:51:05.672698', 1, '2024-05-16 14:51:05.672698', 1, 2),
('2024-05-16 14:51:05.675086', 1, '2024-05-16 14:51:05.675086', 1, 2),
('2024-05-16 14:51:05.677094', 1, '2024-05-16 14:51:05.677094', 1, 2),
('2024-05-16 14:51:05.678095', 1, '2024-05-16 14:51:05.678095', 1, 2),
('2024-05-16 14:51:05.679092', 1, '2024-05-16 14:51:05.679092', 1, 2),
('2024-05-16 14:51:05.680091', 1, '2024-05-16 14:51:05.680091', 1, 2),
('2024-05-16 14:51:05.681098', 1, '2024-05-16 14:51:05.681098', 1, 2),
('2024-05-16 14:51:05.682618', 1, '2024-05-16 14:51:05.682618', 1, 2),
('2024-05-16 14:51:05.683624', 1, '2024-05-16 14:51:05.683624', 1, 2),
('2024-05-16 14:51:05.684623', 1, '2024-05-16 14:51:05.684623', 1, 2),
('2024-05-16 14:51:05.685637', 1, '2024-05-16 14:51:05.685637', 1, 2),
('2024-05-16 14:51:05.686645', 1, '2024-05-16 14:51:05.686645', 1, 2),
('2024-05-16 14:51:05.688643', 1, '2024-05-16 14:51:05.688643', 1, 2),
('2024-05-16 14:51:05.689645', 1, '2024-05-16 14:51:05.689645', 1, 2),
('2024-05-16 14:51:05.690643', 1, '2024-05-16 14:51:05.690643', 1, 2),
('2024-05-16 14:51:05.691645', 1, '2024-05-16 14:51:05.691645', 2, 1),
('2024-05-16 14:51:05.692644', 1, '2024-05-16 14:51:05.692644', 2, 1),
('2024-05-16 14:51:05.693668', 1, '2024-05-16 14:51:05.693668', 2, 1),
('2024-05-16 14:51:05.695667', 1, '2024-05-16 14:51:05.695667', 2, 1),
('2024-05-16 14:51:05.696682', 1, '2024-05-16 14:51:05.696682', 2, 1);


CREATE TABLE `orders` (
	`id` bigint NOT NULL AUTO_INCREMENT,
    `customer_id` bigint NOT NULL,
   
    `pay_at` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`),
   
    KEY `order_customer_idx` (`customer_id`),
  
	CONSTRAINT `fk_order_customer` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`)
);
insert into `orders` values
(1,1,'2024-01-16 14:51:05.672698');


CREATE TABLE `ticket` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `expired_at` datetime(6) NOT NULL,
  `paid_at` datetime(6) DEFAULT NULL,
  `trip_id` bigint NOT NULL,
  `seat_id` bigint NOT NULL,
  `is_active` boolean DEFAULT TRUE,
  `order_id` bigint not null, 
  PRIMARY KEY (`id`),
  KEY `ticket_trip_idx` (`trip_id`),
  KEY `ticket_seat_idx` (`seat_id`),
  foreign key(`order_id`) references  `orders` (`id`),
  CONSTRAINT `fk_ticket_trip` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id`),
  CONSTRAINT `fk_ticket_seat` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`)
);
DELIMITER $$

CREATE TRIGGER set_expired_at
BEFORE INSERT ON ticket
FOR EACH ROW
BEGIN
    DECLARE depart_time DATETIME(6);

    -- Lấy thời gian khởi hành từ bảng trip dựa trên trip_id
    SELECT depart_at INTO depart_time
    FROM trip
    WHERE id = NEW.trip_id;

    -- Đặt giá trị expired_at bằng depart_at cộng thêm 1 giờ (hoặc tùy chỉnh khoảng thời gian)
    SET NEW.expired_at = DATE_ADD(depart_time, INTERVAL 0 HOUR);
END;


$$ DELIMITER 

insert into `ticket`(`id`, `paid_at`,`trip_id`,`seat_id`,`is_active`,`order_id`) values 
(1, '2024-01-16 14:51:05.672698',1,1,1,1),
(2, '2024-01-16 14:51:05.672698',1,2,1,1),
(3, '2024-01-16 14:51:05.672698',1,3,1,1),
(4, '2024-01-16 14:51:05.672698',1,4,1,1),
(5, '2024-01-16 14:51:05.672698',1,5,1,1)
;