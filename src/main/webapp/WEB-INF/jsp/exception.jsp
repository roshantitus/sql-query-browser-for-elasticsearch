<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<jsp:include page="includes/staticFiles.jsp"/>

<body>
<div class="container">
    <jsp:include page="includes/bodyHeader.jsp"/>

    <h2>Something happened...</h2>

    <p>${exception.message}</p>

    Exception: ${exception.message}.
		  	<c:forEach items="${exception.stackTrace}" var="stackTrace"> 
				${stackTrace} 
			</c:forEach>


    <jsp:include page="includes/footer.jsp"/>

</div>
</body>

</html>
