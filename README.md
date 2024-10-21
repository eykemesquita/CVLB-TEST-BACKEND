# CRUD API para Gerenciamento de Clientes

![DALL·E 2024-10-21 14 13 55 - A modern and creative logo design for a CRUD API project, featuring abstract geometric shapes representing data management, with a color palette of bl](https://github.com/user-attachments/assets/53f6f0c7-fc4d-46ed-8e8c-1a88a1304393)

Bem-vindo ao **CRUD API para Gerenciamento de Clientes**! Este projeto é uma API RESTful desenvolvida com o objetivo de gerenciar informações de clientes de forma simples e eficiente. Com suporte a operações CRUD (Criar, Ler, Atualizar e Deletar), a API permite que você interaja com um banco de dados de clientes de maneira ágil.

## Tecnologias Utilizadas

- **Java 17**: A base sólida do projeto, aproveitando as últimas funcionalidades da linguagem.
- **Spring Boot**: Facilita a configuração e a criação de aplicações Java, proporcionando um desenvolvimento rápido e eficaz.
- **Spring Data JPA**: Simplifica o acesso ao banco de dados, utilizando a programação orientada a objetos.
- **Swagger (OpenAPI)**: Para documentação da API, tornando a exploração das rotas mais intuitiva.
- **JUnit e Mockito**: Para testes unitários robustos, garantindo que o código funcione conforme esperado.
- **MariaDB / MySQL**: O banco de dados relacional para armazenar informações dos clientes.

## Funcionalidades

- **Gerenciamento de Clientes**: Criação, leitura, atualização e exclusão de clientes.
- **Autenticação**: Segurança básica com tokens JWT (se implementado).
- **Paginização e Filtragem**: Possibilidade de listar clientes com filtros e paginação.
- **Documentação Interativa**: Explore a API diretamente através do Swagger.


## Descrição dos Diretórios

- **src/main/java**: Contém o código-fonte do projeto.
  - **controller**: Controladores que gerenciam as requisições HTTP.
  - **dto**: Objetos de transferência de dados.
  - **entity**: Entidades do banco de dados.
  - **exception**: Classes de exceção personalizadas.
  - **mapper**: Classes responsáveis pela conversão entre entidades e DTOs.
  - **repository**: Interfaces de acesso ao banco de dados.
  - **service**: Classes de lógica de negócio.

- **src/main/resources**: Contém arquivos de configuração e recursos.
  - **application.properties**: Configurações da aplicação.
  - **db**: Scripts SQL para inicialização do banco de dados.

- **test**: Contém os testes do projeto.


## Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/yourusername/crud_api.git
   cd crud_api
   
## Configure o banco de dados no arquivo application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco<br><br> spring.datasource.username=seu_usuario<br><br> spring.datasource.password=sua_senha

## Rode o projeto:

./mvnw spring-boot:run

## Contribuição
Contribuições são bem-vindas! Se você tem sugestões ou melhorias, fique à vontade para abrir um Pull Request.

## Licença
Este projeto é licenciado sob a MIT License.

## Contato
Para mais informações ou dúvidas, entre em contato:

Nome: Eyke Mesquita Teixeira
<br><br>
Email: eyke1313@gmail.com

## Agradecimentos

🎉 Obrigado por explorar a API!
Estou empolgado em compartilhar esta experiência com você! A API foi desenvolvida com muito carinho e dedicação, e espero que ela atenda às suas expectativas. Divirta-se navegando por suas funcionalidades e sinta-se à vontade para contribuir ou personalizar à sua maneira.

Lembre-se, cada linha de código conta uma história. A sua história começa agora! 🚀✨
