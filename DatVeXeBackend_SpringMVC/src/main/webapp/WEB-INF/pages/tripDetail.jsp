<%-- 
    Document   : updateShipper
    Created on : May 12, 2024, 8:30:38 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">QUẢN LÝ CHUYẾN XE</h1>

<c:url value="/admin/tripDetail" var="action" />
<form:form method="post" action="${action}" modelAttribute="trip">
    <form:hidden path="id" />
    <form:hidden path="isActive" />
    <form:hidden path="price" />
    <form:hidden path="createdAt" />
    <div class="row">
        <div class="col-md-5 col-12">

            <div class="form-floating mb-3 mt-3">
                <label >Tuyến</label>
                <form:select class="form-select" id="route" path="routeId" name="routelist">
                    <c:forEach items="${routes}" var="r">
                        <c:choose>
                            <c:when test="${r.id == trip.routeId.id}">
                                <option value="${r.id}" selected>${r.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${r.id}">${r.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
            </div>

            <div class="form-floating mb-3 mt-3">
                <label >Xe</label>
                <form:select class="form-select" id="car" path="carId" name="carlist">
                    <c:forEach items="${cars}" var="r">
                        <c:choose>
                            <c:when test="${r.id == trip.carId.id}">
                                <option value="${r.id}" selected>${r.carNumber}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${r.id}">${r.carNumber}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
            </div>

            <div class="form-floating mt-3 mb-3">

                <form:input path="datetime" type="text" class="form-control" id="goDate"  name="date" />

                <label for="price">Ngày khởi hành</label>

            </div>


        </div>


    </div>
    <c:choose>
        <c:when test="${trip.id == null}">
            <button type="submit" class="btn btn-info mt-3 mb-3">Thêm</button>
        </c:when>
        <c:otherwise>
            <c:url value="/api/deleteTrip/${trip.id}"  var="apiDel"/>
            <a class="btn btn-danger" onclick="deleteItem('${apiDel}', true)">Xóa</a>  
            <button type="submit" class="btn btn-info mt-3 mb-3">Cập nhât</button>
            
        </c:otherwise>
    </c:choose>


</form:form> 

<script src="<c:url value="/js/delete.js"/>"></script>
<link rel="stylesheet" type="text/css" href="https://npmcdn.com/flatpickr/dist/themes/material_green.css">
<script>
        flatpickr("#goDate", {
            "enableTime": true
            , dateFormat: "Y-m-d H:i",
             minDate:new Date().fp_incr(2)
        });
</script>