<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/real.css">
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);
* {font-family: 'Noto Sans KR', sans-serif; }
table {	width : 100%;	border-collapse: collapse;  }
th,td {
	border : 2px solid #bcbcbc;
	text-align: center;  	padding : 8px;
}
th {    background-color: white; 	color : white;   }
td {	background-color: white;}
caption {
	color : #111111; 	font-size: 20px;
	background-color: #FFFFFF;
}
input[type=text],input[type=password],textarea {
	width : 100%;
}


</style></head>
<script>
function button_event(){
if (confirm("정말 삭제하시겠습니까??") == true){    //확인
    document.form.submit();
}else{   //취소
    return;
}}
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
  <h2>고객센터<br> Q&A </h2>
            <p> Q&A 내역 확인 </p>
</div></div>

<div class="main">
 <div class="col-md-6 col-sm-12">
<table>
<tr><td width="20%">글쓴이</td>
	<td width="80%" style="text-align: left">${board.name}</td></tr>
<tr><td>제목</td><td style="text-align: left">${board.subject}</td></tr>
<tr><td>문의사항</td><td style="text-align: left">${board.category}</td></tr>
<tr><td>내용</td><td>
 <table style="width:100%; height:250px;"><tr><td
 style="border-width: 1px; vertical-align: top; text-align: left;">
${board.content}</td></tr></table></td></tr>
<tr><td>첨부파일</td>
	<td style="text-align: left;">
	<c:if test="${board.file1==null || board.file1.trim() eq '' }">&nbsp;</c:if>
	<c:if test="${board.file1!=null && board.file1.trim() ne '' }">
	<a href="<%=request.getContextPath()%>/view/ex/upfile/${board.file1 }">${board.file1 }</a></c:if>
</td></tr>
<tr><td colspan="2">
	<a href="SReplyForm?num=${num}"><b style="color: blue;">[답변]</b></a>	
	<a href="SUpdateForm?num=${num}"><b style="color: blue;">[수정]</b></a>	
	<a href="SDelete?num=${num }"><b style="color: blue;">[삭제]</b></a>
	<a href="SList"><b style="color: blue;">[목록]</b></a>	
</td></tr></table></div></div></main></div>
</body>
</html>