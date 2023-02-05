package gestioneMalattie;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class SintomoDAO {

	private final MongoCollection<Document> collection;

    private final static String DB_NAME = "HealthCare";
    private final static String COLLECTION_NAME = "Sintomo";

    public SintomoDAO(MongoClient client) {
        MongoDatabase database = client.getDatabase(SintomoDAO.DB_NAME);
        this.collection = database.getCollection(SintomoDAO.COLLECTION_NAME);
    }
    
  


	public List<SintomoBean> getSintomiByNome(List<String> listaNomiSintomi) {
		List<SintomoBean> listaSintomi = new ArrayList<>();
		for(String s : listaNomiSintomi) {
			FindIterable<Document> cursor = this.collection.find(Filters.eq("nome_sintomo",s));
			for(Document d : cursor) {
				Integer codice = d.getInteger("codice");
				listaSintomi.add(new SintomoBean(codice,s));
			}
		}
		return listaSintomi;
	}
	
    public SintomoBean getSintomoById(Integer id) {
    	FindIterable<Document> cursor = this.collection.find(Filters.eq("codice",id));
    	SintomoBean sintomo = null;
    	for(Document d : cursor) {
    		String nome = d.getString("nome_sintomo");
    		Integer codice = id;
    		sintomo = new SintomoBean(codice,nome);
    	}
    	return sintomo;
    }

	public List<SintomoBean> getSintomi() {
		FindIterable<Document> cursor = this.collection.find();
		List<SintomoBean>listaSintomi = new ArrayList<>();
		for(Document d : cursor) {
			String nome = d.getString("nome_sintomo");
			if(nome==null) {
				nome = d.getString("nome sintomo");
			}
    		Integer codice = d.getInteger("codice");
    		listaSintomi.add(new SintomoBean(codice,nome));
		}
		return listaSintomi;
	}
    
}
