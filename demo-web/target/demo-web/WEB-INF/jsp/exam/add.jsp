<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>考试编辑</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/static/js/plugins/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=contextPath %>/static/js/plugins/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=contextPath %>/static/js/plugins/easyui/themes/color.css">
	<script type="text/javascript" src="<%=contextPath %>/static/js/plugins/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=contextPath %>/static/js/plugins/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=contextPath %>/static/js/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<div class="easyui-layout" data-options="fit:true" >
		<div id="center" data-options="region:'center',border:false"
			style="padding:5px;">
			<div id="planPanel" title="考试编辑" class="easyui-panel"
				data-options="border:true" style="padding:5px;">
				
				<form id="addForm" name="addForm" method="post"
					action="<%=contextPath%>/exam/create">
					<table class="promodify" cellspacing="1">
					    <tr>
							<td class="info">名称：</td>
							<td><input type="text" id="name" name="name" class="easyui-textbox" data-options="required:true"/>
								<span class="notice"></span>
							</td>
						</tr>
					</table>
					<div align="center">
						<a id="submitBtn" onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">添加</a> 
						<a id="goback" onclick="goback();" class="easyui-linkbutton" data-options="iconCls:'icon-back',plain:true">返回</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
		function add(){
			$('#addForm').submit();
		}
		
		function goback(){
			window.location.href='<%=contextPath%>/exam/list';
		}	
		
	</script>

</body>
</html>
