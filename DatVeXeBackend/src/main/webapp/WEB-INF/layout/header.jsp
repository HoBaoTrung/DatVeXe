<%-- 
    Document   : header
    Created on : Apr 11, 2024, 1:41:19 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/"/>">
            <img src="https://hapotravel.com/wp-content/uploads/2023/04/tong-hop-25-mau-logo-hoa-sen-dep-va-y-nghia_1.jpg"
                 alt="Logo" style="width:40px;">
            Quản lý vé xe
        </a>


        <form class="d-flex">

            <%--  <c:choose>
                 <c:when test="${pageContext.request.userPrincipal.name != null}">
                     <a class="btn btn-info m-1" href="<c:url value="/"/>">${pageContext.request.userPrincipal.name}</a>
                     <a href="<c:url value="/logout"/>">
                     <button  type="button" class="btn btn-primary m-1">Logout</button>
                     </a>
                 </c:when>
                 
             </c:choose> --%>
            <a href="<c:url value="/logout" />"
            <button  type="button" class="btn btn-primary m-1">Logout</button>
            </a>
        </form>
    </div>
</nav>
