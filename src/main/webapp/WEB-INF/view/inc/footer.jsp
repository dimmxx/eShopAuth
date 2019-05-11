<%@ page language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<div id="sidebar">
  
<h3>
<ul>
<li><a href="./ProductServlet?category=1">Категория 1 - Мобильные телефоны</a></li>
<li><a href="./ProductServlet?category=2">Категория 2 - Фотоаппаратура</a></li>
<li><a href="./ProductServlet?category=3">Категория 3 - Компьютерная техника</a></li>
<li><a href="./ProductServlet?category=all">Все категории товаров</a></li>

<li><a href="registration.php">Регистрация</a></li>
<li><a href="login.php">Вход</a></li>
<li><a href="./CartServlet">Корзина (${not empty sessionScope.cart.mapProductQuantity ? sessionScope.cart.mapProductQuantity : "0"})</a></li>
</ul>
</h3>
</div>

<div id="footer">
<p>Copyright (c) by Mate Academy</p>
</div>
<!-- end #footer -->
</body>
</html>
