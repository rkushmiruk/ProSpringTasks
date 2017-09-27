
CREATE TABLE "CONTACT" (
  "ID" INT NOT NULL AUTO_INCREMENT ,
  "FIRST_NAME" VARCHAR(60) NOT NULL,
  "LAST_NAME" VARCHAR(40) NOT NULL,
  "BIRTH_DATE" DATE,
  PRIMARY KEY("ID"),
  UNIQUE "UQ_CONTACT_1"  ("FIRST_NAME", "LAST_NAME"));

CREATE TABLE "CONTACT_TEL_DETAIL" (
  "ID" INT NOT NULL AUTO_INCREMENT,
  "CONTACT_ID" INT NOT NULL,
  "TEL_TYPE" VARCHAR(20)  NOT NULL,
  "TEL_NUMBER" VARCHAR(20) NOT NULL,
  UNIQUE "UQ_CONTACT_TEL_DETAIL_1" ("CONTACT_ID","TEL_TYPE"),
  PRIMARY KEY("ID"),
  CONSTRAINT FK_CONTACT_TEL_DETAIL_CONTACT FOREIGN KEY ("CONTACT_ID")
  REFERENCES CONTACT ("ID")
);

