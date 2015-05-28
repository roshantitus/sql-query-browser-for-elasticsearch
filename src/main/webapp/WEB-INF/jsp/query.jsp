<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/jsp/includes/staticFiles.jsp" %>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="query.window.title"/></title>
</head>
<body>
		<div>	
		<form:form id="queryForm" modelAttribute="queryCommand" action="query.html" method="post">
		  	<fieldset class="fieldset">		
				<legend class="legend"><fmt:message key="query.database.legend.header"/></legend>
				<div class="form-item"> 
					<form:select path="database" cssErrorClass="form-error-field">
						<form:option value="NONE" label="Select database:" />
						<form:options items="${queryCommand.indexes}"/>
	                </form:select>	
	                <div class="form-item"><form:errors path="database" cssClass="form-error-message" /></div>		
				</div>	
			</fieldset>		
		  	<fieldset class="fieldset">		
				<legend class="legend"><fmt:message key="query.query.legend.header"/></legend>
				<div class="form-item"> 
					<form:textarea path="query" rows="5" cols="150" cssErrorClass="form-error-field"/> 
					<div class="form-error-message"><form:errors path="query" /></div>			
				</div>
				<div class="form-item"> 
					<input type="submit" value="<fmt:message key="query.submit.button.label"/>" onclick="setFormAction('query.html')" />
				</div>
			</fieldset>
		</form:form>
	</div>
</body>
</html>