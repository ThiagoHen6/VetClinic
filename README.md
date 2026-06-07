# 🐾 VetClinic API

API REST para gerenciamento de clínica veterinária, desenvolvida com Spring Boot.

## 📋 Sobre o Projeto

O VetClinic permite o cadastro de tutores e seus pets, além de agendamento de consultas com validações de negócio, como verificação de disponibilidade do veterinário e compatibilidade de especialidade com o tipo de animal.

## ✨ Funcionalidades

- Cadastro de **Tutores** com endereço
- Cadastro de **Animais** vinculados a um tutor
- Cadastro de **Veterinários** com especialidades por tipo de animal
- **Agendamento de Consultas** com as seguintes validações:
  - Verifica se o veterinário está disponível no horário solicitado
  - Verifica se o animal pertence ao tutor informado
  - Verifica se o veterinário possui especialidade para o tipo de animal
- Atualização de **status da consulta** (AGENDADA, CONCLUIDA, CANCELADA)
- Documentação interativa dos endpoints via **Swagger UI**

## 🐶 Tipos de Animal Suportados

- Cachorro
- Gato
- Réptil
- Pássaro

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Swagger / OpenAPI 3**
- **Bean Validation**

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```
controller  →  service  →  repository  →  banco de dados
     ↕              ↕
    DTO          entities
     ↕
  mapper
```

- **Controllers** — recebem as requisições HTTP e retornam respostas
- **Services** — contêm as regras de negócio
- **Repositories** — acesso ao banco de dados via Spring Data JPA
- **DTOs** — objetos de transferência de dados (Request e Response separados)
- **Mappers** — conversão entre entidades e DTOs
- **GlobalExceptionHandler** — tratamento centralizado de exceções via `@ControllerAdvice`

## 📡 Endpoints

### Tutor
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/tutores` | Cadastrar tutor |
| GET | `/tutores` | Listar tutores |
| GET | `/tutores/{id}` | Buscar tutor por ID |
| PUT | `/tutores/{id}` | Atualizar tutor |
| DELETE | `/tutores/{id}` | Remover tutor |

### Animal
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/tutores/{tutorId}/animais` | Cadastrar animal |
| GET | `/tutores/{tutorId}/animais` | Listar animais do tutor |
| PUT | `/tutores/{tutorId}/animais/{id}` | Atualizar animal |
| DELETE | `/tutores/{tutorId}/animais/{id}` | Remover animal |

### Veterinário
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/veterinarios` | Cadastrar veterinário |
| GET | `/veterinarios` | Listar veterinários |
| PUT | `/veterinarios/{id}` | Atualizar veterinário |
| DELETE | `/veterinarios/{id}` | Remover veterinário |

### Consulta
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/consultas` | Agendar consulta |
| GET | `/consultas` | Listar consultas |
| PUT | `/consultas/{id}/status` | Atualizar status da consulta |

## 🚀 Como Executar

### Pré-requisitos
- Java 21+
- MySQL
- Maven

### Configuração

1. Clone o repositório:
```bash
git clone https://github.com/ThiagoHen6/VetClinic.git
cd VetClinic
```

2. Configure o banco de dados em `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vetclinic
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

4. Acesse a documentação Swagger:
```
http://localhost:8080/swagger-ui/index.html
```

## 👨‍💻 Autor

Feito por [Thiago](https://github.com/ThiagoHen6) como projeto de portfólio para praticar desenvolvimento back-end com Spring Boot.
