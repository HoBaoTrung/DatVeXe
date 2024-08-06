<%-- 
    Document   : updateShipper
    Created on : May 12, 2024, 8:30:38 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<style>
    .select-wrapper {
        position: relative;
        width: 200px;
    }
    select {
        width: 100%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
        appearance: none;
        -webkit-appearance: none;
        -moz-appearance: none;
        background: url('image.png') no-repeat right center;
    }
</style>



<h1 class="text-center text-info">QUẢN LÝ XE</h1>

<%--
<form:form method="post" modelAttribute="vehicle"  >


   

    <button type="submit" class="btn btn-info mt-3 mb-3">Cập nhât</button>
    <button  class="btn btn-danger mt-3 mb-3">Xóa</button>
</form:form>
--%>
<form method="post" modelAttribute="user"  enctype="multipart/form-data">

    <div class="form-floating mb-3 mt-3">
        <label for="number">Số xe:</label>     
        <input type="text" class="form-control" id="number" placeholder="Enter number" value="0001" name="number"/>


    </div>

    <select class="form-select" id="vehicle" name="vehicle">
        <option selected value="loai1">
            Xe khách 45 chỗ, Số chỗ: 45  
        <div>
            <img class="rounded img-fluid" 
                 src="https://otomiennam.com.vn/wp-content/uploads/2023/05/Samco-45-cho.jpg.webp"
                 width="70"/>
        </div>

        </option>

        <option value="loai2">
            1321

        </option>

    </select>

    <br>


    <button type="submit" class="btn btn-info mt-3 mb-3">Cập nhât</button>
    <button  class="btn btn-danger mt-3 mb-3 ">Xóa</button>

</form>
