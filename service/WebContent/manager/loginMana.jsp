<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��¼</title>
</head>
<body>

	<center>
		<s:form action="manaLogin" method="post">
			<s:textfield label="�˺�" name="manager.managerName" title="�������˺�"/>
			<s:textfield label="����" name="manager.managerPw" />
			<s:submit value="�ύ" />
		</s:form>
	</center>

</body>
</html>