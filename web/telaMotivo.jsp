<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<html>
<title>SAR</title>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <%@include  file="navbar.html" %>
    <h1>
        Manter Motivo - ${operacao}
    </h1>
    <form action="ManterMotivoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterMotivo">
      <label for="idmot">Codigo do motivo: </label><br>
        <input type="text" id="idmot" value="${motivo.idMotivo}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>><br>
        <label for="nomemot">Nome Motivo: </label><br>              
        <input type="text" id="nomemot" value="${motivo.nomeMotivo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br><br>
        <button type="submit" class="btn btn-primary">Incluir</button>
    </form>
        </table>
    </form>

</body>

</html>