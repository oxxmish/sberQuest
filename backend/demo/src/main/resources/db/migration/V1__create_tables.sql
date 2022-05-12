-- auto-generated definition
create table if not exists products
(
    id     bigserial not null
        constraint products_pkey
            primary key,
    colour varchar(255),
    name   varchar(255)
);

alter table products
    owner to postgres;



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
    text          varchar(2000),
    short_text          varchar(2000),
    product_id    bigint
        constraint fkgruqk22d9nl42xwbt855fvvux
            references products,
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
    current_state jsonb,
    username       varchar(255)
);

alter table sessions
    owner to postgres;


