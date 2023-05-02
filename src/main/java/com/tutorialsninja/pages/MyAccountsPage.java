package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountsPage extends Utility {

    public By registerAccountText = By.xpath("//h1[normalize-space()='Register Account']");
    public By returningCustomerText = By.xpath("//h2[normalize-space()='Returning Customer']");
    public By firstNameField = By.id("input-firstname");
    public By lastNameField = By.id("input-lastname");
    public By emailField = By.id("input-email");
    public By telephoneField = By.id("input-telephone");
    public By passwordField = By.id("input-password");
    public By confirmPasswordField = By.xpath("//input[@id='input-confirm']");
    public By subYesButton = By.xpath("//label[normalize-space()='Yes']");
    public By policyCheckBox = By.xpath("//input[@name='agree']");
    public By continueButton = By.xpath("//input[@value='Continue']");
    public By successMessage = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
    public By clickContinue = By.xpath("//a[normalize-space()='Continue']");
    public By logOutBox = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li/a");
    public By logOut = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']");
    public By logOutText = By.cssSelector("div[id='content'] h1");
    public By continueFinalButton = By.xpath("//a[normalize-space()='Continue']");
    public By loginButton = By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]");
    public By myAccountText = By.xpath("//h2[contains(text(),'My Account')]");
    public By accountLogOutText = By.xpath("//h1[contains(text(),'Account Logout')]");
    public By continueTextButton = By.xpath("//a[contains(text(),'Continue')]");

    public void selectMyAccountOptions(String option) {

        clickOnTheElement(By.linkText("My Account"));
        List<WebElement> optionsList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li/a"));
        for (WebElement element : optionsList) {
            if (element.getText().equalsIgnoreCase(option)) {
                clickOnWebElement(element);
                break;
            }
        }
    }

    public String verifyText(By by) {
        return getTextFromElement(by);
    }

    public void enterDetailToField(By by, String firstName) {
        sendTextToTheElement(by, firstName);
    }

    public void click(By by){
        clickOnTheElement(by);
    }
}
