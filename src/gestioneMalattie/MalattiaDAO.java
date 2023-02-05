package gestioneMalattie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;

import org.bson.Document;

public class MalattiaDAO {
    private final MongoCollection<Document> collection;

    private final static String DB_NAME = "HealthCare";
    private final static String COLLECTION_NAME = "Malattia";

    public MalattiaDAO(MongoClient client) {
        MongoDatabase database = client.getDatabase(MalattiaDAO.DB_NAME);
        this.collection = database.getCollection(MalattiaDAO.COLLECTION_NAME);
    }
    
 public boolean existMalattia(String malattia) {
    	
    	 Document doc = this.collection.find(Filters.eq("nome_malattia", malattia)).first();
    	 
    	 if(doc != null) {
    		 return true;
    	 }
    	 
    	 return false;
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
                List<Integer>listaSintomi = new ArrayList<>();
                for(int i=0; i<=5; i++) {
                	Integer sintomo = doc.getInteger("sintomo"+i);
                	if(sintomo!=null) { 
                		listaSintomi.add(sintomo);
                	}
                }

                listaMalattia.add(new GestioneMalattieBean(codice, nome, descrizione, listaSintomi));
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
            List<Integer> listaSintomi = new ArrayList<>();
            for(int i=0; i<=5; i++) {
            	Integer codiceSintomo = doc.getInteger("sintomo"+i);
            	if(codiceSintomo!=null) {
            		listaSintomi.add(codiceSintomo);
            	}
            }
            listaMalattia.add(new GestioneMalattieBean(codice, nome, descrizione, listaSintomi));
        }
        return listaMalattia;
    }

    private class Pair{
    	public GestioneMalattieBean m;
    	public Integer v;
    	
    	public Pair(GestioneMalattieBean m, Integer v) {
    		this.m = m;
    		this.v = v;
    	}
    	
    }
    
	public List<GestioneMalattieBean> getMalattieBySintomi(List<SintomoBean> listaSintomi) {
		List<GestioneMalattieBean> listaRisultato = new ArrayList<>();
		List<GestioneMalattieBean> listaMalattie = getMalattie();
		PriorityQueue<Pair> malattieOrdinate = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.v - o1.v;
			
		}});
		for(GestioneMalattieBean m : listaMalattie) {
			Integer counter=0;
			if((counter = checkSintomo(m,listaSintomi)) > 0) {
				malattieOrdinate.add(new Pair(m,counter));
			}
		}

		for(Pair p : malattieOrdinate) {
			listaRisultato.add(p.m);
		}
		return listaRisultato;
	}

	private int checkSintomo(GestioneMalattieBean m, List<SintomoBean> listaSintomi) {
		int count=0;
		for(SintomoBean s : listaSintomi) {
			List<Integer> listaSintomiPerMalattia = m.getListaSintomi();
			for(Integer g : listaSintomiPerMalattia) {
				if(s.getCodice() == g) {
					count++;
				}
			}
		}
		return count;
	}
}
