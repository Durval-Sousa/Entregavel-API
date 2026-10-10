# Sistema Acadêmico

Projeto desenvolvido para a disciplina de Desenvolvimento de APIs e Backend.

## Sprint 4 — PUT, DELETE e Lombok

Nesta etapa foram implementadas e revisadas as operações de atualização e remoção de alunos na API REST.

Também foi utilizado o Lombok para reduzir códigos repetitivos, como getters, setters e construtores.

## Estrutura utilizada

```text
Cliente
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
PostgreSQL
```

## Funcionalidades implementadas

- Atualização de aluno com `PUT`;
- Exclusão de aluno com `DELETE`;
- Verificação de aluno existente antes de excluir;
- Tratamento de erro para ID inexistente;
- Uso de `findById().orElseThrow()` no método de atualização;
- Uso de `existsById()` no método de exclusão;
- Uso de DTOs para separar os dados da API da entidade do banco;
- Uso de `ResponseEntity` para controlar as respostas HTTP;
- Uso do Lombok para gerar getters, setters e construtores.

## Lombok

Foram utilizadas as anotações:

```java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
```

Essas anotações geram automaticamente getters, setters, construtor vazio e construtor com todos os campos, reduzindo código repetitivo. [373]

## Endpoints

### Atualizar aluno

```http
PUT /alunos/{id}
```

Exemplo:

```http
PUT http://localhost:8080/alunos/1
Content-Type: application/json
```

Body:

```json
{
  "nome": "Maria Silva Santos",
  "ra": "202600123"
}
```

Resposta esperada:

```text
204 No Content
```

### Excluir aluno

```http
DELETE /alunos/{id}
```

Exemplo:

```http
DELETE http://localhost:8080/alunos/1
```

Resposta esperada:

```text
204 No Content
```

Caso o aluno não exista, a aplicação lança uma exceção informando que o registro não foi encontrado.

O status `204 No Content` significa que a operação foi concluída com sucesso, mas não há corpo para devolver na resposta. [372][376]

## Tecnologias utilizadas

- Java 21;
- Spring Boot;
- Spring Data JPA;
- Hibernate;
- PostgreSQL;
- Lombok;
- Maven;
- DBeaver;
- Postman ou Insomnia.

## Como executar

1. Criar o banco PostgreSQL chamado `sistema_academico`.
2. Configurar usuário e senha no arquivo `application.properties`.
3. Executar a classe `SistemaAcademicoApplication`.
4. Testar os endpoints pelo Postman ou Insomnia.

## Resultado da Sprint 4

Ao finalizar esta etapa, a API possui:

- CRUD de alunos;
- DTOs `AlunoRequest` e `AlunoResponse`;
- Atualização com `PUT`;
- Exclusão com `DELETE`;
- Retorno HTTP `204 No Content`;
- Verificação de existência antes da exclusão;
- Tratamento para IDs inexistentes;
- Uso de Lombok para reduzir código boilerplate;
- Persistência de dados no PostgreSQL.