<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Crismar24
  Date: 24.03.2018
  Time: 2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--что будет вызвано в результате клика на кнопку--%>
    <spring:form modelAttribute="userFromServer" method="post" action="/web_app_test/users/check">
        <spring:input path="name"/>
        <spring:input path="password"/>
        <spring:button>check user</spring:button>

    </spring:form>
</body>
</html>
