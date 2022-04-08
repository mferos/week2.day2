package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver cd = new ChromeDriver();
		cd.get("http://leaftaps.com/opentaps/control/login");
		cd.manage().window().maximize();
		
		cd.findElement(By.id("username")).sendKeys("DemoCSR");
		cd.findElement(By.id("password")).sendKeys("crmsfa");
		cd.findElement(By.className("decorativeSubmit")).click();
		cd.findElement(By.linkText("CRM/SFA")).click();
		cd.findElement(By.linkText("Leads")).click();
		cd.findElement(By.linkText("Find Leads")).click();
		cd.findElement(By.xpath("//div[@id='findLeads']//span[contains(text(), 'Email')]")).click();
		cd.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("sangi.kings@gmail.com");
		cd.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		WebElement element = cd.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[@class='linktext']"));
		String name = element.getText();
		System.out.println(name);
		cd.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[@class='linktext']")).click();
		
		cd.findElement(By.xpath("//a[@class='subMenuButton'][contains(text(), 'Duplicate Lead')]")).click();
		if (cd.getTitle().equals("Duplicate Lead"))
		{
			System.out.println("Title verified");
		}
		cd.findElement(By.xpath("//input[@type='submit']")).click();
		if (cd.findElement(By.xpath("//div[@class='form']//span[@id='viewLead_firstName_sp']")).getText().equals(name)) {
			System.out.println("Name is duplicated");
		}
		//cd.close();
	}

}
