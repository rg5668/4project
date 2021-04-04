<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
<style type="text/css">

@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);
* {font-family: 'Noto Sans KR', sans-serif; }
.main {
	margin-top:100px;
}
</style></head>
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
  <h2>고객센터<br> Q&A 답변 </h2>
            <p> 문의 사항에 답변을<br> 작성해 주세요. </p>
  </div></div>

<div class="main">
<div class="col-md-6 col-sm-12">
<form action="SReply" method="post" enctype="multipart/form-data" name="f">
	<input type="hidden" name="num" value="${board.num}">
	<input type="hidden" name="ref" value="${board.ref}">
	<input type="hidden" name="reflevel" value="${board.reflevel}">
	<input type="hidden" name="refstep" value="${board.refstep}">
	<table>
	<tr><td>글쓴이</td><td>
	<input type="text" name="name"></td></tr>
    <tr><td>제목</td><td><input type="text" name="subject" value="└RE:${board.subject}"></td></tr>
    <tr><td>분류</td><td>  ${board.category}</td></tr>
    <tr><td>내용</td><td><textarea cols="40" rows="15" name="content"></textarea></td></tr>
    <tr><td colspan="2">
    <a href="javascript:document.f.submit()">[답변글등록]</a></td></tr></table>
</form></div></div></main></div>
</body>
</html>