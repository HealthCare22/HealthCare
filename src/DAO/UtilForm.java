package DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.model.Filters;
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
	 
	  
	 public static boolean CreateNewForm(String topic, String titolo, String descrizione, String email) {
		 
		 String db_name = "HealthCare",
	                db_collection_name = "Form";
	 
		 LocalDate todaysDate = LocalDate.now();
	        MongoDatabase db = getConnection().getDatabase(db_name);
	        MongoCollection<Document> col = db.getCollection(db_collection_name);
	        
	        
	        Document document = new Document("topic", topic)
	        					.append("titolo", titolo)
	        					.append("descrizione", descrizione)
	        					.append("status",true)
	        					.append("DataApertura",todaysDate)
	        					.append("DataChiusura", null)
	        					.append("idIntervento", 0)
	        					.append("autore",email);
	       
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
	 
	 public static List<List<GestioneFormBean>> getFormByStatus(String email){
		 
		 //DataBase connection
		 String db_name = "HealthCare",
	                db_collection_name = "Form";
		 
		 MongoDatabase db = getConnection().getDatabase(db_name);
		 
		 //Get the "Form" Collection from the DB
		 MongoCollection<Document> col = db.getCollection(db_collection_name);
		 
		 //Query to filter the results, the output is a Finterable<Document> containing
		 //every user's form
		 FindIterable<Document> cursor = col.find(Filters.all("autore", email));

		 //Lists that contain: All the user's forms; Open forms; closed forms;
		 List<List<GestioneFormBean>> listaForm = new ArrayList<List<GestioneFormBean>>(2);
		 List<GestioneFormBean> listaFormAperti = new ArrayList<>();
		 List<GestioneFormBean> listaFormChiusi = new ArrayList<>();
		 
		 //Iteration on the result
		 for(Document d : cursor) {
			 
			 //Bean construction
			 String id = d.getObjectId("_id").toString();
			 String topic = d.getString("topic");
			 String autoreForm = d.getString("autore");
			 String titolo = d.getString("titolo");
			 String descrizione = d.getString("descrizione");
			 Date dataApertura = d.getDate("DataApertura");
			 Date dataChiusura = d.getDate("dataChiusura");
			 Boolean status = d.getBoolean("status");
			 
			 
			 GestioneFormBean bean = new GestioneFormBean(id,autoreForm,titolo,descrizione,dataApertura,dataChiusura,status,topic,"0");
			 
			 //add the bean to the appropriate list
			 if(status == true) {
				 listaFormAperti.add(bean);
			 }else {
				 listaFormChiusi.add(bean);
			 }
		 }
		 listaForm.add(listaFormAperti);
		 listaForm.add(listaFormChiusi);
		 return listaForm;
	 }
	 
	 public static GestioneFormBean getFormById(String id) {
		//DataBase connection
		 String db_name = "HealthCare",
	                db_collection_name = "Form";
		 
		 MongoDatabase db = getConnection().getDatabase(db_name);
		 
		 //Get the "Form" Collection from the DB
		 MongoCollection<Document> col = db.getCollection(db_collection_name);
		 
		 //Query to filter the results, the output is a Finterable<Document> containing
		 //the form
		 FindIterable<Document> cursor = col.find(Filters.eq("_id", new ObjectId(id)));
		 GestioneFormBean bean = null;
		 for(Document d : cursor) {
			 
			 //Bean construction
			 String topic = d.getString("topic");
			 String autoreForm = d.getString("autore");
			 String titolo = d.getString("titolo");
			 String descrizione = d.getString("descrizione");
			 Date dataApertura = d.getDate("DataApertura");
			 Date dataChiusura = d.getDate("dataChiusura");
			 Boolean status = d.getBoolean("status");
			 
			 
			 bean = new GestioneFormBean(id,autoreForm,titolo,descrizione,dataApertura,dataChiusura,status,topic,"0");
		 }
		 return bean;
	 }
}


