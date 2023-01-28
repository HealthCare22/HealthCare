package DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.model.Filters;

import Beans.GestioneFormBean;

public class FormDAO {
    private final MongoCollection<Document> collection;

    private final static String DB_NAME = "HealthCare";
    private final static String COLLECTION_NAME = "Form";

    public FormDAO(MongoClient client) {
        MongoDatabase database = client.getDatabase(FormDAO.DB_NAME);
        this.collection = database.getCollection(FormDAO.COLLECTION_NAME);
    }


    public boolean CreateNewForm(String topic, String titolo, String descrizione, String email) {
        LocalDate todaysDate = LocalDate.now();
        Document document = new Document("topic", topic)
                .append("titolo", titolo)
                .append("descrizione", descrizione)
                .append("status", true)
                .append("DataApertura", todaysDate)
                .append("DataChiusura", null)
                .append("idIntervento", 0)
                .append("autore", email);

        this.collection.insertOne(document);

        return true;
    }

    public List<GestioneFormBean> recuperaForm() {
        FindIterable<Document> cursor = this.collection.find();
        List<GestioneFormBean> listaForm = new ArrayList<>();

        //Creazione lista di form
        for (Document d : cursor) {

            String id = d.getObjectId("_id").toString();
            String topic = d.getString("topic");
            String autoreForm = d.getString("autore");
            String titolo = d.getString("titolo");
            String descrizione = d.getString("descrizione");
            Date dataApertura = d.getDate("DataApertura");
            Date dataChiusura = d.getDate("dataChiusura");
            Boolean status = d.getBoolean("status");


            GestioneFormBean bean = new GestioneFormBean(id, autoreForm, titolo, descrizione, dataApertura, dataChiusura, status, topic, "0");
            listaForm.add(bean);
        }


        return listaForm;
    }

    public List<List<GestioneFormBean>> getFormByStatus(String email) {
        //Query to filter the results, the output is a Finterable<Document> containing
        //every user's form
        FindIterable<Document> cursor = this.collection.find(Filters.all("autore", email));

        //Lists that contain: All the user's forms; Open forms; closed forms;
        List<List<GestioneFormBean>> listaForm = new ArrayList<List<GestioneFormBean>>(2);
        List<GestioneFormBean> listaFormAperti = new ArrayList<>();
        List<GestioneFormBean> listaFormChiusi = new ArrayList<>();

        //Iteration on the result
        for (Document d : cursor) {

            //Bean construction
            String id = d.getObjectId("_id").toString();
            String topic = d.getString("topic");
            String autoreForm = d.getString("autore");
            String titolo = d.getString("titolo");
            String descrizione = d.getString("descrizione");
            Date dataApertura = d.getDate("DataApertura");
            Date dataChiusura = d.getDate("dataChiusura");
            Boolean status = d.getBoolean("status");


            GestioneFormBean bean = new GestioneFormBean(id, autoreForm, titolo, descrizione, dataApertura, dataChiusura, status, topic, "0");

            //add the bean to the appropriate list
            if (status) {
                listaFormAperti.add(bean);
            } else {
                listaFormChiusi.add(bean);
            }
        }
        listaForm.add(listaFormAperti);
        listaForm.add(listaFormChiusi);
        return listaForm;
    }

    public GestioneFormBean getFormById(String id) {
        //Query to filter the results, the output is a Finterable<Document> containing
        //the form
        FindIterable<Document> cursor = this.collection.find(Filters.eq("_id", new ObjectId(id)));
        GestioneFormBean bean = null;
        for (Document d : cursor) {

            //Bean construction
            String topic = d.getString("topic");
            String autoreForm = d.getString("autore");
            String titolo = d.getString("titolo");
            String descrizione = d.getString("descrizione");
            Date dataApertura = d.getDate("DataApertura");
            Date dataChiusura = d.getDate("dataChiusura");
            Boolean status = d.getBoolean("status");


            bean = new GestioneFormBean(id, autoreForm, titolo, descrizione, dataApertura, dataChiusura, status, topic, "0");
        }
        return bean;
    }
}
