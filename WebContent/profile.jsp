<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/profileStyle.css">
<script src="./js/profileScript.js"></script>
<title>Profilo</title>
</head>
<body>
	<jsp:include page="navbar.html"/>
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
    
    <div class="info">
        
            <h1>Dati Anagrafici</h1>
                <h2>Nome</h2>
                <input type="text" id="nome" value="Nome" readonly>

                <h2>Cognome</h2>
                <input type="text" id="cognome" value="Cognome" readonly>
            
                <h2>Sesso</h2>
                <input type="text" id="sesso" value="Maschio" readonly>
            
                <h2>Data di Nascita</h2>
                <input type="date" id="data" value="date" readonly>
        
            <h1>Credenziali</h1>
            
                <h2>E-mail</h2>
                <input type="email" id="email" value="angelo@gmail.com" readonly>
            
                <h2>Password</h2>
                <input type="password" id="password" value="password" readonly>
    </div>   
    <div class="info2">
            <h1>Contatti</h1>
            
            <h2>Numero di Telefono</h2>
            <input type="text" id="telefono" value="1234567890" readonly>

        
            <h1>Domicilio</h1>
        
            <h2>Provincia</h2>
            <input type="text" id="provincia" value="Salerno" readonly>
            
            <h2>Comune</h2>
            <input type="text" id="comune" value="Mercato San Severino" readonly>
        
            <h2>Indirizzo</h2>
            <input type="text" id="indirizzo" value="Via Castello,26" readonly>
    </div>
    
    <div class="buttondiv">
        <button id="annulla" onclick=reload()>Annulla modifiche</button>
        <button id="save" onclick=save()>Salva</button>
        

    </div>

        
</div>
</body>
</html>