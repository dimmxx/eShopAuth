<%
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String age = request.getParameter("age");
    String comment = request.getParameter("comment");
%>
<html>
<head>
    <meta charset=utf-8/>
    <title>Register</title>
    <style>
        form {
            display: inline;
        }
    </style>
</head>
<body style="background-color:cornflowerblue">
<h2>Register</h2>

<form id='registerForm' action='./AuthServletRegister' method='post'>

    <input type='text' placeholder='username' name='username' value='<%=(username!=null?username:"")%>'/>

    <br><input type='text' placeholder='email' name='email' value='<%=(email!=null?email:"")%>'/>

    <br><input type='password' placeholder='password' name='password'/>

    <br><input type='password' placeholder='re-type password' name='repassword'/>

    <br><input type='text' placeholder='age' name='age' value='<%=(age!=null?age:"")%>'/>

    <br><br>

    <%String temp = (String) session.getAttribute("gender");%>
    <input type="radio" name="gender" value="m" <%=(temp != null && temp.equals("m")?"checked":"")%>> Male<br>
    <input type="radio" name="gender" value="f" <%=(temp != null && temp.equals("f")?"checked":"")%>> Female<br>
    <input type="radio" name="gender" value="o" <%=(temp != null && temp.equals("o")?"checked":"")%>> Other<br>

    <%temp = (String) session.getAttribute("address");%>
    <br>Address <select name='address'>
    <option value='1' <%=(temp != null && temp.equals("1") ? "selected" : "")%>>Kyiv, Ukraine</option>
    <option value='2' <%=(temp != null && temp.equals("2") ? "selected" : "")%>>Madrid, Spain</option>
    <option value='3' <%=(temp != null && temp.equals("3") ? "selected" : "")%>>Paris, France</option>
    <option value='4' <%=(temp != null && temp.equals("4") ? "selected" : "")%>>Rome, Italy</option>
</select>

    <br><br><textarea cols='50' rows='7' placeholder='comment'
                      name='comment'><%=(comment != null ? comment : "")%></textarea>
    <br><br><input type="checkbox" name="agree" value="1"> I agree with terms and conditions<br>
    <input type='hidden' value='0' name='agree'>

    <br><br><input type='submit' value='Register'/>
</form>
</body>