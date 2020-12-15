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
        Manter Cargo - ${operacao}
    </h1>
    <form action="ManterCargoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterCargo">
      <label for="idDespesa">Codigo do Cargo </label><br>
        <input type="text" name="idcargo" id="idcargo" value="${cargo.idCargo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br>
        <label for="vlrde">Nome do Cargo </label><br>              
        <input type="text" name="nomecargo" id="nomecargo" value="${cargo.nomeCargo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br><br>   
              
          <input type="submit" name="btnConfirmar" value="Confirmar">
        
    </form>

</body>

</html>