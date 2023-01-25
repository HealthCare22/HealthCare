
function attivaMyForm(){
	myForm=document.getElementById("MyForms");
	newForm=document.getElementById("NewForm");
	searchForm=document.getElementById("SearchForm");
	Interventi=document.getElementById("Interventi");

		myForm.classList.add("attivo");
		myForm.style.backgroundColor='#35908B';
		myForm.style.color=white;
		newForm.classList.remove("attivo");
		searchForm.classList.remove("attivo");
		Interventi.classList.remove("attivo");
}
		
function attivaNuovoForm(){
	
	myForm=document.getElementById("MyForms");
	newForm=document.getElementById("NewForm");
	searchForm=document.getElementById("SearchForm");
	Interventi=document.getElementById("Interventi");
	
		myForm.classList.remove("attivo");
		newForm.classList.add("attivo");
		searchForm.classList.remove("attivo");
		Interventi.classList.remove("attivo");
}
		
function attivaEsploraForm(){
	
	myForm=document.getElementById("MyForms");
	newForm=document.getElementById("NewForm");
	searchForm=document.getElementById("SearchForm");
	Interventi=document.getElementById("Interventi");	
	
		myForm.classList.remove("attivo");
		newForm.classList.remove("attivo");
		searchForm.classList.add("attivo");
		Interventi.classList.remove("attivo");
}

function attivaInterventi(){
		
		myForm=document.getElementById("MyForms");
		newForm=document.getElementById("NewForm");
		searchForm=document.getElementById("SearchForm");
		Interventi=document.getElementById("Interventi");
		
		myForm.classList.remove("attivo");
		newForm.classList.remove("attivo");
		searchForm.classList.remove("attivo");
		Interventi.classList.add("attivo");
	
		}
	