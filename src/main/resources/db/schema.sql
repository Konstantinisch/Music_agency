-- Create the Orchester table

-- ALTER TABLE orchesters DROP FOREIGN KEY orchesters_id_fk;
-- drop
-- database music_agency;
--      create
-- database music_agency;


drop table if exists orchesters;
drop table if exists pianists;
drop table if exists managers;


-- Create the Manager table

--
-- CREATE TABLE managers
-- (
--     manager_id      INT PRIMARY KEY,
--     name            VARCHAR(64) not null,
--     percent_of_gage INT
-- );
--
--
-- CREATE TABLE orchesters
-- (
--     orchester_id               INT PRIMARY KEY,
--     name                       VARCHAR(64) not null,
--     number_of_people           INT,
--     name_of_program            VARCHAR(64) not null,
--     gage                       INT,
--     duration_of_concert_in_min INT,
--     manager_id_fk              INT
--     -- FOREIGN KEY (manager_id_fk) REFERENCES managers (manager_id)
-- );
--
--
-- -- Create the Pianist table
-- CREATE TABLE pianists
-- (
--     pianist_id                 INT PRIMARY KEY,
--     name                       VARCHAR(64) not null,
--     name_of_program            VARCHAR(64) not null,
--     gage                       INT,
--     duration_of_concert_in_min INT,
--     mp_id_fk                   INT
--     -- FOREIGN KEY (mp_id_fk) REFERENCES managers (manager_id)
-- );


CREATE TABLE managers
(
    manager_id      INTEGER PRIMARY KEY,
    name            VARCHAR(128) NOT NULL,
    percent_of_gage INTEGER
);

CREATE TABLE orchesters
(
    orchester_id               INTEGER PRIMARY KEY,
    name                       VARCHAR(128) NOT NULL,
    number_of_people           INTEGER,
    name_of_program            VARCHAR(128) NOT NULL,
    gage                       INTEGER,
    duration_of_concert_in_min INTEGER,
    manager_id_fk              INTEGER,
    FOREIGN KEY (manager_id_fk) REFERENCES managers (manager_id)
);

CREATE TABLE pianists
(
    pianist_id                 INTEGER PRIMARY KEY,
    name                       VARCHAR(128) NOT NULL,
    name_of_program            VARCHAR(128) NOT NULL,
    gage                       INTEGER,
    duration_of_concert_in_min INTEGER,
    mp_id_fk                   INTEGER,
    FOREIGN KEY (mp_id_fk) REFERENCES managers (manager_id)
);