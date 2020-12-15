<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@include  file="navbar.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de cargo</title>
    </head>
    <body>
        <h1>Pesquisa de cargo</h1>
        <div class="tabela">
        <table class="table table-bordered">
            <tr>
                <th scope="col">IDCargo</th>
                <th scope="col">Nome</th>
                <th scope="col">Editar</th>
                <th scope="col">Excluir</th>
                
            </tr>
            <c:forEach items="${cargos}" var="cargo">
                <tr>
                     <td scope="row"><c:out value="${cargo.idCargo}" /></td>
                     <td scope="row"><c:out value="${cargo.nomeCargo}" /></td>
                     <td scope="row"><a href="ManterCargoController?acao=prepararOperacao&operacao=Editar&idCargo=<c:out value="${cargo.idCargo}"/>"><button type="button" class="btn btn-outline-primary">Editar</button></a></td>
                     <td scope="row"><a href="ManterCargoController?acao=prepararOperacao&operacao=Excluir&idCargo=<c:out value="${cargo.idCargo}"/>"><button type="button" class="btn btn-outline-danger">Excluir</button></a></td>
                </tr>
            </c:forEach>
        </table>
            </div>
        <form action="ManterCargoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <button type="submit" class="btn btn-primary">Incluir</button>
        </form>
    </body>
</html>
