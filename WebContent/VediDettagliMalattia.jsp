<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DAO.UtilForm" %>
<%@ page import="Beans.GestioneFormBean" %>    

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
	
	
	    
		
		
		<div id="Dettaglio">
		
		
		
		<div id="Dettaglio1ariga">
			
			<div class="Info">
			<h3>Nome Malattia</h3>
			</div>
						
		
		</div>
		<div id="Dettaglio1ariga">
		
		
		
				
			<div class="Info2">
			<h3>Sintomi</h3>
			</div>
		
			
		
	    </div>
		
		
		<div id="Dettaglio1ariga">
		  <div class="Commento">
  					<h3>Descrizione malattia: Sopra la panca la capra campa, sotto la panca la capra crepa.
  					Sopra la panca la capra campa, sotto la panca la capra crepa. 
  					Sopra la panca la capra campa, sotto la panca la capra crepa
  					Sopra la panca la capra campa, sotto la panca la capra crepa.
  					Sopra la panca la capra campa, sotto la panca la capra crepa. 
  					Sopra la panca la capra campa, sotto la panca la capra crepa
  					</h3>
				</div>
		</div>

		</div>
</body>
</html>