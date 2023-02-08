package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumAperturaForm {

	// 5.1 Il campo titolo deve contenere almeno 2 caratteri
	
	// 5.2 Il campo titolo deve contenere al massimo 255 caratteri
	
	// 5.3 Il campo titolo non rispetta il formato stabilito
	
	// 5.4 Il campo descrizione deve contenere minimo 2 caratteri
	
	// 5.5 Il campo descrizione deve contenere al massimo 800 caratteri
	
	// 5.6 Il form è stato aperto correttamente
	/**
	 * TCS_5.1
	 *Il titolo deve contenere almeno 2 caratteri 
	 */
	@Test
	public void aperturaFormTitolo2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/AperturaForm.jsp");


		driver.findElement(By.id("titolo"));
		WebElement titolo=driver.findElement(By.id("titolo"));
		driver.findElement(By.id("descrizione"));
		WebElement descrizione=driver.findElement(By.id("descrizione"));

		
		titolo.sendKeys("a");
		descrizione.sendKeys("Ho un dubbio riguardante un paziente affetto da epilessia...");

		WebElement apriForm = driver.findElement(By.id("apri-form"));
		apriForm.click();

		String actualUrl="http://localhost:8080/HealthCare/AperturaFormServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}
	
	//5.2 Il campo titolo deve contenere al massimo 255 caratteri
	@Test
	public void aperturaFormTitolo255Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/AperturaForm.jsp");


		driver.findElement(By.id("titolo"));
		WebElement titolo=driver.findElement(By.id("titolo"));
		driver.findElement(By.id("descrizione"));
		WebElement descrizione=driver.findElement(By.id("descrizione"));

		
		titolo.sendKeys("Delucidazioni paziente epiletticooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		descrizione.sendKeys("Ho un dubbio riguardante un paziente affetto da epilessia...");

		WebElement apriForm = driver.findElement(By.id("apri-form"));
		apriForm.click();

		String actualUrl="http://localhost:8080/HealthCare/AperturaFormServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}



	//5.3 Il campo titolo non rispetta il formato stabilito
	@Test
	public void aperturaFormTitoloCaratteriSpeciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/AperturaForm.jsp");

		
		driver.findElement(By.id("titolo"));
		WebElement titolo=driver.findElement(By.id("titolo"));
		driver.findElement(By.id("descrizione"));
		WebElement descrizione=driver.findElement(By.id("descrizione"));

		
		titolo.sendKeys("Emorragia01*!");
		descrizione.sendKeys("Ho un dubbio riguardante un paziente...");

		WebElement apriForm = driver.findElement(By.id("apri-form"));
		apriForm.click();

		String actualUrl="http://localhost:8080/HealthCare/AperturaFormServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}
	// 5.4 Il campo descrizione deve contenere minimo 2 caratteri
	@Test
	public void aperturaFormDescrizione2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/AperturaForm.jsp");


		driver.findElement(By.id("titolo"));
		WebElement titolo=driver.findElement(By.id("titolo"));
		driver.findElement(By.id("descrizione"));
		WebElement descrizione=driver.findElement(By.id("descrizione"));

		
		titolo.sendKeys("Emorragia");
		descrizione.sendKeys("a");

		WebElement apriForm = driver.findElement(By.id("apri-form"));
		apriForm.click();

		String actualUrl="http://localhost:8080/HealthCare/AperturaFormServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}
	
	// 5.5 Il campo descrizione deve contenere al massimo 800 caratteri
	@Test
	public void aperturaFormDescrizione800Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/AperturaForm.jsp");


		driver.findElement(By.id("titolo"));
		WebElement titolo=driver.findElement(By.id("titolo"));
		driver.findElement(By.id("descrizione"));
		WebElement descrizione=driver.findElement(By.id("descrizione"));

		
		descrizione.sendKeys("Delucidazioni paziente epiletticooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		titolo.sendKeys("Ho un dubbio riguardante un paziente affetto da epilessia...");

		WebElement apriForm = driver.findElement(By.id("apri-form"));
		apriForm.click();

		String actualUrl="http://localhost:8080/HealthCare/AperturaFormServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}
	
	// 5.6 form aperto correttamente
	@Test
	public void aperturaFormCorrettamente() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/AperturaForm.jsp");


		driver.findElement(By.id("titolo"));
		WebElement titolo=driver.findElement(By.id("titolo"));
		driver.findElement(By.id("descrizione"));
		WebElement descrizione=driver.findElement(By.id("descrizione"));

		
		titolo.sendKeys("Delucidazione su paziente epilettico");
		descrizione.sendKeys("Ho un dubbio riguardante un paziente affetto da epilessia...");

		WebElement apriForm = driver.findElement(By.id("apri-form"));
		apriForm.click();

		String actualUrl="http://localhost:8080/HealthCare/AperturaFormServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}
}
