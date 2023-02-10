<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "medico.MMGBean" %>
<%@ page import = "utenza.UserDAO" %>
<%@ page import="com.mongodb.client.MongoClient" %>

<%  
    String error_message = (String) request.getAttribute("error");
	MMGBean mmg = (MMGBean) request.getAttribute("user");
	if(mmg == null){
		request.getRequestDispatcher("ProfileServlet").forward(request,response);
	}
%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/profileStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="./js/profileScript.js"></script>
<title>Profilo</title>
</head>
<body>
	<jsp:include page="navbar.jsp"/>

<%if(error_message!=null){ %>

<div class = errorMessage>
	<p><%=error_message %></p>
</div>
	<%}%>


    <div class="img">
    <img id="profilo"src="./images/sample.jpg" alt="Foto Profilo">
    </div>
    <div class="center">
        <div class="sectiondiv">
        <button id="section1"  onclick=goToAnagrafica()>Anagrafica e credenziali</button>
        <button id="section2"  onclick=goToContatti()>Contatti e domicilio</button>
    </div>
    <div class="editdiv">
            <button id="edit" onclick="edit()">Modifica</button>
    </div>
    </div>
  <form method="post" action="EditProfile"> 
    <div class="info">
    	
            <h1>Dati Anagrafici</h1>
                <h2>Nome</h2>
              	<input type="text" id="nome" name="name" value= '<%=mmg.getNome() %>' readonly> 

                <h2>Cognome</h2>
                <input type="text" id="cognome" name="surname" value='<%=mmg.getCognome() %>' readonly> 
            
                <h2>Sesso</h2>
                <input type="text" id="sesso" name="gender" value=<%=mmg.getSesso() %> readonly>
            
               
        
            <h1>Credenziali</h1>
            
                <h2>E-mail</h2>
                <input type="email" id="email" name="email" value=<%=mmg.getEmail() %> readonly>
            
                <h2>Password</h2>
                <input type="password" id="password" name="password" value=<%=mmg.getPassword()%> readonly>
        	
    </div>   
    <div class="info2">
            <h1>Contatti</h1>
            
            <h2>Numero di Telefono</h2>
            <input type="text" id="telefono" name="numero_telefono" value=<%=mmg.getTelefono() %> readonly>

        
            <h1>Domicilio</h1>
        
            <h2>Provincia</h2>
            <input type="text" id="provincia" name="provincia" value='<%=mmg.getProvincia() %>' readonly>
            
            <h2>Comune</h2>
            <input type="text" id="comune" name="comune" value='<%=mmg.getComune() %>' readonly>
        
            <h2>Indirizzo</h2>
            <input type="text" id="indirizzo" name="indirizzo" value='<%=mmg.getIndirizzo()%>' readonly>

             
    </div>
	    <div class="buttondiv">
	    	<button type="submit" id="save">Salva</button>
	        <button id="annulla" onclick=reload()>Annulla modifiche</button>
	    </div>
	</form>
       
       
</body>
</html>