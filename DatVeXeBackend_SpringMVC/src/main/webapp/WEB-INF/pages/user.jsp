

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">QUẢN LÝ USER</h1>

<br/>
<c:if test="${counter > 1}">
    <ul class="pagination mt-1">
        <li class="page-item"></li>
            <c:forEach begin="1" end="${counter}" var="i">
                <c:url value="/admin/user" var="pageUrl">
                    <c:param name="role" value="${param.role}"/>
                    <c:param name="page" value="${i}"></c:param>
                </c:url>
            <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
            </c:forEach>
    </ul>
</c:if>
<span>
    <c:url value="/admin/user" var="roleUrl">
        <c:param name="role" value="customer"/>

    </c:url>  
    <a href="${roleUrl}">
        <button class="btn btn-danger">Khách hàng</button>
    </a>
</span>

<span>
    <c:url value="/admin/user" var="roleUrl">
        <c:param name="role" value="staff"/>

    </c:url>
    <a href="${roleUrl}">
        <button class="btn btn-primary">Nhân viên</button>
    </a>
</span>

<table class="table table-striped mt-3">
    <tr>

        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Avatar</th>
        <th></th>
    </tr>
    <c:forEach items="${users}" var="u">
        <tr style="border-bottom: solid 1px black">


            <td>${u.id}</td>
            <td>${u.firstName} ${u.lastName}</td>
            <td>${u.phonenumber}</td>
            <td>${u.email}</td>
            <td><img class="rounded img-fluid" 
                     src="${u.avatar}"
                     width="45"/></td>

            <td>
                <c:url value="/api/deleteUser/${u.id}"  var="apiDel"/>
                <button class="btn btn-danger" onclick="deleteItem('${apiDel}')">Xóa</button>

                <a class="btn btn-info" href="<c:url value="/admin/userDetail/${u.id}"/>">Xem chi tiết</a>

            </td>

        </tr>
    </c:forEach>

</table>