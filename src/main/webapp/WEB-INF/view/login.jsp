<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login_Menu</title>
</head>
<body>
<div class="form">

    <h1>Вход в систему</h1><br>
    <form action="/start" method="post">

        <label>Name:
            <input type="text" name="name"><br/>
        </label>
        <label>Password:
            <input type="password" name="pass"><br/>
        </label>
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>
