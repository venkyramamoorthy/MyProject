import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class webmail {

	public webmail() {
		
	}
	public void Selfcare()
	{
		String OTP =mail();
		WebDriver browser1 = new FirefoxDriver();
		browser1.get("https://www.google.com");
		browser1.manage().window().maximize(); 
		WebElement search = browser1.findElement(By.id("lst-ib"));
		search.clear();
		search.sendKeys(new String[]{OTP});
		
	}

	public String mail()
	{
		WebDriver browser = new FirefoxDriver();
		browser.get("https://webmail.tcs.com/");
		browser.manage().window().maximize(); 
		WebElement Username= browser.findElement(By.name("Username"));
		Username.sendKeys(new String []{"venkateshraja Govindarajramamoorthy"});
		WebElement Password=browser.findElement(By.name("Password"));
		Password.sendKeys(new String[]{"Venk@tes111111"});
		WebElement Login=browser.findElement(By.id("mybutton"));
		Login.click();
		waiting(30000);
		browser.switchTo().frame("s_MainFrame");
		//Double click Functionality
		Actions action = new Actions(browser);
		action.moveToElement(browser.findElement(By.xpath("//*[contains(text(),'supportdms')]"))).doubleClick().build().perform();
		waiting(15000);
		WebElement desc = browser.findElement(By.cssSelector(".s-stack.s-mailbody"));
		String ls =  desc.getText().substring(0,38).replaceAll("\\D+","");
		System.out.println("Remaining :"+ls);
		return(ls);
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
	public static void main(String[] args) {
		webmail Call = new webmail();
		Call.Selfcare();
	}

}
