

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class w3schools {

	//Initialization Part

	WebDriver browser = new FirefoxDriver();
	public w3schools() {
		//Declaration Part
		browser.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	public void Alertfn()
	{
		browser.switchTo().frame("iframeResult");
		WebElement tryit = browser.findElement(By.xpath("//button[@onclick='myFunction()' and contains(text(),'Try it')]"));
		tryit.click();
		//Alert Function
		Alert alert = browser.switchTo().alert();
		alert.sendKeys("Karthik");
		alert.accept();
		//alert.dismiss();
		WebElement result = browser.findElement(By.id("demo"));
		System.out.println(result.getText());
		browser.switchTo().parentFrame();
		WebElement home = browser.findElement(By.id("tryhome"));
		home.click();
		String parentWindow = browser.getWindowHandle();
		Set<String> u = browser.getWindowHandles();
		for (String name : u) {
			System.out.println(name +"------"+ browser.getTitle());
			if(!name.equalsIgnoreCase(parentWindow))
			{
				browser.switchTo().window(name);
			}
		}
		WebElement html = browser.findElement(By.xpath("//nav[@id='mySidenav']//*[@class='w3-bar-item w3-button' and contains(text(),'Learn HTML')]"));
		System.out.println(html.getText());
		//browser.close();
		browser.switchTo().window(parentWindow);
		
	}
	private void close()
	{
		browser.close();
	}
	public static void main(String[] args) {
		w3schools Call = new w3schools();
		Call.Alertfn();
       // Call.close();
	}

}
