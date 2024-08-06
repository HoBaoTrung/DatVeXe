<%-- 
    Document   : index
    Created on : Jul 23, 2024, 2:36:59 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">QUẢN LÝ USER</h1>
<button class="btn btn-success">Thêm</button>
<table class="table table-striped mt-3">
    <tr>
       
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Avatar</th>
        <th></th>
    </tr>

    <tr style="border-bottom: solid 1px black">

       
        <td>1</td>
        <td>Nguyễn Văn A</td>
        <td>0123456789</td>
        <td>nvA@gmail.com</td>
        <td><img class="rounded img-fluid" 
                 src="https://th.bing.com/th/id/OIP.9_MptOLxjJEGSGukPt9FWQHaHa?w=188&h=188&c=7&r=0&o=5&dpr=1.3&pid=1.7"
                 width="45"/></td>

        <td>
            <button class="btn btn-danger">Xóa</button><!-- comment -->
            <a class="btn btn-info" href="<c:url value="/userDetail"/>">Xem chi tiết</a>
        </td>

    </tr>
    <%-- 
     <c:forEach items="${products}" var="p">
         <tr>

            <td><img class="rounded img-fluid" src="${p.image}" width="150"/></td>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.deliveryAddress}</td>
            <td>${p.recievedAddress}</td>

            <c:if test="${p.pay==true}">
                <td>yes</td>
            </c:if> 
            <c:if test="${p.pay==false}">
                <td>no</td>
            </c:if> 

            <td>
                <button class="btn btn-danger">Xoa</button><!-- comment -->
                <a class="btn btn-info" href="#">Xem chi tiet</a>
            </td>

        </tr>
</c:forEach>
    --%>       
</table>