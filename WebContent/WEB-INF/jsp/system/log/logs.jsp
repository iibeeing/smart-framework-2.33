<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <title>Smart Smaple - 日志</title>
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
                    <h3>日志列表</h3>
                </div>
            </div>
            <div class="css-panel-content">
                <table id="customer_table" class="css-table">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>语句</td>
                            <td>操作时间</td>
                            <td>类型</td>
                            <td>操作用户ID</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="log" items="${list}">
                            <tr data-id="${log.id}" data-name="${log.id}">
                                <td>
                                    ${log.id }
                                </td>
                                <td>
                                    ${log.statement }
                                </td>
                                <td>
                                    ${log.operateTime }
                                </td>
                                <td>
                                    ${log.type }
                                </td>
                                <td>
                                    ${log.userid }
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
<script type="text/javascript" src="${BASE}/www/script/customer.js"></script>

</body>
</html>