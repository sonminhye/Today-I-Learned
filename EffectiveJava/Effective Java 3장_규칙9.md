### Effective Java 3장 객체의 생성과 삭제

#### 규칙 9. equals 를 재정의할 때는 반드시 hashCode도 재정의하라

------

#### HashCode의 일반규약

* 응용 프로그램 실행 중 같은 객체의 hashCode 는 언제나 동일한 정수가 반환되어야 함
* equals(Object) 가 같다고 판정한 두 객체의 hashCode 객체의 값은 같아야 함
* equals(Object) 가 다르다고 판정한 두 객체의 hashCode 값은 무조건 다를 필요는 없음. 단, 서로 다른 hashCode 값이 나오면 해시테이블의 성능이 향상될 수 있다.

#### hashCode 재정의 시 주의점

성능개선을 위해 객체 중요부분을 해시코드 계산 과정에서 생략하면 안됌.

간단한 구현방식

```java
@Override
public int hashCode(){
	int result = message.hashCode();
	return result;
}
```

속도를 고려한 구현 방식

```java
@Override 
public int hashCode(){
	return Objects.hash(modelName, company);
}
```

* 속도가 느려질 때는 lazy init 이나 caching을 고려해 볼 수 있다. 핵심 필드를 누락하지 않아야 한다.



**Lombok을 사용하면, 조금 더 편하게 Equals 와 HashCode 를 재정의가능하다.**

@EqualsAndHashCode 어노테이션

callSuper속성을 통해, equals 와 hashCode 메소드 생성 시, 부모클래스의 필드까지 감안할지 여부 설정 가능하다.

Exclude를 사용하면, 어떤 필드를 비교대상에서 제외시킬지를 지정가능하다.

