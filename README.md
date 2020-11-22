### Sistema de gerenciamento de salas de reuniões com Java em API REST com Spring Boot

* Criação de modelo de dados para o mapeamento da entidade com bancos de dados H2 gravando em arquivo.
* Desenvolvimento de operações de gerenciamento de rooms (create, read, update e delete).
* Relação de cada uma das operações acima com o padrão arquitetural REST.

Para executar via terminal, executar:
> mvn spring-boot:run

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

> http://localhost:8082/api/v1/room

São necessários os seguintes pré-requisitos para a execução do projeto:
* Java 11 ou superior.
* Maven 3.6.3 ou superior.
