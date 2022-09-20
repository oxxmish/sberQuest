create table if not exists game_entity
(
    id              bigserial primary key,
    game_state      varchar,
    name            varchar(255),
    date            timestamp without time zone,
    welcome_message varchar(500)
);

create table if not exists game_entity_leaders
(
    game_entity_id bigint not null
        constraint fk8vr44nftwqca3uh6jys08sunw
            references game_entity,
    leaders_id     bigint not null
        constraint uk_rs2y7lctm4yt6dlfgly2gdp07
            unique
        constraint fkt09dh9uuk85y5p0jrcx10p9qg
            references users
);
