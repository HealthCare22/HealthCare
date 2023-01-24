<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="Beans.GestioneFormBean" %>
<%@ page import="DAO.UtilForm" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Form</title>
		<link rel="stylesheet" href="./css/MyFormStyle.css">
	</head>
	<body>
		<jsp:include page="navbar.html"/>
		<div id ="FormNavbar">
			<jsp:include page="FormNavbar.jsp"/>
		</div>
		<div id="OpenedClosedForms">
		<form method="get" action="myFormServlet">
			<button type="submit" id="OpenedFormButton" name="status" value="true">Aperti</button>
			<button type="submit" id="ClosedFormButton" name="status" value="false">Chiusi</button>
		</form>	
		</div>
		<div id="Forms">
			<table>
			<%!List<GestioneFormBean>listaForm = new ArrayList<>();%>
			<%listaForm = (List<GestioneFormBean>) request.getAttribute("listaForm");
			if(listaForm==null){
				listaForm = UtilForm.getFormByStatus("true");
			}%>
			<%for(GestioneFormBean f : listaForm){
					%><tr>
						<td><%=f.getTopic() %></td>
						<td><%=f.getTitolo() %></td>
						<td><%=f.getDataApertura() %></td>
						<td>YAY</td>
					</tr>					
				<%} %>
			</table>
		</div>
	</body>
</html>