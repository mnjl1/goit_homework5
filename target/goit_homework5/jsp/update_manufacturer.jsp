<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 05.11.2017
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Изменить производителя.</title>
</head>
<body>
<h1>ID производителя.</h1>

<form action="/update-manufacturer" method="post" accept-charset="UTF-8">
    <p>Введите текущий ID Производителя</p>
    <input type="text" name="manufacturerId">

    <p>Новое наименование Производителя:</p>
    <input type="text" name="manufacturerName">

    <input type="submit" value="Подтвердить">

</form>



</body>
</html>
