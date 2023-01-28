package DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import Beans.GestioneFormBean;
import Beans.GestioneInterventiBean;

public class InterventoUtil {

	  private static com.mongodb.client.MongoClient getConnection() {
	        String uri = "mongodb+srv://root:root@healthcare.i5mrfxx.mongodb.net/test";
	 
	        	com.mongodb.client.MongoClient mongoClient =  MongoClients.create(uri);
	            MongoDatabase database = mongoClient.getDatabase("HealthCare");
	            MongoCollection<Document> collection = database.getCollection("MMG");
				return mongoClient;
	        
	    }
	 
	  
	 public static boolean addIntervento(String email,String descrizione, String id) {
		 String db_name = "HealthCare",
	                db_collection_name = "Intervento";
	 
		
	        MongoDatabase db = getConnection().getDatabase(db_name);
	        MongoCollection<Document> col = db.getCollection(db_collection_name);
	        
	        
	        Document document = new Document("email", email)
	        					.append("descrizione", descrizione)
	        					.append("id_form", id);
	        					
	        
	        col.insertOne(document);
	        
	        return true;
	 }
	 
	 public static List<GestioneInterventiBean> recuperaInterventi(String identificatore, String email ) {
		 
		 
		 String db_name = "HealthCare",
	                db_collection_name = "Interventi";
	 
		
	        MongoDatabase db = getConnection().getDatabase(db_name);
	        MongoCollection<Document> col = db.getCollection(db_collection_name);
	        
      FindIterable<Document> cursor = col.find();
      List<GestioneInterventiBean> listaInterventi = new ArrayList<>();

      //Creazione lista di form
      for(Document d : cursor) {
             
    	  if(email.equals(d.getString(identificatore))) {
    		  
    		 String id = d.getString("id_form");
			 String descrizione = d.getString("descrizione");
			 String email_medico = d.getString("email");
			 

			 
			 
			 GestioneInterventiBean bean = new GestioneInterventiBean(id,descrizione, email_medico);
			 listaInterventi.add(bean);
      }
      }
      
      
      return listaInterventi;
		 
		 
		 
		 
	 }
}
