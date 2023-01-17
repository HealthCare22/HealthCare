	import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class ConnectionDB {
    public static void main( String[] args ) {
        // Replace the placeholder with your MongoDB deployment's connection string
        String uri = "mongodb+srv://root:root@healthcare.i5mrfxx.mongodb.net/test";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("HealthCare");
            MongoCollection<Document> collection = database.getCollection("Sintomo");
            Document doc = collection.find(eq("nome_sintomo", "febbre")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }

        }
    }
}