<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/19 0019
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>test</title>
</head>
<script>
    function selectUser() {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("test").innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("POST", "/FMC/user/showUser.do", true);

        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send("id=1");
    }

    function bulid() {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("test").innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("POST", "/FMC/autoCode/bulid.do", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send("tableName="+document.getElementById("tableName").value+"&"+"moduleName="+document.getElementById("moduleName").value+"&"+"className="+document.getElementById("className").value);

    }
</script>
<body>
<p id="test">test</p>
数据库表名：
<input id="tableName" type="text"/><br/>
包名：
<input id="moduleName" type="text"/><br/>
生成的类名：
<input id="className" type="text"/><br/>
<button type="button" onclick="selectUser()">onclick test</button>
<button type="button" onclick="bulid()">onclick bulid</button>
</body>
</html>
