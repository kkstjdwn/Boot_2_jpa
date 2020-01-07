<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${notice.title }</title>
<c:import url="../template/boot.jsp"/>
</head>
<body>
<c:import url="../template/nav.jsp"/>
	<div class="container">
		<form>
			<div class="form-group">
		      <label class="control-label col-sm-2" for="title">제목</label>
				<div class="col-sm-10">
	      			<input type="text" class="form-control" id="title" value="${notice.title }" readonly="readonly">
				</div>
	    	</div>
	    	<div class="form-group">
		      <label class="control-label col-sm-2" for="writer">작성자</label>
				<div class="col-sm-10">
	      			<input type="text" class="form-control" id="writer" value="${notice.writer}" readonly="readonly">
				</div>
	    	</div>
	    	<div class="form-group">
		      <label class="control-label col-sm-2" for="contents">내용</label>
				<div class="col-sm-10">
	      			<input class="form-control" id="contents" value="${notice.contents }" readonly="readonly" style="width: 100%; height: 500px;">
				</div>
	    	</div>
	    	<div class="form-group">
		      <label class="control-label col-sm-2" for="regDate">작성날짜</label>
				<div class="col-sm-10">
	      			<input type="text" class="form-control" id="regDate" value="${notice.regDate }" readonly="readonly">
				</div>
	    	</div>
	    	<div class="form-group">
		      <label class="control-label col-sm-2" for="hit">조회수</label>
				<div class="col-sm-10">
	      			<input type="text" class="form-control" id="hit" value="${notice.hit}" readonly="readonly">
				</div>
	    	</div>
	    	<c:if test="${list.size() ne 0 }">
		    	<c:forEach items="${list }" var="f">
			    	<div class="form-group">
				      <label class="control-label col-sm-2" for="files">첨부파일</label>
						<div class="col-sm-10">
			      			<input type="text" class="form-control files" value="${f.oname}" readonly="readonly">
						</div>
			    	</div>
		    	</c:forEach>
	    	</c:if>
		</form>
	</div>
</body>
</html>