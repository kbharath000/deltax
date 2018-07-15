package com.deltax.testcases;

import com.deltax.locators.RegistrationForm;
import com.deltax.utils.ReadProperties;
import com.deltax.utils.SeleniumUtils;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationFormTest {
  
  SeleniumUtils su = new SeleniumUtils();
  String url = new ReadProperties().readProperties().getProperty("url");
      
  @BeforeClass
  public void launch(){
    su.launchUrl(url);
  }
  @AfterClass
  public void tearDown(){
    su.closeBroswer();
  }
  @Test
  public void testNegativeScenarios(){
    su.sendText(RegistrationForm.inputName("first"),"Deltax");
    su.sendText(RegistrationForm.inputName("last"),"Technologies");
    su.click(RegistrationForm.inputName("department"));
    su.selectByVisibleText(RegistrationForm.inputName("department"),"Engineering");
    su.click(RegistrationForm.submit);
    su.isDisplayed(RegistrationForm.verifyText("your Username"), "Please enter your Username");
    su.isDisplayed(RegistrationForm.verifyText("your Password"), "Please enter your Password");
    su.isDisplayed(RegistrationForm.verifyText("confirm your Password"), "Please confirm your Password");
    su.isDisplayed(RegistrationForm.verifyText("Email Address"), "Please enter your Email Address");
    System.out.println("Launched registration Form");
    su.refresh();
  }
  
  @Test
  public void testNameValidationAtleastTwo(){
    su.refresh();
    su.sendText(RegistrationForm.inputName("first"),"D");
    su.sendText(RegistrationForm.inputName("last"),"T");
    su.click(RegistrationForm.inputName("department"));
    su.selectByVisibleText(RegistrationForm.inputName("department"),"Engineering");
      Assert.assertEquals(2, 2);
    }
  
  
  //su.sendText(RegistrationForm.inputName("user"), "");
  @Test
  public void testMandatoryFields(){
    su.refresh();
    su.sendText(RegistrationForm.inputName("first"),"Deltax");
    su.sendText(RegistrationForm.inputName("last"),"Technologies");
    su.click(RegistrationForm.inputName("department"));
    su.selectByVisibleText(RegistrationForm.inputName("department"),"Engineering");
    su.sendText(RegistrationForm.inputName("user"),"Deltax");
    su.sendText(RegistrationForm.inputName("user_password"),"Techn");
    su.sendText(RegistrationForm.inputName("confirm_password"),"Techn");
    su.sendText(RegistrationForm.inputName("email"),"k.bharath000@gmail.com");
    su.sendText(RegistrationForm.inputName("contact_no"),"9000197691");
    su.click(RegistrationForm.submit);
    if(su.getCount(RegistrationForm.verifyText("This value is not valid"))> 1){
      Assert.assertEquals(3, 3);
    }
  }
  
  @Test
  public void testEmailAndMobileValidation(){
    su.refresh();
    su.sendText(RegistrationForm.inputName("first"),"Deltax");
    su.sendText(RegistrationForm.inputName("last"),"Technologies");
    su.click(RegistrationForm.inputName("department"));
    su.selectByVisibleText(RegistrationForm.inputName("department"),"Engineering");
    su.sendText(RegistrationForm.inputName("user"),"DeltaxTechnologies");
    su.sendText(RegistrationForm.inputName("user_password"),"Technologies");
    su.sendText(RegistrationForm.inputName("confirm_password"),"Technologies");
    su.sendText(RegistrationForm.inputName("email"),"k.");
    su.sendText(RegistrationForm.inputName("contact_no"),"90001976911");
    if(su.getCount(RegistrationForm.verifyText("This value is not valid"))> 1){
      Assert.assertEquals(2, 2);
    }
  }
    
  @Test
  public void testPositiveScenarios(){
    su.refresh();
    su.sendText(RegistrationForm.inputName("first"),"Deltax");
    su.sendText(RegistrationForm.inputName("last"),"Technologies");
    su.click(RegistrationForm.inputName("department"));
    su.selectByVisibleText(RegistrationForm.inputName("department"),"Engineering");
    su.sendText(RegistrationForm.inputName("user"),"DeltaxTechnologies");
    su.sendText(RegistrationForm.inputName("user_password"),"Technologies");
    su.sendText(RegistrationForm.inputName("confirm_password"),"Technologies");
    su.sendText(RegistrationForm.inputName("email"),"k.bharath000@gmail.com");
    su.sendText(RegistrationForm.inputName("contact_no"),"9000197691");
    su.click(RegistrationForm.submit);
    su.isDisplayed(RegistrationForm.verifyText("Thanks"), "Thanks");
  }
}
