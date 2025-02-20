create table event (
    event_id SERIAL NOT NULL,
    event_name VARCHAR(50) NOT NULL,
    date_time TIMESTAMP WITH TIME ZONE NOT NULL,
    capacity INTEGER NOT NULL,
    version INTEGER NOT NULL,
    primary key(event_id),
    unique (event_name)
);

create table ticket (
    ticket_id SERIAL NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    event_id INTEGER NOT NULL,
    primary key(ticket_id),
    constraint fk_ticket_event
        foreign key (event_id)
            references event(event_id)
)