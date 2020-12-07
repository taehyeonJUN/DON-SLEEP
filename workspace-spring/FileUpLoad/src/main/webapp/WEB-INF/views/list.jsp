<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="item" items="${list}">

	<li><span>${item.title}</span> <span>
	<img src="upload/${item.image}" width="50" height="50"></span></li>


</c:forEach>

<c:if test="${list.size() < 1}">
	<li>등록된 이미지가 없습니다.</li>
</c:if>