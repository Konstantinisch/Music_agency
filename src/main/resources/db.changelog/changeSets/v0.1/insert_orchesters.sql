-- Insert test data into Orchester
INSERT INTO orchesters (orchester_id, name, number_of_people, name_of_program, gage, duration_of_concert_in_min,
                        manager_id_fk)
VALUES (1, 'London Symphony Orchestra', 80, 'Classical Masterpieces',
        10000, 180, 2);
INSERT INTO orchesters (orchester_id, name, number_of_people, name_of_program, gage, duration_of_concert_in_min,
                        manager_id_fk)
VALUES (2, 'Berlin Philharmonic', 90, 'Romantic Era', 12000,
        200, 2);
INSERT INTO orchesters (orchester_id, name, number_of_people, name_of_program, gage, duration_of_concert_in_min,
                        manager_id_fk)
VALUES (3, 'Vienna Philharmonic', 85, 'Mozart Specials', 11000,
        190, 2);