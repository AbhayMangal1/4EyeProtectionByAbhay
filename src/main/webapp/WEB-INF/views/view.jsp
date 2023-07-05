<%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>

        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
            <script src="jquey.js"></script>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">
        </head>

        <body>
        <a href="${pageContext.request.contextPath}/maker/showForm">Maker HomePage</a><br>
        <a href="${pageContext.request.contextPath}/logout">Logout</a><br>
        <h1>Maker View</h1>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">User Code</th>
                        <th scope="col">User Name</th>
                        <th scope="col">User Address</th>
                        <th scope="col">Active/Inactive Flag</th>
                        <th scope="col">Status</th>
                        <th scope="col">Delete</th>
                        <th scope="col">Modify</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${customerList}" var="item">
                        <tr>
                            <th scope="row"></th>
                            <td>
                                <a href="linkview?code=${item.getCustomerCode()}&status=${item.getRecordStatus()}"><c:out value="${item.getCustomerCode()}" /></a>
                            </td>
                            <td>
                                <c:out value="${item.getCustomerName()}" />
                            </td>
                            <td>
                                <c:out value="${item.getCustomerAddress1()}" />
                            </td>
                            <td>
                                <c:out value="${item.getFlag()}" />
                            </td>
                            <td>
                                <c:out value="${item.getRecordStatus()}" />
                            </td>
                            <td>
                                <a href="update?code=${item.getCustomerCode()}&status=${item.getRecordStatus()}&update=Delete"><c:out value="Delete" /></a>
                            </td>
                            <td>
                                <a href="update?code=${item.getCustomerCode()}&status=${item.getRecordStatus()}&update=Modify"><c:out value="Modify" /></a>
                            </td>

                        </tr>
                    </c:forEach>

                    <c:forEach items="${customerMasterList}" var="masteritem">
                        <tr>
                            <th scope="row"></th>
                            <td>
                                <a href="linkview?code=${masteritem.getCustomerCode()}&status=${masteritem.getRecordStatus()}"><c:out value="${masteritem.getCustomerCode()}" /></a>
                            </td>
                            <td>
                                <c:out value="${masteritem.getCustomerName()}" />
                            </td>
                            <td>
                                <c:out value="${masteritem.getCustomerAddress1()}" />
                            </td>
                            <td>
                                <c:out value="${masteritem.getFlag()}" />
                            </td>
                            <td>
                                <c:out value="${masteritem.getRecordStatus()}" />
                            </td>
                            <td>
                                <a href="update?code=${masteritem.getCustomerCode()}&status=${masteritem.getRecordStatus()}&update=Delete"><c:out value="Delete" /></a>
                            </td>
                            <td>
                                <a href="update?code=${masteritem.getCustomerCode()}&status=${masteritem.getRecordStatus()}&update=Modify"><c:out value="Modify" /></a>
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </body>

        </html>
