## JUnit5의 기본어노테이션

#### 기본어노테이션

**@BeforeAll**

* 전체테스트가 시작되기 전 가장 처음 호출

**@BeforeEach**

* 각 테스트가 시작되기 전마다 호출

**@AfterAll**

* 전체테스트가 끝나면 마지막으로 호출

**@AfterEach**

* 각테스트가 끝날 때마다 호출

**@Disabled**

* 해당 테스트를 진행하지 않겠다는 어노테이션



#### 테스트이름표시

**@DisplayName**

* 테스트 각각의 이름을 한글로 표시가능
* @DisplayNameGeneration 보다 우선순위 높음

**@DisplayNameGeneratoration**

* Method와 Class 레퍼런스를 사용해 테스트 이름을 표기하는 방법이다.
* 기본적인 구현체로 ReplaceUnderscores 를 제공한다.