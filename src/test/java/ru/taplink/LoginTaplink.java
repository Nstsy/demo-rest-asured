package ru.taplink;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTaplink {
    @Test
    public void test1() {
        given()
                .body(LoginRequestTaplink.getBody("111@gmail.com", "111222"))
                .header("Content-Type", "application/json")
                .when()
                .post(LoginRequestTaplink.URL)
                .then()
                .log().all()
                .statusCode(200)
                .body("result", equalTo("fail"))
                .body("message", equalTo("Неверная почта или пароль"));
    }

    @Test
    public void test2() {
        given()
                .body(LoginRequestTaplink.getBody("", ""))
                .header("Content-Type", "application/json")
                .when()
                .post(LoginRequestTaplink.URL)
                .then()
                .log().all()
                .statusCode(200)
                .body("result", equalTo("fail"))
                .body("message", equalTo("Неверная почта или пароль"));
    }

    @Test
    public void test3() {
        given()
                .body(LoginRequestTaplink.getBody("111@gmail.com", ""))
                .header("Content-Type", "application/json")
                .when()
                .post(LoginRequestTaplink.URL)
                .then()
                .log().all()
                .statusCode(200)
                .body("result", equalTo("fail"))
                .body("message", equalTo("Неверная почта или пароль"));
    }

    @Test
    public void test4() {
        given()
                .body(LoginRequestTaplink.getBody("", "111222"))
                .header("Content-Type", "application/json")
                .when()
                .post(LoginRequestTaplink.URL)
                .then()
                .log().all()
                .statusCode(200)
                .body("result", equalTo("fail"))
                .body("message", equalTo("Неверная почта или пароль"));
    }

    @Test
    public void test5() {
        given()
                .body("{ \"email\": \"nstsy@gmail.com\", \"password\": \"gooETU1\", \"twofactor\": \"\" }")
                .header("Content-Type", "application/json")
                .when()
                .post(LoginRequestTaplink.URL)
                .then()
                .log().all()
                .statusCode(200)
                .body("result", equalTo("fail"))
                .body("message", equalTo("Неверная почта или пароль"));
    }

    @Test
    public void test6() {
        given()
                .body("{ \"email\": \"nstsy@gmail.com\", \"password\": \"gooETU1\"}")
                .header("Content-Type", "application/json")
                .when()
                .post(LoginRequestTaplink.URL)
                .then()
                .log().all()
                .statusCode(200);
    }
}