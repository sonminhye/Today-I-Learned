### Effective Java 6장 열거형과 어노테이션

#### 규칙 31. ordinal 대신 객체필드를 사용하라

---

#### ordinal 이란

* 상수의 순서를 반환하는 함수.

```java
enum Number{
    ONE, TWO, THREE
}

public static void main(){
...
Number num;
num = Gender.ONE;
num.ordinal()+1 // 1 
...
}
```

- 위와 같은 예시처럼, 상수의 값을 가져올 때 ordinal() 함수를 사용해 표현하는 경우가 생길 수 있다.

- 하지만 중간에 상수의 위치가 바뀌어버린다면 해당 구현은 쉽게 깨질 수 있다. ONE 과 THREE의 순서만 바뀌어도 의도하는 바와 전혀 다른 결과를 나타낼 수 있기 때문에 위험하다.

- 따라서, 객체필드를 사용해 상수에 값을 지정해주는 방식을 써야 안전하게 상수에 값을 줄 수 있다.

```java
enum Number{
    ONE(1), TWO(2), THREE(3);
  	
  	private int num; // 객체 필드이용하여 값 지정
  	
  	Number(int num){
      this.num = num; 
    }
}
```

* 위와같이 객체필드를 이용하여 직접적으로 값을 지정하는 방법이 안전하다.

