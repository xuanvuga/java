<%-- 
    Document   : auction
    Created on : Sep 1, 2022, 12:56:08 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<h1 class="text-center text-danger">SAN PHAM CAN GIAO HANG</h1>

<c:url value="/auction" var="action"/>
<form:form method="post" action="${action}" modelAttribute="auction"
           enctype="multipart/form-date">
    <div class="form-group">
        <label for="file">Anh san pham</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class ="form-group">
        <input type="submit" value="Them san pham" class ="btn-danger"/>
    </div>
    
</form:form>
