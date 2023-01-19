package DAO;

import java.util.*;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;

import com.mongodb.client.*;

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
        obj.add(new BasicDBObject("Password", loginPwd));
        
 
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
}
