# Spring Cloud Gateway

* Gateway 란, 일종의 '통로' 다.
* 서비스로 전달되는 모든 API 요청의 한 관문의 역할을 하는 것이 Gateway 이다.
* Netflix Zuul 을 대체할 수 있는 역할을 함.

* 모든 요청들의 관문이기 때문에, 각 요청들에 대해 인증이나 보안을 적용하는 데에 이점이 있음.
* 동적 라우팅이 가능



### 3가지 구성요소

* Route (경로)
  * 응답을 보낼 목적지 uri, 필터 항목을 식별하기 위한 ID로 구성되어 있다.
* Predicate
  * 조건에 대한 정의를 하고, 해당 HTTP 요청이 조건에 부합하는지 검사한다.
  * Java8 의 Function Predicate
* Filter
  * SCG 로의 요청을 하면, Gateway Handler가 이 요청에 대한 조건을 검사한다. 해당 요청에 필요한 특정한 필터체인들을 거쳐 요청을 최종적으로 수행
  * 이 과정에서 Global Filter, Custom Filter를 거치는데, 해당 필터들에서 인증, 로깅 등의 구현이 가능하다. Filter에서는 요청과 응답값을 필요에 따라 수정할 수 있다.

```yaml
spring:
	cloud:
		gateway:
			routes:
				- id: user-service  
				  uri: http://localhost:8081
				  predicates:
				   - Path=/welcome/**
				  filters:
				   - name: UserFilter
				     args:
				        baseMessage: productFilter
				        preLogger: true
				        postLogger: true
```

