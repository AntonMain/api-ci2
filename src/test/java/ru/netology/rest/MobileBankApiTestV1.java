package ru.netology.rest;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
      // Given - When - Then
      // Предусловия
      given()
          .baseUri("http://localhost:9999/api/v1")
      // Выполняемые действия
      .when()
          .get("/demo/accounts")
      // Проверки
      .then()
          .statusCode(200)
              .header("Content-Type", "application/json; charset=UTF-8")
              .contentType(ContentType.JSON)
              .body("",hasSize(3))
              .body("[2].currency", equalTo("RUB"))
              //.body("every { it.balance >= 0 }", is(true))
              //.body(matchesJsonShemaInClasspath("accounts.schema.json"))
        ;

    }
}
