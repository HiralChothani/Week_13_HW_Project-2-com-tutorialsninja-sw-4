package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {
    HomePage homePage = new HomePage();
    public By sortBy = By.xpath("//select[@id='input-sort']");
    public String price = "Price (High > Low)";
    public By productPriceList = By.xpath("//div[@class='row']//p[@class='price']");
    public By macBook = By.linkText("MacBook");
    public By addToCart = By.xpath("//button[@id='button-cart']");
    public By confirmationMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    public By messageLink = By.xpath("(//a[normalize-space()='shopping cart'])[1]");
    public By textShoppingCart = By.xpath("(//a[contains(text(),'Shopping Cart')])[1]");
    public By textMacBook = By.xpath("(//a[contains(text(),'MacBook')])[2]");
    public By qty = By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]");
    public By updateButton = By.xpath("(//i[@class='fa fa-refresh'])[1]");
    public By successMessage = By.xpath("(//div[@class='alert alert-success alert-dismissible'])[1]");
    public By totalPrice = By.xpath("//tbody//tr//td[6]");
   public By checkOutButton = By.xpath("//a[@class='btn btn-primary']");
   public By checkOutText = By.xpath("//h1[normalize-space()='Checkout']");
   public By newCustomerText = By.xpath("//h2[normalize-space()='New Customer']");
   public By guestCheckOutButton = By.xpath("(//input[@value='guest'])[1]");
   public By continueTab = By.id("button-account");
   public By firstNameField = By.id("input-payment-firstname");
   public By lastNameField = By.id("input-payment-lastname");
   public By emailField = By.id("input-payment-email");
   public By telephoneField = By.id("input-payment-telephone");
   public By addressField = By.id("input-payment-address-1");
   public By cityField = By.id("input-payment-city");
   public By postCodeField = By.id("input-payment-postcode");
   public By countryField = By.id("input-payment-country");
   public By regionField = By.id("input-payment-zone");
   public By continueButton = By.id("button-guest");
   public By commentArea = By.xpath("//textarea[@name='comment']");
   public By tcBox = By.name("agree");
   public By continuePaymentButton = By.id("button-payment-method");
   public By warningMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");



    public void selectSortByOption(By by, String option) {
        selectByVisibleTextFromDropDown(by, option);
    }

    public List verifyProductPriceOrder(By by) {
        return getTextFromElements(by);
    }

    public void selectProduct(By by) {
        homePage.selectMenu(by);
    }

    public String verifyText(By by) {
        return getTextFromElement(by);
    }

    public void click(By by) {
        clickOnTheElement(by);
    }

    public void changeParameter(By by, String text) {
        clickOnTheElement(by);
        clearText(by);
        sendTextToTheElement(by, text);
    }

    public void enterDetailToField(By by,String firstName){
        sendTextToTheElement(by, firstName);
    }
}
