Perfeito!
A seguir está o **README profissional completo**, já adaptado para um **projeto acadêmico da disciplina de Arquitetura de Sistemas** e incluindo **toda a documentação técnica do backend** em um único arquivo.

Se quiser, posso gerar também uma versão em PDF depois.

---

# 📄 **README – Backend FacilPark**

### *Projeto da Disciplina de Arquitetura de Sistemas*

---

## 📘 **Descrição Geral do Projeto**

O **FacilPark** é um sistema acadêmico desenvolvido como parte da disciplina de **Arquitetura de Sistemas**, com o objetivo de simular o funcionamento de um estacionamento inteligente. O backend foi construído em **Java**, seguindo uma arquitetura **monolítica**, organizada por camadas e utilizando padrões de projeto como **Factory** e **Strategy** para modularizar regras de negócio.

O sistema permite:

* Registrar entradas de veículos
* Registrar saídas
* Calcular valores a pagar
* Gerenciar vagas
* Controlar diferentes tipos de veículos

O projeto utiliza uma organização clara de pastas e separação lógica entre **Controllers**, **Models**, **Factories** e **Strategies**, reforçando conceitos fundamentais de arquitetura.

---

# 🏗️ **Arquitetura do Sistema**

O backend foi desenvolvido utilizando uma **arquitetura monolítica estruturada por camadas**, organizada da seguinte forma:

```
src/
 ├── Controllers/
 │     ├── EntradaController.java
 │     └── SaidaController.java
 │
 ├── Models/
 │     ├── Estacionamento.java
 │     ├── Vaga.java
 │     ├── Veiculo.java
 │     ├── Carro.java
 │     ├── Moto.java
 │     └── Caminhao.java
 │
 ├── Strategies/
 │     ├── CalculoValorStrategy.java
 │     └── CalculoValorPorEntradaStrategy.java
 │
 ├── Factories/
 │     └── VeiculoFactory.java
 │
 └── Main.java
```

---

# 🧠 **Padrões de Projeto Utilizados**

### ✔️ **Factory Pattern – Criação de veículos**

Classe: `VeiculoFactory.java`

Motivo:

* Reduz acoplamento
* Permite criar carros, motos e caminhões sem if/else espalhados
* Facilita expansão (novos tipos de veículos)

---

### ✔️ **Strategy Pattern – Cálculo do valor do estacionamento**

Arquivos principais:

* `CalculoValorStrategy.java` (interface)
* `CalculoValorPorEntradaStrategy.java` (implementação)

Benefícios:

* Diferentes regras de cobrança podem ser adicionadas sem alterar o restante do sistema
* Evita condicionais extensas
* Permite mudar estratégias em tempo de execução

---

### ✔️ **MVC Simplificado**

* **Controllers** → Entrada/Saída
* **Models** → Entidades principais
* **Factories/Strategies** → Regras de negócio desacopladas

---

# 📂 **Descrição das Camadas**

## **1. Controllers**

São responsáveis por orquestrar chamadas e controlar o fluxo entre usuário e sistema.

### **EntradaController.java**

* Registra entrada de um veículo
* Solicita criação via Factory
* Procura vaga disponível
* Registra horário de entrada

### **SaidaController.java**

* Registra saída
* Solicita cálculo de valor via Strategy
* Libera vaga
* Retorna valor a pagar

---

## **2. Models**

### **Estacionamento.java**

* Estrutura principal
* Lista de vagas
* Métodos para alocar e liberar vagas

### **Vaga.java**

* Estado da vaga
* Tipo de veículo aceito
* Ocupação

### **Veiculo.java (classe abstrata)**

Especializações:

* `Carro.java`
* `Moto.java`
* `Caminhao.java`

Atributos:

* Placa
* Horário de entrada
* Horário de saída

---

## **3. Factory**

### `VeiculoFactory.java`

Recebe:

* tipo do veículo
* placa

E retorna:

* instância correta do tipo (Carro/Moto/Caminhão)

---

## **4. Strategy**

### `CalculoValorStrategy.java`

Define interface com método:

```java
double calcularValor(Veiculo veiculo);
```

### `CalculoValorPorEntradaStrategy.java`

Implementação baseada em:

* Tabela fixa de valores
* Tipo de veículo

Exemplo:

* Carro: R$ 10
* Moto: R$ 5
* Caminhão: R$ 15

---

# 🔁 **Fluxo de Funcionamento**

## **Fluxo 1 – Entrada de Veículo**

1. Usuário informa tipo e placa
2. Controller chama a Factory
3. Factory cria o veículo correto
4. Estacionamento busca vaga disponível
5. Horário de entrada é registrado

```
Entrada → Factory → Veículo → Estacionamento → Vaga alocada
```

---

## **Fluxo 2 – Saída de Veículo**

1. Usuário informa a placa
2. Controller localiza veículo
3. Aplica Strategy de cálculo
4. Vaga é liberada
5. Sistema retorna valor total

```
Saída → Estratégia → Cálculo → Libera Vaga → Valor Final
```

---

# 🔧 **Tecnologias Utilizadas**

* **Java 17+**
* **IntelliJ IDEA**
* **Arquitetura Monolítica**
* **Padrões de projeto (Factory, Strategy)**
* Sem dependências externas (projeto puro em Java)

---

# ▶️ **Como Executar o Projeto**

### 1. Abra o projeto no IntelliJ IDEA

A pasta contém arquivos:

* `.idea`
* `FacilPark.iml`

O IntelliJ identifica automaticamente como projeto Java.

### 2. Execute o arquivo principal

```
src/Main.java
```

### 3. Use os menus do console para:

* Registrar entradas
* Registrar saídas
* Visualizar vagas

---

# 📚 **Documentação Técnica Completa**

Inclusa no README:

* Arquitetura
* Estrutura do projeto
* Padrões utilizados
* Fluxos de uso
* Descrição das principais classes
* Descrição detalhada de Controllers, Models, Factories e Strategies

---

# 📌 **Status do Projeto**

✔️ Funcional
✔️ Estruturado
✔️ Código padronizado
✔️ Utiliza boas práticas acadêmicas de arquitetura

---

# 👥 **Autores**

Projeto acadêmico — Disciplina de Arquitetura de Sistemas
Equipe conforme arquivo original do repositório.

---

# 🔄 **O que posso gerar a seguir para você?**

Posso criar:

📌 Um **PDF profissional** com essa documentação
📌 Um **diagrama UML completo** (classes + fluxo)
📌 Um **diagrama da arquitetura**
📌 Um **manual do usuário**
📌 Uma **versão resumida para apresentação em slides**

É só pedir!
