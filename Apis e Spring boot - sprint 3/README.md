# Sistema Acadêmico

Projeto desenvolvido para a disciplina de Desenvolvimento de APIs e Backend.

## Sprint 3 — DTOs e CRUD Completo

Nesta etapa foi implementado um CRUD completo para a entidade `Aluno`, utilizando Spring Boot, JPA, Hibernate e PostgreSQL.

Foram criados DTOs para separar os dados enviados e recebidos pela API da entidade salva no banco de dados.

## Estrutura utilizada

```text
Controller → Service → Repository → PostgreSQL
```

## Funcionalidades

- Criar aluno;
- Buscar aluno por ID;
- Atualizar aluno;
- Excluir aluno;
- Uso de `AlunoRequest` e `AlunoResponse`;
- Tratamento de `Optional` com `if/else`;
- Retornos HTTP `201`, `200`, `204` e `404`.

## Tecnologias

- Java 21;
- Spring Boot;
- Spring Data JPA;
- Hibernate;
- PostgreSQL;
- Maven.

## Como executar

1. Criar o banco PostgreSQL `sistema_academico`.
2. Configurar usuário e senha no arquivo `application.properties`.
3. Executar a classe `SistemaAcademicoApplication`.
4. Testar os endpoints pelo Postman ou Insomnia.

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/alunos` | Cria um aluno |
| GET | `/alunos/{id}` | Busca aluno por ID |
| PUT | `/alunos/{id}` | Atualiza aluno |
| DELETE | `/alunos/{id}` | Exclui aluno |