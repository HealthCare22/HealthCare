package DAO;

import java.util.*;

import org.bson.Document;

import com.mongodb.BasicDBObject;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;

import Beans.MMGBean;

public class UserDAO {
    private final MongoCollection<Document> collection;

    private final static String DB_NAME = "HealthCare";
    private final static String COLLECTION_NAME = "MMG";

    public UserDAO(MongoClient client) {
        MongoDatabase database = client.getDatabase(UserDAO.DB_NAME);
        this.collection = database.getCollection(UserDAO.COLLECTION_NAME);
    }

    // Method to search a user in the mongodb
    public boolean searchUserInDb(String loginId, String loginPwd) {
        boolean user_found = false;

        // Get the particular record from the mongodb collection        
        List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        obj.add(new BasicDBObject("email", loginId));
        obj.add(new BasicDBObject("password", loginPwd));

        // Form a where query
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("$and", obj);
        System.out.println("Sql query is?= " + whereQuery.toString());

        FindIterable<Document> cursor = this.collection.find(whereQuery);
        for (Document doc : cursor) {
            System.out.println("Found?= " + doc);
            user_found = true;
        }
        return user_found;
    }


    public boolean appendUserInDb(String nome, String cognome, String sesso, String eta, String password, String email,
                                  String provincia, String comune, String indirizzo, String numero_telefono) {

        Document document = new Document("nome_medico", nome)
                .append("cognome", cognome)
                .append("email", email)
                .append("indirizzo", indirizzo)
                .append("sesso", sesso)
                .append("eta", eta)
                .append("provincia", provincia)
                .append("comune", comune)
                .append("telefono", numero_telefono)
                .append("password", password);

        this.collection.insertOne(document);

        return true;
    }

    public MMGBean recuperaUser(String email) {
        FindIterable<Document> cursor = this.collection.find(Filters.eq("email", email));

        String nome = " ", cognome = " ", indirizzo = " ", data = " ", gender = " ", telefono = " ", password = " ", comune = " ", provincia = " ";
        int id = 0;
        for (Document doc : cursor) {
            nome = doc.getString("nome_medico");
            cognome = doc.getString("cognome");
            indirizzo = doc.getString("indirizzo");
            data = doc.getString("eta");
            gender = doc.getString("sesso");
            telefono = doc.getString("telefono");
            password = doc.getString("password");
            comune = doc.getString("comune");
            provincia = doc.getString("provincia");
        }
        System.out.println(data);
        MMGBean mmg = new MMGBean(id, nome, cognome, email, indirizzo, data, gender, telefono, password, provincia, comune);
        return mmg;
    }

    public boolean editUserInDb(String nome, String cognome, String sesso, String eta, String password, String email,
                                String provincia, String comune, String indirizzo, String numero_telefono) {

        boolean user_found = false;

        // Create a query to find the document you want to update
			/*BasicDBObject query = new BasicDBObject("email", email);

			// Create the update object with the new values
			BasicDBObject updateDocument = new BasicDBObject();
			updateDocument.append("$set", new BasicDBObject().append("fieldName", "newFieldValue"));*/
        Document query = new Document("email", email);
        Document update = new Document("$set", new Document("email", email)
                .append("cognome", cognome)
                .append("nome_medico", nome)
                .append("indirizzo", indirizzo)
                .append("sesso", sesso)
                .append("eta", eta)
                .append("provincia", provincia)
                .append("comune", comune)
                .append("telefono", numero_telefono)
                .append("password", password));

        this.collection.updateOne(query, update);
        System.out.println(indirizzo + eta + provincia + comune + numero_telefono + password);
        return user_found;

    }
}