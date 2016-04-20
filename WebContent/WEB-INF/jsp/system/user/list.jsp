<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <title>Smart Smaple - Customer</title>
    <link rel="stylesheet" href="${BASE}/www/asset/style/global.css"/>
</head>
<body>

<div id="header">
    <div id="logo">Smart Sample</div>
    <div id="oper">
        <button type="button" id="logout">Logout</button>
    </div>
</div>

<div id="content">
    <div id="main">
        <div class="css-panel">
            <div class="css-panel-header">
                <div class="css-left">
                    <h3>用户列表</h3>
                </div>
                <div class="css-right">
                    <a href="${BASE}/user/create">新增用户</a>
                </div>
            </div>
            <div class="css-panel-content">
                <table id="customer_table" class="css-table">
                    <thead>
                        <tr>
                            <td>|用户姓名|</td>
                            <td>|描述|</td>
                            <td class="css-width-75">|操作|</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${userList}">
                            <tr data-id="${user.id}" data-name="${user.username}">
                                <td>
                                    <a href="${BASE}/user/${user.id}">${user.username}</a>
                                </td>
                                <td>
                                    <%-- ${user.description} --%>
                                    我是${user.username}
                                </td>
                                <td>
                                    <a href="${BASE}/user/${user.id}">Edit</a>
                                    <a href="#" class="ext-user-delete">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<div id="footer">
    <div id="copyright">Copyright @ 2016</div>
</div>

<script type="text/javascript" src="${BASE}/www/asset/lib/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${BASE}/www/asset/lib/jquery-form/jquery.form.min.js"></script>
<script type="text/javascript" src="${BASE}/www/asset/script/global.js"></script>
<%-- <script type="text/javascript" src="${BASE}/www/script/customer.js"></script> --%>
<script type="text/javascript" src="${BASE}/www/script/system/user/list.js"></script>

</body>
</html>