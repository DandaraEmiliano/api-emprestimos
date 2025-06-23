# 📚 API de Empréstimos

API RESTful para cadastro, consulta, atualização e remoção de empréstimos entre clientes, com validações e controle completo do ciclo de vida dos registros.

---

## 🚀 Tecnologias

- Java 17
- Spring Boot 3.2.5
- Spring Web (MVC)
- Spring Data JPA
- PostgreSQL
- Lombok
- Bean Validation
- Spring Boot DevTools
- Springdoc OpenAPI (Swagger UI)

---

## 🔧 Requisitos

- Java 17 instalado
- PostgreSQL rodando
- Maven 3.8+ instalado

---

## ⚙️ Configuração

### 1. Banco de dados

Crie o banco no PostgreSQL:

```sql
CREATE DATABASE emprestimosdb;
```

### 2. `application.properties`

Atualize as credenciais:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/emprestimosdb
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

---

## ▶️ Rodando a aplicação

```bash
./mvnw spring-boot:run
```

Ou no IntelliJ: `Run > EmprestimosApplication.java`

---

## 📮 Endpoints principais

| Método | Endpoint            | Descrição                     |
|--------|---------------------|-------------------------------|
| POST   | /emprestimos        | Criar novo empréstimo         |
| GET    | /emprestimos        | Listar todos os empréstimos  |
| GET    | /emprestimos/{id}   | Buscar empréstimo por ID     |
| PUT    | /emprestimos/{id}   | Atualizar empréstimo         |
| DELETE | /emprestimos/{id}   | Deletar empréstimo           |

---

## 📑 Documentação Swagger

Acesse:

```
http://localhost:8080/swagger-ui.html
```

---

## ✅ Validações

- Cliente: obrigatório
- Valor: obrigatório e maior que 0
- Datas de empréstimo e devolução: obrigatórias

---

## 🧠 Padrões adotados

- Padrão MVC
- Separação por DTO
- Tratamento de exceções com `@RestControllerAdvice`
- Boas práticas: SOLID, Clean Code

---

## 📁 Estrutura do projeto

```
com.project.emprestimos
├── controller
├── dto
├── exception
├── model
├── repository
├── service
└── EmprestimosApplication.java
```

---

## 👩🏻‍💻 Autora

**Dandara Emiliano**  
[GitHub](https://github.com/DandaraEmiliano) · [LinkedIn](https://linkedin.com/in/dandaraemiliano)

---

## 📝 Licença

Este projeto está sob a licença MIT.
