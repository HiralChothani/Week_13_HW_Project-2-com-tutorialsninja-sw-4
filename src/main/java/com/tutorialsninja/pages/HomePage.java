package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    public By desktop = By.linkText("Desktops");
    public By laptopsAndNotebooks = By.linkText("Laptops & Notebooks");
    public By components = By.linkText("Components");
    public By showAllDesktops = By.linkText("Show AllDesktops");
    public By showAllLaptopsAndNotebooks = By.linkText("Show AllLaptops & Notebooks");
    public By showAllComponents = By.linkText("Show AllComponents");

    public void clickOnMenu(By by) {
        mouseHoverOnTheElementAndClick(by);
    }

    public void selectMenu(By by) {
        clickOnTheElement(by);
    }

    public String verifyText(By by) {
       return getTextFromElement(by);
    }


}
