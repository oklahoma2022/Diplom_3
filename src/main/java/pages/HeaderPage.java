package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {

    public HeaderPage() {
    }

    private final SelenideElement buttonConstructor= $(byXpath("//p[text()='Конструктор']"));
    private final SelenideElement buttonLogo= $(byXpath("//div[contains(@class, 'logo')]/a[@href='/']"));
    private final SelenideElement buttonPersonalAccount= $(byXpath("//p[text()='Личный Кабинет']"));

    public void buttonConstructor() {
        buttonConstructor.click();
    }
    public void buttonLogo() {
        buttonLogo.click();
    }
    public void buttonPersonalAccount() {
        buttonPersonalAccount.click();
    }
}
