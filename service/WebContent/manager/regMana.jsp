<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ע��</title>
</head>
<body>

	<center>
		<p>
		<h1>ע��ҳ�棬������Ϣʵ��ע��</h1>
		<br>
		<s:form action="manaReg" theme="simple" enctype="multipart/form-data"
			method="post">
			<table>
				<tr>
					<td>�˺�:<s:textfield name="manager.managerName" title="��������û���ֻ������ĸ������
				���ҳ��ȱ�����4��20֮��" /></td>
				</tr>
				<tr>
					<td>����:<s:password name="manager.managerPw" title="�����������ֻ������ĸ������
				���ҳ��ȱ�����4��25֮��" /></td>
				</tr>
				<tr>
					<td>����:<s:textfield name="manager.managerEmail" title="����������" /></td>
				</tr>
				<tr>
					<td>ͼƬ:<s:file name="manaLogo" />
					</td>
				</tr>
				<tr>
					<td><s:submit value="�ύ" /> <s:reset value="����" /></td>
				</tr>
			</table>
		</s:form>
	</center>

</body>



</html>