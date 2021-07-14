### 2021.01.15 ROWNUM = 2

쿼리를 짜다보면 ROWNUM 을 쓸 일이 종종 있다.

ROWNUM = 1 의 경우, 가장 상위 행을 가져오는 구문이지만, ROWNUM = 2 조건은 2번째 행을 가져오지 않는다.

ROWNUM = 2 를 가져오기 위해 ROWNUM = 1 인 첫번째 행은 제외되게 되고, 그럼 다시 두번째행은 첫번째 행이 되는 식이다.

따라서, ROWNUM = 2 이나 ROWNUM <= 10 과 같은 조건을 사용하고 싶을 땐, 바로 해당 쿼리문의 조건문이 아니라, 한번 더 감싸서 바깥 쿼리문에서 조건을 걸어주면 된다.

```sql
SELECT

FROM (
      SELECT ROWNUM AS RNUM

           , AAA FROM TBL

     ) T

WHERE T.RNUM <= 10
```

다음과 같이 ROWNUM 을 사용하면 원하는 대로 결과를 추출가능하다.