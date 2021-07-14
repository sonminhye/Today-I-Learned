### 2021.07.14 오라클 IS_NUMBER

오라클에서 숫자여부를 확인하는 방법

* REGEXP_INSTR(정규식 문자열 검색 함수, Oracle 10g 이상에서 사용가능)
  * REGEXP_INSTR([숫자값], '[^0-9]') = 0

- TRANSLATE(문자열 치환함수, Oracle 8i 이상에서 사용 가능)
  - TRANSLATE([숫자값], 'A1234567890', 'A') IS NULL
  - 숫자를 찾아 치환 후 남은 문자가 존재할 시 숫자 아님
- IS_NUMBER(컬럼) = 1
  - 숫자일 때 1, 문자일 때 0 반환



VARCHAR2 형식의 컬럼에서 숫자만을 추려 Max값을 구해야 하는 케이스가 있었음.

해당 케이스의 경우, WHERE 문에 IS_NUMBER(컬럼) = 1 조건을 통해 숫자만을 비교하여 Max 값을 찾을 수 있었음.