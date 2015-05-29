<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/jsp/includes/staticFiles.jsp" %>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="query.window.title"/></title>
	<!--
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>	
	  -->
</head>
<body>
		<div>	
		<form:form id="queryForm" modelAttribute="queryCommand"  action="query.html" method="post">
		  	<fieldset class="fieldset">		
				<legend class="legend"><fmt:message key="query.database.legend.header"/></legend>
				<div class="form-item"> 
					<form:select path="database" cssErrorClass="form-error-field" >
						<form:options items="${queryCommand.indexes}" />
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
			<form:hidden path="hostname"/>
			<form:hidden path="port"/>
			<form:hidden path="dataSourceCode"/>
		</form:form>
		
		<fieldset>
			<c:if test="${queryCommand.result.totalHits != null}">
				<div> 
					<fmt:message key="query.output.rows.returned"/> <b><c:out value="${queryCommand.result.totalHits}"/></b>.		
				</div>			
			</c:if>		
		</fieldset>
		
		<fieldset class="fieldset">
			<legend class="legend"><fmt:message key="query.output.legend.header"/></legend>		
				<c:if test="${queryCommand.result.totalHits != null}">								
					<table id="tt" class="easyui-datagrid" style="width:1200px;height:300px">
						<thead><tr><th field="ROW_ID" width="100"></th>
						<c:forEach var="row" items="${queryCommand.result.rows}">
						   
						</c:forEach>
					</table>
				</c:if>
		</fieldset>			
	</div>
</body>
</html>