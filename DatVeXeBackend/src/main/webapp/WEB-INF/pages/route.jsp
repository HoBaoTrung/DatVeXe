<%-- 
    Document   : vehicle
    Created on : Jul 24, 2024, 8:34:49 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">QUẢN LÝ Xe</h1>
<button class="btn btn-success">Thêm</button>
<table class="table table-striped mt-3">
    <tr>
       
        <th>ID</th>
        <th>Tên</th>
        <th>Điểm đi</th>
        <th>Điểm đến</th>
        <th>Giá</th>
        <th></th>
    </tr>

    <tr style="border-bottom: solid 1px black">

        
        <td>1</td>
        <td>Tuyến NB-VT</td>
        <td>Nhà Bè</td>
        <td>Vũng Tàu</td>
        <td>150000   </td>
     

        <td>
            <button class="btn btn-danger">Xoa</button><!-- comment -->
            <a class="btn btn-info" href="<c:url value="/admin/routeDetail" />">Xem chi tiet</a>
        </td>

    </tr>
</table>
