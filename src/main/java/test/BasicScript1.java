package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicScript1 {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");
		String titleString =driver.getTitle();
		System.out.println("The Title of the page is: "+ titleString);
		
		WebElement emailElement = driver.findElement(By.id("Email"));
		emailElement.clear();
		emailElement.sendKeys("admin@yourstore.com");
		
		WebElement passElement = driver.findElement(By.id("Password"));
		passElement.clear();
		passElement.sendKeys("admin");
		
		WebElement loginElement = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button"));
		loginElement.click();
		
		
		driver.close();
		driver.quit();
		
	}
	
	
	
	
}
