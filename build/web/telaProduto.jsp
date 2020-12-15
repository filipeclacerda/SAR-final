<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<html>
<title>SAR</title>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>
    <%@include  file="navbar.html" %>
  
    <h1>
        Manter Produto - ${operacao}
    </h1>
    <form action="ManterProdutoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterCargo">
        <label for="idProduto">Codigo do Produto:</label><br>
        <input type="text" id="idProduto" value="${produto.idProduto}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>><br>
        <label for="nomeCargo">Nome Produto:</label><br>              
        <input type="text" id="nomeCargo" value="${produto.nomeProduto}" <c:if test="${operacao != 'Excluir'}"> readonly</c:if>><br><br>
        <label for="preco">Preço:</label><br>              
        <input type="number" id="preco" value="${produto.preco}" <c:if test="${operacao != 'Excluir'}"> readonly</c:if>><br><br>
        
        <button type="submit" class="btn btn-primary">Incluir</button>
    </form>

</body>

</html>