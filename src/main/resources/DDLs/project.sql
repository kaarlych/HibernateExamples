CREATE TABLE project (
    project_id serial not null,
    name varchar(64) not null,
    description text not null,
    deadline timestamp with time zone not null,
    primary key(project_id),
    unique(name)
);