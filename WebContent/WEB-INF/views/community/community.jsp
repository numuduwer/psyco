<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 페이지</title>
</head>
<body>

	 <!--  검색베너  & 신메뉴 , 랭킹미리보기 -->
    <section id="banner_section">
      
        <div id="banner">
            <img src="/psyco/resources/img/main/community.jpg" alt="">
        </div>
 
    </section>

    <!-- 경매 상품 -->
    <section class="item-section">
        <div class="admin">
            <ul class="admin_btn">
                <li><a href="/psyco/communityList.com?category=1">자유게시판 </a></li>
                <li><a href="/psyco/communityList.com?category=2">QnA게시판</a></li>
                <li><a href="/psyco/communityList.com?category=3">홍보게시판</a></li>
                <li><a href="/psyco/communityList.com?category=4">음식점  추천게시판 </a></li>
            </ul>
         
        </div>
    </section>
    
     <div class="nContent">
        <div class="ntable">
            <div class="table_title">
                <h3>자유게시판 </h3>
                <span>더보기 > </span>
            </div>
                 <table class="table_box">
                <tr>
                    <td colspan="5" class="table_detail"> 지금 냉면 살만한가 ?? </td>
                    <td class="table_time">14:10</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail">다들 평균 얼마에 사시나요? </td>
                    <td class="table_time">14:06</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail">아 여기 진짜 개꿀이다  </td>
                    <td class="table_time">14:00</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail">아 막내입니다. 이사이트 너무좋습니다.  </td>
                    <td class="table_time">13:52</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail"> 막내들의 메뉴선택 팁  </td>
                    <td class="table_time">13:47</td>
                </tr>
               	 <tr>
                    <td colspan="5" class="table_detail">이거 결제 된거 맞나요 ? </td>
                    <td class="table_time">13:38</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail">가게사장입니다. 감사합니다.  </td>
                    <td class="table_time">13:29</td>
                </tr>
                <tr>
                    <td colspan="5" class="table_detail">오랜만에 다시 해볼까 하는데 지금도 할만한가요 ?</td>
                    <td class="table_time">13:05</td>
                </tr>
            </table>
            

        </div>
        <div class="ntable">
            <div class="table_title">
                <h3>QnA  </h3>
                <span>더보기 > </span>
            </div>
            <table class="table_box">
                <tr>
                    <td colspan="5" class="table_detail">서울대 입구 돈까스집 맛있나요 ?? </td>
                    <td class="table_time">14:10</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail">다들 평균 얼마에 사시나요? </td>
                    <td class="table_time">14:06</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail">안녕하세요 문의드립니다. </td>
                    <td class="table_time">14:00</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail">이거 사기 아님 ?? </td>
                    <td class="table_time">13:52</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail"> 싸게 먹는 팁있나요??? </td>
                    <td class="table_time">13:47</td>
                </tr>
               	 <tr>
                    <td colspan="5" class="table_detail">아 이거 랭킹 어떻게 올리나요 ?? </td>
                    <td class="table_time">13:38</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail">go ?? stop ?? </td>
                    <td class="table_time">13:29</td>
                </tr>
                <tr>
                    <td colspan="5" class="table_detail">오랜만에 다시 해볼까 하는데 ....</td>
                    <td class="table_time">13:05</td>
                </tr>
            </table>

        </div>
    </div>
   <br><br>
    
    <div class="nContent">
        <div class="ntable">
            <div class="table_title">
                <h3>가게를 홍보합니다.  </h3>
                <span>더보기 > </span>
            </div>
                  <table class="table_box">
                <tr>
                    <td colspan="5" class="table_detail">서울대 입구 달팽이집 오늘하루 이벤트합니다.  </td>
                    <td class="table_time">14:10</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail">서울대 입구 칼국수집 오픈했습니다.  </td>
                    <td class="table_time">14:06</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail">안녕하세요 돈까스집입니다. 오늘 이벤트는  </td>
                    <td class="table_time">14:00</td>
                </tr>
                 <tr> 
                    <td colspan="5" class="table_detail">안녕하세요 냉면입니다. 예약각능 합니다.  </td>
                    <td class="table_time">13:52</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail">서울대 입구 국밥집에서 김치를 판매합니다.  </td>
                    <td class="table_time">13:47</td>
                </tr>
               	 <tr>
                    <td colspan="5" class="table_detail">갈비탕집입니다. 매장에서 포장해가시면 2인분 국물 드립니다.  </td>
                    <td class="table_time">13:38</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail">서울대 입구 파스타집입니다. 오늘은 로제파스타  </td>
                    <td class="table_time">13:29</td>
                </tr>
                <tr>
                    <td colspan="5" class="table_detail">오늘 볶음밥 무료행사합니다. 닭갈비집 </td>
                    <td class="table_time">13:05</td>
                </tr>
            </table>

        </div>
        <div class="ntable">
            <div class="table_title">
                <h3> 음식점 추천  </h3>
                <span>더보기 > </span>
            </div>
                       <table class="table_box">
                <tr>
                    <td colspan="5" class="table_detail">서울대 입구 돈까스집 괜찮아요.  </td>
                    <td class="table_time">14:10</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail">냉면집 서울대입구점 되게 빨리나옴.맛은  </td>
                    <td class="table_time">14:06</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail"> 새로 오픈한 칼국수집 가봄 솔직 후기  </td>
                    <td class="table_time">14:00</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail"> 국밥집 맛있네요 </td>
                    <td class="table_time">13:52</td>
                </tr>
                 <tr>
                    <td colspan="5" class="table_detail"> 칼국수집 가지마세요 ...  </td>
                    <td class="table_time">13:47</td>
                </tr>
               	 <tr>
                    <td colspan="5" class="table_detail">아 닭갈비집 진짜 강추 합니다.  </td>
                    <td class="table_time">13:38</td>
                </tr>
                 <tr>
                    <td colspan="5 " class="table_detail"> 파스타 집 괜찮아요 ??  </td>
                    <td class="table_time">13:29</td>
                </tr>
                <tr>
                    <td colspan="5" class="table_detail"> 이거 광고 말고 솔직 후기만 올려주세요 .</td>
                    <td class="table_time">13:05</td>
                </tr>
            </table>

        </div>
    </div>
     
	
	
		
	
	
</body>
</html>