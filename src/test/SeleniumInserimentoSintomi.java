package test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumInserimentoSintomi {
	
	//Uno o più sintomi risultano incorretti

	/**
	 * TCS_17.1
	 * 1 o più sintomi inseriti risultano incorretti
	 */
	@Test
	public void inserimentoSintomi() {
	System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
	WebDriver driver = new EdgeDriver();
	driver.get("http://localhost:8080/HealthCare/RicercaMalattia.jsp");

	driver.findElement(By.id("sintomo1"));
	WebElement sintomo1=driver.findElement(By.id("sintomo1"));
	driver.findElement(By.id("sintomo2"));
	WebElement sintomo2=driver.findElement(By.id("sintomo2"));
	sintomo1.sendKeys("febbre");
	sintomo2.sendKeys("aaaaaaaaaaaaaaaa");

	WebElement cercaButton = driver.findElement(By.id("cercaPerNomeButton"));
	cercaButton.click();

	String actualUrl="http://localhost:8080/HealthCare/MyForm.jsp";
	String expectedUrl= driver.getCurrentUrl();
	assertEquals(actualUrl, not(expectedUrl));

	}
}
