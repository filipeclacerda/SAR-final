<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@include  file="navbar.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de produto</title>
    </head>
    <body>
        
        <h1>Pesquisa de produto</h1>
        <div class="tabela">
        <table class="table table-bordered">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Preço</th>
                <th scope="col">Editar</th>
                <th scope="col">Excluir</th>
                
            </tr>
            <c:forEach items="${produtos}" var="produto">
                <tr>
                     <td scope="row"><c:out value="${produto.idProduto}" /></td>
                     <td scope="row"><c:out value="${produto.nomeProduto}" /></td>
                     <td scope="row"><c:out value="${produto.preco}" /></td>
                     <td scope="row"><a href="ManterProdutoController?acao=prepararOperacao&operacao=Editar&idProduto=<c:out value="${produto.idProduto}"/>"><button type="button" class="btn btn-outline-primary">Editar</button></a></td>
                     <td scope="row"><a href="ManterProdutoController?acao=prepararOperacao&operacao=Excluir&idProduto=<c:out value="${produto.idProduto}"/>"><button type="button" class="btn btn-outline-danger">Excluir</button></a></td>
                </tr>
            </c:forEach>
        </table>
            </div>
        <form action="ManterProdutoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <button type="submit" class="btn btn-primary">Incluir</button>
        </form>
    
    </body>
</html>
