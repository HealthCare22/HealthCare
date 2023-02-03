package test;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;


public class Selenium {
	


		@Test
		public void registrazioneMMG() {
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


		@Test
		public void ricercaMalattia() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/RicercaMalattia.jsp");
		
		driver.findElement(By.id("nomeMalattia"));
		WebElement nomeMalattia=driver.findElement(By.id("nomeMalattia"));
		nomeMalattia.sendKeys("a");

		WebElement cercaMalattia = driver.findElement(By.id("cercaPerNomeButton"));
		cercaMalattia.click();

		String dettaglioMalattia = driver.findElement(By.id("dettaglio")).getTagName(); 
		String dettaglio= "nessunaMalattia";
		Assert.assertEquals(dettaglio, dettaglioMalattia);

		}


		@Test
		public void inserimentoSintomi() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/RicercaMalattia.jsp");

		driver.findElement(By.id("sintomo1"));
		WebElement sintomo1=driver.findElement(By.id("sintomo1"));
		sintomo1.sendKeys("diarrea");


		WebElement cercaButton = driver.findElement(By.id("cercaPerNomeButton"));
		cercaButton.click();

		String actualUrl="http://localhost:8080/HealthCare/MyForm.jsp";
		String expectedUrl= driver.getCurrentUrl();
		assertEquals(actualUrl, not(expectedUrl));

		}

		@Test
		public void inserimentoIntervento() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/DettaglioFormServlet");

		driver.findElement(By.id("descrizione"));
		WebElement descrizione=driver.findElement(By.id("descrizione"));
		descrizione.sendKeys("");

		WebElement pubblica = driver.findElement(By.id("pubblica"));
		pubblica.click();

		String actualUrl="http://localhost:8080/HealthCare/DettaglioFormServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

		}

		@Test
		public void modificaDatiMMG() {
			System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
			WebDriver driver = new EdgeDriver();
			driver.get("http://localhost:8080/HealthCare/profile.jsp");

			driver.findElement(By.id("nome"));
			WebElement nome=driver.findElement(By.id("nome"));
			nome.sendKeys("");

			WebElement save = driver.findElement(By.id("save"));
			save.click();

			String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
			String expectedUrl= driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, expectedUrl);

		}

		@Test
		public void aperturaForm() {
			System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
			WebDriver driver = new EdgeDriver();
			driver.get("http://localhost:8080/HealthCare/AperturaForm.jsp");

			driver.findElement(By.id("titolo"));
			WebElement titolo=driver.findElement(By.id("titolo"));
			driver.findElement(By.id("descrizione"));
			WebElement descrizione=driver.findElement(By.id("descrizione"));
			titolo.sendKeys("");
			descrizione.sendKeys("");
			WebElement apriForm = driver.findElement(By.id("apri-form"));
			apriForm.click();

			String actualUrl="http://localhost:8080/HealthCare/AperturaFormServlet";
			String expectedUrl= driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, expectedUrl);

		}
  }
