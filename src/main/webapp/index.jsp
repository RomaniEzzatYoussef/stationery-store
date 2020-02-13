<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Romani Ezzat
  Date: 2/11/2020
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hibernate Test</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div>
    <a href="${contextPath}/api/users">Get All Users</a>
</div>

</body>
</html>
