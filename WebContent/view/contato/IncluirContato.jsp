<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Contato</title>
    
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
    
   <!-- Bootstrap Core CSS -->
<link href="view/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="view/css/shop-homepage.css" rel="stylesheet">
<link href="view/css/estiloContato.css" rel="stylesheet">

<link href="view/css/estilo.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<!-- jQuery -->
<script src="view/js/jquery.js"></script>
<script src="view/js/script.js"></script>

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
<div style="text-align: center; color: #088A29; font-size: 20px; font-family: Comic Sans MS"> ${mensagem} </div>

<div class="container" style="margin-left: 310px;">
    <div class="row">
        
        <form class="form-horizontal" id="frmcontatoazul" action="incluirContato" method="post">
        <fieldset>
        
        <!-- Form Name -->
        <legend>Deixe sua Mensagem</legend>
        
        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="txtinputnome">Nome</label>  
          <div class="col-md-8">
          <input id="txtinputnome" name="nome" placeholder="Escreva seu nome completo" class="form-control input-md" required="required" type="text" />
           
          </div>
        </div>
        
        <!-- Text input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="txtinputemail">Email</label>  
          <div class="col-md-8">
          <input id="txtinputemail" name="email" placeholder="Coloque um email válido" class="form-control input-md" required="required" type="email" />
           
          </div>
        </div>
        
        
        
        <!-- Textarea -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="txtinputarea">Mensagem</label>
          <div class="col-md-8">                     
            <textarea class="form-control" id="txtinputarea" rows="6" name="mensagem" placeholder="Escreva sua opinião, crítica ou sugestão para o site"></textarea>
          </div>
        </div>
        
        <!-- Button -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="btnenviar"></label>
          <div class="col-md-8">
            <button id="btnenviar" name="btnenviar" class="btn btn-primary btn-lg">Enviar</button>
          </div>
        </div>
        
        </fieldset>
        </form>
        
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
