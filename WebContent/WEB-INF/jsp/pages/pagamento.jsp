<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagamento</title>
</head>
<body>
	<h1>Pagina de pagamento</h1>
	<jsp:include page="/WEB-INF/jsp/partials/lista-carrinho.jsp" />
	<h2>Op��es de frete</h2>
	<form action="fechar-compra" method="post">
		<input type="radio" name="frete" value="sedex">
		<label for="sedex">Sedex (R$ ${carrinho.subTotal * 0.2 + carrinho.subTotal})</label>
		<input type="radio" name="frete" value="pac">
		<label for="sedex">PAC (R$ ${(carrinho.subTotal * 0.1) + carrinho.subTotal })</label>
		<input type="submit" value="Fechar compra">
	</form>
</body>
</html>