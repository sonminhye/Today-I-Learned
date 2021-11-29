### Static 과 Final

------

### static

* 메모리에 한 번 할당하고자 할 때 사용. 프로그램의 시작과 동시에 끝날때까지 할당이 되며, static이 붙은 변수나 메소드는 프로그램 내 전역적으로 사용가능함.
* 모든 객체가 공유하는 메모리라는 점에서 장점이 있으나, 많이 사용하게 될 경우 시스템 성능에 영향이 있을 수 있음.
* 보통, **클래스(class)**의 경우, static 영역에 생성되며, new 연산을 통해 할당받은 객체의 경우 heap 영역에 생성
  * 자바 힙(heap) 영역 : 객체들이 할당되는 공간. 사용이 끝난 객체들은 GC에 의해 시간이 지나면 제거된다.
  * 자바 Static 영역 : 프로그램의 시작과 동시에 끝날때까지 할당되는 공간. 



#### static 필드

* 클래스변수(클래스에 귀속된 변수). 
* 인스턴스 생성이 되지 않더라도, 사용이 가능한 변수이다.
  * 물론, 인스턴스로도 접근가능함.
* 인스턴스간 공유가 가능한 변수
  * 싱글턴 패턴에서도 쓰임.

```java
public class Singleton {
	private static Singleton instance;	
	private Singleton(){};
	public static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton(); // 할당되지 않았을 시 단 한번 할당
		}
		return instance;
	}
}
```



#### static 메소드

* 인스턴스가 생성되지 않아도 사용가능한 메소드
* 주로, 유틸클래스에 static 메소드를 많이 사용함.
  * java.lang.Math 클래스
  * 아래와 같이 인스턴스를 생성하지 않고도 abs라는 static 메소드를 사용가능하다.

```java
import java.lang.Math;

public class Main
{
	public static void main(String[] args){
		System.out.println(Math.abs(-10)); // 10
	}
}
```



### final

* 초기화가 되고 난 후 값을 변경할 수 없다.



#### final 필드

* 선언 시에 값을 초기화 하거나, 선언 후 생성자를 통해 초기화 가능하다. 
* 초기화 하지 않으면 컴파일 에러가 발생한다.



#### final 객체

* 객체 변수를 final로 선언하면, 다른 객체를 지정불가능함.
* 클래스의 필드는 변경 가능

```java
public class Main {
	public static void main(String[] args){
		final finalClass = new FinalClass();
		finalClass = new FinalClass(); // 불가능함
		finalClass.setName("A"); // 클래스 필드 변경 가능
	}
}
```



#### final 클래스

* 클래스에 final 을 사용하게 되면, 상속이 불가함.
* 필드는 setter 를 통해 변경 가능.



#### final 메서드

* 해당 클래스를 상속받은 자식클래스에서 재정의 불가함.



**참고**

https://imasoftwareengineer.tistory.com/73

jvm 관련 - https://steady-snail.tistory.com/67