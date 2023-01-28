package DAO;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.*;
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

    public boolean addIntervento(String email, String descrizione, String id) {
        Document document = new Document("email", email)
                .append("descrizione", descrizione)
                .append("id_form", id);

        this.collection.insertOne(document);

        return true;
    }

    public List<GestioneInterventiBean> recuperaInterventi(String identificatore, String email) {
        FindIterable<Document> cursor = this.collection.find();
        List<GestioneInterventiBean> listaInterventi = new ArrayList<>();

        //Creazione lista di form
        for (Document d : cursor) {
            if (email.equals(d.getString(identificatore))) {

                String id = d.getString("id_form");
                String descrizione = d.getString("descrizione");
                String email_medico = d.getString("email");


                GestioneInterventiBean bean = new GestioneInterventiBean(id, descrizione, email_medico);
                listaInterventi.add(bean);
            }
        }

        return listaInterventi;
    }
}
