<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>editGoods</title>
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
		<s:form action="editGoods" theme="simple">
			<table>
				<tr>
					<td>��Ʒ��:<s:textfield label="��Ʒ��" name="goods.goodName"
							title="��������Ʒ��!" />
					</td>
				</tr>
				<tr>
					<td>���:<s:textfield label="���" name="goods.goodIntroduction"
							title="��������!" />
					</td>
				</tr>
				<tr>
					<td>���Եط�:<s:textfield label="���Եط�" name="goods.fromWhere"
							title="���������Եط�!" />
					</td>
				</tr>
				<tr>
					<td>�������:<s:textfield label="�������" name="goods.goodState"
							title="�������������!" />
					</td>
				</tr>
				<tr>
					<td>�۸�:<s:textfield label="�۸�" name="goods.price"
							title="������۸�!" />
					</td>
				</tr>
				<tr>
					<td>����:<s:textfield label="����" name="goods.goodClassify"
							title="���������!" />
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