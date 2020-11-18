# 소상공인들을 위한 음식쿠폰 역경매 플랫폼  (작성중) 
<hr/>

## 목차 
1. [개요](#개요)
2. [info](#info)
2. [Technologies](#Technologies)
3. [Features](#Features)
## 개요 
배민 쿠폰,쿠팡 외식상품권등 E-커머스를 통한 음식할인 쿠폰에 대한 관심이 커지고 있다. 그러나 기존 E-커머스플랫폼은 대형프렌차이즈에 기준이 맞춰져 있다.     
소상공인들도 기준을 맞추고  E-커머스 플랫폼의 차별점을 두기위해 역경매 방식을 적용시킨 음식쿠폰판매 플랫폼을 기획하였다. 

## info
- 소상공인들을 위한 음식쿠폰 역경매 플랫폼 
- 개발기간: 2020.09.24 ~ 2020.10.24
- 팀원 : 김신, 김경빈, 이세기, 정동윤 

## Technologies

#### 개발환경  
- OS : Mac OS / window 10 
- IDE : Eclipes
- Language : java(jdk1.8) JSTL(1.2) 
- Framework : spring(4.3)
- Middleware : tomcat(8.5) 
- DBMS : Oracle(11g)
- ORM : mybatis(3.2)
- Front-End : tiles, javascript, ajax, jquery

#### 사용된 기능 
- 1.naver API (login, maps) 
- 2.결제 API 
- 3.ajax, jquery사용한 비동기처리 , 유효성검사 


<img src="https://user-images.githubusercontent.com/33523029/99492247-8e1a4000-29b0-11eb-84a5-e395eeab72a3.png" width="400" height="400">


## Features

### 로그인 / 회원가입 페이지 
 - auth , 네이버 로그인구현 
 - ajax를 사용 아이디 중복확인 비동기 처리 
 
 
 ### 메인페이지 
 - 실시간으로 경매page 데이터 떨어뜨림 
 - 
