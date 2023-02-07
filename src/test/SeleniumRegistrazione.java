package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;

public class SeleniumRegistrazione {

	/**
	 * 1.1
	 * Il campo Nome deve contenere almeno 2 caratteri
	 */
	@Test
	public void registrazioneMMGNome2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("nome"));
		WebElement nome=driver.findElement(By.id("nome"));
		nome.sendKeys("");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	/**
	 * 1.2
	 *Il campo Nome deve contenere al massimo 255 caratteri
	 */
	@Test
	public void registrazioneMMGNome256Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("nome"));
		WebElement nome=driver.findElement(By.id("nome"));
		nome.sendKeys("Pasqualeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
				"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
				"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
				"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	/**
	 * 1.3
	 * Il campo Nome deve contenere solo caratteri alfabetici o spazi
	 */
	@Test
	public void registrazioneMMGNomeAS() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("nome"));
		WebElement nome=driver.findElement(By.id("nome"));
		nome.sendKeys("Pasquale95");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	/**
	 * 1.4
	 * Il campo Cognome deve contenere almeno 2 caratteri
	 */
	
	@Test
	public void registrazioneMMGCognome2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("cognome"));
		WebElement cognome=driver.findElement(By.id("cognome"));
		cognome.sendKeys("");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	/**
	 * 1.5
	 * Il campo Cognome deve contenere al massimo 255 caratteri
	 */
	
	@Test
	public void registrazioneMMGCognome256Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("cognome"));
		WebElement cognome=driver.findElement(By.id("cognome"));
		cognome.sendKeys("Califanoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
				"ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
				"ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
				"oooooooooooooooooooooooooooooooooooooo");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	
	/**
	 * 1.6
	 * Il campo Cognome deve contenere solo caratteri alfabetici o spazi
	 */
	@Test
	public void registrazioneMMGCognomeAS() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("cognome"));
		WebElement cognome=driver.findElement(By.id("cognome"));
		cognome.sendKeys("Califano95");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.7
	 * Il campo Mail deve contenere almeno 2 caratteri
	 */
	@Test
	public void registrazioneMMGMail2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.8
	 * Il campo Mail deve contenere al massino 255 caratteri
	 */
	@Test
	public void registrazioneMMGMail255Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("Pasqualecalifanoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
				"ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
				"ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
				"oooooooooooooooooooooooooooooooooooooo@gmail.com");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.9
	 * Il campo Mail non rispetta il formato stabilito
	 */
	@Test
	public void registrazioneMMGMailFormatoStabilito() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("pasquale*califano@gmail.com");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	

	/**
	 * 1.10
	 * L'email inserita è già presente nel DB
	 */
	@Test
	public void registrazioneMMGMail_Gia_presente_nel_DB() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("pasqualecalifano@gmail.com");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	/**
	 * 1.11
	 * Il campo indirizzo deve contenere almeno 2 caratteri
	 */
	@Test
	public void registrazioneMMGIndirizzo_almeno2_caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("indrizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.12
	 * Il campo indirizzo deve contenere al max 255 caratteri
	 */
	@Test
	public void registrazioneMMGIndirizzo_massimo255_caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("indrizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("Via dottor pietro Finianiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.13
	 * Il campo indirizzo deve contenere solo caratteri alfanumerici
	 */
	@Test
	public void registrazioneMMGIndirizzo_solo_alfanumerici() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("indrizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("Via Dottor Pietro##Fimiani");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.14
	 * Il campo provincia deve contenere minimo 2 caratteri
	 */
	@Test
	public void registrazioneMMGProvincia_almeno2_caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("provincia"));
		WebElement provincia=driver.findElement(By.id("provincia"));
		provincia.sendKeys("");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.15
	 * Il campo provincia deve contenere minimo 2 caratteri
	 */
	@Test
	public void registrazioneMMGIndirizzo_almeno2_caratteri2() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("indrizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("S");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.16
	 * Il campo provincia deve contenere minimo 2 caratteri e non sono ammissibili caratteri speciali
	 */
	@Test
	public void registrazioneMMGIndirizzo_almeno2_caratteri_noSpeciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("indrizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("SA#");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.17
	 * Il campo provincia deve contenere al max 255 caratteri
	 */
	@Test
	public void registrazioneMMGcomune_massimo255_caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("indrizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("Salernooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	/**
	 * 1.18
	 * Il campo comune deve contenere min 2 caratteri e non deve essere vuoto
	 */
	@Test
	public void registrazioneMMGComune_almeno2_caratteri_no_vuoto() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("comune"));
		WebElement comune=driver.findElement(By.id("comune"));
		comune.sendKeys("");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	/**
	 * 1.19
	 * Il campo comune deve contenere min 2 caratteri e non deve presentare caratteri speciali
	 */
	@Test
	public void registrazioneMMGcomune_almeno2_caratteri_nospeciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("indrizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("Castel#@SanGiorgio");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	/**
	 * 1.20
	 * Il campo comune deve contenere max 255 caratteri 
	 */
	@Test
	public void registrazioneMMGcomune_max_255caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("indrizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("Castel San Giorgiooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	
	/**
	 * 1.21
	 * Il campo sesso deve essere valorizzato con una sola scelta tra M, F o altro
	 */
	@Test
	public void registrazioneMMGsesso_1Scelta_tra_M_F_altro() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("sesso"));
		WebElement sesso=driver.findElement(By.id("sesso"));
		sesso.sendKeys("");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_1.22
	 * Il campo telefono deve contenere almeno 10 caratteri
	 */
	@Test
	public void registrazioneMMGtelefono_almeno_10Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("telefono"));
		WebElement telefono=driver.findElement(By.id("telefono"));
		telefono.sendKeys("");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_1.23
	 * Il campo telefono deve contenenre al max 11 caratteri
	 */
	@Test
	public void registrazioneMMGTelefono_max11caratt() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("telefono"));
		WebElement telefono=driver.findElement(By.id("telefono"));
		telefono.sendKeys("333-333455321897");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_1.24
	 * Il campo telefono deve contenenre solo caratteri numerici al più le prime 3 cifre possono essere separate da un trattino
	 */
	@Test
	public void registrazioneMMGTelefono_solo_numerici_e_il_trattino_dopo_lePrime3() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("telefono"));
		WebElement telefono=driver.findElement(By.id("telefono"));
		telefono.sendKeys("333-22BB451");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_1.25
	 * Il campo password deve contenenre almeno 8 caratteri, almeno una lettera, almeno un numero, nessuno spazio
	 */
	@Test
	public void registrazioneMMGpassword_min8caratt_minLettera_minNumeroNospazio() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	/**
	 * TCS_1.26
	 * Il campo password deve contenenre almeno 24 caratteri, almeno una lettera, almeno un numero, nessuno spazio
	 */
	@Test
	public void registrazioneMMGpassword_max24caratt_minLettera_minNumeroNospazio() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("soqquadroallasoqquadro2324554lol");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	/**
	 * TCS_1.27
	 * Il campo password deve contenenre almeno una lettera, almeno un numero, nessuno spazio
	 */
	@Test
	public void registrazioneMMGpassword_minLettera_minNumeroNospazio() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("soqquadro alla");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	/**
	 * TCS_1.28
	 * Il campo confermapassword non è stato inserito e non corrisponde al campo password
	 */
	@Test
	public void registrazioneMMGConfermapassword_no_corrispondeza_e_lasciato_vuoto() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("confermaPassword"));
		WebElement confermaPassword=driver.findElement(By.id("confermaPassword"));
		confermaPassword.sendKeys("");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_1.29
	 * Il campo confermapassword non corrisponde al campo password
	 */
	@Test
	public void registrazioneMMGConfermapassword_noCorrispondenza() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("confermaPassword"));
		WebElement confermaPassword=driver.findElement(By.id("confermaPassword"));
		confermaPassword.sendKeys("ciao");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("nonciao");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	/**
	 * TCS_1.30
	 * Il campo confermapassword non corrisponde al campo password
	 */
	@Test
	public void registrazioneMMGConfermapassword_noCorrispondenza2() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("confermaPassword"));
		WebElement confermaPassword=driver.findElement(By.id("confermaPassword"));
		confermaPassword.sendKeys("ciao");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("non ciao");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_1.31
	 * Il campo confermapassword non corrisponde al campo password
	 */
	@Test
	public void registrazioneMMGConfermapassword_noCorrispondenza3() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("confermaPassword"));
		WebElement confermaPassword=driver.findElement(By.id("confermaPassword"));
		confermaPassword.sendKeys("ciaooooooo");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("nonciao");

		WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
		confirmRegistration.click();
		confirmRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/login.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



}



