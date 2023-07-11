CREATE TABLE profiles
(
    id               SERIAL       NOT NULL,
    nome             VARCHAR(100) NOT NULL UNIQUE,

    CONSTRAINT pk_profile
        PRIMARY KEY (id)
);