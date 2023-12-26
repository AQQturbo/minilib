<%@ page language="java" contentType="text/html; charset=UTF-8"
	import = "java.util.*"
	import = "minilib.vo.Title"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表</title>
</head>
<body>

<table width="100%" border="0" cellspacing="1" cellpadding="0" class="">
			                      <tr bgcolor="#fba661" height="25">
				                        <td width="10%" bgcolor= "#fba661">
											<div align="center">
												ISBN
											</div>
										</td>
										<td width="13%" bgcolor="#fba661">
											<div align="center">
												书名
											</div>
										</td>
										<td width="12%" bgcolor="#fba661">
											<div align="center">
												作者
											</div>
										</td>
										<td width="13%" bgcolor="#fba661">
											<div align="center">
												出版社
											</div>
									
										</td>
									
									</tr>
								
									<c:forEach items= "${requestScope.alltitleslist}" var="title" varStatus="status" >
										
												<tr bgcolor="#f3f3f3" height="25">
													<td width="10%">
														<div align="center">
															${title.isbn}
														</div>
													</td>
													<td width="13%">
														<div align="center">
															${title.title}
														</div>
													</td>
													<td width="12%">
														<div align="center">
															${title.authors}
														</div>
													</td>
													<td width="12%">
														<div align="center">
															${title.pressid}
														</div>
													</td>
												</tr>
										</c:forEach>
										
																
								
	</table>

</body>
</html>