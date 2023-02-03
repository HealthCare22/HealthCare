package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumAperturaForm {
	
	//Il campo Topic deve contenere almeno 2 caratteri
	@Test
	public void aperturaForm2Caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/AperturaForm.jsp");
		
		driver.findElement(By.id("topic"));
		WebElement topic=driver.findElement(By.id("topic"));
		driver.findElement(By.id("titolo"));
		WebElement titolo=driver.findElement(By.id("titolo"));
		driver.findElement(By.id("descrizione"));
		WebElement descrizione=driver.findElement(By.id("descrizione"));
		
		topic.sendKeys("");
		titolo.sendKeys("Delucidazioni paziente epilettico");
		descrizione.sendKeys("Ho un dubbio riguardante un paziente affetto da epilessia...");
		
		WebElement apriForm = driver.findElement(By.id("apri-form"));
		apriForm.click();

		String actualUrl="http://localhost:8080/HealthCare/AperturaFormServlet";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}
	
	//Il Topic inserito non esiste
		@Test
		public void aperturaFormTopicInesistente() {
			System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
			WebDriver driver = new EdgeDriver();
			driver.get("http://localhost:8080/HealthCare/AperturaForm.jsp");
			
			driver.findElement(By.id("topic"));
			WebElement topic=driver.findElement(By.id("topic"));
			driver.findElement(By.id("titolo"));
			WebElement titolo=driver.findElement(By.id("titolo"));
			driver.findElement(By.id("descrizione"));
			WebElement descrizione=driver.findElement(By.id("descrizione"));
			
			topic.sendKeys("Epilessiaaaaaaa");
			titolo.sendKeys("Delucidazioni paziente epilettico");
			descrizione.sendKeys("Ho un dubbio riguardante un paziente affetto da epilessia...");
			
			WebElement apriForm = driver.findElement(By.id("apri-form"));
			apriForm.click();

			String actualUrl="http://localhost:8080/HealthCare/AperturaFormServlet";
			String expectedUrl= driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, expectedUrl);

		}
		
		//Il Topic inserito non esiste
				@Test
				public void aperturaFormTitolo2Caratteri() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/AperturaForm.jsp");
					
					driver.findElement(By.id("topic"));
					WebElement topic=driver.findElement(By.id("topic"));
					driver.findElement(By.id("titolo"));
					WebElement titolo=driver.findElement(By.id("titolo"));
					driver.findElement(By.id("descrizione"));
					WebElement descrizione=driver.findElement(By.id("descrizione"));
					
					topic.sendKeys("Epilessiaaaaaaa");
					titolo.sendKeys("Delucidazioni paziente epilettico");
					descrizione.sendKeys("Ho un dubbio riguardante un paziente affetto da epilessia...");
					
					WebElement apriForm = driver.findElement(By.id("apri-form"));
					apriForm.click();

					String actualUrl="http://localhost:8080/HealthCare/AperturaFormServlet";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);

				}
		
		//Il campo Descrizione deve contenere meno di 800 caratteri
		
				@Test
				public void aperturaFormDescrizione800Caratteri() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/AperturaForm.jsp");
					
					driver.findElement(By.id("topic"));
					WebElement topic=driver.findElement(By.id("topic"));
					driver.findElement(By.id("titolo"));
					WebElement titolo=driver.findElement(By.id("titolo"));
					driver.findElement(By.id("descrizione"));
					WebElement descrizione=driver.findElement(By.id("descrizione"));
					
					topic.sendKeys("Epilessia");
					titolo.sendKeys("Delucidazioni paziente epilettico");
					descrizione.sendKeys("Ho un dubbio riguardante un paziente affetto da epilessiaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
							+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa...");
					
					WebElement apriForm = driver.findElement(By.id("apri-form"));
					apriForm.click();

					String actualUrl="http://localhost:8080/HealthCare/AperturaFormServlet";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);

				}
}
