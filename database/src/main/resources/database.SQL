CREATE TABLE beneficiaries
(
    ID          SERIAL PRIMARY KEY,
    nrBen       INT,
    name        VARCHAR(255),
    surname     VARCHAR(255),
    phone       VARCHAR(15),
    IDNP        VARCHAR(13),
    address     INTEGER,
    email       VARCHAR(255),
    localityID  INT,
    environment VARCHAR(50),
    cardID      INT
);

CREATE TABLE cards
(
    ID         SERIAL PRIMARY KEY,
    cardNr     VARCHAR(20),
    cardType   INT,
    dateExpire DATE
);

CREATE TABLE environments
(
    ID                   SERIAL PRIMARY KEY,
    environmentType      VARCHAR(50),
    popularityPercentage INT
);

CREATE TABLE users
(
    ID        SERIAL PRIMARY KEY,
    username  VARCHAR(50),
    password  VARCHAR(255),
    createdAt DATE,
    roleID    INT
);

CREATE TABLE roles
(
    ID       SERIAL PRIMARY KEY,
    roleName VARCHAR(50)
);

CREATE TABLE localities
(
    ID            SERIAL PRIMARY KEY,
    localityName  VARCHAR(255),
    localityType  VARCHAR(50),
    environmentID INT,
    population    INT,
    area          DECIMAL(10, 2)
);

ALTER TABLE beneficiaries
    ADD CONSTRAINT fk_locality FOREIGN KEY (localityID) REFERENCES localities (ID);
ALTER TABLE beneficiaries
    ADD CONSTRAINT fk_card FOREIGN KEY (cardID) REFERENCES cards (ID);
ALTER TABLE localities
    ADD CONSTRAINT fk_environment FOREIGN KEY (environmentID) REFERENCES environments (ID);
ALTER TABLE users
    ADD CONSTRAINT fk_role FOREIGN KEY (roleID) REFERENCES roles (ID);

INSERT INTO roles (roleName)
VALUES ('Admin'),
       ('Editor'),
       ('Viewer'),
       ('Moderator'),
       ('Support'),
       ('Analyst'),
       ('Developer'),
       ('Tester'),
       ('Manager'),
       ('Customer');

INSERT INTO environments (environmentType, popularityPercentage)
VALUES ('Urban', 80),
       ('Rural', 60),
       ('Suburban', 70),
       ('Industrial', 50),
       ('Commercial', 85),
       ('Residential', 75),
       ('Natural', 90),
       ('Tourist', 95),
       ('Educational', 65),
       ('Technological', 78);

INSERT INTO localities (localityName, localityType, environmentID, population, area)
VALUES ('CityA', 'City', 1, 500000, 300.5),
       ('VillageB', 'Village', 2, 2000, 50.75),
       ('TownC', 'Town', 3, 25000, 100.9),
       ('CityD', 'City', 4, 800000, 450.25),
       ('VillageE', 'Village', 2, 1500, 30.2),
       ('TownF', 'Town', 3, 30000, 110.45),
       ('CityG', 'City', 5, 600000, 350.6),
       ('VillageH', 'Village', 6, 1000, 25.1),
       ('TownI', 'Town', 7, 15000, 75.3),
       ('CityJ', 'City', 8, 700000, 400.8);

INSERT INTO cards (cardNr, cardType, dateExpire)
VALUES ('1234567890123456', 1, '2025-01-01'),
       ('9876543210987654', 2, '2026-05-15'),
       ('5678901234567890', 3, '2027-09-30'),
       ('4321098765432109', 4, '2025-12-31'),
       ('6543210987654321', 5, '2028-07-01'),
       ('8765432109876543', 1, '2029-03-10'),
       ('2109876543210987', 2, '2024-11-20'),
       ('3456789012345678', 3, '2026-04-25'),
       ('5432109876543210', 4, '2027-08-18'),
       ('8901234567890123', 5, '2028-02-14');

INSERT INTO beneficiaries (nrBen, name, surname, phone, IDNP, address, email, localityID, environment, cardID)
VALUES (1, 'John', 'Doe', '1234567890', '1234567890123', 101, 'john.doe@example.com', 1, 'Urban', 1),
       (2, 'Jane', 'Smith', '0987654321', '9876543210987', 102, 'jane.smith@example.com', 2, 'Rural', 2),
       (3, 'Alice', 'Brown', '5678901234', '5678901234567', 103, 'alice.brown@example.com', 3, 'Suburban', 3),
       (4, 'Bob', 'Johnson', '4321098765', '4321098765432', 104, 'bob.johnson@example.com', 4, 'Industrial', 4),
       (5, 'Eve', 'Davis', '6543210987', '6543210987654', 105, 'eve.davis@example.com', 5, 'Commercial', 5),
       (6, 'Charlie', 'Wilson', '8765432109', '8765432109876', 106, 'charlie.wilson@example.com', 6, 'Residential', 6),
       (7, 'Grace', 'Taylor', '2109876543', '2109876543210', 107, 'grace.taylor@example.com', 7, 'Natural', 7),
       (8, 'Oscar', 'Anderson', '3456789012', '3456789012345', 108, 'oscar.anderson@example.com', 8, 'Tourist', 8),
       (9, 'Sophia', 'Thomas', '5432109876', '5432109876543', 109, 'sophia.thomas@example.com', 9, 'Educational', 9),
       (10, 'Liam', 'Martin', '8901234567', '8901234567890', 110, 'liam.martin@example.com', 10, 'Technological', 10);

INSERT INTO users (username, password, createdAt, roleID)
VALUES ('admin', 'password123', '2024-11-19', 1),
       ('editor', 'editorpass', '2024-10-15', 2),
       ('viewer', 'viewpass', '2024-09-01', 3),
       ('moderator', 'modpass', '2024-08-20', 4),
       ('support', 'supppass', '2024-07-30', 5),
       ('analyst', 'analypass', '2024-06-25', 6),
       ('developer', 'devpass', '2024-05-18', 7),
       ('tester', 'testpass', '2024-04-10', 8),
       ('manager', 'manpass', '2024-03-05', 9),
       ('customer', 'custpass', '2024-02-28', 10);
