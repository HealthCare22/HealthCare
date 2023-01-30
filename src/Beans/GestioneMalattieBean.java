package Beans;

import java.util.ArrayList;
import java.util.List;

public class GestioneMalattieBean {

	private int idMalattia;
	private String nome;
	private String descrizione;
	private List<Integer> listaSintomi;
	
	public GestioneMalattieBean(int idMalattia, String nome, String descrizione, List<Integer> listaSintomi) {
		super();
		this.idMalattia = idMalattia;
		this.nome = nome;
		this.descrizione = descrizione;
		this.listaSintomi = listaSintomi;
	}
	
	
	public GestioneMalattieBean(int idMalattia, String nome, String descrizione) {
		super();
		this.idMalattia = idMalattia;
		this.nome = nome;
		this.descrizione = descrizione;
		this.listaSintomi = new ArrayList<>();
	}


	public int getIdMalattia() {
		return idMalattia;
	}
	public void setIdMalattia(int idMalattia) {
		this.idMalattia = idMalattia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public List<Integer> getListaSintomi() {
		return listaSintomi;
	}
	public void setListaSintomi(List<Integer> listaSintomi) {
		this.listaSintomi = listaSintomi;
	}
	
	
	
}
