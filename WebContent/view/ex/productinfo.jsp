<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/real.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main2.css">
<style type="text/css">

@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);
* {font-family: 'Noto Sans KR', sans-serif; }
</style>
</head>
<script
	src="/maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="/code.jquery.com/jquery-1.11.1.min.js"></script>



<!-- 제품 상세정보에 관한 폼 -->
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
  
<main>
	<div class="sidenav">
		<a href="main"><img
			src="<%=request.getContextPath()%>/view/ex/img/logo2.jpg"
			style="width: 150"></a>
		<div class="service-main-text">
			<h2>상품</h2>
			<p>상품 상세 내용</p>
		</div>
	</div>

	<div class="main">

		<div align="center" style="width: 90%">
			<div align="center">
				<h4>해당 상품 정보</h4>
				<form method="post" name="f">
					<table style="width: 100%">
						<tr>
							<td colspan="2"><img
								src="<%=request.getContextPath()%>/view/ex/img/${pinfo.getPimg() }"
								style="width: 160px" height="200px"></td>
							
						</tr>
						<tr>
						
							<td><b>상품이름 : </b>${pinfo.getPname() }</td>
						</tr>
						<tr>
							
							<td><b>가격 : </b>${pinfo.getPrice() }원</td>
						</tr>
						<tr>
							<td><b>상세정보 :</b> ${pinfo.getPcontent()}</td>
						</tr>
					</table>
					<div align="center">
					<input type="submit" class="btn" style="margin-top: 10px"
						value="구매하기" formaction='buyinfo?pcode=${pinfo.getPcode() }'>
					<input type="submit" class="btn" style="margin-top: 5px"
						value="장바구니 담기"
						formaction='basketInsert?pcode=${pinfo.getPcode()}'>
					</div>
				</form>
			</div>
		</div>
	</div>
</main>
</div>
</body>
</html>