package DAO;

import org.bson.Document;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

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
	 
		 
	        MongoDatabase db = getConnection().getDatabase(db_name);
	        MongoCollection<Document> col = db.getCollection(db_collection_name);
	        
	        
	        Document document = new Document("topic", topic)
	        					.append("titolo", titolo)
	        					.append("descrizione", descrizione)
	        					.append("status",true);
	       
	        col.insertOne(document);
	        
	        
	 
		 return true;
	 }

}
