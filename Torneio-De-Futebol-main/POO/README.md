# 🏆 Torneio Mundial de Futebol

Autores:
Raphael de Almeida Cruz; RGA: (202421901060);
Nicolas Oliveira Dos Santos; RGA: (202421901054);


Sistema desenvolvido em Java utilizando Programação Orientada a Objetos para simular um torneio mundial de futebol com fase de grupos e mata-mata.

## 📌 Funcionalidades

- Cadastro de juízes
- Consulta de times no banco de dados
- Sorteio automático dos grupos
- Simulação completa da fase de grupos
- Classificação automática dos dois melhores de cada grupo
- Simulação das fases eliminatórias
  - Oitavas de Final
  - Quartas de Final
  - Semifinais
  - Final
- Revelação do campeão
- Tratamento de exceções personalizadas
- Persistência de dados utilizando MySQL

---

# 🛠 Tecnologias utilizadas

- Java
- Swing (JOptionPane)
- JDBC
- MySQL 8
- Docker
- Docker Compose
- Programação Orientada a Objetos

---

# 📂 Estrutura do projeto

```
Projeto
│
├── src/
│   ├── model/
│   ├── view/
│   ├── persistencia/
│   ├── exception/
│   ├── img/
│   └── main/
│   
├── banco/
│   └── banco.sql
│
├── docker-compose.yml
│
└── README.md
```

---

# 📋 Requisitos

- Java JDK 17 ou superior
- Docker Desktop
- Git (opcional)

---

# ▶ Como executar

## 1. Clonar o projeto

```bash
git clone <https://github.com/Crovizin/Torneio-De-Futebol/tree/ENTREGRA_POLIMORFISMO>
```

ou apenas baixar o arquivo compactado.

---

## 2. Iniciar o banco de dados

Na pasta do projeto execute:

```bash
docker compose up -d
```

O Docker criará automaticamente:

- Container MySQL
- Banco de dados
- Tabela de times
- Inserção dos 32 clubes

Não é necessário executar nenhum comando SQL manualmente.

---

## 3. Executar o projeto

Abra o projeto em sua IDE (VSCode, NetBeans ou IntelliJ).

Execute a classe principal (`Main.java`).

---

# 📖 Funcionamento

Ao iniciar o sistema:

1. Cadastro dos juízes
2. Visualização dos clubes
3. Pesquisa de times
4. Sorteio dos grupos
5. Simulação da fase de grupos
6. Simulação do mata-mata
7. Revelação do campeão

---

# 📌 Conceitos de POO utilizados

O projeto utiliza diversos conceitos de Programação Orientada a Objetos:

- Classes e Objetos
- Encapsulamento
- Herança
- Polimorfismo
- Classes Abstratas
- Tratamento de Exceções
- Associação entre objetos

---

# 🗄 Persistência de Dados

Os dados dos clubes são armazenados em um banco de dados MySQL.

O acesso ao banco é realizado através de JDBC utilizando PreparedStatement, evitando SQL Injection.

