<html>
<head>
    <meta charset=utf-8/>
    <title>Login</title>
    <style>
        form {display: inline;}
    </style>

</head>
<body style="background-color:cornflowerblue;">
<h2>Login</h2>


<form id='loginForm' action='./AuthServletLogin' method='post'>
    <input type='text' placeholder='username' name='username'>
    <br><input type='password' placeholder='password' name='password'>
    <br><br><input type='submit' value='Log in'>
</form>

<form id='RegisterForm' action='./registerForm.jsp' method='post'>
    <br><input type='submit' value='Register'>
</form>

</body>
</html>
