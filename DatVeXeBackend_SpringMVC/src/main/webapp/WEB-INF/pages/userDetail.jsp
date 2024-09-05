

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">QUẢN LÝ USER</h1>


        <c:url value="/admin/userDetail/${user.id}" var="action" />
   
<form:form method="post" modelAttribute="user"  enctype="multipart/form-data">

    <form:hidden path="avatar" />
    <form:hidden path="createdAt" />
    <div class="form-floating mb-3 mt-3">
        <form:input path="lastName" type="text" class="form-control" id="lastname" placeholder="Enter lastname" name="lastname"/>
        <label for="lastname">Họ và tên lót</label>
        <form:errors path="lastName" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input path="firstName" type="text" class="form-control" id="firstname" placeholder="Enter firstname" name="firstname"/>
        <label for="firstname">Tên</label>
        <form:errors path="firstName" element="div" cssClass="text-danger"/>
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input type="phone" class="form-control" id="phone" placeholder="Enter phone" name="phone" path="phonenumber"/>
        <label for="phone">Phone</label>
        <form:errors path="phonenumber" element="div" cssClass="text-danger"/>
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
        <form:select class="form-select" id="role" path="roleId" name="rolelist">
            <c:forEach items="${roles}" var="r">
                <c:choose>
                    <c:when test="${r.id == user.roleId.id}">
                        <option value="${r.id}" selected>${r.userRole}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${r.id}">${r.userRole}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input type="file" class="form-control" id="avatar"  path="file" />
        <label for="avatar">Avatar</label>

    </div>


    <c:choose>
        <c:when test="${user.roleId.userRole == 'STAFF'}">
            <c:set var="labelText" value="Xác nhận nhân viên"/>
        </c:when>
        <c:when test="${user.roleId.userRole == 'USER'}">
            <c:set var="labelText" value="Xác nhận người dùng"/>
        </c:when>
        <c:otherwise>
            <c:set var="labelText" value=""/>
        </c:otherwise>
    </c:choose>

    <c:if test="${labelText != ''}">
        <div class="form-check">
            <form:checkbox 
                class="form-check-input" 
                id="active" 
                path="isActive"
                />
            <label for="active" class="form-check-label">${labelText}</label>
        </div>
    </c:if>


    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            Cập nhật
        </button>
    </div>
</form:form>


<c:url value="/api/deleteUser/${user.id}"  var="apiDel"/>
<button  class="btn btn-danger mt-3 mb-3" onclick="deleteItem('${apiDel}', true)">Xóa</button>
<c:if test="${err != null}">
    <script type="text/javascript">
//            Tải xong trang mới hiện alert
        document.addEventListener("DOMContentLoaded", function () {
            alert("${err}");
        });
    </script>
</c:if>
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