package utenza;

public class UtenteBean {

	private int idUtente;
	private int idMMG;
	
	public UtenteBean(int idUtente, int idMMG) {
		super();
		this.idUtente = idUtente;
		this.idMMG = idMMG;
	}
	
	
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public int getIdMMG() {
		return idMMG;
	}
	public void setIdMMG(int idMMG) {
		this.idMMG = idMMG;
	}
	
	
	
}
