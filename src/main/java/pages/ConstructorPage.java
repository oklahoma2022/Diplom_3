package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ConstructorPage {
    public  ConstructorPage() {
    }

    //Локатор кнопки Булка
    private final SelenideElement buttonBun = $(byXpath("//span[text()='Булки']"));
    // Локатор кнопки Соусы
    private final SelenideElement buttonSouse = $(byXpath("//span[text()='Соусы']"));
    //Локатор кнопки Начинки
    private final SelenideElement buttonFilling = $(byXpath("//span[text()='Начинки']"));
    //Локатор для проверки текста что мы перешли
    private final SelenideElement textBun = $(byXpath("//h2[text()='Булки']"));
    //Локатор для проверки текста что мы в начинках
    private final SelenideElement textSouse = $(byXpath("//h2[text()='Соусы']"));
    // Локатор для проверки что мы в соусах
    private final SelenideElement textFilling = $(byXpath("//h2[text()='Начинки']"));

    public void buttonBun() {
        buttonBun.click();
    }
    public void buttonSouse() {
        buttonSouse.click();
    }
    public void buttonFilling() {
        buttonFilling.click();
    }
    public String textBun() {
        return textBun.getText();
    }
    public String textSouse() {
        return textSouse.getText();
    }
    public String textFilling() {
        return textFilling.getText();
    }
}
