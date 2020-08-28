package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage lp;

    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        lp = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @And("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) {
        lp.setUserName(email);
        lp.setPassword(pwd);
    }

    @And("Click on Login")
    public void click_on_login() {
        lp.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful.")) {
            driver.close();
            Assert.fail();
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }
    }

    @When("User click on Logout link")
    public void user_click_on_logout_link() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000);
    }

    @Then("Close the browser")
    public void close_the_browser() {
        driver.close();
    }
}