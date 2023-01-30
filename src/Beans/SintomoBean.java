package Beans;

public class SintomoBean {

	private Integer codice;
	private String nome;
	public SintomoBean(Integer codice, String nome) {
		super();
		this.codice = codice;
		this.nome = nome;
	}
	public Integer getCodice() {
		return codice;
	}
	public void setCodice(Integer codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
