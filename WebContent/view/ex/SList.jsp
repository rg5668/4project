<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
* {font-family: 'Noto Sans KR', sans-serif; font-size: 14px;}
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

<body class="w3-content" style="max-width:1200px">

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:0px">


  
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
  <h2>고객센터<br> Q&A 내역 </h2>
<p>${name }님의<br> Q&A내역입니다.</p>
  </div></div>

<div class="main" align="center">
 <div style="width: 100%">
<table >
  <c:if test="${boardcount == 0 }" >
  <tr><td colspan="5">등록된 게시글이 없습니다.</td></tr>
 </c:if>
 <c:if test="${boardcount != 0 }" >
  <tr><td colspan="6" style="text-align:right">글개수 : ${boardcount} </td></tr>
  	  
  	  <tr><td width="8%"><b>번호</b></td>
      <td width="16%"><b>Q&A분류</b></td><td width="39%"><b>제목</b></td>
      <td width="11%"><b>작성자</b></td><td width="17%"><b>등록일</b></td>
      <td width="11%"><b>조회수</b></td></tr>
<c:forEach   var="b"   items="${list}">
   <tr><td>${boardnum}</td>
   <c:set var="boardnum"  value="${boardnum-1 }" />
   	<c:if test="${b.file1 != null && !b.file1.trim() eq ''}">
      <a href="upfile/${b.file1}" style="text-decoration: none;">@</a>
      </c:if>
    <c:if test="${b.file1 == null || b.file1.trim() eq ''}">
     &nbsp;&nbsp;&nbsp; </c:if>
     
        <c:if test="${b.reflevel > 0}">
	       <c:forEach var="i"  begin="1"  end="${b.reflevel-1 }">
		   
	             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	      
	      </c:forEach>	       
	  </c:if>
		
	  <td>${b.category}</td><td><a href="SInfo?num=${b.num}">${b.subject}</a></td>
	  <td>${b.name}</td><td>${b.regdate}</td>
		<td>${b.readcnt}</td></tr>
</c:forEach>
		
   <tr><td colspan="6">
   	<c:if test="${startpage <= bottomLine}"><b style="color: blue;">[이전]</b> </c:if>
     <c:if test="${startpage > bottomLine}">
      <a href="SList?pageNum=${startpage - bottomLine}"><b style="color: blue;">[이전]</b></a></c:if> 
      
      <c:forEach  var="a"  begin="${startpage}"   end="${endpage}">
      
      <c:if test="${a==pageNum }">[${a}] </c:if>
       <c:if test="${a!=pageNum }">
        
           <a href="SList?pageNum=${a}">[${a}]</a>
         </c:if>
         </c:forEach>
        <c:if test="${endpage >= maxpage}">  <b style="color: blue;">[다음]</b></c:if>
       <c:if test="${endpage < maxpage}">
          <a href="SList?pageNum=${startpage + bottomLine}"><b style="color: blue;">[다음]</b></a></c:if>
    </td></tr>  
	<tr><td colspan="6" style="text-align:right" >
     <a href="SBoardForm"><input type="button" class="btn2" value="글쓰기" style="margin-top: 10px" ></a></td></tr>  
   
</c:if>


  
</table>
</div></div>
</main></div></body></html>