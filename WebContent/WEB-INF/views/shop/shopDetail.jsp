<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 가게 상세 페이지</h1>
	
	<h2>가게 정보들 쫘악 나온다.</h2>
	
	 <div class="userZZimpage_tab1">
                        <ul class="zzim_reg">                     
                                           </ul>
                        <c:if test="${coun1t == 0}">
							<table>
								<tr>
									<td>  ${count1}가게가 등록되어있지 않습니다. </td>
								</tr>
							</table>
						</c:if>
                       
                        <c:if test="${count1 > 0}">
	                       <c:forEach var="article" items="${articleList1}">
		                        <div id = "${article.shop_num}" class="myPage_item_info">
			                     
		                            <img src="/img/item/one/1.jpg" alt="">
		                            <ul>
		                                <li><a href="shopDetail.com?shop_num=${article.shop_num }">가게 이름 : ${article.shop_name}</a></li>
		                                <li>
		                                    <span> 주소 : ${article.address}</span>
		                                </li>
		                                <li>
		                                    <span> 영업시간 : ${article.operating_time}</span>
		                                </li>
		                            </ul>
		                            <ul class="myPage_item_info_btnList">
		                                <li><button class="shop_btn"><a href="shopModify.com?shop_num=${article.shop_num }">수정</a> </button></li>
		                               	<li><button class="shop_btn"> <a href="javascript:onClickItemDelete('${article.shop_num}')" >삭제</a> </button></li>
		                            </ul>
		                        </div>
                        </c:forEach>
                   	</c:if>
                    </div>
	
	<strong> 가게 메뉴 </strong>
	<button onclick="window.location='/psyco/shop/menuList.com?shop_num=${article.shop_num}'">가게 메뉴판</button>
	</h3>
	<button onclick="window.location='/psyco/shop/shopModify.com?shop_num=${article.shop_num}'">수정</button>

</body>
</html>