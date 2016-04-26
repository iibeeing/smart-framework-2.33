<%@tag import="com.ccc.tools.Function"%>
<%@ tag language="java" %>
<%@attribute name="formName" description="formName" required="true"%>
<%@attribute name="functionId" description="functionId" required="true"%>
<%
	Function function = new Function();
	boolean isShow = function.eqUserkeyWord(functionId);
	String code = functionId.substring(functionId.indexOf("_") + 1,
			functionId.length());
	if (isShow) {
%>
<div class="t-tb-del">
	<div class="t-del-txt update <%=functionId%>"><%=formName%></div>
</div>
<%
	}
%>
