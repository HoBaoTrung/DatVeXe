<%-- 
    Document   : vehicle
    Created on : Jul 24, 2024, 8:34:49 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">QUẢN LÝ TUYẾN XE</h1>
<a href="<c:url value="/admin/routeDetail" />" class="btn btn-success">Thêm</a>
<c:if test="${counter > 1}">
    <ul class="pagination mt-1">
        <li class="page-item"></li>
            <c:forEach begin="1" end="${counter}" var="i">
                <c:url value="/admin/route" var="pageUrl">
                    <%--<c:param name="role" value="${param.role}"/>--%>
                    <c:param name="page" value="${i}"></c:param>
                </c:url>
            <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
            </c:forEach>
    </ul>
</c:if>
<table class="table table-striped mt-3">
    <tr>
       
        <th>ID</th>
        <th>Tên</th>
        <th>Điểm đi</th>
        <th>Điểm đến</th>
        <th>Giá</th>
        <th></th>
    </tr>
    <c:forEach items="${routes}" var="r">
    <tr style="border-bottom: solid 1px black">

        
        <td>${r.id}</td>
        <td>${r.name}</td>
        <td>${r.fromStation.name}</td>
        <td>${r.toStation.name}</td>
        <td>${r.routePrice}   </td>
     

        <td>
             <c:url value="/api/deleteRoute/${r.id}"  var="apiDel"/>
            <button onclick="deleteItem('${apiDel}')" class="btn btn-danger">Xóa</button>
            <a class="btn btn-info" href="<c:url value="/admin/routeDetail/${r.id}" />">Xem chi tiết</a>
        </td>

    </tr></c:forEach>
</table>
