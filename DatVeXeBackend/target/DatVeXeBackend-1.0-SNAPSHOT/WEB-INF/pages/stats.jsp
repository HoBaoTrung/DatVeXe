<%-- 
    Document   : stats
    Created on : May 6, 2024, 3:41:50 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center text-info mt-1">THỐNG KÊ , BÁO CÁO</h1>



<div class="row">

    <div class="col-md-5 col-12">
        <form>
            <div class="mb-3 mt-3">
                <label for="year" class="form-label">Chon nam:</label>

                <select class="form-select" id="period" name="yaer">
                    <option selected >2024</option>
                   
                    <%int number = 10;
                        for (int i = 1; i <= number; i++) {
                    %>
                   <option ><%=2024 - i%></option>
                        
                   
                    <%}%>

                </select>
            </div>
            <div class="form-floating mt-3">
                <label for="period" class="form-label">Chon thoi gian</label><br>
                <select class="form-select" id="period" name="period">
                    <option selected value="MONTH">Theo thang</option>
                    <option value="QUARTER">Theo quy</option>

                </select>

            </div>
            <div class="mt-3">
                <button class="btn btn-success mb-2" type="submit" >Loc</button>
            </div>
        </form>
        <div class="alert alert-info">
            <h4>Nam: ${param.year}</h4>
            <h4>Thoi gian: ${param.period}</h4>
        </div>
        <table class="table">
            <tr>

                <th>Thơì Gian</th>
                <th>
                    Doanh thu
                </th>
            </tr>
            <c:forEach items="${RevenueByPeriod}" var="p">
                <tr>
                    <td>${p[0]}</td>
                    <td>${p[1]} vnd</td>
                </tr>

            </c:forEach>
        </table>

    </div>
    <div class="col-md-7 col-12">
        <canvas id="myChart1"></canvas>

    </div>
</div>  


<br>
<div class="row">

    <div class="col-md-5 col-12">
        <table class="table">
            <tr>

                <th>Thơì Gian</th>
                <th>
                    So luong
                </th>
            </tr>
            <c:forEach items="${QuantityByPeriod}" var="p">
                <tr>
                    <td>${p[0]}</td>
                    <td>${p[1]} don</td>
                </tr>

            </c:forEach>
        </table>

    </div>
    <div class="col-md-7 col-12">
        <canvas id="myChart2"></canvas>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
    // bat su kien on load de xem no nap du lieu chua
    let label = [];
    let data = [];
    let label2 = [];
    let data2 = [];
    <c:forEach items="${RevenueByPeriod}" var="p">
    label.push('${p[0]}');
    data.push('${p[1]}');

    </c:forEach>
    <c:forEach items="${QuantityByPeriod}" var="p">
    label2.push(${p[0]});
    data2.push('${p[1]}');

    </c:forEach>
    function drawChartRevenue(ctx, label, data, title) {
        // const ctx = document.getElementById('myChart');

        new Chart(ctx, {
            type: 'bar',
            data: {
                labels: label,
                datasets: [{
                        label: title,
                        data: data,
                        borderWidth: 1,
                        backgroundColor: ['pink', 'yello', 'green', 'white', 'orange']
                    }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    }
    window.onload = function () {
        let ctx1 = document.getElementById("myChart1");
        let ctx2 = document.getElementById("myChart2");
        drawChartRevenue(ctx1, label, data, "DOANH THU");
        drawChartRevenue(ctx2, label2, data2, "SO LUONG Don");
    }
</script>