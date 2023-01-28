<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DAO.FormDAO" %>
<%@ page import="Beans.GestioneFormBean" %>
<%@ page import="com.mongodb.client.MongoClient" %>


<%

	Collection<?> allInterventi = (Collection<?>) request.getAttribute("listaInterventi"); 	
	String idForm = (String)request.getParameter("id");
	MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
	FormDAO formDAO = new FormDAO(mongoClient);

%>

	

<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,Beans.GestioneInterventiBean"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Dettagli del Form</title>
<link rel="stylesheet" href="./css/DettagliFormStyle.css">
</head>

<body>
	<jsp:include page="navbar.jsp"/>
	
	
	<% GestioneFormBean form = formDAO.getFormById(idForm); %>
	<div id="Titolo">
			<h1>Dettagli del Form</h1>
		</div>
		
		
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
		
 <% 
  if(allInterventi != null && allInterventi.size() != 0){
		Iterator<?> it = allInterventi.iterator();
		while (it.hasNext()) {
			GestioneInterventiBean bean = (GestioneInterventiBean) it.next();

%>
		<div>
			<table>
				<tr><%=bean.getEmail_medico() %></tr>
				<tr><%=bean.getDescrizione()%></tr>
				
			</table>
		
		
		</div>
		
		
<%
		}
  }
	 else {
%>

	<p>No interventi available</p>

<%
	}
	
%>


		<%
			HttpSession sessione = request.getSession();
			sessione.setAttribute("id_form", idForm);
		%>

	<form method="GET" action="InserimentoInterventoServlet">
		<div class="interventi-container">
			<div class="intervento-MMG">
				<div class="img">
		                <img id="profilo"src="./images/sample.jpg" alt="Foto Profilo">
		        </div>
				<div class="InfoProfilo1">
					<h1>Autore: <%=form.getAutore() %></h1>
				</div>
			</div>
			<%

				String q = "InserimentoInterventoServlet?id="+idForm;

				System.out.println(q);

%>
			
			<div class="text-intervento">
				<textarea id="descrizione" name="descrizione" rows="10" cols="50" placeholder="Descrizione" maxlength="800"></textarea>
			</div>
			<div class="intervento-button"> 
				<button type="submit" class="Button">Pubblica</button>
			</div>
		</div>
		</form>
</body>
</html>