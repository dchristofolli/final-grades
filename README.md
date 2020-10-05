# Final Grades
### Resumo
Solução para o Desafio Técnico da PUC.

#### Desafio proposto
Desenvolva uma API que calcule as notas finais dos alunos para cada disciplina. <br />
A nota final de cada disciplina é calculada através de média ponderada das prova. Cada prova pode ter um peso diferente. <br />
A API deverá permitir que os pesos das provas sejam parametrizados, conforme o exemplo abaixo: <br />
Ex: <br />
* Prova1 = 7.0 -> Peso1 = 1
* Prova2 = 8.0 -> Peso2 = 1
* Prova3 = 7.5 -> Peso3 = 1
* Media -> ((7.0x1)+(8.0x1)+(7.5x1))/3=7.5

#### Informações complementares:
As Informações de disciplinas e alunos estão abaixo no arquivo (JSON) em anexo. <br />
A aplicação deve ser desenvolvida utilizando a linguagem Java utilizando Spring Framework como um projeto Spring Boot e documentação utilizando o Swagger Framework.

#### Tecnologias utilizadas
Para esse projeto, foram utilizadas as seguintes tecnologias:
* Java 11: Linguagem utilizada no projeto;
* Spring: Inicialização da API e injeção de dependências;
* Gradle: Automação do build e gestão de dependências;
* Swagger: Documentação interativa da API;

#### Requerimentos
Para executar o sistema, é necessário ter Java 11 e Docker instalados na máquina.

#### Inicialização do sistema
Execute os comandos abaixo na raíz do projeto <br />
docker-compose up -d <br />
./gradlew clean build <br />
java -jar ./build/libs/final-grades-1.0.jar.


#### Swagger
* [Swagger](http://127.0.0.1:8080/swagger-ui/#/app-controller)
* [Documentação](http://127.0.0.1:8080/v2/api-docs)

#### Versionamento
O projeto foi versionado pela URL no modelo path, por ter o visual mais limpo e ser mais amigável ao desenvolvedor.
