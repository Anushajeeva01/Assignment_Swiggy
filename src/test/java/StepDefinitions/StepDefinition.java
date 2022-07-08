package StepDefinitions;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

public class StepDefinition {
	
	public static WebDriver driver;	
	
	@Before	
	public void BeforeExecution()	
	{
		System.out.println("EXECUTING BEFORE HOOK");
		System.setProperty("webdriver.chrome.driver", "./BrowserUtils/chromedriver.exe");
        driver = new ChromeDriver();        
	}
	
	@After	
	public void AfterExecution()	
	{
		System.out.println("EXECUTING AFTER HOOK");		
		//driver.close();
	}
	 
		@Given("^Swiggy URL is working for the user$")
	    public void swiggy_url_is_working_for_the_user() throws InterruptedException {
			  driver.get("https://www.swiggy.com");
		      driver.manage().window().maximize();       
	    }

	    @When("^user is able to enter location in delivery location$")
	    public void user_is_able_to_enter_location_in_delivery_location() throws InterruptedException {
	    	WebElement Location = driver.findElement(By.id("location")) ;              
	  	      StringBuilder location = new StringBuilder()
	  	    		  .append("Chennai")
	  	    		  .append(",")
	  	    		  .append(" Tamil Nadu")
	  	    		  .append(",")
	  	    		  .append(" India");
	  	      
	  	     		  Location.sendKeys(location);
	  	     		  
	  	     		 Thread.sleep(2000);
	  	    		 WebElement WE1 = driver.findElement(By.className("_2W-T9"));
	  	    		 WE1.click();  	    		   
	    }

	    @When("^user clicks on \"([^\"]*)\" icon in delivery location$")
	    public void user_clicks_on_something_icon_in_delivery_location(String strArg1) throws InterruptedException {
	        WebElement LocateMeIcon = driver.findElement(By.className("LukWG"));
	        LocateMeIcon.click();
	    }

	    @Then("^Check user is able to see restaurants lists$")
	    public void check_user_is_able_to_see_restaurants_lists() throws InterruptedException {
	    	Thread.sleep(2000);
			 String ExpectedURL = driver.getCurrentUrl();
			 if(ExpectedURL.equalsIgnoreCase("https://www.swiggy.com/restaurants"))
			 {
				 System.out.println("User is in India and user can see restaurants lists");
			 }
			 else
			 {
		   System.out.println("User is not in India and user can't be served");
	   }
		 
	    }

	    @Then("^Check user is able to see the error message if its outside India$")
	    public void check_user_is_able_to_see_the_error_message_if_its_outside_india() throws InterruptedException {
	    	Thread.sleep(2000);
			 String ExpectedURL = driver.getCurrentUrl();
			 if(ExpectedURL.equalsIgnoreCase("https://www.swiggy.com/restaurants"))
			 {
				 System.out.println("User is in India and user can see restaurants lists");
			 }
			 else
			 {
		   System.out.println("User is not in India and user can't be served");
	  }
	    }
	    @And("^Search for the food Item$")
	    public void search_for_the_food_item() throws InterruptedException {
	    	Thread.sleep(2000);
	    	WebElement Search = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div/ul/li[5]/div/a/span[2]"));
	    	JavascriptExecutor js =(JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].click()", Search);
	      
	        
	        Thread.sleep(2000);
	        WebElement SearchText =driver.findElement(By.className("_2FkHZ"));
	        SearchText.click();
	        
	        SearchText.sendKeys("Pizza");
	         Thread.sleep(3000);
	         WebElement Button1 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/button[1]/div[2]/div[1]/b"));
	        Button1.click();
	        
	        
	    }

	    @And("^Check user can able to see the search results$")
	    public void check_user_can_able_to_see_the_search_results() throws InterruptedException {
	        
	    	Thread.sleep(3000);
			 String ExpectedURL = driver.getCurrentUrl();
			 if(ExpectedURL.equalsIgnoreCase("https://www.swiggy.com/search?query=Pizza"))
			 {
				 System.out.println("User is able to see the search results successfully");
			 }
			 else
			 {
		   System.out.println("User is not able to see the search results");
	 }
	    }
	    
	    @Then("^user able to add food item$")
	    public void user_able_to_add_food_item() throws InterruptedException {
	    	Thread.sleep(2000);
	        WebElement AddItem = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/div[4]/div[1]/div/div[2]/div/div/div[2]/div[2]/div/div[1]"));
	        JavascriptExecutor js =(JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].click()", AddItem);
	    	
	    	WebElement AdditemButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[3]/div[2]/span[2]"));
	    	JavascriptExecutor js1 =(JavascriptExecutor)driver;
	    	js1.executeScript("arguments[0].click()", AdditemButton);
	    }

	    @And("^Check added food item is in the cart$")
	    public void check_added_food_item_is_in_the_cart() throws InterruptedException {
	    	Thread.sleep(2000);
	    	
	    	WebElement Cart = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div/ul/li[1]/div/div/div/a/span[2]"));
	    	JavascriptExecutor js =(JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].click()", Cart);
	    	
	    	String ExpectedURL = driver.getCurrentUrl();
			 if(ExpectedURL.equalsIgnoreCase("https://www.swiggy.com/checkout"))
			 {
				 System.out.println("Item added to the cart successfully");
			 }
			 else
			 {
		   System.out.println("Item added to the cart is unsuccessful");
	}
	       
	    }}