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
		return malattiaDao.getMalattie(mongoClient);
	}

	public List<GestioneMalattieBean> RicercaPerNome(String nomeMalattia) {
		MalattiaDAO malattiaDao = new MalattiaDAO(mongoClient);
		return malattiaDao.RicercaPerNome(nomeMalattia, mongoClient);
	}

	public List<SintomoBean> getAllSintomi() {
		SintomoDAO sintomoDao = new SintomoDAO(mongoClient);
		return sintomoDao.getSintomi();
	}

	public List<SintomoBean> getSintomiByNome(List<String> listaNomiSintomi) {
		SintomoDAO sintomoDao = new SintomoDAO(mongoClient);
		return sintomoDao.getSintomiByNome(listaNomiSintomi);
	}

	public List<GestioneMalattieBean> ricercaPerSintomi(List<String> listanomiSintomi) {
		MalattiaDAO malattiaDao = new MalattiaDAO(mongoClient);
		SintomoDAO sintomoDao = new SintomoDAO(mongoClient);
		List<SintomoBean> listaSintomi = sintomoDao.getSintomiByNome(listanomiSintomi);
		return malattiaDao.ricercaPerSintomi(listaSintomi, mongoClient);
	}

	public boolean existMalattia(String nomeMalattia) {
		MalattiaDAO malattiaDao = new MalattiaDAO(mongoClient);
		return malattiaDao.existMalattia(nomeMalattia);
	}
	
	public Boolean existSintomo(MongoClient client, String nome) {
		SintomoDAO sintomoDao = new SintomoDAO(client);
		return sintomoDao.existSintomo(nome);
	}
	
}
