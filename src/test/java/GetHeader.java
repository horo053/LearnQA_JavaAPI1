import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetHeader {
    @Test
    public void getHeader(){
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();
        String head = response.getHeader("x-secret-homework-header");
        System.out.println(head);
        assertEquals("Some secret value", head, "Не правильный header");
    }
}
