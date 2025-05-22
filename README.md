# challenge-api

> API RESTful para mapeamento e rastreamento de motos nos pátios da MOTTU usando visão computacional e trilateração com ArUco Markers.

---

##  Descrição do Projeto

A ausência de um sistema automatizado de mapeamento e localização das motos compromete a agilidade da operação nos pátios da empresa MOTTU e aumenta o risco de falhas humanas.

Este projeto propõe uma solução tecnológica que visa melhorar a eficiência operacional por meio de:

- Cálculo preciso da posição das motos por trilateração, com base em distâncias medidas entre marcadores ArUco fixos e móveis instalados no ambiente (fixos) e nos veículos (móveis);

- Armazenamento e rastreamento histórico de posições para auditoria e controle de movimentação;

- Integração via API RESTful construída com Java Spring Boot, seguindo boas práticas de arquitetura, documentação (Swagger), uso de DTOs, cache e tratamento de erros.

Público-alvo: Funcionários responsáveis pela gestão de pátios da MOTTU

A API será consumida por uma aplicação móvel voltada aos operadores dos pátios, que permitirá:

- Visualização de um mapa digital com as posições em tempo real das motos;

- Consulta interativa: ao clicar sobre uma moto no mapa, o app exibe suas informações detalhadas (placa, modelo, status, histórico de localização etc.).

---

## Tecnologias e Ferramentas Utilizadas

- Java 17
- Spring Boot 3
- Maven
### Módulos Spring Utilizados
- `Spring Web` – construção da API RESTful  
- `Spring Data JPA` – persistência de dados com ORM  
- `Spring Validation` – validação de dados de entrada  
- `Spring Cache` – melhoria de performance com cache de dados
- `MapStruct` – mapeamento automático entre entidades e DTOs
### Persistência de Dados
- **H2 Database** – ambiente de desenvolvimento  
- **Oracle Database** – ambiente de produção
### Documentação e Testes da API
- **Swagger / OpenAPI** – documentação da API  
- **Swagger UI** – testes via interface interativa
- **Postman** – testes manuais das requisições  

---

## Pré-requisitos

- Java 17+
- Maven 3.8+
- IDE (IntelliJ, Eclipse ou VS Code)

---

## Como Executar

```bash
# Clone o repositório
git clone https://github.com/thiag0renatino/challenge-java-api.git
cd challenge-java-api

# Compile o projeto
mvn clean install

# Execute a aplicação
mvn spring-boot:run
```

A API estará disponível em:  
 `http://localhost:8080`

---

## Documentação da API

Disponível via Swagger:  
 [`http://localhost:8080/swagger-ui/index.html`](http://localhost:8080/swagger-ui/index.html)

---

## Principais Entidades

| Entidade           | Descrição                                                                |
|--------------------|--------------------------------------------------------------------------|
| `Moto`             | Representa a moto rastreada (placa, modelo, status etc.)                |
| `Posicao`          | Coordenadas x, y de uma moto em um momento específico                   |
| `MarcadorFixo`     | Marcador ArUco fixo instalado no pátio                                  |
| `MarcadorArucoMovel`| Marcador ArUco preso à moto                                            |
| `MedicaoPosicao`   | Distância entre marcador fixo e moto para cálculo de posição            |
| `Usuario`          | Funcionário cadastrado no sistema                                       |
| `Patio`            | Unidade física onde motos são monitoradas                              |

---

## Endpoints da API

### `/motos`
- `GET /motos`
- `GET /motos/{id}`
- `POST /motos`
- `PUT /motos/{id}`
- `DELETE /motos/{id}`
- `GET /motos/buscar?placa=`
- `GET /motos/status/{status}`
- `GET /motos/{id}/posicoes`

### `/posicoes`
- `GET /posicoes`
- `GET /posicoes/moto/{motoId}`
- `GET /posicoes/{id}/moto`
- `GET /posicoes/ultimas`
- `GET /posicoes/historico/{motoId}`
- `GET /posicoes/revisao`
- `POST /posicoes`
- `PUT /posicoes/{id}`
- `DELETE /posicoes/{id}`

### `/patios`
- `GET /patios`
- `GET /patios/{id}`
- `GET /patios/com-motos`
- `GET /patios/{id}/motos`
- `GET /patios/{id}/posicoes`
- `POST /patios`
- `PUT /patios/{id}`
- `DELETE /patios/{id}`

### `/usuarios`
- `GET /usuarios`
- `GET /usuarios/{id}`
- `GET /usuarios/por-email?email=`
- `POST /usuarios`
- `PUT /usuarios/{id}`
- `DELETE /usuarios/{id}`

### `/marcadores-fixos`
- `GET /marcadores-fixos`
- `GET /marcadores-fixos/por-patio/{patioId}`
- `GET /marcadores-fixos/por-codigo?codigoAruco=`
- `POST /marcadores-fixos`
- `DELETE /marcadores-fixos/{id}`

### `/marcadores-moveis`
- `GET /marcadores-moveis`
- `GET /marcadores-moveis/{id}`
- `GET /marcadores-moveis/por-moto?idMoto=`
- `GET /marcadores-moveis/por-codigo?codigoAruco=`
- `POST /marcadores-moveis`
- `PUT /marcadores-moveis/{id}`
- `DELETE /marcadores-moveis/{id}`

### `/medicoes`
- `GET /medicoes`
- `GET /medicoes/{id}`
- `GET /medicoes/posicao/{id}`
- `GET /medicoes/posicao/{id}/contagem`
- `GET /medicoes/marcador/{id}`
- `POST /medicoes`
- `DELETE /medicoes/{id}`

---

## Banco de Dados

- H2 em memória (dev)
- Oracle (produção)
- Configurações no arquivo `application.properties`

---

## Alunos

- Thiago Renatino Paulino — RM556934  
- Cauan Matos Moura — RM558821  
- Gustavo Roberto — RM558033  

---

## Licença

Projeto acadêmico
