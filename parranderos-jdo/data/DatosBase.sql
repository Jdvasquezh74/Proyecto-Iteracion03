--Datos de Operadores
--Operadores jurídicos
INSERT INTO A_USUARIO (Id, Nit, Ubicacion, TipoJuridico, RelacionComunidad, Clave) VALUES(1,13479971147,'Las Aguas','Vivienda Universitaria','Convenio','1234');
INSERT INTO A_OPERADOR (Id, Nombre) VALUES(1,'City U');
INSERT INTO A_USUARIO (Id, Nit, Ubicacion, TipoJuridico, RelacionComunidad, Clave) VALUES(2,12384775261,'Las Aguas','Hotel','Convenio','abc1');
INSERT INTO A_OPERADOR (Id, Nombre) VALUES(2,'The Spot');
INSERT INTO A_USUARIO (Id, Nit, Ubicacion, TipoJuridico, RelacionComunidad, Clave) VALUES(3,12234524140,'Venecia','Hotel','Convenio','*acb');
INSERT INTO A_OPERADOR (Id, Nombre) VALUES(3,'Venecia''s Site');
INSERT INTO A_USUARIO (Id, Nit, Ubicacion, TipoJuridico, RelacionComunidad, Clave) VALUES(4,11267378276,'Las Aguas','Hostal','Convenio','-ad-');
INSERT INTO A_OPERADOR (Id, Nombre) VALUES(4,'Hostal María');
INSERT INTO A_USUARIO (Id, Nit, Ubicacion, TipoJuridico, RelacionComunidad, Clave) VALUES(5,19936899590,'Fenicia','Hostal','Convenio','efgh');
INSERT INTO A_OPERADOR (Id, Nombre) VALUES(5,'La Zona de Fercho');
--Datos extra de operadores jurídicos
--Datos extra de vivienda universitaria
INSERT INTO A_SERVICIO(Id, IdUsuario, Amoblamiento, Cosineta, Wifi, TVCable, ServiciosPublicos, Recepcion24H, Aseo, ApoyoSocial, ApoyoAcademico) 
VALUES (1,1,'true','true','true','true','true','true','true','true','true');

INSERT INTO A_CONTRATO (Id, IdUsuario, Periodo, Costo)
VALUES(1,1,'Mensual',2300000);
INSERT INTO A_CONTRATO (Id, IdUsuario, Periodo, Costo)
VALUES(2,1,'Trimestral',5800000);
INSERT INTO A_CONTRATO (Id, IdUsuario, Periodo, Costo)
VALUES(3,1,'Semestral',8800000);
--Datos extra de hoteles
INSERT INTO A_SERVICIO(Id, IdUsuario, Restaurante, Piscina, Parqueadero, Wifi, TVCable) 
VALUES (2,2,'true','true','true','true','true');
INSERT INTO A_SERVICIO(Id, IdUsuario, Restaurante, Piscina, Parqueadero, Wifi, TVCable) 
VALUES (3,3,'false','false','false','true','true');
--Datos extra de hostales
INSERT INTO A_HORARIO(Id, IdUsuario, HoraInicio, HoraFin, Dia) 
VALUES (1,4,'8:00','22:00','L');
INSERT INTO A_HORARIO(Id, IdUsuario, HoraInicio, HoraFin, Dia) 
VALUES (2,4,'8:00','22:00','M');
INSERT INTO A_HORARIO(Id, IdUsuario, HoraInicio, HoraFin, Dia) 
VALUES (3,4,'8:00','22:00','X');
INSERT INTO A_HORARIO(Id, IdUsuario, HoraInicio, HoraFin, Dia) 
VALUES (4,4,'8:00','22:00','J');
INSERT INTO A_HORARIO(Id, IdUsuario, HoraInicio, HoraFin, Dia) 
VALUES (5,4,'8:00','22:00','V');
INSERT INTO A_HORARIO(Id, IdUsuario, HoraInicio, HoraFin, Dia) 
VALUES (6,4,'8:00','22:00','S');
INSERT INTO A_HORARIO(Id, IdUsuario, HoraInicio, HoraFin, Dia) 
VALUES (7,4,'8:00','22:00','D');

