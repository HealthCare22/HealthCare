package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumInserimentoIntervento {


	/**
	 * TCS_8.1
	 *il campo Descrizione deve contenere almeno 2 caratteri
	 */
	@Test
	public void inserimentoIntervento2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/SearchServlet");

		driver.findElement(By.id("descrizione"));
		WebElement descrizione=driver.findElement(By.id("descrizione"));
		descrizione.sendKeys("");

		WebElement pubblica = driver.findElement(By.id("pubblica"));
		pubblica.click();

		String actualUrl="http://localhost:8080/HealthCare/DettagliForm.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	/**
	 * TCS_8.2
	 *il campo Descrizione deve contenere al massimo 800 caratteri
	 */
	@Test
	public void inserimentoIntervento800Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/SearchServlet");

		driver.findElement(By.id("descrizione"));
		WebElement descrizione=driver.findElement(By.id("descrizione"));
		descrizione.sendKeys("Inerente alla patologia da lei descrittaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa...");

		WebElement pubblica = driver.findElement(By.id("pubblica"));
		pubblica.click();

		String actualUrl="http://localhost:8080/HealthCare/DettagliForm.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}
}
