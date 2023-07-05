<%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>

        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
            <script src="jquery.js"></script>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">
        </head>

        <body>
        <a href="redirect:/logout">Logout</a><br>
        <a href="${pageContext.request.contextPath}/">HomePage</a><br>


        <h1>Checker Page</h1>


        <a href = "viewMasterData">View Master Table Data</a>


            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">User Code</th>
                        <th scope="col">User Name</th>
                        <th scope="col">User Address</th>
                        <th scope="col">Record Status</th>
                        <th scope="col">Active/Inactive Flag</th>
                        <th scope="col">Approve</th>
                        <th scope="col">Reject</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${customerList}" var="item">
                        <tr>
                            <th scope="row"></th>
                            <td>
                                <a href="linkview?code=${item.getCustomerCode()}"><c:out value="${item.getCustomerCode()}" /></a>
                            </td>
                            <td>
                                <c:out value="${item.getCustomerName()}" />
                            </td>
                            <td>
                                <c:out value="${item.getCustomerAddress1()}" />
                            </td>
                            <td>
                                <c:out value="${item.getRecordStatus()}" />
                            </td>
                            <td>
                                <c:out value="${item.getFlag()}" />
                            </td>
                            <td>
                                <a href="approve?code=${item.getCustomerCode()}&status=${item.getRecordStatus()}"><c:out value="approve" /></a>
                            </td>
                            <td>
                                <a href="reject?code=${item.getCustomerCode()}&status=${item.getRecordStatus()}"><c:out value="reject" /></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </body>

        </html>
