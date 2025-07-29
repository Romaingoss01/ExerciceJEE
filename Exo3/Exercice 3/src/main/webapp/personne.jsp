<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 29/07/2025
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bienvenue chez les personnes</title>
</head>
<body>

<ul>
    <c:forEach var="p" items="${nom}">

        <li> - ${prenom} ${nom} ${age}</li>
    </c:forEach>
</ul>




</body>
</html>
