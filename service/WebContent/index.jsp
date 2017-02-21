<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>主页</title>
</head>
<body>

	<%
		if (session.getAttribute("managerName") != null && !session.getAttribute("managerName").equals("")) {
	%>
	<p>
		登录账号:<%=session.getAttribute("managerName")%>
		<a href='<s:url action="zx"></s:url>'>注销</a>
	<table cellspacing="0" align="right">
		<tr>
			<td></td>
			<td><s:form action="indexGetUser">
					<s:submit value="用户信息"></s:submit>
				</s:form></td>
			<td><s:form action="indexGetGoods" method="post">
					<s:submit value="商品信息" />
				</s:form></td>
		</tr>
	</table>



	<%
		} else {
	%>

	<table cellspacing="0" align="right">
		<thead>
			<tr>
				<td>
				
				<s:form action="tzAction1" method="post">
						<s:submit value="登录" />

					</s:form>
					
				</td>
				<td><s:form action="tzAction2" method="post">
						<s:submit value="注册" />
					</s:form></td>
			</tr>
		</thead>
	</table>




	<%
		}
	%>


</body>
</html>