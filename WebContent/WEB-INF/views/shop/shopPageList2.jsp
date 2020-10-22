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
        <h1>사장님 마이페이지</h1>

        <div class="myPage_shopTitle ">
            <h2 class="myPage_subTitle">내 가게 관리하기 </h2>
        </div>
    </div>



    <!--   탭 버튼-->
    <div class="myPage">
        <div class="myPage_content">
            <div class="myPage_main">
                <div class="tabs">
                    <div class="tab" data-tab-target="#tab1">
                        <p>내 가게 리스트</p>
                    </div>
                    <div class="tab" data-tab-target="#tab2">
                        <p>내 가게 리뷰목록 </p>
                    </div>
                    <div class="tab" data-tab-target="#tab3">
                        <p>서비스 탈퇴하기</p>
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
                                <li><a href="">가게 이름</a></li>
                                <li>
                                    <span> 주소</span>
                                </li>
                                <li>
                                    <span> 영업시간</span>
                                </li>
                            </ul>
                            <ul class="myPage_item_info_btnList">
                                <li><button class="shop_btn"><a href="">수정</a> </button></li>
                                <li><button class="shop_btn"><a href="">삭제</a> </button></li>
                            </ul>

                        </div>
                        <div class="myPage_item_info">
                            <img src="/img/item/one/1.jpg" alt="">
                            <ul>
                                <li><a href="">가게 이름</a></li>
                                <li>
                                    <span> 주소</span>
                                </li>
                                <li>
                                    <span> 영업시간</span>
                                </li>
                            </ul>
                            <ul class="myPage_item_info_btnList">
                                <li><button class="shop_btn"><a href="">수정</a> </button></li>
                                <li><button class="shop_btn"><a href="">삭제</a> </button></li>
                            </ul>

                        </div>
                        <div class="myPage_item_info">
                            <img src="/img/item/one/1.jpg" alt="">
                            <ul>
                                <li><a href="">가게 이름</a></li>
                                <li>
                                    <span> 주소</span>
                                </li>
                                <li>
                                    <span> 영업시간</span>
                                </li>
                            </ul>
                            <ul class="myPage_item_info_btnList">
                                <li><button class="shop_btn"><a href="">수정</a> </button></li>
                                <li><button class="shop_btn"><a href="">삭제</a> </button></li>
                            </ul>
                        </div>
                    </div>


                </div>


                <!--   탭 2 내용-->
                <div id="tab2" data-tab-content class="items">
                    <div class="userpage_tab2">
                        <h2>가게리뷰 리스트</h2>
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

                <!--   탭 3 내용-->
                <div id="tab3" data-tab-content class="items">
                    <div class="form_box">
                        <form action="" class="form">
                            <div class=form_tab>
                                <label for="" class="form_title"> 아이디</label>
                                <input type="text" class="form_input" />
                            </div>
                            <div class=form_tab>
                                <label for="" class="form_title"> 패스워드</label>
                                <input type="text" class="form_input" />
                            </div>


                            <div class=form_tab>
                                <input type="button" class="form_btn" value="제출" />
                                <input type="button" class="form_btn" value="뒤로" />
                            </div>
                        </form>
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