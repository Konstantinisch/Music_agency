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