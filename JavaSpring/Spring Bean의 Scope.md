### Spring Bean Scope

#### 스프링 빈

* 스프링에 의해 생성되고 관리되는 객체

#### 스프링 빈 Scope

* 스프링 빈 Scope의 종류에는 singleton, prototype, (request, session, global session : Spring MVC Web Application에서 사용) 이 있다.
  
  * singleton : 하나의 Bean에 대해 Spring IoC Container에 단 하나의 객체만 존재
  
  * prototype : Bean 주입 시마다 새로운 객체 생성

* 별도의 설정을 하지 않는다면, 보통 singleton 방식으로 빈이 관리된다.

* 주입받는 빈의 경우 같은 객체라는 것을 보장받는 것.

##### Singleton

* 생성이 된 Bean의 경우, single beans cache에 저장된다. 

* bean에 대한 요청 및 참조가 있을 경우 cache된 객체가 반환된다.

##### Prototype

* 모든 요청에 대해 새로운 객체가 생성된다.

* GC에 의해 bean이 제거되게 된다.


