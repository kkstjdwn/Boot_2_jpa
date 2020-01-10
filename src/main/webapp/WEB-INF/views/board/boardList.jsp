<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록's</title>
<c:import url="../template/boot.jsp"/>
</head>
<body>
<c:import url="../template/nav.jsp"/>

<div class="container">
  <h2 style="text-align: center;">${board} List</h2>
  <div style="min-height: 410px; margin-bottom: 20px;">            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>글번호</th>
        <th>글제목</th>
        <th>글쓴이</th>
        <th>작성날짜</th>
        <th>조회수</th>
        <c:if test="${board eq 'Qna' }">
	        <th>REF</th>
	        <th>STEP</th>
	        <th>DEPTH</th>
        </c:if>
      </tr>
    </thead>
    <tbody>
	<c:forEach items="${list }" var="boardVO">
      <tr>
        <td>${boardVO.num }</td>
        <td><a href="NoticeSelect?num=${boardVO.num }">${boardVO.title }</a></td>
        <td>${boardVO.writer }</td>
        <td>${boardVO.regDate }</td>
        <td>${boardVO.hit }</td>
        <c:if test="${board eq 'Qna' }">
	        <td>${boardVO.ref }</td>
	        <td>${boardVO.step }</td>
	        <td>${boardVO.depth }</td>
        </c:if>
        <td>
        	<c:forEach items="${boardVO.filesList }" var="f">
        		<span> ${f.oname }</span>
        	</c:forEach>
        </td>
      </tr>      
	</c:forEach>
    </tbody>
  </table>
  </div>
<!-- PAGER ----------------------------------------------------->  
 	<div class="or-pager" style="text-align: center;">
		<c:if test="${pager.curBlock gt 0 }">
			
			<button type="button" class="btn-pager" id="none-hover"> << </button>
		</c:if>
		<c:if test="${pager.curBlock ne 0 }">
			<button type="button" class="btn-pager" id="none-hover"> < </button>
		</c:if>
		<c:forEach begin="${pager.startNum }" end="${pager.lastNum}" var="p">
		<c:choose>
			<c:when test="${pager.curPage eq p }">
				<button type="button" style="color: black; font-weight: bold;" title="${p }" class="btn-pager" id="move"> ${p } </button>
			</c:when>
			<c:otherwise>
<%-- 				<a href="NoticeList?page=${p-1 }&size=10">${p }</a> --%>
				<button type="button" value="${p }"  class="btn-pager" id="move" onclick="search()"> ${p } </button>
			</c:otherwise>
		</c:choose>
		
		</c:forEach>
		<c:if test="${pager.curBlock lt pager.totalBlock-1 }">
			<button type="button" class="btn-pager" id="none-hover"> > </button>
			<c:if test="${pager.totalBlock gt pager.curBlock }">
				<button type="button" class="btn-pager" id="none-hover"> >> </button>
			</c:if>
		</c:if>
<!-- PAGER ----------------------------------------------------->
	<select name="kind" id="kind">
		<option value="tt">제목</option>
		<option value="wt">작성자</option>
		<option value="ct">내용</option>
	</select>
	
	<input name="search" type="text" id="search">
	
	<button type="button" onclick="search()">검색</button>
	</div>
	
</div>

<script type="text/javascript">
	function search() {
		var 
		location.href = "NoticeList?kind="+$("#kind").val()+"&search="+$("#search").val()+"&page="$("#move").val()+"&size=10";
		}
</script>
</body>
</html>