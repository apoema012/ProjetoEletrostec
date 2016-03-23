<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>ELETROSTEC</title>

<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">


<!-- Bootstrap Core CSS -->
<link href="view/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="view/css/shop-homepage.css" rel="stylesheet">

<!-- jQuery -->
<script src="view/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="view/js/bootstrap.min.js"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="principal">ELETROSTEC</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="QuemSomos.jsp">QUEM SOMOS</a></li>
				<li><a href="dicas.jsp">DICAS</a></li>
				<li><a href="exibirContato">CONTATO</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-md-3">
				<p class="lead">CATEGORIAS</p>
				<div class="list-group">
					<c:forEach var="c" items="${listaCategoriaProduto}">
						<a href="visualizarProdutoCategoria?id=${c.id}" class="list-group-item">${c.descricao}</a>
					</c:forEach>
				</div>
			</div>

			<div class="col-md-9">

				<div class="row carousel-holder">

					<div class="col-md-12">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img class="slide-image" src="view/img/slide1.jpg"
										style="height: 270px;">
								</div>
								<div class="item">
									<img class="slide-image" src="view/img/slidenot.png"
										style="height: 270px;">
								</div>
								<div class="item">
									<img class="slide-image" src="view/img/slidehd.jpg"
										style="height: 270px;">
								</div>
							</div>
							<a class="left carousel-control" href="#carousel-example-generic"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control"
								href="#carousel-example-generic" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>

				</div>

				<div class="row">
					<c:forEach var="p" items="${listaProduto}">
						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img src="view/img/${p.imagem}" style="width: 189px;">
								<div class="caption">
									<h4 class="pull-right">R$ ${p.preco}</h4><br>
									<h4>
										<a href="visualizarProduto?id=${p.id}">${p.nome}</a>
									</h4>
									<p>${p.descricao}</p>
								</div>
								<div class="ratings">
									<p class="pull-right">20 reviews</p>
									<p>
										<span class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>




				</div>

			</div>

		</div>

	</div>
	<!-- /.container -->

	<footer class="section section-primary">
      <div class="container">
        <div class="row">
          <div class="col-sm-6">
            <h3>&nbsp; &nbsp;Redes Sociais</h3>
           
            <div class="col-md-12 hidden-xs text-left">
              <a href="#"><i class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a>
              <a href="#"><i class="fa fa-3x fa-fw fa-twitter text-inverse"></i></a>
              <a href="#"><i class="fa fa-3x fa-fw fa-facebook text-inverse"></i></a>
              
            </div>
          </div>
        </div>
      </div>
      <hr>
      <p align="center" style="font-size: 14px;">Copyright © 2016 Eletrostec Comércio Eletrônico LTDA</p>
    </footer>

</body>
</html>