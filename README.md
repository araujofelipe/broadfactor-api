# Desafio programação - para vaga desenvolvedor

## Stack utilizada

- Java 11
- Maven
- ClearDB MySQL (heroku)
- Spring Boot
    - Spring Data JPA
    - Spring Security
- Lombok
- JWT

## Como executar o projeto

### API Via Docker

Pela linha de commando, na pasta do projeto execute nesta ordem:

```mvn clean package```

```docker build --tag=broadfactor-api:latest .```

```docker-compose up```
###


## Como testar a api

### Cadastro de usuário

#### uri: POST http://localhost:8080/api/v1/usuario

Exemplo de requisição

```json
{
    "nome": "Fulano de tal",
    "email": "fulano@broadfactor.com.br",
    "senha": "123456",
    "empresa": {
        "cnpj": "13995981000104"
    }
} 
```
### Login

#### uri: POST http://localhost:8080/api/v1/login

Exemplo de requisição

```shell
curl --location --request POST 'localhost:8080/api/v1/login' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'email=ciclanol@freelas.com.br' \
--data-urlencode 'senha=123456'
```

Ou utilize o postman com método x-www-form-urlencoded


### Detalhar Empresa

#### uri: GET http://localhost:8080/api/v1/empresa/{id}

Lembre-se de passar o header 'Autorization', contendo "Bearer `token`"