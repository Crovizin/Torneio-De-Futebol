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

> Certifique-se de que o Docker Desktop esteja aberto antes de iniciar.
---

# Como executar

## 1. Abra um terminal na pasta do projeto

Entre na pasta MAIOR_TORNEIO_DE_FUTEBOL:

Caso não esteja. Execute o comando:
```bash
cd MAIOR_TORNEIO_DE_FUTEBOL
```
---

## 2. Inicie o banco de dados

Execute o comando:

```bash
docker compose up -d
```

Na primeira execução aguarde aproximadamente **20 segundos**, pois o Docker criará automaticamente o banco de dados e importará todos os clubes.

Caso a porta 3307 esteja sendo utilizada por outro programa, altere a porta no arquivo `docker-compose.yml` e no arquivo `Banco.java` para outra porta livre.
---

## 3. Execute o programa

Após o banco ser iniciado execute:

```bash
java -jar torneio-futebol-1.0.jar
```

O sistema será iniciado normalmente.

---

# Encerrando

Após utilizar o sistema, para desligar o banco execute:

```bash
docker compose down
```

---

# Observações

- O banco de dados é criado automaticamente na primeira execução.
- Não é necessário instalar MySQL ou importar arquivos SQL manualmente.
- Os 32 clubes são cadastrados automaticamente pelo Docker.
- Nas próximas execuções basta iniciar o Docker e executar os mesmos comandos.

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
