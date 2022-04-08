package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	static String companyName = "Test Leaf India";
	
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
		cd.findElement(By.xpath("//div[@id='findLeads']//input[@name='firstName']")).sendKeys("Mohamed");
		cd.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		cd.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		cd.findElement(By.xpath("//a[@class='subMenuButton'][contains(text(),'Edit')]")).click();
		cd.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		cd.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys(companyName);
		cd.findElement(By.xpath("//input[@name='submitButton'][@value='Update']")).click();
		
		if (cd.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText().contains(companyName)) {
			System.out.println("Company name updated");
		} else {
			System.out.println("Company name not updated");
		}
		Thread.sleep(2000);
		cd.close();
	}

}
