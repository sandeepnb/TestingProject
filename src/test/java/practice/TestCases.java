package practice;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCases {
	
	public static WebDriver driver;
	
	@Test
	public static void testCase1()
	{
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GURANSH\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https:\\facebook.com");
		
		driver.manage().window().maximize();
		
		//find all the links on facebook home page
		
		
		driver.findElement(By.name("firstname")).sendKeys("hello");
		driver.findElement(By.name("lastname")).sendKeys("hi");
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("123456789");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		int countLinks=0;
		for (WebElement link : links) {
			
			System.out.println(link.getAttribute("href")+"     "+link.getText());
			countLinks++;
			
		}
		
		
		System.out.println("Total links on facebook home page are "+countLinks);
		
		

		
		WebElement dropdown_month=driver.findElement(By.id("month"));		
		
		Select select=new Select(dropdown_month);
		
		List<WebElement> list=select.getOptions();
		
		for(WebElement l:list)
		{
			System.out.println(l.getAttribute("value")+"    "+l.getText());
			
			
		}
		
		select.selectByValue("9");
		
		
		WebElement checkBox_Male=driver.findElement(By.xpath("//input[@value='2']"));
		
		if(!checkBox_Male.isSelected())
		{
			
			checkBox_Male.click();
		}
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}
	
	

}
