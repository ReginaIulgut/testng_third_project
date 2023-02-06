package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class CarvanaTest extends CarvanaBase{

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateCarvanaHomePageAndURL(){
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validateTheCarvanaLogo(){
        Assert.assertTrue(carvanaBasePage.logoHeader.isDisplayed());
    }

    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validateTheMainNavigation(){
        for (int i = 0; i < carvanaBasePage.mainNavigationBar.size(); i++) {
            Assert.assertTrue(carvanaBasePage.mainNavigationBar.get(i).isDisplayed());
        }
    }

    @Test(priority = 4, description = "Validate the sign in error message")
    public void validateErrorMessage(){
        carvanaBasePage.signInBox.click();
        carvanaBasePage.emailInbox.sendKeys("johndoe@gmail.com");
        carvanaBasePage.continueAndSignInButton.click();
        carvanaBasePage.passwordInbox.sendKeys("abcd1234");
        carvanaBasePage.continueAndSignInButton.click();
        Assert.assertTrue(carvanaBasePage.errorMessage.isDisplayed());
    }

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void validateSearchButton(){
        carvanaBasePage.searchCarsButton.click();
        Waiter.pause(1);
        for (int i = 0; i < carvanaBasePage.filterOptions.size(); i++) {
            Assert.assertTrue(carvanaBasePage.filterOptions.get(i).isDisplayed());
        }
    }

    @Test(priority = 6, description = "Validate the search result tiles")
    public void validateTheSearchResult(){
        carvanaBasePage.searchCarsButton.click();
        carvanaBasePage.searchInputBox.sendKeys("mercedes-benz" + Keys.ENTER);
        Waiter.pause(5);
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));
    }

}
