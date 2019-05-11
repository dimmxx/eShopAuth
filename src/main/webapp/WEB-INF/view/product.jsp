<%@ page language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="inc/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Title</title>
    <style type="text/css">
        tab1 {
            padding-left: 1em;
        }
    </style>

</head>
<body style="background-color:cornflowerblue;">

<script src="https://code.jquery.com/jquery-3.4.0.js"
  integrity="sha256-DYZMCC8HTC+QDr5QNaIcfR7VSPtcISykd+6eSmBW5qo="
  crossorigin="anonymous"></script>

<script src="./JS/product.js"></script>

<h2>Product list</h2>

<c:forEach items="${products}" var="product" varStatus="count">
    <table border="1">
        <tr>
            <td width="110">Product code:</td>
            <td width="50">
                <div id="${product.id}code">${product.id}</div>
            </td>
            <td width="200"></td>
            <td width="500"><h3 id="${product.id}name">${product.productName}</h3></td>
            <td style="text-align: right" width="200">$${product.price}.00</td>
        </tr>
        <tr>
            <td width="110"></td>
            <td width="50"></td>
            <td width="200"><img src="./static/images/${product.image}" width="200"></td>
            <td width="500">${product.description}</td>
            <td></td>
        </tr>
        <tr>
            <td width="110"></td>
            <td width="50"></td>
            <td style="text-align: center" width="200">
                <form action="./CartServlet" method="post">
                    <input type="hidden" name="productId" value="${product.id}">
                    <input type="submit" value="Quick buy" style="height:30px; width:130px"/>
                </form>
            </td>
            <td style="text-align: right" width="500">
                <div><img src="./static/images/minus_btn.png" onclick="minus('${product.id}')" width="25px"
                          height="25px"/>
                    <span><tab1 id="${product.id}">0</tab1><tab1></tab1></span>
                    <img src="./static/images/plus_btn.png" onclick="plus('${product.id}')" width="25px" height="25px"/>
                </div>
            </td>
            <td style="text-align: center" width="200">
                <div><input onclick="buy(${product.id})" type="button" value="Add to the cart" style="height:30px; width:130px"/></div>
            </td>
        </tr>
    </table>
    <br><br>
</c:forEach>

</body>
</html>
<%@include file="inc/footer.jsp" %>