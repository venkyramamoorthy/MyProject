import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class irctc {
	WebDriver browser = new FirefoxDriver();
	public irctc() {
		browser.get("https://www.irctc.co.in");
		browser.manage().window().maximize();
	}
    public void flight()
	{
		WebElement fclick = browser.findElement(By.xpath("//a[@target='_blank' and contains(text(),'Flights')]"));
		fclick.click();
		//Window Handle 
		String parentWindow = browser.getWindowHandle();
		Set<String> u = browser.getWindowHandles();
		for (String name : u) {
			System.out.println(name +"------"+ browser.getTitle());
			if(!name.equalsIgnoreCase(parentWindow))
			{
				browser.switchTo().window(name);
			}
		}
		
		WebElement from = browser.findElement(By.id("origin"));
		from.sendKeys(new String[]{"Mumbai"});
		waiting(2000);
		WebElement fromdrop = browser.findElement(By.xpath("//li[@class='ui-menu-item']"));
		fromdrop.click();
		WebElement To = browser.findElement(By.id("destination"));
		To.sendKeys(new String[]{"chennai"});
		waiting(2000);
		WebElement Todrop = browser.findElement(By.xpath("//li[@class='ui-menu-item']//following::*[@class='ui-menu-item']"));
		Todrop.click();
		//Date format
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DATE, 10);
		SimpleDateFormat formatdate = new SimpleDateFormat("dd/MM/yyyy");
		String date = formatdate.format(c.getTime());
		//DateFormat END
		WebElement datefield = browser.findElement(By.id("departDate"));
		datefield.sendKeys(new String[]{date});
		WebElement search = browser.findElement(By.xpath("//div[@class='srchbtn']"));
		search.click();
		waiting(5000);
		System.out.println(browser.getTitle());
		//browser.close(); 
		browser.switchTo().window(parentWindow);
		//browser.close();
		browser.quit();
		
	}
	public void waiting(int time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void close()
	{
		browser.close();
	}
	public static void main(String[] args) {
		
		irctc call = new irctc();
		call.flight();
		//call.close();
	}
}
