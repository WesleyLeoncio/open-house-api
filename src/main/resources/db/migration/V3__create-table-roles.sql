CREATE TABLE roles
(
    id               UUID         NOT NULL DEFAULT uuid_generate_v4(),
    nome             VARCHAR(100) NOT NULL UNIQUE,

    CONSTRAINT pk_role
        PRIMARY KEY (id)
);