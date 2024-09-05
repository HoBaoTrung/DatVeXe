<%-- 
    Document   : updateShipper
    Created on : May 12, 2024, 8:30:38 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">QUẢN LÝ USER</h1>


<form:form method="post" modelAttribute="type"  enctype="multipart/form-data">


    <div class="form-floating mt-3 mb-3">
        <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter name" name="name"/>
        <label for="name">Loại</label>
        <form:errors path="name" element="div" cssClass="text-danger"/>
    </div>



    <div class="form-floating mt-3 mb-3">
        <form:input type="number" class="form-control" id="quantity" placeholder="Enter quantity" name="quantity" path="quantity"/>
        <label for="quantity">Số chỗ</label>
        <form:errors path="quantity" element="div" cssClass="text-danger"/>
    </div>

    <c:choose>
        <c:when test="${type.id==null}">
            <button type="submit" class="btn btn-info mt-3 mb-3">Thêm</button>
        </c:when>
        <c:otherwise>
            
            <button type="submit" class="btn btn-info mt-3 mb-3">Cập nhât</button>
            <c:url value="/api/deleteType/${type.id}"  var="apiDel"/>
            <button onclick="deleteItem('${apiDel}',true)" class="btn btn-danger">Xóa</button>
        </c:otherwise>
    </c:choose>
</form:form>


