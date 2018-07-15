package com.deltax.locators;

import org.openqa.selenium.By;

/**
 * Hello world!
 *
 */
public class RegistrationForm 
{
  /**
   * Return locator by xpath
   * @param text Input xpath value
   * @return By
   */
  public static By inputName(String text){
    By inputName = By.xpath("//*[contains(@name,'"+text+"')]");
    return inputName;
  }
  
  public static By verifyText(String text){
    //*[contains(text(),'your Username')]
    By inputText = By.xpath("//*[contains(text(),'"+text+"')]");
    return inputText;
  }
  
public static By submit = By.xpath("//button[@type='submit']");
  
}
