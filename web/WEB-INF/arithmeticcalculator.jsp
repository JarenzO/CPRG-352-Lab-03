<%-- 
    Document   : arithmeticcalculator
    Created on : 4-Feb-2022, 6:19:56 PM
    Author     : Jaren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculators - Arithmetic</title>
        <style>
            body {
                font-family: "Lucida Sans";
            }
        </style>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        
        <form method="post" action="arithmetic" return false;>
        
        <div>
            <label>First:</label>
            <input type="text" name="${formfirstterm}">
            <br>
            <label>Second:</label>
            <input type="text" name="${formsecondterm}">
        </div>
        <div>
            <input type="submit" name="${operation}" value="+">
            <input type="submit" name="${operation}" value="-">
            <input type="submit" name="${operation}" value="*">
            <input type="submit" name="${operation}" value="%">
        </div>
        <div>
            <p>Result: <c:if test="${empty formfirstterm || empty formsecondterm}">---</c:if> 
                <c:if test="${ !(empty formfirstterm || empty formsecondterm) && error != true }">${calculation.result}</c:if>
                <c:if test="${error == true}">invalid</c:if> 
            </p>
            <a href="http://localhost:8084/Calculators/age">Age Calculator</a>
        </div>
            
        </form>
            
    </body>
</html>
