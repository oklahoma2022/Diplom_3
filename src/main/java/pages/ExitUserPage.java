package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ExitUserPage {
    public ExitUserPage(){
    }
    private final SelenideElement buttonExit= $(byXpath("//button[text()='Выход']"));

    public void buttonExit() {
        buttonExit.click();
    }


}
