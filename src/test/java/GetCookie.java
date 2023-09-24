import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCookie {
    @Test
    public void getCookie(){
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();
        String cook = response.getCookies().toString();
        assertEquals("{HomeWork=hw_value}", cook, "Не правильные cookie");
    }
}
