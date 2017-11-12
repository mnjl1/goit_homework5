<%@ page import="models.Manufacturer" %>
<%@ page import="java.util.List" %><%--
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


    <select name="list" style="width: 50mm">
        <option value="">Производитель</option>
        <%!
            private String manufacturerName;
            private Long manufacturerId;
        %><%
            List<Manufacturer> manufacturerList = (List<Manufacturer>) request.getAttribute("list");

            for(Manufacturer m: manufacturerList) {
                manufacturerName = m.getManufacturerName();
                manufacturerId = m.getId();
                %>
                <option value="<%=manufacturerId%>">"<%=manufacturerName%>"</option>
            <%}
        %>

    </select>


    <input type="submit" value="Добавить.">

</form>


</body>
</html>
