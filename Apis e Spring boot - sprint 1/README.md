# Sistema Acadêmico

Projeto desenvolvido para a atividade de Desenvolvimento de APIs e Backend.

## Sprint 1

Nesta etapa foi criada a entidade JPA `Curso`, utilizando Spring Boot, Hibernate e PostgreSQL.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- DBeaver

## Entidade criada

A entidade `Curso` possui os seguintes campos:

- `id`
- `descricao`
- `turno`

## Configuração do banco

O projeto utiliza um banco PostgreSQL chamado:

```text
sistema_academico
```

A tabela `curso` é criada automaticamente pelo Hibernate com a propriedade:

```properties
spring.jpa.hibernate.ddl-auto=update
```

## Como executar

1. Clone o repositório.
2. Crie um banco PostgreSQL chamado `sistema_academico`.
3. Configure o usuário e a senha no arquivo `application.properties`.
4. Execute a aplicação Spring Boot.
5. Verifique a tabela `curso` no PostgreSQL.

## Resultado esperado

Ao iniciar a aplicação, o Hibernate cria automaticamente a tabela `curso` com as colunas:

- `id`
- `descricao`
- `turno`