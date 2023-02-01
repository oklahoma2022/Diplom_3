import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pages.ConstructorPage;
import static com.codeborne.selenide.Selenide.open;
import static constants.LinkConstants.MAIN_PAGE_URL;

public class ConstructorTest extends BeforeTest {
    ConstructorPage constructorPage;

    public ConstructorTest() {
        constructorPage = new ConstructorPage();
    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу «Булки»")
    public void openingBuns() {
        open(MAIN_PAGE_URL);
        //кликаем не любое другое наполнение
        constructorPage.buttonFilling();
        //Проверяем что клик на булочки работает т.к по дефолту они выбраны и не нажимаются
        constructorPage.buttonBun();
        Assert.assertEquals("Булки", constructorPage.textBun());
    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу «Соусы» ")
    public void openingSouse() {
        open(MAIN_PAGE_URL);
        constructorPage.buttonSouse();
        Assert.assertEquals("Соусы", constructorPage.textSouse());
    }

    @Test
    @DisplayName("Проверка, что работает переход к разделу «Начинки» ")
    public void openingFilling() {
        open(MAIN_PAGE_URL);
        constructorPage.buttonFilling();
        Assert.assertEquals("Начинки", constructorPage.textFilling());
    }
}
