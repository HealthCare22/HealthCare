<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="gestioneMalattie.GestioneMalattieBean"%>
<%@ page import="gestioneMalattie.SintomoBean"%>    
<%@ page import="java.util.*" %>

 
 <%List<GestioneMalattieBean>listaMalattie = (List<GestioneMalattieBean>) request.getAttribute("listaMalattie");%>
	    
		
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
		<div class="indietroButton">
			<button  id="indietro" onclick="history.back()">Indietro</button>
		</div>
        <h1>Dettagli Malattia </h1>
    </div>
	   
		<%if(listaMalattie.size()>0){
		for(GestioneMalattieBean m : listaMalattie){ %>
		<div id="Dettaglio">		
		<div id="Dettaglio1ariga">
			
			<div class="Info">
			<h3><strong>Nome Malattia:</strong> <%=m.getNome() %></h3>
			</div>
		</div>
		<div id="Dettaglio1ariga">
			<div class="Info2">
			<h3><b>Sintomi:</b></h3>
			<ul>
		<%for(SintomoBean s : m.getListaSintomi()){ %>
				<li>-<%= s.getNome() %></li>
	    <%} %>
	    </ul>
	    </div>
	    </div>
		<div id="Dettaglio1ariga">
		  <div class="Commento">
  					<h3><strong>Descrizione:</strong> <%=m.getDescrizione() %></h3>
				</div>
		</div>
		</div>
		<%}}else{ %>
				<div id = "nessunaMalattia">
					<p> <b>Non ci sono malattie che corrispondono ai parametri</b></p>
				</div>
		<%} %>
</body>
</html>