<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jquery/jquery.min.js"></script>
	<script type="text/javascript" src="jquery/bootstrap.min.js"></script>
	<script type="text/javascript" src="jquery/jquery-1.8.3.min.js"></script>
  	<link rel="stylesheet" href="css/style1.css" type="text/css"></link>
  	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"></link>
  	</head>
  <style>
  	th{
  		text-align:center;
  	}
  </style>
  <script type="text/javascript">
	//清空input 数据
	function clearForm(form) {
  	// 迭代input清空
	  	$(':input', form).each(function() {
	    var type = this.type;
	    var tag = this.tagName.toLowerCase(); // normalize case
	    if (type == 'text' || type == 'password' || tag == 'textarea')
	      this.value = "";
	    // 跌代多选checkboxes
	      else if (type == 'checkbox' || type == 'radio')
	      this.checked = false;
	    // select 迭代下拉框
	      else if (tag == 'select')
	      this.selectedIndex ="";
	  });
	}
	
  </script>
  <body>
<!-- right -->
<div id="xt-right">
    <div class="xt-input">
        	<input type="button" value="汽车添加" class="green-int"  data-toggle="modal" data-target="#myModal" onclick="clearForm(clearform)"/>
    </div>
    <div class="xt-table">
        <table cellpadding="0" cellspacing="0" border="0" bgcolor="#dcdcdc" width="100%">
            <tr>
	            <th>汽车编号</th>
	            <th>汽车类型</th>
	            <th>汽车库存</th>
	            <th>汽车价格(元)<th>
	            <th>描述</th>
            </tr>
            <c:forEach items="${classList}" var="obj" >
            	<tr class="xt-bg">
	               <td>${obj.classname}</td>
	               <td>${obj.gradename}</td>
	               <td>${obj.classsize}</td>
	               <td>${obj.remark}</td>
           		</tr>
            </c:forEach>
        </table>
    </div>
    <div class="xt-fenye" >
 		<center>${pageStr}</center>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content modal-lg">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					新增汽车
				</h4>
			</div>
			<form class="form-horizontal" role="form" action="<%=path %>/school/addClass" method="post"  id="clearform" onsubmit="return checkForm()">
			<div class="modal-footer" style="text-align:left">
				<div class="form-group">
					 <label  class="col-sm-2 control-label"><label style="color:red">*</label>汽车名称:</label>
					 <div class="col-sm-8">
					      <input type="text" class="form-control"  placeholder="请输入汽车名称" name="className" required="required" onblur="checkClass()" id="className">
					      <span style="color:red" id="rnMsg"></span>
					 </div>
					 <div class="col-sm-2"></div>
				</div>
				<div class="form-group">
					 <label  class="col-sm-2 control-label">汽车类型:</label>
					 <div class="col-sm-8">
					      <select class="form-control" name="gradeId" required="required">
					     	 <option value="">请选择</option>
					      <c:forEach items="${gradeList}" var="obj">
					      		<option value="${obj.gradeId}">${obj.gradeName}</option>
					      </c:forEach>
					      </select>
					 </div>
					 <div class="col-sm-2"></div>
				</div>
					<div class="form-group">
					 <label  class="col-sm-2 control-label"><label style="color:red">*</label>汽车价格:</label>
					 <div class="col-sm-8">
					      <input type="text" class="form-control"  placeholder="请输入汽车价格" name="classSize" required="required">
					      <span style="color:red" id="rnMsg"></span>
					 </div>
					 <div class="col-sm-2"></div>
				</div>
					<div class="form-group">
					 <label  class="col-sm-2 control-label"><label style="color:red">*</label>描述:</label>
					 <div class="col-sm-8">
					      <input type="text" class="form-control"  placeholder="请输入汽车描述" name="remark" required="required" >
					      <span style="color:red" id="rnMsg"></span>
					 </div>
					 <div class="col-sm-2"></div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<input type="submit" value="提交" class="btn btn-primary"/>
			</div>
			</form>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
  </body>
  <script type="text/javascript">
  	
  	function checkForm(){
  		var rnMsg = $("#rnMsg").html();
  		if(rnMsg!=""){
  			return false;
  		}
  	}
  </script>
</html>
