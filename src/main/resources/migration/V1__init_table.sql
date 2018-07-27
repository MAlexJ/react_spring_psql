-- -----------------------------------------------------
-- Table userTable
-- -----------------------------------------------------
CREATE TABLE app.user (
  userId    SERIAL PRIMARY KEY,
  firstName VARCHAR(20),
  lastName  VARCHAR(20),
  bithData  DATE,
  gender    VARCHAR(6)
);