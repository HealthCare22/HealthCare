<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Beans.GestioneMalattieBean"%>    

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Dettagli della malattia</title>
<link rel="stylesheet" href="./css/DettagliMalattia.css">
</head>

<body>
	<jsp:include page="navbar.jsp"/>
	
	<div class="heading">
        <h1>Tipo di ricerca: </h1>
    </div>
    <div class="selector">
        <button id="perNome" onclick="goToNome()">per nome</button>
        <button id="perSintomi" onclick="goToSintomi()">per sintomi</button>
    </div>
	
	
	    <%List<GestioneMalattieBean>listaMalattie = (List<GestioneMalattieBean>) request.getAttribute("listaMalattia"); 
	    %>
		
		<%for(GestioneMalattieBean m : listaMalattie){ %>
		<div id="Dettaglio">		
		<div id="Dettaglio1ariga">
			
			<div class="Info">
			<h3><strong>Nome Malattia:</strong> <%=m.getNome() %></h3>
			</div>
		</div>
		<div id="Dettaglio1ariga">
			<div class="Info2">
			<h3>Sintomi</h3>
			</div>
	    </div>
		<div id="Dettaglio1ariga">
		  <div class="Commento">
  					<h3><strong>Descrizione:</strong> <%=m.getDescrizione() %></h3>
				</div>
		</div>
		</div>
		<%} %>
</body>
</html>