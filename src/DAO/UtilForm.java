package DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import Beans.GestioneFormBean;

public class UtilForm {
	
	  private static com.mongodb.client.MongoClient getConnection() {
	        String uri = "mongodb+srv://root:root@healthcare.i5mrfxx.mongodb.net/test";
	 
	        	com.mongodb.client.MongoClient mongoClient =  MongoClients.create(uri);
	            MongoDatabase database = mongoClient.getDatabase("HealthCare");
	            MongoCollection<Document> collection = database.getCollection("MMG");
				return mongoClient;
	        
	    }
	 
	  
	 public static boolean CreateNewForm(String topic, String titolo, String descrizione) {
		 
		 String db_name = "HealthCare",
	                db_collection_name = "Form";
	 
		 LocalDate todaysDate = LocalDate.now();
	        MongoDatabase db = getConnection().getDatabase(db_name);
	        MongoCollection<Document> col = db.getCollection(db_collection_name);
	        
	        
	        Document document = new Document("topic", topic)
	        					.append("titolo", titolo)
	        					.append("descrizione", descrizione)
	        					.append("status",true)
	        					.append("DataApertura",todaysDate);
	       
	        col.insertOne(document);
	        
	        
	 
		 return true;
	 }
	 
	 
	 public static List<GestioneFormBean> recuperaForm(){
		 
		 String db_name = "HealthCare",
	                db_collection_name = "Form";
	 
		
	        MongoDatabase db = getConnection().getDatabase(db_name);
	        MongoCollection<Document> col = db.getCollection(db_collection_name);
	        
         FindIterable<Document> cursor = col.find();
         List<GestioneFormBean> listaForm = new ArrayList<>();

         //Creazione lista di form
         for(Document doc : cursor) {
              
                
                String topic = doc.getString("topic");
                String titolo = doc.getString("titolo");
                Date data = doc.getDate("DataApertura");
                
                listaForm.add(new GestioneFormBean(topic, data, titolo));
         }
         
         
         return listaForm;
     }
		 
	 }


