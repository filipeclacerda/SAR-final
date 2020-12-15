<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@include  file="navbar.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de despesa</title>
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
        
        <h1>Pesquisa de despesa</h1>
        <div class="tabela">
        <table class="table table-bordered">
            <tr>
                <th scope="col" width="4%">ID</th>
                <th scope="col" width="30%">valorDespesa</th>
                <th scope="col" width="10%">dataVencimento</th>
                <th scope="col"width="10%">funcionario</th>
                <th scope="col"width="10%">tipoDespesa</th>                
                <th scope="col" width="10%">Editar</th>
                <th scope="col" width="10%">Excluir</th>
            </tr>
            <c:forEach items="${despesas}" var="despesa">
                <tr>
                    <td scope="row"><c:out value="${despesa.idDespesa}" /></td>
                    <td scope="row"><c:out value="${despesa.valorDespesa}" /></td>
                    <td scope="row"><c:out value="${despesa.dataVencimento}" /></td>
                    <td scope="row"><c:out value="${despesa.funcionario.nome}" /></td>
                    <td scope="row"><c:out value="${despesa.tipoDespesa.nomeDespesa}" /></td>
                    <td scope="row"><a href="ManterDespesaController?acao=prepararOperacao&operacao=Editar&idDespesa=<c:out value="${despesa.idDespesa}"/>"><button type="button" class="btn btn-outline-primary">Editar</button></a></td>
                    <td scope="row"><a href="ManterDespesaController?acao=prepararOperacao&operacao=Excluir&idDespesa=<c:out value="${despesa.idDespesa}"/>"><button type="button" class="btn btn-outline-danger">Excluir</button></a></td>
                </tr>
            </c:forEach>
        </table>
        </div>
        <form action="ManterDespesaController?acao=prepararOperacao&operacao=Incluir" method="post">
            <div align="right" class="inclu">
            <button type="submit" class="btn btn-primary">Incluir</button>
            </div>
            
            
        </form>
        
    </body>
</html>
