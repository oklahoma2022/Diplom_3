package service;

import api.UserRestClient;
import models.UserModel;

public class UserApiService {
// Делайм сервис для обращения к АПИ на удаление пользователя ,чтобы не мусорить в базе
    UserRestClient userClient;

    public UserApiService() {
        userClient = new UserRestClient();
    }
    public void deleteUserByModelService(UserModel user) {
        String accessToken = userClient.getAcceptToken(user);
        if (accessToken != null) {
            userClient.deleteByToken(accessToken);
        }
    }

}
