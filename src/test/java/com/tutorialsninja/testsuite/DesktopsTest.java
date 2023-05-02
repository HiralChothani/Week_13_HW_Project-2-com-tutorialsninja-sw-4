package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class DesktopsTest extends BaseTest {

    DesktopsPage desktopsPage = new DesktopsPage();
    TopMenuTest topMenuTest = new TopMenuTest();

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        // Mouse hover on Desktops Tab.and click
        // Click on “Show All Desktops"
        topMenuTest.verifyUserShouldNavigateToDesktopsPageSuccessfully();
        // get all product name in list
        List expectedProductOrder = desktopsPage.verifyProductOrder(desktopsPage.productNameList);
        // Select Sort By position "Name: Z to A"
        desktopsPage.selectSortByOption(desktopsPage.sortBy, desktopsPage.nameZ_A);
        //  Verify the Product will arrange in Descending order.
        List actualProductOrder = desktopsPage.verifyProductOrder(desktopsPage.productNameList);
        Collections.reverse(expectedProductOrder);
        expectedProductOrder.sort(String.CASE_INSENSITIVE_ORDER.reversed());
        Assert.assertEquals(actualProductOrder, expectedProductOrder, "Product not arranged in descending order");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        // Mouse hover on Desktops Tab.and click
        // Click on “Show All Desktops"
        topMenuTest.verifyUserShouldNavigateToDesktopsPageSuccessfully();
        // Select Sort By position "Name: A to Z"
        desktopsPage.selectByVisibleTextFromDropDown(desktopsPage.sortBy, desktopsPage.nameA_Z);
        // Select product “HP LP3065”
        desktopsPage.selectProduct(desktopsPage.productHP_LP3065);
        // Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        Assert.assertEquals(desktopsPage.verifyText(desktopsPage.productHP_LP3065), expectedText, "Text does not match");
        // Select Delivery Date "2022-11-30"
        desktopsPage.changeParameter(desktopsPage.dateBox, "2022-11-30");
        // Enter Qty "1” using Select class.
        desktopsPage.changeParameter(desktopsPage.qty, "1");
        // Click on “Add to Cart” button
        desktopsPage.click(desktopsPage.addOnButton);
        // Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!\n" + "×";
        Assert.assertEquals(desktopsPage.verifyText(desktopsPage.confirmationMessage),expectedMessage, "Message not displayed");
      // Click on link “shopping cart” display into success message
        desktopsPage.click(desktopsPage.shoppingCartButton);
        // Verify the text "Shopping Cart"
        Assert.assertEquals(desktopsPage.verifyText(desktopsPage.textShoppingCart), "Shopping Cart", "Text not displayed");
        //  Verify the Product name "HP LP3065"
        Assert.assertEquals(desktopsPage.verifyText(desktopsPage.productHP_LP3065), "HP LP3065", "Wrong product name");
        // Verify the Delivery Date "2022-11-30"
        Assert.assertEquals(desktopsPage.verifyText(desktopsPage.deliveryDate), "Delivery Date:2022-11-30", "Wrong delivery date");
        // Verify the Model "Product21"
        Assert.assertEquals(desktopsPage.verifyText(desktopsPage.model), "Product 21", "Wrong Model");
        // Verify the Total "$122.00"
          Assert.assertEquals(desktopsPage.verifyText(desktopsPage.totalPrice), "$122.00", "Wrong TotalPrice");
    }

}
