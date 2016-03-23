<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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

<div class="container">    
        
        <div id="signupbox" style="margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Categoria de Produtos</div>
                        </div>  
                        <div class="panel-body" >
                            <form id="signupform" class="form-horizontal" role="form" method="post" action="incluirCategoriaProduto">
                                
                                <div class="form-group">
                                    <label for="lastname" class="col-md-3 control-label">Descrição</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="descricao" required="required">
                                    </div>
                                </div>
                                    

                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" type="submit" class="btn btn-info"><i class="icon-hand-right"></i>Cadastrar</button>  
                                    </div>
                                </div>
                                
                             
                            </form>
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