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
		
		<div id="Dettaglio1ariga">
		  <div class="Commento">
  					<h3><%=form.getDescrizione() %></h3>
				</div>
		</div>
		</div>
</body>
</html>