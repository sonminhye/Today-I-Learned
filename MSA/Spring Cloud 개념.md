# Spring Cloud

* MSA 를 지원하기 위한 프레임워크
* 공식 사이트 URL - https://spring.io/projects/spring-cloud



### MSA 구축을 위해 필요한 부분들

* 환경 설정관리를 위해, Spring Cloud Config Server 필요
  * 여러 msa 서비스들의 설정정보를 한 곳에 저장하기 위한 저장소
* 각 서비스의 등록, 위치정보
  * Naming Server (Eureka)

* 로드밸런싱
  * Ribbon (Client Side)
  * Spring Cloud Gateway

* REST Template 등을 이용해 통신
  * FeignClient
* 모니터링
  * Zipkin Distributed Tracing
  * Netflix API Gateway
* 장애 회피
  * Hystrix

