<%@ page session="false" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<f:view>
<html>
<head>

<t:stylesheet path="/css/common.css"></t:stylesheet>
</head>
<body>

	<f:loadBundle basename="com.eni.docmin.resources.messages" var="msg" />

	<table id="titleTable">
		<tr>
			<td valign="top">
			<div id="title"><h:outputText
				value="#{msg.label_header_home_page}" /></div>
			<div id="subTitle"><h:outputText
				value="Errore" /></div>
			</td>
		</tr>
	</table>
	<br>
	<br>
</body>
</html>
</f:view>