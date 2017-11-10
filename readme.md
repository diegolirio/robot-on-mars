# Robot On Mars

### Documentation

- Api http://31.220.55.236:5003/robot-on-mars/swagger-ui.html
- curl -s --request POST http://31.220.55.236:5003/robot-on-mars/rest/mars/MMRMMRMM

> O `http://31.220.55.236:5003` é uma proxy (Zuul) que respectivamente aponta para duas (ou mais) instancias da aplicação, `http://31.220.55.236:8090/rest/mars/MM` e `http://31.220.55.236:8091/rest/mars/MM`.