<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<h3>Titolo Form</h3>
			</div>
			<div class="Info">
				<h3>Topic</h3>
			</div>
			<div class="Info">
				<h3>Data Apertura</h3>
			</div>
		</div>
		
		<div id="Dettaglio2ariga">
			<div class="img">
                <img id="profilo"src="./images/sample.jpg" alt="Foto Profilo">
            </div>
            <div class="InfoProfilo">
				<h3>Dott. Serretella</h3>
			</div>
			
		</div>
		
		<div id="Dettaglio1ariga">
		  <div class="Commento">
  					<h3>Descrizione Form: Lorem Ipsum è considerato il testo segnaposto standard
  					 sin dal sedicesimo secolo, quando un anonimo tipografo prese una cassetta di 
  					 caratteri e li assemblò per preparare un testo campione. È sopravvissuto non 
  					 solo a più di cinque secoli, 
  					ma anche al passaggio alla videoimpaginazione, pervenendoci sostanzialmente 
  					inalterato. Fu reso popolare, negli anni ’60, con la diffusione dei fogli di 
  					caratteri trasferibili “Letraset”, che contenevano passaggi del Lorem Ipsum, 
  					e più recentemente da software di impaginazione come Aldus PageMaker, che 
  					includeva versioni del Lorem Ipsum.</h3>
				</div>
		</div>
		
		
		</div>
</body>
</html>