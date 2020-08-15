<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
<!-- <link rel="stylesheet" href="../CSS/styles.css"> -->

<style>
body{
font-size: 1.5em;
margin-left: 20x
}

h1{
color: black;}

</style>
</head>
<body class="container dashboard">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
 
 
 <h1><a href="/songs/new">Add New Song</a></h1>
  <h1><a href="/songs/topten">Top Ten</a></h1>
	<div> 
		<h1> Song by artist: </h1>
	<form:form action="/search" method="get" modelAttribute="song">
	
			<form:label path="name">Name</form:label>
	        <form:input path="name"/>
	       <button>Submit</button>
	</form:form>
			
	</div>
 
 
 <div><h1>All Songs</h1></div>

<table class="">
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
            <td><a href="/songs/${song.id}"> <c:out value="${song.title}"/>  </a></td>
            <td><c:out value="${song.rating}"/></td>
           <td><a href="/songs/${song.id}/delete">Delete </a></td>
           
                            
        </tr>
        </c:forEach>
    </tbody>
</table>
<!-- <a href="/books/new">New Book</a> -->


	
	<%-- <form:form action="/songs" method="POST" modelAttribute="song">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Creator</form:label>
	        <form:errors path="creator"/>
	        <form:input path="creator"/>
	    </p>
	    <p>
	        <form:label path="version">Version</form:label>
	        <form:errors path="version"/>
	        <form:input path="version"/>
	    </p>
	    
	    <input type="submit" value="Submit"/>
	</form:form> --%>



</body>
</html>