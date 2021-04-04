<%@page import="dao.SBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
var CON;
CON=confirm("정말로 게시물을 삭제하시겠습니까?");
if(CON){
	"${dao.delete(num)}";
	location.href="${url1}";
} else {
	location.href="${url2}";
}
</script>