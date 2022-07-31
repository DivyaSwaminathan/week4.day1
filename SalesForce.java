package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowsLst=new ArrayList<String>(windowHandles);
		String firstWindow=windowsLst.get(0);
		String secondWindow=windowsLst.get(1);
		driver.switchTo().window(secondWindow);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		String newWindowTitle = driver.getTitle();
		System.out.println("Title of new window : " + newWindowTitle);
		driver.switchTo().window(firstWindow);
		String parentTitle = driver.getTitle();
		System.out.println("Parent window Title" + parentTitle);
		driver.quit();
		
	}

}
