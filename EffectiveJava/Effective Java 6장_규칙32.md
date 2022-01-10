### Effective Java 6장 열거형과 어노테이션

#### 규칙 32. 비트필드 대신 EnumSet을 사용하라

---

#### 비트필드 열거형 상수

- 연관된 상수들의 **집합**을 비트로 표현한 것을 비트필드라고 한다.

```java
public class Text{
	public static final int STYLE_BOLD = 1 << 0; // 1
	public static final int STYLE_ITALIC = 1 << 1; // 2
	public static final int STYLE_UNDERLINE = 1 << 2; // 4
	public static final int STYLE_STRIKETHROUGH = 1 << 3; // 8
  
  // 이 메서드의 인자는 STYLE_상수를 비트별 OR 한 값이거나 0.
  public void applyStyles(int styles){...}
}

text.applyStyles(Text.STYLE_ITALIC); // 2
text.applyStyles(Text.STYLE_ITALIC | Text.STYLE_BOLD); // 3 (1)
```

* 상수들을 집합에 넣을 때, 합집합 혹은 ㅛ집합 등의 집합연산을 효율적으로 실행할 수 있지만, int enum 패턴과 동일한 단점을 갖고있다.
* 비트필드가 출력될 때, 단순한 정수 열거상수를 출력하는 것 보다 어떤 의미인지 해석하기가 어렵다는 단점이 있다.
  * (1) 위 예제에서 다음과 같이 style 이 지정되어 출력했을 때, 숫자 3이 무엇을 의미하는지 알아보기가 힘들다.
* 필드에 포함된 요소들을 순회하기도 어렵다.

#### EnumSet

* 갯수가 제한된 상수들의 집합. 그 중 Enum 자료형으로 구성된 집합을 효율적으로 표현 가능한 특별한 자료구조
* 내부적으로 비트 벡터를 사용함.
* Enum 갯수에 따라서 서로 다른 구현체를 사용한다.
  * 64개 이하일 때는 RegularEnumSet을 사용(단일 long형)
  * 64개 이상일 때는 JumboEnumSet을 사용(long배열)

* HashSet과 같은 타 구현체와 비교 시, Enum의 경우 예상가능한 순서대로 저장이 되어있고, 1개의 비트만이 필요하여 더 빠르다고 볼 수 있다.

```java
public class Text{
	public enum Style{BOLD, ITALIC, UNDERLINE, STRIKETHROUGH};

  public void applyStyles(Set<Style> styles){...}
}

text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC)); 
```

* 위처럼 EnumSet을 이용하였을 때, 형안정성을 보장받을 수 있다. (Style Enum 타입만 Set클래스 안에 들어갈 수 있음.)
* 내부적으로는 removeAll 또는 retainAll 과 같은 일괄 연산들도 비트단위 산술연산을 통해 구현되므로, 비트필드를 수작업으로 조작할 때와 같은 절차를 밟는다.
  * 우리가 비트필드를 직접적으로 조작하지 않아도 복잡한 부분은 EnumSet이 처리해준다.

#### 결론

* 결론적으로, 열거 자료형을 집합에 사용해야 한다고 비트필드로 표현하는 것은 좋지 않은 방식이다. 
* EnumSet의 단 한가지 장점은, 자바 1.6에서는 변경불가능(immutable) EnumSet객체를 만들수 없다는 것이다.
  * 그 때 까지 EnumSet 객체를 Collections.unmodifiableSet으로 포장하는 방식을 사용하여야 함.
