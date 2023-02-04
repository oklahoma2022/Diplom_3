import models.UserModel;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pages.AuthPage;
import pages.HeaderPage;
import pages.RegisterPage;
import service.GeneratorUserService;
import service.UserApiService;
import static com.codeborne.selenide.Selenide.open;
import static constants.LinkConstants.*;

public class AuthUserTest  {
    RegisterPage registerPage;
    GeneratorUserService generateUser;
    UserApiService userService;
    UserModel user;
    HeaderPage headerPage;
    public AuthUserTest() {
        generateUser = new GeneratorUserService();
        userService = new UserApiService();
        user = generateUser.getRandomUser();
        registerPage = new RegisterPage();
        headerPage = new HeaderPage();
    }

    @Test
    @DisplayName("Авторизация пользователя через кнопку  «Войти в аккаунт» на главной")
    public void authLoginInAccountTest() {
        //Открываем страницу регистрации  и регистрируем нового пользователя  для проверок
        open(REGISTER_URL);
        registerPage.registration(user);

        open(MAIN_PAGE_URL);
        AuthPage authPage = new AuthPage();
        authPage.buttonLogin();
        authPage.authUser(user);
    }

    @Test
    @DisplayName("Авторизация пользователя через кнопку «Личный кабинет»")
    public void authToAccountUserTest() {
        //Открываем страницу регистрации  и регистрируем нового пользователя  для проверок
        open(REGISTER_URL);
        registerPage.registration(user);

        AuthPage authPage = new AuthPage();
        headerPage.buttonPersonalAccount();
        authPage.authUser(user);

    }

    @Test
    @DisplayName("Авторизация пользователя через кнопку в форме регистрации")
    public void authToRegisterPageTest() {
        open(REGISTER_URL);
        registerPage.registration(user);

        open(REGISTER_URL);
        AuthPage authPage = new AuthPage();
        authPage.buttonLoginOnThePageRegistrations();
        authPage.authUser(user);
    }

    @Test
    @DisplayName("Авторизация пользователя  через кнопку в форме восстановления пароля.")
    public void  authToFrogPasswordTest() {  open(REGISTER_URL);
        registerPage.registration(user);

        open(FROG_PASSWORD_URL);
        AuthPage authPage = new AuthPage();
        authPage.buttonLoginOnThePageFrogPassword();
        authPage.authUser(user);

    }

    @After
    public void deleteUser() {
        // удаляем пользователя через API  чтобы не мусорить в базе
        userService.deleteUserByModelService(user);
    }

}
