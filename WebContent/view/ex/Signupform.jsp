<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import = "java.io.InputStream"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8"><title>게시물 목록 보기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);
* {font-family: 'Noto Sans KR', sans-serif; }
</style>
</head>

<script src="/maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="/code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
function Signupform_submit()
{
   var f=document.f;
   
   
	   
   if(f.id.value===""||f.id.value==null)
   {
      alert("아이디를 입력하세요");
      f.id.focus();
      return;
   }
   if(f.pass.value===""||f.pass.value==null)
   {
      alert("비밀번호를 입력하세요");
      f.pass.focus();
      return;
   }
   if(f.pass.value != f.passcheck.value ){
       alert("비밀번호를 동일하게 입력하세요.");
       f.pass.focus();
       return false;
   }
   if(f.name.value===""||f.name.value==null)
   {
      alert("이름을 입력하세요");
      f.name.focus();
      return;
   }
   if(f.userphone.value===""||f.userphone.value==null)
   {
      alert("전화번호를 입력하세요");
      f.userphone.focus();
      return;
   }
   //if(f.birth.value=="null"||f.birth==null)
   //{
     // alert("생년월임 입력하세요");
     // f.birth.focus();
     // return;
   //}
   if(f.address1.value===""||f.address1.value==null)
   {
      alert("주소를 입력하세요");
      f.address1.focus();
      return;
   }
   f.submit();
}
</script>

<body>
<div class="sidenav">
<a href="main"><img src="<%=request.getContextPath()%>/view/ex/img/logo2.jpg" style="width:150"></a>
 <div class="service-main-text">
  <h2>회원가입</h2>
  </div>
</div>

<body class="w3-content" style="max-width:1200px">

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:0px">

  <!-- Push down content on small screens -->
  <div class="w3-hide-large" style="margin-top:83px"></div>
  
  <!-- Top header -->
  
<div class="main">
<p align="right">
<font size="2px">
<c:if test="${empty session}"><a href="loginForm">로그인/회원가입&nbsp;</a></c:if>
<c:if test="${not empty session}"><a href="logout">로그아웃&nbsp;</a></c:if>
<c:if test="${empty session}"><a href="loginForm" onclick="alert('로그인 후 이용해주세요');">마이페이지&nbsp;</a></c:if>
<c:if test="${not empty session}"><a href="mypageForm">마이페이지&nbsp;</a></c:if>
<c:if test="${empty session}"><a href="loginForm" onclick="alert('로그인 후 이용해주세요');">장바구니&nbsp;</a></c:if>
<c:if test="${not empty session}"><a href="basketForm">장바구니&nbsp;</a></c:if>
<c:if test="${empty session}"><a href="loginForm" onclick="alert('로그인 후 이용해주세요');">고객센터&nbsp;</a></c:if>
<c:if test="${not empty session}"><a href="SBoardForm">고객센터&nbsp;</a></c:if>
</font>
</p>
 <div >
   <div class="service-form" align="center">
   <h2>회원가입</h2>
	<form action="Signup" name="f" method="post">
	<div>
    <div class="popup">
      
      
      	<table style="width:80%" >
          <tbody>
          <form action="idcheck" method="post">
            <tr>
              <th>아이디</th>
              <td><input type="text" id="id" name="id" placeholder="아이디를 입력해주세요">
              		<input type="submit" id="id_check" name="id_check" value="중복확인" style="width:80px;" class="btn2" formaction=idcheck></td>
            </tr>
            </form>
            <tr>
              <th>비밀번호</th>
              <td><input type="password" id="pass" name="pass" placeholder="비밀번호를 입력해주세요." style="width:80%"></td>
            </tr>
              <tr>
                <th>비밀번호 확인</th>
                <td><input type="password" id="passcheck" name="passcheck" placeholder="비밀번호를 입력해주세요." style="width:80%"></td>
              </tr>
              <tr>
              <th>이름</th>
              <td><input type="text" id="name" name="name"  placeholder="이름을 입력해주세요" style="width:80%"></td>
            </tr>
              <tr>
                <th>전화번호</th>
                <td>
                
                <input type="tel" id="userphone" name="userphone" placeholder="연락처를 입력하세요."  style="width:80%"></td>
              </tr>
            <th>생년월일</th>
              <td>
                <select id="yy" name="birthyy" class="yy_sel" aria-label="년"  style="width:26%">
                <option value="00">----년</option>
                <c:forEach var="i" begin="1" end="30">
                <option><c:out value="${2022-i}년" /></option>
                </c:forEach>
                </select>
                <select id="mm" name="birthmm" class="mm_sel" aria-label="월"  style="width:25%">
                  <option value="00">--월</option>
             <c:forEach var="i" begin="1" end="12">
                <option><c:out value="${i}월" /></option>
                </c:forEach>
                </select> 
                <select id="dd" name="birthdd" class="dd_sel" aria-label="일"  style="width:25%">
                  <option value="00">--일</option>
                  <c:forEach var="i" begin="1" end="31">
                <option><c:out value="${i}일" /></option>
                </c:forEach>
              </select><br /></td>
            </tr>
            <tr>
              <th>주소</th>
              <td><input type="text" id="address1" name="address1" placeholder="주소를 입력하세요."  style="width:80%"><br>
                  <input type="text" id="address2" name="address2" placeholder="상세주소를 입력해주세요." style="width:80%"></td>
            </tr>
            
          </tbody>
          
        </table>
        <div align="center">
        
                <button type="button" value="가입하기" onClick="Signupform_submit()" class="btn">가입하기</button>
            </div>
    
      </div>
      </div>
</form></div></div></div></body>

