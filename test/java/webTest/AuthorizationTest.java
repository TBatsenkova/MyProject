package webTest;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Story("Авторизация")
public class AuthorizationTest extends BaseTest {

    @Test
    @DisplayName("Авторизация c латинскими символами")
    void test1() throws InterruptedException {
        authorization.useLatinLatter();
        Assertions.assertTrue(authorization.checkIfUserAuthorizedOrNot());
        logger.info("авторизация успешна");
    }
    @Test
    @DisplayName("Авторизация c символами, верхний, нижний регистр")
    void test2() throws InterruptedException {
        authorization.useBigAndSmallLatter();
        Assertions.assertTrue(authorization.checkIfUserAuthorizedOrNot());
        logger.info("авторизация успешна");
    }

    @Test
    @DisplayName("Авторизация cо спецсимволами")
    void test3() throws InterruptedException {
        authorization.useSpeсialSymbol();
        Assertions.assertTrue(authorization.check401Error());
        logger.info("авторизация не выполнена");
    }

    @Test
    @DisplayName("Авторизация с 3 символами в логине")
    void test4() throws InterruptedException {
        authorization.use3Symbols();
        Assertions.assertTrue(authorization.checkIfUserAuthorizedOrNot());
        logger.info("авторизация успешна");
    }

    @Test
    @DisplayName("Авторизация с 20 символами в логине")
    void test5() throws InterruptedException {
        authorization.use20Symbols();
        Assertions.assertTrue(authorization.checkIfUserAuthorizedOrNot());
        logger.info("авторизация успешна");
    }

    @Test
    @DisplayName("Авторизация с логином < 3 символов")
    void test6() throws InterruptedException {
        authorization.useLessThan3Symbols();
        Assertions.assertTrue(authorization.check401Error());
        logger.info("авторизация не выполнена");
    }

    @Test
    @DisplayName("Авторизация с логином > 20 символов")
    void test7() throws InterruptedException {
        authorization.useMoreThan20Symbols();
        Assertions.assertTrue(authorization.check401Error());
        logger.info("авторизация не выполнена");
    }
}
