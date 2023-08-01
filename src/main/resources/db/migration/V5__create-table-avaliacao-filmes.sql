CREATE TABLE avaliacoes
(
    id            SERIAL      NOT NULL,
    filme_id     INTEGER      NOT NULL,
    usuario_id   INTEGER      NOT NULL,
    nota         INTEGER      NOT NULL,

    CONSTRAINT pk_avaliacao
      PRIMARY KEY (id),
    CONSTRAINT fk_avaliacao_filme_id
      FOREIGN KEY(filme_id)
        REFERENCES filmes(id),
    CONSTRAINT fk_avaliacao_usuario_id
      FOREIGN KEY(usuario_id)
        REFERENCES usuarios(id)
);