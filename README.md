# Biblioteca API

Projeto desenvolvido para praticar meus conhecimentos em Java e Spring Boot.

A aplicação consiste em uma API REST para gerenciamento de livros, permitindo cadastrar, listar, buscar, atualizar e excluir livros.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- Bean Validation
- Maven

## Funcionalidades

- Cadastro de livros
- Listagem de livros
- Busca de livro por ID
- Busca de livros por título
- Atualização de livros
- Exclusão de livros
- Tratamento de exceção para livros não encontrados
- Validação dos dados cadastrados

## Estrutura do projeto

O projeto foi organizado em camadas:

- Controller
- Service
- Repository
- Model
- Exception

## Livro

Cada livro possui as seguintes informações:

- Título
- Autor
- Categoria
- Ano de publicação
- Disponibilidade

## Objetivo

Este projeto foi criado com o objetivo de praticar o desenvolvimento de APIs REST utilizando Java e Spring Boot, além de reforçar conceitos de JPA, banco de dados, validações e tratamento de exceções.