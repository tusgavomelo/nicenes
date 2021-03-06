<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nicenes</title>
<jsp:include page="/WEB-INF/jsp/partials/css_links.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
	<section class="container">
		<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
		<jsp:include page="/WEB-INF/jsp/partials/listar-livros-aleatorios.jsp" />
		<jsp:include page="/WEB-INF/jsp/partials/lista-de-desejos.jsp" />
		<jsp:include page="/WEB-INF/jsp/partials/lista-carrinho.jsp" />
		<c:if test="${ not empty carrinho }">
			<a href="pagamento">Fechar compra</a>
		</c:if>
	</section>
</body>
</html>