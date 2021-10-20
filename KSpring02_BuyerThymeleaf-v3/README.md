# Kotlin Spring Boot Project

## JPA( Java Persistence API, Architecture)
* 일반적인 DBMS CRUD 는 SQL 을 기반으로 한다
* 가급 SQL 을 적게 사용하기 위하여 Mybatis 등의 도구를 사용하지만   
완전하게 SQL 을 사용하지 않을 수는 없다
* JPA 는 최소한 기본 CRUD 는 아무런 SQL 의 도움없이 구현할수 있도록  
만드는 기술이다
* ORM(Object-relational Mapping) 의 개념을 Spring에 도입한 것
* DB도 마치 메모리에 변수, 객체를 저장하는 것과 같은 방법으로  
기본 class 를 사용하여 구현하고자 하는 기술
* JPA 는 말그대로 기술적인 개념이다. Spring 에서는 JPA 를   
구현하기 위하여 interface 차원에서만 지원한다.
* 보통은 JPA 와 함께 Hibernate 라는 구현체를 함께 사용한다  
boot 에서는 Hibernate 는 JPA 에 포함되어 구현된다

## JPA DDL 설정

    spring.jpa.hibernate.ddl-auto=create

* JPA DDL 설정 :   
create, update, create-drop, validate, none 이 있다
* create : 기존의 table 을 삭제하고 다시 생성하기
* update : 기존 table 구조를 분석하여 변경사항을 alter table
* create-drop : 기존 table 을 삭제하고 다시 생성하고
프로젝트를 종료하면 table 을 drop
* validate : Entity 칼럼의 설정값과 실제 table 의 구조가 다르면  
프로젝트 실행 멈춤
* none : 아무것도 하지마
* 개발당시 : create, update 를 설정
* 자동화된 test 를 진행할때 : create-drop 를 설정
* 수동 test : update, validate 를 설정
* 실제 실행 서버 : validate 또는 none





### jQuery import
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-latest.min.js></script>