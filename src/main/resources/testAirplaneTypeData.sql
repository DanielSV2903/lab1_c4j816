-- 1. Limpieza en cascada respetando las claves foráneas
DELETE FROM [dbo].[booking];
DELETE FROM [dbo].[flight_log];
DELETE FROM [dbo].[flight];
DELETE FROM [dbo].[flightschedule];
DELETE FROM [dbo].[airport_reachable];
DELETE FROM [dbo].[airport_geo];
DELETE FROM [dbo].[airplane];
DELETE FROM [dbo].[airplane_type];
DELETE FROM [dbo].[airline];
DELETE FROM [dbo].[airport];

-- 2. Reinicio de contadores IDENTITY
DBCC CHECKIDENT ('[dbo].[airplane]', RESEED, 0);
DBCC CHECKIDENT ('[dbo].[airplane_type]', RESEED, 0);
DBCC CHECKIDENT ('[dbo].[airline]', RESEED, 0);
DBCC CHECKIDENT ('[dbo].[airport]', RESEED, 0);

-- 3. Aeropuerto base (Requerido por la FK de airline)
INSERT INTO [dbo].[airport] ([iata], [icao], [name]) VALUES
('MAD', 'LEMD', 'Adolfo Suárez Madrid-Barajas');

-- 4. Aerolíneas
INSERT INTO [dbo].[airline] ([iata], [airlinename], [base_airport]) VALUES
('IB', 'Iberia', 1),
('LH', 'Lufthansa', 1);

-- 5. Tipos de aeronave
INSERT INTO [dbo].[airplane_type] ([identifier], [description]) VALUES
('Boeing 737-800', 'Fuselaje estrecho, corto y medio alcance'),
('Airbus A320-200', 'Un pasillo, medio alcance'),
('Embraer E190',   'Avión regional sin flota asignada');

-- 6. Aeronaves asignadas
INSERT INTO [dbo].[airplane] ([capacity], [type_id], [airline_id]) VALUES
(186, 1, 1),
(189, 1, 1),
(180, 2, 2);