package web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseView {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    Actions actions;
    JavascriptExecutor javascriptExecutor;

    public BaseView(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        actions = new Actions(webDriver);
        javascriptExecutor = (JavascriptExecutor) webDriver;
        PageFactory.initElements(webDriver, this);
    }

}
