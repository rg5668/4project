<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>

<html>
<head>
<title>CUWET Q&A</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/real.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main2.css">
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);
* {font-family: 'Noto Sans KR', sans-serif; }

</style>

</head>

<script>

function board_submit() {
	var f = document.f;
	if(f.name.value=="") {
		alert("이름을 입력하세요")
		f.name.focus();
		return;
	} 
	if(f.subject.value=="") {
		alert("제목을 입력하세요")
		f.subject.focus();
		return;
	}
	if(f.content.value=="") {
		alert("내용을 입력하세요")
		f.content.focus();
		return;
	}
	f.submit();
}	
</script>

<body class="w3-content" style="max-width:1200px">

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:250px">

  <!-- Push down content on small screens -->
  <div class="w3-hide-large" style="margin-top:83px"></div>
  
  <!-- Top header -->
  
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
    
<!-- header -->
<main>
<div class="sidenav">
<a href="main"><img src="<%=request.getContextPath()%>/view/ex/img/logo2.jpg" style="width:150"></a>
 <div class="service-main-text">
  <h2>고객센터<br> Q&A 작성 </h2>
            <p> ${name}님<br>
            	문의 사항을 작성해 주세요. </p>
            	<a href="SList">
  <input type="button" class="btn3" value="문의목록" style="width:60%"><br>
  </a>
  </div></div>

<div class="main" >
 <div style="width: 80%">
   <div >
   <h3>Q&A</h3>
	<form action="SBoard" name="f" method="post" enctype="multipart/form-data">
		<div >
        <p>    <label>제목</label>
            <input type="text" class="form-control" name="subject"></p>
         </div>		
         <div >
        <p>    <label>이름</label>
           <input type="text" class="form-control" value="${name}"></p>
         </div>
        <div >
        <p><label>문의 카테고리</label><br>
		<select name="category" style="width: 100%">
        <option value="배송">배송문의</option>
         <option value="반품교환환불">반품/교환/환불</option>
         <option value="주문결제">주문결제</option>
         <option value="회원서비스">회원서비스</option>
         </select></p></div>
		<div >
          <p>  <label>Q&A 내용</label><br>
            <textarea cols="30" rows="5" name="content"></textarea> </p>
         </div>
         		<div>
          <p>  <label>첨부파일</label>
            <input type="file" name="file1" style="width: 100%"> </p>
         </div>
         
         <div align="center">
         <a href="javascript:board_submit()">
         <input type="button" value="등록" class="btn"></a>
         </div>
	</form>
</div></div></div>
</main></div>

</body>

</body>
</html>

