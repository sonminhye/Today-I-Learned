### 0923 maven 빌드에러(자바 버전문제)

```xml
Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile (default-compile) on project JenkinsProject: Fatal error compiling: invalid target release: 11 -> [Help 1]
```

* 문제의 원인은, 프로젝트에 설정되어있는 java version 이 낮은데, maven 버전은 11로 서로 버전이 다르기 때문에 발생한 오류였다.

pom.xml

```xml
	<name>JenkinsProject</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>11</java.version>
	</properties>
```

* pom.xml 파일의 java version 과 서버의 java version 을 11로 올려주고, 새로 바뀐 자바 경로를 설정해주었다.
  * vi /etc/profile - java path 설정