INSERT INTO A_HORARIO(Id, IdUsuario, HoraInicio, HoraFin, Dia) 
VALUES (1,5,'7:00','23:00','L');
INSERT INTO A_HORARIO(Id, IdUsuario, HoraInicio, HoraFin, Dia) 
VALUES (2,5,'7:00','23:00','M');
INSERT INTO A_HORARIO(Id, IdUsuario, HoraInicio, HoraFin, Dia) 
VALUES (3,5,'7:00','23:00','X');
INSERT INTO A_HORARIO(Id, IdUsuario, HoraInicio, HoraFin, Dia) 
VALUES (4,5,'7:00','23:00','J');
INSERT INTO A_HORARIO(Id, IdUsuario, HoraInicio, HoraFin, Dia) 
VALUES (5,5,'8:00','22:00','V');
INSERT INTO A_HORARIO(Id, IdUsuario, HoraInicio, HoraFin, Dia) 
VALUES (6,5,'9:00','21:00','S');

--Operadores naturales
INSERT INTO A_USUARIO (Id, NumeroDocumento, TipoDocumento, RelacionComunidad, Clave) VALUES(6,61792456,'CC','Profesor','1235');
INSERT INTO A_OPERADOR (Id, Nombre) VALUES(6,'Alberto Rojas');
INSERT INTO A_USUARIO (Id, NumeroDocumento, TipoDocumento, RelacionComunidad, Clave) VALUES(7,10592831,'CC','Egresado','ghjk');
INSERT INTO A_OPERADOR (Id, Nombre) VALUES(7,'María Rossetti');

--Datos de clientes
INSERT INTO A_CLIENTE (Id, Nombre) VALUES(6,'Alberto Rojas');
INSERT INTO A_USUARIO (Id, NumeroDocumento, TipoDocumento, RelacionComunidad, Clave) VALUES(8,1151123456,'TI','Estudiante','#hf3');
INSERT INTO A_CLIENTE (Id, Nombre) VALUES(8,'Humberto Morales');
INSERT INTO A_USUARIO (Id, NumeroDocumento, TipoDocumento, RelacionComunidad, Clave) VALUES(9,1346578921,'CE','Egresado','hyT3');
INSERT INTO A_CLIENTE (Id, Nombre) VALUES(9,'Lina Puebla');

--Habitaciones de los hoteles
INSERT INTO A_OFERTA (Id, IdUsuario, Tipo, Precio, Capacidad, TipoHabitacion, Baniera, Yacuzzi, Sala, Cosineta, Otros, Dimensiones) 
VALUES(101,2,'Confort',80000,2,'Habitación Estándar','true','false','true','true','false','80x60');
INSERT INTO A_OFERTA (Id, IdUsuario, Tipo, Precio, Capacidad, TipoHabitacion, Baniera, Yacuzzi, Sala, Cosineta, Otros,Dimensiones) 
VALUES(102,2,'Confort',80000,2,'Habitación Estándar','true','false','true','true','false','80x60');
INSERT INTO A_OFERTA (Id, IdUsuario, Tipo, Precio, Capacidad, TipoHabitacion, Baniera, Yacuzzi, Sala, Cosineta, Otros,Dimensiones) 
VALUES(103,2,'Deluxe',120000,3,'SemiSuite','true','true','true','true','false','120x80');
INSERT INTO A_OFERTA (Id, IdUsuario, Tipo, Precio, Capacidad, TipoHabitacion, Baniera, Yacuzzi, Sala, Cosineta, Otros,Dimensiones) 
VALUES(104,2,'Lujo',160000,3,'Suite','true','true','true','true','true','160x90');

