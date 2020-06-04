DROP TABLE IF EXISTS answer;

create table answer (
    id bigserial not null,
    answer_value varchar(255) not null,
    is_correct bool not null default false,
    question_id int8,
    primary key (id)
);

DROP TABLE IF EXISTS question;

create table question (
    id  bigserial not null,
    question_value varchar(255) not null,
    quiz_id int8,
    primary key (id)
);

DROP TABLE IF EXISTS quiz;

create table quiz (
    id  bigserial not null,
    quiz_name varchar(255) not null,
    primary key (id)
);

DROP TABLE IF EXISTS user_table;

create table user_table (
    id  bigserial not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    primary key (id)
);

DROP TABLE IF EXISTS user_role;

create table user_role (
    user_table_id int8 not null,
    role varchar(255) not null
);

alter table if exists answer add constraint fk_answer_question_id foreign key (question_id) references question;
alter table if exists question add constraint fk_question_quiz_id foreign key (quiz_id) references quiz;
alter table if exists user_role add constraint fk_user_role_user_table_id foreign key (user_table_id) references user_table;


