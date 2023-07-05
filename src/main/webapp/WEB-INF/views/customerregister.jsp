<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>Customer Registration</title>

        <style>
            .error {
                color: red;
            }
        </style>

</head>
<body>
<a href="${pageContext.request.contextPath}/">HomePage</a><br>
<a href="${pageContext.request.contextPath}/logout">Logout</a><br>

        <div class="container d-flex justify-content-end">
        <span>
        <form method="post" action="uploadFile" enctype="multipart/form-data">
        <input type="file" name="file" />
        <input type="submit" value="Upload File" />
        </form>
        </span>
        </div>
        <br>

<div class="container">
<h1> Maker Page </h1>
<i>Fill out the form. Asterisk (*) means required.</i><br><br>

<form:form action="userformsubmit" modelAttribute="customer">

Customer Code:  <form:input path="customerCode" />
<form:errors path="customerCode" cssClass="error" /> <br><br>


Customer Name (*):  <form:input path="customerName" />
<form:errors path="customerName" cssClass="error" /> <br><br>

Customer Address 1 (*):  <form:input path="customerAddress1" />
<form:errors path="customerAddress1" cssClass="error" /> <br><br>

Customer Address 2:  <form:input path="customerAddress2" />
<form:errors path="customerAddress2" cssClass="error" /> <br><br>

Customer Pin Code (*):  <form:input path="customerPinCode" />
<form:errors path="customerPinCode" cssClass="error" /> <br><br>


Customer Email Address (*):  <form:input path="emailAddress" />
<form:errors path="emailAddress" cssClass="error" /> <br><br>

Customer Contact Number (*):  <form:input path="contactNumber" />
<form:errors path="contactNumber" cssClass="error" /> <br><br>

Primary Contact Person:  <form:input path="primaryContactPerson" /><br><br>
Flag : <form:select path="flag">
       <form:option value="A"></form:option>
       <form:option value="I"></form:option>
       </form:select> <br><br>

<input type="submit" value="Register" name="add">
</form:form>
</div>

<form:form action="userformview" modelAttribute="customerview">
<input type="submit" value="View All Data" name="View">
</form:form>



</body>
</html>