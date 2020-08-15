<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
 
 <link rel="stylesheet" href="static/css/styles.css" ></link>
 
 <title>Insert title here</title>
</head>
<body>

<h1>Edit A LANGUAGE</h1>
	<form:form action="/songs/${song.id}" method="POST" modelAttribute="song">
	    
	    <p>
	        <form:label path="name">Artist Name</form:label>
	        <form:errors path="name"/>
	        <form:input class="input" path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Title</form:label>
	        <form:errors path="creator"/>
	        <form:input class="input" path="creator"/>
	    </p>
	    <p>
	        <form:label path="version">Rating</form:label>
	        <form:errors path="version"/>
	        <form:input class="input" path="version"/>
	    </p>
	    
	    <input type="submit" value="Submit"/>
	</form:form>


</body>
</html>