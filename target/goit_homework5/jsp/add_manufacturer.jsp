<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 02.11.2017
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добавить Производителя.</title>
</head>
<body>
<h1>Новый Производитель.</h1>

<form action="/add-manufacturer" method="post" accept-charset="UTF-8">
    <p>Наименование Производитель?/p>
    <input type="text" name="manufacturerName">

    <input type="submit" value="Добавить производителя.">

</form>

</body>
</html>
