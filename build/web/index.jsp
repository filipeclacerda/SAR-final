<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<html lang="pt-BR">

    <head>
        <style>
            .boxed {
                height: 150px;
                width: 300px;
                background-color: #f3e1f0;
                border-radius: 5%;
                padding-top: 30px;
            }
            
        </style>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <title>SAR - Cadastrar Funcionário</title>


        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>

    <body>
        <%@include  file="navbar.html" %>
        <br><br>
        <div class="row">
            <div class="col"></div>           
            <div class="col">
                <div class="boxed">
                    <center>
                        <label><b>Pesquisar e Cadastrar cargos</b></label><br><br>
                        <a href="PesquisaCargoController" class="btn btn-danger" role="button" aria-pressed="true">Cargos</a>   
                    </center>
                </div>
            </div>
            <br>
            <div class="col">
                <div class="boxed">
                <center>
                    <label><b>Pesquisar e Cadastrar Funcionários</b></label><br><br>
                    <a href="PesquisaFuncionarioController" class="btn btn-danger" role="button" aria-pressed="true">Funcionários</a>
                </center>
            </div>
            </div>
            <div class="col"></div>
        </div> <br>
        <div class="row">  
            <div class="col"></div>
            <div class="col">
                <div class="boxed">
                <center>
                    <label><b>Pesquisar e Cadastrar Motivos</b></label><br><br>
                    <a href="PesquisaMotivoController" class="btn btn-danger" role="button" aria-pressed="true">Motivos</a>
                </center>
            </div>         
            </div>  <br>
            <div class="col">
                <div class="boxed">
                <center>
                    <label><b>Pesquisar e Cadastrar Despesas</b></label><br><br>
                    <a href="PesquisaDespesaController" class="btn btn-danger" role="button" aria-pressed="true">Despesas</a>
                </center>
                    </div>  
            </div>
            <div class="col"></div>
        </div>
    </body>

</html>