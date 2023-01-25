function attivaCercaForm(){
			myForm=document.getElementById("MyForms");
			newForm=document.getElementById("NewForm");
			searchForm=document.getElementById("SearchForm");
			Interventi=document.getElementById("Comments");

				searchForm.classList.add("attivo");
				searchForm.style.backgroundColor='#35908B';
				searchForm.style.color='#FFFFFF';
				newForm.classList.remove("attivo");
				myForm.classList.remove("attivo");
				Interventi.classList.remove("attivo");
}