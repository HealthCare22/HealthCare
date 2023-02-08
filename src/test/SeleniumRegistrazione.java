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
	public void registrazioneNome2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("name"));
		WebElement nome=driver.findElement(By.id("name"));
		nome.sendKeys("");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	/**
	 * 1.2
	 *Il campo Nome deve contenere al massimo 255 caratteri
	 */
	@Test
	public void registrazioneNome256Caratteri() {
		
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("name"));
		WebElement nome=driver.findElement(By.id("name"));
		nome.sendKeys("Pasqualeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
				 "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
				 "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
				 "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	/**
	 * 1.3
	 * Il campo Nome deve contenere solo caratteri alfabetici o spazi
	 */
	@Test
	public void registrazioneNomeCaratteriSpeciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("name"));
		WebElement nome=driver.findElement(By.id("name"));
		nome.sendKeys("Pasquale95");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	/**
	 * 1.4
	 * Il campo Cognome deve contenere almeno 2 caratteri
	 */
	
	@Test
	public void registrazioneCognome2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("surname"));
		WebElement cognome=driver.findElement(By.id("surname"));
		cognome.sendKeys("");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	/**
	 * 1.5
	 * Il campo Cognome deve contenere al massimo 255 caratteri
	 */
	
	@Test
	public void registrazioneCognome256Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("surname"));
		WebElement cognome=driver.findElement(By.id("surname"));
		cognome.sendKeys("Califanooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	
	/**
	 * 1.6
	 * Il campo Cognome deve contenere solo caratteri alfabetici o spazi
	 */
	@Test
	public void registrazioneCognomeCaratteriSpeciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("surname"));
		WebElement cognome=driver.findElement(By.id("surname"));
		cognome.sendKeys("Califano95");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.7
	 * Il campo Mail deve contenere almeno 2 caratteri
	 */
	@Test
	public void registrazioneMail2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.8
	 * Il campo Mail deve contenere al massino 255 caratteri
	 */
	@Test
	public void registrazioneMail255Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("pasqualecalifanoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo@gmail.com");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.9
	 * Il campo Mail non rispetta il formato stabilito
	 */
	@Test
	public void registrazioneMailFormatoNonStabilito() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("pasqualecalifano*gmail.com");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	

	/**
	 * 1.10
	 * L'email inserita è già presente nel DB
	 */
	@Test
	public void registrazioneMailEsistente() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("pasqualecalifano@gmail.com");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	/**
	 * 1.11
	 * Il campo indirizzo deve contenere almeno 2 caratteri
	 */
	@Test
	public void registrazioneIndirizzo2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		continueRegistration.click();
		
		driver.findElement(By.id("indirizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("");

		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.12
	 * Il campo indirizzo deve contenere al max 255 caratteri
	 */
	@Test
	public void registrazioneIndirizzo256Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		continueRegistration.click();
		
		driver.findElement(By.id("indirizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("Via Dottor Pietro Fimianiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.13
	 * Il campo indirizzo deve contenere solo caratteri alfanumerici
	 */
	@Test
	public void registrazioneIndirizzoCaratteriSpeciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		continueRegistration.click();
		
		driver.findElement(By.id("indirizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("Via Dottor Pietro##Fimiani");

		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.14
	 * Il campo provincia deve contenere minimo 2 caratteri
	 */
	@Test
	public void registrazioneProvincia2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		continueRegistration.click();
		
		driver.findElement(By.id("provincia"));
		WebElement provincia=driver.findElement(By.id("provincia"));
		provincia.sendKeys("");

		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.15
	 * Il campo provincia deve contenere minimo 2 caratteri senza caratteri speciali
	 */
	@Test
	public void registrazioneIndirizzo2CaratteriSpeciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		continueRegistration.click();
		
		driver.findElement(By.id("provincia"));
		WebElement provincia=driver.findElement(By.id("provincia"));
		provincia.sendKeys("SA#");

		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * 1.16
	 * Il campo provincia deve contenere al max 255 caratteri
	 */
	@Test
	public void registrazioneProvincia256Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		continueRegistration.click();
		
		driver.findElement(By.id("provincia"));
		WebElement provincia=driver.findElement(By.id("provincia"));
		provincia.sendKeys("Salernoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");

		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	/**
	 * 1.17
	 * Il campo comune deve contenere min 2 caratteri e non deve essere vuoto
	 */
	@Test
	public void registrazioneComune2CaratteriNonVuoto() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		continueRegistration.click();
		
		driver.findElement(By.id("comune"));
		WebElement comune=driver.findElement(By.id("comune"));
		comune.sendKeys("");

		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	/**
	 * 1.18
	 * Il campo comune deve contenere min 2 caratteri e non deve presentare caratteri speciali
	 */
	@Test
	public void registrazioneComune2CaratteriSpeciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		continueRegistration.click();
		
		driver.findElement(By.id("comune"));
		WebElement comune=driver.findElement(By.id("comune"));
		comune.sendKeys("");

		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	/**
	 * 1.19
	 * Il campo comune deve contenere max 255 caratteri 
	 */
	@Test
	public void registrazioneComune256Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		continueRegistration.click();
		
		driver.findElement(By.id("comune"));
		WebElement comune=driver.findElement(By.id("comune"));
		comune.sendKeys("Castel San Giorgioooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");

		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	
	/**
	 * 1.20
	 * Il campo sesso deve essere valorizzato con una sola scelta tra M, F o altro
	 */
	@Test
	public void registrazioneSesso1Scelta() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("femmina"));
		WebElement sesso=driver.findElement(By.id("femmina"));
		sesso.sendKeys("");
		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		continueRegistration.click();

		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	/**
	 * TCS_1.21
	 * Il campo telefono deve contenere almeno 10 caratteri
	 */
	@Test
	public void registrazioneTelefono10Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		continueRegistration.click();
		
		driver.findElement(By.id("telefono"));
		WebElement telefono=driver.findElement(By.id("telefono"));
		telefono.sendKeys("");

		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_1.22
	 * Il campo telefono deve contenenre al max 11 caratteri
	 */
	@Test
	public void registrazioneTelefono11Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		continueRegistration.click();
		
		driver.findElement(By.id("telefono"));
		WebElement telefono=driver.findElement(By.id("telefono"));
		telefono.sendKeys("333-333455321897");

		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_1.23
	 * Il campo telefono deve contenere solo caratteri numerici al più le prime 3 cifre possono essere separate da un trattino
	 */
	@Test
	public void registrazioneTelefonoCaratteriNonNumerici() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		continueRegistration.click();
		
		driver.findElement(By.id("telefono"));
		WebElement telefono=driver.findElement(By.id("telefono"));
		telefono.sendKeys("333-22BB451");

		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_1.24
	 * Il campo password deve contenenre almeno 8 caratteri, almeno una lettera, almeno un numero, nessuno spazio
	 */
	@Test
	public void registrazioneNoPassword() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	/**
	 * TCS_1.25
	 * Il campo password deve contenenre al massimo 24 caratteri, almeno una lettera, almeno un numero, nessuno spazio
	 */
	@Test
	public void registrazionePassword24Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("***************************************************************");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	/**
	 * TCS_1.26
	 * Il campo password deve contenenere almeno una lettera, almeno un numero, nessuno spazio
	 */
	@Test
	public void registrazionePasswordNoSpazi() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp?");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("******* ****");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	/**
	 * TCS_1.27
	 * Il campo confermapassword non è stato inserito e non corrisponde al campo password
	 */
	@Test
	public void registrazioneConfermapasswordErrata() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");

		driver.findElement(By.id("confirmPassword"));
		WebElement confirmPassword=driver.findElement(By.id("confirmPassword"));
		confirmPassword.sendKeys("***");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_1.28
	 * La registrazione e' avvenuta con successo
	 */
	@Test
	public void registrazioneCorretta() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/registration.jsp");
		
		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("pippopippo1!");
		driver.findElement(By.id("confirmPassword"));
		WebElement confirmPassword=driver.findElement(By.id("confirmPassword"));
		confirmPassword.sendKeys("pippopippo1!");

		WebElement continueRegistration = driver.findElement(By.id("firstFormButton"));
		WebElement finishRegistration = driver.findElement(By.id("secondFormButton"));
		continueRegistration.click();
		finishRegistration.click();

		String actualUrl="http://localhost:8080/HealthCare/RegistrationServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	

}



