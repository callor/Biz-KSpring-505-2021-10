# Spring Boot Security Project
* Dependency 설정
 
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity5</artifactId>
        </dependency>

* Spring Framework 에 Security 관련 Dependency 를 설정하면 Project 가  
* Security 에 wrapping 되어 모든 제어가 Security 를 거쳐서 작동 된다.
* Security 관련 Config 를 설정하여  Security 작동을 Custom 화 하여
* Project 를 진행하게 된다

## Spring Security 에서 POST 전송
* Security project 에서는 절대 일반적인 방법으로는 POST 로 데이터를 보낼수 없다
* thymeleaf 의 extra security 의 도움을 받아 FORM 을 재 설정해야 한다.
* Security 에서 POST 로 데이터를 서버로 전송하려면  
반드시  _csrf 변수에 Token 을 담아서 같이 보내야 한다
* thymeleaf 에서 form tag 에 th:action={} 지정하면 자동으로 해당 변수가  
form 에 <input type=hidden>으로 설정되어 준비 된다

## CSRF : Cross-site Request Forgery
* 상대방 서버의 input form 화면의 코드를 복제하여 로컬에 파일로 만들고  
일부 내용을 위조하여 다시 submit 하여 서버로 전송하는 해킹 행위

* Spring Security 는 POST 로 전송되는 모든 데이터에 대하여 CSRF 거부정책을 수행한다
* POST 전송되는 모든 데이터에 _csrf 데이터가 없으면 거부한다(403 Forbidden 오류 발생)
* thymeleaf 의 extra-security 를 dependency 에 설정해 두면  
thymeleaf 에서 _csrf 값을 취급 할 수 있다.
 







