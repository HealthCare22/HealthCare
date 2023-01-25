<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Form</title>
		<link rel="stylesheet" href="./css/MyFormStyle.css">
		<script src="./js/myFormScript.js"></script>
	</head>
	<body onload="attivaMyForm()">
		<jsp:include page="navbar.html"/>
		
			<div id ="FormNavbar">
				<jsp:include page="FormNavbar.jsp"/>
			</div>
		
			<div id="OpenedClosedForms">
				<button id="OpenedFormButton" onclick="toOpenedForms()">Aperti</button>
				<button id="ClosedFormButton" onclick="toClosedForms()">Chiusi</button>
			</div>
			<div id="OpenedForms">
				<table>
					<tr>
						<td>TOPIC</td>
						<td>TITOLO</td>
						<td>dd/MM/yyyy</td>
						<td><button class = "DettagliButton">Vedi dettagli</button></td>
					</tr>
					<tr>
						<td>TOPIC</td>
						<td>TITOLO</td>
						<td>dd/MM/yyyy</td>
						<td><button class = "DettagliButton">Vedi dettagli</button></td>
					</tr>
				</table>
			</div>
			
			<div id="ClosedForms">
				<table>
					<tr>
						<td>TOPIC</td>
						<td>TITOLO</td>
						<td>dd/MM/yyyy</td>
						<td><button class = "DettagliButton">Vedi dettagli</button></td>
					</tr>
					<tr>
						<td>TOPIC</td>
						<td>TITOLO</td>
						<td>dd/MM/yyyy</td>
						<td><button class = "DettagliButton">Vedi dettagli</button></td>
					</tr>
				</table>
			</div>
	</body>
</html>