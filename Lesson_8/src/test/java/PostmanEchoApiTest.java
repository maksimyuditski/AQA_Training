import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для Postman Echo API")
public class PostmanEchoApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    // === ТЕСТЫ ДЛЯ GET МЕТОДА ===

    @Test
    @DisplayName("Тест GET запроса с параметрами foo1=bar1&foo2=bar2")
    public void testGetRequestWithParameters() {
        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .extract().response();

        // Проверка кода ответа (pm.response.to.have.status(200))
        assertEquals(200, response.getStatusCode(), "response is ok - код ответа должен быть 200");

        // Проверка тела ответа с параметрами запроса 
        // (pm.response.to.have.jsonBody('args.foo1', 'bar1'))
        assertEquals("bar1", response.jsonPath().getString("args.foo1"), 
                "response body has json with request queries - args.foo1 должен быть bar1");
        assertEquals("bar2", response.jsonPath().getString("args.foo2"), 
                "response body has json with request queries - args.foo2 должен быть bar2");
        
        // Дополнительные проверки структуры ответа
        assertNotNull(response.jsonPath().getString("args"), "Поле args должно присутствовать");
        assertNotNull(response.jsonPath().getString("headers"), "Поле headers должно присутствовать");
        assertNotNull(response.jsonPath().getString("url"), "Поле url должно присутствовать");
    }

    // === ТЕСТЫ ДЛЯ POST RAW TEXT ===

    @Test
    @DisplayName("Тест POST запроса с Raw Text данными")
    public void testPostRequestWithRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";
        
        Response response = given()
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .extract().response();

        // Проверка кода ответа (pm.response.to.have.status(200))
        assertEquals(200, response.getStatusCode(), "response is ok - код ответа должен быть 200");

        // Проверка тела ответа с данными запроса
        // (pm.response.to.have.jsonBody('data', 'This is expected to be sent back as part of response body.'))
        assertEquals(requestBody, response.jsonPath().getString("data"), 
                "response body has json with request body - data должна содержать отправленный текст");
        
        // Дополнительные проверки структуры ответа
        assertNotNull(response.jsonPath().getString("headers"), "Поле headers должно присутствовать");
        assertNotNull(response.jsonPath().getString("url"), "Поле url должно присутствовать");
        assertEquals("https://postman-echo.com/post", response.jsonPath().getString("url"), 
                "URL должен соответствовать эндпоинту");
    }

    // === ТЕСТЫ ДЛЯ POST FORM DATA ===

    @Test
    @DisplayName("Тест POST запроса с Form Data")
    public void testPostRequestWithFormData() {
        Response response = given()
                .contentType(ContentType.URLENC)
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .extract().response();

        // Проверка кода ответа (pm.response.to.have.status(200))
        assertEquals(200, response.getStatusCode(), "response is ok - код ответа должен быть 200");

        // Проверка тела ответа с form data
        // (pm.response.to.have.jsonBody('form.foo1', 'bar1'))
        assertEquals("bar1", response.jsonPath().getString("form.foo1"), 
                "response body has json with form data - form.foo1 должен быть bar1");
        assertEquals("bar2", response.jsonPath().getString("form.foo2"), 
                "response body has json with form data - form.foo2 должен быть bar2");
        
        // Дополнительные проверки структуры ответа
        assertNotNull(response.jsonPath().getString("form"), "Поле form должно присутствовать");
        assertNotNull(response.jsonPath().getString("headers"), "Поле headers должно присутствовать");
        assertEquals("https://postman-echo.com/post", response.jsonPath().getString("url"), 
                "URL должен соответствовать эндпоинту");
    }

    // === ТЕСТЫ ДЛЯ PUT ЗАПРОСА ===

    @Test
    @DisplayName("Тест PUT запроса")
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .extract().response();

        // Проверка кода ответа (pm.response.to.have.status(200))
        assertEquals(200, response.getStatusCode(), "response is ok - код ответа должен быть 200");

        // Проверка тела ответа с данными запроса
        // (pm.response.to.have.jsonBody('data', 'This is expected to be sent back as part of response body.'))
        assertEquals(requestBody, response.jsonPath().getString("data"), 
                "response body has json with form data - data должна содержать отправленный текст");
        
        // Дополнительные проверки структуры ответа
        assertNotNull(response.jsonPath().getString("headers"), "Поле headers должно присутствовать");
        assertEquals("https://postman-echo.com/put", response.jsonPath().getString("url"), 
                "URL должен соответствовать эндпоинту PUT");
    }

    // === ТЕСТЫ ДЛЯ PATCH ЗАПРОСА ===

    @Test
    @DisplayName("Тест PATCH запроса")
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .extract().response();

        // Проверка кода ответа (pm.response.to.have.status(200))
        assertEquals(200, response.getStatusCode(), "response is ok - код ответа должен быть 200");

        // Проверка тела ответа с данными запроса
        // (pm.response.to.have.jsonBody('data', 'This is expected to be sent back as part of response body.'))
        assertEquals(requestBody, response.jsonPath().getString("data"), 
                "response body has json with form data - data должна содержать отправленный текст");
        
        // Дополнительные проверки структуры ответа
        assertNotNull(response.jsonPath().getString("headers"), "Поле headers должно присутствовать");
        assertEquals("https://postman-echo.com/patch", response.jsonPath().getString("url"), 
                "URL должен соответствовать эндпоинту PATCH");
    }

    // === ТЕСТЫ ДЛЯ DELETE ЗАПРОСА ===

    @Test
    @DisplayName("Тест DELETE запроса")
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .extract().response();

        // Проверка кода ответа (pm.response.to.have.status(200))
        assertEquals(200, response.getStatusCode(), "response is ok - код ответа должен быть 200");

        // Проверка тела ответа с данными запроса
        // (pm.response.to.have.jsonBody('data', 'This is expected to be sent back as part of response body.'))
        assertEquals(requestBody, response.jsonPath().getString("data"), 
                "response body has json with form data - data должна содержать отправленный текст");
        
        // Дополнительные проверки структуры ответа
        assertNotNull(response.jsonPath().getString("headers"), "Поле headers должно присутствовать");
        assertEquals("https://postman-echo.com/delete", response.jsonPath().getString("url"), 
                "URL должен соответствовать эндпоинту DELETE");
    }

    // === ДОПОЛНИТЕЛЬНЫЕ ТЕСТЫ ДЛЯ УЛУЧШЕННОГО ПОКРЫТИЯ ===

    @Test
    @DisplayName("Тест GET запроса без параметров")
    public void testGetRequestWithoutParameters() {
        Response response = given()
                .when()
                .get("/get")
                .then()
                .extract().response();

        // Проверка кода ответа
        assertEquals(200, response.getStatusCode(), "response is ok - код ответа должен быть 200");
        
        // Проверка структуры ответа без параметров
        assertEquals("https://postman-echo.com/get", response.jsonPath().getString("url"), 
                "URL должен быть без параметров");
        assertNotNull(response.jsonPath().getString("headers"), "Поле headers должно присутствовать");
    }

    @Test
    @DisplayName("Тест POST запроса с пустым телом")
    public void testPostRequestWithEmptyBody() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .post("/post")
                .then()
                .extract().response();

        // Проверка кода ответа
        assertEquals(200, response.getStatusCode(), "response is ok - код ответа должен быть 200");
        assertEquals("https://postman-echo.com/post", response.jsonPath().getString("url"), 
                "URL должен соответствовать эндпоинту POST");
        assertNotNull(response.jsonPath().getString("headers"), "Поле headers должно присутствовать");
    }

    @Test
    @DisplayName("Тест POST с JSON данными")
    public void testPostRequestWithJsonData() {
        String jsonBody = "{\n" +
                "  \"message\": \"This is expected to be sent back as part of response body.\",\n" +
                "  \"timestamp\": \"" + System.currentTimeMillis() + "\"\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("/post")
                .then()
                .extract().response();

        // Проверка кода ответа
        assertEquals(200, response.getStatusCode(), "response is ok - код ответа должен быть 200");
        
        // Проверка JSON данных в ответе
        assertNotNull(response.jsonPath().getString("json"), "Поле json должно присутствовать");
        assertNotNull(response.jsonPath().getString("data"), "Поле data должно присутствовать");
        assertEquals("https://postman-echo.com/post", response.jsonPath().getString("url"), 
                "URL должен соответствовать эндпоинту POST");
    }
}