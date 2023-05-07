-- Creaci�n del secuenciador
create sequence alohandes_sequence;

CREATE TABLE A_USUARIO
(
Id NUMBER,
Nit NUMBER,
Ubicacion VARCHAR(30),
TipoJuridico VARCHAR(30) CONSTRAINT CK_USUARIO_TJ CHECK (TipoJuridico IN ('Hotel','Hostal','Vivienda Universitaria')),
NumeroDocumento NUMBER,
TipoDocumento VARCHAR(30),
RelacionComunidad VARCHAR(30),
Clave VARCHAR(30) CONSTRAINT NN_USUARIO_CL NOT NULL,
CONSTRAINT A_USUARIO_PK PRIMARY KEY (Id)
);

CREATE TABLE A_CLIENTE
(
Id NUMBER,
Nombre VARCHAR(30) NOT NULL,
CONSTRAINT A_CLIENTE_PK PRIMARY KEY (Id)
);

ALTER TABLE A_CLIENTE

ADD CONSTRAINT fk_cliente_a_usuario
    FOREIGN KEY (Id)
    REFERENCES a_usuario(Id)
ENABLE;

CREATE TABLE A_OPERADOR
(
Id NUMBER,
Nombre VARCHAR(30) NOT NULL,
CONSTRAINT A_OPERADOR_PK PRIMARY KEY (Id)
);

ALTER TABLE A_OPERADOR

ADD CONSTRAINT fk_operador_a_usuario
    FOREIGN KEY (Id)
    REFERENCES a_usuario(Id)
ENABLE; 

CREATE TABLE A_HORARIO
(
Id NUMBER,
IdUsuario NUMBER,
HoraInicio VARCHAR(30),
HoraFin VARCHAR(30),
Dia VARCHAR(30),
CONSTRAINT A_HORARIO_PK PRIMARY KEY(Id, IdUsuario)
);

ALTER TABLE A_HORARIO

ADD CONSTRAINT fk_horario_a_usuario
    FOREIGN KEY (IdUsuario)
    REFERENCES a_usuario(Id)
ENABLE; 

CREATE TABLE A_CONTRATO
(
Id NUMBER,
IdUsuario NUMBER,
Periodo VARCHAR(30),
Costo NUMBER,
CONSTRAINT A_CONTRATO_PK PRIMARY KEY(Id)
);

ALTER TABLE A_CONTRATO

ADD CONSTRAINT fk_contrato_a_operador
    FOREIGN KEY (IdUsuario)
    REFERENCES a_operador(Id)
ENABLE; 

CREATE TABLE A_SERVICIOCOSTOADICIONAL
(
Id NUMBER,
IdUsuario NUMBER,
Nombre VARCHAR(30),
Costo NUMBER,
CONSTRAINT A_SERVICIOCOSTOADICIONAL_PK PRIMARY KEY(Id)
);

ALTER TABLE A_SERVICIOCOSTOADICIONAL

ADD CONSTRAINT fk_serviciosadicional_a_operador
    FOREIGN KEY (IdUsuario)
    REFERENCES a_operador(Id)
ENABLE; 

CREATE TABLE A_OFERTA
(
Id NUMBER,
IdUsuario NUMBER,
NumeroHabitaciones NUMBER,
DiasArriendo NUMBER,
HistorialDiasArriendo NUMBER,
Tipo VARCHAR(30),
Precio NUMBER,
Capacidad NUMBER,
Ubicacion VARCHAR(30),
TipoHabitacion VARCHAR(30),
Compartida VARCHAR(30),
Amoblado VARCHAR(30),
Dimensiones VARCHAR(30),
Baniera VARCHAR(30),
Yacuzzi VARCHAR(30),
Sala VARCHAR(30),
Cosineta VARCHAR(30),
Otros VARCHAR(30),
CONSTRAINT A_OFERTA_PK PRIMARY KEY(Id, IdUsuario)
);

ALTER TABLE A_OFERTA

ADD CONSTRAINT fk_oferta_a_operador
    FOREIGN KEY (IdUsuario)
    REFERENCES a_operador(Id)
ENABLE; 

ALTER TABLE A_OFERTA
	ADD CONSTRAINT CK_OFERTA_CMP
	CHECK (Compartida IN ('true', 'false'))
ENABLE;

ALTER TABLE A_OFERTA
	ADD CONSTRAINT CK_OFERTA_AMB
	CHECK (Amoblado IN ('true', 'false'))
ENABLE;

ALTER TABLE A_OFERTA
	ADD CONSTRAINT CK_OFERTA_BN
	CHECK (Baniera IN ('true', 'false'))
ENABLE;

ALTER TABLE A_OFERTA
	ADD CONSTRAINT CK_OFERTA_YC
	CHECK (Yacuzzi IN ('true', 'false'))
ENABLE;

ALTER TABLE A_OFERTA
	ADD CONSTRAINT CK_OFERTA_SL
	CHECK (Sala IN ('true', 'false'))
