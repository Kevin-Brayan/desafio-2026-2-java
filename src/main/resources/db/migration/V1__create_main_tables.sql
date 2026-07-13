CREATE TABLE aluno (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    ativo BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE curso (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tipo_documento (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE status (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    responsavel_id BIGINT NOT NULL,
    finaliza_solicitacao BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE solicitacao (
    id BIGINT NOT NULL AUTO_INCREMENT,
    aluno_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    tipo_id BIGINT NOT NULL,
    data_solicitacao DATETIME NOT NULL,
    data_alteracao DATETIME NOT NULL,
    status_id BIGINT NOT NULL,
    prioridade VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),

    CONSTRAINT fk_solicitacao_aluno
        FOREIGN KEY (aluno_id) REFERENCES aluno(id),

    CONSTRAINT fk_solicitacao_curso
        FOREIGN KEY (curso_id) REFERENCES curso(id),

    CONSTRAINT fk_solicitacao_tipo
        FOREIGN KEY (tipo_id) REFERENCES tipo_documento(id),

    CONSTRAINT fk_solicitacao_status
        FOREIGN KEY (status_id) REFERENCES status(id)
);