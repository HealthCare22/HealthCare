package gestioneMalattie;

import java.util.ArrayList; 
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;

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


    public List<GestioneMalattieBean> RicercaPerNome(String nomeMalattia, MongoClient client) {
        List<GestioneMalattieBean> listaMalattie = getMalattie(client);
        List<GestioneMalattieBean> listaRisultato = new ArrayList<>();
        for (GestioneMalattieBean m : listaMalattie) {
            if (nomeMalattia.equals(m.getNome())) {
            	listaRisultato.add(m);
            }
        }
        return listaRisultato;
    }

	public List<GestioneMalattieBean> getMalattie(MongoClient client) {
		Hashtable<Integer,String> sintomiTable = getSintomi(client);
        FindIterable<Document> cursor = this.collection.find();
        List<GestioneMalattieBean> listaMalattia = new ArrayList<>();

        for (Document doc : cursor) {

            String nome = doc.getString("nome_malattia");
            Integer codice = doc.getInteger("codice");
            String descrizione = doc.getString("descrizione");
            List<SintomoBean> listaSintomi = new ArrayList<>();
            for(int i=0; i<=5; i++) {
            	Integer codiceSintomo = doc.getInteger("sintomo"+i);
            	if(codiceSintomo!=null) {
            		SintomoBean sintomo = new SintomoBean(codiceSintomo,sintomiTable.get(codiceSintomo));
            		listaSintomi.add(sintomo);
            	}
            }
            listaMalattia.add(new GestioneMalattieBean(codice, nome, descrizione, listaSintomi));
        }
        return listaMalattia;
    }

    private Hashtable<Integer, String> getSintomi(MongoClient client) {
		Hashtable<Integer, String> sintomiTable = new Hashtable<>();
		MongoDatabase database = client.getDatabase(MalattiaDAO.DB_NAME);
		MongoCollection<Document> SintomoCollection = database.getCollection("Sintomo");
		FindIterable<Document> cursor = SintomoCollection.find();
		for(Document d : cursor) {
			Integer codiceSintomo = d.getInteger("codice");
			String nomeSintomo = d.getString("nome_sintomo");
			if(nomeSintomo == null) {
				nomeSintomo = d.getString("nome sintomo");
			}
			sintomiTable.put(codiceSintomo, nomeSintomo);
			System.out.println(nomeSintomo);
		}
		return sintomiTable;
	}

	private class Pair{
    	public GestioneMalattieBean m;
    	public Integer v;
    	
    	public Pair(GestioneMalattieBean m, Integer v) {
    		this.m = m;
    		this.v = v;
    	}
    	
    }
    
	public List<GestioneMalattieBean> ricercaPerSintomi(List<SintomoBean> listaSintomi, MongoClient client) {
		List<GestioneMalattieBean> listaRisultato = new ArrayList<>();
		List<GestioneMalattieBean> listaMalattie = getMalattie(client);
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
			List<SintomoBean> listaSintomiPerMalattia = m.getListaSintomi();
			for(SintomoBean g : listaSintomiPerMalattia) {
				if(s.getCodice() == g.getCodice()) {
					count++;
				}
			}
		}
		return count;
	}
}
