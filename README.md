# DummyJSON Client - Java 17 e Spring Boot 3.2.5

## Descrição do Projeto
Este projeto é um microsserviço Java que interage com a API pública [DummyJSON](https://dummyjson.com/docs/products) para realizar operações de busca de produtos. O projeto foi desenvolvido usando Java 17 e Spring Boot 3.2.5.

## Funcionalidades
* **Consulta de Produtos**: Realiza chamadas para a API do DummyJSON para buscar informações sobre produtos.
* **Integração com WebClient**: Utiliza `WebClient` para realizar chamadas HTTP de forma reativa.
* **Validação de Dados**: Validação de dados de entrada usando Bean Validation (Jakarta Validation).
* **Documentação OpenAPI**: Documentação da API usando SpringDoc OpenAPI.
* **Monitoramento de Saúde**: Endpoint `/health` para verificação da saúde do microsserviço.
* **Testes de Integração**: Inclui testes de integração desenvolvidos com JUnit 5 e Spring Boot Test.

## Estrutura do Projeto
```
code-challenge-migration
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.dummyjson
│   │   │       ├── DummyJsonClientApplication.java
│   │   │       ├── config
│   │   │       │   └── WebClientConfig.java
│   │   │       ├── controller
│   │   │       │   ├── ProductController.java
│   │   │       │   └── HealthController.java
│   │   │       ├── dto
│   │   │       │   └── Product.java
│   │   │       ├── service
│   │   │       │   └── ProductService.java
│   │   └── resources
│   │       └── application.yaml
│   └── test
│       └── java
│           └── com.example.dummyjson
│               ├── controller
│               │   ├── ProductControllerTest.java
│               │   └── HealthControllerTest.java
│               ├── dto
│               │   └── ProductTest.java
│               └── service
│                   └── ProductServiceTest.java
└── pom.xml
```

## Requisitos
* **Java 17+**
* **Maven 3.8.x+**
* **Docker** (opcional, para execução em container)

## Configuração
O projeto utiliza configurações externalizadas para facilitar a execução em diferentes ambientes. As principais configurações estão no arquivo `application.yaml`:

```yaml
api:
  dummyjson:
    base-url: https://dummyjson.com
    products-path: /products
```

## Executar a Aplicação
Para clonar o repositório e iniciar o projeto, siga os passos abaixo:
### Clone do Projeto
```bash
git clone https://github.com/mateusvfreitas/ibm-code-challenge-migration.git
cd ibm-code-challenge-migration
```

### Execução com Maven
```bash
mvn clean install
mvn spring-boot:run
```

### Execução com Docker
```bash
docker build -t dummyjson-app .
docker run -p 8080:8080 dummyjson-app
```

### Execução com Docker Compose
```bash
docker-compose up
```

## Executar Testes
```bash
mvn clean test
```

## Documentação da API
A documentação da API está disponível em:
- http://localhost:8080/swagger-ui.html

## Endpoints Disponíveis
- `GET /api/products`: Lista todos os produtos
- `GET /api/products/{id}`: Busca um produto pelo ID
- `GET /health`: Verifica a saúde do microsserviço
- `GET /actuator/health`: Verifica a saúde do microsserviço via Spring Boot Actuator.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.2.5**
- **WebClient** para chamadas HTTP reativas
- **Spring Boot Actuator** para monitoramento
- **SpringDoc OpenAPI** para documentação
- **JUnit 5** e **Spring Boot Test** para testes

## Containerização
O projeto inclui um Dockerfile e um arquivo docker-compose.yml para facilitar a execução em ambientes containerizados.

## Monitoramento de Saúde
O microsserviço inclui dois endpoints para verificação de saúde:

- `/health`: Um endpoint customizado que pode ser implementado para verificar a saúde do microsserviço.

- `/actuator/health`: Endpoint fornecido pelo Spring Boot Actuator, que oferece uma visão detalhada da saúde do microsserviço, incluindo status de dependências e componentes internos.

### Exemplo de Resposta do Actuator Health
```json
{
    "status": "UP",
    "components": {
        "diskSpace": {
            "status": "UP",
            "details": {
                "total": 500107862016,
                "free": 300107862016,
                "threshold": 10485760,
            }
        },
        "ping": {
            "status": "UP"
        }
    }
}
```
