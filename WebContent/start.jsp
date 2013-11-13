<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<html>
<head>
<%
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma", "noCache");
	if (request.getProtocol().equals("HTTP/1.1")) {
		response.setHeader("Cache-Control", "no-cache");
	}
%>
<title>DocMin</title>
<link rel=stylesheet type="text/css" href="css/common.css">
<script language="javascript">

</script>
</head>
<body>
<f:view>
	<f:loadBundle basename="com.eni.docmin.resources.messages" var="msg" />

	<div id="titleBar">

		<div id="titleTable">
			<div id="title">
				<h:outputText
					value="#{msg.label_estero_header_sistema_doc}" />
			</div>
			<div id="user"><h:outputText
					value="#{msg.label_header_user}: user-name.. " /><br/>
				<h:outputText
					value="#{startBean.testConn}" />
			</div>
		</div>
	</div>
	
	<div id="contents">

	
	<h:panelGrid columns="2"
		cellpadding="0"
		rowClasses="gRow">
		<h:form id="mainForm">
		<h:panelGrid columns="1">

			panel-grid 
			
		</h:panelGrid>
		</h:form>
		
		<t:graphicImage 
			url="/images/default.jpg" 
			width="890px" 
			height="592px"
			hspace="40"
			vspace="2"></t:graphicImage>
	</h:panelGrid>
	</div>
</f:view>
</body>
</html>