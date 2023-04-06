package backTest;

import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractTest {

    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String token;
    private static String postUrl;
    private static String authUrl;
    private static String validUsername;
    private static String validPassword;
    private static String invalidUsername;
    private static String invalidPassword;
    private static String myId;


    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/resources/project.properties");
        prop.load(configFile);
        token = prop.getProperty("token");
        postUrl = prop.getProperty("post_url");
        authUrl = prop.getProperty("auth_url");
        validUsername = prop.getProperty("valid_username");
        validPassword = prop.getProperty("valid_password");
        invalidUsername = prop.getProperty("invalid_username");
        invalidPassword = prop.getProperty("invalid_password");
        myId = prop.getProperty("myId");
    }

    public static String getApiKey() {
        return token;
    }

    public static String getAuthUrl() {
        return authUrl;
    }

    public static String getPostUrl() {
        return postUrl;
    }

    public static String getValidUsername() {
        return validUsername;
    }

    public static String getValidPassword() {
        return validPassword;
    }

    public static String getInvalidUsername() {
        return invalidUsername;
    }

    public static String getInvalidPassword() {
        return invalidPassword;
    }

    public static String getToken() {
        return token;
    }

    public static String getMyId() {
        return myId;
    }
}
