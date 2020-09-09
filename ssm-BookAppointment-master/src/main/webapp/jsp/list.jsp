<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>图书列表</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>图书列表</h2>
        </div>
        <form name="firstForm" action="<%= request.getContextPath()%>/books/search" method="post">
        	<div class="panel-heading ">
        	    <table class="table table-bookName">
        	       <thead>
        	       		<tr> 
        					<th width="90" align="lift">图书名称：</th>
        					<th width="150" align="lift">
        						<input type="text" name="name" class="allInput" value="${name}" placeholder="输入检索书名^o^" />
        					</th>
        					<th> 
        						<input type="submit" id="tabSub" value="检索" /> 
        						<input type="submit" id="addSub" value="添加" />
        					</th> 
        				</tr> 
        	       </thead> 
        	    </table> 
         	</div>
        </form>
       
        <form name="delForm" action="<%= request.getContextPath()%>/books/delete" method="post">
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>图书ID</th>
                    <th>图书名称</th>
                    <th>馆藏数量</th> 
                    <th>删除</th>
                    <th>修改</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="sk">
                    <tr>
                        <td>${sk.bookId}</td>
                        <td>${sk.name}</td>
                        <td>${sk.number}</td>
                        <!-- <td><a class="btn btn-info" href="/books/{sk.bookId}/detail" target="_blank">删除</a></td> -->
                        <input type="text" name="delId" value="${sk.bookId}" style="visibility:hidden"/>
                        <td><input type="submit" id="delSub" name="delId" value="删除"/></td>
                        <td><input type="submit" id="XiuSub" value="修改 "/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table> 
        </div>
		</form>
        
    </div>
</div>



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>

