package gestioneForm;

public class GestioneInterventiBean {

		private String id_form;
		private String descrizione;
		private String email_medico;
		
		
		public GestioneInterventiBean(String id_form, String descrizione, String email_medico) {
			super();
			this.id_form = id_form;
			this.descrizione = descrizione;
			this.email_medico = email_medico;
		}


		public String getId_form() {
			return id_form;
		}


		public void setId_form(String id_form) {
			this.id_form = id_form;
		}


		public String getDescrizione() {
			return descrizione;
		}


		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}


		public String getEmail_medico() {
			return email_medico;
		}


		public void setEmail_medico(String email_medico) {
			this.email_medico = email_medico;
		}
		
		
		
		
}
