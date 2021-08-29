### 젠킨스(Jenkins)

* Java로 빌드 된 오픈소스 CI(Continuous Integration) 및 CD(Continuous Delivery) 도구
* 기본적으로 소프트웨어 프로젝트를 빌드, 테스트 및 배포하기 위해 사용되며, DevOps 개발도구의 가장 기본 도구

#### 설치방법(ubuntu)

1. 사용가능한 패키지들과 그 버전에 대한 정보 업데이트(설치가능 리스트 업데이트)

```bash
sudo apt-get update
```



2. JDK 설치

* JDK를 설치한다.

```bash
sudo apt-get install openjdk-8-jdk
```



3. Jenkins 저장소 Key 다운로드

* This is the Debian package repository of Jenkins to automate installation and upgrade. To use this repository, first add the key to your system
* 설치와 업그레이드를 자동화해주는 젠킨스의 debain package repository. 이 repository 를 위해 먼저 키를 추가해주어야 한다.

```bash
wget -q -O - https://pkg.jenkins.io/debian/jenkins.io.key | sudo apt-key add -
```



4. jenkins repository 등록

* Then add a Jenkins apt repository entry

```bash
sudo sh -c 'echo deb https://pkg.jenkins.io/debian binary/ > /etc/apt/sources.list.d/jenkins.list'
```



5. jenkins 설치

```bash
sudo apt-get update
sudo apt-get install jenkins
```



6. jenkins 포트 변경

- 기본 포트는 8080 으로 잡혀있지만, 보통 톰캣이 8080 포트를 쓰기 때문에 해당 포트를 다른 포트로 바꿔주었다.

```bash
sudo vi /etc/default/jenkins
```

* HTTP_PORT 라고 쓰여진 설정에 원하는 포트번호를 입력해준다. (9000번)

* aws 보안그룹 설정에도 9000번 포트를 인바운드 규칙으로 등록해준다.

![ec2_port_add](../img/ec2_port_add.png)



7. Jenkins 시작

```bash
sudo service jenkins restart
```



8. Jenkins 초기 비밀번호 입력

```bash
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```

