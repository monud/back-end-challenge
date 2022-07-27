# Space Flight News - Desafio backend Coodesh

Título: Space Flight News - Desafio backend Coodesh
Descrição: Uma descrição sobre o projeto em frase
Linguagem: Springboot, JPA e hibernate

This is a challenge by Coodesh

Como instalar e usar o projeto (instruções):

Este aplicativo é empacotado como uma war que possui o Tomcat 8 incorporado. Nenhuma instalação do Tomcat ou JBoss é necessária. Você o executa usando o comando ```java -jar```.

* Clone este repositoio 
* Use o JDK 1.8 e Maven 3.x
* Você pode construir o projeto e executar os testes executando ```mvn clean package```
* Uma vez construído com sucesso, você pode executar o serviço por um destes dois métodos:
```
        java -jar -Dspring.profiles.active=test target/space-flight-news-main-0.1.0.war
ou
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
```
* olhe o stdout ou boot_example.log para ter certeza que não ocorreu uma exception

Once the application runs you should see something like this

```
 s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8090 (http)
 com.skyflight.Application        : Started Application in 22.285 seconds (JVM running for 23.032)
```