# Sistema de Pedidos - Design Patterns

## Objetivo

Projeto desenvolvido em Spring Boot para gerenciamento de pedidos de um e-commerce utilizando padrões de projeto.

O sistema realiza:

* criação de pedidos
* controle de status
* cálculo de frete
* persistência em banco de dados
* APIs REST

---

# Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* H2 Database
* Maven
* Postman

---

# Padrões de Projeto Utilizados

## State Pattern

O padrão State foi utilizado para controlar os diferentes estados do pedido.

Estados implementados:

* AGUARDANDO_PAGAMENTO
* PAGO
* ENVIADO
* CANCELADO

Cada estado possui suas próprias regras de negócio e transições permitidas.

---

## Strategy Pattern

O padrão Strategy foi utilizado para o cálculo de frete.

Estratégias implementadas:

* Frete terrestre (5%)
* Frete aéreo (10%)

Isso permite adicionar novas formas de frete sem alterar o restante do sistema.

---

## Factory Pattern

O padrão Factory foi utilizado para centralizar a criação das estratégias de frete e dos estados do pedido.

Factories implementadas:

* FreteFactory
* PedidoStateFactory

---

# Fluxo do Pedido

AGUARDANDO_PAGAMENTO
↓ pagar
PAGO
↓ enviar
ENVIADO

Cancelamento permitido:

* enquanto estiver AGUARDANDO_PAGAMENTO
* enquanto estiver PAGO

Após enviado:

* não pode mais alterar status

Se cancelado:

* não pode mais alterar status

---

# Regras de Negócio

* Um pedido aguardando pagamento pode:

  * ser pago
  * ser cancelado

* Um pedido pago:

  * pode ser enviado
  * pode ser cancelado
  * não pode ser pago novamente

* Um pedido enviado:

  * não pode ser cancelado
  * não pode mudar de status

* Um pedido cancelado:

  * não pode mudar de status

---

# Estrutura do Projeto

src/main/java/com/av2/designpatterns

* resources
* services
* repositories
* domains
* strategy
* state
* factory

---

# Endpoints

## Criar pedido

POST /pedidos

Exemplo:

{
"cliente": "Gustavo",
"valor": 1000,
"tipoFrete": "AEREO"
}

---

## Listar pedidos

GET /pedidos

---

## Pagar pedido

PUT /pedidos/{id}/pagar

---

## Cancelar pedido

PUT /pedidos/{id}/cancelar

---

## Enviar pedido

PUT /pedidos/{id}/enviar

---

# Banco de Dados

O projeto utiliza H2 Database em memória.

Console:
http://localhost:8080/h2-console

---

# Como executar o projeto

1. Clonar repositório
2. Abrir no IntelliJ
3. Executar a aplicação Spring Boot
4. Testar endpoints via Postman

---

# Testes Realizados no Postman

## Criar Pedido (POST)

<img width="1573" height="684" alt="image" src="https://github.com/user-attachments/assets/54653d81-8056-4b9f-878a-406cf84da878" />
<img width="1574" height="613" alt="image" src="https://github.com/user-attachments/assets/767b49a4-d8b4-4074-82a1-11bb4e17ee7d" />


---

## Listar Pedidos (GET)

<img width="1584" height="887" alt="image" src="https://github.com/user-attachments/assets/9f8a15dc-d55f-4f95-acad-a2f229cfc912" />


---

## Pagar Pedido (PUT)

<img width="1583" height="755" alt="image" src="https://github.com/user-attachments/assets/102410fd-da87-4dca-bc2c-94bd032a8dc8" />


---

## Enviar Pedido (PUT)

<img width="1580" height="762" alt="image" src="https://github.com/user-attachments/assets/dc629090-b55c-4bc0-a915-7f469f285b82" />


---

## Cancelar Pedido (PUT)

<img width="1568" height="702" alt="image" src="https://github.com/user-attachments/assets/85c7eb2c-afa2-403e-ae87-237db0a2c72d" />


---

## Listar Pedidos (GET) Pós Realização do Teste

<img width="1570" height="906" alt="image" src="https://github.com/user-attachments/assets/f82a5b58-cfb5-478c-b6a0-13700e1aaf74" />


---
# Testes das Regras de Negócio

## Não permitir pagamento duplo

<img width="1584" height="905" alt="image" src="https://github.com/user-attachments/assets/600cfe36-cfc0-4b5a-a02e-c4999c720f90" />


---

## Não permitir envio sem pagamento

<img width="1536" height="948" alt="image" src="https://github.com/user-attachments/assets/c2580673-616c-4781-afa9-b0ac63a2417b" />


---

## Não permitir cancelamento após envio

<img width="1575" height="941" alt="image" src="https://github.com/user-attachments/assets/d4fe9730-77f1-4a25-b721-e1e85db4ac9e" />


---

## Não permitir alteração após cancelamento

<img width="1564" height="953" alt="image" src="https://github.com/user-attachments/assets/9da3adde-adc6-4933-9f38-42f20595b011" />


---

## Permitir pagamento enquanto aguardando pagamento

<img width="1576" height="742" alt="image" src="https://github.com/user-attachments/assets/d53861f6-f090-4ec7-98c4-2ccf2cedd2e6" />


---

## Permitir cancelamento enquanto aguardando pagamento

<img width="1574" height="777" alt="image" src="https://github.com/user-attachments/assets/4f5f4b12-afc6-41be-ba78-96b484637b84" />


---

## Permitir cancelamento enquanto pago

<img width="1568" height="758" alt="image" src="https://github.com/user-attachments/assets/67bd6eee-a2bb-4437-ab5d-93982c304689" />


---


# Diagrama UML

<img width="3778" height="4656" alt="designpatterns" src="https://github.com/user-attachments/assets/f206bb2c-17ea-4776-a8b9-d9204dcb429c" />

---

# Pasta Postman



---
