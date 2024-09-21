package AddUser;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class addUser{
		  public static void main(String[] args){
			WebDriver driver;

		    //WebDriverManager.chromedriver().setup();
		    driver= new ChromeDriver();
		    try{
		      driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
		      driver.manage().window().maximize();
		      WebElement addUserButton= driver.findElement(By.xpath("//button[@ng-click='pop()']"));
		      addUserButton.click();
		      driver.findElement(By.name("FirstName")).sendKeys("Sachin");
		      driver.findElement(By.name("LastName")).sendKeys("Sharma");
		      driver.findElement(By.name("UserName")).sendKeys("Sachin123");
		      driver.findElement(By.name("Password")).sendKeys("Global@123");
		      driver.findElement(By.xpath("//input[@value='15']")).click();
		      driver.findElement(By.xpath("//option[text()='Admin']")).click();
		      driver.findElement(By.name("Email")).sendKeys("Sharma@gmail.com");
		      driver.findElement(By.name("Mobilephone")).sendKeys("1234567890"); 
		      driver.findElement(By.xpath("//button[@ng-click='save(user)']")).click();
		      boolean userFound= false;
		      List<WebElement> rows= driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tbody/tr"));
		      for(WebElement row : rows) {
		    	  String rowText=row.getText();
		    	  if(rowText.contains("Sachin")) {
		    		  userFound= true;
		    		  System.out.println("User Found");
		    		  break;
		    	  }
		      }

		      //Deleting User
		      if(userFound==true) {
		      Thread.sleep(1000);
		      driver.findElement(By.xpath("(//i[@ng-class='iconClass'])[3]")).click();
		      Thread.sleep(1000);
		      driver.findElement(By.xpath("//button[text()='OK']")).click();
		      
		      List<WebElement> updatedRows = driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tbody/tr"));
		      for(WebElement updatedRow : updatedRows) {
		    	  String updatedRowText=updatedRow.getText();
		    	  if(!updatedRowText.contains("Sachin")) {
		    		  System.out.println("User Deleted");
		    		  break;
		    	  }
		    	  
		      }
		      }
		      }
		    catch(Exception e){
		      e.printStackTrace();
		    }
		    
		  }
		}


