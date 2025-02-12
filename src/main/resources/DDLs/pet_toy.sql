CREATE TABLE pet_toy
(
    pet_toy_id SERIAL,
    pet_id     SERIAL NOT NULL,
    toy_id     SERIAL NOT NULL,
    CONSTRAINT fk_pet_toy_pet
        FOREIGN KEY (pet_id)
            REFERENCES pet (pet_id),
    CONSTRAINT fk_pet_toy_toy
        FOREIGN KEY (toy_id)
            REFERENCES toy (toy_id)
);