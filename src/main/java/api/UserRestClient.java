package api;

import constants.EndpointsConstant;
import models.UserModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.httpclient.HttpStatus;
// модель клиента для  обращения к апи и последующем использовании для удаления созданых нами пользователей
public class UserRestClient {

    public UserRestClient() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    }

    public String getAcceptToken(UserModel user) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(EndpointsConstant.LOGIN_USER_API)
                .then()
                .extract()
                .path("accessToken");
    }

    public void deleteByToken(String accessToken) {
        RestAssured
                .given()
                .when()
                .header("Authorization", accessToken)
                .delete(EndpointsConstant.USER_API)
                .then()
                .statusCode(HttpStatus.SC_ACCEPTED)
                .extract()
                .path("success");;
    }
}
