<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
 <meta charset="ISO-8859-1">
<title>ELETROSTEC - Produtos</title>

<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>

 <!-- Bootstrap Core CSS -->
    <link href="view/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="view/css/bootstrap-override.css" rel="stylesheet">
      <link href="view/css/shop-homepage.css" rel="stylesheet">
    
    <!-- jQuery -->
    <script src="view/css/netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"></script>
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
                <a class="navbar-brand" href="principal">ELETROSTEC</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="QuemSomos.jsp">QUEM SOMOS</a>
                    </li>
                    <li>
                        <a href="dicas.jsp">DICAS</a>
                    </li>
                    <li>
                    	<a href="exibirContato">CONTATO</a>
                    </li>
                </ul>
            </div></div></nav> <br><br>

	<div class="container-fluid">
    <div class="content-wrapper">	
		<div class="item-container">	
			<div class="container">	
				<div class="col-md-12" >
					<div class="product col-md-3 service-image-left" >
							<center>
								<img id="item-display" src="view/img/${produto.imagem}" style="width: 250px;"></img>
							</center>
					</div>
				
					<div class="col-md-7">
						<div class="product-title">${produto.nome}</a> <br>
						<div class="product-desc">${produto.descricao}</div>
						
						<hr>
						<div class="product-price">R$ ${produto.preco}</div>
					
						<div class="product-stock"></div>
						<hr>
						<h3>Ligue agora mesmo e reseve o seu!</h3>
													
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid">		
			<div class="col-md-12 product-info">
			<hr>
					<ul id="myTab" class="nav nav-tabs nav_tabs">
						
						<li class="active"><a href="#service-one" data-toggle="tab">Especificação do Produto</a></li>
						
					</ul>
				<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade in active" id="service-one">
						 
							<section class="container product-info">
							
							${produto.especificacao}
								
							</section>
										  
						</div>
					</div>
				</div>
			</div>


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