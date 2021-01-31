<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<html lang="ru">
<head>
  <title>Car shop</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="/res/css/style1.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <style>
  .fakeimg {
    height: 200px;
    background-image: url(car-shop/res/img/fakeimage.jpg);
    background-size: 50%;
    background-position: right;
    background-repeat: no-repeat;
  }
  </style>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="home">CAR SHOP</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Магазин</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Корзина</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="newuser">Регистрация</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="login">Вход</a>
      </li>    
    </ul>
  </div>  
</nav>

<div class="jumbotron header_container" style="margin-bottom:0">
    <h1 style="text-align: left; float: left; font-size: 50px; color: rgb(55,91,115);"><b>&nbsp;CAR SHOP.</b> Все автомобили Украины</h1>
</div>



<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-4">
      <h2>Location = ${language}</h2>
      <h5>Photo of me:</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
      <h3>Some Links</h3>
      <p>Lorem ipsum dolor sit ame.</p>
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="#">Легковые</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Внедорожники и кроссоверы</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Пикапы</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Минивены</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>

    <div class="col-sm-8">
      <div class="btn-group" style="width: 100%">
        <button type="button" class="btn btn-primary btn-my-r"><h5>Легковые</h5></button>
        <button type="button" class="btn btn-primary btn-my-r"><h5>Внедорожники и кроссоверы</h5></button>
        <button type="button" class="btn btn-primary btn-my-r"><h5>Пикапы</h5></button>
        <button type="button" class="btn btn-primary btn-my-r"><h5>Минивены</h5></button>
      </div>
      <h2>Выберите бренд</h2>
      <h5>Title description, Dec 7, 2017</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
      <br>
      <h2>TITLE HEADING</h2>
      <h5>Title description, Sep 2, 2017</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    </div>
  </div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
  <p>Footer</p>
</div>

</body>
</html>