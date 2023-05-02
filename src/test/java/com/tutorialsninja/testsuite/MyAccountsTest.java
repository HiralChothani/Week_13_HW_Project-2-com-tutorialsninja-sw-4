package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.MyAccountsPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountsTest extends BaseTest {
    MyAccountsPage myAccountsPage = new MyAccountsPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // Click on My Account Link
        // Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccountsPage.selectMyAccountOptions("Register");
        //  Verify the text “Register Account”.
        Assert.assertEquals(myAccountsPage.verifyText(myAccountsPage.registerAccountText), "Register Account", "Text not register");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        // Click on My Account Link.
        // Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        myAccountsPage.selectMyAccountOptions("Login");
        //  Verify the text “Returning Customer”.
        Assert.assertEquals(myAccountsPage.verifyText(myAccountsPage.returningCustomerText), "Returning Customer", "Text not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //  Click on My Account Link.
        // Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        verifyUserShouldNavigateToRegisterPageSuccessfully();
        //Enter First Name, Last Name, Email, Telephone, Password and Password Confirm
        myAccountsPage.enterDetailToField(myAccountsPage.firstNameField, "Julie");
        myAccountsPage.enterDetailToField(myAccountsPage.lastNameField, "Samsonic");
        myAccountsPage.enterDetailToField(myAccountsPage.emailField, randomEmail());
        myAccountsPage.enterDetailToField(myAccountsPage.telephoneField, "6875430598");
        myAccountsPage.enterDetailToField(myAccountsPage.passwordField, "Sonic20*");
        myAccountsPage.enterDetailToField(myAccountsPage.confirmPasswordField, "Sonic20*");
        // Select Subscribe Yes radio button
        myAccountsPage.click(myAccountsPage.subYesButton);
        // Click on Privacy Policy check box
        myAccountsPage.click(myAccountsPage.policyCheckBox);
        // Click on Continue button
        myAccountsPage.click(myAccountsPage.continueButton);
        // Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(myAccountsPage.verifyText(myAccountsPage.successMessage), "Your Account Has Been Created!", "Message not displayed");
        //  Click on Continue button
        myAccountsPage.click(myAccountsPage.clickContinue);
        // Click on My Account Link
        // Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccountsPage.selectMyAccountOptions("Register");
        // Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        mouseHoverOnTheElement(myAccountsPage.logOutBox);
        myAccountsPage.click(myAccountsPage.logOut);
        // Verify the text “Account Logout”
        Assert.assertEquals(myAccountsPage.verifyText(myAccountsPage.logOutText), "Account Logout", "Text not displayed");
        //  Click on Continue button
        myAccountsPage.click(myAccountsPage.continueFinalButton);
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        // Click on My Account Link.
        // Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        verifyUserShouldNavigateToLoginPageSuccessfully();
        //  Enter Email address and Password
        myAccountsPage.enterDetailToField(myAccountsPage.emailField, "Random-e283eeca-e472-4601-911a-6fc5fbbc9b4f@example.com");
        myAccountsPage.enterDetailToField(myAccountsPage.passwordField, "Samgen123*");
        // Click on Login button
        myAccountsPage.click(myAccountsPage.loginButton);
        // Verify text “My Account”
        Assert.assertEquals(myAccountsPage.verifyText(myAccountsPage.myAccountText), "My Account", "Text Does not match");
        // Click on My Account Link
        // Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccountsPage.selectMyAccountOptions("Logout");
        // Verify the text “Account Logout”
        Assert.assertEquals(myAccountsPage.verifyText(myAccountsPage.accountLogOutText), "Account Logout", "Text not displayed");
        // Click on Continue button
        myAccountsPage.click(myAccountsPage.continueTextButton);

    }
}
