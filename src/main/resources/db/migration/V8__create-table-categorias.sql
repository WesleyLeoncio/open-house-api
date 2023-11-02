CREATE TABLE categorias
(
    id               SERIAL       NOT NULL,
    nome             VARCHAR(100) NOT NULL UNIQUE,

    CONSTRAINT pk_categoria
        PRIMARY KEY (id)
);