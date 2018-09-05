<!DOCTYPE html>
<html >
<head>
    <meta content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
</head>
<body>  
    <h2>服务站列表</h2>  
    <#list serviceStations as ss>
    	${ss}<br/>
    </#list>
    <h1><span id=title></span><h1>
    
    <button id="btn">生成二维码</button>
</body>
<script type="text/javascript">
  $(document).ready(function(){
	  $("#btn").click(function(){
		  $.ajax({ 
		     type : "POST", //提交方式 
		     url : "/user/createCore",//路径 
		     success : function(result){//返回数据根据结果进行相应的处理 
		    	 if(result.type==0){
			    	 alert(result.massage);
			    	 $("#title").text(result.info);
			     }else{
			    	 alert(result.massage);
			     }
		  		}
		    });
		});
	});
  </script>
</html>
