create table if not exists game_board
(
    id     bigserial not null
        constraint game_board_pkey
            primary key,
    colour varchar(255),
    name   varchar(255)
);

alter table game_board
    owner to postgres;

create table if not exists final_questions
(
    id      bigserial not null
        constraint final_questions_pkey
            primary key,
    answer        varchar(1500),
    text          varchar(5000),
    game_board_id bigint
        constraint fk4ajlropjfpguifbl3b1fispeh
            references game_board
);

alter table final_questions
    owner to postgres;

create table if not exists regular_questions
(
    id            bigserial not null
        constraint regular_questions_pkey
            primary key,
    answer        varchar(1500),
    type          varchar(255),
    text          varchar(5000),
    game_board_id bigint
        constraint fk1du07u8jpsa7f7ys7enc0n79i
            references game_board
);

alter table regular_questions
    owner to postgres;

create table if not exists sessions
(
    uuid           uuid not null
        constraint sessions_pkey
            primary key,
    current_answer varchar(1500),
    username       varchar(255)
);

alter table sessions
    owner to postgres;


