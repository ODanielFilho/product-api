
<h3 align="center">
  Api de Cadastro de Produtos
</h3>
<br></br>


<p align="center">

  <img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-%2304D361">
  <img alt="Language: Java" src="https://img.shields.io/badge/language-java-green">
  <img alt="Version: 1.0" src="https://img.shields.io/badge/version-1.0-yellowgreen">

</p>


## Como interagir com o banco de dados?
- Utilizamos o [Beekeeper Community](https://github.com/beekeeper-studio/beekeeper-studio/releases/tag/v4.1.13)

## Como interagir com a API?
- Utilizamos o [Postman](https://https://www.postman.com/)

## :rocket: Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Docker
* Hibernate Validator

:mag: Baixe o projeto e teste você mesmo na prática.

## Instalação

Instalação das dependências do projeto

```bash
mvn clean install
```
## Run

Criar uma conexão no PostgreSQL para rodar o banco de dados. Após isso os parâmetros **username** e **password** da sua conexão devem ser informados no arquivo application.properties
```bash
spring.datasource.username=admin
spring.datasource.password=admin
```

## Docker

Será necessário também definir um usuário e uma senha para o banco no arquivo **docker-compose.yml**
```bash
    environment:
      - POSTGRES_USER=admin
      - POSTGRES_PASSWORD=admin
      - POSTGRES_DB=product
```
Por padrão o **USER** está configurado como **admin**

Após isso, executar o comando:

```bash
docker compose up -d
```

## Swagger

Para ver as rotas da api, os tipos e formatos de dados que ela recebe acesse este link após rodar o projeto:
```bash
http://localhost:8080/swagger-ui/index.html#/
```

Developed by Daniel Filho