package gestioneForm;

import java.util.List;

import com.mongodb.client.MongoClient;

public class FormFacade {

private static MongoClient mongoClient;
	
	public FormFacade(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
	
	public boolean apriForm(String titolo, String descrizione, String email) {
		FormDAO form = new FormDAO(mongoClient);
		boolean isUserFound = form.CreateNewForm(titolo, descrizione, email);
		return isUserFound;
	}
	
	public List<GestioneFormBean> recuperaTuttiIForm(){
		FormDAO form = new FormDAO(mongoClient);
		List<GestioneFormBean> listaForm = form.recuperaForm();
		return listaForm;
	}
	
	public List<GestioneFormBean> getFormByStatus(String email, boolean status){
		FormDAO form = new FormDAO(mongoClient);
		List<List<GestioneFormBean>> listaForm = form.getFormByStatus(email);
		if(status == true) {
			return listaForm.get(0);
		}else {
			return listaForm.get(1);
		}
	}
	
	public void changeFormStatus(String id) {
		FormDAO formDao = new FormDAO(mongoClient);
		GestioneFormBean formBean = formDao.getFormById(id);
		if(formBean.getStatus()) {
			formDao.setStatusFalse(id);
		}else {
			formDao.setStatusTrue(id);
		}
	}
	
	public GestioneFormBean getFormById(String id) {
		FormDAO formDao = new FormDAO(mongoClient);
		return formDao.getFormById(id);
	}

	public void deleteForm(String id) {
		FormDAO formDao = new FormDAO(mongoClient);
		InterventoDAO interventoDao = new InterventoDAO(mongoClient);
		formDao.deleteForm(id);
		interventoDao.deleteInterventi(id);
	}

	public void updateForm(String id, String titolo, String descrizione) {
		FormDAO formDao = new FormDAO(mongoClient);
		formDao.updateForm(id, titolo, descrizione);
	}

	public List<GestioneInterventiBean> getInterventiByFormId(String idForm) {
		InterventoDAO intervendoDao = new InterventoDAO(mongoClient);
		return intervendoDao.recuperaInterventi(idForm);
	}

	public void deleteInterventi(String idForm) {
		InterventoDAO interventoDao = new InterventoDAO(mongoClient);
		interventoDao.deleteInterventi(idForm);
		
	}

	public List<GestioneInterventiBean> addIntervento(String email, String descrizione, String id_form) {
		InterventoDAO interventoDao = new InterventoDAO(mongoClient);
		interventoDao.addIntervento(email, descrizione, id_form);
		List<GestioneInterventiBean>listaForm = interventoDao.recuperaInterventi(id_form);
		return listaForm;
	}

	public List<GestioneInterventiBean> getInterventiByEmail(String email) {
		InterventoDAO interventoDao = new InterventoDAO(mongoClient);
		List<GestioneInterventiBean>listaInterventi = interventoDao.getInterventiByEmail(email);
		return listaInterventi;
	}
	
}
