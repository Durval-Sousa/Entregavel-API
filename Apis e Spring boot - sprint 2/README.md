# Sistema Acadêmico

Projeto desenvolvido para a atividade de Desenvolvimento de APIs e Backend.

## Sprint 2

Na Sprint 2, a entidade foi integrada a uma API REST completa, organizada em camadas:

```text
Cliente → Controller → Service → Repository → PostgreSQL
```

Também foram implementados endpoints para cadastrar, listar, consultar e excluir cursos.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- DBeaver
- Postman

## Arquitetura do projeto

O projeto foi dividido nas seguintes camadas:

- `Entity`: representa a tabela `curso` do banco de dados.
- `Repository`: realiza o acesso aos dados utilizando `JpaRepository`.
- `Service`: concentra as operações da aplicação.
- `Controller`: disponibiliza os endpoints da API REST.

## Entidade criada

A entidade `Curso` possui os seguintes campos:

- `id`
- `descricao`
- `turno`

A entidade utiliza as anotações:

- `@Entity`
- `@Id`
- `@GeneratedValue`

## Repository

Foi criado o `CursoRepository`, que estende:

```java
JpaRepository<Curso, Long>
```

Com isso, a aplicação pode utilizar métodos prontos para salvar, listar, buscar e excluir cursos no banco de dados.

## Service

Foi criado o `CursoService`, responsável por realizar as operações da aplicação.

O service recebe o repository por injeção de dependência e utiliza seus métodos para:

- Listar todos os cursos;
- Buscar um curso por ID;
- Salvar um novo curso;
- Excluir um curso.

## Controller

Foi criado o `CursoController`, responsável por receber as requisições HTTP e retornar as respostas da API.

Foram utilizados:

- `@RestController`
- `@GetMapping`
- `@PostMapping`
- `@DeleteMapping`
- `@RequestBody`
- `@PathVariable`
- `@RequestParam`

## Endpoints da API

### Listar todos os cursos

```http
GET /cursos
```

### Buscar curso por ID

```http
GET /cursos/{id}
```

### Cadastrar curso

```http
POST /cursos
```

Exemplo de corpo da requisição:

```json
{
  "descricao": "Análise e Desenvolvimento de Sistemas",
  "turno": "Noturno"
}
```

### Buscar cursos por turno

```http
GET /cursos/buscar?turno=Noturno
```

### Excluir curso

```http
DELETE /cursos/{id}
```

### Consultar o RA do aluno

```http
GET /cursos/ra
```

Esse endpoint retorna uma frase com o nome e o RA do aluno.

## Configuração do banco

O projeto utiliza um banco PostgreSQL chamado:

```text
sistema_academico
```

A conexão é configurada no arquivo `application.properties`.

A tabela `curso` é criada ou atualizada automaticamente pelo Hibernate com a propriedade:

```properties
spring.jpa.hibernate.ddl-auto=update
```

A propriedade abaixo permite visualizar os comandos SQL no console da aplicação:

```properties
spring.jpa.show-sql=true
```

## Como executar

1. Clone o repositório.
2. Crie um banco PostgreSQL chamado `sistema_academico`.
3. Configure o usuário e a senha no arquivo `application.properties`.
4. Verifique se o PostgreSQL está em execução.
5. Execute a aplicação Spring Boot.
6. Utilize o Postman, Insomnia ou o navegador para testar os endpoints.
7. Verifique a tabela `curso` no PostgreSQL.

## Resultado esperado

Ao iniciar a aplicação, o Hibernate cria automaticamente a tabela `curso` com as colunas:

- `id`
- `descricao`
- `turno`

A API também deve permitir realizar operações de cadastro, consulta e exclusão de cursos utilizando o banco PostgreSQL.

## Funcionamento da aplicação

Quando o cliente envia uma requisição, o `Controller` recebe os dados e chama o `Service`.

O `Service` utiliza o `Repository`, que acessa o banco de dados por meio do JPA e do Hibernate.

Depois da operação, o resultado é devolvido ao cliente, normalmente em formato JSON.

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