<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css" href="car-shop/res/css/style1.css">
    <link rel="stylesheet" type="text/css" href="car-shop/res/css/hello.css">
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
        <form class="inner_logo">
            <label><h2>Выберите язык/Choose language:</h2></label>
            <input type="button" value="Русский" onClick='location.href="ru"'>
            <input type="button" value="English" onClick='location.href="en"'>
        </form>
    </div>
</body>
</html>