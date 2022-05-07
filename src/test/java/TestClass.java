import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestClass {
    @Test
    public void testGet() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("555") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                // специализированные проверки — лучше
                .contentType(ContentType.JSON)
                .body("data", equalTo("555"))
        ;
    }
}

