### 2021.01.15 ORDER BY 문에 DECODE 쓰기

오늘 짜려는 쿼리 중 order by 를 사용하여야 하는 부분이 있었다.

학기 코드 컬럼이 있었는데 '1', 'S', '2', 'W' 와 같은 형식의 코드로 저장되는 컬럼이었다.

S, W 는 각각 여름학기, 겨울학기로 1학기 다음이 S, 2학기 다음이 W 순서로 정렬이 되어야만 했다.

이처럼 문자와 숫자가 함께있는 경우엔 어떻게 Order by 를 사용해야 하는지 고민했다.

Case when 문으로 각각의 코드를 다시 1,2,3,4 와 같은 코드형식으로 치환하여 한번 더 쿼리문을 감싸 정렬해야 하나, 고민하던 중,

Order by 문에 Decode 를 쓰는 방법을 생각했다.

```sql
ORDER BY DECODE(SHTM_CD, '1', '1', 'S', '2', '2', '3','W', '4', '1') 
```

오더바이 문에 다음과 같이 Decode 문을 쓰면 성능상 문제가 발생하지 않을지 고민해봐야 겠지만, 이 방법으로 간단하게 코드를 정렬할 수 있었다.