ENABLE;

ALTER TABLE A_OFERTA
	ADD CONSTRAINT CK_OFERTA_CS
	CHECK (Cosineta IN ('true', 'false'))
ENABLE;

ALTER TABLE A_OFERTA
	ADD CONSTRAINT CK_OFERTA_OTROS
	CHECK (Otros IN ('true', 'false'))
ENABLE;

CREATE TABLE A_RESERVA
(
Id NUMBER,
IdCliente NUMBER,
IdOferta NUMBER,
IdOperador NUMBER,
Precio NUMBER,
FechaInicio DATE,
FechaFin DATE,
CONSTRAINT A_RESERVA_PK PRIMARY KEY(Id)
);

ALTER TABLE A_RESERVA

ADD CONSTRAINT fk_reserva_a_cliente
    FOREIGN KEY (IdCliente)
    REFERENCES a_cliente(Id)
ENABLE;

ALTER TABLE A_RESERVA

ADD CONSTRAINT fk_reserva_a_oferta
    FOREIGN KEY (IdOferta, IdOperador)
    REFERENCES a_oferta(Id, IdUsuario)
ENABLE;

CREATE TABLE A_SERVICIO
(
Id NUMBER,
IdOferta NUMBER,
IdUsuario NUMBER,
Restaurante VARCHAR(30) CONSTRAINT CK_SERVICIO_RS CHECK(Restaurante IN ('true','false')),
Piscina VARCHAR(30) CONSTRAINT CK_SERVICIO_PS CHECK(Piscina IN ('true','false')),
Parqueadero VARCHAR(30) CONSTRAINT CK_SERVICIO_PA CHECK(Parqueadero IN ('true','false')),
Wifi VARCHAR(30) CONSTRAINT CK_SERVICIO_WF CHECK(Wifi IN ('true','false')),
TVCable VARCHAR(30) CONSTRAINT CK_SERVICIO_TV CHECK(TVCable IN ('true','false')),
Recepcion24H VARCHAR(30) CONSTRAINT CK_SERVICIO_RC24 CHECK(Recepcion24H IN ('true','false')),
Amoblamiento VARCHAR(30) CONSTRAINT CK_SERVICIO_AM CHECK(Amoblamiento IN ('true','false')),
Cosineta VARCHAR(30) CONSTRAINT CK_SERVICIO_CS CHECK(Cosineta IN ('true','false')),
ServiciosPublicos VARCHAR(30) CONSTRAINT CK_SERVICIO_SP CHECK(ServiciosPublicos IN ('true','false')),
Aseo VARCHAR(30) CONSTRAINT CK_SERVICIO_AS CHECK(Aseo IN ('true','false')),
ApoyoSocial VARCHAR(30) CONSTRAINT CK_SERVICIO_APS CHECK(ApoyoSocial IN ('true','false')),
ApoyoAcademico VARCHAR(30) CONSTRAINT CK_SERVICIO_APA CHECK(ApoyoAcademico IN ('true','false')),
Comidas VARCHAR(30) CONSTRAINT CK_SERVICIO_CD CHECK(Comidas IN ('true','false')),
BanioPrivado VARCHAR(30) CONSTRAINT CK_SERVICIO_BP CHECK(BanioPrivado IN ('true','false')),
CostoLuz NUMBER CONSTRAINT CK_SERVICIO_CL CHECK(CostoLuz >= 0),
CostoAgua NUMBER CONSTRAINT CK_SERVICIO_CA CHECK(CostoAgua >= 0),
CostoTVCable NUMBER CONSTRAINT CK_SERVICIO_CTV CHECK(CostoTVCable >= 0),
CostoWifi NUMBER CONSTRAINT CK_SERVICIO_CW CHECK(CostoWifi >= 0),
CONSTRAINT A_SERVICIO_PK PRIMARY KEY(Id, IdUsuario)
);

ALTER TABLE A_SERVICIO

ADD CONSTRAINT fk_servicio_a_usuario
    FOREIGN KEY (IdUsuario)
    REFERENCES a_usuario(Id)
ENABLE; 

ALTER TABLE A_SERVICIO

ADD CONSTRAINT fk_servicio_a_oferta
    FOREIGN KEY (IdOferta, IdUsuario) 
    REFERENCES a_oferta(Id, IdUsuario)
ENABLE; 

CREATE TABLE A_SEGURO
(
Id NUMBER,
IdOferta NUMBER,
IdUsuario NUMBER,
Caracteristicas VARCHAR(120),
Costo NUMBER,
CONSTRAINT A_SEGURO_PK PRIMARY KEY(Id)
);

ALTER TABLE A_SEGURO

ADD CONSTRAINT fk_seguro_a_oferta
    FOREIGN KEY (IdOferta, IdUsuario)
    REFERENCES a_oferta(Id, IdUsuario)
ENABLE; 

COMMIT;

