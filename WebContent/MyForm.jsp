<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="Beans.GestioneFormBean" %>
<%@ page import="DAO.UtilForm" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Form</title>
		<link rel="stylesheet" href="./css/MyFormStyle.css">
		<script src="./js/myFormScript.js"></script>
	</head>
	<body onload="attivaMyForm()">
		<jsp:include page="navbar.jsp"/>
		
			<div id ="FormNavbar">
				<jsp:include page="FormNavbar.jsp"/>
			</div>
			<div id="OpenedClosedForms">
				<button id="OpenedFormButton" onclick="toOpenedForms()">Aperti</button>
				<button id="ClosedFormButton" onclick="toClosedForms()">Chiusi</button>
			</div>
		<div id="Forms">
			<div id="OpenedForms">
				<table>
				
				<!-- get the user's email from the HttpSession -->
				<% String email = (String)session.getAttribute("email");
				
				//call the GetFormByStatus to obtain all the user's forms
				List<List<GestioneFormBean>> listaForm = UtilForm.getFormByStatus(email);
				
				//list of open forms
				List<GestioneFormBean>listaFormAperti = listaForm.get(0);
				
				//list of closed forms
				List<GestioneFormBean>listaFormChiusi = listaForm.get(1);
				if(listaForm != null){
				for(GestioneFormBean f : listaFormAperti){%>
					<tr>
						<td><%= f.getTopic() %></td>
						<td><%= f.getTitolo() %></td>
						<td><%= f.getDataApertura() %></td>
						<td><form method = "get" action="DettaglioFormServlet"> 
						<button type="submit" name="id" value =<%=f.getIdform() %> class = "DettagliButton">
						Vedi dettagli</button></form></td>
					</tr>
				<%} %>
				</table>
			</div>
			<div id="ClosedForms">
				<table>
					<%for(GestioneFormBean f : listaFormChiusi){%>
					<tr>
						<td><%= f.getTopic() %></td>
						<td><%= f.getTitolo() %></td>
						<td><%= f.getDataApertura() %></td>
						<td><form method = "get" action="DettaglioFormServlet">  
						<button type="submit" name="id" value =<%=f.getIdform() %> class = "DettagliButton">
						Vedi dettagli</button></form></td>
					</tr>
				<%}} %>
				</table>
			</div>
		</div>
	</body>
</html>