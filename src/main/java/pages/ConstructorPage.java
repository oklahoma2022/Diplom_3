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



    public void buttonBun() {
        buttonBun.click();
    }
    public void buttonSouse() {

        buttonSouse.click();
    }
    public void buttonFilling() {
        buttonFilling.click();
    }
    public String getAttributeClassBun() {
        return getAttributeParentClass(buttonBun);
    }
    public String getAttributeClassSouse() {
        return getAttributeParentClass(buttonSouse);
    }
    public String getAttributeClassFilling() {
        return getAttributeParentClass(buttonFilling);
    }

    private String getAttributeParentClass(SelenideElement selenideElement) {
        return selenideElement.parent().getAttribute("class");
    }

}
