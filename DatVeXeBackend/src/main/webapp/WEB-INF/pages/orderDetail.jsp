<%-- 
    Document   : updateShipper
    Created on : May 12, 2024, 8:30:38 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">QUẢN LÝ VÉ XE</h1>


<form method="post"  >
    <table class="table table-striped mt-3">
        <tr>

            <th>ID</th>
            <th>Ngày mua</th>
            <th>Nơi đi</th>
            <th>Nơi đến</th>
            <th>Xe</th>
            <th>Ghế</th>
            <th>Giá</th>

            <th></th>
        </tr>

        <tr style="border-bottom: solid 1px black">

            <td>1</td>
            <td>21/7/2024 <br> 13:30:00</td>
            <td>Nhà Bè</td>
            <td>Vũng Tàu</td>
            <td>0001</td>
            <td>A-1</td>
            <td>150000</td>
<!--            <td>
                
                <button type="submit" class="btn btn-info mt-3 mb-3">Cập nhât</button>
                <button  class="btn btn-danger mt-3 mb-3 ">Xóa</button>
            </td>-->
        </tr>
    </table>

</form>

<link rel="stylesheet" type="text/css" href="https://npmcdn.com/flatpickr/dist/themes/material_green.css">
<script>
    flatpickr("#goDate", {
        "enableTime": true

    });
</script>