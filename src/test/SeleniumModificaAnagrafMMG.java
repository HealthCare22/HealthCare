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
	@Test
	public void modificaDatiMMG_email_due_caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void modificaDatiMMG_email_255_caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("pasqualeCalifanooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooo");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test
	public void modificaDatiMMG_email_formato_errato() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("pasquale*califano@gmail.com");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test
	public void modificaDatiMMG_email_gia_inserita() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("email"));
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("pasqualecalifano@gmail.com");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	
	@Test
	public void modificaDatiMMG_indirizzo_formato_errato() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("indirizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	} 
	
	@Test
	public void modificaDatiMMG_indirizzo_max_255_caratt() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("indirizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("Via dottor Pietro Fimianiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
				+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void modificaDatiMMG_indirizzo_caratteri_Alfanumerici() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("indirizzo"));
		WebElement indirizzo=driver.findElement(By.id("indirizzo"));
		indirizzo.sendKeys("Via Dottor Pietro##Fimiani");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	

	@Test
	public void modificaDatiMMG_provincia_almeno_2_caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("provincia"));
		WebElement provincia=driver.findElement(By.id("privinica"));
		provincia.sendKeys("");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void modificaDatiMMG_provincia_almeno_2_caratteri2() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("provincia"));
		WebElement provincia=driver.findElement(By.id("privinica"));
		provincia.sendKeys("S");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void modificaDatiMMG_provincia_almeno_2_caratteri_no_speciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("provincia"));
		WebElement provincia=driver.findElement(By.id("privinica"));
		provincia.sendKeys("SA#");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void modificaDatiMMG_provincia_massimo_255() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("provincia"));
		WebElement provincia=driver.findElement(By.id("privinica"));
		provincia.sendKeys("Salernooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void modificaDatiMMG_comune_almeno_2_caratteri_no_vuoto() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("comune"));
		WebElement comune=driver.findElement(By.id("comune"));
		comune.sendKeys("");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void modificaDatiMMG_comune_almeno_2_caratteri_no_speciali() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("comune"));
		WebElement comune=driver.findElement(By.id("comune"));
		comune.sendKeys("Castel#@SanGiorgio");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void modificaDatiMMG_comune_massimo_255_caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("comune"));
		WebElement comune=driver.findElement(By.id("comune"));
		comune.sendKeys("Castel San Giorgioooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
				+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void modificaDatiMMG_telefono_almeno_10_caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("telefono"));
		WebElement telefono=driver.findElement(By.id("telefono"));
		telefono.sendKeys("");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	
	@Test
	public void modificaDatiMMG_telefono_max_11_caratteri() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("telefono"));
		WebElement telefono=driver.findElement(By.id("telefono"));
		telefono.sendKeys("34565768765");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void modificaDatiMMG_telefono_solo_num_e_trattino_() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("telefono"));
		WebElement telefono=driver.findElement(By.id("telefono"));
		telefono.sendKeys("333-22BB451");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	
	@Test
	public void modificaDatiMMG_password_min8caratt_min1lettera_min1nummero_nospazio() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	

	@Test
	public void modificaDatiMMG_password_max24caratt_almeno1lettera_almeno1numero_no_spazio() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("acidoDesossiriborucleico34");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void modificaDatiMMG_password_max24caratt_almeno1lettera_almeno1numero_no_spazio2() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("acido Desossiriborucleico34");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	
	@Test
	public void modificaDatiMMG_confermaPassword_max24caratt_almeno1lettera_almeno1numero_no_spazio() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("confermaPassword"));
		WebElement confermaPassword=driver.findElement(By.id("confermaPassword"));
		confermaPassword.sendKeys("");

		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	
	@Test
	public void modificaDatiMMG_confermaPassword_non_inserito_e_non_corrispondente_al_campo_password() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("confermaPassword"));
		WebElement confermaPassword=driver.findElement(By.id("confermaPassword"));
		confermaPassword.sendKeys("");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("heysiri");
		
		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test
	public void modificaDatiMMG_confermaPassword_corrispondente_al_campo_password() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("confermaPassword"));
		WebElement confermaPassword=driver.findElement(By.id("confermaPassword"));
		confermaPassword.sendKeys("heysiri");

		driver.findElement(By.id("password"));
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("heygoogle");
		
		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void modificaDatiMMG_confermaPassword_non_inserito_e_non_corrispondente_al_campo_password2() {
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/profile.jsp");

		driver.findElement(By.id("confermaPassword"));
		WebElement confermaPassword=driver.findElement(By.id("confermaPassword"));
		confermaPassword.sendKeys("andiamotuttiinsieme");

		driver.findElement(By.id("Password"));
		WebElement Password=driver.findElement(By.id("Password"));
		Password.sendKeys("sicchebbello");
		
		WebElement save = driver.findElement(By.id("save"));
		save.click();

		String actualUrl="http://localhost:8080/HealthCare/profile.jsp";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
}