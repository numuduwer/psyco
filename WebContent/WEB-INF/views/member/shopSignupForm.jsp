<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	function goBack(){
		window.history.back();
	}
		function imagepreview(input){
		       if(input.files && input.files[0]){
		           var filerd = new FileReader();
		           filerd.onload=function(e){
		               $('#imgpreview').attr('src', e.target.result);
		           };
		           filerd.readAsDataURL(input.files[0]);
		       }
		     }

</script>
<body>

    <!--  기능  타이틀 -->
    <div class="myPage_mainTitle">
        <h1>가게 등록페이지  </h1>
        <ul class="shignupStep">
            <li>
                <div class="shignupStep_box">1. 가입유형 선택</div>
            </li>
            <li>
                <div class="shignupStep_box">2. 사업자등록 확인</div>
            </li>
            <li>
                <div class="shignupStep_box">3. 회원정보</div>
            </li>
            <li>
                <div class="shignupStep_box_on">4. 가게정보</div>
            </li>
        </ul>
        <div class="myPage_userTitle">
            <h3 class="myPage_subTitle"> 4. 가게정보</h3>
        </div>
    </div>
 

    <div class="form_box2">

        <form  action="/psyco/member/shopSignupPro.com" method="post" enctype="multipart/form-data">
		<input type="hidden" name="member_num" value="${member_num}">
		
		 <div class="form_newBox">
                <div class="form_newBox_title">
                   	가게이름 
                </div>
                <div class="form_newBox_content">
                     <input class="form_newBox_input" type="text" name="shop_name" />
                </div>            
         </div>
         
         <div class="form_newBox">
                <div class="form_newBox_title">
                   	가게 연락처  
                </div>
                <div class="form_newBox_content">
              		<input class="form_newBox_input" type="text" name="shop_phone" />
             		<span>※(-) 없이 붙여서 입력해주세요.  </span>
                </div>
         </div>
         
          <div class="form_newBox">
                <div class="form_newBox_title">
                   	영업시간  
                </div>
                <div class="form_newBox_content">
                	<input class="form_newBox_input" type="text" name="operating_time" />
             		<span>※(예시 9시부터 6시반 : 09:00 ~ 06:30 )  </span>
                </div>
         </div>
         
         <div class="form_newBox">
                <div class="form_newBox_title">
                   	가게주소   
                </div>
                <div class="form_newBox_content">
                	<input class="form_newBox_input" type="text" name="address" />      
                </div>
         </div>
         
           
         <div class="form_newBox">
                <div class="form_newBox_title">
                   	원산지    
                </div>
                <div class="form_newBox_content">
                 <input class="form_newBox_input" type="text" name="origin" />    
                </div>
         </div>
         
         
          <div class="form_newBox">
                <div class="form_newBox_title">
                   	가게 이미지    
                </div>
                <div class="form_newBox_content">
                	<img id="imgpreview"  width="100" height="100">  
                   	<input type="file" onchange="imagepreview(this);" name="shop_img"/>
                </div>
         </div>
     	
     	            <br><br>
            <div class="form_newBox_content2">
            <input type="button" value="취소" onclick="history.go(-1) " class="form_btn" />
             <input type="submit" value="등록 " class="form_btn" />
            
            </div>
     	
     	
       
         
        
         
            
		
		<!-- 
            <div class=form_tab>
                <label for="" class="form_title"> 가게이름</label>
                <input class="form_input" type="text" name="shop_name" />
            </div>
            <div class=form_tab>
                <label for="" class="form_title"> 가게번호</label>
                <input class="form_input" type="text" name="shop_phone" />
            </div>
            <div class=form_tab>
                <label for="" class="form_title"> 영업시간</label>
                <input class="form_input" type="text" name="operating_time" />
            </div>

            <div class=form_tab>
                <label for="" class="form_title">가게 주소</label>
                <input class="form_input" type="text" name="address" />
            </div>

            <div class=form_tab>
                <label for="" class="form_title">원산지</label>
                <input class="form_input" type="text" name="origin" />
            </div>

            <div class=form_tab>
                <label for="" class="form_title">포장여부</label>
                <input type="checkbox" name="takeout" value="1" />
            </div>
            <div class=form_tab>
		       	<label for="" class="form_title"><img id="imgpreview"  width="100" height="100">가게 이미지</label>
		       	<input type="file" onchange="imagepreview(this);" name="shop_img"/>
			</div>

            <div class=form_tab>
                <label for="" class="form_title">사업자 번호</label>
                 <input type="text" name="license_number" />
                 <input type="text" name="license_number" value="${license_number}" readonly />
            </div>

            <ul class="form_btn_box">
                <li>
                    <input class=form_btn2 type="button" value="뒤로가기" onClick="history.go(-1);" >
                </li>
                <li>
                    <input class=form_btn2 type="submit" id="nextBtn" value="다음으로">
                </li>
            </ul> -->
</form>
</div>

	
</body>
</html>