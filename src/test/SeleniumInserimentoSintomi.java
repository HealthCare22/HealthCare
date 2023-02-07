package test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumInserimentoSintomi {
	
	

	/**
	 * TCS_17.1
	 * 1 o più sintomi inseriti risultano incorretti
	 */
	
	//nessun sintomo inserito
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

	String actualUrl="http://localhost:8080/HealthCare/MyForm.jsp";
	String expectedUrl= driver.getCurrentUrl();
	assertEquals(actualUrl, not(expectedUrl));

	}


	//Uno o più sintomi risultano incorretti
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

	String actualUrl="http://localhost:8080/HealthCare/MyForm.jsp";
	String expectedUrl= driver.getCurrentUrl();
	assertEquals(actualUrl, not(expectedUrl));

	}
	
}
