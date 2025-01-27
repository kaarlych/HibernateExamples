CREATE TABLE owner (
    owner_id SERIAL NOT NULL,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    phone varchar(32) NOT NULL,
    email varchar(32) not null,
    primary key (owner_id)
);