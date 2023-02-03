<!DOCTYPE html>
<html lang="en">

<%
	String error_message = (String) request.getAttribute("error_message");
%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/registrationStyle.css">
    <title>Registrazione</title>
    <script src = "./js/registrationScript.js"></script>
</head>
<body>
		
	<div class="logo-container">
    <img class="logo" src="images/logo.png" alt="logoHealthCare">
    </div>
    	<div>
        	<p><%=error_message %></p>
        </div>
    <div class="registration">
        <h1 class="labelaccount">Crea un nuovo account</h1>
        
        <form id="registrationForm" method="post"  action="RegistrationServlet">
        <div id = "firstForm">
            <div class="registrationInformation">

                <div class="go-next">
                    <button id="skip1"> </button>
                    <hr>
                    <button id="skip2"> </button>
                </div>

                <div class="NomeCognome">
                    <input id="name"  type="text" name="name" placeholder="Nome"  >
                    <input id="surname" type="text" name="surname" placeholder="Cognome" >
                </div>


                <div class="sesso">
                
                    <p>Sesso</p>
                   		
	                        <input type="radio" id="maschio" name="gender" value="Maschio" checked>
	                        <label for="Maschio">Maschio</label>
	
	                        <input type="radio" id="femmina" name="gender" value="Femmina">
	                        <label for="Femmina">Femmina</label>
	
	                        <input type="radio" id="altro" name="gender" value="Altro">
	                        <label for="Altro">Altro</label>
                        
                </div>
                
           
            <div class="password">
                <input id="password" type="password" name="password" placeholder="Password" >
                <input id="confirmPassword" type="password" name="confirmPassword" placeholder="Conferma password">
            </div>  

    
            <div class="email">
                <input id="email" type="text" name="email" placeholder="Email">
            </div> 

            <div class="email">
                <input id="confirmEmail" type="email" name="confirmEmail" placeholder="Conferma email">
            </div>

        </div>
    </div>
    <div id = "secondForm">
        <div class="go-next">
            <button id="skip1Post"> </button>
            <hr>
            <button id="skip2Post"> </button>
        </div>
        <h1 class = "labelaccount">Domicilio:</h1>
        <div class="domicilio" >
            <input id="provincia" type="text" name="provincia" placeholder="Provincia" >
            <input id="comune" type="text" name="comune" placeholder="Comune" >
            <input id="indirizzo" type="text" name= "indirizzo" placeholder="Indirizzo" >
        </div>
        <div class="telefono">
            <input id="telefono" type="text" name="numero_telefono" placeholder="Numero di telefono" >
        </div>
    </div>   
    	<div class="pulsantiConfermaAnnulla">
    	<button type = "submit" id = "secondFormButton">Conferma</button>
    	</div>
    	</form>
    	 
        <div class="pulsantiConfermaAnnulla">
            <button id="annulla" onclick = "changeForm()" >Annulla</button>
            <button  id = "firstFormButton" onclick="changeForm()" >Avanti</button>
        </div>
    </div>
</body>
</html>

