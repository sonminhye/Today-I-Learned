### Effective Java 4장 클래스와 인터페이스

#### 규칙 14. public 클래스 안에는 public 필드를 두지 말고 접근자 메서드를 사용하라

------

```java
class Point{
	public double x;
	public double y;
}
```

위와 같이 데이터 필드를 조작가능한 pubic 필드를 가진 클래스의 경우, 캡슐화의 이점을 누리기 어려우며, API변경 없이 내부표현 변경 불가능.

#### 선언된 패키지 밖에서도 사용 가능한 클래스에는 접근자 메서드를 제공할 것

* public 클래스의 데이터 필드를 공개할 경우, 내부의 표현을 변경할 수 없음.
  * 예를들어, 위의 Point 클래스에서 x를 a로 바꾸고 싶더라도, 클라이언트 코드에서 Point.x와 같은 형태의 코드들이 존재한다면 문제가 생길 수 있기 때문.

* package-private이나, private 중첩 클래스(nested class)는 데이터 필드 공개에도 잘못은 아님.

public 으로 열 경우, thread Safe 하지 못한 상황이 생김(Lock 류의 작업을 걸지 못함)

