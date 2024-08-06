<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" 
           uri="http://tiles.apache.org/tags-tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="bootstrap.min.css" />
        <title><tiles:insertAttribute name="title" /></title>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" 
              integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" 
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
        <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
        <script src="https://npmcdn.com/flatpickr/dist/flatpickr.min.js"></script>
        <script src="https://npmcdn.com/flatpickr/dist/l10n/ru.js"></script>

    </head>
    <body>   
        <tiles:insertAttribute name="header" />  
        <br>
        <div class="row">
            <div class="col-md-2 col-12">
                <nav class="navbar  bg-dark navbar-dark">


                    <ul class="navbar-nav">
                        <li class="nav-item">

                            <a class="nav-link" href="<c:url value="/admin/"/>">
                                <i class="fas fa-user"></i>
                                Quản lý người dùng</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/vehicle"/>">
                                <i class="fas fa-bus"></i>
                                Quản lý xe</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/types"/>">
                                <i class="fas fa-bus-alt"></i>
                                Quản lý loại xe</a>
                        </li> 
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/route"/>">
                                <i class="fas fa-route"></i>
                                Quản lý tuyến xe</a>
                        </li> 
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/trip"/>">
                                <i class="far fa-map"></i>
                                Quản lý chuyến xe</a>
                        </li> 
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/order"/>">
                                <i class="fas fa-ticket-alt"></i>
                                Quản lý vé xe</a>
                        </li> 
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/stats"/>">
                                <i class="fas fa-stream"></i>
                                Thống kê</a>
                        </li> 
                    </ul>

                </nav>
            </div>
            <div class="col-md-10 col-12">
                <tiles:insertAttribute name="content" />    
            </div>
        </div>
        <tiles:insertAttribute name="footer" />
    </body>
</html>