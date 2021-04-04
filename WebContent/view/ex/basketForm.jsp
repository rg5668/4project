<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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


</style>
</head>
<script src="/maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
$( document ).ready( function() {
  $( '.check-all' ).click( function() {
      $( '.ab' ).prop( 'checked', this.checked );
      itemSum(this.form);
   } );
} );
</script>
<script type="text/javascript">
function itemSum(f)
{
   var sum = 0;
   var count = f.select.length;
   if(count==null)
	{
	   if( f.select.checked == true )
		{
		   sum+=parseInt(f.select.id);
		}
	}
   else
	{
   		for(var i=0; i < count; i++ )
   		{
       		if( f.select[i].checked == true )
       		{
    	   		sum += parseInt(f.select[i].id);
       		}
   		}
	}
   f.total_sum.value = sum+'원';
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
  <h2>장바구니</h2>
    <p>기타문의 사항은 고객센터로 연락주세요</p>
  </div>
</div>

<div class="main">
   <div class="col-md-6 col-sm-12">
   <div class="service-form">
   <h3>장바구니 내역</h3>
	<form name="f" >
	<table style="width:100%">
	
	<tr >
	<td colspan="2" >
	<b style="margin-right: 80%"><input type="checkbox" name="all" class="check-all" >&nbsp;전체선택</b></td>
	</tr>
	<c:forEach var="b" items="${list }">
		<tr><td><input type="checkbox" name="select" value=${b.getBcount() } class="ab" onClick="itemSum(this.form);" id="${b.price }"></td>
		<td>
		<a href="productinfo?pcode=${b.getPcode()}&id=${b.getId()}">
		<img src="<%=request.getContextPath()%>/view/ex/img/${b.getPimg() }" width="150px" height="150px"></a>
		</td>
			
		</tr>
		<tr>
			<td>상품명</td>
			<td><a href="productinfo?pcode=${b.getPcode()}&id=${b.getId()}">${b.getPname() }</a></td>
		</tr>
		<tr>
			
			<td>상품코드</td>
			<td>${b.getPcode()}</td>
		</tr>
		<tr>
			
			<td>가격</td>
			<td>${b.getPrice() }원</td>
		</tr>
	</c:forEach>
	</table>
	<div align="center">
	<p align="left">합계:&nbsp;<input name="total_sum" type="text" size="20" "></p>
	<input type="submit" value="구매하기" formaction='basketbuy?id=${id}'  class="btn2">
	<input type="submit" value="장바구니 내역 삭제" formaction='basketdelete?id=${id}'  class="btn2">
	</div>
</form>
	</div></div></div></main></div></body>
</html>