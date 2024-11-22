-- Create the Orchester table
CREATE TABLE orchesters
(
    orchester_id               INT PRIMARY KEY,
    name                       VARCHAR(64),
    number_of_people           INT,
    name_of_program            VARCHAR(64),
    gage                       INT,
    duration_of_concert_in_min INT
);

-- Create the Pianist table
CREATE TABLE pianists
(
    pianist_id                 INT PRIMARY KEY,
    name                       VARCHAR(64),
    name_of_program            VARCHAR(64),
    gage                       INT,
    duration_of_concert_in_min INT
);

-- Create the Manager table
CREATE TABLE managers
(
    manager_id      INT PRIMARY KEY,
    name            VARCHAR(64),
    percent_of_gage INT,
    orchester_id    INT,
    pianist_id      INT,
    FOREIGN KEY (orchester_id) REFERENCES Orchester (orchester_id),
    FOREIGN KEY (pianist_id) REFERENCES Pianist (pianist_id)
);