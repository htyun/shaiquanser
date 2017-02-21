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
					<td>商品名:<s:textfield label="商品名" name="goods.goodName"
							title="请输入商品名!" />
					</td>
				</tr>
				<tr>
					<td>简介:<s:textfield label="简介" name="goods.goodIntroduction"
							title="请输入简介!" />
					</td>
				</tr>
				<tr>
					<td>来自地方:<s:textfield label="来自地方" name="goods.fromWhere"
							title="请输入来自地方!" />
					</td>
				</tr>
				<tr>
					<td>在售情况:<s:textfield label="在售情况" name="goods.goodState"
							title="请输入在售情况!" />
					</td>
				</tr>
				<tr>
					<td>价格:<s:textfield label="价格" name="goods.price"
							title="请输入价格!" />
					</td>
				</tr>
				<tr>
					<td>分类:<s:textfield label="分类" name="goods.goodClassify"
							title="请输入分类!" />
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