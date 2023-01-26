<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Elenco malattie rare</title>
<link rel="stylesheet" href="./css/listaMalattieStyle.css">
</head>

<body>
	<jsp:include page="navbar.jsp"/>
	
	<div id="Titolo">
			<h1>Elenco delle malattie rare</h1>
		</div>
	
	
	<div id = "ricercaContainer">
	   <button class = "buttonCerca">Cerca</button>
	
	   <div class="search">
        <input type="text" id="nomeMalattia" placeholder="Nome Malattia">
     </div>
</div>

		

		<div id = "elencoMalattie">
		<div id="malattiaContainer">
            <div class="elenco">
             <h3> Nome Malattia</h3>
            </div>
            <div>
				<button class = "ButtonVediForm">Vedi Dettagli</button>
			</div>
		</div>
		
		<div id="malattiaContainer">
            <div class="elenco">
             <h3> Nome Malattia</h3>
           
            </div>
            <div>
				<button class = "ButtonVediForm">Vedi Dettagli</button>
			</div>
		</div>
		
		<div id="malattiaContainer">
            <div class="elenco">
             <h3> Nome Malattia</h3>
            </div>
            <div>
				<button class = "ButtonVediForm">Vedi Dettagli</button>
			</div>
		</div>
		
		<div id="malattiaContainer">
            <div class="elenco">
             <h3> Nome Malattia</h3>
            </div>
            <div>
				<button class = "ButtonVediForm">Vedi Dettagli</button>
			</div>
		</div>
		
		</div>
