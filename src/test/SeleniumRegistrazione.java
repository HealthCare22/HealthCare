package test;

	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
	import static org.junit.Assert.assertEquals;
	import static org.hamcrest.CoreMatchers.*;
	import org.junit.Assert;

	public class SeleniumRegistrazione {

		//Il campo Nome deve contenere almeno 2 caratteri
		@Test
		public void registrazioneMMGNome2Caratteri() {
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
		
		//Il campo Nome deve contenere al massimo 255 caratteri
			@Test
			public void registrazioneMMGNome256Caratteri() {
				System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
				WebDriver driver = new EdgeDriver();
				driver.get("http://localhost:8080/HealthCare/registration.jsp?");

				driver.findElement(By.id("nome"));
				WebElement nome=driver.findElement(By.id("nome"));
				nome.sendKeys("Pasqualeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
							  "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
						      "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
							  "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

				WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
				confirmRegistration.click();
				confirmRegistration.click();

				String actualUrl="http://localhost:8080/HealthCare/login.jsp";
				String expectedUrl= driver.getCurrentUrl();
				Assert.assertEquals(actualUrl, expectedUrl);

			}
			
			//Il campo Nome deve contenere solo caratteri alfabetici o spazi
			@Test
			public void registrazioneMMGNomeAS() {
				System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
				WebDriver driver = new EdgeDriver();
				driver.get("http://localhost:8080/HealthCare/registration.jsp?");

				driver.findElement(By.id("nome"));
				WebElement nome=driver.findElement(By.id("nome"));
				nome.sendKeys("Pasquale95");

				WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
				confirmRegistration.click();
				confirmRegistration.click();

				String actualUrl="http://localhost:8080/HealthCare/login.jsp";
				String expectedUrl= driver.getCurrentUrl();
				Assert.assertEquals(actualUrl, expectedUrl);

			}
			
			//Il campo Cognome deve contenere almeno 2 caratteri
				@Test
				public void registrazioneMMGCognome2Caratteri() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("cognome"));
					WebElement cognome=driver.findElement(By.id("cognome"));
					cognome.sendKeys("");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);

					}
		
				//Il campo Cognome deve contenere al massimo 255 caratteri
				@Test
				public void registrazioneMMGCognome256Caratteri() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("cognome"));
					WebElement cognome=driver.findElement(By.id("cognome"));
					cognome.sendKeys("Califanoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
								  "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
							      "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
								  "oooooooooooooooooooooooooooooooooooooo");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);

				}
				
				//Il campo Cognome deve contenere solo caratteri alfabetici o spazi
				@Test
				public void registrazioneMMGCognomeAS() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("cognome"));
					WebElement cognome=driver.findElement(By.id("cognome"));
					cognome.sendKeys("Califano95");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);

				}

				//Il campo Mail deve contenere almeno 2 caratteri
				@Test
				public void registrazioneMMGMail2Caratteri() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("email"));
					WebElement email=driver.findElement(By.id("email"));
					email.sendKeys("");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);

				}
			
				//Il campo Mail deve contenere al massino 255 caratteri
				@Test
				public void registrazioneMMGMail255Caratteri() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("email"));
					WebElement email=driver.findElement(By.id("email"));
					email.sendKeys("Pasqualecalifanoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
							  "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
						      "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" +
							  "oooooooooooooooooooooooooooooooooooooo@gmail.com");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				//Il campo Mail non rispetta il formato stabilito
				@Test
				public void registrazioneMMGMailFormatoStabilito() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("email"));
					WebElement email=driver.findElement(By.id("email"));
					email.sendKeys("pasquale*califano@gmail.com");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				@Test
				public void registrazioneMMGMail_Gia_presente_nel_DB() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("email"));
					WebElement email=driver.findElement(By.id("email"));
					email.sendKeys("pasqualecalifano@gmail.com");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				
				@Test
				public void registrazioneMMGIndirizzo_almeno2_caratteri() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("indrizzo"));
					WebElement indirizzo=driver.findElement(By.id("indirizzo"));
					indirizzo.sendKeys("");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				@Test
				public void registrazioneMMGIndirizzo_massimo255_caratteri() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("indrizzo"));
					WebElement indirizzo=driver.findElement(By.id("indirizzo"));
					indirizzo.sendKeys("Via dottor pietro Finianiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
							+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
							+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
							+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				@Test
				public void registrazioneMMGIndirizzo_solo_alfanumerici() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("indrizzo"));
					WebElement indirizzo=driver.findElement(By.id("indirizzo"));
					indirizzo.sendKeys("Via Dottor Pietro##Fimiani");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				@Test
				public void registrazioneMMGProvincia_almeno2_caratteri() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("provincia"));
					WebElement provincia=driver.findElement(By.id("provincia"));
					provincia.sendKeys("");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}

				@Test
				public void registrazioneMMGIndirizzo_almeno2_caratteri2() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("indrizzo"));
					WebElement indirizzo=driver.findElement(By.id("indirizzo"));
					indirizzo.sendKeys("S");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
	
				@Test
				public void registrazioneMMGIndirizzo_almeno2_caratteri_noSpeciali() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("indrizzo"));
					WebElement indirizzo=driver.findElement(By.id("indirizzo"));
					indirizzo.sendKeys("SA#");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
	
				@Test
				public void registrazioneMMGcomune_massimo255_caratteri() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("indrizzo"));
					WebElement indirizzo=driver.findElement(By.id("indirizzo"));
					indirizzo.sendKeys("Salernooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
							+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
							+ "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				
				@Test
				public void registrazioneMMGComune_almeno2_caratteri_no_vuoto() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("comune"));
					WebElement comune=driver.findElement(By.id("comune"));
					comune.sendKeys("");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				
				@Test
				public void registrazioneMMGcomune_almeno2_caratteri_nospeciali() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("indrizzo"));
					WebElement indirizzo=driver.findElement(By.id("indirizzo"));
					indirizzo.sendKeys("Castel#@SanGiorgio");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				
				@Test
				public void registrazioneMMGcomune_max_255caratteri() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("indrizzo"));
					WebElement indirizzo=driver.findElement(By.id("indirizzo"));
					indirizzo.sendKeys("Castel San Giorgiooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
							+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
							+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
							+ "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				@Test
				public void registrazioneMMGsesso_1Scelta_tra_M_F_altro() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("sesso"));
					WebElement sesso=driver.findElement(By.id("sesso"));
					sesso.sendKeys("");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				
				@Test
				public void registrazioneMMGsesso_almeno_10Caratteri() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("sesso"));
					WebElement sesso=driver.findElement(By.id("sesso"));
					sesso.sendKeys("M");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				@Test
				public void registrazioneMMGTelefono_max11caratt() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("telefono"));
					WebElement telefono=driver.findElement(By.id("telefono"));
					telefono.sendKeys("333-333455321897");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				
				@Test
				public void registrazioneMMGTelefono_solo_numerici_e_il_trattino_dopo_lePrime3() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("telefono"));
					WebElement telefono=driver.findElement(By.id("telefono"));
					telefono.sendKeys("333-22BB451");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				@Test
				public void registrazioneMMGpassword_min8caratt_minLettera_minNumeroNospazio() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("password"));
					WebElement password=driver.findElement(By.id("password"));
					password.sendKeys("");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				
				@Test
				public void registrazioneMMGpassword_max24caratt_minLettera_minNumeroNospazio() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("password"));
					WebElement password=driver.findElement(By.id("password"));
					password.sendKeys("soqquadroallasoqquadro2324554lol");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}


				@Test
				public void registrazioneMMGpassword_minLettera_minNumeroNospazio() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("password"));
					WebElement password=driver.findElement(By.id("password"));
					password.sendKeys("soqquadro alla");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
	
				
				@Test
				public void registrazioneMMGConfermapassword_no_corrispondeza_e_lasciato_vuoto() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("confermaPassword"));
					WebElement confermaPassword=driver.findElement(By.id("confermaPassword"));
					confermaPassword.sendKeys("");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}

				@Test
				public void registrazioneMMGConfermapassword_noCorrispondenza() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("confermaPassword"));
					WebElement confermaPassword=driver.findElement(By.id("confermaPassword"));
					confermaPassword.sendKeys("ciao");
					
					driver.findElement(By.id("password"));
					WebElement password=driver.findElement(By.id("password"));
					password.sendKeys("nonciao");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				
				@Test
				public void registrazioneMMGConfermapassword_noCorrispondenza2() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("confermaPassword"));
					WebElement confermaPassword=driver.findElement(By.id("confermaPassword"));
					confermaPassword.sendKeys("ciao");
					
					driver.findElement(By.id("password"));
					WebElement password=driver.findElement(By.id("password"));
					password.sendKeys("non ciao");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				@Test
				public void registrazioneMMGConfermapassword_noCorrispondenza3() {
					System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
					WebDriver driver = new EdgeDriver();
					driver.get("http://localhost:8080/HealthCare/registration.jsp?");

					driver.findElement(By.id("confermaPassword"));
					WebElement confermaPassword=driver.findElement(By.id("confermaPassword"));
					confermaPassword.sendKeys("ciaooooooo");
					
					driver.findElement(By.id("password"));
					WebElement password=driver.findElement(By.id("password"));
					password.sendKeys("nonciao");

					WebElement confirmRegistration = driver.findElement(By.id("firstFormButton"));
					confirmRegistration.click();
					confirmRegistration.click();

					String actualUrl="http://localhost:8080/HealthCare/login.jsp";
					String expectedUrl= driver.getCurrentUrl();
					Assert.assertEquals(actualUrl, expectedUrl);
				}
				
				
	
	}
	
	

