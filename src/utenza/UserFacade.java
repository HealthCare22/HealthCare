package utenza;

import com.mongodb.client.MongoClient;

import gestioneForm.FormDAO;
import gestioneForm.InterventoDAO;
import medico.MMGBean;

public class UserFacade {

private static MongoClient mongoClient;
	
	public UserFacade(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public boolean modifyUser(String password, String email, String provincia, String comune, String indirizzo,
			String numero_telefono, String oldmail) {
		UserDAO userDao = new UserDAO(mongoClient);
		if(!(email.equals(oldmail))){
			FormDAO formDao = new FormDAO(mongoClient);
			formDao.updateEmail(oldmail, email);
			InterventoDAO interventoDao = new InterventoDAO(mongoClient);
			interventoDao.updateEmailInterventi(oldmail, email);
		}
		return userDao.editUserInDb(password, email, provincia, comune, indirizzo, numero_telefono, oldmail);
	}

	public MMGBean getUserByEmail(String email) {
		UserDAO userDao = new UserDAO(mongoClient);
		return userDao.recuperaUser(email);
	}

	public String encrypt(String password) {
		return UserDAO.encrypt(password);
	}

	public boolean checkCredentials(String email, String pass) {
		UserDAO userDao = new UserDAO(mongoClient);
		return userDao.searchUserInDb(email, pass);
	}

	public boolean registerUser(String nome, String cognome, String sesso, String encrypt, String email,
			String provincia, String comune, String indirizzo, String numero_telefono) {
		UserDAO userDao = new UserDAO(mongoClient);
		return userDao.appendUserInDb(nome, cognome, sesso, encrypt, email, provincia, comune, indirizzo, numero_telefono);
	}

	public boolean existEmail(String email) {
		UserDAO userDao = new UserDAO(mongoClient);
		return userDao.existEmail(email);
	}
	
}
