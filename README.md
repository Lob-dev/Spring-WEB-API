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
   + 해당 사이트에서 1.8.0_252-2 LTS 버전 다운로드 받기

  + Eclipse, Spring 다운로드 및 설치 [Tistory](https://devfunpj.tistory.com/2?category=859537)

  + Tomcat 9.x 설치하기<br/> [link](https://tomcat.apache.org/download-90.cgi)
   + 해당 홈페이지에서 맨 위에 존재하는 ZIP 파일을 다운로드 받아 적당한 위치에 압축을 해제한다.<br/>
   + 그후 [Tistory](https://devfunpj.tistory.com/3?category=859537)

  + 스프링 개발 환경 구축 Hello World [Tistory](https://devfunpj.tistory.com/4?category=859537)

  + mariadb, mySql Workbench 설치 및 샘플 DB 구축 [Tistory](https://devfunpj.tistory.com/5?category=859537)

  + 스프링, Mariadb, MyBatis 연동, 데이터 조회 [Tistory](https://devfunpj.tistory.com/6?category=859537)

+ ### Spring 환경 구축과 Spring Boot 환경 구축 비교
  + Spring Boot 환경 구축하기 [For Intellij]

<br/> 주간 보고 파일 [Google-docs](https://docs.google.com/document/d/19fLz2yBGg9_bgwa-a8VnRS4WH8QNGi6Q5_N4UJuDquc/edit) <br/>
 + 오픈 JDK란?
   + 기존에 Oracle이 가지고 있던 플러그인이 포함된 JDK와 JVM가 유료화되면서 해당 부분을 제거한 JDK와 JVM을 제공하는 오픈소스 기반의 JDK이다.
   + Java SE 7부터 작성된 모든 JDK는 OpenJDK 기반의 레퍼런스 소스 코드를 사용하므로 아무 문제없이 사용이 가능하다!
 + MVC Model이란?
   + Model View Controller로 구성하는 패턴을 말하며, 뷰와 비즈니스 로직을 분리하여 서로에게 영향없이 데이터와 뷰를 변경할 수 있게 만든것이다.
   + 모델은 데이터를 처리하는 부분을 가리키고 뷰는 화면에 표시되는 부분을 말하며, 컨트롤러는 각 요소들의 연결관계를 설정하고 뷰와 데이터의 연결 등을 관리한다.
   + 스프링 MVC에선 디스패쳐 서블릿과 핸들링맵핑을 이용해 클라이언트의 요청에 맞는 컨트롤러를 찾아 서비스를 이용한다.
 + JSP와 타임리프
   + JSP는 Java를 이용한 서버 사이드 스크립트 언어이다. HTML과 스크립트 영역을 포함하며, 실행 시 javax.servlet.http.HttpServlet 클래스를 상속받은
   + java 소스코드로 변환한 다음 컴파일된다. 해당 파일을 변환하고 실행시켜 주는 프로그램은 서블릿 컨테이너라고 부른다.<br/> 대표적으로 Tomcat이 있다.
   + 타임리프는 지원이 거의 중단되고 있는 JSP의 대안으로 떠오르는 뷰탬플릿 엔진이다. XML/XHTML/HTML5/JS등을 활용할 수 있으며, MVC 패턴에 맞게 설계되었다. 
 + Git command 학습
   + [link-thebook](https://thebook.io/080212/xa/)<br/>
   + [link-tistory](https://goddaehee.tistory.com/category/6.%20%EA%B0%9C%EB%B0%9C%EB%8F%84%EA%B5%AC/6_3%20GIT)
 + readme Markdown 학습
   + [link-heropy](https://heropy.blog/2017/09/30/markdown/)
   + [link-GitHub](https://gist.github.com/ihoneymon/652be052a0727ad59601)
<br/>
      
## 2주차 Inteface Guide Document 작성

  <br/>공공 데이터 API 문서와 카카오 API 문서를 참고해서 이번 프로젝트의 API 문서 초안 만들기.<br/>
  
  + API란 무엇일까?
    + API : Application Programming Interface는 응용 프로그램에서 사용할 수 있도록 운영 체제나 프로그래밍 언어가 제공하는 기능을 제어할 수 있게 만든 인터페이스를 뜻한다.
    + private API : Internal API로써 자체 제품, 서비스를 개선하기 위하여 내부적으로 발행하는(구현하는) API. 제 3자에게 노출되지 않는다.
    + public API : 개방형 API로써 모두에게 공개되는 API를 말한다. (KAKAO MAP API..)
    + partner API : 해당 기업이 데이터 공유에 동의하는 특정한 기업, 사람들에게만 제공하는 API. (회사간 SW 통합, 비즈니스 관계에서 사용)
    <br/>
  + REST 아키텍처는 무엇일까? (학습 중)
    + 관련 용어 학습하기 (Client-Server, Stateless, Cache, Uniform Interface, Layered System...)
    + self-descrive message : 메시지 자체만으로 스스로(응답 정보)를 설명할 수 있어야 한다.
    + HATEOAS : 애플리케이션의 상태는 하이퍼링크를 통해 전이되어야 한다. (self, next, prev, query...Links 등)
    <br/>
  + REST API 작성 규칙
    + 행위(Method)는 URL에 명시, 포함해서는 안된다.
    + _ 대신 - 를 사용한다. (Dash도 최소한으로 사용해야 한다. 정확한 의미 표현, 단어(Resource)의 결합 등..)
    + 소문자를 사용한다.
    + 함수처럼 Control Resource 에만 예외적으로 동사를 허용한다.
    <br/>  

## 3주차 RESTful Architecture가 적용된 간단한 HTTP API 만들기
  
  <br/>API 가이드와 샘플 데이터를 사용하여 간단한 API 만들기<br/>
  
  + Spring Framework 학습 정리
    + Spring Framework란? [link-notion](https://www.notion.so/01-Spring-Framework-879a94d541214069a7a91561849f0a2e)
    + POJO와 Spring IoC/DI [link-notion](https://www.notion.so/02-POJO-IoC-DI-9706fa7b6b234dfcb9ab04834c69a8b6)
    + Spring 계층 구조와 사용되는 Model 정리 [link-notion](https://www.notion.so/03-Model-2dddcc91d7994d0abb49f729d154edf6)
    + Spring AOP란? (학습 중)
  <br/>
  + HTTP : Hypertext Transfer Protocol 은 HTML과 같은 문서를 전송하기 위한 Application layer Protocol이다.
    + Web Browser(Client) - Web Server Model 의 요청 응답 구조로 되어 있으며, 요청을 처리한 후
    + 정보나 상태를 가지지 않는 Stateless Protocol 이기도 하다.
    + Stateless Protocol은 각 요청을 독립적인 트랜잭션으로 취급하며, 독립적인 쌍의 요청과 응답을 가진다.
    + 지속적으로 클라이언트와 통신을 연결하고 있지 않기때문에 상대적으로 많은 리소스를 아낄 수 있다.
    + 많은 요청과 응답 가운데 진행되는 연결 / 해제에 대한 오버헤드가 존재하므로 요청이 많은 서비스에서는 따로 해결책을 준비하여야 한다.
    + 서버에서 상태를 기억할 수 있도록 쿠키, 세션, 토큰을 통하여 정보를 저장하고 서버가 클라이언트를 식별할 수 있게끔 처리할 수 있다. 
    + 추가적으로 HTTP는 데이터를 전송할 때 평문으로 전송하기에 보안(탈취, 변조 등)에 취약하다. 
    <br/>
  + HTTPS : HTTP over Secure Socket Layer(SSL) 를 말하며, 독립적인 계층을 가진 SSL을 이용한 HTTP 통신 방식을 의미한다.
    + SSL이 적용되어 있을 경우 응용 계층의 프로토콜들은 외부로 보내는 데이터를 일차적으로 TCP가 아닌 SSL에 보내게되고, 
    + SSL에서 받은 데이터를 암호화하여 TCP로 전달해서 외부 인터넷으로 전달하게 된다. 응답은 역순(APP은 SSL을 TCP로 인식한다.)
    + 기존에 HTTP 프로토콜의 평문 전송으로 인한 보안 취약점을 보완하는 프로토콜이다.
    + HTTPS Protocol 통신 절차 (Client -> Server)
    + brower에서 가지고 있는 인증기관 리스트를 확인하고 인증기관에 통신하려는 웹 서버의 인증서를 요청하여 인증서와 암호화키를 받는다.
    + 해당 암호화 키를 가지고 Application -> SSL(암호화 키를 통한 데이터 암호화) -> TCP 순으로 진행한다.
    + 요청을 보낸 웹 서버에서 최초로 인증서를 발급하였을 때 암호화키를 가지고 해당 데이터를 복호화한다.
    <br/>
  + HTTP 요청 구조
    + Start Line (HTTP Method : GET, POST.., Request Target : URL.., HTTP Version : 1.0, 1.1, 2.0..)
    + Header : HTTP 요청 그 자체에 대한 정보를 가지고 있는 구조이다. key : value 형식으로 이루어져 있다. (Host, Content-Type, Accept, Connection..)
    + Body   : HTTP 요청이 전송하는 데이터를 담는 부분이다, 전송하는 데이터가 없다면 Body 부분은 비어있다.
    <br/>
  + HTTP Status Code (응답 코드) 학습하기
    + 10X의 의미 : 정보를 확인하는 CODE
    + 100 Continue : 임시적인 응답으로 Client가 계속해서 응답을 요청하거나 완료한 경우 무시해도 되는 것을 알려주는 code.
    + 101 Switching Protocol : Client의 Upgrade 요청 헤더에 따른 응답. 서버에서 프로토콜을 변경할 것임을 알려주는 code.
    + 102 Processing : 서버가 요청에 대해서 수신하고 처리 중이지만, 아직 응답할 수 없다는 것을 알려주는 code.
    + 103 Early Hints : 주로 Link 헤더와 함께 사용되며, 응답을 준비하는 동안 Client가 사전 로딩을 시작하도록 하는 Code.
    + 20X의 의미 : 통신이 성공했다고 알려주는 CODE
    + 200 OK : 메서드에 따라 의미가 변경되는 code로써 요청이 성공적으로 진행되었다는 것을 알려주는 code.
    + 201 Created : 요청이 성공적이였으며, 그에 따른 새로운 리소스가 생성되었음을 알려주는 code.
    + 202 Accepted : 요청을 수신했지만, 해당 요청에 따른 행동을 할 수 없음을 알려주는 code. (비동기, 배치와 관련된 code이다.)
    + 204 No Content : 요청은 성공하였으나, 보내줄 컨텐츠는 없다는 것을 알려주는 code.
    + 30X의 의미 : HTTP (URL) Redirect 요청 CODE
    + 300 Multiple Choice : 요청에 대해서 하나 이상의 응답이 가능한 경우를 알려주는 code. (client는 하나의 요청을 반드시 선택해야 함. )
    + 301 Moved Permanently : 요청한 리소스의 URI가 변경되었음을 알려주는 code.
    + 302 Found : 요청한 리소스의 URI가 일시적으로 변경되었음을 의미하는 code.
    + 303 See Other : client가 요청한 리소스를 다른 URI에 GET 요청을 해야 얻어낼 수 있음을 알려주는 code. (서버가 직접 응답하는 경우이다.)
    + 304 Not Modified : cache를 목적으로 사용되는 code로써 client에게 응답이 수정되지 않았다는 것을 알려주고, 응답의 캐시된 버전을 사용하게 하는 code.
    + 40X의 의미 : 클라이언트의 요청에 따른 오류
    + 400 Bad Request : 잘못된 문법에 인하여서 서버가 요청을 이해할 수 없음을 의미하는 code.
    + 401 Unauthorized : 해당 Client에게 인증을 요청하는 Code. (Login..)
    + 403 Forbidden : 해당 Content에 접근할 권리를 가지기 않고 있다는 것을 알려주는 Code. (401과 다른점은 서버는 해당 Client가 누구인지 알고 있다는 점)
    + 404 Not Found : 서버에서 리소스를 찾을 수 없거나, Client에서 알 수 없는 URL일 경우 혹은 리소스를 숨기기 위하여 사용되기도 하는 code.
    + 405 Method Not Allowed : 해당 요청에따른 메소드가 있음을 서버는 알고 있으나, 제거되었거나 혹은 사용할 수 없음을 알려주는 code.
    + 409 Conflict : 해당 요청이 서버의 상태와 충돌될 경우 응답되는 code.
    + 50X의 의미 : 서버의 오류
    + 500 Internal Server Error : 서버가 해당 요청에 따른 처리방법을 알 수 없음을 알려주는 code.
    + 502 Bad Gateway : 서버가 요청을 처리하는데 필요한 응답을 얻기 위해 작업하는 동안 잘못된 응답을 수신한 것을 알려주는 code
    + 503 Service Unavailable : 서버가 요청을 처리할 준비가 되어있지 않음을 알려주는 code. (작동 중단, 과부화 등)
    <br/>
    
    
    
  + 브라우저에서 URL을 입력하여 서버에서 응답하는 과정은?
    + 1. Web brower가 해당 URL을 해석한다. 만약 URL이 문법에 맞지 않는다면 검색 엔진으로 해당 요청을 검색한다.
    + 2. URL이 문법에 맞다면 URL의 host (현재 unicode로 되어있음) 부분을 (host name에서 허용된 문자로) = Punycode encoding 한다.
    + 3. HTTP Strict Transport Security(HTTPS만을 사용하여 통신해야 한다고 웹 사이트가 웹 브라우저에 알리는 보안기능) 목록을 확인한다.
    + 4. HSTS 목록에 해당 URL이 존재한다면 HTTPS 요청으로, 그렇지 않다면 HTTP 요청으로 보낸다.
    + 5. 먼저 Brower에 해당 Domain이 cache 되어있는지 확인한다
    + 5-1. 없을 경우 Local의 hosts 파일을 확인한다. 
    + 5-2 해당 경우에도 없는 (최초 요청) 경우 DNS(Domain Name Server)에 요청을 보낸다.
    + 6. ARP(Address Resolution Protocol) brodcast를 보내기 위해서는 요청 대상의 IP와 MAC address가 필요하므로 ARP cache를 통해 ARP 항목을 확인하고 해당 정보를 반환받는다.
    + 6-1. 해당 정보가 없는 경우 IP address가 local subnet에 있는지 확인하기 위해 routing table 조회한다.
    + 6-2. 있는 경우 subnet과 연관된 interface 사용한다.
    + 6-3. 없는 경우 기본 gateway의 subnet과 연관된 interface 사용한다.
    + 6-4. (2, 3 이후) Network library는 Link Layer에 ARP 요청을 보낸다.
    + 7-1-1. HTTPS 요청일 경우 Application은 (TCP로 생각하고 있는) 특정한 계층을 가진 SSL로 해당 정보를 전달한다.
    + 7-1-2. TCP 계층을 통해 Client와 Server가 3-way handshaking를 진행한다. 
    + 3-way handshaking 란?: TCP 소켓은 연결 설정과정 중에 총 3번의 대화를 주고 받는다. (SYN : 연결 요청 플래그 / ACK : 응답) (Client->Server)SYN -> (Server->Client)SYN + ACK -> (Client->Server)ACK
    + 7-1-3. TCP 연결을 통해 SSL과 서버가 SSL (TLS) 버전과 암호 규약을 설정하고 server가 인증서를 client로 보내고. client에서 만족할 경우 RSA 또는 Diffie-hellman 키 교환을 진행한다. 이 행위를 통하여 세션에서 사용할 대칭키를 설정한다.
    + 7-1-4. Client 의 SSL에서 앞서 받은 인증서를 기반으로 encoding을 진행한다.
    + 7-1-5. SSL에서 TCP 계층으로 데이터를 전송한다. 이후 (TCP(세그먼트) -> IP(데이터그램) -> Data Link(Frame) -> ethernet, Wifi, Modem.. -> router -> Server )
    + 7-2-1. HTTP 요청일 경우 바로 TCP로 전달하여 3-way handshaking 만을 진행하고 HTTP Protocol을 통하여 요청한다. (평문)
    + 8. client 에서 요청과 header를 보낸 후 요청 내용이 완료되었음을 알리는 한 줄 바꿈 (\n)을 서버에 보낸다.
    + 8-1. 서버가 요청을 수신하고 해당 요청을 매개 변수로 구분한다. (HTTP Method로 구분, 직접 URL을 입력한 경우 GET)
    + 8-2. 서버는 해당 서버에 구성된 가상 호스트를 확인하고 요청을 수락할 수 있는지 확인한 뒤(안된다면 202, 401, 403 등을 응답), 해당 요청에 따른 처리를 진행하고 client에게 응답한다.
    + 8.3. 해당 응답을 받은 Browser가 그에따른 처리를 한다. (html, css, js 구문 분석 -> 렌더링 -> real DOM 구성(React, Vue는 Virtual DOM) -> 렌더 트리 구성 -> 레이아웃 배치 -> 랜더 트리 그리기(화면 생성..등))
    + 8-4. 해당 응답이 HTML, CSS, JS를 제외한 Image 같은 Media Type의 요소에 대한 요청이 있을 경우 서버에서 재 요청을 요구한다.
    + 8-5. Client가 재요청을 진행하면, Image 같은 Media Type 을 응답하여 해당 요소들을 배치하고 Web page 구성이 끝난다. 
    <br/>
    
  + 궁금한 것 
    + JSON란 무엇일까? (학습 중)
    + 브라우저에 URL을 입력했을 경우 서버에서 응답하는 과정 설명하기 (학습 중)
    + 해당 API의 TEST CASE 작성하기 (완료)
    + JPA 학습 해보기 (학습 중)
    <br/>
## 4주차 API 구축을 위한 SQL 작성하기
  
  <br/>
  
    + API 문서 초안 수정해보기<br/>

