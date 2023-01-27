<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DAO.UtilForm" %>
<%@ page import="Beans.GestioneFormBean" %>    

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Dettagli del Form</title>
<link rel="stylesheet" href="./css/DettagliFormStyle.css">
</head>

<body>
	<jsp:include page="navbar.jsp"/>
	
	<div id="Titolo">
			<h1>Dettagli del Form</h1>
		</div>
		
		<%String idForm = (String)request.getParameter("id"); 
		GestioneFormBean form = UtilForm.getFormById(idForm);%>
		<div id="Dettaglio">
		
		<div id="Dettaglio1ariga">
			<div class="Info">
				<h3>Titolo: <%=form.getTitolo() %></h3>
			</div>
			<div class="Info">
				<h3>Topic: <%=form.getTopic() %></h3>
			</div>
			<div class="Info">
				<h3>Data Apertura: <%=form.getDataApertura() %></h3>
			</div>
		</div>
		
		<div id="Dettaglio2ariga">
			<div class="img">
                <img id="profilo"src="./images/sample.jpg" alt="Foto Profilo">
            </div>
            <div class="InfoProfilo">
				<h3>Autore: <%=form.getAutore() %></h3>
			</div>
			
		</div>
		
		<div id="Dettaglio3aRiga">
		  <div class="Commento">
  					<h3><%=form.getDescrizione() %></h3>
				</div>
		</div>
		<div id="Buttons">
			<h1>Stato:Aperto</h1>
			<button class="Button">Modifica</button>
			<button class="Button">Elimina</button>
			<button class="Button">Chiudi Form</button>
		</div>
		</div>
		
		<div class="interventi-container">
			<div class="intervento-MMG">
				<div class="img">
		                <img id="profilo"src="./images/sample.jpg" alt="Foto Profilo">
		        </div>
				<div class="InfoProfilo1">
					<h3></h3>
				</div>
			</div>
			
			<div class="text-intervento">
				<textarea id="descrizione" name="descrizione" rows="10" cols="50" placeholder="Descrizione" maxlength="800"></textarea>
			</div>
			<div class="intervento-button"> 
				<button class="Button">Pubblica</button>
			</div>
		</div>
		
</body>
</html>