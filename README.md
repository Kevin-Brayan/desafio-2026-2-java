# Desafio TI DEV UNOESC 2026/2

Sistema desenvolvido como solução para o Desafio TI DEV UNOESC 2026/2 utilizando Java, Spring Boot, Spring Security, Thymeleaf, Flyway e MySQL.

O sistema permite o gerenciamento de solicitações de documentos acadêmicos, disponibilizando uma interface web e uma API REST para cadastro, consulta e geração de estatísticas.

---

# Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT
- Thymeleaf
- Flyway
- MySQL
- Maven
- Bootstrap 5

---

# Estrutura do projeto

```
src/main/java
├── config
├── controller
│   ├── api
│   └── view
├── dto
├── entity
├── enums
├── mapper
├── repository
└── service
```

---

# Pré-requisitos

Antes de executar a aplicação é necessário possuir:

- Java 21
- Maven 3.9+
- MySQL Server

---

# Configuração do banco

Crie um banco vazio no MySQL.

Exemplo:

```sql
CREATE DATABASE desafio2026;
```

Depois configure o arquivo

```
src/main/resources/application.properties
```

alterando os dados de conexão:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/desafio2026
spring.datasource.username=root
spring.datasource.password=sua_senha
```

---

# Flyway

As tabelas são criadas automaticamente através do Flyway.

As migrations encontram-se em:

```
src/main/resources/db/migration
```

Não é necessário executar nenhum script manualmente.

---

# Executando a aplicação

Na raiz do projeto execute:

Linux

```bash
./mvnw spring-boot:run
```

Windows

```cmd
mvnw.cmd spring-boot:run
```

ou

```bash
mvn clean install
```

seguido de

```bash
mvn spring-boot:run
```

A aplicação será iniciada em

```
http://localhost:8080
```

---

# Autenticação

O sistema utiliza autenticação baseada em JWT.

Após realizar login é criado um cookie HttpOnly contendo o token JWT utilizado nas requisições autenticadas.

---

# Interface Web

Após iniciar a aplicação, as principais páginas disponíveis são:

| Página | URL |
|---------|-----|
| Login | `/auth/login` |
| Cadastro | `/auth/register` |
| Dashboard | `/dashboard` |
| Solicitações | `/solicitacoes` |
| Nova solicitação | `/solicitacoes/nova` |

---

# Endpoints da API

## Autenticação

### Registrar usuário

```
POST /auth/register
```

### Login

```
POST /auth/login
```

---

## Alunos

Cadastrar aluno

```
POST /aluno/cadastrar
```

---

## Cursos

Cadastrar curso

```
POST /curso/cadastrar
```

---

## Status

Cadastrar status

```
POST /status/cadastrar
```

---

## Tipos de Documento

Cadastrar tipo de documento

```
POST /tipoDocumento/cadastrar
```

---

## Solicitações

Cadastrar

```
POST /solicitacao/cadastrar
```

Listar

```
GET /solicitacao/listar
```

Parâmetros opcionais:

| parâmetro | descrição |
|-----------|-----------|
| aluno | nome do aluno |
| curso | nome do curso |
| status | nome do status |
| tipoDocumento | tipo do documento |
| inicio | data inicial |
| fim | data final |
| page | página |
| size | quantidade por página |

---

Alterar status

```
PATCH /solicitacao/status
```

---

# Estatísticas

Solicitações por status

```
GET /solicitacao/estatisticas/status
```

Solicitações por período

```
GET /solicitacao/estatisticas/periodo
```

Documentos mais solicitados

```
GET /solicitacao/estatisticas/documentos-mais-solicitados
```

Tempo médio de emissão

```
GET /solicitacao/estatisticas/media
```

---

# Funcionalidades

- Cadastro de usuários
- Login com JWT
- Cadastro de alunos
- Cadastro de cursos
- Cadastro de status
- Cadastro de tipos de documento
- Cadastro de solicitações
- Consulta paginada
- Filtros por aluno, curso, status, documento e período
- Dashboard com estatísticas
- Alteração de status da solicitação

---

# Licença

Este projeto foi desenvolvido para fins acadêmicos como parte do Desafio TI DEV UNOESC 2026/2.
