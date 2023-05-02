package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

public class DesktopsPage extends Utility {
    HomePage homePage = new HomePage();
    public By sortBy = By.id("input-sort");
    public String nameZ_A = "Name (Z - A)";
    public String nameA_Z = "Name (A - Z)";
    public By productNameList = By.xpath("//div[@class='row']//h4");
    public By productHP_LP3065 = By.linkText("HP LP3065");
    public By dateBox = By.xpath("//input[@id='input-option225']");
    public By qty = By.xpath("//input[@id='input-quantity']");
    public By addOnButton = By.xpath("//button[@id='button-cart']");
    public By confirmationMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    public By shoppingCartButton = By.linkText("shopping cart");
    public By textShoppingCart = By.xpath("//a[contains(text(),'Shopping Cart')]");
    public By deliveryDate = By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]");
    public By model = By.xpath("//td[contains(text(),'Product 21')]");
    public By totalPrice = RelativeLocator.with(By.xpath("//td[contains(text(),'$122.00')]")).below(By.xpath("//td[contains(text(),'Total')]"));

    public void selectSortByOption(By by, String option) {
        selectByVisibleTextFromDropDown(by, option);
    }

    public List verifyProductOrder(By by) {
        return getTextFromElements(by);
    }

    public void selectProduct(By by){
        homePage.selectMenu(by);
    }
    public String verifyText(By by){
        return getTextFromElement(by);
    }

    public void changeParameter(By by, String text){
        clickOnTheElement(by);
        clearText(by);
        sendTextToTheElement(by,text);
    }

   public void click(By by){
        clickOnTheElement(by);
   }
}
