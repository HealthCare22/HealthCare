package Beans;
import java.util.Date;

public class GestioneFormBean {
	private String idform;
	private String autore;
	private String titolo;
	private String descrizione;
	private Date dataApertura;
	private Date dataChiusura;
	private Boolean Status;

	
	public GestioneFormBean(String idform, String autore, String titolo, String descrizione, Date dataApertura,
			Date dataChiusura, Boolean status) {
		super();
		this.idform = idform;
		this.autore = autore;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.dataApertura = dataApertura;
		this.dataChiusura = dataChiusura;
		Status = status;
	
		
	}
	
	
	public GestioneFormBean(String titolo, Date dataApertura, String topic) {
		super();
		this.titolo = titolo;
		this.dataApertura = dataApertura;
		
	}
	
	


	public GestioneFormBean() {
		super();
	}


	public String getIdform() {
		return idform;
	}
	public void setIdform(String idform) {
		this.idform = idform;
	}
	public String getAutore() {
		return autore;
	}
	public void setIdmmg(String autore) {
		this.autore = autore;
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


	
}
