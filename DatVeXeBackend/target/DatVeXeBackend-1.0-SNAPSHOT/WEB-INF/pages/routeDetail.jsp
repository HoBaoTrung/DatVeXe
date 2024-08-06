<%-- 
    Document   : updateShipper
    Created on : May 12, 2024, 8:30:38 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">QUẢN LÝ TUYẾN XE</h1>

<%--
<form:form method="post" modelAttribute="user"  enctype="multipart/form-data">

    
    <div class="form-floating mt-3 mb-3">
        <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter name" name="name"/>
        <label for="name">Tên</label>
        <form:errors path="name" element="div" cssClass="text-danger"/>
    </div>



    

    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" id="price" placeholder="Enter price" name="price" path="price"/>
        <label for="price">price</label>
        <form:errors path="price" element="div" cssClass="text-danger"/>
    </div>


    

    <button type="submit" class="btn btn-info mt-3 mb-3">Cập nhât</button>
    <button  class="btn btn-danger mt-3 mb-3">Xóa</button>
</form:form>
--%>
<form method="post" modelAttribute="user"  >
    <div class="row">
        <div class="col-md-5 col-12">


            <div class="form-floating mb-3 mt-3">
                <input type="text" class="form-control" id="firstname" placeholder="Enter name" name="name"/>
                <label for="name">Tên</label>

            </div>

            <div class="form-floating mb-3 mt-3">
                <label >Nơi đi</label>
                
                <select class="form-select" id="vehicle" name="vehicle">
                    <c:forEach items="${stations}" var="s">
                    <option selected value="NB">
                       ${s.name}

                    </option></c:forEach>
                </select>
            </div>
            
            <div class="form-floating mb-3 mt-3">
                <label >Nơi đến</label>
                <select class="form-select" id="vehicle" name="vehicle">
                    <option selected value="VT">
                       Vũng Tàu

                    </option>
                </select>
            </div>

            <div class="form-floating mt-3 mb-3">
                <input type="text" class="form-control" id="address" placeholder="Enter price" name="price" />
                <label for="price">Giá vé</label>

            </div>


        </div>


    </div>
    <button type="submit" class="btn btn-info mt-3 mb-3">Cập nhât</button>
    <button  class="btn btn-danger mt-3 mb-3 ">Xóa</button>

</form>

