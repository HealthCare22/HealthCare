<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/ricercaMalattiaStyle.css">
    <title>Ricerca per sintomi</title>
    <script src = "./js/ricercaMalattiaScript.js"></script>
</head>
<body>
	<jsp:include page="navbar.html"/>
    <div class="heading">
        <h1>Tipo di ricerca: </h1>
    </div>
    <div class="selector">
        <button id="perNome" onclick="goToNome()">per nome</button>
        <button id="perSintomi" onclick="goToSintomi()">per sintomi</button>
    </div>
    <div class="containers">
        <div class="containerNome">
            <h1>Ricerca Malattia Rara</h1>
            <hr>
            <div class="ricercaNome">
                <input type="text" id="nomeMalattia" placeholder="Nome Malattia">
            </div>
            <div class="cercaPerNomeButtonDiv">
                <button id="cercaPerNomeButton">Cerca</button>
            </div>
        </div>
        <div class="containerSintomi">
            <h1>Ricerca Malattia Rara</h1>
            <hr>
            <div id="nomeSintomoContainer">
                <input type="text" class="nomeSintomo" id="Sintomo1" placeholder="Nome Sintomo">
            </div>
                <div class="buttons">
                    <button id="rimuoviSintomoButton" onclick="removeSintomo()">Annulla</button>
                    <button id="aggiungiSintomoButton" onclick="addSintomo()">Aggiungi Sintomo</button>
                    <button id="cercaPerSintomiButton">Cerca</button>
                </div>
        </div>
        
    </div>
</body>
</html>