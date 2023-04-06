package webTest;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

@Story("Лента моих постов")
public class MyPostTest extends BaseTest{

    @Test
    @DisplayName("Лента с моими постами")
    void test1()  {
        authorization.useLatinLatter();
        Assertions.assertTrue(homePage.isPostPreView());
        logger.info("превью постов отображаются");
        Assertions.assertTrue(homePage.isPostTitleVisible());
        logger.info("названия постов отображаются");
        Assertions.assertTrue(homePage.isPostDescriptionVisible());
        logger.info("описания постов отображаются");
    }

    @Test
    @DisplayName("Кликабельность страниц")
    void test2() throws InterruptedException {
        authorization.useBigAndSmallLatter();
        Assertions.assertTrue(homePage.isPreviousPageDesable());
        Thread.sleep(5000);
        homePage.clickNextPage();
        Thread.sleep(5000);
        Assertions.assertTrue(driver.getCurrentUrl().contains("page=2"));
        homePage.clickPreviousPage();
        Thread.sleep(5000);
        Assertions.assertTrue(homePage.isPreviousPageDesable());
        logger.info("страницы кликабельны");
    }

    @Test
    @DisplayName("Кликабельность картинок")
    void test3() throws InterruptedException {
        authorization.useBigAndSmallLatter();
        homePage.clickAllPostPreview();
        logger.info("все картинки кликабельны");
    }
}
