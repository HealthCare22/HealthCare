package Beans;

import java.util.Date;

public class GestioneFormBean {
	private int idform;
	private int idmmg;
	private String titolo;
	private String descrizione;
	private Date dataApertura;
	private Date dataChiusura;
	private Boolean Status;
	private String Topic;
	private String idIntervento;
	
	public GestioneFormBean(int idform, int idmmg, String titolo, String descrizione, Date dataApertura,
			Date dataChiusura, Boolean status, String topic, String idIntervento) {
		super();
		this.idform = idform;
		this.idmmg = idmmg;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.dataApertura = dataApertura;
		this.dataChiusura = dataChiusura;
		Status = status;
		Topic = topic;
		this.idIntervento = idIntervento;
	}
	
	
	public int getIdform() {
		return idform;
	}
	public void setIdform(int idform) {
		this.idform = idform;
	}
	public int getIdmmg() {
		return idmmg;
	}
	public void setIdmmg(int idmmg) {
		this.idmmg = idmmg;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Date getDataApertura() {
		return dataApertura;
	}
	public void setDataApertura(Date dataApertura) {
		this.dataApertura = dataApertura;
	}
	public Date getDataChiusura() {
		return dataChiusura;
	}
	public void setDataChiusura(Date dataChiusura) {
		this.dataChiusura = dataChiusura;
	}
	public Boolean getStatus() {
		return Status;
	}
	public void setStatus(Boolean status) {
		Status = status;
	}
	public String getTopic() {
		return Topic;
	}
	public void setTopic(String topic) {
		Topic = topic;
	}
	public String getIdIntervento() {
		return idIntervento;
	}
	public void setIdIntervento(String idIntervento) {
		this.idIntervento = idIntervento;
	}
	
	

	
}
