#### 0909 iptables 재부팅 초기화

#### **iptable**

우분투 리부팅 후 젠킨스가 계속 실행되지 않아, 원인을 찾아보니 iptables 설정이 초기화되기 때문이었다.

초기화

```bash
sudo iptables -F
```

포트 허용

```bash
sudo iptables -I INPUT 1 -p tcp --dport 9000 -j ACCEPT
sudo iptables -I INPUT 2 -p tcp --dport 8080 -j ACCEPT
sudo iptables -I INPUT 3 -p tcp --dport 80 -j ACCEPT
```



참고사이트

https://happist.com/573574/%EC%9A%B0%EB%B6%84%ED%88%AC-%EB%B0%A9%ED%99%94%EB%B2%BD-%EA%B0%95%ED%99%94%EB%A5%BC-%EC%9C%84%ED%95%9C-%EC%9A%B0%EB%B6%84%ED%88%AC-iptables-%EC%84%A4%EC%A0%95%EB%B2%95-ddos-%EB%B0%A9%EC%96%B4

