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