package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
    HomePage homePage = new HomePage();
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.clickOnMenu(homePage.desktop);
        homePage.selectMenu(homePage.showAllDesktops);
        String expectedTest = "Desktops";
        Assert.assertEquals(homePage.verifyText(homePage.desktop), expectedTest, "Text not displayed" );
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        homePage.clickOnMenu(homePage.laptopsAndNotebooks);
        homePage.selectMenu(homePage.showAllLaptopsAndNotebooks);
        String expectedTest = "Laptops & Notebooks";
        Assert.assertEquals(homePage.verifyText(homePage.laptopsAndNotebooks), expectedTest, "Text not displayed" );
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        homePage.clickOnMenu(homePage.components);
        homePage.selectMenu(homePage.showAllComponents);
        String expectedTest = "Components";
        Assert.assertEquals(homePage.verifyText(homePage.components), expectedTest, "Text not displayed" );
    }
}
