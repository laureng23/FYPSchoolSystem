<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Subject List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
    <div class="generic-container">
        <%@include file="authheader.jsp" %> 
        <%@include file="sideNav.jsp" %>    
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Subjects </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        
                        <th>Title</th>
                      
                        
                        <sec:authorize access="hasRole('ADMIN') or hasRole('TEACHER')">
                            <th width="100"></th>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <th width="100"></th>
                        </sec:authorize>
                         
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${subjects}" var="subject">
                    <tr>
                        
                        <td>${subject.title}</td>
                     
                        <sec:authorize access="hasRole('ADMIN') or hasRole('TEACHER')">
                            <td><a href="<c:url value='/edit-subject-${subject.title}' />" class="btn btn-success custom-width">edit</a></td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <td><a href="<c:url value='/delete-subject-${subject.title}' />" class="btn btn-danger custom-width">delete</a></td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <sec:authorize access="hasRole('ADMIN')">
            <div class="well">
               
            </div>
        </sec:authorize>
    </div>
</body>
</html>