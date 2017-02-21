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
					<td>商品名: <s:textfield label="商品名" name="goods.goodName"
							title="请输入商品名!" /></td>
				</tr>
				<tr>
					<td>商品介绍: <s:textfield label="商品介绍"
							name="goods.goodIntroduction" title="请输入商品介绍!" /></td>
				</tr>
				<tr>
					<td>商品发布地: <s:textfield label="商品发布地" name="goods.fromWhere"
							title="请输入商品发布地!" /></td>
				</tr>
				<tr>
					<td>商品在售情况: <s:textfield label="商品在售情况" name="goods.goodState"
							title="请输入商品在售情况!" /></td>
				</tr>
				<tr>
					<td>商品价: <s:textfield label="商品价格" name="goods.price"
							title="请输入商品价格!" /></td>
				</tr>
				<tr>
					<td>上传者: <s:textfield label="上传者" name="goods.releaserID"
							title="请输入上传者!" /></td>
				</tr>
				<tr>
					<td>商品分类: <s:textfield label="商品分类" name="goods.goodClassify"
							title="请输入商品分类!" /></td>
				</tr>
				<tr>
					<td>图片: <s:file name="goodLogo" label="头像" /></td>
				</tr>
				<tr>
					<td><s:submit value="提交" /></td>
				</tr>

			</table>
		</s:form>

	</div>

</body>
</html>