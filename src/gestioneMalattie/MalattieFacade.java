package gestioneMalattie;

import java.util.List;

import com.mongodb.client.MongoClient;

public class MalattieFacade {

	private static MongoClient mongoClient;
	
	public MalattieFacade(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public List<GestioneMalattieBean> getAllMalattie() {
		MalattiaDAO malattiaDao = new MalattiaDAO(mongoClient);
		return malattiaDao.getMalattie();
	}

	public List<GestioneMalattieBean> RicercaPerNome(String nomeMalattia) {
		MalattiaDAO malattiaDao = new MalattiaDAO(mongoClient);
		return malattiaDao.RicercaPerNome(nomeMalattia);
	}

	public List<SintomoBean> getAllSintomi() {
		SintomoDAO sintomoDao = new SintomoDAO(mongoClient);
		return sintomoDao.getSintomi();
	}

	public List<SintomoBean> getSintomiByNome(List<String> listaNomiSintomi) {
		SintomoDAO sintomoDao = new SintomoDAO(mongoClient);
		return sintomoDao.getSintomiByNome(listaNomiSintomi);
	}

	public List<GestioneMalattieBean> getMalattieBySintomi(List<SintomoBean> listaSintomi) {
		MalattiaDAO malattiaDao = new MalattiaDAO(mongoClient);
		return malattiaDao.getMalattieBySintomi(listaSintomi);
	}

	public boolean existMalattia(String nomeMalattia) {
		MalattiaDAO malattiaDao = new MalattiaDAO(mongoClient);
		return malattiaDao.existMalattia(nomeMalattia);
	}
	
}
