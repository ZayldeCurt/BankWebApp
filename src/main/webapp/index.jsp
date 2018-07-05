<html>
<body>
<style>
    body {
        background-image: url("myBackground.jpg");
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<h2>Hello!!!</h2>
<a href="login.jsp">Strona logowania</a><br>
<%--<a href="account.jsp">Strona konta</a>--%>

<form action="/account" method="post">
    <div class="wrapper">
        <span class="group-btn">
            <button type="submit" class="btn btn-primary btn-md">Strona konta<i class="fa fa-sign-in"></i></button>
        </span>
    </div>
</form>

</body>
</html>
