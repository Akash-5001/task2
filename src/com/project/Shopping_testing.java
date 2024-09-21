package com.project;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shopping_testing {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		//create account -->
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		WebElement sign1= driver.findElement(By.xpath("//li[@class='authorization-link']"));
		sign1.click();
		WebElement name2 = driver.findElement(By.id("email"));
		name2.sendKeys("akashvijay123a@gmail.com");
		WebElement name5 = driver.findElement(By.name("login[password]"));
		name5.sendKeys("Akash123@");
		WebElement create= driver.findElement(By.id("send2"));
		create.click();
		
		//shopping option
		Actions action = new Actions(driver);
		WebElement mens =driver.findElement(By.xpath("//span[text()='Men']"));
		action.moveToElement(mens).build().perform();
		WebElement top =driver.findElement(By.id("ui-id-17"));
		action.moveToElement(top).build().perform();
		WebElement hoodies =driver.findElement(By.id("ui-id-20"));
		hoodies.click();
		
		WebElement sort =driver.findElement(By.id("sorter"));
		Select select = new Select(sort);
		select.selectByValue("price");
		
		WebElement material =driver.findElement(By.xpath("//div[text()='Material']"));
		material.click();
		WebElement hemp =driver.findElement(By.xpath("//a[contains(text(),'Hemp')]"));
		hemp.click();
		WebElement hoodie =driver.findElement(By.xpath("//img[@class='product-image-photo']"));
		action.contextClick(hoodie).build().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> windows = driver.getWindowHandles();
		for(String child : windows) {
			if(!parentWindow.equalsIgnoreCase(child)) {
				System.out.println(child);
				driver.switchTo().window(child);
			}
		}
		String title = driver.getTitle();
		System.out.println(title);
		WebElement size =driver.findElement(By.xpath("//div[@option-id='168']"));
		size.click();
		WebElement green =driver.findElement(By.xpath("//div[@option-label='Green']"));
		green.click();
		System.out.println("color selected");
		WebElement quantity=driver.findElement(By.xpath("//input[@id='qty']"));
		quantity.clear();
		quantity.sendKeys("4");
		WebElement cart =driver.findElement(By.xpath("//button[@title='Add to Cart']"));
		action.click(cart).perform();
		driver.navigate().back();
		driver.switchTo().window(parentWindow);
		
		WebElement clearall =driver.findElement(By.xpath("//span[text()='Clear All']"));
		clearall.click();
        WebElement size1 =driver.findElement(By.xpath("//div[text()='Size']"));
		size1.click();
		WebElement sizel =driver.findElement(By.xpath("//div[@class='swatch-option text '][text()='L']"));
		sizel.click();
		WebElement colour =driver.findElement(By.xpath("//div[text()='Color']"));
		colour.click();
		WebElement red =driver.findElement(By.xpath("//div[@class=\"swatch-option color \"][@option-label=\"Red\"]"));
		red.click();
	
		WebElement hoodie1 =driver.findElement(By.xpath("//a[contains(text(),'Oslo Trek Hoodie')]"));
		action.moveToElement(hoodie1).build().perform();
		WebElement cart1 =driver.findElement(By.xpath("//span[text()='Add to Cart']"));
		cart1.click();
		WebElement mycart =driver.findElement(By.xpath("//a[@class='action showcart']"));
		mycart.click();
		WebElement edit =driver.findElement(By.linkText("View and Edit Cart"));
		edit.click();
		
		
		List<WebElement> qty = driver.findElements(By.xpath("//input[@class='input-text qty']"));
		for (WebElement quantity1 : qty) {
			quantity1.clear();
			quantity1.sendKeys("2");
		}
		WebElement update =driver.findElement(By.xpath("//*[@title='Update Shopping Cart']"));
		update.click();
		WebElement ad =driver.findElement(By.xpath("//div[@class='ea-stickybox-hide']"));
		ad.click();
		Thread.sleep(3000);
		WebElement proceed =driver.findElement(By.xpath("//span[text()='Proceed to Checkout']"));
	    proceed.click();
		Thread.sleep(10000);
		
		
		driver.findElement(By.xpath("//input[@class='input-text'][@name='street[0]']")).sendKeys("22A Kavarapalayam");
		driver.findElement(By.xpath("//input[@class='input-text'][@name='street[1]']")).sendKeys("alice mart");
		driver.findElement(By.xpath("//input[@class='input-text'][@name='street[2]']")).sendKeys("thirunindravur");
		driver.findElement(By.xpath("//input[@class='input-text'][@name='city']")).sendKeys("chennai");
		WebElement place =driver.findElement(By.xpath("//select[@class='select'][@name='country_id']"));
		Select place1 = new Select(place);
		place1.selectByValue("IN");
		WebElement state =driver.findElement(By.xpath("//select[@class='select'][@name='region_id']"));
		Select state1 = new Select(state);
		state1.selectByVisibleText("Tamilnadu");
		driver.findElement(By.name("postcode")).sendKeys("98765");
		driver.findElement(By.name("telephone")).sendKeys("0987654321");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
		Thread.sleep(10000);
		
	}		
	}