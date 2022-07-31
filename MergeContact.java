		 /* 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */

package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//table[@name='ComboBox_partyIdFrom']/following::img)[1]")).click();
		
		//switch to second window
		Set<String> allwindows=driver.getWindowHandles();
		List<String> listofwindows=new ArrayList<String>(allwindows);
		String secondwindow=listofwindows.get(1);
		driver.switchTo().window(secondwindow);
		System.out.println(driver.getTitle());
		
		//click on first resulting contact
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("priya");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		
		//switch to first window
		String firstwindow=listofwindows.get(0);
		driver.switchTo().window(firstwindow);	
		driver.findElement(By.xpath("(//table[@name='ComboBox_partyIdFrom']/following::img)[2]")).click();
		
		//switch to second window
		Set<String> allwindows1=driver.getWindowHandles();
		List<String> listofwindows1=new ArrayList<String>(allwindows1);
		String secondwindow1=listofwindows1.get(1);
		driver.switchTo().window(secondwindow1);
		System.out.println(driver.getTitle());
		
		//click on second resulting contact
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("priya");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();
	
		//switch to first window
		String firstwindow1=listofwindows1.get(0);
		driver.switchTo().window(firstwindow1);	
		driver.findElement(By.linkText("Merge")).click();
		
		//alert accept
		Alert a=driver.switchTo().alert();
		String text=a.getText();
		System.out.println(text);
		a.accept();
		
		Thread.sleep(5000);
		String title=driver.getTitle();
		if(title.equals("View Contact | opentaps CRM")) {
			System.out.println("Title is correct");
		}
		else {
			System.out.println("Title is incorrect");
		}
	}

}
