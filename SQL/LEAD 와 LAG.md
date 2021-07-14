### 2021.02.28 LEAD 함수

```sql
SELECT PERS_NO  
     , A.OFORD_FR_DT  
     , CASE WHEN LEAD(A.OFORD_FG_CD) OVER (ORDER BY A.PERS_NO, A.OFORD_SEQ) LIKE 'D%'  
THEN LEAD(A.OFORD_FR_DT) OVER (ORDER BY A.PERS_NO, A.OFORD_SEQ)  
ELSE A.OFORD_TO_DT  
END AS OFORD_TO_DT  
FROM TABLE A  
ORDER BY A.PERS_NO, A.OFORD_SEQ
```

오늘은 LEAD 구문을 썼다. 
특정 컬럼을 기준으로 정렬하여 자기보다 바로 다음 행의 값을 가져올 수 있는 함수이다.

LEAD 함수와 짝을 이루는 LAG 함수도 있는데, LAG 함수의 경우 이전행의 값을 가져오는 함수이다.

> ##### LEAD (컬럼) OVER(ORDER BY 정렬컬럼)
>
> ##### LAG (컬럼) OVER(ORDER BY 정렬컬럼)



