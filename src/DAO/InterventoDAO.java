package DAO;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;

import org.bson.Document;

import Beans.GestioneInterventiBean;

public class InterventoDAO {
    private final MongoCollection<Document> collection;

    private final static String DB_NAME = "HealthCare";
    private final static String COLLECTION_NAME = "Intervento";

    public InterventoDAO(MongoClient client) {
        MongoDatabase database = client.getDatabase(InterventoDAO.DB_NAME);
        this.collection = database.getCollection(InterventoDAO.COLLECTION_NAME);
    }

  
    public List<GestioneInterventiBean> addIntervento(String email,String descrizione, String id) {
    	
	        Document document = new Document("email", email)
	        					.append("descrizione", descrizione)
	        					.append("id_form", id);
	        					
	        
	        this.collection.insertOne(document);
	        List<GestioneInterventiBean> tuttiInterventi = recuperaInterventi(id);
	        
	        return tuttiInterventi;
	 }
	 


public  List<GestioneInterventiBean> recuperaInterventi(String id ) {

	
        FindIterable<Document> cursor = this.collection.find(Filters.eq("id_form", id));
        List<GestioneInterventiBean> listaInterventi = new ArrayList<>();

       
	  for(Document d : cursor) {
			
			 String descrizione = d.getString("descrizione");
			 String email_medico = d.getString("email");
			 
			 System.out.println(descrizione);
			 GestioneInterventiBean bean = new GestioneInterventiBean(id,descrizione, email_medico);
			 System.out.println(bean);
			 listaInterventi.add(bean);
			 
		
 }
  
	  return listaInterventi;

 }

}
