package stream;

import java.util.Arrays;
import java.util.List;

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
		
		// 2011에 일어난 모든 트랜잭션을 찾아 오름차순으로 정리하시오.
		transactions.stream().filter(i -> i.getYear() == 2011)
							.map(i -> i.getValue())
							.sorted()
							.forEach(System.out::println);
		
	}
}
