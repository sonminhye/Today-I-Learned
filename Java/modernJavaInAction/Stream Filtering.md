## 스트림필터링

스트림의 경우, 2가지의 필터링 방법이 존재

#### 프레디케이트 필터링

* 프레디케이트는, boolean 을 반환하는 함수
* filter 메서드를 활용하여 프레디케이트를 인자로 넘겨 원하는 요소를 걸러낼 수 있음.

```java
class Dish {
	boolean vegetarian;
	....
	public boolean isVegetarian (return this.vegetarian;)
}

Main {
....
  
// 프레디케이트 (불리언반환함수) 를 통해 filtering
List<Dish> vegetarianMenu = menu.stream()
.filter(Dish::isVegetarian) // (1) isVegetarian 이라는 프레디케이트를 filter 의 인자로 넘김
.collect(toList());
  
...
}

```

* (1) 처럼, boolean을 반환하는 isVegetarian 함수를 filter 메서드의 인자로 넘겨 vegetarian 이 true 인 요소만 뽑아내도록 함.

#### 고유요소 필터링

* 고유 요소로 이루어진 스트림을 반환하는 distinct 메서드가 있다. 
  * 고유 여부는 스트림에서 만든 객체의 hashCode , equals 를 통해 결정 

```java
// 고유요소로 필터링 (distinct 를 이용한 중복 필터링)
List<Integer> numbers = Arrays.asList(1,2,1,2,3,2,4,5);

numbers.stream()
   .filter(i -> i % 2 == 0)
   .distinct() // (1) distinct 를 통해 고유한 원소만 필터링
   .forEach(System.out::println); // (2) 2 4 
```

* filter 메서드로 짝수만 걸러낸 다음, (1) 과 같이 distinct 를 이용해 고유한 원소만 필터링 한다.