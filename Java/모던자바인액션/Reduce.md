## Reduce

* reduce 는 새로운 값을 이용해 스트림의 모든 요소를 소비할 때 까지 람다를 반복실행하는 함수이다.

```java
List<Integer> numbers = Arrays.asList(1,2,3,4,5)
int sum = numbers.stream().reduce(0, Integer::sum);  // 15
Optional<Integer> max = numbers.stream().reduce((a, c) -> a < c ? c : a ); // 5
```

Reduce 함수의 디스크립터는 (T , T) -> T 이다. **스트림의 두 요소를 합쳐 하나의 값을 만든다.**

0 + 1 = 1 이 리턴

1 + 2 = 3 이 리턴

...

와 같은 방식으로 누적된 합계를 다시 첫번째 인자로 하고 다음 스트림 요소와의 sum을 계산한다.