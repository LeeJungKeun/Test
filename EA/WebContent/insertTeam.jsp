<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>MnL 반응형 웹</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div id="login-page">
    <div class="container">

        <form class="form-login" action="FrontControl/insertTeam"  method="post">
            <h2 class="form-login-heading">팀 만들기</h2>
            <div class="login-wrap">

                <input type="text" class="form-control" placeholder="팀이름" id="teamName" name="teamName" autofocus >
                <br>
                <input type="text" class="form-control" placeholder="팀 주소" id="teamAddr" name="teamAddr">
                <br>
                <input type="text" class="form-control" placeholder="팀구성수 (슷자로)" id="playerNo" name="playerNo">
                <br>
  
                <label class="checkbox">
		                <span class="pull-right">
		                </span>
                </label>
                <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> Make A Team</button>
                <hr>

                <div class="login-social-link centered">

                </div>
            	

            </div>


        </form>



    </div>
</div>

<!-- js placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!--BACKSTRETCH-->
<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
<script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
<script>
    //$.backstretch("assets/img/south-korea-05.jpg", {speed: 500});
    $('.backstretch').css('opacity', '0.7');

</script>


</html>
<script type="text/javascript">

