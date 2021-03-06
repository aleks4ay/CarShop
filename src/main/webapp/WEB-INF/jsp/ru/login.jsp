<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="car-shop/res/css/logo.css">
    <style>
        .hello_1 {
            height: 1200px;
            background-image: url(car-shop/res/img/background_1.jpg);
            /*background-size: cover;*/
            background-size: 100%;
            background-position: center;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body class="hello_1">
<div class="center1">
    <form class="inner_logo" method="post">
        <div class="mb-3">
            <label for="login1" class="form-label">Login</label>
            <input type="text" class="form-control" id="login1" aria-describedby="emailHelp"  value="${user.login}">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1">
        </div>
        <button type="submit" class="btn btn-outline-success">Log in</button>
        <button type="button" class="btn btn-outline-danger" onclick="window.history.back()">Cancel</button>
    </form>
</div>
</body>
</html>