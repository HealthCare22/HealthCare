function goToContatti(){
     info1=document.getElementsByClassName("info"); //non si deve vedere
     info2=document.getElementsByClassName("info2"); //si deve vedere
     button1=document.getElementById("section1"); //deve cambiare colore
     button2=document.getElementById("section2"); // anche lui
    
    button1.style.backgroundColor='#B7DDDB';
    button1.style.color='#000000';
    button2.style.backgroundColor='#35908B';
    button2.style.color='#FFFFFF';
     /* background: #B7DDDB; color: #000000; unselected
        background: #35908B; color: #FFFFFF; selected*/
    for(var i=0;i<info1.length;i++){
        info1[i].style.display="none";
    }
    for(var i=0;i<info2.length;i++){
        info2[i].style.display="flex";
    }

}

function goToAnagrafica(){
    info1=document.getElementsByClassName("info"); // si deve vedere
    info2=document.getElementsByClassName("info2"); //non si deve vedere
    button1=document.getElementById("section1");
    button2=document.getElementById("section2");

    button2.style.backgroundColor='#B7DDDB';
    button2.style.color='#000000';
    button1.style.backgroundColor='#35908B';
    button1.style.color='#FFFFFF';


    for(var i=0;i<info2.length;i++){
        info2[i].style.display="none";
    }

    for(var i=0;i<info1.length;i++){
        info1[i].style.display="flex";
    }
 

}

