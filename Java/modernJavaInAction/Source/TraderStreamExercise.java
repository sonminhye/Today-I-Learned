package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class TraderStreamExercise {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
			new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000),
			new Transaction(raoul, 2011, 400),
			new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700),
			new Transaction(alan, 2012, 950)
		);
		
		System.out.println("2011에 일어난 모든 트랜잭션을 찾아 오름차순으로 정리하시오.");
		// (1) 2011에 일어난 모든 트랜잭션을 찾아 오름차순으로 정리하시오.
		transactions.stream().filter(i -> i.getYear() == 2011)
							.map(i -> i.getValue())
							.sorted()
							.forEach(System.out::println);
		
		System.out.println("거래자가 근무하는 모든 도시를 중복없이 나열하시오.");
		// (2) 거래자가 근무하는 모든 도시를 중복없이 나열하시오.
		transactions.stream().map(transaction -> transaction.getTrader().getCity())
							.distinct()
							.forEach(System.out::println);
		
		System.out.println("케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.");
		// (3) 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
		transactions.stream().map(Transaction::getTrader)
							 .filter(transaction -> transaction.getCity().equals("Cambridge"))
							 .distinct()
							 .sorted(Comparator.comparing(Trader::getName))
							 .collect(Collectors.toList());
		
		System.out.println("모든 거래자의 이름을 알파벳순으로 정렬해서 반환");
		// (4) 모든 거래자의 이름을 알파벳순으로 정렬해서 반환
		transactions.stream().map(transaction -> transaction.getTrader().getName())
							.sorted()
							.distinct()
							.collect(Collectors.toList())
							.forEach(System.out::println);

		System.out.println("4 모범답안");
		String str = transactions.stream().map(transaction -> transaction.getTrader().getName())
										.sorted()
										.distinct()
										.reduce("", (n1, n2) -> n1 + n2); // 이 부분은 joining 으로도 연결 가능하다.
		System.out.println(str);
		
		
		System.out.println("밀라노에 거래자가 있는가?");
		// (5) 밀라노에 거래자가 있는가?
		boolean result = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		System.out.println(result);
		
		System.out.println("케임브리지에 거주하는 거래자의 모든 트랜잭션 값을 출력하시오.");
		// (6) 케임브리지에 거주하는 거래자의 모든 트랜잭션 값을 출력하시오.
		transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
							 .collect(Collectors.toList())
							 .forEach(System.out::println);
		
		System.out.println("전체 트랜잭션 중 최댓값은 얼마인가?");
		// (7) 전체 트랜잭션 중 최댓값은 얼마인가?
		int max = transactions.stream().map(transaction -> transaction.getValue())
							 .reduce(Integer::max).get();
		System.out.println(max);
		
		System.out.println("전체 트랜잭션 중 최솟값은 얼마인가?");
		int min = transactions.stream().map(transaction -> transaction.getValue())
									.reduce(Integer::min).get();
		System.out.println(min);

	}
}
