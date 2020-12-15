<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@include  file="navbar.html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Motivo</title>
    </head>
    <body>
        <h1>Pesquisa de Motivo</h1>
       <div class="tabela">
        <table class="table table-bordered">
            <tr>
                <th scope="col">ID Motivo</th>
                <th scope="col">Nome</th>
                <th scope="col">Editar</th>
                <th scope="col">Excluir</th>
                
            </tr>
            <c:forEach items="${motivos}" var="motivo">
                <tr>
                    <td scope="row"><c:out value="${motivo.idMotivo}" /></td>
                    <td scope="row"><c:out value="${motivo.nomeMotivo}" /></td>
                    <td scope="row"><a href="ManterMotivoController?acao=prepararOperacao&operacao=Editar&idMotivo=<c:out value="${motivo.idMotivo}"/>"><button type="button" class="btn btn-outline-primary">Editar</button></a></td>
                    <td scope="row"><a href="ManterMotivoController?acao=prepararOperacao&operacao=Excluir&idMotivo=<c:out value="${motivo.idMotivo}"/>"><button type="button" class="btn btn-outline-danger">Excluir</button></a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterMotivoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <button type="submit" class="btn btn-primary">Incluir</button>
        </form>
    </body>
</html>
