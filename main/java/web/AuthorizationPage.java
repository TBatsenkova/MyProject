package web;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BaseView{
    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Username']//following::input[@type='text']")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[text()='Password']//following::input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button/span[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[text()='Hello, ']")
    private WebElement helloButton;

    @FindBy(xpath = "//h1[text()='Blog']")
    private WebElement textBlog;

    @FindBy(xpath = "//h2[text()='401']")
    private WebElement error401;

    @Step("валидный тест")
    public AuthorizationPage useLatinLatter(){
        usernameInput.sendKeys("batsenkova");
        passwordInput.sendKeys("1b445c82db");
        loginButton.click();
        return this;
    }

    @Step("невалидный тест")
    public AuthorizationPage useSpeсialSymbol(){
        usernameInput.sendKeys("@");
        passwordInput.sendKeys("174059b298");
        loginButton.click();
        return this;
    }

    @Step("верхний, нижний регист плюс символы в логине")
    public AuthorizationPage useBigAndSmallLatter(){
        usernameInput.sendKeys("GB-test");
        passwordInput.sendKeys("374940bcf9");
        loginButton.click();
        return this;
    }

    @Step("больше 20 символов")
    public AuthorizationPage useMoreThan20Symbols(){
        usernameInput.sendKeys("iiiiiiiiiiiiiiiiiiiiii");
        passwordInput.sendKeys("ce899cdb5e");
        loginButton.click();
        return this;
    }

    @Step("20 символов")
    public AuthorizationPage use20Symbols(){
        usernameInput.sendKeys("jjjjjjjjjjjjjjjjjjjj");
        passwordInput.sendKeys("f79a4e7077");
        loginButton.click();
        return this;
    }

    @Step("меньше 3 символов")
    public AuthorizationPage useLessThan3Symbols(){
        usernameInput.sendKeys("n");
        passwordInput.sendKeys("7b8b965ad4");
        loginButton.click();
        return this;
    }

    @Step("3 символа")
    public AuthorizationPage use3Symbols(){
        usernameInput.sendKeys("nnn");
        passwordInput.sendKeys("a1931ec126");
        loginButton.click();
        return this;
    }

    public boolean checkIfUserAuthorizedOrNot() throws InterruptedException {
        helloButton.isDisplayed();
        textBlog.isDisplayed();
        return true;
    }

    public boolean check401Error() {
        error401.isDisplayed();
        return true;
    }
}
