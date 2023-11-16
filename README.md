# Rentaway

## Índice

1. [Sobre](#sobre)
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)
3. [Configuração do Ambiente](#configuração-do-ambiente)
4. [Instruções de Instalação](#instruções-de-instalação)
5. [Como Executar](#como-executar)
6. [Swagger](#swagger)

## Sobre

O Sistema de Aluguel de Carros é uma aplicação desenvolvida para o Bootcamp da IBM e serve para gerenciar o processo de aluguel de veículos. O projeto é dividido em duas partes: um backend em Java e um frontend em Angular.

## Tecnologias Utilizadas

### Backend (Java v11)

- Spring Boot
- Hibernate
- Maven

### Frontend (Angular v17)

- Angular CLI
- TypeScript
- Angular Material

## Configuração do Ambiente

Antes de executar a aplicação, é necessário configurar o ambiente de desenvolvimento. Certifique-se de ter as seguintes ferramentas instaladas:

### Backend

- Java SDK
- Maven

### Frontend

- Node.js
- Angular CLI

## Instruções de Instalação

1. Clone este repositório:

```bash
git clone https://github.com/rnogara/rentaway.git
cd rentaway
```

2. Inicializar o Docker:

```bash
docker-compose up -d
```

3. Instalar dependências do node:

```bash
cd frontend
npm install
```

## Como Executar

1. Backend:

- Rode o projeto na sua IDE

2. Frontend:

```bash
cd frontend
ng serve
```

## Swagger

https://app.swaggerhub.com/apis/RNOGARADEV/rentaway/v0


