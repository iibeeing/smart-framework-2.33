<%@ tag language="java" pageEncoding="UTF-8" %>
<%@attribute name="formName" description="formName" required="true"%>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<style>
/*页码*/
.page_num{float:left; border:1px solid #a6a6a6; padding:1px 7px 0px 7px; margin:10px 5px 0px 0px; font-family:Arial, Helvetica, sans-serif; font-size:11px; background:url(../images/t-main.jpg); height:15px; cursor:pointer;}
.page_num:hover{border:1px solid #000;}
.page_left{background:url(/www/asset/images/t-table.png); background-position:74px 44px; width:9px; height:13px; padding:3px 6px 0px 5px;}
.page_right{background:url(/www/asset/images/t-table.png); background-position:74px 20px; width:9px; height:13px; padding:3px 6px 0px 5px;}
.page_point{margin:10px 5px 0px 0px; font-family:Arial, Helvetica, sans-serif; font-size:11px; float:left;}
.page_text{margin:13px 5px 0px 0px;float:left;}
.page_textfield{width:20px; height:14px; border:1px solid #a6a6a6; float:left; margin:10px 5px 0px 0px; font-family:Arial, Helvetica, sans-serif; font-size:11px; padding:2px 2px 0px 2px;}
.page_go{background:url(/www/asset/images/amend.jpg); width:17px; height:15px; float:left; margin:10px 5px 0px 0px; border:1px solid #345f98; color:#fff; font-weight:bold;cursor:pointer;}
.page_go:hover{background:url(/www/asset/images/amend-1.jpg); border:1px solid #345f98; }
</style>

<script type="text/javascript" src="${BASE}/www/asset/lib/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${BASE}/www/asset/lib/jquery-form/jquery.form.min.js"></script>
<script type="text/javascript">
	
	$().ready(function() {
		
		$(".firstPage").click(function() {
			$("#pageIndex").val(1);
			$(this).parents("form").submit();
		});
		
		$(".prePage").click(function() {
			var pageIndex = $("#pageIndex").val();
			if (parseInt(pageIndex) > 1) {
				var pageindex = parseInt(pageIndex)-1;
				$("#pageIndex").val(pageindex);
				$(this).parents("form").submit();
			}
		});
		
		$(".nextPage").click(function() {
			var pageIndex = $("#pageIndex").val();
			var pageCount = $("#pageCount").val();
			if (parseInt(pageIndex) < parseInt(pageCount)) {
				var pageindex = parseInt(pageIndex)+1;
				$("#pageIndex").val(pageindex);
				$(this).parents("form").submit();
			}
		});
		
		$(".lastPage").click(function() {
			var pageCount = $("#pageCount").val();
			$("#pageIndex").val(pageCount);
			$(this).parents("form").submit();
		});
		
		$(".toPage").click(function() {
			var pageValue = $("#pageValue").val();
			$("#pageIndex").val(pageValue);
			$(this).parents("form").submit();
		});
		
	});
	
</script>
<div style="text-align: right; padding-right: 5px;width: 100%">
        <input type="hidden" value="${page.pageCount}" id="pageCount" />
        <input type="hidden" name="page.pageIndex" id="pageIndex" value="${page.pageIndex}" />
        <div class="page_num firstPage">1</div>
        <div class="page_num page_left prePage"></div>
        <div class="page_num page_right nextPage"></div>
        <div class="page_num lastPage">${page.pageCount}</div>
        <div class="page_text">跳转到</div>
        <div>
          <input type="text" id="pageValue"  class="page_textfield" value="${page.pageIndex}"/>
        </div>
        <div class="page_num page_go toPage">GO</div>
        <div class="page_text">共${page.recordCount}条信息 每页显示</div>
        <div><input name="page.pageNumber" type="text"  class="page_textfield" id="pageNumber" value="${page.pageNumber}"/></div>
        <div class="page_text">条</div>
</div>