<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 19-04-2024
  Time: 02:18 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View All by Limit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<% response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    if (session.getAttribute("username") != null) { %>
<nav class="navbar navbar-expand-lg" style="background:linear-gradient(90deg,greenyellow,yellow,greenyellow);">
    <div class="container-fluid">
        <a class="navbar-brand text-danger display-6 text-uppercase" style="font-weight: bold;" href="#">MyBank Transaction</a>
        <a class="navbar-toggler bg-light" type="a" data-bs-toggle="collapse" data-bs-target="#myBankMenu">
            <span class="navbar-toggler-icon"></span>
        </a>
        <div class="collapse navbar-collapse" id="myBankMenu">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <p class="text-light display-6">Hi, <%=session.getAttribute("username")%>
                    </p>
                </li>
                <li class="nav-item">
                    <a href="view" class="btn btn-outline-light rounded-5 me-2"><span class="bi bi-list-columns"></span>
                        View all transaction</a>
                </li>
                <li class="nav-item">
                    <a href="viewTransactions.jsp" class="btn btn-outline-white rounded-5 me-2"
                       style="font-weight: bolder"><span class="bi bi-list-columns"></span> Filter by type and User</a>
                </li>
                <li class="nav-item">
                    <a href="Creationt.jsp" class="btn btn-outline-light rounded-5 me-2"><span
                            class="bi bi-cloud-plus-fill"></span> Add transaction</a>
                </li>
                <li class="nav-item">
                    <a href="logout" class="btn btn-outline-light rounded-5 me-2"><span class="bi bi-door-open"></span>
                        Logout</a>
                </li>

            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <form action="viewTransactions.jsp">
        <input type="text" name="username"/>
        <input type="text" name="type"/>
        <input type="submit" value="filter">
    </form>

</div>


<%@ taglib prefix="sqlJstl" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="coreJstl" uri="http://java.sun.com/jsp/jstl/core" %>
<sqlJstl:setDataSource var="driverSource" driver="oracle.jdbc.driver.OracleDriver"
                       url="jdbc:oracle:thin:@localhost:1521:xe"
                       user="system"
                       password="102002"
/>
<sqlJstl:query var="typeAndUser" dataSource="${driverSource}"
               sql="select * from TRANSACTIONHISTORY where nameuser=? and transaction_type = ?">
    <sqlJstl:param value="${param['username']}"/>
    <sqlJstl:param value="${param['type']}"/>
</sqlJstl:query>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-4 col-md-8 col-12 table-responsive p-5 shadow-lg">
            <table class="table table-striped text-nowrap">
                <thead>
                <tr>
                    <th>Credit card number</th>
                    <th>Credit card holder</th>
                    <th>Credit card limit</th>
                    <th>Credit card available</th>
                </tr>
                </thead>
                <tbody>
                <coreJstl:forEach items="${typeAndUser.rows}" var="data">
                    <tr>
                        <td>${data.NAMEUSER}</td>
                        <td>${data.TRANSACTION_TYPE}</td>
                        <td>${data.AMOUNT}</td>
                        <td>${data.TRANSACTION_DATE}</td>
                    </tr>
                </coreJstl:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<% } else {
    response.sendRedirect("index.jsp");
}%>
</body>
</html>
