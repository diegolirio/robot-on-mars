# Robot On Mars

### Documentation

- Api http://31.220.55.236:5003/robot-on-mars/swagger-ui.html
- curl -s --request POST http://31.220.55.236:5003/robot-on-mars/rest/mars/MMRMMRMM

> O `http://31.220.55.236:5003` é uma proxy que respectivamente aponta para duas (ou mais) instâncias da aplicação, `http://31.220.55.236:8090/rest/mars/MMRMMRMM` e `http://31.220.55.236:8091/rest/mars/MMRMMRMM`, possibilitando uma escalabilidade.

> As instâncias `ROBOT-ON-MARS` podem ser vista em http://31.220.55.236:5002.

##### Tecnologias

- `Java 8`
- `Spring Framework`
- `Spring Boot`
- `Spring Cloud`
- `JUnit4`
- `IDEs: Spring Tool Suite e IntelliJ`
- `Tomcat Embedded`
- `Linux`

Padrões:   
`Template Method` `Strategy` `Builder` `SRP` `OCP` `ISP`.

> Obs: Servidor utilizado somente para estudos e desenvolvimento, não suporta um processamento em massa.
