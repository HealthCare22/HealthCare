function attivaMyForm(){
			myForm=document.getElementById("MyForms");

				myForm.classList.add("attivo");
				myForm.style.backgroundColor='#35908B';
				myForm.style.color='#FFFFFF';
}

function toClosedForms(){
	
	openButton=document.getElementById("OpenedFormButton");
	closeButton=document.getElementById("ClosedFormButton");
	
	opened=document.getElementById("OpenedForms");
	var closed=document.getElementById("ClosedForms");
	
	openButton.style.backgroundColor="#B7DDDB";
	openButton.style.color="black";
	
	
	closeButton.style.backgroundColor="#35908B";
	closeButton.style.color="white";
	
	
	opened.style.display="none";
	closed.style.display="flex";
	
}

function toOpenedForms(){

	openButton=document.getElementById("OpenedFormButton");
	closeButton=document.getElementById("ClosedFormButton");
	
	opened=document.getElementById("OpenedForms");
	var closed=document.getElementById("ClosedForms");
	
	closeButton.style.backgroundColor="#B7DDDB";
	closeButton.style.color="black";
	
	openButton.style.backgroundColor="#35908B";
	openButton.style.color="white";
	
	opened.style.display="flex";
	closed.style.display="none";
	
}