<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>userInfo</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

table thead tr th {
	border: 1px solid black;
	padding: 3px;
	background-color: #cccccc;
}

table tbody tr td {
	border: 1px solid black;
	padding: 3px;
}
</style>
</head>
<body>

	<div align="center">
		<h2>用户列表</h2>
		<table cellspacing="0">
			<thead>
				<tr>
					<th>userName</th>
					<th>userPw</th>
					<th>userSex</th>
					<th>userCity</th>
					<th>stuName</th>
					<th>stuNo</th>
					<th>birth</th>
					<th>userEmail</th>
					<th>introduction</th>
					<th>userQQ</th>
					<th>userTel</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="userList">
					<tr>
						<td><s:property value="userName" /></td>
						<td><s:property value="userPw" /></td>
						<td><s:property value="userSex" /></td>
						<td><s:property value="userCity" /></td>
						<td><s:property value="stuName" /></td>
						<td><s:property value="stuNo" /></td>
						<td><s:property value="birth" /></td>
						<td><s:property value="userEmail" /></td>
						<td><s:property value="introduction" /></td>
						<td><s:property value="qq" /></td>
						<td><s:property value="userTel" /></td>
						<td><a
							href='<s:url  action="edit"><s:param name="stuNo" value="stuNo"/></s:url>'>Edit
						</a> <a
							href='<s:url action="delUser"><s:param name="stuNo" value="stuNo"/></s:url>'>Dele
						</a></td>
					</tr>
				</s:iterator>
			</tbody>

		</table>
		 <a href="user/insertUser.jsp">添加</a> 
		<a
			href='<s:url action="Page"><s:param name="pageNow" value="1"/></s:url>'>首
			页</a> <a
			href='<s:url action="Page"><s:param name="pageNow" value="pageNow-1"/></s:url>'>上一页</a>
		<a
			href='<s:url action="Page"><s:param name="pageNow" value="pageNow+1"/></s:url>'>下一页</a>
		<a
			href='<s:url action="Page"><s:param name="pageNow" value="pageCount"/></s:url>'>尾
			页</a>

	</div>

</body>
</html>