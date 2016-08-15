INSERT INTO DEPARTAMENTS VALUES (0, 'Informatyka'), (1, 'Elektronika');
INSERT INTO STUDENTS VALUES (0, 'Koszalin', '1995-05-17 23:12:23', 123543123, 'Piotr ', 'Kamiński', 'U-1000'),
  (1, 'Kołobrzeg', '1991-02-05 03:26:04', 654345567, 'Szymon', 'Tomczak', 'U-1001'),
  (2, 'Koszalin', '1992-12-19 12:34:03', 456565654, 'Kacper', 'Wójcik', 'U-1002'),
  (3, 'Kołobrzeg', '1992-01-29 03:12:24', 767676865, 'Mateusz', 'Nowak', 'U-1003'),
  (4, 'Koszalin', '1993-04-19 00:56:30', 453463463, 'Michał', 'Jabłoński', 'U-1004'),
  (5, 'Słupsk', '1990-07-02 08:46:28', 765674563, 'Maciej', 'Kurek', 'U-1005'),
  (6, 'Sianów', '1991-08-19 17:25:53', 654576564, 'Jakub', 'Czyż', 'U-1006'),
  (7, 'Słupsk', '1994-06-08 13:37:49', 345345345, 'Wojciech', 'Wróbel', 'U-1007'),
  (8, 'Koszalin', '1991-09-08 22:44:07', 654765745, 'Maciej', 'Białek', 'U-1008'),
  (9, 'Kołobrzeg', '1990-12-19 13:47:48', 234234234, 'Mikołaj', 'Górski', 'U-1009'),
  (10, 'Koszalin', '1993-08-15 11:37:56', 543534534, 'Michał', 'Piotrowski', 'U-1010'),
  (11, 'Sianów', '1995-08-02 01:32:53', 654746753, 'Jan', 'Nowak', 'U-1011'),
  (12, 'Koszalin', '1994-07-28 12:41:35', 654564563, 'Eryk', 'Olszewski', 'U-1012'),
  (13, 'Sianów', '1991-11-21 04:49:35', 345345345, 'Mikołaj', 'Marczak', 'U-1013'),
  (14, 'Słupsk', '1993-04-17 06:32:29', 654645645, 'Franciszek', 'Zając', 'U-1014'),
  (15, 'Kołobrzeg', '1992-10-30 01:58:15', 345345675, 'Michał', 'Marzec', 'U-1015'),
  (16, 'Sianów', '1990-05-14 10:18:54', 345345235, 'Maciej', 'Krawczyk', 'U-1016'),
  (17, 'Kołobrzeg', '1990-12-08 12:58:17', 987456345, 'Jan', 'Marek', 'U-1017'),
  (18, 'Sianów', '1993-09-05 05:23:27', 234235623, 'Oliwier', 'Jabłońska', 'U-1018'),
  (19, 'Koszalin', '1991-03-16 01:22:47', 435452334, 'Michał', 'Adamski', 'U-1019'),
  (20, 'Słupsk', '1995-07-25 02:20:03', 654654345, 'Eryk', 'Król', 'U-1020');
INSERT INTO LECTURERS VALUES (0, 'Profesor', 'Jan', 'Kowalski', 0), (1, 'Profesor', 'Jerzy', 'Jurek', 0),
  (2, 'Magister', 'Janina', 'Jaśko', 0), (3, 'Doktorant', 'Piotr', 'Wąs', 1), (4, 'Inżynier', 'Hanna', 'Polko', 1),
  (5, 'Profesor', 'Edward', 'Zimny', 1);
INSERT INTO ACCOUNTS VALUES (0, 'test', 'test', NULL, 0), (1, 'test1', 'test1', 0, NULL);
INSERT INTO SUBJECTS
VALUES (0, 30, 'Programowanie', 0), (1, 15, 'Zast. programowania', 1), (2, 30, 'Mikroprocesory', 2),
  (3, 15, 'Konstrukcja maszyn', 3), (4, 30, 'Materiałoznastwo', 4), (5, 15, 'Urządzenia cyfrowe', 5);
INSERT INTO GRADES (GRADE_ID, GRADE, STUDENT_ID, SUBJECT_ID, DESCRIPTION)
VALUES (0, 2, 0, 0, 'test1'), (1, 3, 0, 0, 'test2'), (2, 4, 0, 0, 'test3'), (3, 5, 0, 1, 'test4'),
  (4, 3, 0, 1, 'test5'), (5, 2, 0, 2, 'test6'), (6, 3, 0, 2, 'test7'), (7, 4, NULL, NULL, 'test8'),
  (8, 5, NULL, NULL, 'test9'), (9, 3, NULL, NULL, 'test10'), (10, 2, NULL, NULL, 'test11');
INSERT INTO TOPICS
VALUES (0, 'Sklep Muzyczny'), (1, 'Dziennik Ocen'), (2, 'Sklep Zoologiczny'), (3, 'Aplikacja do testowania'),
  (4, 'Sterownik akwarium'), (5, 'Sterownik oświetlenia'), (6, 'Sterownik jakiśtam');
INSERT INTO GROUPS VALUES (0, 1, 0), (1, 1, 1), (2, 1, 2), (3, 1, 3), (4, 3, 4), (5, 3, 5), (6, 5, 6);
INSERT INTO SEMESTERS
VALUES (0, 1, 2015, 0), (1, 2, 2016, 0), (2, 1, 2015, 1), (3, 2, 2016, 1), (4, 1, 2014, 0), (5, 2, 2015, 0);
INSERT INTO STUDENTS_GROUPS
VALUES (0, 0), (1, 0), (2, 0), (3, 1), (4, 1), (5, 1), (6, 2), (7, 2), (8, 2), (9, 2), (10, 2), (11, 2), (12, 3),
  (13, 3), (14, 3), (15, 3), (16, 3), (17, 3), (18, 4), (19, 5), (20, 6);
INSERT INTO STUDENTS_SEMESTERS
VALUES (0, 0), (0, 1), (0, 2), (0, 3), (0, 4), (0, 5), (0, 6), (0, 7), (0, 8), (0, 9), (0, 10), (0, 11), (0, 12),
  (0, 13), (0, 14), (0, 15), (0, 16), (0, 17), (1, 0), (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8),
  (1, 9), (1, 10), (1, 11), (1, 12), (1, 13), (1, 14), (1, 15), (1, 16), (1, 17);