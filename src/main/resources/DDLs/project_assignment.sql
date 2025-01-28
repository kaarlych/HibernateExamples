create table project_assignment (
    project_assignment_id serial not null,
    employee_id int not null,
    project_id int not null,
    primary key (project_assignment_id),
    constraint fk_project_assignment_employee
                                foreign key (employee_id)
                                references employee (employee_id),
    constraint fk_project_assignment_project
                                foreign key (project_id)
                                references project (project_id)
);