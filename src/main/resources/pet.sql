CREATE TABLE pet (
    pet_id serial not null,
    name varchar(32) not null,
    breed varchar(32) not null,
    owner_id int not null,
    primary key (pet_id),
    constraint fk_pet_owner
                 foreign key (owner_id)
                 references owner (owner_id)
);