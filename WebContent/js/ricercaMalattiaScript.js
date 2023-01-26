var s=1;
var maxS= 5;

addButton=document.getElementById("aggiungiSintomoButton").addEventListener("click", function(event){
  event.preventDefault()
});
removeButton=document.getElementById("rimuoviSintomoButton").addEventListener("click", function(event){
  event.preventDefault()
});






function addSintomo(){

    if(s<maxS){
        s++;
    
    var listaSintomi = document.getElementById("nomeSintomoContainer");
    var input = document.createElement("input");
                input.type = "text";
                input.placeholder = "Nome Sintomo "+s;
                input.classList.add("nomeSintomo");
                input.id="Sintomo"+s;

                listaSintomi.appendChild(input);
              
    }
    else{
        alert("Limite massimo di Sintomi raggiunto!!");
    }

    if(s>1){
        remove=document.getElementById("rimuoviSintomoButton");
        remove.style.display="block";
    }

}

function removeSintomo(){


    sintomo=document.getElementById("Sintomo"+s);
    sintomo.remove();
    s--;

    if(s==1){
        remove=document.getElementById("rimuoviSintomoButton");
        remove.style.display="none";
    }
}

function goToNome(){
    nome=document.getElementById("perNome");
    sintomi=document.getElementById("perSintomi");

    nomeContainer=document.getElementsByClassName("containerNome");
    sintomiContainer=document.getElementsByClassName("containerSintomi");

    nome.style.backgroundColor='#35908B';
    nome.style.color='#FFFFFF';

    sintomi.style.backgroundColor='#B7DDDB';
    sintomi.style.color='#000000';

    for(var i=0;i<nomeContainer.length;i++){
        nomeContainer[i].style.display="block";
    }
    for(var i=0;i<sintomiContainer.length;i++){
        sintomiContainer[i].style.display="none";
    }


}

function goToSintomi(){
    nome=document.getElementById("perNome");
    sintomi=document.getElementById("perSintomi");

    nomeContainer=document.getElementsByClassName("containerNome");
    sintomiContainer=document.getElementsByClassName("containerSintomi");


    sintomi.style.backgroundColor='#35908B';
    sintomi.style.color='#FFFFFF';

    nome.style.backgroundColor='#B7DDDB';
    nome.style.color='#000000';


    
    for(var i=0;i<nomeContainer.length;i++){
        nomeContainer[i].style.display="none";
    }
    for(var i=0;i<sintomiContainer.length;i++){
        sintomiContainer[i].style.display="flex";
        sintomiContainer[i].style.flexDirection="column";
        sintomiContainer[i].style.justifyContent="center";
    }

}