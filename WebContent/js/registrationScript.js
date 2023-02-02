
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


/*
function validate(obj){

	
	let name=document.getElementById("name");
	let surname=document.getElementById("surname");
	let password=document.getElementById("password");
	let confirmPassword=document.getElementById("confirmPassword");
	let email=document.getElementById("email");
	let confirmEmail=document.getElementById("confirmEmail");
	let provincia=document.getElementById("provincia");
	let comune=document.getElementById("comune");
	let indirizzo=document.getElementById("indirizzo");
	let telefono=document.getElementById("telefono");

	changeForm();
	if(validateName(name)&&
			validateSurname(surname)&&
			validatePassword(password,confirmPassword)&&
			validateEmail(email,confirmEmail))
		{
			changeForm();//prima parte corretta
			alert("prima parte corretta");
		}
	if(validateProvincia(provincia)&&
			validateComune(comune)&&
			validateIndirizzo(indirizzo)&&
			validateTelefono(telefono))
		{
		return true; //tutto corretto
		
		}

	event.preventDefault();
	
}







function validateName(data){
	let RGX="^[a-z A-Z àéèìòù]{2,255}$";
	if(data.value.match(RGX))
		{
		
		return true;
		
		}
	else
		{
		alert("nome non valido");
		document.getElementById("name").focus();
		return false;
		
		}
	
}
function validateSurname(data){
	let RGX="^[a-z A-Z àéèìòù]{2,255}$";
	if(data.value.match(RGX))
	{
	
	return true;
	}
else
	{
	alert("cognome non valido");
	document.getElementById("surname").focus();
	return false;
	}

}

function validatePassword(data,confirmData){
	let RGX="^(?=([^\s])*[0-9])(?=([^\s])*[a-zA-Z])([^\s]){8,24}$";
	if(data.value!=confirmData.value){
		alert("le password non corrispondono");
		document.getElementById("password").focus();
		return false;	
	}
	if(data.value.match(RGX))
	{
	return true;
	}
	else
	{
	alert("password non valida");
	document.getElementById("password").focus();
	return false;
	}

}

function validateEmail(data,confirmData){
	let RGX="([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)";
	if(data.value!=confirmData.value){
		alert("le email non corrispondono");
		document.getElementById("email").focus();
		return false;	
	}
	if(data.value.match(RGX))
	{
	return true;
	}
	else
	{
	alert("email non valida");
	document.getElementById("email").focus();
	return false;
	}

}
function validateProvincia(data){
	let RGX="^[a-z A-Z àéèìòù]{2,255}$";
	if(data.value.match(RGX))
	{
	
	return true;
	}
else
	{
	alert("Provincia non valida");
	document.getElementById("provincia").focus();
	return false;
	}
}
function validateComune(data){
	let RGX="^[a-z A-Z àéèìòù]{2,255}$";
	if(data.value.match(RGX))
	{
	
	return true;
	}
else
	{
	alert("Comune non valido");
	document.getElementById("comune").focus();
	return false;
	}
	
}

function validateIndirizzo(data){
	let RGX="^[a-z A-Z 0-9 àéèìòù',.-]{2,255}$";
	if(data.value.match(RGX))
	{
	return true;
	}
else
	{
	alert("Indirizzo non valido");
	document.getElementById("indirizzo").focus();
	return false;
	}
	
}
function validateTelefono(data){
	let RGX= "^(\+\d{1,2}\s?)?1?\-?\.?\s?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$/";
	if(data.value.match(RGX))
	{
		return true;
		}
	else
	{
		alert("Numero di telefono non valido");
		document.getElementById("telefono").focus();
		return false;
	}
	
	
}
*/




