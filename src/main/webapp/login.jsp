<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pllsym
  Date: 21 cze 2018
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing In</title>
    <link href="vendor/login.css" rel="stylesheet">
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
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->


    <!--Pulling Awesome Font -->
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

    <div class="container">
        <div class="row">
            <div class="col-md-offset-5 col-md-3">
                <form action="/login" method="post">
                    <div class="form-login">
                        <h4>Welcome back.</h4>
                            <input type="text" name="email" id="email" class="form-control input-sm chat-input" placeholder="email" />
                            </br>
                            <input type="text" name="userPassword" id="userPassword" class="form-control input-sm chat-input" placeholder="password" />
                            </br>
                            <label>
                                <input type="checkbox" name="remeberMe" id="remeberMe">
                                Zapamiętaj mnie
                            </label>
                        <div class="wrapper">
                            <span class="group-btn">
                                <button type="submit" class="btn btn-primary btn-md">login<i class="fa fa-sign-in"></i></button>
                                <%--<a href="#" class="btn btn-primary btn-md">login <i class="fa fa-sign-in"></i></a>--%>
                            </span>
                        </div>
                    </div>
                </form>
                <form action="/registration.jsp" method="get">
                    <div class="wrapper">
                            <span class="group-btn">
                                <button type="submit" class="btn btn-primary btn-md">rejestracja<i class="fa fa-sign-in"></i></button>
                                <%--<a href="#" class="btn btn-primary btn-md">login <i class="fa fa-sign-in"></i></a>--%>
                            </span>
                    </div>
                </form>

            </div>
        </div>
    </div>
</body>
</html>
