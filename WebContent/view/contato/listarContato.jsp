<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mensagens</title>
</head>
<body>

<!-- Bootstrap Core CSS -->
    <link href="view/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="view/css/shop-homepage.css" rel="stylesheet">
    
    <!-- jQuery -->
    <script src="view/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="view/js/bootstrap.min.js"></script>
    
</head>
<body>

<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand">ELETROSTEC</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                    	<a href="#" data-toggle="dropdown" class="dropdown-toggle"> PRODUTO <b class="caret"></b></a>
                    	<ul class="dropdown-menu">
                            <li><a href="exibirIncluirProduto">CADASTRO</a></li>
                            <li><a href="listarProduto">LISTAR</a></li>
                        </ul>
                    	</li>

                    <li class="dropdown">
                    	<a href="#" data-toggle="dropdown" class="dropdown-toggle"> CATEGORIA <b class="caret"></b></a>
                    	<ul class="dropdown-menu">
                            <li><a href="exibirIncluirCategoriaProduto">CADASTRO</a></li>
                            <li><a href="listarCategoriaProduto">LISTAR</a></li>
                        </ul>
                    	</li>
                    	
                    <li class="dropdown">
                        <a href="#" data-toggle="dropdown" class="dropdown-toggle"> FUNCIONÁRIO <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="exibirFuncionario">CADASTRO</a></li>
                            <li><a href="listarContato">MENSAGENS</a></li>
                        </ul>
                    </li>

	                    <li style="padding-left: 300px;">
	                    	<a>Bem vindo, ${usuarioLogado.nome}</a>
	                    </li>
	                    <li>
	                    <a href="logout">Sair</a>
	                    </li>
	                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

<div style="text-align: center; color: #088A29; font-size: 20px; font-family: Comic Sans MS"> ${mensagem} </div>

<div class="container">
	<div class="row">
		
        
        <div class="col-md-12">
        <h4>Mensagens</h4>
        <div class="table-responsive">

                
              <table id="mytable" class="table table-bordred table-striped">
                   
                   <thead>
                   
                   <th>NOME</th>
                   <th>EMAIL</th>
                   <th>MENSAGEM</th>
                   <th>AÇÕES</th>
                     
                   </thead>
    <tbody>
    
    	<c:forEach var="c" items="${listaContato}">
		    <tr>
		    <td>${c.nome}</td>
		    <td>${c.nome}</td>
		    <td>${c.email}</td>
		    <td>${c.mensagem}</td>
		    <td><a href="removerContato?id=${c.id}">Remover</a></td>
		    </tr>
    
    </tbody>
        </c:forEach>
</table>
                
            </div>
            
        </div>
	</div>
</div>
    
    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row" align="center">
                <div class="col-lg-12"> 
                    <p>Copyright &copy; Eletrostec Comércio Eletrônico LTDA - 2016</p>
                </div>
            </div>
        </footer>

    </div>  


</body>
</html>