
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">QUẢN LÝ VÉ XE</h1>

<table class="table table-striped mt-3">
    <tr>
        <th>ID</th>
        <th>Ngày đi</th>
        <th>Nơi đi</th>
        <th>Nơi đến</th>
        <th>Xe</th>
        <th>Ghế</th>
        <th>Giá</th>

        <th></th>

    </tr>
    <c:forEach items="${tickets}" var="t">
        <tr style="border-bottom: solid 1px black">
            <fmt:formatDate value="${t.expiredAt}" pattern="dd/MM/yyyy" var="datePart" />
            <fmt:formatDate value="${t.expiredAt}" pattern="HH:mm:ss" var="timePart" />
            <td>${t.id}</td>

            <td>${datePart} - ${timePart}</td>
            <td>${t.tripId.routeId.fromStation.name}</td>
            <td>${t.tripId.routeId.toStation.name}</td>

            <td>${t.tripId.carId.carNumber}</td>
            <td> ${t.seatId.code}</td>
            <td>${t.tripId.price}</td>
            <td>
                <c:url value="/api/deleteTicket/${t.id}"  var="apiDel"/>  
                <button class="btn btn-danger" onclick="deleteItem('${apiDel}')" >Xóa</button>
            </td>

        </tr>
    </c:forEach>
</table>

