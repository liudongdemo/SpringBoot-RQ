<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Hello World!</title>
</head>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<body>
	<center>
		<p>请添加服务站的人员</p>

		<p>
			<label>服务站成员姓名</label> <input type="text" id="userNa" name="userNa">
		</p>
		<label>服务站成员代码</label> <input type="text" id="core" name="core"><br/>
		<input type="button" id="btn" value="提交">
	</center>
</body>
<script type="text/javascript">
  $(document).ready(function(){
	  $("#btn").click(function(){
		  var userNa = $("#userNa").val();
		  var core = $("#core").val();
		  if(userNa=="")
			  return;
		  if(core=="")
			  return;
		  $.ajax({ 
		     type : "POST", //提交方式 
		     url : "/user/add",//路径 
		     data : { 
		      "userNa" : userNa,
		      "core" : core
		     },
		     success : function(result){//返回数据根据结果进行相应的处理 
		     if(result.type==0)
		    	 window.location.href = "/user/list";
		    	 alert(result.massage);
		     } 
		    });
		});
	});
  </script>

</html>