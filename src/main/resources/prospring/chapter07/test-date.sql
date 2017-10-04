INSERT INTO CONTACT (FIRST_NAME,LAST_NAME,BIRTH_DATE) VALUES
('Chris','Shaefer',TO_DATE('1989-12-09','YYYY-MM-DD'));
INSERT INTO CONTACT (FIRST_NAME,LAST_NAME,BIRTH_DATE) VALUES
('Roman','Kushmyruk',TO_DATE('1994-10-23','YYYY-MM-DD'));
INSERT INTO CONTACT (FIRST_NAME,LAST_NAME,BIRTH_DATE) VALUES
('John ','Smith',TO_DATE('1964-02-28','YYYY-MM-DD'));

INSERT INTO CONTACT_TEL_DETAIL (CONTACT_ID,TEL_TYPE,TEL_NUMBER)VALUES
(1,'Mobile','1234567890');
INSERT INTO CONTACT_TEL_DETAIL (CONTACT_ID,TEL_TYPE,TEL_NUMBER)VALUES
(1,'Home','3806339594');
INSERT INTO CONTACT_TEL_DETAIL (CONTACT_ID,TEL_TYPE,TEL_NUMBER)VALUES
(2,'Home','3809941412');


INSERT INTO HOBBY (hobby_id) values ('Swimming');
INSERT INTO HOBBY (hobby_id) values ('Jogging');
INSERT INTO HOBBY (hobby_id) values ('Programming');
INSERT INTO HOBBY (hobby_id) values ('Movies');
INSERT INTO HOBBY (hobby_id) values ('Reading');

INSERT INTO CONTACT_HOBBY_DETAIL(CONTACT_ID,HOBBY_ID) values (1, 'Swimming');
INSERT INTO CONTACT_HOBBY_DETAIL(CONTACT_ID,HOBBY_ID) values (1, 'Movies');
INSERT INTO CONTACT_HOBBY_DETAIL(CONTACT_ID,HOBBY_ID) values (2, 'Swimming');