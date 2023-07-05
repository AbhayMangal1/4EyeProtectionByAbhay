<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

        <a href="${pageContext.request.contextPath}/">HomePage</a>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">User Code</th>
                        <th scope="col">User Name</th>
                        <th scope="col">User Address</th>
                        <th scope="col">Block/Unblock Status</th>
                        <th scope="col">Active/Inactive Flag</th>
                        <th scope="col">Create Date</th>
                        <th scope="col">Created By</th>
                        <th scope="col">Modified Date</th>
                        <th scope="col">Modified By</th>
                        <th scope="col">Authorized Date</th>
                        <th scope="col">Authorized By</th>
                    </tr>
                </thead>
                <tbody>
                        <tr>
                            <th scope="row"></th>
                            <td>
                               <c:out value="${item.getCustomerCode()}" />
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
                                <c:out value="${item.createDate}" />
                            </td>

                            <td>
                                <c:out value="${item.createdBy}" />
                            </td>


                            <td>
                                <c:out value="${item.modifiedDate}" />
                            </td>


                            <td>
                                <c:out value="${item.modifiedBy}" />
                            </td>


                            <td>
                                <c:out value="${item.authorisedDate}" />
                            </td>


                            <td>
                                <c:out value="${item.authorisedBy}" />
                            </td>

                        </tr>

                </tbody>
            </table>
        </body>

        </html>
