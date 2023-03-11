insert into employees (employee_id, first_name,last_name,email,phone_number,hire_date,salary,manager_id,department_id)
values(1,'Juan','Lebron','lobo@wpt.com','010000000','2018-10-20',5000,null,1);
insert into employees (employee_id, first_name,last_name,email,phone_number,hire_date,salary,manager_id,department_id)
values(2,'Ale','Galan','galan@wpt.com','010000000','2018-10-20',5000,null,2);
insert into employees (employee_id, first_name,last_name,email,phone_number,hire_date,salary,manager_id,department_id)
values(3,'Aug','Tapia','tapia@wpt.com','010000000','2018-10-20',5000,null,3);

ALTER SEQUENCE employee_id_sequence RESTART WITH 4;

insert into departments (department_id, department_name,manager_id) values (1,'HR',1);
insert into departments (department_id,department_name,manager_id) values (2,'QC',2);
insert into departments (department_id,department_name,manager_id) values (3,'InfoSec',3);

ALTER SEQUENCE department_id_sequence RESTART WITH 4;
