<%-- 
    Document   : vehicle
    Created on : Jul 24, 2024, 8:34:49 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">QUẢN LÝ XE</h1>
<a href="<c:url value="/admin/vehicleDetail" />" class="btn btn-success">Thêm</a>

<table class="table table-striped mt-3">
    <tr>
       
        <th>ID</th>
        <th>Số xe</th>
        <th>Loại</th>
        <th>Số chỗ</th>
        <th>Loại ghế</th>
        <th>Hình ảnh</th>
        <th></th>
    </tr>
    
    <c:forEach items="${cars}" var="c">

    <tr style="border-bottom: solid 1px black">

        <td>${c.id}</td>
        <td>${c.carNumber}</td>
        <td>${c.typeId.name}</td>
        <td>${c.typeId.quantity}</td>
        <td>${c.typeSeatId.name}</td>
        <td><img class="rounded img-fluid" 
                 src="${c.image}"
                 width="70"/></td>

        <td>
            <c:url value="/api/deleteCar/${c.id}"  var="apiDel"/>
            <button onclick="deleteItem('${apiDel}')" class="btn btn-danger">Xóa</button>
            <a class="btn btn-info" href="<c:url value="/admin/vehicleDetail/${c.id}" />">Xem chi tiết</a>
        </td>

    </tr>
    </c:forEach>
</table>
