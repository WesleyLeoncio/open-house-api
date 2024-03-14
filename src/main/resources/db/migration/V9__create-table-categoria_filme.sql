CREATE TABLE categoria_filme
(
    categoria_id   uuid         NOT NULL,
    filme_id       uuid         NOT NULL,

    CONSTRAINT pk_categoria_filme
        PRIMARY KEY (categoria_id, filme_id),
    CONSTRAINT fk_categoria
        FOREIGN KEY (categoria_id) REFERENCES categorias (id),
    CONSTRAINT fk_filme
        FOREIGN KEY (filme_id) REFERENCES filmes (id)
);