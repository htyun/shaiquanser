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
					<td>�û���:<s:textfield label="�û���" name="user.userName"
							title="�������û���!" />
					</td>
				</tr>
				<tr>
					<td>����:<s:textfield label="����" name="user.userPw"
							title="����������!" />
					</td>
				<tr>
					<td>ѧ������:<s:textfield label="����" name="school.schoolPw"
							title="����������!" />
					</td>
				</tr>
				<tr>
					<td>�Ա�:<s:textfield label="�Ա�" name="user.userSex"
							title="�������Ա�!" />
					</td>
				</tr>
				<tr>
					<td>���ڵ�:<s:textfield label="���ڵ�" name="user.userCity"
							title="���������ڵ�!" />
					</td>
				</tr>
				<tr>
					<td>ѧУ:<s:textfield label="ѧУ" name="user.stuName"
							title="������ѧУ!" />
					</td>
				</tr>
				<tr>
					<td>����:<s:textfield label="����" name="user.birth"
							title="����������!" />
					</td>
				</tr>
				<tr>
					<td>����:<s:textfield label="����" name="user.userEmail"
							title="����������!" />
					</td>
				</tr>
				<tr>
					<td>���:<s:textfield label="���" name="user.introduction"
							title="��������!" />
					</td>
				</tr>
				<tr>
					<td>QQ:<s:textfield label="QQ" name="user.qq" title="������QQ!" />
					</td>
				</tr>
				<tr>
					<td>�绰:<s:textfield label="�绰" name="user.userTel"
							title="������绰!" />
					</td>
				</tr>
				<tr>
					<td><s:submit value="�ύ" /></td>
				</tr>

			</table>
		</s:form>

	</div>
</body>
</html>