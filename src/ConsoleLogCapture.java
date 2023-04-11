import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class ConsoleLogCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Vibhuti\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		
		//listeners - OnTestFailure 
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//a[@role='button']")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.className("add-to-cart")).click();
		driver.findElement(By.partialLinkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER); //get logEntries object
		List<LogEntry> logs = entry.getAll(); //LogEntryObject - get all method and return all logs in list
		for(LogEntry e : logs) //iterating through list and printing each log message
		{
			System.out.println("Message: "+e.getMessage());
		}
	}

}
