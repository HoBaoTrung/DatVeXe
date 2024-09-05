

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">QUẢN LÝ ĐƠN HÀNG</h1>

<table class="table table-striped mt-3">
    <tr>

        <th>ID</th>
        <th>Số lượng vé</th>
        <th>Thời gian mua vé</th>
        <th>Người mua</th>
        <th>Tổng giá</th>
        <th></th>
    </tr>
    <c:forEach items="${orders}" var="o">
        <tr style="border-bottom: solid 1px black">
            <fmt:formatDate value="${o.createdDate}" pattern="dd/MM/yyyy" var="datePart" />
            <fmt:formatDate value="${o.createdDate}" pattern="HH:mm:ss" var="timePart" />
            <c:set var="soVe" value="${o.ticketSet.size()}" />
            <c:set var="giaChuyenDi" value="${o.getTicketSet().iterator().next().tripId.price}" />
            <td>${o.id}</td>
            <td>${soVe}</td>
            <td>${datePart} <br> ${timePart}</td>
            <td>${o.customerId.firstName} ${o.customerId.lastName}  </td>
            <td> ${soVe*giaChuyenDi} </td>


            <td>
                <c:url value="/api/deleteOrder/${o.id}"  var="apiDel"/>
                <button onclick="deleteItem('${apiDel}')" class="btn btn-danger">Xóa</button><!-- comment -->
                <a class="btn btn-info" href="<c:url value="/admin/orderDetail/${o.id}" />">Xem chi tiết</a>
            </td>

        </tr></c:forEach>
</table>
