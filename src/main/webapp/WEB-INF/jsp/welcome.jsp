<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html lang="en">

<jsp:include page="includes/staticFiles.jsp"/>

<body>
<div class="container">
    <jsp:include page="includes/bodyHeader.jsp"/>
    <h2><fmt:message key="welcome"/></h2>

    <jsp:include page="includes/footer.jsp"/>

</div>
</body>

</html>