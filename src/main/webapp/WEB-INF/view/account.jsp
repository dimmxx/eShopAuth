<%@ page import="java.util.Date" %>
<%@ page language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Personal account</title>
    <style>
        form {
            display: inline;
        }

        h4 {
            color: white
        }
    </style>
</head>
<body style="background-color:cornflowerblue;">
<h2>Personal account</h2><br>
<h4>${user.messageSb}</h4>

<br>SessionName: <%=session.getAttribute("sessionName")%>
<br>SessionId: <%=session.getId()%>
<br>SessionUser: <%=session.getAttribute("user")%>
<br>SessionRole: <%=session.getAttribute("role")%>
<br>SessionCreationTime: <%=new Date(session.getCreationTime())%>
<br>SessionLastAccessedTime: <%=new Date(session.getLastAccessedTime())%>
<br>SessionMaxInactivityInterval: <%=session.getMaxInactiveInterval()%>
<br>SessionCart: <%=session.getAttribute("cart")%>
<br>
<br>Username: ${user.username}
<br>Password: ${user.password}
<br>Email: ${user.email}
<br>Role: ${user.role}

<br>Age: ${user.age}
<br>Address: ${user.address}
<br>Gender: ${user.gender}
<br>comment: ${user.comment}
<br>Agree: ${user.agree}
<br><br>
<hr>
<br>
<c:if test="${sessionScope.role != null}">
    <a href="./">Continue shopping</a>
    <a href="./LogoutServlet">LOG OUT</a>
</c:if>
<c:if test="${sessionScope.role == null}">

    <form id='loginForm' action='./loginForm.jsp' method='get'>
    <br><input type='submit' value='Log in'>
    </form>

    <form id='registerForm' action='./registerForm.jsp' method='post'>
        <input type="hidden" name="username" value="${user.username}">
    <input type="hidden" name="email" value="${user.email}">
    <input type="hidden" name="age" value="${user.age}">
    <input type="hidden" name="comment" value="${user.comment}">

        <input type='submit' value='Register'>
    </form>
</c:if>

</body>
</html>