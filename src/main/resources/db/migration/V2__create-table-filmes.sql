CREATE TABLE filmes
(
    id               UUID         NOT NULL DEFAULT uuid_generate_v4(),
    nome             VARCHAR(100) NOT NULL,
    descricao        VARCHAR(100) NOT NULL,
    data_lancamento  DATE    NOT NULL,
    duracao          VARCHAR(50) NOT NULL,
    imagem           VARCHAR(100) NOT NULL,
    categoria        VARCHAR(100) NOT NULL,

    CONSTRAINT pk_filme
        PRIMARY KEY (id)
);