import models.UserModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pages.AuthPage;
import pages.HeaderPage;
import pages.RegisterPage;
import service.GeneratorUserService;
import service.UserApiService;
import static com.codeborne.selenide.Selenide.open;
import static constants.LinkConstants.*;

public class TransitionToConstructorTest {
    RegisterPage registerPage;
    AuthPage authPage;
    GeneratorUserService generateUser;
    UserApiService userService;
    UserModel user;
    HeaderPage headerPage;

    public TransitionToConstructorTest() {
        generateUser = new GeneratorUserService();
        userService = new UserApiService();
        user = generateUser.getRandomUser();
        registerPage = new RegisterPage();
        authPage = new AuthPage();
        headerPage = new HeaderPage();
    }

    @Test
    @DisplayName("Переход в конструктор по кнопке «Конструктор» из личного кабинета")
    public void transferAccountUserToConstructor() {
        //Регистрируем пользователя
        open(REGISTER_URL);
        registerPage.registration(user);
        //Авторизуем пользователя
        open(AUTH_USER_URL);
        AuthPage authPage = new AuthPage();
        authPage.authUser(user);
        //Переходим в личный кабинет
        headerPage.buttonPersonalAccount();
        //Кликаем на кнопку «Конструктор»
        headerPage.buttonConstructor();
        //Проверяем что открылся конструктор и на странице есть заголовок "Соберите бургер"
        Assert.assertEquals("Соберите бургер", headerPage.getTextConstructorPage());
    }

    @Test
    @DisplayName("Переход в конструктор по клику на логотип «Stellar Burgers» из личного кабинета ")
    public void transferAccountUserToLogo() {
        //Регистрируем пользователя
        open(REGISTER_URL);
        registerPage.registration(user);
        //Авторизуем пользователя
        open(AUTH_USER_URL);
        AuthPage authPage = new AuthPage();
        authPage.authUser(user);
        //Переходим в личный кабинет
        headerPage.buttonPersonalAccount();
        //Кликаем на логотип «Stellar Burgers»
        headerPage.buttonLogo();
        //Проверяем что открылся конструктор и на странице есть заголовок "Соберите бургер"
        Assert.assertEquals("Соберите бургер", headerPage.getTextConstructorPage());
    }

    @After
    public void deleteUser() {
        // удаляем пользователя через API  чтобы не мусорить в базе
        userService.deleteUserByModelService(user);
    }
}
