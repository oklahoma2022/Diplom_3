package service;

import com.github.javafaker.Faker;
import models.UserModel;

//Подлючили фейкера, чтобы данные которые будем использовать были всегда  новые и актуальные
public class GeneratorUserService {
        Faker faker;
        public GeneratorUserService() {
            faker = new Faker();
        }

        public UserModel getRandomUser() {
            return new UserModel(
                    faker.internet().emailAddress(),
                    faker.internet().password(),
                    faker.name().name()
            );
        }
}
