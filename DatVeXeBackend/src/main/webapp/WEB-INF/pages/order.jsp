<%-- 
    Document   : vehicle
    Created on : Jul 24, 2024, 8:34:49 PM
    Author     : ASUS
--%>

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

    <tr style="border-bottom: solid 1px black">

        
        <td>1</td>
        <td>1</td>
        <td>21/7/2024 <br> 13:30:00</td>
       <td>Nguyễn Văn A   </td>
        <td>150000   </td>
     

        <td>
            <button class="btn btn-danger">Xoa</button><!-- comment -->
            <a class="btn btn-info" href="<c:url value="/orderDetail" />">Xem chi tiet</a>
        </td>

    </tr>
</table>
