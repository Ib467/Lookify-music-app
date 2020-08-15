<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Top Ten Songs</h1>
    <div>
            <h1>Your Results</h1>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Rating</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${songs }" var="song">
                        <tr>
                            <td>
                                <c:out value="${song.title }" />
                            </td>
                            <td>
                                <c:out value="${song.rating }" />
                            </td>
                            <td>
                                <a href="/songs/${song.id}/delete">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <a href="/dashboard">Dashboard</a>
</body>
</html>