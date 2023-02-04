import io.qameta.allure.Step;
import models.UserModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pages.RegisterPage;
import service.GeneratorUserService;
import service.UserApiService;
import static constants.LinkConstants.REGISTER_URL;
import static com.codeborne.selenide.Selenide.*;

public class RegisterUserTest{
    GeneratorUserService generateUser;
    UserApiService userService;
    UserModel user;

    public RegisterUserTest() {
        generateUser = new GeneratorUserService();
        userService = new UserApiService();
        user = generateUser.getRandomUser();
    }

    @Test
    @Step("Успешная регистрация пользователя")
    public void registerTest() {
        open(REGISTER_URL);
        RegisterPage registerPage = new RegisterPage();
        registerPage.registration(user);
        Assert.assertEquals("Вход", registerPage.getTextAuthPage());
    }

    @Test
    @Step("Ошибка для некорректного пароля.Пароль 5 символов")
    public void registrationIncorrectPasswordTest() {
        open(REGISTER_URL);
        RegisterPage registerPage = new RegisterPage();
        user.setPassword("12345");
        registerPage.registration(user);
        Assert.assertEquals("Некорректный пароль", registerPage.getErrorMessagePassword());
    }

    @After
    public void deleteUser() {
        // удаляем пользователя через API  чтобы не мусорить в базе
        userService.deleteUserByModelService(user);
    }
}