INSERT INTO A_OFERTA (Id, IdUsuario, Tipo, Precio, Capacidad, TipoHabitacion, Baniera, Yacuzzi, Sala, Cosineta, Otros, Dimensiones) 
VALUES(25,3,'Confort',80000,2,'Habitación Estándar','true','false','true','true','false','80x60');
INSERT INTO A_OFERTA (Id, IdUsuario, Tipo, Precio, Capacidad, TipoHabitacion, Baniera, Yacuzzi, Sala, Cosineta, Otros,Dimensiones) 
VALUES(26,3,'Confort',80000,2,'Habitación Estándar','true','false','true','true','false','80x60');

--Habitaciones de los hostales
INSERT INTO A_OFERTA (Id, IdUsuario, Capacidad, Dimensiones, Precio) 
VALUES(1001,4,6,'80x60',25000);
INSERT INTO A_OFERTA (Id, IdUsuario, Capacidad, Dimensiones, Precio)
VALUES(1002,4,6,'80x60',25000);
INSERT INTO A_OFERTA (Id, IdUsuario, Capacidad, Dimensiones, Precio)
VALUES(1,5,10,'120x80',20000);
INSERT INTO A_OFERTA (Id, IdUsuario, Capacidad, Dimensiones, Precio)
VALUES(2,5,5,'60x60',15000);

--Habitaciones de una vivienda universitaria
INSERT INTO A_OFERTA (Id, IdUsuario, Capacidad, Compartida) 
VALUES(1001,1,2,'true');
INSERT INTO A_OFERTA (Id, IdUsuario, Capacidad, Compartida)
VALUES(1002,1,2,'true');
INSERT INTO A_OFERTA (Id, IdUsuario, Capacidad, Compartida)
VALUES(801,1,1,'false');
INSERT INTO A_OFERTA (Id, IdUsuario, Capacidad, Compartida)
VALUES(802,1,1,'false');

--Habitaciones de operador natural
INSERT INTO A_OFERTA (Id, IdUsuario, Ubicacion, Compartida)
VALUES(1,6,'Kennedy','false');
INSERT INTO A_OFERTA (Id, IdUsuario, Ubicacion, Compartida)
VALUES(2,6,'Kennedy','false');
--Info extra de habitación natural
INSERT INTO A_SERVICIO(Id, IdUsuario, IdOferta, Comidas, Cosineta, BanioPrivado, CostoLuz, CostoAgua, CostoTVCable, CostoWifi) 
VALUES (4,6,1,'true','true','false',0,0,5000,5000);
INSERT INTO A_SERVICIO(Id, IdUsuario, IdOferta, Comidas, Cosineta, BanioPrivado, CostoLuz, CostoAgua, CostoTVCable, CostoWifi) 
VALUES (5,6,2,'true','true','false',0,0,5000,5000);
--Apartamento de operador natural
INSERT INTO A_OFERTA (Id, IdUsuario, Ubicacion, Amoblado)
VALUES(3,6,'Quinta Paredes','true');
--Info extra de alquiler
INSERT INTO A_SERVICIO(Id, IdUsuario, IdOferta, CostoLuz, CostoAgua, CostoTVCable, CostoWifi) 
VALUES (6,6,3,0,0,75000,60000);
--Vivienda de operador natural
INSERT INTO A_OFERTA (Id, IdUsuario, Ubicacion, NumeroHabitaciones, Amoblado, Precio, DiasArriendo, HistorialDiasArriendo)
VALUES(7,7,'Salitre',3,'true',120000,3,0);
--Info extra de vivienda
INSERT INTO A_SEGURO (Id, IdOferta, IdUsuario, Costo, Caracteristicas)
VALUES(1,7,7,30000,'Incluye suciedad y desarreglos en la vivienda (NO DAÑOS)');

INSERT INTO A_CONTRATO (Id, IdUsuario, Periodo, Costo)
VALUES(4,6,'Diario',30000);
INSERT INTO A_CONTRATO (Id, IdUsuario, Periodo, Costo)
VALUES(5,6,'Semanal',150000);
INSERT INTO A_CONTRATO (Id, IdUsuario, Periodo, Costo)
VALUES(6,6,'Mensual',500000);

