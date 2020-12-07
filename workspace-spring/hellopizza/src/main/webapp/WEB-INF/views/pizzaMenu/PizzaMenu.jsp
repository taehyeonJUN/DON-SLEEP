<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴정보</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>

	<br><br><br><br>
	
	<form action = "${pageContext.request.contextPath}/order/add.do" method = "post">
	<c:forEach var="vo1" items="${selectTopping}" varStatus="stat">
	<div class="sort">
	<input type="checkbox" value="${vo1.meId}" name="liMeid">
	<input type="hidden" value='${vo1.meName}' name="liMename"><c:out value='${vo1.meName}'></c:out>
	<input type="hidden" value='${vo1.mePrice}' name="liMeprice"><c:out value='${vo1.mePrice}'></c:out>	
	수량 : <input type="text" name="liEa" value="0" size="1"/> <br />
	</div>
	</c:forEach>
<%-- 	메뉴아이디 : <input type="text" name="liMeid" value="${PizzaOrderVo.liMeid}"/> <br /> --%>
	
		<br><br><br><br>
	<c:forEach var="vo2" items="${selectSize}" varStatus="stat">
	<div class="sort">
	<input type="checkbox" value="${vo2.meId}" name="liMeid">
	<input type="hidden" value='${vo2.meName}' name="liMename"><c:out value='${vo2.meName}'></c:out>
	<input type="hidden" value='${vo2.mePrice}' name="liMeprice"><c:out value='${vo2.mePrice}'></c:out>
	수량 : <input type="text" name="liEa"  value="0" size="1"/> <br />
	</div>
	</c:forEach>
	
		<br><br><br><br>
	<c:forEach var="vo3" items="${selectSide}">
	<div class="sort">
	<input type="checkbox" value="${vo3.meId}" name="liMeid">
	<input type="hidden" value='${vo3.meName}' name="liMename"><c:out value='${vo3.meName}'></c:out>
	<input type="hidden" value='${vo3.mePrice}' name="liMeprice"><c:out value='${vo3.mePrice}'></c:out>
		수량 : <input type="text" name="liEa"  value="0" size="1" /> <br />
</div>
	</c:forEach>

	<br>
	<input type="submit" value="주문">
	</form>


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.js">

	</script>
	<script type="text/javascript">
	
	$(function() {
		$('.sort').each(function(index, item) {
			$(this).find('[name="liMeid"]').attr('name', 'insLi['+index+'].liMeid');
			$(this).find('[name="liEa"]').attr('name', 'insLi['+index+'].liEa');
			$(this).find('[name="liMename"]').attr('name', 'insLi['+index+'].liMename');
			$(this).find('[name="liMeprice"]').attr('name', 'insLi['+index+'].liMeprice');
		})
		
	})
	</script>


</body>
</html>