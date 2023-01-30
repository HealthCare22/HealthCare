package DAO;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import Beans.SintomoBean;

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
	
    
    
}
