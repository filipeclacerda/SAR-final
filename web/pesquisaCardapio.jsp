<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Pesquisa de items do cardapio</title>
         <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        
<%@include  file="navbar.html" %>
        <h1>Pesquisa de items do cardapio</h1>
        <div class="tabela">
        <table class="table table-bordered">
            <tr>
                <th scope="col">IDCardapio</th>
                <th scope="col">Nome Cardapio</th>
                <th scope="col">Preco</th>
                <th scope="col">Editar</th>
                <th scope="col">Excluir</th>
                
            </tr>
            <c:forEach items="${cardapios}" var="cardapio">
                <tr>
                    <td scope="row"><c:out value="${cardapio.idCardapio}" /></td>
                    <td scope="row"><c:out value="${cardapio.nomeCardapio}" /></td>
                    <td scope="row"><c:out value="${cardapio.preco}" /></td>
                    <td scope="row"><a href="ManterCardapioController?acao=prepararOperacao&operacao=Editar&idCardapio=<c:out value="${cardapio.idCardapio}"/>"><button type="button" class="btn btn-outline-primary">Editar</button></a></td>
                    <td scope="row"><a href="ManterCardapioController?acao=prepararOperacao&operacao=Excluir&idCardapio=<c:out value="${cardapio.idCardapio}"/>"><button type="button" class="btn btn-outline-danger">Excluir</button></a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterCardapioController?acao=prepararOperacao&operacao=Incluir" method="post">
            <button type="submit" class="btn btn-primary">Incluir</button>
        </form>
    </body>
</html>
