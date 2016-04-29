<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="p"%>
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
            
             	<div class="css-row">
                    <div class="css-left">
                        <form id="user_search_form">
                            <div class="css-search">
                                <input type="text" id="user_name" placeholder="用户名"/>
                                <span class="css-search-button">
                                    <button type="submit">搜索</button>
                                </span>
                            </div>
                        </form>
                    </div>
                    <div class="css-right">
                        <div id="user_pager"></div>
                    </div>
                </div>
                
            
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
                
<!--                 <div class="css-row">
                    <div class="css-right">
                        <div id="user_pager"></div>
                    </div>
                </div> -->
                <p:page formName="f1"></p:page>
                
			       <%--  <div class="panelBar">
					<div class="pages">
						<span>显示</span>
						<select class="combox"  name="numPerPage" >
							<option value="10">10</option>
						</select>
						<span>条，共${page.recordCount}条</span>
					</div>
					<div class="pagination" targetType="navTab" totalCount="${page.recordCount}" numPerPage="${page.pageNumber}" pageNumShown="10" currentPage="${page.pageNum}"></div>
				</div> --%>
	
            </div>
        </div>
    </div>
</div>

<div id="footer">
    <div id="copyright">Copyright @ 2016</div>
</div>

<script id="user_table_template" type="text/template">
    <tr data-id="{user.id}" data-name="{user.username}">
        <td><a href="#" class="ext-user-view">{user.username}</a></td>
        <td>{user.username}</td>
        <td>
            <a href="#" class="ext-user-edit">Edit</a>
            <a href="#" class="ext-user-delete">Delete</a>
        </td>
    </tr>
</script>
<script type="text/javascript" src="${BASE}/www/asset/lib/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${BASE}/www/asset/lib/jquery-form/jquery.form.min.js"></script>
<script type="text/javascript" src="${BASE}/www/asset/script/global.js"></script>
<script type="text/javascript" src="${BASE}/www/script/system/user/list.js"></script>

</body>
</html>