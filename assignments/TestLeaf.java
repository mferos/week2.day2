package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLeaf {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://acme-test.uipath.com/login");
		chromeDriver.manage().window().maximize();
		
		chromeDriver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
		chromeDriver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
		chromeDriver.findElement(By.xpath("//button[@type = 'submit']")).click();
		
		System.out.println(chromeDriver.getTitle());
		
		chromeDriver.findElement(By.xpath("//a[contains(text(), 'Log Out')]")).click();
		
		chromeDriver.close();
	}

}
