<%@ page language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="inc/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Cart</title>
</head>
<body style="background-color:cornflowerblue;">

<script src="https://code.jquery.com/jquery-3.4.0.js"
        integrity="sha256-DYZMCC8HTC+QDr5QNaIcfR7VSPtcISykd+6eSmBW5qo="
        crossorigin="anonymous"></script>

<script src="./JS/cart.js"></script>


<table border="1">
    <tr>
            <td>Delete</td>
            <td>No</td>
            <td>Product id</td>
            <td>Product image</td>
            <td>Product</td>
            <td>Price</td>
            <td></td>
            <td>Sum</td>
            <td>Change</td>
        </tr>

<c:forEach var="mapEntry" items="${cart.productMap}" varStatus="count">
        <tr>
            <td style="text-align: center"><img src="./static/images/delete.png" onclick="deleteItem('${mapEntry.key.id}')" width="20"></td>
            <td style="text-align: center">${count.count}.</td>
            <td id="${mapEntry.key.id}" style="text-align: center">${mapEntry.key.id}</td>
            <td style="text-align: center"><img src="./static/images/${mapEntry.key.image}" width="30"></td>
            <td>${mapEntry.key.productName}</td>
            <td style="text-align: center">${mapEntry.key.price}$</td>
            <td style="text-align: center">
                <img src="./static/images/minus_btn.png" onclick="minus('${mapEntry.key.id}')" width="25px" height="25px"/>
                <input type="text" id="${mapEntry.key.id}value" value="${mapEntry.value}" size="4"/>
                <img src="./static/images/plus_btn.png" onclick="plus('${mapEntry.key.id}')" width="25px" height="25px"/>
            </td>
            <td style="text-align: center">${mapEntry.key.price * mapEntry.value}</td>
            <td style="text-align: center"><input onclick="changeQuantity('${mapEntry.key.id}')" type="button" value="Edit"/></td>
        </tr>

</c:forEach>
</table>

<br>


<table border="0">
    <tr>
        <td width="200">Product quantity: ${cart.mapProductQuantity}</td>
        <td width="500">Total amount: ${cart.mapTotalAmount}$</td>
        <td width="200">
            <form id='checkout' action='./CheckoutServlet' method='post'>
            <input type="submit" value="Checkout"/>
            </form>
        </td>
    </tr>
    </table><br><br>

</body>
</html>


<%@include file="inc/footer.jsp" %>
