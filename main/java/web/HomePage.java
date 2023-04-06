package web;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BaseView {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@class='content']//img")
    private List<WebElement> previewList;

    @FindBy(xpath = "//div[@class='content']//h2")
    private List<WebElement> tytleList;

    @FindBy(xpath = "//div[@class='description svelte-127jg4t']")
    private List<WebElement> descriptionList;

    @FindBy(xpath = "//span[text()='Home']")
    private WebElement homeButton;

    @FindBy(xpath = "//a[text()='Next Page']")
    private WebElement nextPageButton;

    @FindBy(xpath = "//a[text()='Previous Page']")
    private WebElement previousPageButton;


    @Step("переход на следующую страницу")
    public HomePage clickNextPage() {
        nextPageButton.click();
        return this;
    }

    @Step("переход на предыдущую страницу")
    public HomePage clickPreviousPage() {
        previousPageButton.click();
        return this;
    }

    @Step("клик на HOME")
    public HomePage clickHomeButton() {
        homeButton.click();
        return this;
    }

    @Step("клик на первую картинку")
    public HomePage clickFirstPostPreview() {
        previewList.get(0).click();
        return this;
    }

    @Step("клик на все картинки")
    public HomePage clickAllPostPreview() throws InterruptedException {
        for(int i = 0; i < previewList.size(); i++) {
            previewList.get(i).click();
            Thread.sleep(5000);
            homeButton.click();
        }
        return this;
    }


    public boolean isPostPreView() {
        return ((previewList.size() > 0) && (previewList.get(0).isDisplayed()));
    }

    public boolean isPostTitleVisible() {
        return ((tytleList.size() > 0) && (tytleList.get(0).isDisplayed()));
    }

    public boolean isPostDescriptionVisible() {
        return ((descriptionList.size() > 0) && (descriptionList.get(0).isDisplayed()));
    }

    public boolean isNextPageVisible() {
        return nextPageButton.isDisplayed();
    }

    public boolean isPreviousPageVisible() {
        return previousPageButton.isDisplayed();
    }

    public boolean isPreviousPageDesable() {
        return previousPageButton.isEnabled();
    }

}
