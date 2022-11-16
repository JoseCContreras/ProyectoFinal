CREATE  DATABASE ecomerce;

USE ecomerce;


CREATE TABLE productos (
id int PRIMARY KEY AUTO_INCREMENT,
sku VARCHAR (50) NOT NULL,
descripcion VARCHAR (50) NOT NULL,
precio_Compra DOUBLE NOT NULL,
precio_Venta DOUBLE NOT NULL,
stock INT,
fecha_Alta DATE);


CREATE TABLE clientes(
id int PRIMARY KEY AUTO_INCREMENT,
dni VARCHAR (11) UNIQUE,
nombre VARCHAR (45) NOT NULL,
apellido VARCHAR (45) NOT NULL,
fecha_Nacimiento DATE  NOT NULL);

CREATE TABLE venta (
id INT PRIMARY KEY AUTO_INCREMENT,
fecha_Alta DATE,
total DOUBLE,
cliente_id INT,
CONSTRAINT fk_cliente_id FOREIGN KEY (cliente_id) REFERENCES clientes (id));

CREATE TABLE detalle_Venta (
id INT PRIMARY KEY AUTO_INCREMENT,
venta_id INT, 
productos_id INT,
cantidad INT NOT NULL,
subtotal DOUBLE,
CONSTRAINT fk_venta_id FOREIGN KEY (venta_id) REFERENCES venta (id),
CONSTRAINT fk_productos_id FOREIGN KEY (productos_id) REFERENCES productos (id));


USE ecomerce;

INSERT INTO productos (id,sku,descripcion,precio_Compra,precio_venta,stock, fecha_Alta) VALUES
 ('1','6942138956184','H2OGO! DOUBLE SLIDE','2200','4400','12','2022-10-15'),
 ('2','6942138946550','SET DE SNORKEL CLASICO','1090','2000','12','2022-07-15'),
 ('3','6942138923797','colchoneta con red surtido','3000','4990','12','2022-10-05'),
 ('4','6942138919073','COLCHONETA APOYA VASO','1550','3500','6','2022-10-27'),
 ('5','6942138930245','SALVAVIDAS ARCOIRIS','3258','6990','6','2022-10-01'),
 ('6','6942138961867','UNICORNIO KAWAII CHICO INFLABLE','7240','14400','12','2022-06-30'),
 ('7','6942138967432','WATERMELON ISLAND','300','590','8','2022-05-21'),
 ('8','6942138951271','isla soleada siciliana','1000','1600','12','2022-02-19'),
 ('9','6942138950762','FRUTAS SURTIDOS 84 X 58 CM','3600','5820','22','2022-09-15'),
 ('10','6942138913231','ORCA INFLABLE','100','200','30','2022-09-15');
 

 
 INSERT INTO clientes (id,dni,nombre,apellido,fecha_Nacimiento) VALUES
 ('1','95906218','Jose','Contreras','1993-07-09'),
 ('2','33694911','LUCAS DANIEL','AGÜERO','1983-10-15'),
 ('3','34328642','ESTEFANÍA SOLEDAD','AGÜERO PARRA','1972-08-22'),
 ('4','13696436','ALFREDO ALEJANDRO','AGUILERA  MORENO','1999-05-30'),
 ('5','F4506883','DAIANA BELEN','ÁLAMO','2001-06-01'),
 ('6','25609258','ESTELA JUANA','ALMARÁZ','1995-12-14'),
 ('7','11140543','MARÍA ESTELA','BAZÁN','1999-09-09'),
 ('8','21088102','JUAN MANUEL','BLANQUER ROMERO','1952-11-18'),
 ('9','53631896','ELIANA DANIELA','CÓRDOBA OLGA','1968-04-06'),
 ('10','F4412351','WALTER EDUARDO','PERALTA SALICA','2010-02-19');




INSERT INTO venta (id,fecha_alta,total,cliente_id) VALUES
('1','2022-10-09','4400','1'),
('2','2022-10-09','2000','2'),
('3','2022-10-09','4990','3'),
('4','2022-10-09','3500','4'),
('5','2022-10-09','6990','5'),
('6','2022-10-09','14400','6'),
('7','2022-10-09','590','7'),
('8','2022-10-09','1600','8'),
('9','2022-10-09','5820','9'),
('10','2022-10-09','200','10');



INSERT INTO detalle_Venta (id,venta_id,productos_id,cantidad,subtotal) VALUES
('1',   '1',   '1',   '1',  '4400'),
('2',   '2',   '2',   '1',  '2000'),
('3',   '3',   '3',   '1',  '4990'),
('4',   '4',   '4',   '1',  '3500'),
('5',   '5',   '5',   '1',  '6990'),
('6',   '6',   '6',   '1',  '14400'),
('7',   '7',   '7',   '1',  '590'),
('8',   '8',   '8',   '1',  '1600'),
('9',   '9',   '9',   '1',  '5820'),
('10',  '10',  '10',  '1',  '200');

