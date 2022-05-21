create table if not exists game_board
(
    id bigserial not null
        constraint game_board_pkey
            primary key,
    name varchar(500),
    num_fields integer
);

alter table game_board owner to postgres;

create table if not exists game_boards_questions
(
    game_board_id bigint not null,
    question_id bigint not null,
    constraint game_boards_questions_pkey
        primary key (game_board_id, question_id)
);

alter table game_boards_questions owner to postgres;

create table if not exists products
(
    id bigserial not null
        constraint products_pkey
            primary key,
    colour varchar,
    name varchar
);

alter table products owner to postgres;

create table if not exists products_for_boards
(
    game_board_id bigint not null,
    product_id bigint not null,
    num_of_repeating integer,
    constraint products_for_boards_pkey
        primary key (game_board_id, product_id)
);

alter table products_for_boards owner to postgres;

create table if not exists questions
(
    id bigserial not null
        constraint questions_pkey
            primary key,
    answer varchar,
    type varchar(255),
    short_text varchar,
    text varchar,
    product_id bigint
        constraint fkdnt39hlm1bcye9ivenccipd5s
            references products
);

alter table questions owner to postgres;

create table if not exists sessions
(
    uuid uuid not null
        constraint sessions_pkey
            primary key,
    current_answer varchar,
    username varchar(255)
);

alter table sessions owner to postgres;

