<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="./css/FormNavbar.css">
		<script src="./js/FormNavbarScript"></script>
		
	</head>
	<body>
		<div class="operazioni">
        <ul>
            <li><a href="MyForm.jsp"><button id="MyForms" class="disattivo" onclick="attivaMyForm()">I miei form</button></li></a>
            <li><a href="AperturaForm.jsp"><button id="NewForm" class="disattivo" onclick="attivaNuovoForm()">Nuovo Form</button></li></a>
            <li><a href="CercaForm.jsp"><button id="SearchForm" class="disattivo" onclick="attivaEsploraForm()">Cerca un form</button></li></a>
            <li><a href="VisualizzaInterventiPersonaliServlet"><button id="Comments" class="disattivo" onclick="attivaInterventi()">Interventi</button></li></a>
        </ul>   
    </div>
	</body>
</html>