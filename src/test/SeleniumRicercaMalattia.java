package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumRicercaMalattia {
	
	
	//Il campo Malattia deve essere compilato e deve avere minimo 2 caratteri alfabetici
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

	String dettaglioMalattia = driver.findElement(By.id("dettaglio")).getTagName(); 
	String dettaglio= "nessunaMalattia";
	Assert.assertEquals(dettaglio, dettaglioMalattia);

	}
	
	//Il campo Malattia deve contenere al massimo 40 caratteri
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

		String dettaglioMalattia = driver.findElement(By.id("dettaglio")).getTagName(); 
		String dettaglio= "nessunaMalattia";
		Assert.assertEquals(dettaglio, dettaglioMalattia);

		}
		
		
		
		//La Malattia ricercata non esiste
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

		String dettaglioMalattia = driver.findElement(By.id("dettaglio")).getTagName(); 
		String dettaglio= "nessunaMalattia";
		Assert.assertEquals(dettaglio, dettaglioMalattia);

		}
				
				
				
}
