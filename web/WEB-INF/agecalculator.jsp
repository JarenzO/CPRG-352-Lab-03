<%-- 
    Document   : agecalculator
    Created on : 3-Feb-2022, 6:18:51 PM
    Author     : Jaren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body {
                font-family: "Lucida Sans";
            }
        </style>
        <title>Calculators - Age</title>
    </head>
    <body>
        
        <h1>Age Calculator</h1>
        
        <form method="post" action="age">
        
          <div>
            <label>Enter your age: </label>
            <input type="text" name="age" value="${formage}">
          </div>
        
          <div>
            <br>
            <input type="submit" name="calcage" value="Age next birthday">
            <c:if test="${error == true}">
                <p>${errorfeedback}</p>
            </c:if>
             <c:if test="${age != null}">
                <p>Your age next birthday will be ${age.age + 1}</p>
            </c:if>   
                <br>
                <a href="http://localhost:8084/Calculators/arithmetic">Arithmetic Calculator</a>
          </div>
        
        </form>
        
    </body>
</html>
