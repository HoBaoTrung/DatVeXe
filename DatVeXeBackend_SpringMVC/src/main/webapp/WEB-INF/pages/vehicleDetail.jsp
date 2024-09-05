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


<form:form method="post" modelAttribute="car"  enctype="multipart/form-data" >
    <form:hidden path="image" />
    <form:hidden path="id" />
    <div class="row">
        <div class="col"> 
            <div class="form-floating mb-3 mt-3">
                <label for="carNumber">Số xe</label>
                <form:input  path="carNumber" type="number" class="form-control" id="carNumber" placeholder="Enter car number" name="carNumber"/>
                <form:errors path="carNumber" element="div" cssClass="text-danger"/>
            </div>
            <div class="form-floating mb-3 mt-3">
                <label for="carNumber">Giá ghế</label>
                <form:input path="seatPrice" type="text" class="form-control" id="seatPrice" placeholder="Enter seat price" name="seatPrice"/>
                <form:errors path="seatPrice" element="div" cssClass="text-danger"/>
            </div>
            <div class="form-floating mb-3 mt-3">
                <label for="carNumber">Loại xe</label>
                <form:select path="typeId">

                    <c:forEach items="${types}" var="type">      
                        <c:choose>
                            <c:when test="${type.id == car.typeId.id}">
                                <option value="${type.id}" selected>${type.name}

                                </option>
                            </c:when>
                            <c:otherwise>
                                <option value="${type.id}">${type.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
            </div>

            <div class="form-floating mb-3 mt-3">
                <label for="carNumber">Loại ghế</label>
                <form:select path="typeSeatId">

                    <c:forEach items="${typeSeat}" var="type">      
                        <c:choose>
                            <c:when test="${type.id == car.typeSeatId.id}">
                                <option value="${type.id}" selected>${type.name}

                                </option>
                            </c:when>
                            <c:otherwise>
                                <option value="${type.id}">${type.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
            </div>
            <c:choose>
                <c:when test="${car.id==null}">
                    <button type="submit" class="btn btn-info mt-3 mb-3">Thêm</button>
                </c:when>
                <c:otherwise>
                    <c:url value="/api/deleteCar/${car.id}"  var="apiDel"/>
                    <button type="submit" class="btn btn-info mt-3 mb-3">Cập nhât</button>
                    <button onclick="deleteItem('${apiDel}', true)" class="btn btn-danger mt-3 mb-3">Xóa</button>
                </c:otherwise>
            </c:choose>
            
            
        </div>
        <div class="col">
            <div class="form-floating mt-3 mb-3">
                <div class="text text-danger">${errImage}</div>
                <input type="button" class="btn btn-primary"
                       value="Chọn ảnh xe"
                       onclick="document.getElementById('avatar').click();" />
                <form:input style="display: none;" type="file" class="form-control" id="avatar"  path="file" 
                            onchange="displaySelectedImage(event, 'selectedAvatar')"/>
                <div class="form-floating mb-3 mt-3">
                    <img id="selectedAvatar" class="rounded img-fluid" 
                         src="${car.image}"
                         width="50%"/>
                </div>

            </div>
        </div>

    </div>
</form:form>

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