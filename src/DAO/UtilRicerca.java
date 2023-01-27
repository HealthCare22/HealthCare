package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import Beans.GestioneFormBean;
import Beans.GestioneMalattieBean;

public class UtilRicerca {

	  private static com.mongodb.client.MongoClient getConnection() {
	        String uri = "mongodb+srv://root:root@healthcare.i5mrfxx.mongodb.net/test";
	 
	        	com.mongodb.client.MongoClient mongoClient =  MongoClients.create(uri);
	            MongoDatabase database = mongoClient.getDatabase("HealthCare");
	            MongoCollection<Document> collection = database.getCollection("MMG");
				return mongoClient;
}

	  public static List<GestioneMalattieBean> RicercaPerNome (String nomeMalattia) {
		  
		 
	        String db_name = "HealthCare",
	                db_collection_name = "Malattia";
	 
	        // Get the mongodb connection
	        MongoDatabase db = getConnection().getDatabase(db_name);
	 
	        // Get the mongodb collection.
	        MongoCollection<Document> col = db.getCollection(db_collection_name);
	 
	        FindIterable<Document> cursor = col.find();
	         List<GestioneMalattieBean> listaMalattia = new ArrayList<>();

	         //Creazione lista di form
	         for(Document doc : cursor) {
	              

		         if(nomeMalattia.equals(doc.getString("nome_malattia"))) {
	                String nome = doc.getString("nome_malattia");
	                int codice = doc.getInteger("codice");
	                String descrizione = doc.getString("descrizione");
	                
	                listaMalattia.add(new GestioneMalattieBean(codice, nome, descrizione));
		         }
	        }
	         return listaMalattia;
	  }
	  
	  public static List<GestioneMalattieBean> getMalattie(){
		  String db_name = "HealthCare",
	                db_collection_name = "Malattia";
	 
	        // Get the mongodb connection
	        MongoDatabase db = getConnection().getDatabase(db_name);
	 
	        // Get the mongodb collection.
	        MongoCollection<Document> col = db.getCollection(db_collection_name);
	 
	        FindIterable<Document> cursor = col.find();
	         List<GestioneMalattieBean> listaMalattia = new ArrayList<>();

	         //Creazione lista di form
	         for(Document doc : cursor) {
	              
	                String nome = doc.getString("nome_malattia");
	                Integer codice = doc.getInteger("codice");
	                String descrizione = doc.getString("descrizione");
	                listaMalattia.add(new GestioneMalattieBean(codice, nome, descrizione));
		         }
	         return listaMalattia;
	  }
}