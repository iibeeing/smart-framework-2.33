<%@ tag language="java" %>
<%@attribute name="test" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	
%>
<link href="css/table.css" rel="stylesheet" type="text/css" />
<table width=100% border="0" cellspacing="0" cellpadding="0" class="t_tb_right">
  <tr style="background:#d2e1f8">
    <td class="t_topl"></td>
    <td class="t_topc"></td>
    <td class="t_topr"></td>
  </tr>
  <tr style="background:#d2e1f8">
    <td class="t_left"></td>
    <td class="t_center"><div>
      <div class="t_float">
      <div class="t_float">
        <div class="t_btn_green t_btn_red">
        <div class="t_btn_t">删除</div></div></div>
        <div class="t_float">
        <div class="t_btn_green">
        <div class="t_btn_t">新增</div></div></div>
        <div class="t_float">
        <div class="t_btn_green t_btn_blue">
        <div class="t_btn_t">导入</div></div></div>
      </div>
      <div class="t_float">
        <div class="t_btn_green t_btn_blue">
        <div class="t_btn_t">导出</div></div></div>
      </div>
      <div class="t_float_right">
      <div class="t_float t_radio">用户名：</div>
        <div class="t_float">
          <input type="text" name="textfield" id="textfield" class="t_border t_textfield"/>
        </div>
        <div class="t_float t_radio">ID:</div>
        <div class="t_float">
          <input type="text" name="textfield" id="textfield" class="t_border t_textfield"/>
        </div>
        <div class="t_float_serach">
        <div class="t_btn_green t_btn_blue">
      <div class="t_btn_t">搜索</div></div></div></div>
      </div>
      <div style="clear:both;"></div>
    </div>
      <div class="t-title">
        <div class="t-title-pad">用户管理列表</div>
      </div>
      <div class="t-main">
        <table id="table1" width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <th class="t-checkbox" style="border-left:none;"><input type="checkbox" name="checkbox" id="checkbox" /></th>
            <th>用户名<div class="t_main_arrows"></div></th>
            <th>登陆ID<div class="t_main_arrows"></div></th>
            <th>用户电话<div class="t_main_arrows"></div></th>
            <th>用户邮箱<div class="t_main_arrows"></div></th>
            <th>部门名称<div class="t_main_arrows"></div></th>
            <th>用户来源<div class="t_main_arrows"></div></th>
            <th class="table_thlast">操作</th>
          </tr>
          <tr>
            <td class="t-checkbox" style="border-left:none;"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
            <td>暂无通知</td>
            <td>暂无通知暂无通知暂</td>
            <td>2013/02/26 </td>
            <td>2013/02/27 </td>
            <td>2013/02/27 </td>
            <td>2013/02/27 </td>
            <td><div class="t-tb-del">
              <div class="t-del-txt">修改</div>
            </div>
              <div class="t-tb-del" style="padding-left:6px;  padding-right:6px;">
                <div class="t-del-txt">分配角色</div>
            </div>
              <div class="t_del_red">
                <div class="t-del-txt">删除</div>
              </div></td>
          </tr>
         <tr>
            <td class="t-checkbox" style="border-left:none;"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
            <td>暂无通知</td>
            <td>暂无通知暂无通知暂</td>
            <td>2013/02/26 </td>
            <td>2013/02/27 </td>
            <td>2013/02/27 </td>
            <td>2013/02/27 </td>
            <td><div class="t-tb-del">
              <div class="t-del-txt">修改</div>
            </div>
              <div class="t-tb-del" style="padding-left:6px;  padding-right:6px;">
                <div class="t-del-txt">分配角色</div>
            </div>
              <div class="t_del_red">
                <div class="t-del-txt">删除</div>
              </div></td>
          </tr><tr>
            <td class="t-checkbox" style="border-left:none;"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
            <td>暂无通知</td>
            <td>暂无通知暂无通知暂</td>
            <td>2013/02/26 </td>
            <td>2013/02/27 </td>
            <td>2013/02/27 </td>
            <td>2013/02/27 </td>
            <td><div class="t-tb-del">
              <div class="t-del-txt">修改</div>
            </div>
              <div class="t-tb-del" style="padding-left:6px;  padding-right:6px;">
                <div class="t-del-txt">分配角色</div>
            </div>
              <div class="t_del_red">
                <div class="t-del-txt">删除</div>
              </div></td>
          </tr>
        </table>
        <div>
        <div class="page_num page_left"></div>
        <div class="page_num">1</div>
        <div class="page_point">...</div>
        <div class="page_num">5</div>
        <div class="page_num">6</div>
        <div class="page_num">7</div>
        <div class="page_point">...</div>
        <div class="page_num">100</div>
        <div class="page_num page_right"></div>
        <div class="page_text">跳转到</div>
        <div>
          <input type="text" name="textfield2" id="textfield2"  class="page_textfield"/>
        </div>
        <div class="page_num page_go">GO</div>
        <div class="page_text">共21294条信息 每页显示</div>
        <div><input name="textfield2" type="text"  class="page_textfield" id="textfield2" value="25"/></div>
        <div class="page_text">条</div>
        </div>
      </div>
    </td>
    <td class="t_right"></td>
  </tr>
  <tr style="background:#d2e1f8">
    <td class="t_bottoml"></td>
    <td class="t_bottomc"></td>
    <td class="t_bottomr"></td>
  </tr>
</table>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/table.js" type="text/javascript"></script>
