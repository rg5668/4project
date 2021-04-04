<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/real.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">

@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);
* {font-family: 'Noto Sans KR', sans-serif; }
</style></head>
<script src="/maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="/code.jquery.com/jquery-1.11.1.min.js"></script>

<body>
<div class="sidenav">
<a href="main"><img src="<%=request.getContextPath()%>/view/ex/img/logo2.jpg" style="width:150"></a>
 <div class="service-main-text" align="center">
  <h2>마이페이지<br></h2>
  <p>MY PAGE</p>
  
  
  <a href="buy">
  <input type="button" class="btn3" value="구매내역" style="width:60%"><br>
  </a>
  <a href="basketForm">
  <input type="button" class="btn3" value="장바구니" style="width:60%"><br>
  </a>
  <a href="SBoardForm">
  <input type="button" class="btn3" value="고객센터" style="width:60%"><br>
  </a>
  <a href="editprofile">
  <input type="button" class="btn3" value="개인정보수정" style="width:60%"><br>
  </a>
  </div>

</div>

<body class="w3-content" style="max-width:1200px">

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:20px">

  <!-- Push down content on small screens -->
  <div class="w3-hide-large" style="margin-top:83px"></div>
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
 <div class="col-md-6 col-sm-12">
   <div class="service-form" align="center" style="margin-top: 170px">
   <h3>${mem.name }님 정보</h3>
	<form name="f" method="post">

	<table id="tab" style="width:100%">
		<tr><th><label>이름 : </label></th>
        	<td> <input type="text" name="name" style="width:80%" value="${mem.getName()}" readonly="readonly">
        	</td></tr>
        <tr><th><label>주소 : </label></th>
       		<td> <input type="text" name="address" style="width:80%" value="${mem.getAddress() } " readonly="readonly">
        	</td></tr>
        <tr><th><label>생년월일 : </label>
       		</th><td> <input type="text" name="birth" style="width:80%" value="${ mem.getBirth()}" readonly="readonly">
        	</td> </tr>
         <tr><th><label>전화번호 : </label></th>
        	<td><input type="text" name="tel" style="width:80%" value="${ mem.getTel()}" readonly="readonly">
        	</td></tr></table><br>
	<div align="center">
   </div></form>
</div></div></div></body>
