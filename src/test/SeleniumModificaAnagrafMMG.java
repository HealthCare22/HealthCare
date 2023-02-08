package test;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;

public class SeleniumModificaAnagrafMMG {

	//4.1 Il campo Mail deve contenere almeno 2 caratteri
	//4.2 Il campo Mail deve contenere al massimo 255 caratteri
	//4.3 Il campo Mail non rispetta il formato stabilito
	//4.4 L’e-mail inserita è già presente nel database
	//4.5 Il campo Indirizzo deve contenere almeno 2 caratteri
	//4.6 Il campo Indirizzo deve contenere al massimo 255 caratteri
	//4.7 Il campo Indirizzo deve contenere soltanto caratteri alfanumerici
	//4.8 Il campo Provincia deve contenere minimo 2 caratteri
	//4.9 Il campo Provincia non ammette caratteri speciali
	//4.10 Il campo Provincia deve contenere al massimo 255 caratteri
	//4.11 Il campo Comune deve contenere almeno 2 caratteri
	//4.12 Il campo Comune non deve presentare caratteri speciali
	//4.13 Il campo Comune deve contenere al massimo 255 caratteri
	//4.14 Il campo Telefono deve contenere almeno 10 caratteri
	//4.15 Il campo Telefono deve contenere al massimo 11 caratteri
	//4.16 Il campo Telefono deve contenere solo caratteri numerici, al più le prime 3 cifre possono essere separate da un trattino
	//4.17 Il campo Password deve contenere almeno 8 caratteri
	//4.18 Il campo Password deve contenere al massimo 24 caratteri
	//4.19 Il campo Password deve contenere almeno una lettera, almeno un numero e nessuno spazio
	//4.20 Il campo Conferma Password non è stato inserito
	//4.21 Il campo Conferma Password non corrisponde al campo Password
	//4.22 La modifica è avvenuta con successo
	/**
	 * TCS_4.1
	 *Il campo mail deve contenere almeno 2 caratteri 
	 */
	@Test
	public void modificaEmail2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		
		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.2
	 *Il campo mail deve contenere al max 255 caratteri 
	 */
	@Test
	public void modificaEmail256Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		
		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("pasqualecalifanoooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooo@gmail.com");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	//4.3 email formato non corretto
	@Test
	public void modificaEmailCaratteriSpeciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		
		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("pasqualecalifano*gmail.com");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	/**
	 * TCS_4.4
	 *Il campo mail è già presente nel DB
	 */
	@Test
	public void modificaEmailEsistente() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		
		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("pasqualecalifano@gmail.com");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}



	/**
	 * TCS_4.5
	 *Il campo indirizzo deve contenere almeno 2 caratteri
	 */
	@Test
	public void modificaIndirizzo2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement section2 = driver.findElement(By.id("section2"));
		section2.click();
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.6
	 *Il campo indirizzo deve contenere al max 255 caratteri
	 */
	@Test
	public void modificaIndirizzo256Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement section2 = driver.findElement(By.id("section2"));
		section2.click();
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("Via dottor pietro fimianiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.7
	 *Il campo indirizzo deve contenere solo caratteri alfanumerici
	 */
	@Test
	public void modificaIndirizzoCaratteriSpeciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement section2 = driver.findElement(By.id("section2"));
		section2.click();
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("Via Dottor Pietro##Fimiani");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.8
	 *Il campo provincia deve contenere minimo 2 caratteri
	 */
	@Test
	public void modificaProvincia2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement section2 = driver.findElement(By.id("section2"));
		section2.click();
		WebElement provincia=driver.findElement(By.id("provincia"));
		provincia.sendKeys("");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.9
	 *Il campo provincia non deve contenere caratteri speciali
	 */
	@Test
	public void modificaProvinciaCaratteriSpeciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement section2 = driver.findElement(By.id("section2"));
		section2.click();
		WebElement provincia=driver.findElement(By.id("provincia"));
		provincia.sendKeys("SA#");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.10
	 *Il campo provincia deve contenere massimo 256 caratteri
	 */
	@Test
	public void modificaProvincia256Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement section2 = driver.findElement(By.id("section2"));
		section2.click();
		WebElement provincia=driver.findElement(By.id("provincia"));
		provincia.sendKeys("Salernoooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooo");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	/**
	 * TCS_4.11
	 *Il campo comune deve contenere minimo 2 caratteri e non deve essere vuoto
	 */
	@Test
	public void modificaComune2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement section2 = driver.findElement(By.id("section2"));
		section2.click();
		WebElement comune=driver.findElement(By.id("comune"));
		comune.sendKeys("");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.12
	 *Nel campo comune non devono essere presenti caratteri speciali
	 */
	@Test
	public void modificaComuneCaratteriSpeciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement section2 = driver.findElement(By.id("section2"));
		section2.click();
		WebElement comune=driver.findElement(By.id("comune"));
		comune.sendKeys("Castel#@SanGiorgio");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.13
	 *Il campo comune deve contenere max 255 caratteri 
	 */
	@Test
	public void modificaComune256Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement section2 = driver.findElement(By.id("section2"));
		section2.click();
		WebElement comune=driver.findElement(By.id("comune"));
		comune.sendKeys("CastelSanGiorgiooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooo");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.14
	 *Il campo telefono deve contenere almeno 10 caratteri 
	 */
	@Test
	public void modificaTelefono10Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement section2 = driver.findElement(By.id("section2"));
		section2.click();
		WebElement telefono=driver.findElement(By.id("telefono"));
		telefono.sendKeys("");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.15
	 *Il campo comune deve contenere max 11 caratteri
	 */
	@Test
	public void modificaTelefono11Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement section2 = driver.findElement(By.id("section2"));
		section2.click();
		WebElement telefono=driver.findElement(By.id("telefono"));
		telefono.sendKeys("333455321897");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	/**
	 * TCS_4.16
	 *Il campo comune deve contenere solo caratteri numerici, al più le prime 3 cifre possono essere separate dal trattino
	 */
	@Test
	public void modificaTelefonCaratteriNonNumerici() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement section2 = driver.findElement(By.id("section2"));
		section2.click();
		WebElement telefono=driver.findElement(By.id("telefono"));
		telefono.sendKeys("33322BB451");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/EditProfile";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.17
	 *Il campo password deve contenere almeno 8 caratteri, almeno 1 lettera, almeno 1 numero, nessuno spazio
	 */
	@Test
	public void modificaPassword8Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("***");

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.18
	 *Il campo passsord deve contenere al max 24, almeno 1 lettera, 1 numero, no spazi
	 */

	@Test
	public void modificaPassword24Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("**************************************");

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.19
	 *Il campo passsord deve contenere, almeno 1 lettera, 1 numero, no spazi
	 */
	@Test
	public void modificaPasswordCaratteriSpeciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("***");

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}


	/**
	 * TCS_4.20
	 *Il campo confermaPasssord non è stato inserito e non corrisponde al campo password
	 */
	@Test
	public void modificaConfermaPasswordNull() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
	
		WebElement ConfermaPassword=driver.findElement(By.id("password"));
		ConfermaPassword.sendKeys("");

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	/**
	 * TCS_4.21
	 *Il campo confermaPasssord non corrisponde al campo password
	 */
	@Test
	public void modificaConfermaPasswordNonCorrisponde() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
	
		WebElement ConfermaPassword=driver.findElement(By.id("password"));
		ConfermaPassword.sendKeys("*********");

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	/**
	 * TCS_4.22
	 *Il campo confermaPasssord non corrisponde al campo password
	 */
	@Test
	public void modificaCorretta() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement mail=driver.findElement(By.id("email"));
		mail.sendKeys("albera@gmail.com");
		driver.findElement(By.id("password"));
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("pippopippo1!");
		WebElement loginbutton = driver.findElement(By.id("login-button"));
		loginbutton.click();
		
		driver.get("http://localhost:8080/HealthCare/profile.jsp");
		
		WebElement edit = driver.findElement(By.id("edit"));
		edit.click();
		
		WebElement Password=driver.findElement(By.id("password"));
		Password.sendKeys("pippopippo1!");
		WebElement ConfermaPassword=driver.findElement(By.id("password"));
		ConfermaPassword.sendKeys("pippopippo1!");

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

}