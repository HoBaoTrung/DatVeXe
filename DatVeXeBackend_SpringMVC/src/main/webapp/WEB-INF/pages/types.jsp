<%-- 
    Document   : vehicle
    Created on : Jul 24, 2024, 8:34:49 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">QUẢN LÝ LOẠI XE</h1>
<a href="<c:url value="/admin/typeDetail" />" class="btn btn-success">Thêm</a>
<table class="table table-striped mt-3">
    <tr>
       
        <th>ID</th>
       
        <th>Loại</th>
        <th>Số chỗ</th>
        
        <th></th>
    </tr>
    <c:forEach items="${types}" var="t">
    <tr style="border-bottom: solid 1px black">
        <td>${t.id}</td>
       
        <td>${t.name}</td>
        <td>${t.quantity}</td>
       

        <td>
             <c:url value="/api/deleteType/${t.id}"  var="apiDel"/>
            <button onclick="deleteItem('${apiDel}')" class="btn btn-danger">Xóa</button>
            <a class="btn btn-info" href="<c:url value="/admin/typeDetail/${t.id}" />">Xem chi tiết</a>
        </td>

    </tr>
    </c:forEach>
</table>
