<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>登录</title>
</head>
<body>

	<center>
		<s:form action="manaLogin" method="post">
			<s:textfield label="账号" name="manager.managerName" title="请输入账号"/>
			<s:textfield label="密码" name="manager.managerPw" />
			<s:submit value="提交" />
		</s:form>
	</center>

</body>
</html>