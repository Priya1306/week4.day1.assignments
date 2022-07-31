package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//open homepage
		driver.findElement(By.id("home")).click();

		Set<String> allwindows=driver.getWindowHandles();
		List<String> listofwindows=new ArrayList<String>(allwindows);
		String secondwindow=listofwindows.get(1);
		driver.switchTo().window(secondwindow);
		System.out.println(driver.getTitle());
		driver.close();

		//switch to first window
		String firstwindow=listofwindows.get(0);
		driver.switchTo().window(firstwindow);

		//Find number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();

		Set<String> allwindows1=driver.getWindowHandles();
		List<String> listofwindows1=new ArrayList<String>(allwindows1);
		int count=listofwindows1.size();
		System.out.println("The number of windows opened is "+count );
		String secondwindow1=listofwindows1.get(1);
		driver.switchTo().window(secondwindow1);
		driver.close();
		String thirdwindow1=listofwindows1.get(2);
		driver.switchTo().window(thirdwindow1);
		driver.close();

		//switch to first window
		String firstwindow1=listofwindows1.get(0);
		driver.switchTo().window(firstwindow1);

		//do not close me
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();

		Set<String> allwindows2=driver.getWindowHandles();
		List<String> listofwindows2=new ArrayList<String>(allwindows2);
		int count1=listofwindows2.size();
		System.out.println("The number of windows again opened is "+count1 );
		String secondwindow2=listofwindows2.get(1);
		driver.switchTo().window(secondwindow2);
		driver.close();
		String thirdwindow2=listofwindows2.get(2);
		driver.switchTo().window(thirdwindow2);
		driver.close();

		//switch to first window
		String firstwindow2=listofwindows2.get(0);
		driver.switchTo().window(firstwindow2);

		//wait for 5 seconds
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(5000);
		Set<String> allwindows3=driver.getWindowHandles();
		List<String> listofwindows3=new ArrayList<String>(allwindows3);
		int count2=listofwindows3.size();
		System.out.println("The number of windows once again opened is "+count2 );
		driver.quit();
	}

}
