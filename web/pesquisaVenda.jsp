<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Histórico de Vendas</title>
        <style>
div.inclu {
  margin: 35px;
}
div.tabela {
    margin: 20px;
}
</style>
    </head>
    <body>
        <%@include  file="navbar.html" %>
        <h1>Consultar Histórico de Vendas</h1>
        <div class="tabela">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col" width="4%">Data da Venda:</th>
                <th scope="col" width="30%">Funcionario:</th>
                <th scope="col" width="10%">Valor:</th>
            </tr>
            </thead>
            <c:forEach items="${vendas}" var="venda">
                <tr>
                    <td scope="row"><c:out value="${venda.dataVenda}" /></td>
                    <td scope="row"><c:out value="${venda.funcionario.nome}" /></td>
                    <td scope="row"><c:out value="${venda.valorTotal}" /></td>
                </tr>
            </c:forEach>
        </table>
        </div>

        
    </body>
</html>
