CREATE TABLE cached_employee (
                          employee_id serial not null,
                          name varchar(20) not null,
                          surname varchar(20) not null,
                          salary numeric(7, 2) not null,
                          since timestamp with time zone not null,
                          primary key(employee_id)
);