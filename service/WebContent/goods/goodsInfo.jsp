<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>goodsInfo</title>
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
		<h2>商品列表</h2>
		<table cellspacing="0">
			<thead>
				<tr>
					<th>goodName</th>
					<th>goodIntroduction</th>
					<th>releaseTime</th>
					<th>fromWhere</th>
					<th>goodState</th>
					<th>price</th>
					<th>releaserID</th>
					<th>goodClassify</th>
					<th>time</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="goodsList">
					<tr>
						<td><s:property value="goodName" /></td>
						<td><s:property value="goodIntroduction" /></td>
						<td><s:property value="releaseTime" /></td>
						<td><s:property value="fromWhere" /></td>
						<td><s:property value="goodState" /></td>
						<td><s:property value="price" /></td>
						<td><s:property value="releaserID" /></td>
						<td><s:property value="goodClassify" /></td>
						<td><s:property value="time" /></td>
						<td><a
							href='<s:url  action="edits"><s:param name="releaseTime" value="releaseTime"/></s:url>'>Edit
						</a> <a
							href='<s:url action="delGoods"><s:param name="releaseTime" value="releaseTime"/></s:url>'>Dele
						</a></td>
					</tr>
				</s:iterator>
			</tbody>

		</table>
		<a href="goods/insertGoods.jsp">添加</a> 
		 <a
			href='<s:url action="Pages"><s:param name="pageNow" value="1"/></s:url>'>首
			页</a> <a
			href='<s:url action="Pages"><s:param name="pageNow" value="pageNow-1"/></s:url>'>上一页</a>
		<a
			href='<s:url action="Pages"><s:param name="pageNow" value="pageNow+1"/></s:url>'>下一页</a>
		<a
			href='<s:url action="Pages"><s:param name="pageNow" value="pageCount"/></s:url>'>尾
			页</a>

	</div>

</body>
</html>