package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumRicercaMalattia {

	    //18.1 minimo 2 caratteri alfabetici
	
		//18.2 massimo 40 caratteri
		
		//18.3 malattia non trovata
		
		//18.4 malattia trovata
	/**
	 * 18.1
	 * Il campo Malattia deve essere compilato e deve avere minimo 2 caratteri alfabetici 
	 */
	@Test
	public void ricercaMalattiaNull() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/RicercaMalattia.jsp");

		driver.findElement(By.id("nomeMalattia"));
		WebElement nomeMalattia=driver.findElement(By.id("nomeMalattia"));
		nomeMalattia.sendKeys("");

		WebElement cercaMalattia = driver.findElement(By.id("cercaPerNomeButton"));
		cercaMalattia.click();

		String actualUrl="http://localhost:8080/HealthCare/RicercaPerNomeServlet?nomeMalattia=";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	/**
	 * 18.2
	 * Il campo Malattia deve contenere al massimo 40 caratteri
	 */
	@Test
	public void ricercaMalattia40Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/RicercaMalattia.jsp");

		driver.findElement(By.id("nomeMalattia"));
		WebElement nomeMalattia=driver.findElement(By.id("nomeMalattia"));
		nomeMalattia.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		WebElement cercaMalattia = driver.findElement(By.id("cercaPerNomeButton"));
		cercaMalattia.click();

		String actualUrl="http://localhost:8080/HealthCare/RicercaPerNomeServlet?nomeMalattia=aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}


	/**
	 * 18.3
	 * La Malattia ricercata non è stata trovata
	 */
	@Test
	public void ricercaMalattiaInesistente() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/RicercaMalattia.jsp");

		driver.findElement(By.id("nomeMalattia"));
		WebElement nomeMalattia=driver.findElement(By.id("nomeMalattia"));
		nomeMalattia.sendKeys("aaaaaaaa");

		WebElement cercaMalattia = driver.findElement(By.id("cercaPerNomeButton"));
		cercaMalattia.click();

		String actualUrl="http://localhost:8080/HealthCare/RicercaPerNomeServlet?nomeMalattia=aaaaaaaa";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	//18.4 ricera malattia trovata con successo
	@Test
	public void ricercaMalattiaEsistente() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/RicercaMalattia.jsp");

		driver.findElement(By.id("nomeMalattia"));
		WebElement nomeMalattia=driver.findElement(By.id("nomeMalattia"));
		nomeMalattia.sendKeys("Progeria");

		WebElement cercaMalattia = driver.findElement(By.id("cercaPerNomeButton"));
		cercaMalattia.click();

		String actualUrl="http://localhost:8080/HealthCare/RicercaPerNomeServlet?nomeMalattia=Progeria";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
}