package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
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
		cd.findElement(By.xpath("//div[@id='findLeads']//span[contains(text(), 'Phone')]")).click();
		cd.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9710626060");
		cd.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(3000);
		
		WebElement element = cd.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext']"));
		String leadId = element.getText();
		System.out.println(leadId);
		Thread.sleep(1000);
		element.click();
		//cd.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext']")).click();
		Thread.sleep(1000);
		cd.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		
		Thread.sleep(1000);
		cd.findElement(By.linkText("Find Leads")).click();
		cd.findElement(By.xpath("//label[text()='Lead ID:']/following::input")).sendKeys(leadId);
		cd.findElement(By.xpath("//button[contains(text(), 'Find Leads')]")).click();
		
		Thread.sleep(1000);
		if (cd.findElement(By.xpath("//div[contains(text(), 'No records to display')]")).isDisplayed())
		{
			System.out.println("Lead deleted successfully");
		}
	}
}
