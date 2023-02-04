package pages;
import com.codeborne.selenide.SelenideElement;
import models.UserModel;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {

    public RegisterPage() {

    }

    private final SelenideElement inputName = $(byXpath("//label[text()='Имя']/following-sibling::input"));
    private final SelenideElement inputEmail = $(byXpath("//label[text()='Email']/following-sibling::input"));
    private final SelenideElement inputPassword = $(byXpath("//label[text()='Пароль']/following-sibling::input"));
    private final SelenideElement buttonRegistration = $(byXpath("//button[text()='Зарегистрироваться']"));
    private final SelenideElement messageNotCorrectPassword = $(byXpath("//p[text()='Некорректный пароль']"));
    private final SelenideElement getTextAuthPage = $(byXpath("//h2[text()='Вход']"));


    public void inputName(String username) {
        inputName.setValue(username);
    }
    public void inputEmail(String email) {
        inputEmail.setValue(email);
    }
    public void inputPassword(String password) {
        inputPassword.setValue(password);
    }
    public void buttonRegistration() {
        buttonRegistration.click();
    }
    public String getErrorMessagePassword() {
        return messageNotCorrectPassword.getText();
    }

    //После регистрации мы попадаем на страницу регистрации. проверим по тексту что присуствует форма  входа.
    public String getTextAuthPage() {
        return getTextAuthPage.getText();
    }

    public void registration(UserModel user){
        inputName(user.getName());
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
        buttonRegistration();
    }
}
