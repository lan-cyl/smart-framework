<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>客户管理 - 创建客户</title>
</head>

<script type="text/javascript">
    function createSubmit() {
        var xmlhttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        } else {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function() {
            if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                if(xmlhttp.responseText=="true") {
                    alert("添加成功！");
                    window.location.href = "${BASE}/customer";
                }else alert("添加失败！");
            }
        }
        xmlhttp.open("POST","${BASE}/customer_createSubmit",true);
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        var name = document.getElementsByName("name")[0].value;
        var contact = document.getElementsByName("contact")[0].value;
        var telephone = document.getElementsByName("telephone")[0].value;
        var email = document.getElementsByName("email")[0].value;
        xmlhttp.send("name="+name+"&contact="+contact+"&telephone="+telephone+"&email="+email);
    }
</script>

<body>
    <h1>创建客户界面</h1>

    <form>
        姓名：<input type="text" name="name" value="Nixon">
        <br>
        联系人：<input type="text" name="contact">
        <br>
        电话：<input type="text" name="telephone">
        <br>
        邮箱：<input type="text" name="email">
        <br>
        <input type="button" value="提交"onclick="createSubmit();" />
        <input type="reset">
    </form>

</body>
</html>