### 0927 tomcat manager 설정

젠킨스 빌드에러가 떴다. manager/list를 찾지못한다는 에러였는데, 내가 tomcat-users.xml 에 role 태그를 써주지 않은 것을 발견하였음.

* /etc/tomcat9/tomcat-users.xml

```xml
 <role rolename="manager-gui"/>
 <role rolename="manager-script"/>
 <role rolename="manager-status"/>
 <user username="jenkins" password="dhfpswl35" roles="manager-gui,manager-script,manager-status"/>
```

위와같이 설정을 해주었는데도 제대로 빌드가 되지 않아서, tomcat9-admin 을 새로 깔아주었더니 빌드에러가 해결되었다.



