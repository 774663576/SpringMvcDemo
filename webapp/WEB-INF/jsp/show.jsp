<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>show</title>
<script type="text/javascript" src="../javascripts/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function show() {
		$.ajax({
			type:"post",
	  		url:"../member/showById.php",
	  		cache:false,
	  		data:{"id":1},
	  		dataType:"json",
	  		success:function(data){
	  		    $("#show").html(data.loginName);
		  	},
		  	error:function(data){
		  		alert("faild");
		  	}
		});
	}
	function del(param1,param2){
		if(param2==1){
			alert("本账号不可删除。。。(=^ ^=)");
			return;
		}
		$.ajax({
			type:"post",
			url:"../member/delById.php",
			cache:false,
	  		data:{"id":param2},
	  		dataType:"json",
	  		success:function(data){
	  		    //if(data==true) $(param1).parent().parent().remove();
		  		$.ajax({
		  			type:"post",
		  	  		url:"../member/showAll.php",
		  	  		cache:false,
		  	  		data: {},
		  	  		dataType:"json",
		  	  		success:function(data){
		  	  			var title = '<table><tr><td>序号</td><td>主键</td><td>登录名</td><td>密码</td><td>昵称</td><td>等级</td><td>操作</td></tr>';
		  	  			var context = '';
		  	  			$.each(data,function(i,item){
		  	  				if(i%2!=0){
		  	  					context += '<tr style="background-color: #E5DBE2;"><td>'+i+'</td><td>'+item.id+'</td><td>'+item.loginName+'</td><td>'+item.loginPwd+'</td><td>'+item.nickName+'</td><td>'+item.roleRank+'</td><td><a href="javascript:void(0);" onclick="del(this,'+item.id+')" class="del">删除</a></td></tr>';
		  	  				}else{
		  	  					context += '<tr><td>'+i+'</td><td>'+item.id+'</td><td>'+item.loginName+'</td><td>'+item.loginPwd+'</td><td>'+item.nickName+'</td><td>'+item.roleRank+'</td><td><a href="javascript:void(0);" onclick="del(this,'+item.id+')" class="del">删除</a></td></tr>';
		  	  				}
		  	  			});
		  	  			var display = title+context+'</table>';
		  	  			
		  	  		    $("#display").html(display);
		  		  	},
		  		  	error:function(data){
		  		  		alert("faild");
		  		  	}
		  		});
		  	},
		  	error:function(data){
		  		alert("faild");
		  	}
		});
		
	}
</script>
<style type="text/css">
	a {
		text-decoration: none;
	}
	table {
		border: 1px;
		border-style: solid;
		border-color: green;
		
		font-family: "微软雅黑";
		text-align: center;
		
		margin: 0px;
		padding: 0px;
		border-collapse: collapse;
		padding: 0px;
	}
	tr:first-child {
		background-color: #AEC7E1;
	}
	tr {
		cursor: default;
	}
	td {
		width: 100px;
		
		border: 1px;
		border-style: solid;
		border-color: green;
	}
	
</style>
</head>
<body>
	<h3>It's a test page.</h3>
	<div id="display">
		<table>
			<tr><td>序号</td><td>主键</td><td>登录名</td><td>密码</td><td>昵称</td><td>等级</td><td>操作</td></tr>
			<c:forEach var="member" items="${memberList }" varStatus="status">
			<tr <c:if test="${status.index%2!=0 }"> style="background-color: #E5DBE2;"</c:if>>
				<td><c:out value="${status.index+1 }" /></td>
				<td><c:out value="${member.id }" /></td>
				<td><c:out value="${member.loginName }" /></td>
				<td><c:out value="${member.loginPwd }" /></td>
				<td><c:out value="${member.nickName }" /></td>
				<td><c:out value="${member.roleRank }" /></td>
				<td><a href="javascript:void(0);" onclick='del(this,<c:out value="${member.id }" />);' class="del">删除</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<a href="javascript:void(0);" onclick="show();">show</a>
	<div id="show"></div>
</body>
</html>