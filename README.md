# 🏆 Torneio Mundial de Futebol

Autores:
Raphael de Almeida Cruz; RGA: (202421901060);
Nicolas Oliveira Dos Santos; RGA: (202421901054);

Projeto desenvolvido para a disciplina de Programação Orientada a Objetos.

## Tecnologias utilizadas

- Java 17
- Swing
- MySQL 8
- Docker
- JDBC
- Maven (utilizado apenas durante o desenvolvimento)

---

# Requisitos

Antes de executar o projeto é necessário possuir:

- Java JDK 17 ou superior
- Docker Desktop

---

# Como executar

## 1) Baixe o projeto

https://github.com/Crovizin/Torneio-De-Futebol/tree/TORNEIO_FUTEBOL_POO_FINAL

baixe o arquivo .zip.

---

## 2) Inicie o banco de dados

Verifique se esta na pasta "MAIOR_TORNEIO_DE_FUTEBOL"
se não entre com:
```bash
cd MAIOR_TORNEIO_DE_FUTEBOL
```
Na pasta do projeto execute:

```bash
docker compose up -d
```

Aguarde alguns segundos até que o MySQL seja iniciado.

---

## 3) Execute o sistema

Dentro da pasta do projeto execute:

```bash
java -jar torneio-futebol-1.0.jar
```

O sistema iniciará automaticamente.

---

# Banco de Dados

O banco é criado automaticamente utilizando Docker.

Caso seja necessário recriá-lo:

```bash
docker compose down -v
docker compose up -d
```

O script `banco.sql` será executado automaticamente.

---

# Funcionalidades

- Cadastro de Juízes
- Pesquisa de Times
- Sorteio dos Grupos
- Simulação da Fase de Grupos
- Mata-Mata
- Campeão do Torneio
- Eventos Especiais durante as partidas
- Persistência dos times utilizando MySQL

---

# Estrutura do Projeto

```
.
├── src/
├── target
├── banco.sql
├── docker-compose.yml
├── pom.xml
├── README.md
└── torneio-futebol-1.0.jar
```

---

# Autor

Raphael de Almeida Cruz

Universidade Federal de Mato Grosso - UFMT
