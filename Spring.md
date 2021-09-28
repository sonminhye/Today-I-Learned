**Spring DI 컨테이너의 개념**

Spring DI 컨테이너가 관리하는 객체를 빈(Bean)이라고 하고, 빈 들을 관리한다는 의미로 컨테이너를 빈 팩토리(Bean Factory)라고 부름.

-> Bean Factory에 여러가지 컨테이너 기능을 추가하여 어플리케이션 컨텍스트(Application Context)라고 부름.

| **Bean Factory**        | - Bean을 등록, 생성, 조회, 반환 관리함. - 보통은 BeanFactory를 바로 사용하지 않고, 이를 확장한 Application Context를 사용. - getBean() 메소드가 정의되어 있음. |
| ----------------------- | ------------------------------------------------------------ |
| **Application Context** | - Bean을 등록, 생성, 조회, 반환 관리하는 기능은 BeanFactory와 같음 - Spring의 각종 부가 서비스를 추가로 제공 - Spring이 제공하는 ApplicationContext 구현 클래스가 여러 가지 종류가 있음. |