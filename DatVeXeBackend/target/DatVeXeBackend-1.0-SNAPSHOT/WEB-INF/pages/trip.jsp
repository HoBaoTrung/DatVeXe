<%-- 
    Document   : vehicle
    Created on : Jul 24, 2024, 8:34:49 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">QUẢN LÝ CHUYẾN ĐI</h1>
<a href="<c:url value="/admin/tripDetail"/>">
<button class="btn btn-success">Thêm</button>
</a>
<c:if test="${counter > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="<c:url value="/admin/trip" />">Tất cả</a></li>
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="/admin/trip" var="pageUrl">
                        <c:param name="page" value="${i}"></c:param>
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>
<table class="table table-striped mt-3">
    <tr>

        <th>ID</th>
        <th>Tuyến</th>
        <th>Thời gian khởi hành</th>

        <th>Giá</th>
        <th></th>
    </tr>
<c:forEach items="${trips}" var="trip">
    <tr style="border-bottom: solid 1px black">

        
            <td>${trip.id}</td>
            <td>${trip.routeId.name}</td>
            <td>${trip.departAt}</td>

            <td>${trip.price}</td>
            <td>
                <button class="btn btn-danger">Xoa</button><!-- comment -->
                <a class="btn btn-info" href="<c:url value="/admin/tripDetail/${trip.id}" />">Xem chi tiet</a>
            </td>
       
    </tr> </c:forEach>
</table>
