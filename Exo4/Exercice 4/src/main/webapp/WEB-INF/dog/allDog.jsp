<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 30/07/2025
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="catList" type="java.util.ArrayList<com.example.exercice4.model.Dog>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Les Chiens</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous" defer></script>
</head>
<body>
<h1>Liste de Chats</h1>
<hr>

<c:if test="${dogList.size() > 0}">
    <table class="table table-dark text-center align-middle">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Race</th>
            <th>Date de naissance</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${dogListList}" >
            <tr>
                <td>${c.nom}</td>
                <td>${c.race}</td>
                <td>${c.dateDeNaissance}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${dogList.size() == 0}">
    <p>Aucun Chien a presenter</p>
</c:if>

</body>
</html>
