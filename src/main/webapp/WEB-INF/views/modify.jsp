<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Customer Registration</title>

</head>
<body>

<a href="${pageContext.request.contextPath}/">HomePage</a>
<a href="${pageContext.request.contextPath}/maker/showForm">Maker HomePage 2</a>
<div class="container">

<h1> Modify Data </h1>
<form:form action="userformupdate" modelAttribute="customerTemp">


Customer Code: <form:input path="customerCode" readonly="true"/><br><br>
Record Status: <form:input path="recordStatus" readonly="true"/><br><br>
Create Date: <form:input path="createDate" readonly="true"/><br><br>
Created By: <form:input path="createdBy" readonly="true"/><br><br>
Customer Name:  <form:input path="customerName" /><br><br>
Customer Address 1:  <form:input path="customerAddress1" /><br><br>
Customer Address 2:  <form:input path="customerAddress2" /><br><br>
Customer Pin Code:  <form:input path="customerPinCode" /><br><br>
Customer Email Address:  <form:input path="emailAddress" /><br><br>
Customer Contact Number:  <form:input path="contactNumber" /><br><br>
Primary Contact Person:  <form:input path="primaryContactPerson" /><br><br>
Flag : <form:select path="flag">
       <form:option value="Active"></form:option>
       <form:option value="Inactive"></form:option>
       </form:select> <br><br>

<input type="submit" value="Modify" name="Update">
</form:form>
</div>


</body>
</html>