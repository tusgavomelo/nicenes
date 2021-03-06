<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/jsp/partials/css_links.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/partials/header.jsp" />
<section class="container">
	<jsp:include page="/WEB-INF/jsp/partials/menu.jsp" />
	<h1>Lista de Categorias</h1>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Opções</th>
		</tr>
		
					
		<c:forEach var="categoria" items="${categorias}">
			<tr>
				<td>${categoria.categoria}</td>
				<td><a href="excluir-categoria?id=${categoria.categoria_id }">Excluir</a> | <a href="editar-categoria?id=${categoria.categoria_id }">Editar</a></td>
			</tr>
		</c:forEach>
	</table>

</section>
</body>
</html>