<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>insertGoods</title>
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
		<h2>insertUser</h2>
		<s:form action="insertGoods" theme="simple">
			<table>
				<tr>
					<td>��Ʒ��: <s:textfield label="��Ʒ��" name="goods.goodName"
							title="��������Ʒ��!" /></td>
				</tr>
				<tr>
					<td>��Ʒ����: <s:textfield label="��Ʒ����"
							name="goods.goodIntroduction" title="��������Ʒ����!" /></td>
				</tr>
				<tr>
					<td>��Ʒ������: <s:textfield label="��Ʒ������" name="goods.fromWhere"
							title="��������Ʒ������!" /></td>
				</tr>
				<tr>
					<td>��Ʒ�������: <s:textfield label="��Ʒ�������" name="goods.goodState"
							title="��������Ʒ�������!" /></td>
				</tr>
				<tr>
					<td>��Ʒ��: <s:textfield label="��Ʒ�۸�" name="goods.price"
							title="��������Ʒ�۸�!" /></td>
				</tr>
				<tr>
					<td>�ϴ���: <s:textfield label="�ϴ���" name="goods.releaserID"
							title="�������ϴ���!" /></td>
				</tr>
				<tr>
					<td>��Ʒ����: <s:textfield label="��Ʒ����" name="goods.goodClassify"
							title="��������Ʒ����!" /></td>
				</tr>
				<tr>
					<td>ͼƬ: <s:file name="goodLogo" label="ͷ��" /></td>
				</tr>
				<tr>
					<td><s:submit value="�ύ" /></td>
				</tr>

			</table>
		</s:form>

	</div>

</body>
</html>