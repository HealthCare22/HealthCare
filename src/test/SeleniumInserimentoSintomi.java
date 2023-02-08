package test;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class SeleniumInserimentoSintomi {



	// 17.1 il campo sintomo deve avere minimo 2 caratteri --
	
	// 17.2 il campo sintomo deve avere massimo 50 caratteri --
	
	// 17.3 risultato corretto ma nessuna malattia --
	
	// 17.4 risultato corretto --
	
	// secondo sintomo inesistente --
	
	// 17.1 il campo sintomo deve avere minimo 2 caratteri
	@Test
	public void inserimentoNoSintomi() {
	System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
	WebDriver driver = new EdgeDriver();
	driver.get("http://localhost:8080/HealthCare/RicercaMalattia.jsp");

	WebElement perSintomi = driver.findElement(By.id("perSintomi"));
	perSintomi.click();

	driver.findElement(By.id("Sintomo1"));
	WebElement sintomo1=driver.findElement(By.id("Sintomo1"));
	sintomo1.sendKeys("");

	WebElement cercaButton = driver.findElement(By.id("cercaPerSintomiButton"));
	cercaButton.click();

	String actualUrl="http://localhost:8080/HealthCare/RicercaPerSintomiServlet?Sintomo1=";
	String expectedUrl= driver.getCurrentUrl();
	assertEquals(actualUrl, expectedUrl);

	}


	// 17.2 il campo sintomo deve avere massimo 50 caratteri
	@Test
	public void inserimentoSintomi() {
	System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
	WebDriver driver = new EdgeDriver();
	driver.get("http://localhost:8080/HealthCare/RicercaMalattia.jsp");

	WebElement perSintomi = driver.findElement(By.id("perSintomi"));
	perSintomi.click();


	WebElement aggiungiSintomoButton = driver.findElement(By.id("aggiungiSintomoButton"));


	driver.findElement(By.id("Sintomo1"));
	WebElement sintomo1=driver.findElement(By.id("Sintomo1"));
	sintomo1.sendKeys("febbre");
	aggiungiSintomoButton.click();

	driver.findElement(By.id("Sintomo2"));
	WebElement sintomo2=driver.findElement(By.id("Sintomo2"));
	sintomo2.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

	WebElement cercaButton = driver.findElement(By.id("cercaPerSintomiButton"));
	cercaButton.click();

	String actualUrl="http://localhost:8080/HealthCare/RicercaPerSintomiServlet?Sintomo1=febbre&Sintomo2=aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	String expectedUrl= driver.getCurrentUrl();
	assertEquals(actualUrl, expectedUrl);

	}
	
	// 17.3 risultato corretto ma nessuna malattia 
	@Test
	public void inserimento1Sintomi() {
	System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
	WebDriver driver = new EdgeDriver();
	driver.get("http://localhost:8080/HealthCare/RicercaMalattia.jsp");

	WebElement perSintomi = driver.findElement(By.id("perSintomi"));
	perSintomi.click();

	driver.findElement(By.id("Sintomo1"));
	WebElement sintomo1=driver.findElement(By.id("Sintomo1"));
	sintomo1.sendKeys("aaaaaa");

	WebElement cercaButton = driver.findElement(By.id("cercaPerSintomiButton"));
	cercaButton.click();

	String actualUrl="http://localhost:8080/HealthCare/RicercaPerSintomiServlet?Sintomo1=aaaaaa";
	String expectedUrl= driver.getCurrentUrl();
	assertEquals(actualUrl, expectedUrl);

	}
	
	// 17.4 risultato corretto
	@Test
	public void inserimento1SintomoCorretto() {
	System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
	WebDriver driver = new EdgeDriver();
	driver.get("http://localhost:8080/HealthCare/RicercaMalattia.jsp");

	WebElement perSintomi = driver.findElement(By.id("perSintomi"));
	perSintomi.click();

	driver.findElement(By.id("Sintomo1"));
	WebElement sintomo1=driver.findElement(By.id("Sintomo1"));
	sintomo1.sendKeys("diarrea");

	WebElement cercaButton = driver.findElement(By.id("cercaPerSintomiButton"));
	cercaButton.click();

	String actualUrl="http://localhost:8080/HealthCare/RicercaPerSintomiServlet?Sintomo1=diarrea";
	String expectedUrl= driver.getCurrentUrl();
	assertEquals(actualUrl, expectedUrl);

	}
	
	// secondo sintomo inesistente
		@Test
		public void inserimento2Sintomi() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/RicercaMalattia.jsp");

		WebElement perSintomi = driver.findElement(By.id("perSintomi"));
		perSintomi.click();


		WebElement aggiungiSintomoButton = driver.findElement(By.id("aggiungiSintomoButton"));


		driver.findElement(By.id("Sintomo1"));
		WebElement sintomo1=driver.findElement(By.id("Sintomo1"));
		sintomo1.sendKeys("febbre");
		aggiungiSintomoButton.click();

		driver.findElement(By.id("Sintomo2"));
		WebElement sintomo2=driver.findElement(By.id("Sintomo2"));
		sintomo2.sendKeys("aaaaaa");

		WebElement cercaButton = driver.findElement(By.id("cercaPerSintomiButton"));
		cercaButton.click();

		String actualUrl="http://localhost:8080/HealthCare/RicercaPerSintomiServlet?Sintomo1=febbre&Sintomo2=aaaaaa";
		String expectedUrl= driver.getCurrentUrl();
		assertEquals(actualUrl, expectedUrl);

		}
}