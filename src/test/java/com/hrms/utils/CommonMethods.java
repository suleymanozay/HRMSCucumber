package com.hrms.utils;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hrms.testbase.PageInitiliazer;


public class CommonMethods  extends PageInitiliazer{
	

	/**
	 * This method will accept the alert
	 * @throws will throw NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.accept();
			} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}
	/**
	 * This method will dismiss the alert
	 * @throws will throw NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
			} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}
	
	/**
	 * This method will get a text from the alert
	 * @return tet of the alert
	 * @throws will throw NoAlertPresentException if alert is not present
	 */
	public static String getAlertText() {
		try {
			Alert alert=driver.switchTo().alert();
			return alert.getText();
			} 
		catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
			return null;
		}
		}
	/**
	 * This method with switch to the frame
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId){
		try {
			driver.switchTo().frame(nameOrId);
			
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
		
	}
	/**
	 * This method with switch to the frame
	 * @param element
	 */
	public static void switchToFrame(WebElement element){
		try {
			driver.switchTo().frame(element);
			
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
		
	}
	/**
	 * This method with switch to the frame
	 * @param index
	 */
	public static void switchToFrame(int index){
		try {
			driver.switchTo().frame(index);
			
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
		
	}
	/**
	 * This method will click on the element usig JSExecutor
	 * @param element
	 */
	public static  void jsClick(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click;", element);
	}
	/**
	 * This method will scroll until specified element
	 * @param element
	 */
	public static  void scrollIntoElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	/**
	 * This method will scroll page down
	 * @param pixel
	 */
	public static  void scrollDown(int pixel) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+pixel+")");
	}
	/**
	 * This method will scroll page up
	 * @param pixel
	 */
	public static  void scrollUP(int pixel) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-"+pixel+")");
	}
	
	/**
	 * This Method is specific element to appear on the 
	 * it will wait until expected
	 * @param String locator (locator of linkText)
	 * @return
	 */
	public static  WebElement explicitWait (String locator) {
		By element=By.linkText(locator);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement visibilElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element)); 
		return visibilElement;
	}
	/**
	 * This Method will take a screen shot
	 * @param  file name
	 * @return
	 * @throws InterruptedException 
	 */
	public static File screenShot(String fileName) throws InterruptedException {
		Thread.sleep(1500);
		TakesScreenshot ts=(TakesScreenshot)driver;		
		File screen=ts.getScreenshotAs(OutputType.FILE);
		try {
			 FileUtils.copyFile(screen, new File("screenShot/"+fileName+".png"));
		} catch (IOException e) {
			System.out.println("Can not take screenshot");
			e.printStackTrace();
			return null;
		}
		return screen;
	}
	/**
	 * This method will take a screenshot
	 * @param fileName
	 */
	public static String takeScreenshot(String fileName) {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MMdd_hhmmss");
		String timeStamp=sdf.format(date.getTime());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		String scrshotFile=Constants.SCREENSHOTS_FILEPATH+fileName+timeStamp+".png";
		try {
			FileUtils.copyFile(file, new File(scrshotFile));
		} catch (IOException e) {
			System.out.println("Cannot take a screenshot");
		}
		return scrshotFile;
	}
	/**
	 * This method will take a screenshot
	 * @param fileName
	 */
	public static void takeAScreenshot(String fileName) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("screenShot/"+fileName+".png"));
		} catch (IOException e) {
			System.out.println("Cannot take a screenshot");
		}
	}
	/**
	 * This method will Capture screenshot of an alert 
	 * @param path
	 * @return
	 * @throws HeadlessException
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static BufferedImage alertScreenShot(String path) throws HeadlessException, AWTException, IOException, InterruptedException {
		Thread.sleep(1000);
		BufferedImage image = new Robot().createScreenCapture(new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	    ImageIO.write(image, "jpg", new File(path));
	    return image;

	}
	/**
	 * This method will enter text
	 * @param element
	 * @param value
	 */
	public static void sendText(WebElement element,String value) {
		//waitForVisibility(element);
		element.clear();
		element.sendKeys(value);
	}
	/**
	 * This method will create an Object Of WebDriverWait
	 * @return WebDriverWait
	 */
	public static  WebDriverWait getWaitObject () {
		WebDriverWait wait=new WebDriverWait(driver, Constants.EXPLICIT_LOAD_TIME);
		return wait;
	}
	/**
	 * This method will wait until element becomes clickable
	 * @param element
	 */
	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element)); 
	}
	/**
	 * This method will wait until element becomes visible
	 * @param element
	 */
	public static void waitForVisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.visibilityOf(element)); 
	}
	/**
	 * This method will wait until element becomes invisible
	 * @param element
	 */
	public static void waitForInvisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.invisibilityOf(element)); 
	}
	/**
	 * This method will click on the element
	 * @param element
	 */
	public static void click(WebElement element) {
		//waitForClickability(element);
		element.click();
	}
	/**
	 * This method will select value from DD
	 * @param element
	 * @param visibleText
	 */
	public static void selectDdValue(WebElement element, String visibleText) {
		Select select = new Select(element);
		List<WebElement>options=select.getOptions();
		boolean isFound=false;
		for (WebElement option : options) {
			if(option.getText().equals(visibleText)) {
				select.selectByVisibleText(visibleText);
				isFound=true;
				break;
			}
			
		}
		if(!isFound) {
			System.out.println("Value "+visibleText+" was not foud in the dropdown");
		}
	}
	/**
	 * This method will select value from DropDown
	 * @param element
	 * @param index
	 */
			
	public static void selectDDValue(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement>options=select.getOptions();
		boolean isFound=false;
		if(options.size()>index) {
			select.selectByIndex(index);
			isFound=true;
	 }
		if(!isFound) {
			System.out.println("Value with index "+index+" was not selected");
		}
	}
	/**
	 * This method will click on the radio based on the text
	 * @param elements
	 * @param radioText
	 */
	public static void clickRadio(List<WebElement> elements, String radioText) {
		for (WebElement el : elements) {
			if(el.getText().equals(radioText)) {
				el.click();
				break;
			}
			
		}
	}
	
	
}
