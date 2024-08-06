<%-- 
    Document   : updateShipper
    Created on : May 12, 2024, 8:30:38 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">QUẢN LÝ USER</h1>

<%--
<form:form method="post" modelAttribute="user"  enctype="multipart/form-data">

    
    <div class="form-floating mt-3 mb-3">
        <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter name" name="name"/>
        <label for="email">Loại</label>
        <form:errors path="name" element="div" cssClass="text-danger"/>
    </div>



    <div class="form-floating mt-3 mb-3">
        <form:input type="number" class="form-control" id="quantity" placeholder="Enter quantity" name="quantity" path="quantity"/>
        <label for="quantity">Số chỗ</label>
        <form:errors path="quantity" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" id="price" placeholder="Enter price" name="price" path="price"/>
        <label for="price">price</label>
        <form:errors path="price" element="div" cssClass="text-danger"/>
    </div>


    <div class="form-floating mt-3 mb-3">
        <form:input type="file" class="form-control" id="avatar"  path="file" />
        <label for="avatar">Avatar</label>

    </div>

    <button type="submit" class="btn btn-info mt-3 mb-3">Cập nhât</button>
    <button  class="btn btn-danger mt-3 mb-3">Xóa</button>
</form:form>
--%>
<form method="post" modelAttribute="user"  enctype="multipart/form-data">
    <div class="row">
        <div class="col-md-5 col-12">
            

            <div class="form-floating mb-3 mt-3">
                <input type="text" class="form-control" id="firstname" placeholder="Enter name" name="name"/>
                <label for="name">Loại</label>

            </div>

            <div class="form-floating mt-3 mb-3">
                <input type="number" class="form-control" id="quantity" placeholder="Enter quantity" name="quantity" />
                <label for="phone">Số chỗ</label>

            </div>

            <div class="form-floating mt-3 mb-3">
                <input type="text" class="form-control" id="address" placeholder="Enter price" name="price" />
                <label for="price">Giá vé</label>

            </div>


        </div>

        <div class="col-md-7 col-12">
            <div class="form-floating mt-3 mb-3">
                <div class="d-flex justify-content-center mb-4">
                    <img id="selectedAvatar" src="https://mdbootstrap.com/img/Photos/Others/placeholder-avatar.jpg"
                          style="width: 200px; height: 200px; object-fit: cover;" alt="example placeholder" />
                </div>
                
                <input type="file" class="form-control" id="avatar"  onchange="displaySelectedImage(event, 'selectedAvatar')"/>
               

            </div>
        </div>
    </div>
    <button type="submit" class="btn btn-info mt-3 mb-3">Cập nhât</button>
    <button  class="btn btn-danger mt-3 mb-3 ">Xóa</button>

</form>


<script>
    function displaySelectedImage(event, elementId) {
        const selectedImage = document.getElementById(elementId);
        const fileInput = event.target;

        if (fileInput.files && fileInput.files[0]) {
            const reader = new FileReader();

            reader.onload = function (e) {
                selectedImage.src = e.target.result;
            };

            reader.readAsDataURL(fileInput.files[0]);
        }
    }

</script>