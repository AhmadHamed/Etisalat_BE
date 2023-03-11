CREATE SEQUENCE department_id_sequence
INCREMENT BY 1;

CREATE TABLE departments
(department_id NUMBER(4) primary key,
department_name VARCHAR2(30),
manager_id NUMBER(6));


CREATE SEQUENCE employee_id_sequence
INCREMENT BY 1;

CREATE TABLE employees
(employee_id NUMBER(6) primary key,
first_name VARCHAR2(20),
last_name VARCHAR2(25),
email VARCHAR2(25),
phone_number VARCHAR2(20),
hire_date DATE,
salary NUMBER(8,2),
manager_id NUMBER(6),
department_id NUMBER(4));

