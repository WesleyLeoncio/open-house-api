CREATE TABLE avaliacoes
(
    filme_id     UUID         NOT NULL,
    usuario_id   UUID         NOT NULL,
    nota         INTEGER      NOT NULL,

    CONSTRAINT pk_avaliacao
      PRIMARY KEY (filme_id, usuario_id),
    CONSTRAINT fk_avaliacao_filme_id
      FOREIGN KEY(filme_id)
        REFERENCES filmes(id),
    CONSTRAINT fk_avaliacao_usuario_id
      FOREIGN KEY(usuario_id)
        REFERENCES usuarios(id)
);