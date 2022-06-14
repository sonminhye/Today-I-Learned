## ElasticSearch

### ElasticSearch 란?

* 오픈소스 검색엔진

#### ElasticSearch의 장단점

##### 장점

* 오픈소스
* 전문검색 가능(Full Text)
* 통계분석 가능
* 역색인구조
* 분산환경
  * 데이터를 샤드라는 작은 단위로 나누어 제공


##### 단점

* 실시간 검색이 불가능
  * 저장 시점에 데이터 색인

* Document 간의 조인 수행 못함

* 진입장벽이 있다.

* Document 를 수정하지 않고, 기존 문서를 삭제 후 다시 삽입하는 방식

#### ElasticSearch 사용법

* http 프로토콜로 접근 가능한 REST API를 통해 데이터 조작 지원

### Kibana

* Elastic Stack 을 기반으로 구축된 무료 오픈 소스 프론트 엔드 애플리케이션
* ElasticSearch 에서 색인된 데이터를 검색, 시각화 하는 기능 제공 

### Mac 에서 Elastic Search 설치 및 실행

homebrew 로 설치

```bash
brew install elasticsearch
```



에러 발생하여 opensearch 로 다시 설치

```
brew install opensearch
```



127.0.0.1:9200 으로 접속

![실행 화면](/Users/sonminhye/Documents/책읽고정리하기/TIL정리/ElasticSearch/opensearch_localexec.png)
