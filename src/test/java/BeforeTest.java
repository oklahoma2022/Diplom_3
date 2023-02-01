import org.junit.BeforeClass;

import java.util.Objects;

public class BeforeTest {

    @BeforeClass
    public static void startUp() {
        String webDriver = "chromedriver.exe";

        if (Objects.equals(System.getenv("browser"), "yandex")) {
            webDriver = "yandexdriver.exe";
        }

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/" + webDriver);
    }
}
