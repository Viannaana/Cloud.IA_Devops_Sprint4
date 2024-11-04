### CLAUD.IA

## Descrição do Projeto

Este projeto tem como objetivo desenvolver uma solução inovadora para simplificar a busca em bases de dados, utilizando inteligência artificial (IA) generativa e deep learning. A solução proposta, denominada Claud.IA, visa tornar o processo de busca mais intuitivo e eficaz, permitindo que os usuários expressem suas consultas em linguagem natural e obtenham respostas precisas e relevantes.


## Modelo Relacional das Entidades

![WhatsApp Image 2024-05-21 at 00 14 43](https://github.com/Viannaana/Challenge-Java-NTJ.tech/assets/145307161/35339937-4c79-47ee-9532-7b069ba8dc87)

## Modelo Lógico das Entidades
![WhatsApp Image 2024-05-21 at 00 17 36](https://github.com/Viannaana/Challenge-Java-NTJ.tech/assets/145307161/ed6e91c9-952b-4677-8540-78c909895aab)



## Objetivos do Projeto

1. **Simplificação da Análise de Dados:** Desenvolver uma solução capaz de lidar com a diversidade de fontes, formatos e estruturas dos dados, tornando o processo de análise mais eficiente.
2. **Processamento em Tempo Real:** Possibilitar o processamento dos dados em tempo real para tomadas de decisão ágeis e responsivas.
3. **Geração de Insights Significativos:** Utilizar técnicas avançadas de análise de dados, como IA generativa e deep analytics, para extrair insights relevantes e acionáveis.
4. **Capacidades de Previsão e Prescrição:** Incorporar modelos preditivos avançados e algoritmos de machine learning para fornecer insights precisos e orientar a tomada de decisões estratégicas.
5. **Usabilidade e Acessibilidade:** Garantir que a solução seja fácil de usar e acessível, com uma interface intuitiva e recursos de suporte adequados.

## Endpoints

| Endpoint                | Método | Descrição                                                |
|-------------------------|--------|----------------------------------------------------------|
| `/fornecedores`         | GET    | Retorna a lista de fornecedores                          |
| `/fornecedores`         | POST   | Adiciona um novo fornecedor                              |
| `/fornecedores/{id}`    | GET    | Retorna os detalhes de um fornecedor específico          |
| `/fornecedores/{id}`    | PUT    | Atualiza os detalhes de um fornecedor específico         |
| `/fornecedores/{id}`    | DELETE | Deleta um fornecedor específico                          |
| `/produtos`             | GET    | Retorna a lista de produtos                              |
| `/produtos`             | POST   | Adiciona um novo produto                                 |
| `/produtos/{id}`        | GET    | Retorna os detalhes de um produto específico             |
| `/produtos/{id}`        | PUT    | Atualiza os detalhes de um produto específico            |
| `/produtos/{id}`        | DELETE | Deleta um produto específico                             |
| `/clientes`             | GET    | Retorna a lista de clientes                              |
| `/clientes`             | POST   | Adiciona um novo cliente                                 |
| `/clientes/{id}`        | GET    | Retorna os detalhes de um cliente específico             |
| `/clientes/{id}`        | PUT    | Atualiza os detalhes de um cliente específico            |
| `/clientes/{id}`        | DELETE | Deleta um cliente específico                             |
| `/pedidos`              | GET    | Retorna a lista de pedidos                               |
| `/pedidos`              | POST   | Adiciona um novo pedido                                  |
| `/pedidos/{id}`         | GET    | Retorna os detalhes de um pedido específico              |
| `/pedidos/{id}`         | PUT    | Atualiza os detalhes de um pedido específico             |
| `/pedidos/{id}`         | DELETE | Deleta um pedido específico                              |

## Estrutura dos Pacotes

### 📂 Model
Este pacote contém as classes que representam as entidades do sistema, definindo como os dados são armazenados no banco de dados e refletindo as regras de negócio.

### 📂 Dto
Inclui classes responsáveis por transportar dados entre as diferentes camadas da aplicação, especialmente entre o controller e a view. Esses objetos facilitam a transferência de dados de forma eficiente e segura.

### 📂 Repository
As interfaces neste pacote fazem a comunicação direta com o banco de dados através da JPA, gerenciando as operações de CRUD e outras consultas diretamente nas entidades.

### 📂 Controller
Contém as classes que lidam com as requisições HTTP recebidas pelo sistema. Essas classes processam as solicitações, executam a lógica de negócio necessária e retornam as respostas adequadas ao cliente.

### 📂 Handler
Inclui classes para gerenciar exceções e erros que ocorrem durante a execução da aplicação. Por exemplo, se um recurso solicitado não for encontrado, uma exceção "404 not found" será lançada e tratada aqui.

## 🚀 Instruções de Uso do Sistema

1. **Iniciar a Aplicação:** Após clonar o repositório ou baixar os arquivos do projeto, inicialize a aplicação Spring Boot.
2. **Importar Requisições do Postman:** Baixe o arquivo de requisições do Postman fornecido no repositório e importe-o no seu Postman.
3. **Executar Requisições:** Utilize as requisições GET, POST, PUT e DELETE conforme necessário para interagir com os endpoints listados.
4. **URL Base:** Utilize "http://localhost:8080/{Endpoint}" para realizar as requisições, substituindo `{Endpoint}` pelo caminho desejado conforme descrito na tabela de endpoints acima.

Seguindo estas instruções, você poderá explorar e testar todas as funcionalidades da aplicação de forma eficiente.

## :clipboard: Swagger

Acesso ao Swagger: <a href= http://localhost:8080/swagger-ui/index.html>Clique aqui! </a>

## Integrantes do Grupo

- **Ana Júlia Almeida Silva Neves** – RM: 98974
- **Nicoly Oliveira Santos** – RM: 552410
- **Vitor da Silva Pereira** – RM: 551831
- **Rafael Minoro Itokazo** – RM: 99988
