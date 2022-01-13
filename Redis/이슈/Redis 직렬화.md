### Redis 직렬화 관련 오류

[DefaultSerializer requires a Serializable payload but received an object of type](https://minholee93.tistory.com/entry/ERROR-DefaultSerializer-requires-a-Serializable-payload-but-received-an-object-of-type)

- @Cacheable 어노테이션을 적용하였는데, 대상객체의 경우,= Serializable 인터페이스를 구현해야 했다.

#### 직렬화

- 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부 자바 시스템에서도 사용할 수 있도록 byte 형태로 데이터를 변환하는 기술
  - 역직렬화 : byte 형태의 데이터를 자바 시스템 내부에서 사용할 수 있도록 객체로 상주시키는 형태

* Redis 캐시 서버에 자바 객체데이터를 등록하기 위해, 캐시적용을 해줄 대상객체의 직렬화가 필요하다. 따라서, Serializable 인터페이스를 구현하도록 해주었다.

[CoinDiary 프로젝트 - Coin클래스](https://github.com/sonminhye/CoinDiary/blob/main/src/main/java/com/coin/diary/entity/Coin.java)

[CoinDiary 프로젝트 - Diary클래스](https://github.com/sonminhye/CoinDiary/blob/main/src/main/java/com/coin/diary/entity/Diary.java)

```java
@Entity
@Table(name="COIN")
@Getter
@Setter
@IdClass(CoinId.class)
@ToString
public class Coin implements Serializable{ // (1) Serializable 인터페이스 구현
	
	@Id
	@Column(name="COIN_CODE")
	private String coinCode;
	
	@Id
	@Column(name="MARKET_CODE")
	private String marketCode;
	
	@Column(name="COIN_NAME")
	private String coinName;
	
}


@Entity
@Table(name="DIARY")
..
public class Diary implements Serializable{ // (2) Serializable 인터페이스 구현
	
	...
    
	private Coin coin;
	
}
```

* (1) 과 (2) 처럼 Serializable 인터페이스를 각각 구현해주었다.

```java
	@Cacheable(value="diaryNo", key="#diaryNo")
	@Override
	public Diary find(Integer diaryNo) {
		// TODO Auto-generated method stub
		return diaryRepository.findById(diaryNo).get();
	}
```

* Diary 객체를 Redis 에 등록해주었다.



참고

직렬화 관련 참고할만한 글 - https://techblog.woowahan.com/2550/