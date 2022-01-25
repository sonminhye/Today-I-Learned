### Effective Java 6장 열거형과 어노테이션

#### 규칙 35. 작명패턴대신 어노테이션을 사용하라.

---

#### 자바 1.5 이전(작명패턴(naming pattern))

* Junit 사용 시, 테스트 메서드 이름을 test로 시작해야만 했음.

* 이 패턴의 경우, 다음과 같은 단점이 존재

  * 철자를 틀리면 알아보기 힘듬

  * 특정 프로그램 요소에만 적용되도록 만들지 못한다. 
    * testSafetyMechanisms 라는 이름의 클래스를 만든다고 하더라도, Junit 은 해당 클래스 내의 모든 메서드를 테스트하지 않는다. (클래스 이름까지는 확인하지 않음)

  * 프로그램 요소에 인자를 전달할 마땅한 방법이 없다.
    * 특정 예외가 발생해야 성공으로 판정되는 테스트를 만들고 싶어도 방법이 존재하지 않음. (예외 자료형 이름을 테스트 메서드 이름에 넣고 싶어도, 좋은 코드 작성 방식이 아님)

#### 자바 1.5 이후(어노테이션)

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interfae Test {

}
```

* 해당 어노테이션의 경우, 아무런 인자도 받지 않는 어노테이션으로 '표식' 의 역할만 한다. 따라서, 어노테이션 자체가 특정한 역할을 하는 것은 아님.

* 다만, 어떠한 프로그램에서 해당 어노테이션을 붙인 메서드 혹은 변수 등에 대해 무언가 처리해주고 싶은 것이 있다면, 어노테이션을 활용할 수 있다. (나는 이렇게 이해함.)

```java
public class RunTest {
		pulibc static void main(String[] args) throws Exception{
			int tests = 0;
			int passed = 0;
			Class testClass = Class.forName(args[0]);
			for(Method m : testClass.getDeclaredMethods()){
				if(m.isAnnotationPresent(Test.class)){  // 여기서 Test 어노테이션을 붙인 메서드를 찾아낸다. 
					tests ++;
					..... // 처리해주고자 하는 내용 등
				}
			}
		}
}
```

* 위처럼, 어노테이션을 메서드에 붙이고 특정 프로그램에서 리플렉션 등의 방법을 통해 무언가 처리하고 싶은 내용을 작성가능하다. 

##### 어노테이션에 인자 넘기기

* @Test(A.class) 처럼, 어노테이션에 인자를 줄 수 있다. @Retention 어노테이션에서도 이런 부분을 볼 수 있는데,

```java
...
@Documented
@Retention(RetentionPolicy.RUNTIME) // (1) @Retention 어노테이션이 RetentPolicy enum 인자를 받고 있음.
@Target(ElementType.ANNOTATION_TYPE)
public @interface Retention {
    /**
     * Returns the retention policy.
     * @return the retention policy
     */
    RetentionPolicy value(); // (2) 다음과 같이 인자타입 선언
}
```

* (1) 처럼, Retention 어노테이션을 사용할 때 RetentionPolicy 라는 Enum 을 넘길 수 있는 것이다. 

* (2) 와 같이 구현해줌으로써 RetentionPolicy를 인자로 받는 Retention이라는 어노테이션이 만들어지는 것이다.
* (2)는 Class<? extends Exception> value() 와 같은 형태로 선언하면, 인자에 예외 클래스를 상속한 하위클래스들이 올 수 있다.
  * @Test(ArithmeticException.class) 와 같은 식으로 호출 가능함.
  * 인자를 배열로도 받을 수 있음.

정리하자면, 어노테이션 방식은 철자가 틀릴 경우 컴파일 할 수 없다. @Target 어노테이션을 통해 어느 범위에 어노테이션을 적용할 것인지를 정할 수 있으며, 인자를 넘길 수 있는 방식이 존재한다. 따라서, 작명 패턴보다는 어노테이션을 구현하는 것이 좋다.

