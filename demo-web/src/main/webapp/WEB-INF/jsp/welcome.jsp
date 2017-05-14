<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html><html>
<body>
 <h1>欢迎 <shiro:principal /> 登录后台管理系统</h1> 
  <table>
    <tr>
      <td width="300px">获取session域数据</td>
       <td><%=session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY") %></td>
    </tr>
    <tr>
      <td>session创建时间</td>
      <td><%=session.getCreationTime()%></td>
    </tr>
    <tr>
      <td>session 最近访问时间</td>
      <td><%=session.getLastAccessedTime()%></td>
    </tr>
    <tr>
      <td>访问者ip</td>
      <td>${pageContext.request.remoteAddr }</td>
    </tr>
    <tr>
      <td>判断session 是否为新的</td>
      <td><%=session.isNew()%></td>
    </tr>
    <tr>
      <td>session 的ID</td>
      <td>${pageContext.session.id}</td>
    </tr>
    <tr>
      <td>主机端的服务信息</td>
      <td>${pageContext.servletContext.serverInfo}</td>
    </tr>
    <tr>
      <td></td>
      <td></td>
    </tr>
  </table>
</body>
</html>