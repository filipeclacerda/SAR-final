<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<html lang="pt-BR">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>SAR - Cadastrar Funcionário</title>


</head>

<body>
    <%@include  file="navbar.html" %>
    <form action="ManterFuncionarioController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterFuncionario">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6">
                <h3>
                    Cadastrar Funcionário - ${operacao}
                </h3><br>
                <div class="row">
                    <div class="col-md-6">
                        <label for="nomeitem">ID do Funcionário:</label><br>                        
                        <input type="number" name="idFuncionario" value="${funcionario.idFuncionario}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if></td><br>
                        <label for="nomeitem">Nome do Funcionário:</label><br>
                        <input type="text" name="nomefuncionario" value="${funcionario.nome}" <c:if test="${operacao != 'Excluir'}"> readonly</c:if><br><br>
                        <label for="Cargo">Cargo:</label><br>          
                        <select name="idCargo" name="idCargo">
                            <c:forEach items="${cargos}" var="cargo">   
                          <option value="${cargo.idCargo}" <c:if test="${funcionario.cargo.idCargo == cargo.idCargo}"> selected </c:if>>${cargo.nomeCargo}</option>
                            </c:forEach>
              </select><br><br>

                        <label for="salario">Salário Inicial:</label><br>
                        <input type="text" name="salario" value="${funcionario.salario}" <c:if test="${operacao != 'Excluir'}"> readonly</c:if><br><br>
                        <br>
                    </div>
                    <div class="col-md-6">
                        <label for="logradouro">Logradouro:</label><br>
                         <input type="text" name="logradouro" value="${funcionario.logradouro}" <c:if test="${operacao != 'Excluir'}"> readonly</c:if><br><br>
                        <BR>
                        <label for="numero">Número:</label><br>
                         <input type="text" name="numero" value="${funcionario.numero}" <c:if test="${operacao != 'Excluir'}"> readonly</c:if><br><br>
                        <br><br>
                        <label for="complemento">Bairro: </label><br>
                         <input type="text" name="bairro" value="${funcionario.bairro}" <c:if test="${operacao != 'Excluir'}"> readonly</c:if><br><br>
                        <br><br>
                        <label for="estado">Estado:</label><br>
                        <select name="estado"> 
    <option value="estado">Selecione o Estado</option> 
    <option value="ac">Acre</option> 
    <option value="al">Alagoas</option> 
    <option value="am">Amazonas</option> 
    <option value="ap">Amapá¡</option> 
    <option value="ba">Bahia</option> 
    <option value="ce">Ceará¡</option> 
    <option value="df">Distrito Federal</option> 
    <option value="es">Espírito Santo</option> 
    <option value="go">Goiás</option> 
    <option value="ma">MaranhÃ£o</option> 
    <option value="mt">Mato Grosso</option> 
    <option value="ms">Mato Grosso do Sul</option> 
    <option value="mg">Minas Gerais</option> 
    <option value="pa">Pará</option> 
    <option value="pb">Paraíba</option> 
    <option value="pr">Paraná</option> 
    <option value="pe">Pernambuco</option> 
    <option value="pi">Piauí­</option> 
    <option value="rj">Rio de Janeiro</option> 
    <option value="rn">Rio Grande do Norte</option> 
    <option value="ro">Rondônia</option> 
    <option value="rs">Rio Grande do Sul</option> 
    <option value="rr">Roraima</option> 
    <option value="sc">Santa Catarina</option> 
    <option value="se">Sergipe</option> 
    <option value="sp">São Paulo</option> 
    <option value="to">Tocantins</option> 
    </select>
                        <br><br>
                        <label for="numero">Cidade:</label><br>
                        <input type="text" name="cidade" value="${funcionario.cidade}" <c:if test="${operacao != 'Excluir'}"> readonly</c:if><br><br>
                        <label for="numero">Telefone: </label><br>
                        <input type="text" name="telefone" value="${funcionario.telefone}" <c:if test="${operacao != 'Excluir'}"> readonly</c:if><br><br><br>

                        <button type="submit" class="btn btn-primary">Incluir</button>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
            </div>
        </div>
    </div>
</form>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>

</html>