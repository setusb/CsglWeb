<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: setusb
  Date: 2020/11/25
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="login.html">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="billList.jsp">账单管理</a></li>
                <li><a href="providerList.jsp">供应商管理</a></li>
                <li><a href="${pageContext.request.contextPath}/UserListServlet">用户管理</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <c:forEach var="list" items="${list}">
            <div class="providerAdd">
                <form action="${pageContext.request.contextPath}/UserUpdateServlet?uname=${list.name}&upassword=${list.password}&uemail=${list.email}&ulove=${list.love}" method="post">
                    <!--div的class 为error是验证错误，ok是验证成功-->
                    <div>
                        <label for="userName">用户名称：</label>
                        <input type="text" name="userName" id="userName" placeholder="${list.name}"/>
                        <span >*${unName}</span>
                    </div>

                    <div>
                        <label for="data">用户密码：</label>
                        <input type="text" name="password" id="data" placeholder="${list.password}"/>
                        <span >*</span>
                    </div>
                    <div>
                        <label for="userphone">邮箱：</label>
                        <input type="text" name="email" id="userphone" placeholder="${list.email}"/>
                        <span >*</span>
                    </div>
                    <div>
                        <label for="userAddress">爱好：</label>
                        <input type="text" name="love" id="userAddress" placeholder="${list.love}"/>
                    </div>
                    <div class="providerAddBtn">
                        <!--<a href="#">保存</a>-->
                        <!--<a href="userList.html">返回</a>-->
                        <input type="submit" value="保存"/>
                        <input type="button" value="返回" onclick="javascript:window.location.href='${pageContext.request.contextPath}/UserListServlet'"/>
                    </div>
                </form>
            </div>
        </c:forEach>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>
