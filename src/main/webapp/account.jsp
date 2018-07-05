<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="domain.User" %>
<%@ page import="domain.BankAccount" %>
<%@ page import="repository.BankAccountRepository" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@page session="false" %>
<%@ page import="java.util.Date" %><%--

  Created by IntelliJ IDEA.
  User: pllsym
  Date: 21 cze 2018
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

%>
<html>
<head>
    <title>Account page</title>
    <style>
        body {
            background-image: url("myBackground.jpg");
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
</head>
<body>
<%--@elvariable id="user" type="domain.User"--%>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="btn-toolbar">
    <form action="/logout" method="get">
        <button class="btn btn-primary" type="submit">Log out</button>
    </form>
</div>
    <%--<div> czas aktualnu ${sdf.format(actualDate)}</div>--%>
    <%--<div> czas startu ${sdf.format(myCreationDate)}</div>   --%>
    <div> czas aktualnu  <fmt:formatDate value="${actualDate}" pattern="yyyy-MM-dd-HH-mm-ss"></fmt:formatDate></div>
    <div>czas startu <fmt:formatDate value="${myCreationDate}" pattern="yyyy-MM-dd-HH-mm-ss"></fmt:formatDate></div>
<div class="well">
    <table class="table">
        <thead>
        <tr>
            <th>email</th>
            <th>firsname</th>
            <th>lastname</th>
            <th>account number</th>
            <th>currency</th>
            <th>balance</th>
            <th>free funds</th>
            <th style="width: 36px;"></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th>${user.email}</th>
            <th>${user.firstName}</th>
            <th>${user.lastName}</th>
            <th>${bankAccount.accountNumber}</th>
            <th>${bankAccount.currency}</th>
            <th>${bankAccount.balance}</th>
            <th>${bankAccount.freeFunds}</th>
        </tr>
        </tbody>
    </table>
</div>
<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Delete Confirmation</h3>
    </div>
    <div class="modal-body">
        <p class="error-text">Are you sure you want to delete the user?</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button class="btn btn-danger" data-dismiss="modal">Delete</button>
    </div>
</div>

<a href="login.jsp">Strona logowania</a>
</body>
</html>
