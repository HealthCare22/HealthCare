
function changeForm(){
    firstRegistrationForm = document.getElementById("firstForm");
    firstFormButton = document.getElementById("firstFormButton");
    secondRegistrationForm = document.getElementById("secondForm");
    secondFormButton = document.getElementById("secondFormButton");
    annulla=document.getElementById("annulla");
    
    if(firstRegistrationForm.style.display == "none"){
        //Viene premuto il tasto "annulla"
        firstRegistrationForm.style.display = "block";
        firstFormButton.style.display = "block";
        secondRegistrationForm.style.display = "none";
        secondFormButton.style.display = "none";
        annulla.style.display = "none";
    }else{
        //Viene premuto il tasto "avanti"
        firstRegistrationForm.style.display = "none";
        firstFormButton.style.display = "none";
        secondRegistrationForm.style.display = "block";
        secondFormButton.style.display = "block";
        annulla.style.display = "block";
        
    }
}    

