DROP TABLE IF EXISTS user_accounts;

CREATE TABLE user_accounts
  (
     id         LONG PRIMARY KEY,
     name       VARCHAR(150) NOT NULL,
     phone      LONG NOT NULL,
     email      VARCHAR(200) NOT NULL,
     address    VARCHAR(200),
     country    VARCHAR(56) NOT NULL,
     department VARCHAR(50) NOT NULL
  );