--Reservas realizadas por clientes
INSERT INTO A_RESERVA (Id, IdCliente, IdOferta, IdOperador, FechaInicio, FechaFin)
VALUES(1,6,7,7,TO_DATE('16/11/2023', 'DD/MM/YYYY'),TO_DATE('25/11/2023', 'DD/MM/YYYY'));
INSERT INTO A_RESERVA (Id, IdCliente, IdOferta, IdOperador, FechaInicio, FechaFin)
VALUES(2,8,102,2,TO_DATE('14/11/2023', 'DD/MM/YYYY'),TO_DATE('25/11/2023', 'DD/MM/YYYY'));
INSERT INTO A_RESERVA (Id, IdCliente, IdOferta, IdOperador, FechaInicio, FechaFin)
VALUES(3,6,103,2,TO_DATE('15/11/2023', 'DD/MM/YYYY'),TO_DATE('25/11/2023', 'DD/MM/YYYY'));
INSERT INTO A_RESERVA (Id, IdCliente, IdOferta, IdOperador, FechaInicio, FechaFin)
VALUES(4,6,104,2,TO_DATE('16/11/2023', 'DD/MM/YYYY'),TO_DATE('25/11/2023', 'DD/MM/YYYY'));
INSERT INTO A_RESERVA (Id, IdCliente, IdOferta, IdOperador, FechaInicio, FechaFin)
VALUES(5,6,101,2,TO_DATE('16/11/2023', 'DD/MM/YYYY'),TO_DATE('25/11/2023', 'DD/MM/YYYY'));
INSERT INTO A_RESERVA (Id, IdCliente, IdOferta, IdOperador, FechaInicio, FechaFin)
VALUES(6,9,1001,4,TO_DATE('11/03/2023', 'DD/MM/YYYY'),TO_DATE('14/03/2023', 'DD/MM/YYYY'));

--Cancelar una reserva
DELETE FROM A_RESERVA 
WHERE Id=6;

--Cancelar una oferta
DELETE FROM A_SEGURO
WHERE IdUsuario=1 AND IdOferta=101;
DELETE FROM A_SERVICIO
WHERE IdUsuario=1 AND IdOferta=101;
DELETE FROM A_OFERTA
WHERE Id=801 AND IdUsuario = 1;

--Seleccionar un usuario
SELECT *
FROM A_USUARIO
WHERE nit = 19936899590 OR numeroDocumento = 19936899590; 

--Consulta sobre las 20 reservas más famosas
SELECT *
FROM(
SELECT idUsuario, id, coalesce(revCL.numReservas,0) as numReservas
FROM (SELECT idOferta, idOperador, count(id) as numReservas
      FROM A_RESERVA re
      GROUP BY idOferta, idOperador) revCl RIGHT OUTER JOIN A_OFERTA ofe 
      ON revCl.idOferta = ofe.id AND revCL.idOperador = ofe.idUsuario
ORDER BY numReservas DESC, idUsuario, id ASC)
WHERE rownum <= 20;

--Índice de ocupación de las ofertas registradas
SELECT *
FROM(
SELECT idUsuario, id, coalesce(round(coalesce(revCL.numReservas,0)/capacidad*100,2),0) as porcentajeReserva
FROM (SELECT idOferta, idOperador, count(id) as numReservas
      FROM A_RESERVA re
      GROUP BY idOferta, idOperador) revCl RIGHT OUTER JOIN A_OFERTA ofe 
      ON revCl.idOferta = ofe.id AND revCL.idOperador = ofe.idUsuario
ORDER BY porcentajeReserva DESC, idUsuario, id ASC);

--Índice de ocupación total de las ofertas registradas
SELECT round(rev.totalReservas/ofe.ofertas*100,2) porcentajeOcupacion
FROM(SELECT count(numReservas) as totalReservas
FROM (SELECT idOferta, idOperador, count(id) as numReservas
      FROM A_RESERVA re
      GROUP BY idOferta, idOperador) revCl RIGHT OUTER JOIN A_OFERTA ofe 
      ON revCl.idOferta = ofe.id AND revCL.idOperador = ofe.idUsuario) rev, 
      (SELECT count(id) as ofertas
      FROM A_OFERTA ofe) ofe;