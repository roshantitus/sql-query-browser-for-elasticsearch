<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/jsp/includes/staticFiles.jsp" %>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title><fmt:message key="title"/></title>
    <style>  
        .fieldset { background-color: #FFF; } 
    	.legend { color:green; font-weight: bold; background-color: #99C68E; }  
        .form-item { margin: 20px 0; }  
        .form-label { font-weight: bold; }  
        .form-error-field { background-color: #FFC; }  
        .form-error-message { color: red; }      
    </style> 
	<script type="text/javascript">
		function setFormAction(action) 
		{
			queryForm.action = action;
		}		
	</script>    
</head>
           
<body>
<div class="container">
    <jsp:include page="includes/bodyHeader.jsp"/>
    <h2><fmt:message key="welcome"/></h2>
    <form:form id="connectionForm" modelAttribute="connection" method="post">
    	<fieldset class="fieldset">	
			<div class="form-item"> 
				<form:label	for="dataSourceCode" path="dataSourceCode" cssClass="form-item"><fmt:message key="datasource.legend.header"/></form:label>
				<form:select path="dataSourceCode" items="${datasourceList}" cssErrorClass="form-error-field"/>
	               <div class="form-item"><form:errors path="dataSourceCode" cssClass="form-error-message" /></div>		
			</div>	
			<div class="form-item"> 
				<form:label	for="dataSourceCode" path="dataSourceCode" cssClass="form-item"><fmt:message key="hostname.legend.header"/></form:label>
				<form:input path="hostname" rows="5" cols="50" cssErrorClass="form-error-field"/> 
				<div class="form-error-message"><form:errors path="hostname" /></div>			
			</div>		    			
			<div class="form-item"> 
				<form:label	for="dataSourceCode" path="dataSourceCode" cssClass="form-item"><fmt:message key="port.legend.header"/></form:label>
				<form:input path="port" rows="5" cols="10" cssErrorClass="form-error-field"/> 
				<div class="form-error-message"><form:errors path="port" /></div>			
			</div>		    					
			<div class="form-item"> 
				<input type="submit" value="<fmt:message key="submit.button.label"/>" />
			</div>
		</fieldset>
	</form:form>
    <jsp:include page="includes/footer.jsp"/>

</div>
</body>

</html>