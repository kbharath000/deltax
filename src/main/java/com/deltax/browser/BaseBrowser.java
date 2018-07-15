package com.deltax.browser;

import com.deltax.utils.ReadProperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseBrowser {

  WebDriver driver;

  public WebDriver launchBrowser(String browser) 
    {
      if(browser.equalsIgnoreCase("firefox"))
      {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
      }else if(browser.equalsIgnoreCase("chrome"))
      {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get(url);
        return driver;
      }
    return null;
  }
  
} 
