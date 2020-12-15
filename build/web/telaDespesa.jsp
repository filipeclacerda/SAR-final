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
        Manter Despesa - ${operacao}
    </h1>
    <form action="ManterDespesaController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterDespesa">
      <label for="idDespesa">Codigo do Despesa </label><br>
        <input type="text" name="idDespesa" id="idDespesa" value="${despesa.idDespesa}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br>
        <label for="vlrde">Valor Despesa </label><br>              
        <input type="text" name="valorDespesa" id="valorDespesa" value="${despesa.valorDespesa}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br><br>
        <label for="vlr">Valor Pago </label><br>              
        <input type="text" name="valorPago" id="valorPago" value="${despesa.valorPago}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br><br>
        <label for="datav">Data Vencimento </label><br>              
        <input type="text" name="dataVencimento" id="dataVencimento" value="${despesa.dataVencimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br><br>
        <label for="datap">Data Pagamento </label><br>              
        <input type="text" name="dataPagamento" id="dataPagamento" value="${despesa.dataPagamento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>><br><br>
        <label for="f">Funcionário: </label><br>                    
                        <select name="Funcionario_idFuncionario" id="f">
                            <option selected disabled value="0" <c:if test="${despesa.funcionario.idFuncionario == null}"> selected</c:if>>Selecione o Funcionario</option>
                            <c:forEach items="${funcionarios}" var="funcionario">   
                          <option value="${funcionario.idFuncionario}" <c:if test="${operacao =='Excluir'}"> disabled</c:if>
                            <c:if test="${despesa.funcionario.idFuncionario == funcionario.idFuncionario}"> selected</c:if>>${funcionario.nome}
                              </option>
                            </c:forEach>
              </select><br><br>
        <label for="d">Tipo de Despesa </label><br>                    
                        <select name="TipoDespesa_idTipoDespesa" id="d">
                           <option selected disabled value="0" <c:if test="${despesa.tipoDespesa.idTipoDespesa == null}"> selected</c:if>>Selecione o tipo da Despesa</option>
                            <c:forEach items="${tipoDespesas}" var="tipoDespesa">   
                          <option value="${tipoDespesa.idTipoDespesa}" <c:if test="${operacao =='Excluir'}"> disabled</c:if>
                            <c:if test="${despesa.tipoDespesa.idTipoDespesa == tipoDespesa.idTipoDespesa}"> selected</c:if>>${tipoDespesa.nomeDespesa}
                              </option>
                            </c:forEach>
              </select><br><br>      
              
              <input type="submit" name="btnConfirmar" value="Confirmar">
        
    </form>

</body>

</html>