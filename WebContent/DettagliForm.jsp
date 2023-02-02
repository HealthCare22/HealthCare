<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DAO.FormDAO" %>
<%@ page import="Beans.GestioneFormBean" %>
<%@ page import="com.mongodb.client.MongoClient" %>


<%

	
	
	Collection<?> allInterventi = (Collection<?>)request.getAttribute("listaInterventi");

	HttpSession sessione = request.getSession();
	String idForm = (String) sessione.getAttribute("idform");
	String email = (String) sessione.getAttribute("email");

	GestioneFormBean form = (GestioneFormBean) request.getAttribute("formById");
	request.setAttribute("formById", form);
	
	MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
	FormDAO formDAO = new FormDAO(mongoClient);

	sessione.setAttribute("status", form.getStatus());

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
	
	

	<div id="Titolo">
			<h1>Dettagli del Form</h1>
		</div>
		
		
		<div id="Dettaglio">
		
		<div id="Dettaglio1ariga">
			<div class="Info">
				<h3>Titolo: <%=form.getTitolo() %></h3>
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
			<% if(form.getStatus()){ %>
				<h1>Stato: Aperto</h1>
			
		<%} else{ %>
				<h1>Stato: Chiuso</h1>
		
			<% } %>
			
			<%if(form.getAutore().equals(email)){%>
				<form method="GET" action="ModificaForm.jsp">
					<button type="submit" class="Button">Modifica</button>
				</form>
				
				<form method="GET" action="EliminaFormServlet">
					<button type="submit" class="Button">Elimina</button>
				</form>
			
		<% if(form.getStatus()){ %>
			<form method="GET" action="ApriChiudiFormServlet">
				<button type="submit" class="Button">Chiudi Form</button>
			</form>
			<%}else{ %>
				<form method="GET" action="ApriChiudiFormServlet">
				<button type="submit" class="Button">Riapri Form</button>
				</form>
		<% }%>
		<%} %>	
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
	 %>

	
<% if(form.getStatus()){ %>
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

			
			<div class="text-intervento">
				<textarea id="descrizione" name="descrizione" rows="10" cols="50" placeholder="Descrizione" minlength="2" maxlength="800"></textarea>
			</div>
			<div class="intervento-button"> 
				<button type="submit" class="Button">Pubblica</button>
			</div>
		</div>
		</form>
		
	<%} %>
</body>
</html>