
import models.UserModel;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pages.AuthPage;
import pages.ExitUserPage;
import pages.HeaderPage;
import pages.RegisterPage;
import service.GeneratorUserService;
import service.UserApiService;
import static com.codeborne.selenide.Selenide.open;
import static constants.LinkConstants.AUTH_USER_URL;
import static constants.LinkConstants.REGISTER_URL;

public class LogOutAccountTest extends BeforeTest {
    RegisterPage registerPage;
    AuthPage authPage;
    GeneratorUserService generateUser;
    UserApiService userService;
    UserModel user;
    ExitUserPage exitUserPage;
    HeaderPage headerPage;

    public LogOutAccountTest() {
        generateUser = new GeneratorUserService();
        userService = new UserApiService();
        user = generateUser.getRandomUser();
        registerPage = new RegisterPage();
        authPage = new AuthPage();
        exitUserPage = new ExitUserPage();
        headerPage = new HeaderPage();
    }

    @Test
    @DisplayName("Выход из личного кабинета пользователя")
    public void transferAccountUser() {
        //Регистрируем пользователя
        open(REGISTER_URL);
        registerPage.registration(user);
        //Авторизуем пользователя
        open(AUTH_USER_URL);
        AuthPage authPage = new AuthPage();
        authPage.authUser(user);
        //Переходим в личный кабинет
        headerPage.buttonPersonalAccount();
        //Кликаем кнопку выход
        exitUserPage.buttonExit();
    }

    @After
    public void deleteUser() {
        // удаляем пользователя через API  чтобы не мусорить в базе
        userService.deleteUserByModelService(user);
    }
}
