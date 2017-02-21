<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>editUser</title>
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
		<h2>edit</h2>
		<s:form action="editUser" theme="simple">
			<table>
				<tr>
					<td>用户名:<s:textfield label="用户名" name="user.userName"
							title="请输入用户名!" />
					</td>
				</tr>
				<tr>
					<td>密码:<s:textfield label="密码" name="user.userPw"
							title="请输入密码!" />
					</td>
				<tr>
					<td>学号密码:<s:textfield label="密码" name="school.schoolPw"
							title="请输入密码!" />
					</td>
				</tr>
				<tr>
					<td>性别:<s:textfield label="性别" name="user.userSex"
							title="请输入性别!" />
					</td>
				</tr>
				<tr>
					<td>所在地:<s:textfield label="所在地" name="user.userCity"
							title="请输入所在地!" />
					</td>
				</tr>
				<tr>
					<td>学校:<s:textfield label="学校" name="user.stuName"
							title="请输入学校!" />
					</td>
				</tr>
				<tr>
					<td>生日:<s:textfield label="生日" name="user.birth"
							title="请输入生日!" />
					</td>
				</tr>
				<tr>
					<td>邮箱:<s:textfield label="邮箱" name="user.userEmail"
							title="请输入邮箱!" />
					</td>
				</tr>
				<tr>
					<td>简介:<s:textfield label="简介" name="user.introduction"
							title="请输入简介!" />
					</td>
				</tr>
				<tr>
					<td>QQ:<s:textfield label="QQ" name="user.qq" title="请输入QQ!" />
					</td>
				</tr>
				<tr>
					<td>电话:<s:textfield label="电话" name="user.userTel"
							title="请输入电话!" />
					</td>
				</tr>
				<tr>
					<td><s:submit value="提交" /></td>
				</tr>

			</table>
		</s:form>

	</div>
</body>
</html>