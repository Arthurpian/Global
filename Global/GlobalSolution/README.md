# **API de Gerenciamento de Consumo e Produção de Energia**

## **Descrição do Projeto**
Esta é uma API REST desenvolvida com **Spring Boot** que permite o gerenciamento de clientes, instalações, contratos e 
registros de consumo e produção de energia elétrica. O objetivo é oferecer funcionalidades para monitorar e gerenciar 
dados de consumo e produção de energia de maneira eficiente, utilizando o banco de dados H2 para persistência.

---

## **Funcionalidades**
- **Clientes**:
    - Adicionar, listar, buscar e desativar (deleção lógica).
- **Instalações**:
    - Adicionar, listar, buscar e desativar (deleção lógica).
- **Contratos**:
    - Criar, listar e desativar contratos entre clientes e instalações.
- **Registros de Consumo e Produção**:
    - Registrar consumo e produção de energia por contrato.
    - Listar registros associados a contratos.

---

## **Tecnologias Utilizadas**
- **Java 17**
- **Spring Boot 3.0**
- **Maven**
- **Banco de Dados H2**

---

## **Configuração do Projeto**

### **Pré-requisitos**
- **Java 17 ou superior**
- **Maven 3.8.1 ou superior**

### **Acesse a aplicação no navegador**
- **API Base URL: http://localhost:8080**
- **H2 Console: http://localhost:8080/h2-console**
- **JDBC URL: jdbc:h2:mem:testdb**
- **Username: sa**
- **Password: (deixe vazio)**

### **Endpoints da API**

###  clientes
1. Adicionar Cliente
- Método: POST
- URL: /clientes
- Exemplo de Body (JSON)
  {
  "name": "João da Silva",
  "endereco": "Rua das Flores, 41",
  "cpfCnpj": "966.351.800-60",
  "tipo": "PF",
  "cep": "055345-120",
  "ativo": true
  }
- Resposta de Sucesso:
{
  "clienteUuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
  "name": "João da Silva",
  "endereco": "Rua das Flores, 41",
  "cpfCnpj": "966.351.800-60",
  "tipo": "PF",
  "cep": "055345-120",
  "ativo": true
  }

2. Listar Todos os Clientes
- Método: GET 
- URL: /clientes
- Resposta de Sucesso:
  {
  "clienteUuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
  "name": "João da Silva",
  "endereco": "Rua das Flores, 41",
  "cpfCnpj": "966.351.800-60",
  "tipo": "PF",
  "cep": "055345-120",
  "ativo": true
  }

3. Buscar Cliente por UUID
- Método: GET
- URL: /clientes/{clienteUuid}
- Exemplo:     
  GET /clientes/7da41106-5109-45f4-8d09-9ca405c33e5c


4. Deletar Cliente (Deleção Lógica)
- Método: DELETE
- URL: /clientes/{clienteUuid}
- Exemplo:     
  DELETE /clientes/7da41106-5109-45f4-8d09-9ca405c33e5c

###  Instalações

1. Adicionar Instalação
- Método: POST
- URL: /instalacoes 
- Exemplo de Body (JSON):
   {
   "endereco": "Rua das Flores, 41",
   "cep": "055345-120",
   "ativo": true
   }
- Resposta de Sucesso:
    {
    "instalacaoUuid": "84b4b063-58a4-4dab-bf4f-fd13954c328c",
    "endereco": "Rua das Flores, 41",
    "cep": "055345-120",
    "ativo": true
    }

2. Listar Todas as Instalações
- Método: GET
- URL: /instalacoes

3. Deletar Instalação (Deleção Lógica)
- Método: DELETE
- URL: /instalacoes/{instalacaoUuid}


###  Contratos

1. Criar Contrato
- Método: POST
- URL: /contratos
- Exemplo de Body (JSON):
   {
   "clienteUuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
   "instalacaoUuid": "84b4b063-58a4-4dab-bf4f-fd13954c328c",
   "duracaoContrato": 180,
   "ativo": true
   }
- Exemplo de Corpo (JSON):
  {
  "clienteUuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
  "instalacaoUuid": "84b4b063-58a4-4dab-bf4f-fd13954c328c",
  "duracaoContrato": 180,
  "ativo": true
  }

2. Listar Contratos por Cliente
- Método: GET
- URL: /contratos/{clienteUuid}

3. Deletar Contrato (Deleção Lógica)
- Método: DELETE
- URL: /contratos/{contratoUuid}

###  Registros de Consumo

1. Criar Registro de Consumo
- Método: POST
- URL: /consumo
- Exemplo de Body (JSON):
   {
   "contrato": {
   "contratoUuid": "10ea3582-000d-4546-afdf-8677bc58e606"
   },
   "consumoKwh": 450.0,
   "medicaoTimestamp": 1732284100
   }

2. Listar Registros de Consumo por Contrato
- Método: GET
- URL: /consumo/{contratoUuid}

###  Registros de Produção
1. Criar Registro de Produção
- Método: POST
- URL: /producao
- Exemplo de Body (JSON):
   {
   "contrato": {
   "contratoUuid": "10ea3582-000d-4546-afdf-8677bc58e606"
   },
   "producaoKwh": 120.0,
   "medicaoTimestamp": 1732284100
   }

2. Listar Registros de Produção por Contrato
- Método: GET
- URL: /producao/{contratoUuid}

##  Registros de Produção
1. **Clientes, Instalações e Contratos** nunca são apagados do banco. Em vez disso, são marcados como inativos (ativo = false).
2. Para consumo e produção, o timestamp deve sempre ser posterior ao último registro.