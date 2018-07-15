package com.deltax.utils;

import com.deltax.browser.BaseBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumUtils {

  String browser = new ReadProperties().readProperties().getProperty("browser");
  
  BaseBrowser getDriver = new BaseBrowser();
  WebDriver driver = getDriver.launchBrowser(browser);

  WebDriverWait wait = new WebDriverWait(driver, 20);

  public void launchUrl(String url) {
    if (url == null) {
      throw new NullPointerException();
    }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(url);
  }
  
  public void refresh(){
    driver.navigate().refresh();
  }

  public boolean click(By locator) {
    try {
      wait.until(ExpectedConditions.elementToBeClickable(locator));
      driver.findElement(locator).click();
      return true;
    } catch (ElementClickInterceptedException ex) {
      ex.printStackTrace();
    }
    return false;
  }

  public boolean sendText(By locator, String inputText) {
    try {
      wait.until(ExpectedConditions.presenceOfElementLocated(locator));
      driver.findElement(locator).clear();
      driver.findElement(locator).sendKeys(inputText);
      return true;
    } catch (ElementNotInteractableException ex) {
      ex.printStackTrace();
    }
    return false;
  }

  public boolean selectByVisibleText(By locator, String value) {
    try {
      wait.until(ExpectedConditions.presenceOfElementLocated(locator));
      WebElement mySelectElement = driver.findElement(locator);
      Select select = new Select(mySelectElement);
      select.selectByVisibleText(value);
      return true;
    } catch (ElementNotInteractableException ex) {
      ex.printStackTrace();
    }
    return false;
  }
  
  public int getCount(By locator){
    List<WebElement> count = driver.findElements(locator);
    return count.size();
  }
  
  public boolean isDisplayed(By locator, String verifyText){
    wait.until(ExpectedConditions.textToBe(locator, verifyText));
    driver.findElement(locator).isDisplayed();
    return false; 
  }

  public void closeBroswer(){
    driver.close();
  }
  
}
