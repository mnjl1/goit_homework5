<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 05.11.2017
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добывить продукт.</title>
</head>
<body>
<h1>Новый продукт.</h1>

<form action="/add-product" method="post" accept-charset="UTF-8">
    <p>Наименование товара</p>
    <input type="text" name="productName">

    <p>Указать производителя.</p>

    <select name="list">
        <c:forEach items="${manufacturerList}" var="manufacturerName">
            <option value="${databaseValue}">
                    ${manufacturerName}
            </option>
        </c:forEach>
    </select>

    <input type="submit" value="Добавить.">

</form>


</body>
</html>
