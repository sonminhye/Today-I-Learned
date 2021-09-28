**2021.07.19 인터셉터**

인터셉터에 코드를 추가하여 오랫동안 헤매던 문제를 해결하였다. 

모바일에서 접속해 메뉴를 클릭했을 때 PC환경과 동일한 소스를 열 수 있도록 (웹앱) 구현하였는데, 모바일 환경에서 메뉴 진입시 초기 1번은 항상 목록 조회가 되지 않았다.

모바일 환경 디버깅을 통해, 바로 권한 체크를 하는 인터셉터에서 막히고 있다는 것을 알게 되었다.

임시방편으로 인터셉터 내부 소스에 예외적으로 소스를 추가하였지만, 임시방편일 뿐이고 이를 대체할 해결책을 찾아야 할 것 같다. 아래는 이참에 한 인터셉터에 대한 간단한 정리



#### Interceptor

* 낚아채다, 가로채다는 의미를 가지고 있음.

* 서버로 들어온 사용자의 요청객체를 Controller의 핸들러로 도달하기 전에, **낚아채서** 원하는 작업을 한 후, Controller의 핸들러로 보낼 수 있도록 하는 일종의 필터.
* 주로, 화면 호출 전 권한체크를 하거나 로그 등을 쌓고자 할 때 등의 목적으로 쓰임.

* 없다면, 모든 소스에 권한체크를 하는 코드를 적용해주어야 하므로 메모리 낭비, 서버부하, 소스누락 등의 문제가 발생할 수 있다.



#### 구현방법

* 스프링에서 제공하는 **org.springframework.web.servlet.HandlerInterceptor** 를 구현 또는 **org.springframework.web.servlet.handler.HandlerInterceptorAdapter** 를 상속



#### 메서드

* preHandle
  * Controller 수행 전 호출
* postHandle
  * Controller 수행 후 호출
* afterCompletion
  *  뷰에서 최종 결과가 생성하는 일을 포함한 모든 일이 완료 되었을 때 실행

![Interceptor](../Img/Interceptor.png)



#### Spring 환경

* servlet.xml 파일에 인터셉터 설정
  * 여러개의 interceptor를 설정 가능하며, 순서대로 실행됌

```xml
<mvc:interceptors>
	<mvc:interceptor>
	<mvc:mapping path="/*"/>
	<beans:bean class="com.mingsta.AuthInterceptor" />
	</mvc:interceptor>
</mvc:interceptors>
```

* Interceptor 구현

```java
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
public class AuthInterceptor extends HandlerInterceptorAdapter {

@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		return true;
}

@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
  }
}
```



#### Spring Boot 환경

* 스프링부트에서는 spring-webmvc가 spring-boot-starter-web에 포함

```java
dependencies { 
    implementation 'org.springframework.boot:spring-boot-starter-web'
}
```



* Interceptor 클래스 생성(HandlerInterceptor 구현)

```java
package com.mingsta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("여기는 preHandle");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("여기는 postHandle");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}
```



* 빈으로 등록한 인터셉터 등록

```java
package com.mingsta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private AuthInterceptor authInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)
		.addPathPatterns("/**");
	}
}
```

