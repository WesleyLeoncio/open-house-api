CREATE TABLE usuarios
(
    id               SERIAL       NOT NULL,
    nome             VARCHAR(100) NOT NULL,
    login            VARCHAR(100) NOT NULL,
    senha            VARCHAR(100) NOT NULL,
    profile_id       INTEGER      NOT NULL,
    status           BOOLEAN      NOT NULL,

    CONSTRAINT pk_usuario
        PRIMARY KEY (id),
    CONSTRAINT fk_usuario_profile
        FOREIGN KEY (profile_id)
          REFERENCES profiles(id)
);