사용자 입장에서 간단 명료하게 설계

http의 장점을 최대한 살려서

리소스의 형태에 따라서 Request Methods

- GET/POST/PUT/DELETE

적절한 Response Status 코드를 전달

* 200/404/400/201/401 등

URI에는 보안에 치명적인 데이터를 포함해서는 안된다.

복수형으로 지칭하는 것이 좋다.

* /user 보다는 /users
* /user/1 보다는 /users/1

명사형 리소스가 좋다

일괄된 접근 엔드포인트를 두는 것이 좋다. 

* 하나의 URI의 엔드포인트로 http 메서드만 다르게 함.