## SpringBoot 의 동작원리

* application.yml 혹은 application.properties 에서 설정사항들 정의

```properties
server.port=9000   // (1) application.properties

server:       // (2) application.yml
  port:9000
```

##### Request 와 Response 를 받는과정에는 아래와 같은 것들이 필요하다.

* DispatcherServletAutoConfiguration

* ErrorMvcAutoConfiguration

* HttpMessageConvertersAutoConfiguration -> JSON Convert

#### Dispatcher

* 클라이언트의 요청을 한 곳으로 보낸다.
* 요청에 맞는 Handler로 요청을 전달
* Handler의 실행결과를 Http Response 형태로 만들어서 반환

#### RestController

* Spring4부터 @RestController 를 지원

* @Controller + @ResponseBody
  * 기존의 @Controller 에서 JSON형식의 데이터 반환을 위해서는 리턴 자료형 앞에 @ResponseBody를 선언해주어야 했음(ex. Ajax 에서 쓸 때 등)

* View를 갖지 않는 REST Data(JSON/XML) 을 반환한다.



