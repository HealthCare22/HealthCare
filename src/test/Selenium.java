package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver","C:/edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8080/HealthCare/RicercaMalattia.jsp");
		
	}
}
