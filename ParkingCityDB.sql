CREATE DATABASE ParkingCity;
USE ParkingCity;

CREATE TABLE Area (
    AreaID NVARCHAR(1) PRIMARY KEY,
    Estado ENUM('DISPONIBLE', 'NO_DISPONIBLE')
);

CREATE TABLE CajonEstacionamiento (
    CajonEstacionamientoID INT AUTO_INCREMENT PRIMARY KEY,
    EstadoCajon ENUM('VACIO', 'OCUPADO'),
    AreaID NVARCHAR(1)
);

CREATE TABLE Ticket (
    TicketID INT AUTO_INCREMENT PRIMARY KEY,
    HoraEntrada TIME,
    FechaEntrada DATE,
    FechaSalida DATE,
    HoraSalida TIME,
    Estado ENUM ('PAGADO', 'SIN_PAGAR'),
    CajonEstacionamientoID INT 
);

ALTER TABLE CajonEstacionamiento ADD CONSTRAINT CAJONESTACIONAMIENTO_AREA 
FOREIGN KEY (AreaID) REFERENCES Area (AreaID) ON DELETE CASCADE;

ALTER TABLE Ticket ADD CONSTRAINT TICKET_CAJONESTACIONAMIENTO
FOREIGN KEY (CajonEstacionamientoID) REFERENCES CajonEstacionamiento (CajonEstacionamientoID) ON DELETE CASCADE;

INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'A');

INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'B');

INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'C');

INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'D');

INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');
INSERT INTO CajonEstacionamiento (EstadoCajon, AreaID) VALUES ('VACIO', 'M');



