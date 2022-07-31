package week4.day1;

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
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		//select From contact 
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img[1]")).click();
		Set<String> fromwindows = driver.getWindowHandles();
		List<String> fromwindlst=new ArrayList<String>(fromwindows);
		String fromFirstwindow=fromwindlst.get(0);
		String fromSecondwindow=fromwindlst.get(1);
		driver.switchTo().window(fromSecondwindow);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]")).click();
				
		//select To contact 
		//Thread.sleep(5000);
		driver.switchTo().window(fromFirstwindow);
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img[1]")).click();
		
		Set<String> toWindows = driver.getWindowHandles();
		List<String> toWindlst=new ArrayList<String>(toWindows);
		//String toFirstWindow=fromFirstwindow;
		String toSecondWindow=toWindlst.get(1);
		driver.switchTo().window(toSecondWindow);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]")).click();
		driver.switchTo().window(fromFirstwindow);
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//Thread.sleep(2000);
		String title = driver.getTitle();
		
		System.out.println("Page Title : " + title);

	}

}
