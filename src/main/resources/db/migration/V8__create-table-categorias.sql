CREATE TABLE categorias
(
    id               uuid         NOT NULL DEFAULT uuid_generate_v4(),
    nome             VARCHAR(100) NOT NULL UNIQUE,

    CONSTRAINT pk_categoria
        PRIMARY KEY (id)
);