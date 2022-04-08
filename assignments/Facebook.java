package week2.day2.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		
		WebElement w;
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(text(), 'Create New Account')]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Mohamed");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Feros");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("feros@testleaf.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Feros123");
		
		
		w = driver.findElement(By.xpath("//select[@id='day']"));
		Select day = new Select(w);
		day.selectByVisibleText("14");
		
		w = driver.findElement(By.xpath("//select[@id='month']"));
		Select month = new Select(w);
		month.selectByVisibleText("Feb");
		
		w = driver.findElement(By.xpath("//select[@id='year']"));
		Select year = new Select(w);
		year.selectByVisibleText("1989");
		
		driver.findElement(By.xpath("//label[contains(text(), 'Female')]")).click();
	}

}
