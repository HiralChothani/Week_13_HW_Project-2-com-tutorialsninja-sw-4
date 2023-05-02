package com.tutorialsninja.utilities;

import com.tutorialsninja.browserfactory.ManageBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Utility extends ManageBrowser {

    // This method will hover mouse on the element
    public void mouseHoverOnTheElement(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).build().perform();
    }

    // This method will hover mouse and click on the element
    public void mouseHoverOnTheElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).click().build().perform();
    }

    public void clickOnTheElement(By by) {
        driver.findElement(by).click();
    }

    public void clickOnWebElement(WebElement element) {
        element.click();
    }

    /**
     * This method will get text from element
     */
    public String  getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    // This method will send text to the element
    public void sendTextToTheElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    // This method will clear text from box
    public void clearText(By by){
        driver.findElement(by).clear();
    }

    // This method will select from Dropdown
    public void selectByVisibleTextFromDropDown(By by, String name) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // select by visible text
        select.selectByVisibleText(name);
    }

    // This method will get text from elements as list
    public List getTextFromElements(By by) {
        List<WebElement> nameElements = driver.findElements(by);
        List<String> productNames = new ArrayList<String>();
        for (WebElement element : nameElements) {
            productNames.add(element.getText());
            System.out.println(productNames);
        }
        return productNames;
    }

    public static String randomEmail() {
        return "Random-" + UUID.randomUUID().toString() + "@example.com";
    }
}
