# Spring-WEB-API
RESTful Architecture를 적용한 HTTP API 제작 Repo 입니다.
<hr/>

### 1주차
+ GitHub 계정 생성
+ 개발환경 구성
+ mybatis 설치
+ Spring 환경 구축과 Spring Boot 환경 구축 비교


### 2주차
+ Inteface Guide Document 작성 (클라이언트 개발자와 협업하는 방법)


### 3주차
+ RESTful Architecture가 적용된 간단한 HTTP API 만들기
  + RESTful API는 무엇일까?
  + HTTP 통신은 무엇일까?
  + URL을 입력했을 때 발생하는 일련의 과정을 학습해보기


### 4주차
+ API 구축을 위한 SQL 작성하기
+ RestController를 활용하여 RESTful API 구축하기



<hr/>

## 1주차 스프링 개발 환경 구축 

  <br/>Spring-WEB-API 만들기 1주차 과정 Spring-Legacy-Project 구축하기<br/>

Spring-mvc (5.1.8) + mariadb (2.0.3) + mybatis (3.4.4)
<br/>

+ ### GitHub 계정 생성
  + GitHub 회원 가입하기 [Tistory-link](https://goddaehee.tistory.com/218)
  <br/>
  <br/>
+ ### 개발환경 구성
  + JDK 1.8 설치하기 [GitHub-link](https://github.com/ojdkbuild/ojdkbuild)
    해당 사이트에서 1.8.0_252-2 LTS 버전 다운로드 받기

  + Eclipse, Spring 다운로드 및 설치 [Tistory](https://devfunpj.tistory.com/2?category=859537)

  + Tomcat 9.x 설치하기<br/> [link](https://tomcat.apache.org/download-90.cgi)
    해당 홈페이지에서 맨 위에 존재하는 ZIP 파일을 다운로드 받아 적당한 위치에 압축을 해제한다.<br/>
    그후 [Tistory](https://devfunpj.tistory.com/3?category=859537)

  + 스프링 개발 환경 구축 Hello World [Tistory](https://devfunpj.tistory.com/4?category=859537)

  + mariadb, mySql Workbench 설치 및 샘플 DB 구축 [Tistory](https://devfunpj.tistory.com/5?category=859537)

  + 스프링, Mariadb, MyBatis 연동, 데이터 조회 [Tistory](https://devfunpj.tistory.com/6?category=859537)

+ ### Spring 환경 구축과 Spring Boot 환경 구축 비교
  + Spring Boot 환경 구축하기 [For Intellij]

<br/> 주간 보고 파일 [Google-docs](https://docs.google.com/document/d/19fLz2yBGg9_bgwa-a8VnRS4WH8QNGi6Q5_N4UJuDquc/edit) <br/>
 + 오픈 JDK란?<br/>
      기존에 Oracle이 가지고 있던 플러그인이 포함된 JDK와 JVM가 유료화되면서 해당 부분을 제거한 JDK와 JVM을 제공하는 오픈소스 기반의 JDK이다.
      Java SE 7부터 작성된 모든 JDK는 OpenJDK 기반의 레퍼런스 소스 코드를 사용하므로 아무 문제없이 사용이 가능하다!<br/>
 + MVC Model이란?<br/>
      Model View Controller로 구성하는 패턴을 말하며, 뷰와 비즈니스 로직을 분리하여 서로에게 영향없이 데이터와 뷰를 변경할 수 있게 만든것이다.<br/>
      모델은 데이터를 처리하는 부분을 가리키고 뷰는 화면에 표시되는 부분을 말하며, 컨트롤러는 각 요소들의 연결관계를 설정하고 뷰와 데이터의 연결 등을 관리한다.<br/>
      스프링 MVC에선 디스패쳐 서블릿과 핸들링맵핑을 이용해 클라이언트의 요청에 맞는 컨트롤러를 찾아 서비스를 이용한다.<br/>
 + JSP와 타임리프<br/>
      JSP는 Java를 이용한 서버 사이드 스크립트 언어이다. HTML과 스크립트 영역을 포함하며, 실행 시 javax.servlet.http.HttpServlet 클래스를<br/> 상속받은
      java 소스코드로 변환한 다음 컴파일된다. 해당 파일을 변환하고 실행시켜 주는 프로그램은 서블릿 컨테이너라고 부른다.<br/> 대표적으로 Tomcat이 있다.
      타임리프는 지원이 거의 중단되고 있는 JSP의 대안으로 떠오르는 뷰탬플릿 엔진이다. XML/XHTML/HTML5/JS등을 활용할 수 있으며, MVC 패턴에 맞게 설계되었다. <br/>
 + Git command 학습<br/>
      [link-thebook](https://thebook.io/080212/xa/)<br/>
      [link-tistory](https://goddaehee.tistory.com/category/6.%20%EA%B0%9C%EB%B0%9C%EB%8F%84%EA%B5%AC/6_3%20GIT)
      <br/>
 + readme Markdown 학습<br/>
      [link-heropy](https://heropy.blog/2017/09/30/markdown/)<br/>
      [link-GitHub](https://gist.github.com/ihoneymon/652be052a0727ad59601)
      <br/><br/>
      
## 2주차 Inteface Guide Document 작성

  <br/>공공 데이터 API 문서와 카카오 API 문서를 참고해서 이번 프로젝트의 API 문서 초안 만들기.<br/>

  + HTTP/ HTTPS 란?
  + HTTP Status Code 학습하기<br/>
    +  
  + API란 무엇일까?<br/>
  + REST 아키텍처는 무엇일까?<br/>
    + 관련 용어 학습하기 (Client-Server, Stateless, Cache, Uniform Interface, Layered System...)<br/>
    + self-descrive message 란?<br/>
    + HATEOAS 란?<br/>
<br/>

## 3주차 RESTful Architecture가 적용된 간단한 HTTP API 만들기

## 4주차 API 구축을 위한 SQL 작성하기


