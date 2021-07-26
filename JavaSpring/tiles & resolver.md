2021.07.20 스프링 tiles

현 근무환경에서는 스프링 tiles 를 이용하여 다양한 케이스 (직원용 화면, 사용자 화면등) 별로 기본적으로 로드되는 클래스들을 정의해두었다. 

아래는 그렇게 알게된 tiles 과, tiles를 사용할 수 있게 하는 Resolver에 대해 공부한 내용.

#### Resolver

* 뷰의 이름과 실제 view 객체를 맵핑하는 역할
  * Controller에서 DispatcherServlet 에 ModelandView 객체를 넘기거나, 이름을 반환
  * **이름으로 반환할 경우,** DispatcherServlet은 View Resolver에 어떤 뷰 객체를 사용할 것인지 요청
  * View Resolver는 해당 정보와 실제 어떤 뷰 객체를 맵핑할지 결정하여 DispatcherServlet에 반환
  * 뷰 리졸버는 보통 뷰 오브젝트를 캐싱 하므로, 뷰 이름을 넘겨 뷰 리졸버를 사용하는 것이 성능면에서 유리
* 스프링에서는 다양한 뷰 리졸버를 지원함(그 중, tilesViewResolver도 존재)



**applicationContext.xml** 

```xml
<bean id ="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">             	<property name="prefix" value="/WEB-INF/jsp/">    
	<property name="suffix" value=".jsp"> 
</bean>
```

* 보통은 위와 같이, prefix와 suffix를 설정



#### Apache Tiles

반복적으로 사용되는 템플릿을 정의하여 한곳에 모아 관리할 수 있게 하는 프레임워크



1. **pom.xml 파일에 추가**

```xml
<dependency> 
  <groupId>org.apache.tiles</groupId> 
  <artifactId>tiles-jsp</artifactId> 
  <version>2.2.2</version> 
</dependency> 
<dependency> 
  <groupId>org.apache.tiles</groupId> 
  <artifactId>tiles-template</artifactId> 
  <version>2.2.2</version> 
</dependency>
```



2. **tiles View Resolver 등록**

```xml
<!-- Tiles ViewResolver -->
<bean id="tilesViewResolver" class="org.springframework.web.servlet.view.UrlBasedViewResolver"> 
  <property name="viewClass" value="org.springframework.web.servlet.view.tiles2.TilesView"/> 
  <property name="order" value="1"/> <!--여러개의 뷰 리졸버가 존재할 때, 다음과 같이 order 를 지정해주면 됌.-->
</bean> 
```



... 추가예정

