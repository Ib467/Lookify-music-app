<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
 
 <link rel="stylesheet" href="../css/styles.css" ></link>
 
 <title>Insert title here</title>
 
 <style>
 body{
    width: 34%;
    margin: auto;
    max-width: 50%;
}

h1{
color: black;
font-size: 2.5em;
} 
 </style>
</head>
<body>

<h1>Edit a New Song</h1>


	<form:form action="/update-songs/${id}" method="POST" modelAttribute="song">
	    <p>
	        <form:label path="title">Title</form:label>
	        <form:errors path="title"/>
	        <form:input class="input" value="${song.title}" path="title"/>
	    </p>
	    
	    <p>
	        <form:label path="name">Artist Name</form:label>
	        <form:errors path="name"/>
	        <form:input class="input" path="name"/>
	    </p>
	    
	    <form:select path="rating"  class="select">
					<form:option value="1">1</form:option>
					<form:option value="2">2</form:option>
					<form:option value="3">3</form:option>
					<form:option value="4">4</form:option>
					<form:option value="5">5</form:option>
					<form:option value="6">6</form:option>
					<form:option value="7">7</form:option>
					<form:option value="8">8</form:option>
					<form:option value="9">9</form:option>
					<form:option value="10">10</form:option>
				</form:select>
				<form:errors path="rating" />
		<hr/>
			    <form:select path="star"  class="select">
					<form:option value="1">1</form:option>
					<form:option value="2">2</form:option>
					<form:option value="3">3</form:option>
					<form:option value="4">4</form:option>
					<form:option value="5">5</form:option>
					<form:option value="6">6</form:option>
					<form:option value="7">7</form:option>
					<form:option value="8">8</form:option>
					<form:option value="9">9</form:option>
					<form:option value="10">10</form:option>
				</form:select>
				<form:errors path="star" />
		<hr/>
	    <input type="submit" value="Submit"/>
	</form:form>


</body>
</html>