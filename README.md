# 소상공인들을 위한 음식쿠폰 역경매 플랫폼  (작성중) 
배민 쿠폰,쿠팡 외식상품권등 E-커머스를 통한 음식할인 쿠폰에 대한 관심이 커지고 있다.   
E-커머스 플랫폼의 차별점을 두기위해 역경매 방식을 적용시킨 음식쿠폰판매 플랫폼을 기획하였다.  
<br><br><br>

<p align="center">
<img width="600" alt="메인" src="https://user-images.githubusercontent.com/33523029/99495642-45658580-29b6-11eb-8324-885de26ecfd9.png">
 </p>
 

## 목차 
- [info](#info)
- [Technologies](#Technologies)
- [Features](#Features)


## info
- 소상공인들을 위한 음식쿠폰 역경매 플랫폼 
- 개발기간: 2020.09.24 ~ 2020.10.24
- 팀원 : 김신, 김경빈, 이세기, 정동윤 

## Technologies

### 개발환경  
- OS : Mac OS / window 10 
- IDE : Eclipes
- Language : java(jdk1.8) JSTL(1.2) 
- Framework : spring(4.3)
- Middleware : tomcat(8.5) 
- DBMS : Oracle(11g)
- ORM : mybatis(3.2)
- Front-End : tiles, javascript, ajax, jquery

### 사용된 기능 
- naver API (login, maps), 다음 API(주소검색)
- 결제 API , 사업자 등록번호 조회 API
- ajax, jquery사용한 비동기처리, 유효성검사 
- tiles 레이아웃 관리 



## Features

### 메인페이지
 - flex를 통해 레이아웃 
 - 겸매 상품 실시간 DATA(할인율,현재가격 등) 페이지 요청마다 갱신되도록 구현
 - 로그인 중 가게신청여부가 수락되면 이벤트 발생하는 기능
 - 경매 상품 누르면 상품상세페이지(가게페이지)로 이동 

### 로그인 / 회원가입 페이지 (가입은 총 4단계)  
 - Oauth2.0로 Naver API 호출 소셜 로그인 구현 
 - [가입 2단계]사업자 등록번호 조회하도록 공공API사용 
 - [가입 3단계]id 중복확인시 ajax,jquery사용 비동기로 중복여부확인 
 - [가입 3단계] Daum API 사용 주소검색 기능 구현

<p align="center">
<img src="https://user-images.githubusercontent.com/33523029/99492247-8e1a4000-29b0-11eb-84a5-e395eeab72a3.png" width="350" height="400">
<img src="https://user-images.githubusercontent.com/33523029/99492814-945cec00-29b1-11eb-9e6c-a4c23f4f446a.png" width="350" height="400">
</p>
<p align="center">
<img src="https://user-images.githubusercontent.com/33523029/99492967-c5d5b780-29b1-11eb-8036-556cf6d6f6b8.png" width="350" height="400">
<img src="https://user-images.githubusercontent.com/33523029/99493002-d25a1000-29b1-11eb-885c-3294b3d68f19.png" width="350" height="400">
<p/>


### 상품상세페이지
 - flex를 통한 배치 , tab메뉴를 구현해 하단의 가게정보 확인
 - Naver API를 통한 매장위치 정보 구현 
 - join을 통해 가게table, 메뉴table,상품table 의 데이터를 합쳐서 호출 
 - 결제시 실제 결제 하도록 API사용
### 커뮤니티 페이지 (4종류의 커뮤니티 페이지)
 - 자유게시판 
 - 상품추천 게시판
 - 가게홍보 게시판
 - 경매 팁 게시판 
### 관리자 페이지 
- 회원관리
- 가게사업자 관리 
- 가게신청 관리
- 커뮤니티관리
- 리뷰관리 

 
 
