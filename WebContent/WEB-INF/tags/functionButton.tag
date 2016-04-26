<%@tag import="com.ccc.tools.Function"%>
<%@ tag language="java" %>
<%@attribute name="formName" description="formName" required="true"%>
<%@attribute name="functionId" description="functionId" required="true"%>
<%
	Function function = new Function();
	boolean isShow = function.eqUserkeyWord(functionId);
	String code = functionId.substring(functionId.lastIndexOf("_") + 1,
			functionId.length());
	if (isShow) {
		if (code.equals("add")) {
%>
<div class="t_float">
	<div class="t_btn_green">
		<div class="t_btn_t" id="<%=functionId%>"><%=formName%></div>
	</div>
</div>
<%
	} else if (code.equals("del")) {
%>

<div class="t_float">
	<div class="t_btn_green t_btn_red">
		<div class="t_btn_t" id="<%=functionId%>"><%=formName%></div>
	</div>
</div>

<%
	} else {
%>

<div class="t_float">
	<div class="t_btn_green department_blue ">
		<div class="t_btn_t" id="<%=functionId%>"><%=formName%></div>
	</div>
</div>

<%
	}
	}
%>