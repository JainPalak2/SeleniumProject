package demo4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNew1 {
	WebDriver driver;
	@BeforeTest
	public void beforetest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SAMSUNG\\Desktop\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/");
		driver.manage().window().maximize();
	}
	
		
		@Test(priority=1)
		public void signup() {
			driver.findElement(By.linkText("SignUp")).click();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			driver.findElement(By.id("userName")).sendKeys("sanjaylila");
			driver.findElement(By.id("firstName")).sendKeys("bhansali");
			driver.findElement(By.id("lastName")).sendKeys("dahake");
			driver.findElement(By.id("password")).sendKeys("sanjay145");
			driver.findElement(By.name("confirmPassword")).sendKeys("sanjay145");
			driver.findElement(By.xpath("//input[@value= 'Female' and @type= 'radio']")).click();
			driver.findElement(By.id("emailAddress")).sendKeys("nmo@gmail.com");
			driver.findElement(By.id("mobileNumber")).sendKeys("7894561230");
			driver.findElement(By.name("dob")).sendKeys("10-20-2019");
			driver.findElement(By.id("address")).sendKeys("noida");
			Select sel=new Select(driver.findElement(By.name("securityQuestion")));
			sel.selectByIndex(1);
			driver.findElement(By.id("answer")).sendKeys("Blue");
			driver.findElement(By.name("Submit")).click();
			

		}
	  @Test(priority=2)
	public void doLogin() {

		  driver.findElement(By.name("userName")).sendKeys("lalitha");
		  driver.findElement(By.name("password")).sendKeys("password123");
		  driver.findElement(By.xpath("//input[@name='Login']")).click();
		  WebDriverWait wait=new WebDriverWait(driver,1000);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.name("val")));
		  Assert.assertEquals("Home",driver.getTitle());
		 System.out.println("logged in!");
	  }
	  @Test(priority=3)
	public void TestCart()
	{
		  Actions act = new Actions(driver);
		  act.moveToElement(driver.findElement(By.linkText("All Categories"))).perform();
		  act.moveToElement(driver.findElement(By.linkText("Electronics"))).click().perform();
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  act.moveToElement(driver.findElement(By.linkText("Head Phone"))).click().build().perform();
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  act.moveToElement(driver.findElement(By.linkText("Add to cart"))).click().build().perform();;
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);	 
		 // act.moveToElement(driver.findElement(By.linkText("Cart"))).click();

		 driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
		  driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		  Assert.assertEquals("View Cart",driver.getTitle());
		  driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	      System.out.println("added to cart");
		  driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();

		    
	}
	  
	  
	  @Test(priority=4)
	  public void payment()
	  {
		  driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label")).click();
		   
		  driver.findElement(By.xpath("//a[@href='#' and @id='btn']")).click();
		   
		  Assert.assertEquals("Payment Gateway", driver.getTitle());
		   
		  driver.findElement(By.name("username")).sendKeys("123456");
		   
		  driver.findElement(By.name("password")).sendKeys("Pass@456");
		   
		  driver.findElement(By.xpath("//input[@type='submit'and @value='LOGIN']")).click();
		   
		  Assert.assertEquals("Payment Gateway", driver.getTitle());
		   
		  driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
		   
		  driver.findElement(By.xpath("//input[@type='submit'and @value='PayNow']")).click();
		   
		  Assert.assertEquals("Order Details",driver.getTitle());  
	  }
	  
	  @AfterTest
	  public void AfterTest() {
		  driver.close();
	  }
	}




	

