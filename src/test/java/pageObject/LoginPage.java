package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver ldriver;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement txtPwd;

    @FindBy(xpath = "//input[@value='Log in']")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement lnkLogout;

    public void setUserName(String uname) {
        txtEmail.clear();
        txtEmail.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        txtPwd.clear();
        txtPwd.sendKeys(pwd);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clickLogout() {
        lnkLogout.click();
    }

    public void getPagetitle() {
    }
}
