<%-- 
    Document   : index
    Created on : 09-Mar-2017, 19:07:48
    Author     : thomasdwidinata
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<c:url var = "addAction" value = "/user/add" ></c:url>
<c:url var = "removeAction" value = "/user/remove/" ></c:url>
<c:url var = "updateAction" value = "/user/update/" ></c:url>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring 4 Web MVC via Annotations</title>
        <link rel="stylesheet" type="text/css" href="${cp}/resources/css/style.css"} />
        <script src="${cp}/resources/js/common.js"></script>
    </head>
    <body>
        <h3>User List</h3>
        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">Username</th>
                <th width="120">Password</th>
                <th width="120">Role</th>
                <th width="60">Edit</th>
                <th width="60">Delete</th>
            </tr>
            <c:forEach items="${listUser}" var="user"><center>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td><a href="<c:url value='${updateAction}${user.id}' />">Edit</a></td>
                    <td><a href="${updateAction}${user.id}">Delete</a></td>
                </tr></center>
            </c:forEach>
        </table>
<!--        <h1>Spring 4 Web MVC via Annotations</h1>
        Sprint saya : dollar{msg} -->
    </body>
</html>
