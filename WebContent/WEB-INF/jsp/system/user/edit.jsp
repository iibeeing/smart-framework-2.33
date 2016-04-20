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
    <form id="user_edit_form" class="css-form">
        <input type="hidden" id="id" value="${user.id}"/>
        <div class="css-form-header">
            <h3>用户信息编辑</h3>
        </div>
        <div class="css-form-row">
            <label for="customer_name">用户名称:</label>
            <input type="text" id="customer_name" name="username" value="${user.username}" class="ext-required"/>
            <span class="css-color-red">*</span>
        </div>
        <div class="css-form-row">
            <label for="description">用户描述:</label>
            <textarea id="description"  rows="5">${user.username}</textarea>
        </div>
        <div class="css-form-footer">
            <button type="submit">保存</button>
            <button type="button" id="cancel">取消</button>
        </div>
    </form>
</div>

<div id="footer">
    <div id="copyright">Copyright @ 2016</div>
</div>

<script type="text/javascript" src="${BASE}/www/asset/lib/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${BASE}/www/asset/lib/jquery-form/jquery.form.min.js"></script>
<script type="text/javascript" src="${BASE}/www/asset/script/global.js"></script>
<%-- <script type="text/javascript" src="${BASE}/www/script/customer_edit.js"></script> --%>
<script type="text/javascript" src="${BASE}/www/script/system/user/edit.js"></script>

</body>
</html>