## Spring Boot 에서 Spring Security 적용하기

* Configuration 파일 설정

```java
package com.coin.diary;

...

@Configuration
@EnableWebSecurity // (1)
@EnableGlobalMethodSecurity(prePostEnabled = true) // (2)
public class SecurityConfig extends WebSecurityConfigurerAdapter {// (3)
...
}

```

* (1) SpringSecurity 에 대한 설정을 해주기 위해 해당 어노테이션 사용
* (2) @EnableGlobalMethodSecurity 어노테이션의 경우, 특정한 메서드에 권한 처리를 할 때 사용한다.
  * prePostEnabled : @Secured 어노테이션을 사용해 인가처리
  * securedEnabled : @PreAuthorize, @PostAuthorize 어노테이션 사용해 인가처리
  * jsr250Enabled : @RolesAllowed 어노테이션 사용하여 인가처리

* (3) WebSecurityConfigurerAdapter 
  * WebSecurityConfigurer 객체를 만들기 위한 편리한 기본적인 기초 클래스를 제공하기 위함. 해당 클래스의 메서드를 재정의함으로써 커스터마이징 할 수 있다.
    * HttpSecurity 라는 API를 제공하는 클래스를 생성가능하다.



... 이어서 추가 예정

