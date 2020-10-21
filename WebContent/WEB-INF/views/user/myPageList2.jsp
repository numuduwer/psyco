<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	   <!--  기능  타이틀 -->
    <div class="myPage_mainTitle">
        <h1>마이페이지</h1>
        <div class="myPage_userTitle">
            <h2 class="myPage_subTitle">찜 리스트 / 문의하기 </h2>
        </div>
    </div>
    <!--   탭 버튼-->
    <div class="myPage">
        <div class="myPage_content">
            <div class="myPage_main">
                <div class="tabs">
                    <div class="tab" data-tab-target="#tab1">
                        <p>찜 상품 리스트</p>
                    </div>
                    <div class="tab" data-tab-target="#tab2">
                        <p>문의내역 확인 </p>
                    </div>
                </div>
            </div>

            <div class="content">
                <!--   탭 1 내용-->
                <div id="tab1" data-tab-content class="items active">
                    <div class="userZZimpage_tab1">
                        <ul class="zzim_reg">
                            <li><input type="checkbox" name="" id=""> 전체선택</li>
                            <li><a href="">선택 삭제</a> </li>
                        </ul>
                        <div class="myPage_item_info">
                            <img src="/img/item/one/1.jpg" alt="">
                            <ul>
                                <li><a href="">경매 상품 이름</a></li>
                                <li> 할인률 </li>
                                <li>
                                    <span>1000원 / 1개</span>
                                </li>
                            </ul>
                            <button><a href="">삭제</a> </button>
                        </div>
                        <div class="myPage_item_info">
                            <img src="/img/item/one/1.jpg" alt="">
                            <ul>
                                <li><a href="">경매 상품 이름</a></li>
                                <li> 할인률 </li>
                                <li>
                                    <span>1000원 / 1개</span>
                                </li>
                            </ul>
                            <button><a href="">삭제</a> </button>
                        </div>
                        <div class="myPage_item_info">
                            <img src="/img/item/one/1.jpg" alt="">
                            <ul>
                                <li><a href="">경매 상품 이름</a></li>
                                <li> 할인률 </li>
                                <li>
                                    <span>1000원 / 1개</span>
                                </li>
                            </ul>
                            <button><a href="">삭제</a> </button>
                        </div>
                    </div>


                </div>


                <!--   탭 2 내용-->
                <div id="tab2" data-tab-content class="items">
                    <div class="userpage_tab2">
                        <h2>문의 내역 리스트</h2>
                        <table>
                            <tr>
                                <th>no.</th>
                                <th>제목</th>
                                <th>별점</th>
                                <th>작성시간</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>테스트 제목</td>
                                <td>별은 몇개</td>
                                <td>테스트 작성시간 </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        const tabs = document.querySelectorAll("[data-tab-target]");
        const tabcon = document.querySelectorAll("[data-tab-content]");
        tabs.forEach((tab) => {
            tab.addEventListener("click", () => {
                const target = document.querySelector(tab.dataset.tabTarget);
                tabcon.forEach((tabc_all) => {
                    tabc_all.classList.remove("active");
                });

                target.classList.add("active");
            });
        });

    </script>
</body>
</html>