<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Relatório 2 (com filtro)</h1>
        <form action="Relatorio2Controller?acao=emitir" method="post">
            Escolha o curso
            <select name="txtCodCargo">
                <c:forEach items="${cargos}" var="cargo">
                    <option value="${cargo.idCargo}">${cargo.nomeCargo}</option>  
                </c:forEach>
            </select>
            <br/>
            <input type="submit"/>
        </form>
    </body>
</html>
