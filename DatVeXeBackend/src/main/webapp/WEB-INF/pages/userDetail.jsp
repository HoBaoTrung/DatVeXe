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

    <div class="form-floating mb-3 mt-3">
        <form:input path="lastname" type="text" class="form-control" id="lastname" placeholder="Enter lastname" name="lastname"/>
        <label for="lastname">Họ và tên lót</label>
        <form:errors path="firstname" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input path="firstname" type="text" class="form-control" id="firstname" placeholder="Enter firstname" name="firstname"/>
        <label for="firstname">Tên</label>
        <form:errors path="firstname" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input type="phone" class="form-control" id="phone" placeholder="Enter phone" name="phone" path="phone"/>
        <label for="phone">Phone</label>
        <form:errors path="phone" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" id="address" placeholder="Enter address" name="address" path="address"/>
        <label for="address">Địa chỉ</label>
        <form:errors path="address" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input path="email" type="email" class="form-control" id="email" placeholder="Enter email" name="email"/>
        <label for="email">Email</label>
        <form:errors path="email" element="div" cssClass="text-danger"/>
    </div>



    <div class="form-floating mt-3 mb-3">
        <form:input type="text" class="form-control" id="username" placeholder="Enter username" name="username" path="username"/>
        <label for="username">User name</label>
        <form:errors path="username" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd" path="password"/>
        <label for="pwd">Password</label>
        <form:errors path="password" element="div" cssClass="text-danger"/>
    </div>





    <div class="form-floating mt-3 mb-3">
        <form:input type="file" class="form-control" id="avatar"  path="file" />
        <label for="avatar">Avatar</label>

    </div>

      <c:choose>
          <c:when test="${shipper.active==true}">
              <div class="form-check">
                  <input class="form-check-input" type="checkbox" id="active" name="active" value="active" checked>
                  <label for="active" class="form-check-label">Xac nhan shipper</label>

            </div>

        </c:when>


        <c:otherwise>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="active" name="active" value="active" >
                <label for="active" class="form-check-label">Xac nhan shipper</label>

            </div>
        </c:otherwise>
    </c:choose>
    
    <div class="form-check">
        <input class="form-check-input" type="checkbox" id="active" name="active" value="active" checked>
        <label for="active" class="form-check-label">Active</label>

    </div>


    <button type="submit" class="btn btn-info mt-3 mb-3">Cập nhât</button>
    <button  class="btn btn-danger mt-3 mb-3">Xóa</button>
</form:form>
--%>
<form method="post" modelAttribute="user"  enctype="multipart/form-data">
    <div class="row">
        <div class="col-md-5 col-12">
            <div class="form-floating mb-3 mt-3">
                <input type="text" class="form-control" id="lastname" placeholder="Enter lastname" name="lastname"/>
                <label for="lastname">Họ và tên lót</label>

            </div>

            <div class="form-floating mb-3 mt-3">
                <input type="text" class="form-control" id="firstname" placeholder="Enter firstname" name="firstname"/>
                <label for="firstname">Tên</label>

            </div>

            <div class="form-floating mt-3 mb-3">
                <input type="phone" class="form-control" id="phone" placeholder="Enter phone" name="phone" />
                <label for="phone">Phone</label>

            </div>

            <div class="form-floating mt-3 mb-3">
                <input type="text" class="form-control" id="address" placeholder="Enter address" name="address" />
                <label for="address">Địa chỉ</label>

            </div>

            <div class="form-floating mt-3 mb-3">
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email"/>
                <label for="email">Email</label>

            </div>



            <div class="form-floating mt-3 mb-3">
                <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" />
                <label for="username">User name</label>

            </div>

            <div class="form-floating mt-3 mb-3">
                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd" />
                <label for="pwd">Password</label>

            </div>






            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="active" name="active" value="active" checked>
                <label for="active" class="form-check-label">Active</label>

            </div>
        </div>

        <div class="col-md-7 col-12">
            <div class="form-floating mt-3 mb-3">
                <div class="d-flex justify-content-center mb-4">
                    <img id="selectedAvatar" src="https://mdbootstrap.com/img/Photos/Others/placeholder-avatar.jpg"
                         class="rounded-circle" style="width: 200px; height: 200px; object-fit: cover;" alt="example placeholder" />
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