<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Beans.GestioneMalattieBean" %>
<%@ page import="DAO.UtilRicerca" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Elenco malattie rare</title>
<link rel="stylesheet" href="./css/listaMalattieStyle.css">
</head>

<body>
	<jsp:include page="navbar.jsp"/>
	
	<div id="Titolo">
			<h1>Elenco delle malattie rare</h1>
	</div>

		<%List<GestioneMalattieBean>listaMalattie = UtilRicerca.getMalattie(); %>

		<div id = "elencoMalattie">
		<%for(GestioneMalattieBean m : listaMalattie){ %>
		<div id="malattiaContainer">
            <div class="elenco">
             <h3> <%= m.getNome().toUpperCase() %></h3>
            </div>
            <div>
            	<form action="RicercaPerNomeServlet" method="get">
					<button class = "ButtonVediForm" name="nomeMalattia" value=<%=m.getNome() %>>Vedi Dettagli</button>
				</form>
			</div>
		</div> <%}%>
		</div>
