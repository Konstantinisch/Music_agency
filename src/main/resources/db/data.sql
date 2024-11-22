-- Insert test data into Orchester
INSERT INTO orchesters (orchester_id, name, number_of_people, name_of_program, gage, duration_of_concert_in_min)
VALUES (1, 'London Symphony Orchestra', 80, 'Classical Masterpieces', 10000, 180),
       (2, 'Berlin Philharmonic', 90, 'Romantic Era', 12000, 200),
       (3, 'Vienna Philharmonic', 85, 'Mozart Specials', 11000, 190);

-- Insert test data into Pianist
INSERT INTO pianists (pianist_id, name, name_of_program, gage, duration_of_concert_in_min)
VALUES (1, 'Lang Lang', 'Chopin Recital', 5000, 90),
       (2, 'Yuja Wang', 'Rachmaninoff Concertos', 6000, 100),
       (3, 'Martha Argerich', 'Beethoven Sonatas', 5500, 95);

-- Insert test data into Manager
INSERT INTO managers (manager_id, name, percent_of_gage, orchester_id, pianist_id)
VALUES (1, 'Alice Brown', 10, 1, 1),
       (2, 'Bob Smith', 12, 2, 2),
       (3, 'Carol Johnson', 15, 3, 3);