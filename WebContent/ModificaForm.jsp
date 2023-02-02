<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="DAO.FormDAO" %>
<%@ page import="Beans.GestioneFormBean" %>
<%@ page import="com.mongodb.client.MongoClient" %>
    <%

	
	
	

	GestioneFormBean form = (GestioneFormBean) request.getAttribute("formById");
	
	
	MongoClient mongoClient = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
	

	

%>

    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<link rel="stylesheet" href="./css/aperturaFormStyle.css">
    	<title>Modifica Form</title>
	</head>
		<script>
		function attivaNuovoForm(){
			newForm=document.getElementById("NewForm");
				newForm.classList.add("attivo");
				newForm.style.backgroundColor='#35908B';
				newForm.style.color='#FFFFFF';
		}
		</script>
	<body onload="attivaNuovoForm()">
	<jsp:include page="navbar.jsp"/>
	<div id ="FormNavbar">
		<jsp:include page="FormNavbar.jsp"></jsp:include>
	</div>
    <h2 id="Apertura-text">Modifica del form</h2>

     <form method="post" action="ModificaFormServlet">
        <div class="information">
            
            <input name="titolo" type="text"  placeholder="Titolo">
            <textarea name="descrizione"  rows="10" cols="50" placeholder="Descrizione" maxlength="800"></textarea>
			
	        <div class="button-apertura">
	             <input id="apri-form" type="submit" value="Modifica form">
	        </div>
			
        </div>
    </form>
	</body>
</html>