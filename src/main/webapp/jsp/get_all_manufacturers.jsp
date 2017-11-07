<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 06.11.2017
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Показать всех производителей.</title>
</head>
<body>
<form action=/get-all-manufacturers method="post" accept-charset="UTF-8">
    <p>Наименование Производитель?/p>
        <input type="text" name="manufacturer_name">

        <input type="submit" value="Добавить производителя.">

</form>
</body>
</html>
