<%-- 
    Document   : updateShipper
    Created on : May 12, 2024, 8:30:38 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">QUẢN LÝ TUYẾN XE</h1>


<form:form method="post" modelAttribute="route" >
    <form:hidden path="createdAt"/>
    <div class="row">
        <div class="col-md-5 col-12">
            <div class="form-floating mt-3 mb-3">
                <label for="name">Tên</label>
                <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter name" name="name"/>
                <form:errors path="name" element="div" cssClass="text-danger"/>
            </div>


            <div class="form-floating mt-3 mb-3">
                <label for="fromStation">Bến đi</label><!-- comment -->
                <form:select class="form-select" id="fromStation" path="fromStation" name="fromStation">
                    <c:forEach items="${stations}" var="r">
                        <c:choose>
                            <c:when test="${r.id == route.fromStation.id}">
                                <option value="${r.id}" selected>${r.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${r.id}">${r.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-floating mt-3 mb-3">

                <label for="fromStation">Bến đến</label><!-- comment -->
                <form:select class="form-select" id="toStation" path="toStation" name="toStation">
                    <c:forEach items="${stations}" var="r">
                        <c:choose>
                            <c:when test="${r.id == route.toStation.id}">
                                <option value="${r.id}" selected>${r.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${r.id}">${r.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
            </div>


            <div class="form-floating mt-3 mb-3">
                <label for="price">Giá tuyến</label>
                <form:input type="number" class="form-control" id="price" placeholder="Enter price" name="price" path="routePrice"/>

                <form:errors path="routePrice" element="div" cssClass="text-danger"/>
            </div>

        </div>


    </div>
    <c:choose>
        <c:when test="${route.id==null}">
            <button type="submit" class="btn btn-info mt-3 mb-3">Thêm</button>
        </c:when>
        <c:otherwise>
            <c:url value="/api/deleteRoute/${route.id}"  var="apiDel"/>
            <button type="submit" class="btn btn-info mt-3 mb-3">Cập nhât</button>
            <button onclick="deleteItem('${apiDel}', true)" class="btn btn-danger mt-3 mb-3">Xóa</button>
        </c:otherwise>
    </c:choose>
</form:form>


