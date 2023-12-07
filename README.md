# Gerenciador de Estacionamentos

Este é um projeto de backend que permite o cadastro de estacionamentos e veículos, bem como o controle de entrada e saída de veículos nesses estacionamentos. O sistema oferece uma API que permite operações CRUD (Create, Read, Update, Delete) para estabelecimentos e veículos, além de fornecer informações em formato JSON. 

# Tecnologias utilizadas

> **Spring Boot**: Framework Java para desenvolvimento da API REST.
> 
> **MySql**: Banco de dados relacinal para o armazenamento dos dados em ambiente de produção.
>
>  **H2**: Banco de dados relacional para o armazenamento dos dados em ambiente de teste.
>
> **JUnit**: Framework Java para executar testes ao sistema.
>
> **JSON**: Formato de retorno de dados.
>
> **Maven**: Ferramenta de gerenciamento de build e dependências para projetos Java.

# Cadastro

## Estabelecimento
Os estabelecimentos possuem os seguintes campos:

- Nome;
- CNPJ;
- Endereço;
- Telefone;
- Quantidade de vagas para motos;
- Quantidade de vagas para carros.

## Veículos
Os veículos possuem os seguintes campos:

- Marca;
- Modelo;
- Cor;
- Placa;
- Tipo.

# Rotas do sistema

1. Estabelecimento

1.1. GET /estabelecimentos: Retorna a lista de todos os estabelecimentos cadastrados.

1.2. GET /estabelecimentos/id: Retorna os detalhes de um estabelecimento específico pelo ID.

1.3. POST /estabelecimentos: Cria um novo estabelecimento.

1.4. PUT /estabelecimentos/id: Atualiza os dados de um estabelecimento existente.

1.5. DELETE /estabelecimentos/id: Remove um estabelecimento existente.

2. Veículos

2.1. GET /veiculos: Retorna a lista de todos os veículos cadastrados.

2.2. GET /veiculos/id: Retorna os detalhes de um veículo específico pelo ID.

2.3. POST /veiculos: Cria um novo veículo.

2.4. PUT /veiculos/id: Atualiza os dados de um veículo existente.

2.5. DELETE /veiculos/id: Remove um veículo existente.

3. Controle de Entrada e Saída de Veículos
3.1. POST /controle/entrada: Registra a entrada de um veículo no estabelecimento.

3.2. POST /controle/saida: Registra a saída de um veículo do estabelecimento.

