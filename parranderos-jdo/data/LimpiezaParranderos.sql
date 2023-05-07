--- Sentencias SQL para la creación del esquema de parranderos
--- Las tablas tienen prefijo A_ para facilitar su acceso desde SQL Developer

-- USO
-- Copie el contenido deseado de este archivo en una pestaña SQL de SQL Developer
-- Ejecútelo como un script - Utilice el botón correspondiente de la pestaña utilizada
    
-- Eliminar todas las tablas de la base de datos
DROP SEQUENCE alohandes_sequence;
DROP TABLE "A_SERVICIOCOSTOADICIONAL" CASCADE CONSTRAINTS;
DROP TABLE "A_CONTRATO" CASCADE CONSTRAINTS;
DROP TABLE "A_HORARIO" CASCADE CONSTRAINTS;
DROP TABLE "A_OFERTA" CASCADE CONSTRAINTS;
DROP TABLE "A_RESERVA" CASCADE CONSTRAINTS;
DROP TABLE "A_SERVICIO" CASCADE CONSTRAINTS;
DROP TABLE "A_USUARIO" CASCADE CONSTRAINTS;
DROP TABLE "A_OPERADOR" CASCADE CONSTRAINTS;
DROP TABLE "A_CLIENTE" CASCADE CONSTRAINTS;
DROP TABLE "A_SEGURO" CASCADE CONSTRAINTS;
COMMIT;

-- Eliminar el contenido de todas las tablas de la base de datos
-- El orden es importante. Por qué?
delete from a_servicio;
delete from a_contrato;
delete from a_serviciocostoadicional;
delete from a_seguro;
delete from a_oferta;
delete from a_reserva;
delete from a_horario;
delete from a_operador;
delete from a_cliente;
delete from a_usuario;
commit;

