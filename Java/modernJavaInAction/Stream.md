Stream 실습 예제

```java
package stream;

public class Dish {
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;
	
	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getVegetarian() {
		return this.vegetarian;
	}
	
	public int getCalories() {
		return this.calories;
	}
	
	public Type getType() {
		return this.type;
	}
	
	@Override 
	public String toString() {
		return name;
	}
	
	public enum Type {MEAT, FISH, OTHER};
}
```

```java
package stream;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 데이터 소스는 menu 가 된다.
		// 연속된 요소를 스트림에 제공하게 된다.
		List<Dish> menu = Arrays.asList( 
				new Dish("pork", false, 800, Dish.Type.FISH),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));	
		
		
		// 스트림에 filter, map, limit, collect로 이어진 데이터 연산이 적용되도록 한다.
		List<String> threeHighCaloriesDishName = menu.stream() 
													  .filter(dish -> dish.getCalories() > 300) // 람다를 인수로 받아 스트림에서특정 요소를 제외시킴.
													  .map(Dish::getName) // 람다를 이용해 한 요소를 다른요소로 변환 혹은 정보를 추출
													  .limit(3) //정해진 개수 이상의 요소가 스트림에 저장되지 못하도록 스트림크기를 축소
													  .collect(toList()); // 스트림을 다른 형식으로 변환. -> 다양한 변환 방법을 인수로 받아,스트림에 누적된 요소를 특정한 결과로 변환시키는 기능을 한다.
		
		
		List<Integer> threeHighCaloriesDishCalories = menu.stream()
				  .filter(dish -> {
					  System.out.println("filtering:" + dish.getName());
					  return dish.getCalories() > 300;
					  })
				  .map(dish -> {
					  System.out.println("mapping:" + dish.getCalories());
					  return dish.getCalories();
					  })
				  .limit(3)
				  .collect(toList());

		  //.map(Dish::getName)
		  //.limit(3)
		System.out.println(threeHighCaloriesDishCalories);
		System.out.println(threeHighCaloriesDishName);
		
		// Collection -> 모든 연산은 Collection에 들어가기 전에 이미 완료되어야 함.
		// Stream 의 경우는, 요청할 때만 연산을 함
		
	}
}
```

참고

모던 자바 인 액션