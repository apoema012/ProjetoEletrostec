<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilologin.css"/>
<title>LOGIN</title>

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
                
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

<div style="text-align: center; color: #088A29; font-size: 20px; font-family: Comic Sans MS"> ${msg} </div>

<div class="container">
	<div class="row">
        <div class="span12">
    		<div class="" id="loginModal">
              <div class="modal-body">
                <div class="well">
                  <ul class="nav nav-tabs">
                    <li class="active"><a href="#login" data-toggle="tab">Login</a></li>
                  </ul>
                  <div id="myTabContent" class="tab-content">
                    <div class="tab-pane active in" id="login">
                      <form class="form-horizontal" action='efetuarLogin' method="POST">
                        <fieldset>
                          <div id="legend">
                          </div>    
                          <div class="control-group">
                            <!-- Username -->
                            <label class="control-label"  for="username">Email</label>
                            <div class="controls">
                              <input type="text" id="username" name="email" class="input-xlarge">
                            </div>
                          </div>
     
                          <div class="control-group">
                            <!-- Password-->
                            <label class="control-label" for="password">Senha</label>
                            <div class="controls">
                              <input type="password" id="password" name="senha" class="input-xlarge">
                            </div>
                          </div>
     
     						<br>
     						
                          <div class="control-group">
                            <!-- Button -->
                            <div class="controls">
                              <button class="btn btn-success" type="submit">Login</button>
                            </div>
                          </div>
                        </fieldset>
                      </form>                
                    </div>
                </div>
              </div>
            </div>
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