<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>考试列表</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/static/js/plugins/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=contextPath %>/static/js/plugins/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=contextPath %>/static/js/plugins/easyui/themes/color.css">
	<script type="text/javascript" src="<%=contextPath %>/static/js/plugins/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=contextPath %>/static/js/plugins/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=contextPath %>/static/js/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<div class="easyui-layout" data-options="fit:true"> 
    	<div id="north" title="搜索条件"  style="background-color: #E0ECFF;height:60px;"
	       data-options="region:'north',border:false"  width="90%">
	       <form id="searchForm" name="searchForm" action="<%=contextPath%>/exam/list_json2" method="post">
              <table >
		         <tr>
		            <th>类型：</th>
		            <td>
		            	<select name="type">
						    <option value="1">会计应试</option>
						    <option value="2">会计从业资格</option>
						    <option value="3">会计继续教育</option>
						    <option value="11">医学</option>
						    <option value="101">其他</option>
						</select>
		            </td>
		            <td><a href="javascript:search();" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a></td>
		         </tr>
		      </table>
           </form>
        </div>
        <div id="center" data-options="region:'center',border:false" width="90%">
        	<!-- <div id="buttons" class="toolbar-button">
	        	<a href="javascript:add();" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
	        </div> -->
           	<table id="examList" width="90%">
           	</table>
        </div>
    </div>
    <script type="text/javascript">
		$(function(){
			$("#examList").datagrid({
	        	title:'考试列表', 
				fit:true,
				fitColumns:false,
				toolbar:'#buttons',
				queryParams:getParams('searchForm'),
				pagination:false,
				pageNumber:1,
				pageSize:20,
			    loadMsg:'数据加载中....',
			    striped: true, 
			    singleSelect:true,
			    url:'<%=contextPath%>/exam/list_json2',
                columns:[[  
	                {field:'id',title:'ID',width:60},  
              		{field:'name',title:'名称',width:120},
              		{field:'description',title:'简介',width:80},
              		{field:'oper', title:'操作', width:120, formatter:function(value,row,index){
	                       var id = row.id; 
	                       var link = '<a class="editClass" href="javascript:mod(' + id + ');">编辑</a> ';
	                       link += '<a class="delClass" href="javascript:del(' + id + ');">删除</a> ';
	                       return link;
                    	}
                    }
            	]],
		        onLoadSuccess:function(){
		        	$(".editClass").linkbutton({iconCls:"icon-edit",plain:true});
		        	$(".delClass").linkbutton({iconCls:"icon-cancel",plain:true});
		        }
			});
		});
       
         
        function add(){
        	location.href = "<%=contextPath%>/exam/create";
        }
		
		function mod(id){
		   location.href = "<%=contextPath%>/exam/" + id+"/update";
		}
		
		function del(id){
		    var ajaxUrl = "<%=contextPath%>/exam/" + id+"/delete";
			ajaxR(ajaxUrl,null,"是否要删除该考试?");
		}  
		
		function ajaxR(ajaxUrl,data,info){
			$.messager.confirm('确认',info,function(r){  
			   	if (r){  
					$.ajax({
						type:"POST",
						url:ajaxUrl,
						data:data,
						dataType : "json",
						success : function(data) {
							if(data){
								$("#examList").datagrid("reload");
								$(".panel-tool-close").hide();
							}else{
								$.messager.alert('提示',"删除错误",'error');
							}
						},
						error : function(msg) {
							$.messager.alert("提示", msg, "error");
						}
					});
			   	}
			});
		}   
		
		function search(){  
			$('#examList').datagrid('options').queryParams = getParams('searchForm'); 
			$('#examList').datagrid('options').pageNumber = 1; 
			$('#examList').datagrid('getPager').pagination({pageNumber:1});
			$('#examList').datagrid('reload'); //设置好查询参数 reload 一下就可以了  
		}
		
		function getParams(formName){
			var params = new Array(); //先取得 datagrid 的查询参数  
		  	var fields = $('#'+formName).serializeArray(); //自动序列化表单元素为JSON对象  
		    $.each( fields, function(i, field){  
		        params[field.name] = field.value; //设置查询参数
		    });
		    return params;
		}
	</script>
</body>
</html>