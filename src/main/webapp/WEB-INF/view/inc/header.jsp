<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>eShop</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .topnav {
            overflow: hidden;
            background-color: #333;
        }

        .topnav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: cornflowerblue;
            color: black;
        }

        .topnav a.active {
            background-color: cornflowerblue;
            color: white;
        }
    </style>
</head>

<body style="background-color:cornflowerblue;">

<div class="topnav">
    <a href="./">MAIN</a>
    <a href="./ProductServlet?category=all">PRODUCTS</a>
    <a href="loginForm.jsp">LOG IN</a>
    <a href="./LogoutServlet">LOG OUT</a>
    <a href="./CartServlet">CART
        (${not empty sessionScope.cart.mapProductQuantity ? sessionScope.cart.mapProductQuantity : " 0 "})</a>

</div>

<table align="right" border=0>
    <tr>
        <td width="300" align="left">
            <font color=black>

               You are ${not empty sessionScope.user ? ('logged in as <a href="./ShowAccountServlet">' += sessionScope.user.username += '</a>') : " not logged in</a>"}<br>
               You have ${not empty sessionScope.cart.mapProductQuantity ? sessionScope.cart.mapProductQuantity : " 0 "} items in your <a href="./CartServlet">cart</a>

            </font>
        </td>
    </tr>
</table>

<h1><br></h1>



