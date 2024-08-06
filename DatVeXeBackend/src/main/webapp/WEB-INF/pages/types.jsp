<%-- 
    Document   : vehicle
    Created on : Jul 24, 2024, 8:34:49 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">QUẢN LÝ LOẠI XE</h1>
<button class="btn btn-success">Thêm</button>
<table class="table table-striped mt-3">
    <tr>
       
        <th>ID</th>
       
        <th>Loại</th>
        <th>Số chỗ</th>
        <th>Giá vé(vnd)</th>
        <th>Hình ảnh</th>
        <th></th>
    </tr>

    <tr style="border-bottom: solid 1px black">

       
        <td>1</td>
       
        <td>Xe 45 chỗ</td>
        <td>45</td>
        <td>45000</td>
        <td><img class="rounded img-fluid" 
                 src="https://otomiennam.com.vn/wp-content/uploads/2023/05/Samco-45-cho.jpg.webp"
                 width="70"/></td>

        <td>
            <button class="btn btn-danger">Xoa</button><!-- comment -->
            <a class="btn btn-info" href="<c:url value="/typeDetail" />">Xem chi tiet</a>
        </td>

    </tr>
</table>
