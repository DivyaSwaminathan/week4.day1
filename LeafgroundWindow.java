package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		
		//open new window 
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winLst=new ArrayList<String>(windowHandles);
		String mainPage=winLst.get(0);
		String newWindow = winLst.get(1);
		driver.switchTo().window(newWindow);
		String title = driver.getTitle();
		System.out.println("New window Title : " + title);
		driver.close();
		driver.switchTo().window(mainPage);
		
		//find number of open windows 
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		int size = windowHandles2.size();
		System.out.println("The number of open windows are " + size);
		List<String> winLst1=new ArrayList<String>(windowHandles2);
		driver.switchTo().window(winLst1.get(1));
		driver.close();
		driver.switchTo().window(winLst1.get(2));
		driver.close();
		driver.switchTo().window(winLst1.get(0));
		
		
		//Do not close me 
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
	    List<String> winLst2=new ArrayList<String>(windowHandles3);
		for (int i=1;i<winLst2.size();i++) {
		driver.switchTo().window(winLst2.get(i));
		driver.close();
		}
		driver.switchTo().window(winLst2.get(0));
		
		
		//wait 5 secs 
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(6000);
		Set<String> wait5sec = driver.getWindowHandles();
		System.out.println("Number of windows after waiting for 5 seconds :" + wait5sec.size());
		
		
	}

}
