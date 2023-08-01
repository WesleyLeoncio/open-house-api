CREATE TABLE roles
(
    id               SERIAL       NOT NULL,
    nome             VARCHAR(100) NOT NULL UNIQUE,

    CONSTRAINT pk_role
        PRIMARY KEY (id)
);