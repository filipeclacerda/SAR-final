<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@include  file="navbar.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de funcionarios</title>
        <style>
div.tabela {
    margin: 20px;
}
</style>
    </head>
    <body>
        
        <h1>Pesquisa de funcionarios</h1>
        <div class="tabela">
        <table class="table table-bordered">
            <tr>
                <th scope="col" width="4%">ID</th>
                <th scope="col" width="30%">Nome</th>
                <th scope="col" width="10%">Telefone</th>
                <th scope="col"width="10%">Cargo</th>
                <th scope="col" width="10%">Editar</th>
                <th scope="col" width="10%">Excluir</th>
            </tr>
            <c:forEach items="${funcionarios}" var="funcionario">
                <tr>
                    <td scope="row"><c:out value="${funcionario.idFuncionario}" /></td>
                    <td scope="row"><c:out value="${funcionario.nome}" /></td>
                    <td scope="row"><c:out value="${funcionario.telefone}" /></td>
                    <td scope="row"><c:out value="${funcionario.cargo.nomeCargo}" /></td>
                    <td scope="row"><a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Editar&idFuncionario=<c:out value="${funcionario.idFuncionario}"/>"><button type="button" class="btn btn-outline-primary">Editar</button></a></td>
                    <td scope="row"><a href="ManterFuncionarioController?acao=prepararOperacao&operacao=Excluir&idFuncionario=<c:out value="${funcionario.idFuncionario}"/>"><button type="button" class="btn btn-outline-danger">Excluir</button></a></td>
                </tr>
            </c:forEach>
        </table>
        </div>
        <form action="ManterFuncionarioController?acao=prepararOperacao&operacao=Incluir" method="post">
            <button type="submit" class="btn btn-primary">Incluir</button>

            
            
        </form>
        
    </body>
</html>
