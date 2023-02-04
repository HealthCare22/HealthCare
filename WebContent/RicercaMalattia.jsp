
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,Beans.MMGBean"%>

<%@ page import = "Beans.MMGBean" %>
    
    
    <% String error_message = (String) request.getAttribute("error_message"); %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/ricercaMalattiaStyle.css">
    <title>Ricerca per sintomi</title>
    <script src = "./js/ricercaMalattiaScript.js"></script>
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
    

    <div class="containers">
    
		
        <div class="containerNome">
         
            <h1>Ricerca Malattia Rara</h1>
            <hr>
            <div>
            	<p><%=error_message %></p>
            </div>
            <form method="GET" action="RicercaPerNomeServlet">
            <div class="ricercaNome">
                <input type="text" name="nomeMalattia"id="nomeMalattia" placeholder="Nome Malattia">
            </div>
            
            <div class="cercaPerNomeButtonDiv">
                <button type="submit" id="cercaPerNomeButton">Cerca</button>
            </div>
            </form>
            
        </div>
  
        <div class="containerSintomi">
            <h1>Ricerca Malattia Rara</h1>
            <hr>
            <form method="get" action="RicercaPerSintomiServlet">
	            <div id="nomeSintomoContainer">
	                <input type="text" class="nomeSintomo" id="Sintomo1" name="Sintomo1" placeholder="Nome Sintomo">
	            </div>
	                <div class="buttons">
	                    <button type="button" id="rimuoviSintomoButton" onclick="removeSintomo()">Annulla</button>
	                    <button type ="button" id="aggiungiSintomoButton" onclick="addSintomo()">Aggiungi Sintomo</button>
	                    <button type = "submit" id="cercaPerSintomiButton">Cerca</button>
	                </div>
             </form>   
        </div>
    </div>
 
    
</body>
</html>