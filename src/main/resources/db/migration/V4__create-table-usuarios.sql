CREATE TABLE usuarios
(
    id               UUID         NOT NULL DEFAULT uuid_generate_v4(),
    nome             VARCHAR(100) NOT NULL,
    login            VARCHAR(100) NOT NULL,
    senha            VARCHAR(100) NOT NULL,
    status           BOOLEAN      NOT NULL,

    CONSTRAINT pk_usuario
        PRIMARY KEY (id)
);