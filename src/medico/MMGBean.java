package medico;

public class MMGBean {
	
	public int id;
	public String nome;
	public String cognome;
	public String email;
	public String indirizzo;
	public String data;
	public String sesso;
	public String telefono;
	public String password;
	public String provincia;
	public String comune;
	
	
	public MMGBean(int id, String nome, String cognome, String email, String indirizzo, String data, String sesso, String telefono,
			String password, String provincia, String comune) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.indirizzo = indirizzo;
		this.data = data;
		this.sesso = sesso;
		this.telefono = telefono;
		this.password = password;
		this.provincia = provincia;
		this.comune = comune;
	}
	



	public MMGBean()
	{}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	
	  
	
}
