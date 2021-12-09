### JPA (Java Persistant Application)

------

#### JPA란

* 자바 진영의 ORM기술 표준
  * ORM이란, 객체와 관계형 데이터베이스를 매핑 한다는 의미

#### JPA 장점

* 생산성
  * 자바 컬렉션에 객체를 저장하듯 JPA에 저장할 객체를 전달하면, 반복적인 일은 JPA가 처리

#### 영속성 컨텍스트(persistence context)

* 엔티티를 영구 저장하는 환경
* 엔티티 매니저를 통해 저장 혹은 조회를 하게 되면, 엔티티 매니저는 영속성 컨텍스트에 엔티티를 보관 및 관리를 함.

##### 장점

* 1차캐시

  * DB커밋이 이루어지기 전까지 캐시에 엔티티를 저장해 성능상 이점이 있다.

* 동일성보장

  * 식별자가 같은 엔티티 인스턴스를 조회하면, 해당 인스턴스가 같은 인스턴스가 된다는 것을 보장한다.

  ```java
  CoffeeMachine cm1 = em.find(CoffeeMachine.class, "id1");
  CoffeeMachine cm2 = em.find(CoffeeMachine.class, "id1");
  
  cm1 == cm2 // 참
  ```

* 트랜잭션을 지원하는 쓰기 지연

* 변경감지

  * update 와 같은 메서드를 사용하지 않더라도, 변경을 감지한다.

  ```java
  CoffeeMachine cm1 = new CoffeeMachine();
  cm1.setModelName("cm1");
  em.persist(cm1);
  
  cm1.setModelName("cm2"); // 변경 자동 감지해 영속성 컨텍스트에 반영 
  ```

* 지연로딩

