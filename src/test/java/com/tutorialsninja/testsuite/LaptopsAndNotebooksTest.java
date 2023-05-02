package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends BaseTest {
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    TopMenuTest topMenuTest = new TopMenuTest();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //Mouse hover on Laptops & Notebooks Tab.and click
        // Click on “Show All Laptops & Notebooks”
        topMenuTest.verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully();
        // store product price in list
        List expectedPriceOrder = laptopsAndNotebooksPage.verifyProductPriceOrder(laptopsAndNotebooksPage.productPriceList);
        // Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectSortByOption(laptopsAndNotebooksPage.sortBy, laptopsAndNotebooksPage.price);
        // Verify the Product price will arrange in High to Low order.
        List actualPriceOrder = laptopsAndNotebooksPage.verifyProductPriceOrder(laptopsAndNotebooksPage.productPriceList);
        System.out.println(actualPriceOrder);
        Collections.sort(expectedPriceOrder);
        Assert.assertEquals(actualPriceOrder, expectedPriceOrder, "Price not arranged High to Low");
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        //Mouse hover on Laptops & Notebooks Tab.and click
        // Click on “Show All Laptops & Notebooks”
        topMenuTest.verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully();
        // Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectSortByOption(laptopsAndNotebooksPage.sortBy, laptopsAndNotebooksPage.price);
        // Select Product “MacBook”
        laptopsAndNotebooksPage.selectProduct(laptopsAndNotebooksPage.macBook);
        // Verify the text “MacBook”
        Assert.assertEquals(laptopsAndNotebooksPage.verifyText(laptopsAndNotebooksPage.macBook), "MacBook", "Text not displayed");
        // Click on ‘Add To Cart’ button
        laptopsAndNotebooksPage.click(laptopsAndNotebooksPage.addToCart);
        // Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedConfirmationMessage = "Success: You have added MacBook to your shopping cart!\n" + "×";
        Assert.assertEquals(laptopsAndNotebooksPage.verifyText(laptopsAndNotebooksPage.confirmationMessage), expectedConfirmationMessage, "Message not displayed");
        // Click on link “shopping cart” display into success message
        laptopsAndNotebooksPage.click(laptopsAndNotebooksPage.messageLink);
        //Verify the text "Shopping Cart"
        Assert.assertEquals(laptopsAndNotebooksPage.verifyText(laptopsAndNotebooksPage.textShoppingCart), "Shopping Cart", "Text not displayed");
        // Verify the Product name "MacBook"
        Assert.assertEquals(laptopsAndNotebooksPage.verifyText(laptopsAndNotebooksPage.textMacBook), "MacBook", "Text not displayed");
        // Change Quantity "2"
        laptopsAndNotebooksPage.changeParameter(laptopsAndNotebooksPage.qty, "2");
        //  // Click on “Update” Tab
        laptopsAndNotebooksPage.click(laptopsAndNotebooksPage.updateButton);
        // Verify the message “Success: You have modified your shopping cart!”
        Assert.assertEquals(laptopsAndNotebooksPage.verifyText(laptopsAndNotebooksPage.successMessage), "Success: You have modified your shopping cart!\n" + "×", "Message not displayed");
        // Verify the Total $1,204.00
        Assert.assertEquals(laptopsAndNotebooksPage.verifyText(laptopsAndNotebooksPage.totalPrice), "$1,204.00", "Wrong Price");
        // Click on “Checkout” button
        laptopsAndNotebooksPage.click(laptopsAndNotebooksPage.checkOutButton);
        //  Verify the text “Checkout”
        Assert.assertEquals(laptopsAndNotebooksPage.verifyText(laptopsAndNotebooksPage.checkOutText), "Checkout", "Text not displayed");
        //  Verify the Text “New Customer
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(laptopsAndNotebooksPage.newCustomerText));
        Assert.assertEquals(laptopsAndNotebooksPage.verifyText(laptopsAndNotebooksPage.newCustomerText), "New Customer", "Text not displayed");
        // Click on “Guest Checkout” radio button
        laptopsAndNotebooksPage.click(laptopsAndNotebooksPage.guestCheckOutButton);
        // Click on “Continue” tab
        laptopsAndNotebooksPage.click(laptopsAndNotebooksPage.continueTab);
        // Fill the mandatory fields
        laptopsAndNotebooksPage.enterDetailToField(laptopsAndNotebooksPage.firstNameField, "Jenny");
        laptopsAndNotebooksPage.enterDetailToField(laptopsAndNotebooksPage.lastNameField, "Karen");
        final String randomEmail = randomEmail();
        laptopsAndNotebooksPage.enterDetailToField(laptopsAndNotebooksPage.emailField, randomEmail);
        laptopsAndNotebooksPage.enterDetailToField(laptopsAndNotebooksPage.telephoneField, "07850046387");
        laptopsAndNotebooksPage.enterDetailToField(laptopsAndNotebooksPage.addressField, "1xcvt");
        laptopsAndNotebooksPage.enterDetailToField(laptopsAndNotebooksPage.cityField, "Buckledom");
        laptopsAndNotebooksPage.enterDetailToField(laptopsAndNotebooksPage.postCodeField, "XT1 8GH");
        laptopsAndNotebooksPage.enterDetailToField(laptopsAndNotebooksPage.countryField, "United Kingdom");
        laptopsAndNotebooksPage.enterDetailToField(laptopsAndNotebooksPage.regionField, "Isle of Wight");
        // Click on “Continue” Button
        laptopsAndNotebooksPage.click(laptopsAndNotebooksPage.continueButton);
        // Add Comments About your order into text area
        laptopsAndNotebooksPage.enterDetailToField(laptopsAndNotebooksPage.commentArea, "Please dispatch today, My order");
        // Check the Terms & Conditions check box
        laptopsAndNotebooksPage.click(laptopsAndNotebooksPage.tcBox);
        // Click on “Continue” button
        laptopsAndNotebooksPage.click(laptopsAndNotebooksPage.continuePaymentButton);
        //  Verify the message “Warning: Payment method required!”
        Assert.assertEquals(laptopsAndNotebooksPage.verifyText(laptopsAndNotebooksPage.warningMessage), "Warning: Payment method required!\n"+"×", "Message Not Displayed");

    }
}
