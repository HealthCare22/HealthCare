<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
    <%
    String error_message = (String) request.getAttribute("error_message");
    
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<link rel="stylesheet" href="./css/aperturaFormStyle.css">
    	<title>Nuovo Form</title>
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
    <h2 id="Apertura-text">Apertura nuovo form</h2>


	<%if(error_message!=null){ %>
	<div class = "errorMessage">
		<p><%=error_message %></p>
	</div><%} %>
     <form method="post" action="AperturaFormServlet">
        <div class="information">
            
            <input name="titolo" type="text" placeholder="Titolo">
            <textarea name="descrizione" rows="10" cols="50" placeholder="Descrizione" maxlength="800"></textarea>
			
	        <div class="button-apertura">
	             <input id="apri-form" type="submit" value="Apri form">
	        </div>
			
        </div>
    </form>
	</body>
</html>