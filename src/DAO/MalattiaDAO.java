package DAO;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.*;
import org.bson.Document;

import Beans.GestioneMalattieBean;

public class MalattiaDAO {
    private final MongoCollection<Document> collection;

    private final static String DB_NAME = "HealthCare";
    private final static String COLLECTION_NAME = "Malattia";

    public MalattiaDAO(MongoClient client) {
        MongoDatabase database = client.getDatabase(MalattiaDAO.DB_NAME);
        this.collection = database.getCollection(MalattiaDAO.COLLECTION_NAME);
    }

    public List<GestioneMalattieBean> RicercaPerNome(String nomeMalattia) {
        FindIterable<Document> cursor = this.collection.find();
        List<GestioneMalattieBean> listaMalattia = new ArrayList<>();

        //Creazione lista di form
        for (Document doc : cursor) {
            if (nomeMalattia.equals(doc.getString("nome_malattia"))) {
                String nome = doc.getString("nome_malattia");
                int codice = doc.getInteger("codice");
                String descrizione = doc.getString("descrizione");

                listaMalattia.add(new GestioneMalattieBean(codice, nome, descrizione));
            }
        }
        return listaMalattia;
    }

    public List<GestioneMalattieBean> getMalattie() {
        FindIterable<Document> cursor = this.collection.find();
        List<GestioneMalattieBean> listaMalattia = new ArrayList<>();

        //Creazione lista di form
        for (Document doc : cursor) {

            String nome = doc.getString("nome_malattia");
            Integer codice = doc.getInteger("codice");
            String descrizione = doc.getString("descrizione");
            listaMalattia.add(new GestioneMalattieBean(codice, nome, descrizione));
        }
        return listaMalattia;
    }
}
