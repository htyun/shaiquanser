<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>注册</title>
</head>
<body>

	<center>
		<p>
		<h1>注册页面，输入信息实现注册</h1>
		<br>
		<s:form action="manaReg" theme="simple" enctype="multipart/form-data"
			method="post">
			<table>
				<tr>
					<td>账号:<s:textfield name="manager.managerName" title="您输入的用户名只能是字母和数字
				，且长度必须在4到20之间" /></td>
				</tr>
				<tr>
					<td>密码:<s:password name="manager.managerPw" title="您输入的密码只能是字母和数字
				，且长度必须在4到25之间" /></td>
				</tr>
				<tr>
					<td>邮箱:<s:textfield name="manager.managerEmail" title="请输入邮箱" /></td>
				</tr>
				<tr>
					<td>图片:<s:file name="manaLogo" />
					</td>
				</tr>
				<tr>
					<td><s:submit value="提交" /> <s:reset value="重置" /></td>
				</tr>
			</table>
		</s:form>
	</center>

</body>



</html>