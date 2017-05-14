<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/plugins/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/plugins/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/tabs.js"></script>
<script type="text/javascript">
	$(function() {
		$("#menus a").click(function() {
			var title = $(this).text();
			var url = $(this).attr("ref");
			var icon = $(this).attr("icon");
			OpenTab(title, url, icon);
			return false; //使超链接的单击事件失效
		});
	});
</script>
</head>
<body>
  <!-- 方式1 -->
  <div class="easyui-layout" fit="true">
    <!-- 左侧菜单-->
    <div region="west" title="菜单" split="true" style="width:200px" id="menus">
      <c:forEach items="${menus}" var="m">
        <a href="javascript:;" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true" ref="${pageContext.request.contextPath}${m.url}"
          title="${m.name}" icon="">${m.name}</a>
        <br />
      </c:forEach>
    </div>
    <div region="center">
      <div id="tabs" class="easyui-tabs" fit="true" border="false">
        <div title="主页" style="padding: 0px;overflow:hidden;" href='${pageContext.request.contextPath}/welcome'></div>
      </div>
    </div>
  </div>
  <%-- 
<!-- 方式 2 -->
  <div id="main-layout" class="easyui-layout" data-options="fit:true" style="padding:0px;">
    <div region="west" title="菜单" split="true" style="width:200px" id="menus">
      <c:forEach items="${menus}" var="m">
        <a href="${pageContext.request.contextPath}/${m.url}" target="content-iframe">${m.name}</a>
        <br />
      </c:forEach>
    </div>
    <div region="center" title="工作窗口" style="padding:0px">
      <iframe name="content-iframe" src="" frameborder="0" scrolling="no" style="height: 90%;width: 100%"></iframe>
    </div>
  </div>
 --%>
  <!--  -->
  <div id="menu" class="easyui-menu" style="width:150px;">
    <div id="m-refresh">刷新</div>
    <div class="menu-sep"></div>
    <div id="m-closeall">全部关闭</div>
    <div id="m-closeother">除此之外全部关闭</div>
    <div class="menu-sep"></div>
    <div id="m-close">关闭</div>
  </div>
</body>
</html>