### Effective Java 6장 열거형과 어노테이션

#### 규칙 30. int상수 대신 enum을 사용하라.

---

#### Enum이란

- 고정개수의 상수들로 값이 구성되는 자료형
  - 기존의 int enum 패턴의 경우, 초기화를 잘못 하거나 하는 등의 오류가 있더라도 컴파일 에러가 나지 않는다. 또한, enum그룹의 크기를 알기가 어렵고 출력을 해도 해당 enum의 숫자만 보인다.
- enum자료형의 경우, 동일한 이름의 상수도 namespace가 분리 되기 때문에 사용가능하다.
- 열거 상수 별로 하나의 객체를 public static final 형태로 제공한다. 클라이언트가 접근 가능한 생성자가 없으므로, final 선언된 것이나 마찬가지이다.

```java
enum Gender{
    MALE, FEMALE
}

public static void main(){
...
Gender gender;
gender = Gender.MALE;
...
}
```

* 위처럼 Gender에 대한 객체를 만들지 않고, Gender.MALE을 지정해주었다. enum 자료형의 상수 하나하나는 public static final 형태와 다름없다.

* gender 변수에 "male" 과 같이 enum 에 속하지 않은 값을 지정하려고 하면 컴파일 에러가 난다. **컴파일 시점의 형안정성**을 제공한다고 볼 수 있다

```java
public enum Planet{
    
    MERCURY(3.302e+23, 2.439e6),
    EARTH(5.975e+24, 6.378e6);

    //(1) 객체 필드 선언(상수에 중량과 반지름이라는 데이터를 넣기 위해)
    private final double mass;   
    private final double radius;

    //(2) 생성자의 경우 public으로 선언 불가하다.
    Planet(double mass, double radius){
        this.mass = mass;
        this.radius = radius;
    }
    
    //(3) 필드를 public 으로 두고 접근자 메서드를 두는 것이 좋다.
    public double mass();
    public double radius();

}
```

(1)  enum 상수에 데이터를 넣기 위해서는 객체 필드를 선언해야 하며, 생성자를 통해서 받은 데이터를 해당 필드에 저장하는 형태로 사용하여야 한다. 객체 필드는 **변경불가능**하므로 final 선언되어야 한다.

(2) 생성자의 경우 public 으로 선언이 불가하기 때문에 외부에서 수정이 불가능하다.

(3) 객체 필드를 public 으로 두는 것 보다는, 객체 필드에 접근할 수 있는 접근자 메서드를 두는 것이 좋다. 

#### Enum의 특징

* 클래스를 상수처럼 활용이 가능하다.

* enum 선언 상수의 경우, 클래스가 로드될 때 생성이 되기 때문에 singleton방식으로 구성된다.

* enum 의 경우, 기본 toString 메서드도 이미 갖춰져 있으며, 해당 출력결과가 만족스럽지 않을 경우에 함수를 재정의 가능하다.

```java
public enum Fruits {
	APPLE(1), ORANGE(2), PINEAPPLE(3);
	
	private int order;
	
	Fruits(int order){
		this.order = order;
	}
	
	public int order() {
		return this.order;
	}
	
    // toString 함수 재정의 
	@Override
	public String toString() {
		return this.name() + " is "+ this.order;
	}
}
```

#### Enum의 응용

* 각 상수별로 클래스 **몸체 안에 메서드**를 구현할 수 있다.

```java
public enum Fruits {
	APPLE(1){
        // (1) 상수별로 몸체 안에 메서드를 구현해줄 수 있다.
		@Override
		int method() {
		    ...
		}
	}, ORANGE(2){
		@Override
		int method() {
			...
		}
	}, PINEAPPLE(3){
		@Override
		int method() {
			...
		}
		
	};
	
    // (2) abstract 메서드로 선언 시, 각 상수는 해당 메서드를 구현하도록 강제한다.
	abstract int method();
    
    // (3) 메서드를 구현하고 상수별 처리를 구현해주는 방법도 있다. 
    int method1(){
        switch(this){
           case APPLE : .... ;
           case ORANGE : .... ;
           case PINEAPPLE : ...;
        }   
    }
```

* 상수별로 무언가 수행해줘야 하는 행위가 있을 때 (3) 처럼 메서드를 만들고 각 상수별로 switch case 문으로 분기를 처리해줄 수도 있지만, (2) 와 같이 추상메서드로 구현할 경우, 상수별로 (1) 과 같이 메서드를 구현가능하다.

* 새로운 상수가 추가될 때 (3) 의 방식대로라면 구현을 잊을수도 있다. 반면 (1) 과 같은 방식의 경우는 컴파일러가 상수별로 해당 메서드를 구현하도록 강제하기 때문에 메서드를 구현하는 것을 잊을 일이 없다. 따라서 더욱 안전하다는 장점이 있다.
