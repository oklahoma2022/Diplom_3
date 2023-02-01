package pages;

import com.codeborne.selenide.SelenideElement;
import models.UserModel;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    public AuthPage() {
    }

    //Локатор кнопки войти
    private final SelenideElement buttonLogin = $(byXpath("//button[text()='Войти в аккаунт']"));
    //Локатор кнопки в форме регистрации ( есть ссылка)
    private final SelenideElement buttonLoginOnThePageRegistrations = $(byXpath("//a[text()='Войти']"));
    // локатор входа на странице востановления пароля
    private final SelenideElement buttonLoginOnThePageFrogPassword =  $(byXpath("//a[text()='Войти']"));
    //Локатор Емаил импута
    private final SelenideElement inputAuthEmail =$(byXpath("//label[text()='Email']/following-sibling::input"));
    //локатор пароля
    private final SelenideElement inputAuthPassword =$(byXpath("//label[text()='Пароль']/following-sibling::input"));
    //локатор кнопки войти
    private final SelenideElement buttonAuthAccount = $(byXpath("//button[text()='Войти']"));

    public void buttonLogin() {
        buttonLogin.click();
    }
    public void buttonLoginOnThePageRegistrations() {
        buttonLoginOnThePageRegistrations.click();
    }
    public void buttonLoginOnThePageFrogPassword() {
        buttonLoginOnThePageFrogPassword.click();
    }
    public void inputAuthEmail(String email) {
        inputAuthEmail.setValue(email);
    }
    public void inputAuthPassword(String password) {
        inputAuthPassword.setValue(password);
    }
    public void buttonAuthAccount() {
        buttonAuthAccount.click();
    }
    public void authUser(UserModel user){
        inputAuthEmail(user.getEmail());
        inputAuthPassword(user.getPassword());
        buttonAuthAccount();
    }
}