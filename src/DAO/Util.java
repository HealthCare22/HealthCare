package DAO;

import java.util.*;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;

import Beans.GestioneFormBean;
import Beans.MMGBean;

public class Util {
	// Method to make a connection to the mongodb server listening on a default port
    private static com.mongodb.client.MongoClient getConnection() {
        String uri = "mongodb+srv://root:root@healthcare.i5mrfxx.mongodb.net/test";
 
        	com.mongodb.client.MongoClient mongoClient =  MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("HealthCare");
            MongoCollection<Document> collection = database.getCollection("MMG");
			return mongoClient;
}
 
    // Method to search a user in the mongodb
    public static boolean searchUserInDb(String loginId, String loginPwd) {
        boolean user_found = false;
        String db_name = "HealthCare",
                db_collection_name = "MMG";
 
        // Get the mongodb connection
        MongoDatabase db = getConnection().getDatabase(db_name);
 
        // Get the mongodb collection.
        MongoCollection<Document> col = db.getCollection(db_collection_name);
 
        // Get the particular record from the mongodb collection        
        List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        obj.add(new BasicDBObject("email", loginId));
        obj.add(new BasicDBObject("password", loginPwd));
        
        // Form a where query
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("$and", obj);
        System.out.println("Sql query is?= " + whereQuery.toString());
 
        FindIterable<Document> cursor = col.find(whereQuery);
        for(Document doc : cursor) {
            System.out.println("Found?= " + doc);
            user_found = true;
        }
        return user_found;
    }


public static boolean appendUserInDb(String nome, String cognome, String sesso, String data, String password, String email,
		String provincia, String comune, String indirizzo, String numero_telefono) {
		
		boolean user_found = false;
			String db_name = "HealthCare",
			db_collection_name = "MMG";
		
			// Get the mongodb connection
			MongoDatabase db = getConnection().getDatabase(db_name);

			// Get the mongodb collection.
			MongoCollection<Document> col = db.getCollection(db_collection_name);
	
			Document document = new Document("nome_medico", nome)
			.append("cognome", cognome)
			.append("email", email)
			.append("indirizzo", indirizzo)
			.append("sesso", sesso)
			.append("data", data)
			.append("provincia", provincia)
			.append("comune", comune)
			.append("telefono", numero_telefono)
			.append("password", password);

			col.insertOne(document);

			System.out.println(col);
			return true;
			}

public static MMGBean recuperaUser(String email){
	 
	 String db_name = "HealthCare",
               db_collection_name = "MMG";

	
       MongoDatabase db = getConnection().getDatabase(db_name);
       MongoCollection<Document> col = db.getCollection(db_collection_name);
       
    FindIterable<Document> cursor = col.find(Filters.eq("email", email));

    String nome= " ", cognome= " ", indirizzo= " ", gender= " ", telefono= " ", password= " ", comune= " ", provincia= " ";
    int id=0;
    for(Document doc : cursor) {       
            nome = doc.getString("nome_medico");
            cognome = doc.getString("cognome");
            indirizzo = doc.getString("indirizzo");
            gender = doc.getString("Sesso");
            telefono = doc.getString("telefono");
            password = doc.getString("password");
            comune = doc.getString("comune");
            provincia = doc.getString("provincia");
    }
    MMGBean mmg = new MMGBean(id,nome,cognome,email,indirizzo,gender,telefono,password,provincia,comune);
    return mmg;
}
}
