<!DOCTYPE html>
<html >
<head>
    <meta content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
</head>
<body>  
    <h1><span id=title></span><h1>
    <h2 align="center">欢迎来到本页面</h2>  
    <div align="center">
    <button id="index">进入主界面</button>
    <button id="addUI">进入添加页面</button>
    </div>
</body>
<script type="text/javascript">
  $(document).ready(function(){
	  $("#index").click(function(){
		  window.location.href = "/user/list";
		});
	  $("#addUI").click(function(){
		  window.location.href = "/user/addUI";
		});
	});
  </script>
</html>
