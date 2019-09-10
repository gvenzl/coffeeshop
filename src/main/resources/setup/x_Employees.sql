DROP TABLE EMPLOYEES;
CREATE TABLE EMPLOYEES (
  first_name   VARCHAR2(255),
  last_name    VARCHAR2(255),
  city         VARCHAR(25),
  state        VARCHAR(25)
);


INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Sarah', 'Connor', 'New York', 'NY');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Hermann', 'Cuttlery', 'New York', 'NY');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Marco', 'Franco', 'New York', 'NY');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Sebastian', 'Ellis', 'Boston', 'MA');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('George', 'Federick', 'Boston', 'MA');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Allan', 'Secoya', 'Boston', 'MA');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('William', 'Sorrento', 'Washington', 'DC');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Alac', 'McClaflin', 'Washington', 'DC');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Eric', 'Baldron', 'Washington', 'DC');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Gerald', 'Baer', 'San Francisco', 'CA');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Maria', 'Boldon', 'San Francisco', 'CA');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Allison', 'Swartz', 'San Francisco', 'CA');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Stacey', 'Venzl', 'Los Angeles', 'CA');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Lucy', 'Granger', 'Los Angeles', 'CA');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Angelina', 'Heinrich', 'Los Angeles', 'CA');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Adrian', 'Morris', 'Philadelphia', 'PA');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Penny', 'Mayer', 'Philadelphia', 'PA');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Stuart', 'Ernesto', 'Philadelpia', 'PA');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Daniel', 'Dienst', 'Chicago', 'IL');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Emma', 'Marcus', 'Chicago', 'IL');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Ronald', 'Radcliff', 'Chicago', 'IL');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Lorea', 'Ibiza', 'Dallas', 'TX');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('Loic', 'Smith', 'Dallas', 'TX');
INSERT INTO EMPLOYEES (first_name, last_name, city, state) VALUES ('George', 'Raddison', 'Dallas', 'TX');
COMMIT;