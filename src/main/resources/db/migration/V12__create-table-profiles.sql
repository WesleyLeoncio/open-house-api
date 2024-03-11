CREATE TABLE profiles
(
    role_id          UUID       NOT NULL,
    usuario_id       UUID       NOT NULL,

    CONSTRAINT pk_profile
        PRIMARY KEY (role_id, usuario_id),
    CONSTRAINT fk_profile_role
        FOREIGN KEY (role_id) REFERENCES roles (id),
    CONSTRAINT fk_profile_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);
