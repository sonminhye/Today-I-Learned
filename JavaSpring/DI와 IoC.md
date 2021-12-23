### 의존성(Dependency)

* 어떤 객체가 생성되기 위해 다른 객체가 꼭 필요한 관계를 의존관계라고 함.
* 한 클래스가 바뀔 때, 다른 클래스에도 영향이 있다. 주로 **new**라는 키워드를 통해 의존관계가 생성된다.

```java
class CoffeeMachine{
     private Water water = new Water(); 
}
```

* CoffeeMachine 클래스가 Water라는 클래스의 객체를 만들고 있음. (CoffeeMachine는 Water에 의존)
* Water가 아닌, HotWater 객체를 사용하고 싶어도, 코드를 변경하지 않는 이상은 바꿀 수 없음.

#### **의존성 주입(Dependency Injection)**

* new 를 통해 직접 만들어주지 않고 객체에 의존성을 주입해주는 것.

```java
class CoffeeMachine{
    private Water water; 

    public CoffeeMachine(Water water){ // Water 객체를 외부로부터 주입받음.
        this.water = water;
    }
}
```

* 위 코드와 같이 CoffeeMachine 객체를 생성할 시, 아래처럼 의존성 주입이 가능

```java
public interface Water water{
...
}

public class HotWater implements Water{...}
public class SpaklingWater implements Water{...}

class CoffeeMachine {
    private Water water;

    public CoffeeMachine(Water water){
        this.water = water;
    }
}

class Order {
    ...
    public void orderCoffee{
        Water water = new SpaklingWater(); 
    // Water water = new HotWater();  water를 HotWater객체로 바꾸면, CoffeeMachine 클래스 내부의 구현은 변경하지 않고도 coffeeMachine 클래스객체에 HotWater객체를 주입시킬 수 있음.
        CoffeeMachine coffeeMachine = new CoffeeMachine(water); 
    }
}
```

#### **의존성 주입의 장점**

* 객체간의 종속성 및 결합도를 줄일 수 있다.
  
  * 위의 예시처럼, CoffeeMachine 클래스를 생성할 때 필요한 Water 객체에 HotWater, SpaklingWater객체를 손쉽게 갈아끼워 주입해줄 수 있다.

* Unit Test 를 만들기 쉽다
  
  * Mocking 이 쉽다고 하는데, 이 부분은 조금 더 공부해서 보충

#### **의존성 주입의 종류**

* 생성자
  * 생성자 주입은 가장 권고되는 의존성 주입방식이다. OCP원칙을 지킬 수 있다.
  * null객체를 주입하지 않는 이상은 NPE가능성이 없고, 의존관계 주입에 문제가 생길 시 컴파일 타임에 이 문제를 알 수 있다.
  * 수정자를 통해 의존성을 변경할 일이 없으므로, 주입받을 필드에 대해 final로 선언 가능하다.
  * Spring의 생성자 주입의 경우, 순환참조를 컴파일 타임에 알 수 있다는 장점이 있다.
* Setter(수정자)
  * 수정자 주입의 경우, 객체를 주입받지 않은 상태에서도 객체 생성이 가능하다 보니 NPE의 가능성이 존재한다.
* 필드
  * 사용하기 용이하나, Unit Test를 할 수 없다는 단점이 있다.
  * 

### IoC(Inversion of Control) - 제어의 역전

* 의존성 주입을 하는데, 누군가에게서 **의존성을 주입** 받는 것. 
  * 그 누군가는 바로 **스프링 IoC 컨테이너(Application Context).**

... 계속

##### 참고

https://velog.io/@wlsdud2194/what-is-di

https://wordbe.tistory.com/entry/Spring-IoC-빈-등록-방법-5가지

https://umbum.dev/873

백기선 개발자님의 인프런 스프링 무료 강의
