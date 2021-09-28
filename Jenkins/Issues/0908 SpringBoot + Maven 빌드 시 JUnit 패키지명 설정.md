#### 0908 스프링 부트 프로젝트 Maven 빌드 시, @SpringBootTest 패키지명 설정

```wiki
java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
```

스프링부트에서 maven 으로 빌드 시, 해당 오류가 발생

해결을 위해, 아래와 같이 두가지의 방법 존재

* 방법 1 - @SpringBootTest 에 (classes=메인어플리케이션.class) 지정

```java
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.test.jenkins.JenkinsProjectApplication;

@SpringBootTest(classes=JenkinsProjectApplication.class)
class JenkinsProjectApplicationTests {
...
}
```

* 방법 2 - Test클래스의 패키지를 메인 어플리케이션이 있는 package 와 맞춰주기

```java
package com.test.jenkins; // package 를 메인어플리케이션과 동일한 패키지명을 가지도록 하기

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.test.jenkins.JenkinsProjectApplication;

@SpringBootTest
class JenkinsProjectApplicationTests {
...
}
```