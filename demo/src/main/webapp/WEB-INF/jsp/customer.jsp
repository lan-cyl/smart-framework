<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>客户管理 - 客户列表</title>
</head>

<script type="text/javascript">
    function customer_delete(id) {
            var xmlhttp;
            if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            } else {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function() {
                if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                    if(xmlhttp.responseText=="true") {
                        alert("删除成功！");
                        window.location.href = "${BASE}/customer";
                    }else alert("删除失败！");
                }
            }
            xmlhttp.open("GET","${BASE}/customer_delete?id=" + id,true);
            xmlhttp.send();
        }
</script>

<body>
    <h1>客户列表</h1>
    <p><a href="${BASE}/customer_create">添加</a></p>
    <table>
        <tr>
            <th>客户名称</th>
            <th>联系人</th>
            <th>电话号码</th>
            <th>邮箱地址</th>
            <th>操作</th>
        </tr>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.contact}</td>
                <td>${customer.telephone}</td>
                <td>${customer.email}</td>
                <td>
                    <a href="${BASE}/customer_edit?id=${customer.id}">编辑</a>
                    <a href="javascript:customer_delete(${customer.id});">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>

</html>